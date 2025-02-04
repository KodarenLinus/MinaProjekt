<?php 
include "menuCRUD.php";
include "DB_conn.php";
include "user_perm_kund.php";
// check if post or get. And retrieve productID in the apprppriate way
// from query param if GET. from post variable if POST.
$id = $_GET['q'];

// use product id to fetch and display the appropriate product



//here is the check if your a staff member or admin you will be sendt to the login site

    
    $sql = "SELECT * FROM produkttb WHERE produktid = '$id'";
    $result = $conn->query($sql);
    if ($result->num_rows == 1)
    {
        while($row = $result->fetch_assoc()) 
        {
            // In case i want to change things later on i thought it would just be easier storing values in variables rather than putting them directly in
            $price = $row["pris"];
            $namn = $row["namn"];
            $produktID = $row["ProduktID"];
            $description = $row["beskrivning"];

            // Here is where the produkt data we need will display so we can buy them
            echo '<div id="'.$produktID.'" class="product_wrapper">
            <form method="post" action="">
            <input type="hidden" name="produktid" value="'.$produktID.'"/>
            <div class="name">'.$namn.'</div>
            <div class="price">Price: '.$price.'</div>
            <div class="description">Description: '.$description.'</div>
            <input type="submit", name="submit", value="Buy Now", class="buy">
            </form>
            </div>'; 
        }
    }


if(isset($_POST['submit']))
{

    $sql = "SELECT orderId FROM orderr WHERE UserID = '".$userid."'";
    $result = $conn->query($sql);
    if ($result->num_rows > 0) 
    {
        // order exist for user, get id
        $row = $result->fetch_assoc();
        $orderid = $row["orderId"];
    }
    else
    {
        // no order exist, create one
        $sql = "INSERT INTO orderr (userid) VALUES ($userid)"; // Creating a orderrad with the choosen product
        if ($conn->query($sql) === true)
        {
           // echo "succes"; //this is for debbuging purpose
        }

        // get orderid for user
        $sql_1 = "SELECT orderId FROM orderr WHERE UserID = '".$userid."'";
        $result_ = $conn->query($sql_1);
        if ($result_->num_rows > 0) 
        {
            // order exist for user, get id
            $row = $result_->fetch_assoc();
            $orderid = $row["OrderID"];
        }

    }


   /* $produktID = $_POST['produktid']; // get selected product from post variable
    $sql_ = "SELECT produktid FROM orderrad WHERE orderid = '$orderid'";
    $result = $conn->query($sql);*/
    
    $sql_ = "INSERT INTO orderrad (produktID, OrderId, UserID) VALUES ($produktID, $orderid, $userid)"; // Creating a orderrad with the choosen product
    if ($conn->query($sql_) === true)
    {
         // echo "succes"; //this is for debbuging purpose
        // TDO: Add to shoppingcarttb
        $available = 0; // 0 means someone put it in cart, 1 means is available
        $sql__ = "UPDATE produkttb SET available = '$available' WHERE ProduktID = '$produktID'"; //making produkt unavialable
        $result_1 = $conn->query($sql__);
        if ($result_1 == true) 
        {
            header("Location: home_kund.php");
            exit;
        
        }
        else
        { 
            echo "test"; 
        }
    }
}
?>

<style type="text/css">

/*css stylying... at the moment basic but will most likely put more energy in it later on the projekt if visuals is requierd to be good*/
.product_wrapper {
    position: absolute;
    top: 250px;
	padding: 20px;
    left: 10%;
    height: 500px;
    width: 80%;
	text-align: center;
    font-size: 30px;
    border: 1px solid black;	
}
.product_wrapper .name {
    font-size: 60px;
	font-weight:bold;
	}
.product_wrapper .buy {
	text-transform: uppercase;
    font-size: 60px;
	background: #F68B1E;
	border: 1px solid black;
	cursor: pointer;
	color: #fff;
    height: 200px;
    width: 800px;
	padding: 8px 40px;
	margin-top: 50px;
}
.product_wrapper .buy:hover {
	background: #f17e0a;
	border-color: black;
}
</style>