<?php

include_once('arbpg.php');

$arbPg = new ArbPg();
$message = "";
if(isset($_POST['SubmitButton'])){ //check if form was submitted
  $transactionid = $_POST['transactionid']; //get input text
$amount= $_POST['amount'];

  $result = $arbPg->void($transactionid, $amount);
  $message = "Success! You entered: ". json_encode($result);
  echo $message . "<br/>";
}  


?>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    

</head>
<body>
<div class="container">

<div class="row">

<form action="refund.php" method="post">
  <div class="form-group">
    <label for="transactionid">Transaction ID to be Voided </label>
    <input type="text" class="form-control" id="transactionid" name="transactionid" placeholder="Enter transaction id">

  </div>
  <div class="form-group">
    <label for="amount">Amount To be Voided</label>
    <input type="text" class="form-control" id="amount" name="amount" placeholder="Enter amount">
  </div>
  
  <button type="submit"  name="SubmitButton" class="btn btn-primary">Submit</button>

</form>
</div>

<div>
        <a href="index.php">home</a>
    </div>
</div>


</body>
</html>