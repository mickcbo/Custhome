package custhome

import java.awt.image.renderable.RenderableImage;

import org.omg.CosNaming.NamingContextPackage.NotFound;

class UserAccountController {

    def index() 
	{
		
		
	}
	def save(String name,String password) {

		User newUser=new User(enabled: true,name:name,password: password,)
		Role RoleUser = Role.
			
		newUser.save flush:true
		}
		
		
	

	
}
