<?php
use LDAP\Result;
include "menuCRUD.php";
include "DB_conn.php";
include "user_perm_kund.php";

function form()
{
    print '<form method="post" action = "">
    password: <input type="text" name="password_"><br>
    new password: <input type="text" name="newPassword_"><br>
    <input type="submit" name="update">
    </form>';

}
form();

if(isset($_POST['update']))
{
    $password = $_POST['password_'];
    $newPassword = $_POST['newPassword_'];

    echo $password.'<br>';

    if ($newPassword != $password)
    {
        // get password from db
        $sql_1 = "SELECT password from usertb WHERE username = '$username'";
        $result_1 = $conn->query($sql_1);
        if ($result_1->num_rows == 1) 
        {
            //get enc password from db
            while($row = $result_1->fetch_assoc()) 
            {
                $password_hashed = $row["password"];
                if(password_verify($password, $password_hashed))
                {
                    $newPassword = encrypt($newPassword);
                     // they match! Create sql to update the password
                    $sql = "UPDATE usertb SET password = '$newPassword' WHERE username = '$username'";
                    $result_2 = $conn->query($sql);
                    if ($result_2 == TRUE)
                    {
                        echo 'password updated!';
                    }
                    else{
                        echo 'password update failed!';
                    }
                }
                else
                {
                    // if we get here, password didn't match
                    echo "update failed - bad password";
                }
            }
        } 
    }
    else
    {
        echo "new password is the same as the old pick a new";
    }
}


function encrypt ($clear_text)
{
    return password_hash($clear_text, PASSWORD_DEFAULT);
}

?>