<?php
include "menuCRUD.php";
include "DB_conn.php";
include "user_perm_kund.php";

$sql = "SELECT userid, username FROM usertb WHERE userid = '$userid'";
$result = $conn->query($sql);

if ($result->num_rows == 1) {
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