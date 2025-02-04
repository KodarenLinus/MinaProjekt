<!doctype html>
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
	top: 130px;
    left: 1%;
    width: 300px;
	padding: 10px;
	text-align: center;
}
.search_r{
    list-style-type: none;
    position: absolute;
    top: 180px;
    left: -0.5%;
}
</style>