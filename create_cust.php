<?php
include "menu.php";
include "DB_conn.php";

function form()
{
    print '<form method="post" action = "">
    username: <input type="text" name="username_"><br>
    password: <input type="text" name="password_"><br>
    repassword: <input type="text" name="repassword_"><br>
    <input type="submit" name="submit">
    </form>';
}

form();

if(isset($_POST['submit']))
{
    $username_ = $_POST['username_'];
    $password_ = $_POST['password_'];
    $repassword_ = $_POST['repassword_'];
    $permission_ = "1"; // this will be like a register page for new customers, there for is hard coded as 1.

     // checking if the input fields are empty if they are when submiting this code block will not be ececuted.
    if (strlen($username_) != 0 && strlen($password_) != 0 && strlen($repassword_) != 0)
    {
            // create sql to insert the user data, inc hashed password into db
        if ($password_ == $repassword_){
            $password_ = encrypt($password_);
            $sql_ = "INSERT INTO usertb (username, password, permission) VALUES ('$username_','$password_','$permission_')";
        }
        else{
            echo "password are not the same";
        }

        if ($conn->query($sql_) === TRUE) 
        {
            echo "New record created successfully";
        }
        else 
        {
            echo "Error: " . $sql_ . "<br>" . $conn->error;
        }
    }
    else
    {
        echo "you havent filled out all fields";
    }
     
}
else
{
    echo "ingen post!";
}

// return the hashed password
function encrypt ($clear_text)
{
    return password_hash($clear_text, PASSWORD_DEFAULT);
}

?>