<?php

$conn = mysqli_connect("localhost", "root", "");
mysqli_select_db($conn, "apidb");

$email = trim($_POST['email']);
$qry = "SELECT first_name,last_name,phone,email,address FROM `tbl_user` WHERE email='$email';";

$raw=mysqli_query($conn,$qry);

while($res=mysqli_fetch_array($raw)){
    $data[]=$res;
}
print(json_encode($data));



?>