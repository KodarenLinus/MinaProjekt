<style type="text/css">

 

#container {

  position:relative;

  left:px;

  top:0px;

  width:500px;

  height:1000px;

}

#navigation {

  position:absolute;

  left:0px;

  top:0px;

  width:100%;

  height:100px;

  background-color:blue; 

}

 

#login {

  position:absolute;

  left:0px;

  top:0px;

  width:150px;

  height:49px;

}

#create {

position:absolute;

left:200px;

top:0px;

width:200px;

height:49px;

}
 

#navigation a:link,

#navigation a:visited {

  color:yellow;

  text-decoration: none;

  font-size:30px;

  font-weight:bold;

  font-family:Verdana,

  Geneva, sans-serif;

}

#navigation a:hover  {color: red ; }

#navigation a:active { color: yellow; }

 

</style>


 

  <div id=container>

    <div id=navigation>

      <div id=login>

        <a href="login.php">login</a>

        <div id=create>

            <a href="create_cust.php">create user</a>

        </div>

      </div>

     </div>

  </div>