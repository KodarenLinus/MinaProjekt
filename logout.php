<?php
// this is just for logging out, and our log out is removing session data therfore we don need a db connetion
session_destroy();
header("Location: LogIn.php"); 
exit;

?>