<?php
$conn=mysqli_connect("localhost","root","");
mysqli_select_db($conn,"apidb");

    $old_email=trim($_POST['old_email']);
    $phone=trim($_POST['phone']);
    $email=trim($_POST['email']);
    $address=trim($_POST['address']);
    
    $qry1="update tbl_user set phone='$phone',email='$email',address='$address' where email='$old_email'";

    $res=mysqli_query($conn,$qry1);
    // $count=mysqli_num_rows($res);

        if($res==true){
            $response="updated";
        }
        else{
            $response="failed";
        }
    
    echo $response;
    
?>