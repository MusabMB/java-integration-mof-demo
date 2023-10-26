<?php
include_once('config.php');
class ArbPg{



    public $config;
    public $redirect_url;
    public $context_path;
    public $functionURL;
    public $tomselectURL;

    public function __construct() {
       $this->config = parse_ini_file('config.ini', true);
        $this->redirect_url = $this->config['redirect_url'];
        $this->context_path = $this->config['CONTEXTPATH'];
        $this->functionURL = $this->config['functionURL'];
        $this->tomselectURL = $this->config['tomselectURL'];
    }

public function test(){
    echo "working";
}

//admin@hussamadin.comfs


public function void($transactionid, $amount){
    $trackId = (string)rand(1, 1000000); 

    $data = [
        "id" => $this->config['Tranportal_ID'],
        "password" => $this->config['Tranportal_Password'],
        "action" => "3",
        "currencyCode" => "682",
        "trackId" => $trackId,
        "amt" => $amount,
        "udf5"=>"TRANID",
        "transId"=>$transactionid,
        ];

    $data = json_encode($data, JSON_UNESCAPED_SLASHES);

    $wrappedData = $this->wrapData($data);

    $aes_cbc_alg="aes-256-cbc";

    $encData = [
        "id" => $this->config['Tranportal_ID'],
        "trandata" => $this->aesEncrypt($wrappedData,$this->config['resource_key'],$aes_cbc_alg),
    ];
    
    $wrappedData = $this->wrapData(json_encode($encData, JSON_UNESCAPED_SLASHES));


    $curl = curl_init();

    curl_setopt_array($curl, array(
        CURLOPT_URL => $this->config['ARB_MERCHANT_HOSTED_ENDPOINT'],
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_ENCODING => '',
        CURLOPT_MAXREDIRS => 10,
        CURLOPT_TIMEOUT => 0,
        CURLOPT_FOLLOWLOCATION => true,
        CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
        CURLOPT_CUSTOMREQUEST => 'POST',
        CURLOPT_POSTFIELDS => $wrappedData,

        CURLOPT_HTTPHEADER => array(
            'Accept: application/json',
            'Accept-Language: application/json',
            'Content-Type: application/json',
        ),
    ));

    $response = curl_exec($curl);
    //print_r($response);
     curl_close($curl);
     $data = json_decode($response, true)[0];
    $result = $this->getResult($data['trandata']);
    return $result;
}

public function refund($transactionid, $amount){
    $trackId = (string)rand(1, 1000000); 

    $data = [
        "id" => $this->config['Tranportal_ID'],
        "password" => $this->config['Tranportal_Password'],
        "action" => "2",
        "currencyCode" => "682",
        "trackId" => $trackId,
        "amt" => $amount,
        "udf5"=>"TRANID",
        "transId"=>$transactionid,
        ];

    $data = json_encode($data, JSON_UNESCAPED_SLASHES);

    $wrappedData = $this->wrapData($data);

    $aes_cbc_alg="aes-256-cbc";

    $encData = [
        "id" => $this->config['Tranportal_ID'],
        "trandata" => $this->aesEncrypt($wrappedData,$this->config['resource_key'],$aes_cbc_alg),
    ];
    
    $wrappedData = $this->wrapData(json_encode($encData, JSON_UNESCAPED_SLASHES));


    $curl = curl_init();

    curl_setopt_array($curl, array(
        CURLOPT_URL => $this->config['ARB_MERCHANT_HOSTED_ENDPOINT'],
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_ENCODING => '',
        CURLOPT_MAXREDIRS => 10,
        CURLOPT_TIMEOUT => 0,
        CURLOPT_FOLLOWLOCATION => true,
        CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
        CURLOPT_CUSTOMREQUEST => 'POST',
        CURLOPT_POSTFIELDS => $wrappedData,

        CURLOPT_HTTPHEADER => array(
            'Accept: application/json',
            'Accept-Language: application/json',
            'Content-Type: application/json',
        ),
    ));

    $response = curl_exec($curl);
    //print_r($response);
     curl_close($curl);
     $data = json_decode($response, true)[0];
    $result = $this->getResult($data['trandata']);
    return $result;
}


public function getPaymentId()
{

    $plainData = $this->getRequestData();
 
    $wrappedData = $this->wrapData($plainData);



    //var_dump($wrappedData);
    $aes_cbc_alg="aes-256-cbc";
    $encData = [
        "id" => $this->config['Tranportal_ID'],
        "trandata" => $this->aesEncrypt($wrappedData,$this->config['resource_key'],$aes_cbc_alg),
        "errorURL" => "http://localhost:8000/result.php",
        "responseURL" => "http://localhost:8000/result.php",
    ];
    
    $wrappedData = $this->wrapData(json_encode($encData, JSON_UNESCAPED_SLASHES));
    //var_dump($wrappedData);
    $curl = curl_init();

    curl_setopt_array($curl, array(
        CURLOPT_URL => $this->config['ARB_Bank_HOSTED_ENDPOINT_PRODUCTION'],
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_ENCODING => '',
        CURLOPT_MAXREDIRS => 10,
        CURLOPT_TIMEOUT => 0,
        CURLOPT_FOLLOWLOCATION => true,
        CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
        CURLOPT_CUSTOMREQUEST => 'POST',
        CURLOPT_POSTFIELDS => $wrappedData,

        CURLOPT_HTTPHEADER => array(
            'Accept: application/json',
            'Accept-Language: application/json',
            'Content-Type: application/json',
        ),
    ));

    $response = curl_exec($curl);
   // print_r($response);
    curl_close($curl);
    
    // parse response and get id
   $data = json_decode($response, true)[0];
// var_dump($response);
 // exit();
    if ($data["status"] == "1") {
        $id = explode(":", $data["result"])[0];
        return $id;
    } else if(!$data["trandata"]) {
        // handle error either refresh on contact merchant
        return -1;
    }
}


public function getResult($trandata)
    {

       // var_dump($trandata);
        $decrypted = $this->aesDecrypt($trandata);
        $raw = urldecode($decrypted);
        $dataArr = json_decode($raw, true);
       //var_dump($dataArr);
    
        $paymentStatus = $dataArr;
        return  $paymentStatus;
    

    }

