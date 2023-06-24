<?php
$conn=mysqli_connect("localhost","root","");
mysqli_select_db($conn,"apidb");

    $first_name=trim($_POST['first_name']);
    $last_name=trim($_POST['last_name']);
    $phone=trim($_POST['phone']);
    $email=trim($_POST['email']);
    $password=trim($_POST['password']);
    
    $qry1="select* from tbl_user where email='$email'";
    $raw=mysqli_query($conn,$qry1);
    $count=mysqli_num_rows($raw);

    if($count>0){
        $response="exist";
    }
    else{
        $qry2="INSERT INTO `tbl_user` (`id`, `first_name`, `last_name`, `phone`, `email`, `password`,`address`) VALUES (NULL, '$first_name', '$last_name', '$phone','$email', '$password','');";
        $res=mysqli_query($conn,$qry2);
        if($res==true){
            $response="inserted";
        }
        else{
            $response="failed";
        }
    }

    echo $response;
    
?>