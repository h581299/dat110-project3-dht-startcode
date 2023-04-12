package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {	
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
	    BigInteger hashint = null;
		
		try {
		    // we use MD5 with 128 bits digest
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    
		    // compute the hash of the input 'entity'
		    byte[] messageDigest = md.digest(entity.getBytes());
		    
		    // convert the hash into hex format
		    String hexstring = toHex(messageDigest);
		    // new BigInteger(1, messageDigest).toString(16);
		    
		    // convert the hex into BigInteger
		    hashint = new BigInteger(hexstring, 16);
		} catch (Exception e) {
		    System.out.println(e);
		}

	    // return the BigInteger
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// compute the number of bits = bitSize()
	    int bitsize = bitSize();
		
		// compute the address size = 2 ^ number of bits
	    BigInteger number = new BigInteger("2");
	    BigInteger addressSize = number.pow(bitsize);

		// return the address size
		return addressSize;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		try {
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    digestlen = md.getDigestLength();
		} catch (Exception e) {
            System.out.println(e);
        }
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
