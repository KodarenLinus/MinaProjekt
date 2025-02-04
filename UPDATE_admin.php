<?php
use LDAP\Result;
include "menuCRUD_admin.php";
include "db_conn.php";
include "user_perm.php";

function form()
{
    print '<form method="post" action = "">
    username: <input type="text" name="username_"><br>
    password: <input type="text" name="password_"><br>
    new password: <input type="text" name="newPassword_"><br>
    <input type="submit" name="update">
    </form>';

}
form();

if(isset($_POST['update']))
{
    $username = $conn -> real_escape_string($_POST['username_']);
    $password = $conn -> real_escape_string($_POST['password_']);
    $newPassword = $conn -> real_escape_string($_POST['newPassword_']);

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



// display the users that exist on the database
$sql = "SELECT userid, username, password FROM usertb";
$result = $conn->query($sql);
if ($result->num_rows > 0) {
    // output column headers
    echo "<table><th>userid</th><th>username</th><th>password</th><th>";
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>".$row["userid"]."</td><td>".$row["username"]."</td><td>".$row["password"];
    }
    echo "</table>";
} else {
    echo "No users found";
}

function encrypt ($clear_text)
{
    return password_hash($clear_text, PASSWORD_DEFAULT);
}

?>
