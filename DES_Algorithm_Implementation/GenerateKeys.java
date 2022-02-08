package DES_Algorithm_Implementation;


public class GenerateKeys {

	static String round_keys[] = new String[16];
	
	public static String shift_left_once(String key_chunk){ 
	    String shifted="";  
	        for(int i = 1; i < 28; i++){ 
	            shifted += key_chunk.charAt(i); 
	        } 
	        shifted += key_chunk.charAt(0);   
	    return shifted; 
	} 
	
	public static String shift_left_twice(String key_chunk){ 
	    String shifted=""; 
	    for(int i = 0; i < 2; i++){ 
	        for(int j = 1; j < 28; j++){ 
	            shifted += key_chunk.charAt(j); 
	        } 
	        shifted += key_chunk.charAt(0); 
	        key_chunk= shifted; 
	        shifted =""; 
	    } 
	    return key_chunk; 
	}
	
	public static void generate_keys(String key){
		
		int pc1[] = {
		57,49,41,33,25,17,9, 
		1,58,50,42,34,26,18, 
		10,2,59,51,43,35,27, 
		19,11,3,60,52,44,36,		 
		63,55,47,39,31,23,15, 
		7,62,54,46,38,30,22, 
		14,6,61,53,45,37,29, 
		21,13,5,28,20,12,4 
		};

		int pc2[] = { 
		14,17,11,24,1,5, 
		3,28,15,6,21,10, 
		23,19,12,4,26,8, 
		16,7,27,20,13,2, 
		41,52,31,37,47,55, 
		30,40,51,45,33,48, 
		44,49,39,56,34,53, 
		46,42,50,36,29,32 
		}; 
		
		
		String perm_key =""; 
		for(int i = 0; i < 56; i++){ 
			perm_key+= key.charAt(pc1[i]-1); 
		} 
		
		
		String left= perm_key.substring(0, 28); 
		String right= perm_key.substring(28, 56); 
		
		for(int i=0; i<16; i++){ 
			
			if(i == 0 || i == 1 || i==8 || i==15 ){
				left= shift_left_once(left); 
				right= shift_left_once(right);
			} 
			
			else{
				left= shift_left_twice(left); 
				right= shift_left_twice(right);
			}
		
		String combined_key = left + right;
		String round_key = ""; 
	
		for(int i1 = 0; i1 < 48; i1++){ 
			round_key += combined_key.charAt(pc2[i1]-1); 
		}   
		
		round_keys[i] = round_key;
		System.out.println("Key "+ (i+1) + " : "+ round_keys[i]);	
		
	} 

	}
	
	public static void main(String[] args) {
		
		String key = "101010101011101100010010001100000100111001101101100110011011101";
		generate_keys(key);
		
	} 

	}


