<?php
include_once('arbpg.php');

//$ARB_HOSTED_ENDPOINT_TESTING = 'https://securepayments.alrajhibank.com.sa/pg/payment/hosted.htm';
$ARB_PAYMENT_ENDPOINT_TESTING = 'https://securepayments.alrajhibank.com.sa/pg/paymentpage.htm?PaymentID=';

//$ARB_HOSTED_ENDPOINT_PRODUCTION = 'https://digitalpayments.alrajhibank.com.sa/pg/payment/tranportal.htm';
$ARB_PAYMENT_ENDPOINT_PRODUCTION = 'https://digitalpayments.alrajhibank.com.sa/pg/paymentpage.htm?PaymentID=700202329772925873';
echo " ARB PG Payment";

$arbPg = new ArbPg();

$arbPg->test();

$paymentId = $arbPg->getPaymentId(700202329772925873);

echo $arbPg->redirect_url;

$url= $arbPg->redirect_url . $paymentId; //in Production use Production End Point


header("Location: $url");