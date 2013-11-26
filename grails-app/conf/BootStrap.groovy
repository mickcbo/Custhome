import custhome.Couleur
import custhome.Materiau;
import custhome.Role
import custhome.Surface
import custhome.User
import custhome.UserRole
class BootStrap {

      def init = { servletContext ->
    
	  InitValueDefault()
	
     
    }
 
    def destroy = {
    }
	
	def InitValueDefault(){
		def roleAdmin = new Role(authority: 'ROLE_ADMIN').save()
		def roleUser = new Role(authority: 'ROLE_USER').save()
	
		def userAdmin = new User(username: 'admin', password: 'admin', enabled: true)
		userAdmin.save()
		
		def userUser=new User(username: 'user', password: 'user', enabled: true)
		userUser.save()
		UserRole.create(userAdmin, roleAdmin)
		UserRole.create(userUser, roleUser)
		
		
		//Mise en place des materiaux
		new Materiau(description: 'Materiau en bois',nom: 'Bois'  ).save()
		new Materiau(description: 'Materiau en marbre',nom: 'Marbre'  ).save()
		new Materiau(description: 'Materiau en metal',nom: 'Metal'  ).save()
		new Materiau(description: 'Materiau en plastique',nom: 'Plastique'  ).save()
		new Materiau(description: 'Materiau en carrelage',nom: 'Carrelage'  ).save()
		new Materiau(description: 'Materiau en moquette',nom: 'Moquette'  ).save()
		new Materiau(description: 'Materiau en tapisserie',nom: 'Tapisserie'  ).save()
		
		//Mise  en place des surfaces
		new Surface(description: 'Sol',nom: 'Sol'  ).save()
		new Surface(description: 'Mur',nom: 'Mur'  ).save()
		new Surface(description: 'Plafond',nom: 'Plafond'  ).save()
		
		//Mise en place des couleurs
		new Couleur(description: 'Rouge',nom: 'Rouge'  ).save()
		new Couleur(description: 'Vert',nom: 'Vert'  ).save()
		new Couleur(description: 'Bleu',nom: 'Bleu'  ).save()
		new Couleur(description: 'Blanc',nom: 'Blanc'  ).save()
		new Couleur(description: 'Jaune',nom: 'Jaune'  ).save()
		new Couleur(description: 'Marron',nom: 'Marron'  ).save()
		new Couleur(description: 'Noir',nom: 'Noir'  ).save()
		new Couleur(description: 'Violet',nom: 'Violet'  ).save()
		new Couleur(description: 'Orange',nom: 'Orange'  ).save()
		new Couleur(description: 'Rose',nom: 'Rose'  ).save()
		new Couleur(description: 'Pourpre',nom: 'Pourpre'  ).save()
		new Couleur(description: 'Gris',nom: 'Gris'  ).save()
		
	}
}
