<?php
include "menuCRUD_admin.php";
include "db_conn.php";
include "user_perm.php";

function form ()
{
    print '<form method="post" action = "">
    username: <input type="text" name="username_"><br>
    password: <input type="text" name="password_"><br>
    <input type="submit" name="submit">
    </form>';
}

form();

if(isset($_POST['submit']))
{
    $username = $_POST['username_'];
    $password = $_POST['password_'];
    
    $sql = "SELECT permission FROM usertb WHERE userid = '$userid_'"; // accesing the permission level of the user by userid.
    $result = $conn->query($sql);

    if ($result->num_rows == 1) 
    {
        while($row = $result->fetch_assoc()) 
        {
            $permission = $row["permission"];
        }
    }        

    if ($permission == 2 || $permission == 1) // Checking the users authority
    {
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
                    } 
                    else 
                    {
                        echo "something is wrong...."; // something did not go right
                    }
                }
            }
        }  
    }
    else
    {
        echo "You dont have permission to this function"; // you where denied acces if this messages shows
    }    
}

function encrypt ($clear_text)
{
    return password_hash($clear_text, PASSWORD_DEFAULT);
}

?>