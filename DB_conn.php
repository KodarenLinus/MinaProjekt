<?php
$servername = "localhost";
$username = "Linus";
$password = "Linus";
$db = "golf e-handel";

//create connection
$conn = mysqli_connect($servername, $username, $password, $db);
if(!$conn) 
{
    die("connection failed: " . mysqli_connect_error());
}
?>