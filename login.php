<?php
$conn=mysqli_connect("localhost","root","");
mysqli_select_db($conn,"apidb");


$email=$_POST['email'];
$password=$_POST['password'];

$qry = "SELECT * FROM `tbl_user` WHERE email='$email' and password='$password';";
$result = mysqli_query($conn, $qry);
$count = mysqli_num_rows($result);

if ($count==0) {
    
    $response = "not a registered user";
    
} else {

    $response = "success";
}

echo $response;
?>