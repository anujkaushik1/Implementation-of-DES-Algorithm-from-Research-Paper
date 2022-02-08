package com.testpackage;

import org.testng.annotations.Test;

import DES_Algorithm_Implementation.Division;
import DES_Algorithm_Implementation.Encrypting_Decrypting_Text;

public class TestScript {
	
	@Test
	public void test() {
		String arr[] = {"Anuj Kaushik"};
		Encrypting_Decrypting_Text obj = new Encrypting_Decrypting_Text();
		Encrypting_Decrypting_Text.pt = "0000000000000000101000100000000000000000000000000000000000000000";
		obj.main(arr);
		
	}

}
