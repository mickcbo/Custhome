package custhome

class Surface {

	String nom;
	
	String description;
	
		
	@Override
	public String toString() {
		return nom ;
	}



	static constraints = {
		description blank:true ;
		nom blank:false;
		  
	}
    
}