    private function getRequestData()
    {

       // $this->load->model('checkout/order');

       $amount = $trackId = (string)rand(1, 500); 
        
        $trackId = (string)rand(1, 1000000); // TODO: Change to real value
        
        $data = [
            "id" => $this->config['Tranportal_ID'],
            "password" => $this->config['Tranportal_Password'],
            "action" => "1",
            "currencyCode" => "682",
            "errorURL" => "http://localhost:8000/result.php",
            "responseURL" => "http://localhost:8000/result.php",
            "trackId" => $trackId,
            "amt" => $amount,
          
            ];

        $data = json_encode($data, JSON_UNESCAPED_SLASHES);
     //    var_dump($data);
     //  exit();
        return $data;
    }

    

    private function wrapData($data)
    {
        $data = <<<EOT
[$data]
EOT;
        return $data;
    }

    private function aesEncrypt($plainData, $key, $aes_cbc_alg)
    {
       // $key = self::resource_key;
        $iv = "PGKEYENCDECIVSPC";
        $str = $this->pkcs5_pad($plainData);
        $encrypted = openssl_encrypt($str, $aes_cbc_alg, $key, OPENSSL_ZERO_PADDING, $iv);
        $encrypted = base64_decode($encrypted);
        $encrypted = unpack('C*', ($encrypted));
        $encrypted = $this->byteArray2Hex($encrypted);
        $encrypted = urlencode($encrypted);
        //var_dump($encrypted);
        return $encrypted;
    }

    private function pkcs5_pad($text, $blocksize = 16)
    {
        $pad = $blocksize - (strlen($text) % $blocksize);
        return $text . str_repeat(chr($pad), $pad);
    }

    private function byteArray2Hex($byteArray)
    {
        $chars = array_map("chr", $byteArray);
        $bin = join($chars);
        return bin2hex($bin);
    }

    private function aesDecrypt($code)
    {  
       // var_dump($code);
        $code = $this->hex2ByteArray(trim($code));
        $code = $this->byteArray2String($code);
        $iv = "PGKEYENCDECIVSPC";
        $key = $this->config['resource_key'];
        $code = base64_encode($code);
        $decrypted = openssl_decrypt($code, 'AES-256-CBC', $key, OPENSSL_ZERO_PADDING,
            $iv);
            
        return $this->pkcs5_unpad($decrypted);
    }

    private function pkcs5_unpad($text)
    {
        $pad = ord($text[strlen($text) - 1]);
        if ($pad > strlen($text)) return false;
        if (strspn($text, chr($pad), strlen($text) - $pad) != $pad) return false;
        return substr($text, 0, -1 * $pad);
    }

    private function hex2ByteArray($hexString)
    {
        $string = hex2bin($hexString);
        return unpack('C*', $string);
    }

    private function byteArray2String($byteArray)
    {
        $chars = array_map("chr", $byteArray);
        return join($chars);
    }
}