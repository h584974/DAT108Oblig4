package paamelding;

import org.junit.Assert;
import org.junit.Test;
import validering.Validator;

public class ValidatorTest {
	
	private final Validator validator = new Validator();
	
	@Test
	public void testValiderFornavn() {
		Assert.assertTrue(validator.validerFornavn("Oliver"));
		Assert.assertFalse(validator.validerFornavn(""));
		Assert.assertFalse(validator.validerFornavn("     "));
		Assert.assertFalse(validator.validerFornavn("123456789123456789123456789123456789123456789123456789123456789123456789"));
		Assert.assertFalse(validator.validerFornavn(null));
	}
	
	@Test
	public void testValiderEtternavn() {
		Assert.assertTrue(validator.validerEtternavn("Oloughlin"));
		Assert.assertFalse(validator.validerEtternavn(""));
		Assert.assertFalse(validator.validerEtternavn("     "));
		Assert.assertFalse(validator.validerEtternavn("123456789123456789123456789123456789123456789123456789123456789123456789"));
		Assert.assertFalse(validator.validerEtternavn(null));
	}
	
	@Test
	public void testValiderMobil() {
		Assert.assertTrue(validator.validerMobil("47332092"));
		Assert.assertFalse(validator.validerMobil("123456789"));
		Assert.assertFalse(validator.validerMobil("1234567"));
		Assert.assertFalse(validator.validerMobil("kys12345"));
	}
	
	@Test
	public void testValiderPassord() {
		Assert.assertTrue(validator.validerPassord("12345678"));
		Assert.assertFalse(validator.validerPassord("eee12345"));
		Assert.assertFalse(validator.validerPassord("1234eee5"));
		Assert.assertFalse(validator.validerPassord("1234567"));
		Assert.assertFalse(validator.validerPassord("123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789"));
	}
	
	@Test
	public void testValiderPassordRepetert() {
		Assert.assertTrue(validator.validerPassordRepetert("12345678","12345678"));
		Assert.assertTrue(validator.validerPassordRepetert("",""));
		Assert.assertTrue(validator.validerPassordRepetert(null,null));
		Assert.assertFalse(validator.validerPassordRepetert("12345678a","12345678A"));
		Assert.assertFalse(validator.validerPassordRepetert("12345678","123456789"));
		Assert.assertFalse(validator.validerPassordRepetert("12345678",null));
		Assert.assertFalse(validator.validerPassordRepetert(null,"12345678"));
	}
	
	@Test
	public void testValiderKjonn() {
		Assert.assertTrue(validator.validerKjonn("mann"));
		Assert.assertTrue(validator.validerKjonn("kvinne"));
		Assert.assertFalse(validator.validerKjonn(null));
	}

}
