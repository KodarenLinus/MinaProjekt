<?php
include "menuCRUD_admin.php";
include "DB_conn.php";
include "user_perm.php";
function form()
{
    print '<form method="post" action = "">
    username: <input type="text" name="username_"><br>
    password: <input type="text" name="password_"><br>
    repassword: <input type="text" name="repassword_"><br>
    permission<br> (adm = 1, staff = 2, cust = 3: <input type="text" name="permission_"><br>
    <input type="submit" name="submit">
    </form>';
}
if(!$conn) {
    die("connection failed: " . mysqli_connect_error());
}
echo "Connected successfully";
form();

if(isset($_POST['submit']))
{
    $username_ = $_POST['username_'];
    $password_ = $_POST['password_'];
    $repassword_ = $_POST['repassword_'];
    $permission_ = $_POST['permission_'];

    // checking if the input fields are empty if they are when submiting this code block will not be ececuted.
    if (strlen($username_) != 0 && strlen($password_) != 0 && strlen($repassword_) != 0 && strlen($permission_))
    {
       // create sql to insert the user data, inc hashed password into db
       if ($password_ == $repassword_)
       {
            $password_ = encrypt($password_);
            $sql_ = "INSERT INTO usertb (username, password, permission) VALUES ('$username_','$password_','$permission_')";
        }
        else
        {
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
    

// return the hashed password
function encrypt ($clear_text)
{
    return password_hash($clear_text, PASSWORD_DEFAULT);
}

?>  