<!DOCTYPE html>
<html>
	<head>
	<meta name="layout" content="main"/>
	</head>
	<body>
	
	<h1>Creation de votre compte</h1>
	</br></br>
	<div class="row">
  		<div class="span4">
    		<img border="2" src="${resource(dir: 'images', file: 'Createuser.png')}" alt="Grails"/>
    	</div>
      	<div class="span8">
      	</br></br>
	      	<form action="${createLink(uri: '/save')}" method="get">
				<label>Nom</label><input type="text" name="name" />
				<label>Password</label><input type="password" name="password" /></br>
				<input type="submit" value="Valider"/>
			</form>
			
      	</div>
    </div>
        	
          
    
	
	</body>
</html>
