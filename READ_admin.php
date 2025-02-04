<?php
include "menuCRUD_admin.php";
include "db_conn.php";
include "user_perm.php";



$sql = "SELECT userid, username FROM usertb";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output column headers
    echo "<table><th>userid</th><th>username</th><th>";
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>".$row["userid"]."</td><td>".$row["username"];
    }
    echo "</table>";
} else {
    echo "No shopping cart found";
}
?>