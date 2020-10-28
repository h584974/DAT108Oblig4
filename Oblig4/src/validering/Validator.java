package validering;

public class Validator {
	
	public static boolean validerFornavn(String fornavn) {
		return fornavn != null && !fornavn.isBlank() && fornavn.length() <= 50;
	}
	
	public static boolean validerEtternavn(String etternavn) {
		return etternavn != null && !etternavn.isBlank() && etternavn.length() <= 50;
	}

	public static boolean validerMobil(String mobil) {
		int mobilnr = -1;
		try {
			mobilnr = Integer.parseInt(mobil);
		}
		catch(NumberFormatException e) {}
		
		return (mobil.length() == 8 && mobilnr > -1);
	}
	
	public static boolean validerPassord(String passord) {
		boolean validert = true;
		
		if(passord == null || passord.isBlank() || passord.length() < 8 || passord.length() > 64) {
			validert = false;
		}
		else {
			int i2 = 0;
			int i3 = 0;
			for(int i = 0; i < passord.length() - 2; i++) {
				i2 = i + 1;
				i3 = i + 2;
				
				if(passord.charAt(i) == passord.charAt(i2) && passord.charAt(i) == passord.charAt(i3)) {
					validert = false;
					break;
				}
			}
		}
		
		return validert;
	}
	
	public static boolean validerPassordRepetert(String passordRepetert, String passord) {
		return passordRepetert != null && !passordRepetert.isBlank() && passordRepetert.equals(passord);
	}
	
	public static boolean validerKjonn(String kjonn) {
		return kjonn != null;
	}

}