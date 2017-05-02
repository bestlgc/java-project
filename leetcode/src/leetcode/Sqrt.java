package leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sqrt {
	
	    public double sum(int a,int num){
	        double sum = a;
	        for(int  i = 0;i<num-1;i++){
	            sum = sum + Math.sqrt(a);
	        }
	        return sum;
	    }
	    
	    public List<Integer> shuixia(int m,int n){
	    	List<Integer> result = new ArrayList<Integer>();
	    	for(int i = m;i<=n;i++){
	    		
	    		int temp = i ;
	    		//最高位
	    		int a = temp/100;
	    		temp = temp - a*100;
	    		//第二位
	    		int b = temp/10;
	    		temp = temp - b*10;
	    		
	    		int c = temp;
	    		double sum = Math.pow(a, 3)+ Math.pow(b, 3) + Math.pow(c,3);
	    		if(i==sum){
	    			result.add(i);
	    		}
	    	}
	    	return result;
	    }
	    
	    public static void main1(String []args) throws IOException{
	    	Scanner scanner = new Scanner(System.in);
	    	int a = scanner.nextInt();
	    	int b = scanner.nextInt();
	    	System.out.println(a);
	    	System.out.println(b);

	    }
	        
}