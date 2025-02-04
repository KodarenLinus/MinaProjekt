<?php
include "menuCRUD_admin.php";
include "db_conn.php";
include "user_perm.php";

function form()
{
    print '<form method="post" action = "">
    price: <input type="text" name="price"><br>
    name: <input type="text" name="name"><br>
    description: <input type="text" name="description"><br>
    <input type="submit" name="submit" value="Add">
    </form>';

    print '<form method="post" action = "">
    produktid: <input type="text" name="produktid"><br>
    <input type="submit" name="delet" value="Delet">
    </form>';
}
form();

$sql = "SELECT * FROM produkttb";
$result = $conn->query($sql);
//printing our produkts
if ($result->num_rows > 0) {
    // output column headers
    echo "<table><th>produktid</th><th>pris</th><th>namn</th><th>beskrivning</th><th>";
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>".$row["ProduktID"]."</td><td>".$row["pris"]."</td><td>".$row["namn"]."</td><td>".$row["beskrivning"]."</td><td>";
    }
    echo "</table>";
} else {
    echo "No products added";
}

// This code is used for adding produkts to the database tabell.
if (isset($_POST['submit']))
{
    $price = $conn -> real_escape_string($_POST['price']);
    $name = $conn -> real_escape_string($_POST['name']);
    $description = $conn -> real_escape_string($_POST['description']);
    $available = 1;  // 0 means someone put it in cart, 1 means is available

    $sql = "INSERT INTO produkttb (pris, namn, beskrivning, available) VALUES ('$price','$name','$description','$available')";
    if($conn->query($sql) === true)
    {
        // The produkt is added
        echo "New record created successfully";
    }
    else 
    {
        // Something went wrong
        echo "Error: ";
    }


}

// This code is used for deleting produkts
if (isset($_POST['delet']))
{
    $produktid = $_POST['produktid'];

    $sql = "DELETE FROM produkttb WHERE produktid = '$produktid'";
    $result = $conn->query($sql);
    if ($result == true)
    {
        // The produkt has been deleted
        echo "'$produktid' is removed from database";
    }
    else
    {
        // Something went wrong
        echo "Error: ";
    }
}

?>