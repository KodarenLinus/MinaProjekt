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

  top:0px;                                                                                                                                                                                                                                                                                                                                                                                                                      

  width:100%;

  height:100px;

  background-color:blue; 

}

 

#home {

  position:absolute;

  left:500px;

  top:0px;

  width:150px;

  height:49px;

}

#create {

position:absolute;

left:200px;

top:0px;

width:150px;

height:49px;

}

#read {

position:absolute;

left:200px;

top:0px;

width:150px;

height:49px;

}

#update {

position:absolute;

left:200px;

top:0px;

width:150px;

height:49px;

}

#delet {

position:absolute;

left:200px;

top:0px;

width:150px;

height:49px;

}
 

#login {

position:absolute;

left:200px;

top:0px;

width:150px;

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

    <div id=home>

      <a href="home_admin.php">home</a>

      <div id=create>

        <a href="Create_admin.php">Create user</a>

        <div id=read>

          <a href="READ_admin.php">List of users</a>

          <div id=update>

            <a href="Update_admin.php">Update password</a>

            <div id=login>

              <a href="logout.php">log out</a>

              <div id=delet>

                <a href="Delet_admin.php">Remove user</a>

              </div>

            </div>

          </div>

        </div>

      </div>

    </div>

  </div>

</div>                                                                                                                        