package validering;

public class Validator {
	
	private final String ANY_LETTER = "[a-zA-ZÊ¯Â∆ÿ≈]";
	
	public Validator() {}
	
	public boolean validerFornavn(String fornavn) {
		return (fornavn != null && !fornavn.isBlank() && fornavn.length() <= 50 && fornavn.length() >= 2 &&
				Character.isUpperCase(fornavn.charAt(0))) ? fornavn.matches("^" + ANY_LETTER + "+[ -]*" + ANY_LETTER + "*$") : false;
	}
	
	public boolean validerEtternavn(String etternavn) {
		return (etternavn != null && !etternavn.isBlank() && etternavn.length() <= 50 && etternavn.length() >= 2 &&
				Character.isUpperCase(etternavn.charAt(0))) ? etternavn.matches("^" + ANY_LETTER + "+$") : false;
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