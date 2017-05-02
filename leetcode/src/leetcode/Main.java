package leetcode;

public class Main {
	
		public static void main1 (String args[]){
	    	int employee[] = {-1,-1,-1};
	        int target = 0;
	        try{
	            target = System.in.read();
	            employee[0] = System.in.read();
	            employee[1] = System.in.read();
	            employee[2] = System.in.read();
	        }catch(Exception e){
	            
	            }
	        
	        
	        int result = compute(target,employee);
	        System.out.println(result);
	    }
	    public static void main(String args[]){
	    	int employee[] = {3,2,3};
	        int target = 20;
	        
	        
	        int result = compute(target,employee);
	        System.out.println(result);
	    }
	    
	    public static int compute(int target,int []employee){
	        int result = 0;
	        int sum = 0;
	        
	    	for(int i = 0;i<=target;i++){
	        	for(int j = 0;j<=target;j++){
	            	for(int k = 0;k<=target;k++){
	                	sum = i*employee[0] + j*employee[1] + k*employee[2];
	                    if(sum==target){
	                    	result++;
	                    }
	                }
	            }
	        }
	        return result;     
	    }
	    
	    
	    
}

