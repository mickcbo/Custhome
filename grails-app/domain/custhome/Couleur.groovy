package custhome

class Couleur {
	
	String nom;
	
	String description;
	
	@Override
	public String toString() {
		return nom
	}

	

    static constraints = {
		description blank:true ;
		nom blank:false;
    }
}
