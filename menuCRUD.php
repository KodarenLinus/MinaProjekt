<style type="text/css">

#container {

  position:relative;

  top:0px;

  width:100%;

  height:1000px;

}

#navigation {

position:absolute;

left:0px;

top:100px;

width:100%;

height:100px;

background-color:0DCECB; 

}

#RUB {

  position:absolute;

  left:0px;

  top:0px;

  width:100%;

  height:100px;

  background-color:0DCECB; 

  color:white;
  
  text-align: center;

  text-decoration: none;

  font-size:50px;

  font-weight:bold;

  font-family:Verdana,

  Geneva, sans-serif;

}

 

#home {

  position:absolute;

  left:15%;

  top:0px;

  width:150px;

  height:49px;

}

#create {

position:absolute;

left:120%;

top:0px;

width:150px;

height:49px;

}

#read {

position:absolute;

left:120%;

top:0px;

width:200px;

height:49px;

}

#update {

position:absolute;

left:120%;

top:0px;

width:150px;

height:49px;

}

#delet {

position:absolute;

left:120%;

top:0px;

width:150px;

height:49px;

}

#login {

position:absolute;

left:130%;

top:0px;

width:150px;

height:49px;

}

#checkOut {

position:absolute;

left:120%;

top:0px;

width:150px;

height:49px;

}
 



 

#navigation a:link,

#navigation a:visited {

  color:white;

  text-decoration: none;

  font-size:30px;

  font-weight:bold;

  font-family:Verdana,

  Geneva, sans-serif;

}

#navigation a:hover  {color: blue ; }

#navigation a:active { color: blueviolet; }

 

</style>




<div id=container>

  <div id=RUB>

  <a>Golf E-Handel</a>

    <div id=navigation>

      <div id=home>

      <a href="home_kund.php">Home</a>

        <div id=create>

        <a href="CREATE_user_web2.php">Create user</a>

          <div id=read>

          <a href="READ_kund.php">user info</a>

            <div id=update>

            <a href="Update_kund.php">Update password</a>

              <div id=login>

              <a href="logout.php">Log out</a>

                <div id=delet>

                <a href="Delet_web2.php">Remove user</a>

                  <div id=checkOut>

                  <a href="Check_out_kund.php">Check out</a>

                  </div>    

                </div>    

              </div>

            </div>

          </div>

        </div>

      </div>

    </div>

  </div>

</div>