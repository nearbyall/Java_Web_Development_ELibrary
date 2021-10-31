package by.epamtc.melnikov.elibrary.service.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5PasswordEncryption {

	private MD5PasswordEncryption() {}
	
	public static String encryptPasswordWithMD5(String password) {
		
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = password.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < digested.length; i++){
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
