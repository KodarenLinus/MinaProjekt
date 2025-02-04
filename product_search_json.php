{"results":[
<?php
include "DB_conn.php";

// todo: get query string from resquest (if exist)
$q = $conn -> real_escape_string($_GET['query']); // In case the code we get is harmful


if (strlen($q) != 0) // Have this variable so it only display products if you entered any letters in the search bar.
{
    // todo: add where clause with query string
    $sql = "SELECT * FROM produkttb WHERE available = 1 AND namn LIKE '".$q."%'";
    $result = $conn->query($sql);

    $a = array(); // array for storing result
    if ($result->num_rows > 0)
    {
        while($row = $result->fetch_assoc()) 
        {
            $price = $row["pris"];
            $namn = $row["namn"];
            $produktID = $row["ProduktID"];
            $description = $row["beskrivning"];

            // create temp prod object to push into array
            $prod = new stdClass;
            $prod->productid = $produktID;
            $prod->name = $namn;
            $prod->description = $description;
            $prod->price = $price;

            array_push($a, $prod); // add this product to array
        }
    }

    echo json_encode($a); // make json
}

?>
]}