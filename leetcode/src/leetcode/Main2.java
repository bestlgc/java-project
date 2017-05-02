package leetcode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {
	
	 public static void main6(String[] args) {

	        ArrayList<Integer> inputs = new ArrayList<Integer>();
	        Scanner in = new Scanner(System.in);
	        String line = in.nextLine();
	        if(line != null && !line.isEmpty()) {
	            int res = resolve(line.trim());
	            System.out.println(String.valueOf(res));
	        }
	        in.close();
	    }

	    // write your code here
	    public static int resolve(String expr) {
	    	
	       int result = 0;
	       String list[] = expr.split(" ");
	       Stack<Integer> porland = new Stack<Integer>();
	       for(int i = 0;i<list.length;i++ ){
	    	   if(list[i].equals("+")){
	    		   try{
	    			   int a = porland.pop();
		    		   int b = porland.pop();
		    		   porland.push(a+b);
	    		   }catch(Exception e){
	    			   result = -1;
	    			   break;
	    		   }
	    		  
	    	   }else if(list[i].equals("^")){
	    		   try{
	    			   int a = porland.pop();
		    		   porland.push(++a);
	    		   }catch(Exception e){
	    			   result = -1;
	    			   break;
	    		   }
	    		   
	    	   }else if(list[i].equals("*")){
	    		   try{
	    			   int a = porland.pop();
		    		   int b = porland.pop();
		    		   porland.push(a*b);
	    		   }catch(Exception e){
	    			   result = -1;
	    			   break;
	    		   }
	    		  
	    	   }else{
	    		   int num = Integer.parseInt(list[i]);
	    		   porland.push(num);
	    	   }
	    	   
	       }
	       
	       if(result==-1){
	    	   return result;
	    	  }else{
	    		  result = porland.pop();
	    		   return result;
	    	   }
	       
	      
	    }
	
		public static void main(String []args){
			 Scanner in = new Scanner(System.in);
	         String str = in.nextLine();
	         String regx = in.nextLine();
	         in.close();
	         int result = match(str,regx); 
	         System.out.println(result);;
		}
		
		public static int match (String str,String match){
			 int result = 1;
			 char[] rlist = str.toCharArray();
			 char[] mlist = match.toCharArray();
			 int pr=0,mr = 0;
			 
			 for(int i = 0;i<str.length();i++){
				
				 if(rlist[pr]==mlist[mr]){
					 pr++;
					 mr++;
				 }else if(mlist[mr]=='?'){
					 pr++;
					 mr++;
				 }else if(mlist[mr]=='*'){
					 if(mlist[mr+1]==rlist[pr]){
						 mr++;
					 }else{
						 pr++;
					 }					 
				 }else{
					 result = 0;
				 }				 
			 }
	         return result;
	     }
	
		public static void main3(String args[]){
	    	int rec[][] = new int[4][4];	        
	        try{
	            for(int i = 0;i<4;i++){
                	for(int j = 0;j<4;j++){
                    	rec[i][j] = System.in.read();
                    }
                }
	        }catch(Exception e){
	            e.printStackTrace();
	          }      
	        String result = compute(rec);
            
	        System.out.println(result);
	    }
	    
	    public static String compute(int [][]rec){
	        String result = "NO";
	        int vector[][] = new int[4][2];
	        for(int i = 0;i<=3;i++){
	        	//计算向量
            	vector[i][0] = rec[i][1]-rec[i][0];
            	vector[i][1] = rec[i][3]-rec[i][2];
            	//向量和坐标轴平行
            	if((vector[i][0]!=0)&&vector[i][1]!=0){
            		result = "NO";
            		break;
            	}
            }
	        int[] a = new int[3];
	         a[0] = vector[0][0]*vector[1][1] + vector[0][1]*vector[1][0];
	         a[1] = vector[0][0]*vector[2][1] + vector[0][1]*vector[2][0];
	         a[2] = vector[0][0]*vector[3][1] + vector[0][1]*vector[3][0];
	         
	         int count=0;
	         for(int i=0;i<3;i++){
	        	 if(a[i]==0){
	        		 count++;
	        	 }
	         }
	         if(count==2){
	        	 result = "YES";
	         }
	        return result;     
	    }
	    	    	    
}

