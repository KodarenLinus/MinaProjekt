<?php 
include "menuCRUD.php";
include "DB_conn.php";
include "user_perm_kund.php";

    $sql = "SELECT * FROM produkttb where available = 1" ;
    $result = $conn->query($sql);
    if ($result->num_rows > 0) 
    {
        echo '<div class ="product_place" >'; // encasing produkt in box for styling
        while($row = $result->fetch_assoc()) 
        {
            // In case i want to change things later on i thought it would just be easier storing values in variables rather than putting them directly in
            $price = $row["pris"];
            $namn = $row["namn"];
            $produktID = $row["ProduktID"];
            $description = $row["beskrivning"];


            echo '<div id="'.$produktID.'" class="product_wrapper">
            <a href="/product_page.php?q='.$produktID.'">More info</a>
            <div class="name", name = "namn">'.$namn.'</div>
            <div class="price">Price: '.$price.'</div>
            <div class="description">Description: '.$description.'</div>
            </div>';
            
        }
        echo '</div>'; // end of encasing
    }
    else 
    {
        echo "at the moment we dont have any products"; // when there are no available products this messages will show!
    }

?>
<head>
    <html>
    <meta http-equiv="content-type" content="text/html" charset="utf-8" />
    <script>
 
        function searchProduct(searchFor)
        {
            var url = "/product_search_json.php?query=" + searchFor; //URL to send ajax call to
            //alert(searchUrl); // for test only
            
            var xhr = new XMLHttpRequest();
            xhr.open("GET", url);

            var $json;
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                console.log(xhr.status);
                console.log(xhr.responseText);

                // save the json data
                json = xhr.responseText;

                // make js object and get products array from it (from the 'results' object)
                products = JSON.parse(json).results[0];
                    

                //alert(JSON.stringify(products, null, 4)); // used for debugging only
                // get the element where we want to add our products
                var p = document.getElementById("parent-list");

                //e.firstElementChild can be used.
                var child = p.lastElementChild; 
                while (child) 
                {
                    p.removeChild(child);
                    child = p.lastElementChild;
                }

                for (i = 0; i < products.length; i++)
                {
                    //alert(products[i].id);
                   
                    // create the new elements and content for current product
                    var e = document.createElement("li");
                    var a = document.createElement("a");
                    e.textContent = products[i].name + " " + products[i].description;
                    e.style = "padding:5px;border:1px solid #bbb; width: 300px;text-align: center; background: white;";
                    a.appendChild(e);
                    a.href = "/product_page.php?q=" + products[i].productid;
                    p.appendChild(a);
                    
                } 
               
            }};
          
            xhr.send();
        }
    </script>
   </head> 
   <body>
        
        <input id="searchbox" class="search" type="text" placeholder="Enter search term here" onkeyup="searchProduct(this.value)" > 
                <ul id="parent-list" class="search_r" >
                </ul>
              
        </body>
    </html>
<style type="text/css">

/*css stylying... at the moment basic but will most likely put more energy in it later on the projekt if visuals is requierd to be good*/
.search {
    position: absolute;
	top: 230px;
    left: 1%;
    width: 310px;
	padding: 10px;
	text-align: center;
}
.search_r{
    list-style-type: none;
    position: absolute;
    top: 255px;
    left: -1%;
}
.product_place {
    position: absolute;
	top: 320px;
	left: 1%;
	padding: 20px;
    width: 95%;
    height: 800px;
	text-align: center;
    border: 1px solid black;	
    scroll-behavior: smooth;
    overflow-y: scroll;
  
}
.product_wrapper {
	float:left;
	padding: 20px;
    width: 20.5%;
	text-align: center;
    border: 1px solid black;	
    margin-bottom: 1rem;
    margin-right: 1rem;
    margin-left: 1rem;
}
.product_wrapper:hover {
	box-shadow: 0 0 0 1px orangered;
	cursor:pointer;
}
.product_wrapper .name {
    font-weight:bold;
}
</style>