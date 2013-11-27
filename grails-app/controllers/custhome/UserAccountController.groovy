package custhome

import grails.transaction.Transactional;

import java.awt.image.renderable.RenderableImage;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.sun.jdi.Bootstrap;

class UserAccountController {

    def index() 
	{
		
		
	}
	@Transactional
	def save(String name,String password) {
		

		
		def newUser = new User(username: name, password: password, enabled: true)
		newUser.save()
		Role roleUser = Role.find("from Role as b where b.authority=?", ['ROLE_USER'], [cache: true])
		
		
		 UserRole.create(newUser, roleUser)
		
		
		
		redirect(uri:'/')
		
		}
		
		
	

	
}
