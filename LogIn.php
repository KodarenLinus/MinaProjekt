<?php
include "menu.php";
include "DB_conn.php";

session_start();

function form()
{
  print '<form method="post" action = "">
  username: <input type="text" name="username_"><br>
  password: <input type="text" name="password_"><br>
  <input type="submit" name="login">
  </form>';

}

form();

if(isset($_POST['login']))
{
    //Using $conn -> real_escape_string so that the data is getting cleaned when sendt to the database
    $username = $conn -> real_escape_string($_POST['username_']); 
    $password = $conn -> real_escape_string($_POST['password_']);

    // fetch hashed pwd from db
    $sql = "SELECT password, userid FROM userTB WHERE username = '$username'";
    $result = $conn->query($sql);

    // check that we found exactly one user
    if ($result->num_rows == 1) {
      while($row = $result->fetch_assoc()) {
        $password_hashed = $row["password"];
        $userid = $row['userid'];
      }
    } 
    else 
    {
      echo "not exactly 1 result, something is wrong....";
      exit; //exit code here, you entered a username that do not exit, therefore we cant match any password with the database, because the user do not exsist
    }

    // check if passwords match
    if(password_verify($password, $password_hashed)) 
    {
      echo "passwords match!";
        
      // add username and id to session
      $_SESSION['user'] = $username;
      $_SESSION['userid'] = $userid;
        
      // checking wich page they will be sendt to
      $sql__ = "SELECT permission FROM usertb WHERE userid = '$userid'";

      $result__ = $conn->query($sql__);

      if ($result__->num_rows == 1) 
      {
        while($row = $result__->fetch_assoc()) 
        {
          $permission = $row["permission"];
        }
      } 
      else 
      {
        echo "not exactly 1 result, something is wrong....";
      }

      if($permission == 2 || $permission == 3) 
      {
        header("Location: home_admin.php");
        exit;
      }
      else if ($permission == 1)
      {
        header("Location: home_kund.php");
        exit;
      }
      else
      {
        echo "something went wrong";
      }

    }
    else
    {
        echo "passwords don't match";
    }
   
}
function encrypt ($clear_text)
{
    return password_hash($clear_text, PASSWORD_DEFAULT);
}


// if no user logged in, redirect to login page and abort execution of this page
if(!array_key_exists('user', $_SESSION)) 
{
  echo "You must login before you can use this site. If you have no login, goto create_user to register.";
}
else
{
  //echo "Logged in as ".$_SESSION['user']; // Really only used this for debugging
}

?>