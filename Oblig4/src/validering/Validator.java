package validering;

public class Validator {
	
	public Validator() {}
	
	public boolean validerFornavn(String fornavn) {
		return fornavn != null && !fornavn.isBlank() && fornavn.length() <= 50;
	}
	
	public boolean validerEtternavn(String etternavn) {
		return etternavn != null && !etternavn.isBlank() && etternavn.length() <= 50;
	}

	public boolean validerMobil(String mobil) {
		int mobilnr = -1;
		try {
			mobilnr = Integer.parseInt(mobil);
		}
		catch(NumberFormatException e) {}
		
		return (mobil.length() == 8 && mobilnr > -1);
	}
	
	public boolean validerPassord(String passord) {
		boolean validert = true;
		
		if(passord == null || passord.isBlank() || passord.length() < 8 || passord.length() > 64) {
			validert = false;
		}
		else {
			for(int i = 0; i < passord.length() - 2; i++) {
				int i2 = i + 1;
				int i3 = i + 2;
				
				if(passord.charAt(i) == passord.charAt(i2) && passord.charAt(i) == passord.charAt(i3)) {
					validert = false;
					break;
				}
			}
		}
		
		return validert;
	}
	
	public boolean validerPassordRepetert(String passordRepetert, String passord) {
		return passordRepetert == null ? passord == null : passordRepetert.equals(passord);
	}
	
	public boolean validerKjonn(String kjonn) {
		return kjonn != null;
	}

}