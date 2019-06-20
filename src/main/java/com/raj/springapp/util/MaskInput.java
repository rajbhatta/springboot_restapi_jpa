package com.raj.springapp.util;

public class MaskInput 
{
	public String maskCredutCard(String creditCardNumber) 
	{
	    int length = creditCardNumber.length() - creditCardNumber.length()/4;
	    String subString = creditCardNumber.substring(0, length);
	    return subString.replaceAll("[A-Za-z0-9]", "X") + creditCardNumber.substring(length);
	}
	
	public String maskEmail(String email) {
	    final String mask = "*****";
	    final int at = email.indexOf("@");
	    if (at > 2) {
	        final int maskLen = Math.min(Math.max(at / 2, 2), 4);
	        final int start = (at - maskLen) / 2;
	        return email.substring(0, start) + mask.substring(0, maskLen) + email.substring(start + maskLen);
	    }
	    return email;
	}
	

}
