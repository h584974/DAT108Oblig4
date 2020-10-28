package paamelding;

import org.junit.Assert;
import org.junit.Test;

import validering.Validator;

public class ValidatorTest {
	
	@Test
	public void testValiderFornavn() {
		Assert.assertTrue(Validator.validerFornavn("Oliver"));
		Assert.assertFalse(Validator.validerFornavn(""));
		Assert.assertFalse(Validator.validerFornavn("     "));
		Assert.assertFalse(Validator.validerFornavn("123456789123456789123456789123456789123456789123456789123456789123456789"));
		Assert.assertFalse(Validator.validerFornavn(null));
	}
	
	@Test
	public void testValiderEtternavn() {
		Assert.assertTrue(Validator.validerEtternavn("Oloughlin"));
		Assert.assertFalse(Validator.validerEtternavn(""));
		Assert.assertFalse(Validator.validerEtternavn("     "));
		Assert.assertFalse(Validator.validerEtternavn("123456789123456789123456789123456789123456789123456789123456789123456789"));
		Assert.assertFalse(Validator.validerEtternavn(null));
	}
	
	@Test
	public void testValiderMobil() {
		Assert.assertTrue(Validator.validerMobil("47332092"));
		Assert.assertFalse(Validator.validerMobil("123456789"));
		Assert.assertFalse(Validator.validerMobil("1234567"));
		Assert.assertFalse(Validator.validerMobil("kys12345"));
	}
	
	@Test
	public void testValiderPassord() {
		Assert.assertTrue(Validator.validerPassord("12345678"));
		Assert.assertFalse(Validator.validerPassord("eee12345"));
		Assert.assertFalse(Validator.validerPassord("1234eee5"));
		Assert.assertFalse(Validator.validerPassord("1234567"));
		Assert.assertFalse(Validator.validerPassord("123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789"));
	}
	
	@Test
	public void testValiderPassordRepetert() {
		Assert.assertTrue(Validator.validerPassordRepetert("12345678","12345678"));
		Assert.assertFalse(Validator.validerPassordRepetert("12345678a","12345678A"));
		Assert.assertFalse(Validator.validerPassordRepetert("12345678","123456789"));
		Assert.assertFalse(Validator.validerPassordRepetert("12345678",null));
		Assert.assertFalse(Validator.validerPassordRepetert(null,"12345678"));
	}
	
	@Test
	public void testValiderKjonn() {
		Assert.assertTrue(Validator.validerKjonn("mann"));
		Assert.assertTrue(Validator.validerKjonn("kvinne"));
		Assert.assertFalse(Validator.validerKjonn(null));
	}

}
