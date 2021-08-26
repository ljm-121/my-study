package com.study.util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoding implements PasswordEncoder{

	private PasswordEncoder passwordEncoding;
	
	public PasswordEncoding() {
		this.passwordEncoding = new BCryptPasswordEncoder();
	}
	
	public PasswordEncoding(PasswordEncoding passwordEncoding) {
		this.passwordEncoding = passwordEncoding;
	}
	
	
	@Override
	public String encode(CharSequence rawPassword) {
		return SHA512Pass(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return SHA512Pass(rawPassword.toString()).equals(encodedPassword);
	}

	public static String SHA512Pass(String pass) {
		String salt = "k5DRorhmFwIPoRj//MR1mRdGndxdvh5gonQuA0oPF5F7oQXI3SOmu++IF2ALp1Lhld+qG5KyC9ivuB5yYGFI+g==";
        int iterations = 103740;
        int keyLength = 512;
		
        char[] passwordChars = pass.toCharArray();
        byte[] saltBytes = salt.getBytes();
        byte[] hashedBytes = hashPassword(passwordChars, saltBytes, iterations, keyLength);
		return Base64.getEncoder().encodeToString(hashedBytes);
	}	
	
    public static byte[] hashPassword( final char[] password, final byte[] salt, final int iterations, final int keyLength ) {

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return res;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
