package leetcode;
//change
import java.util.Scanner;

public class Main3 {
	
		public static void main(String[] args){
			Scanner in = new Scanner(System.in);
			String input = in.nextLine();
			in.close();
			String numArray[] = input.split(" ");
			Integer a = 0;
			Integer b = 0;
			if(numArray.length==2){
				 a = stringToInt(numArray[0]);
				 b = stringToInt(numArray[1]);
			}	
			Integer sum = a*b;
			String result = to7Str();
			System.out.println(a*b);			
		}
		
		public static int stringToInt(String str){
			Integer sum = 0;
			int j = 0;
			for(int i = str.length()-1;i>=0;i--){
				
				int a = Integer.parseInt(str.substring(i, i+1));
				sum = (int) (sum + a*Math.pow(7, j));
				j++;
			}
			return sum;
		}
	
	    public static void main1(String[] args) {
	        Scanner in = new Scanner(System.in);
	        
	        	String input = in.nextLine();
		        char inputChar[] = input.toCharArray();
		        if(inputChar.length>500){
		        	System.out.println(-1);
		        	return;
		        }
		        if(inputChar.length == 0){
		        	System.out.println(0);
		        	return;
		        }
		        
		        int count = 0;
		        for(int i = 0;i<inputChar.length;i++){
		        	if((inputChar[i]-'z'<=0&&inputChar[i]-'a'>=0)||(inputChar[i]-'Z'<=0&&inputChar[i]-'A'>=0)){
		        		if(i-1<0||inputChar[i-1]==' '||inputChar[i-1]==','||inputChar[i-1]=='.')
		        		count++;
		        		continue;
		        	}else if(inputChar[i]==' '||inputChar[i]==','||inputChar[i]=='.'){
		        		continue;
		        	}else{
		        		count = -1;
		        		break;
		        	}
		        }
		        
		        System.out.println(count);
		    }
		//电报计算
	    public static void main2(String[] args) {
	    	Scanner in = new Scanner(System.in);
	    	
        	String input = in.nextLine();
        	char rt[] = input.toCharArray();
        	int haha = tranverse(rt);
	        System.out.println(haha);
	        StringBuffer result = new StringBuffer();
	        
	        String []str = input.split("#");
	        for(int i = 0;i<str.length;i++){
	        	char temp[] = str[i].toCharArray();
	        	if(temp.length<=0){
	        		continue;
	        	}
	        	int num = tranverse(temp);
	        	if(num>51||num<0){
	        		System.out.println("ERROR");
	        		break;
	        	}
	        	char a = getChar(num);
	        	result.append(a);
	        }
	        System.out.println(result);
	    }
	    public static char getChar(int num){
	    	char[] mapping = {'F','G','R','S','T','L','M','N','O','P','Q','W','X','Y','Z','U','A','G','H','I','J','K','B','C','D','E','l','m','n','o',
	    			'p','i','j','k','f','g','h','a','b','c','d','e','q','r','w','x','y','z','s','t','u','v'};
	    	return mapping[num];
	    }
        
	    public static int tranverse(char[] temp){
	    	int j = temp.length;
	    	double sum = 0;
	    	int i = 0;
	    	int num = 0;
	    	while(j-1>=0){
	    		if(temp[j-1]=='.'){
	    			num = 1;
	    		}else if(temp[j-1]=='-'){
	    			num = 0;
	    		}else{
	    			return -1;
	    		}
	    		sum = sum + num*Math.pow(2, i);
	    		j--;
	    		i++;
	    	}
	    	return (int)sum;
	    }
}
