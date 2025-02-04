<?php
include "menuCRUD.php";
include "DB_conn.php";
include "user_perm_kund.php";

function form ()
{
    print '<form method="post" action = "">
    password: <input type="text" name="password_"><br>
    <input type="submit" name="submit">
    </form>';
}

form();

if(isset($_POST['submit']))
{
    $sql_ = "SELECT username FROM usertb WHERE userid = '$userid_'"; // accesing the username level of the user by userid.
    $result_ = $conn->query($sql_);

    if ($result_->num_rows == 1) 
    {
        while($row = $result_->fetch_assoc()) 
        {
            $username = $row["username"]; // you can only delet the user you are loged in to
        }
    }        

    $password = $_POST['password_'];
    $sql_1 = "SELECT password from usertb WHERE username = '$username'"; // getting a password from database
    $result_1 = $conn->query($sql_1);
    if ($result_1->num_rows == 1) 
    {
        //get enc password from db
        while($row = $result_1->fetch_assoc()) 
        {
            $password_hashed = $row["password"];
            if(password_verify($password, $password_hashed)) // making sure that i entered correct password
            {
                $sql_2 = "DELETE FROM usertb WHERE username = '$username'"; // deleting the desired user 
                
                $result_2 = $conn->query($sql_2);
                if ($result_2 == true) 
                {
                    echo "succes: ".$conn->affected_rows." rows deleted"; // succes shows only when we deleted a user
                    header("Location: logout.php"); // We deleting the user thats logged in so i wise to log it out. otherwise we can run in some problem with the database.
                    exit;
                } 
                else 
                {
                    echo "something is wrong...."; // something did not go right
                }
            }
        }
    }    
}

function encrypt ($clear_text)
{
    return password_hash($clear_text, PASSWORD_DEFAULT);
}

?>