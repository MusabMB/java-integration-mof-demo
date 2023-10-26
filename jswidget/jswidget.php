<?php
error_reporting(E_NOTICE);
include_once('arbpg.php');


$ARB_PAYMENT_ENDPOINT_PRODUCTION = 'https://digitalpayments.alrajhibank.com.sa/pg/payment/hosted.htm';
$arbPg = new ArbPg();
$paymentId = $arbPg->PaymentId(700202329772925873);

echo 700202329772925873;

?>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script type="text/javascript">

        // const reqBody= {
        //     "contextPath": "https://digitalpayments.alrajhibank.com.sa/pg", //Fixed Value
        //     "paymentId": <?php echo(json_encode(700202329772925873)); ?>,
        //     "merchantResponseURL": "http://localhost:8000/result.php"
        // }
const reqBody= {
            "contextPath": <?php echo(json_encode($arbPg->context_path)); ?>, //Fixed Value
            "paymentId": <?php echo(json_encode($paymentId)); ?>,
            "merchantResponseURL": "http://localhost:8000/result.php"
        }

 </script>
<!-- <style id="neogateTheme">
#neogate_checkout {
  --neo-radius:  16px;
  --neo-radius-small:  7px;
  --neo-bg: #ffffff;
  --neo-text:  #1a1a1a;
  --neo-gray:  #6a6a6a;
  --neo-border-color:  #e5e5e5;
  --neo-font:  "Poppins", sans-serif;
  --neo-fontsize:  14px;
  --neo-primary-color: #11a26a;
  --neo-button-border:  0px;
  --neo-shadow:-4px 5px 7px 11px rgba(0, 0, 0, 0.1);
    }

</style> -->

</head>
<body>
<div class="container">

 <div id="payment-widget-container" class="payment-widget-container"></div>
    </div> 
      
  
<div>


<script src=  <?php echo(json_encode($arbPg->functionURL)); ?> > </script>
<script src=  <?php echo(json_encode($arbPg->tomselectURL)); ?> >  </script>
<script type="text/javascript">payload();</script>


</body>
</html>

