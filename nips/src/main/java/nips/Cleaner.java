package nips;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Cleaner {
	public static void main1(String[] args) throws Exception {
		 File file = new File("E:/nipsconference2016.csv");
		 BufferedReader reader = new BufferedReader(new FileReader(file));
		 
		 File file2 = new File("E:/nipsconference2016-01.csv");
		 BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
		 
		 String input = "";
	     String[] strTypes = {"InvitedTalk","Tutorial","Poster","Oral","Demonstration","Workshop","Symposium"};
		 while (input!=null) {
			  input =  reader.readLine();
			  String[] lineContent = input.split(",");
			  if (lineContent.length>1) {
				  for (String string : strTypes) {
					if (lineContent[1].contains(string)) {
						lineContent[1] = lineContent[1].replace(string, string+",");
						System.out.println(lineContent[1]);
					}
				  }
			}
			
			//write to new file
			for (String string : lineContent) {
				writer.write(string+",");
			}
			writer.newLine();
			writer.flush();
		}
		writer.close();
		reader.close();
		 
	}
	
	public static void main(String[] args) throws Exception {
		String reg = "bang|ba[ino]?|beng|be[in]?|bing|bia[no]?|bi[en]?|bu|cang|ca[ino]?|ceng|ce[in]?|chang|cha[ino]?|cheng|che[n]?|chi|chong|chou|chuang|chua[in]|chu[ino]?|ci|cong|cou|cuan|cu[ino]?|dang|da[ino]?|deng|de[in]?|dia[no]?|ding|di[ae]?|dong|dou|duan|du[ino]?|fang|fan|fa|feng|fe[in]{1}|fo[u]?|fu|gang|ga[ino]?|geng|ge[in]?|gong|gou|guang|gua[in]?|gu[ino]?|hang|ha[ino]?|heng|he[in]?|hong|hou|huang|hua[in]?|hu[ino]?|jiang|jia[no]?|jiong|ji[nu]?|juan|ju[en]?|kang|ka[ino]?|keng|ke[n]?|kong|kou|kuang|kua[in]?|ku[ino]?|lang|la[ino]?|leng|le[i]?|liang|lia[no]?|ling|li[enu]?|long|lou|luan|lu[no]?|lv[e]?|mang|ma[ino]?|meng|me[in]?|mia[no]?|ming|mi[nu]?|mo[u]?|mu|nang|na[ino]?|neng|ne[in]?|niang|nia[no]?|ning|ni[enu]?|nong|nou|nuan|nu[on]?|nv[e]?|pang|pa[ino]?|pa|peng|pe[in]?|ping|pia[no]?|pi[en]?|po[u]?|pu|qiang|qia[no]?|qiong|qing|qi[aenu]?|quan|qu[en]?|rang|ra[no]{1}|reng|re[n]?|rong|rou|ri|ruan|ru[ino]?|sang|sa[ino]?|seng|se[n]?|shang|sha[ino]?|sheng|she[in]?|shi|shou|shuang|shua[in]?|shu[ino]?|si|song|sou|suan|su[ino]?|tang|ta[ino]?|teng|te|ting|ti[e]?|tia[no]?|tong|tou|tuan|tu[ino]?|wang|wa[ni]?|weng|we[in]{1}|w[ou]{1}|xiang|xia[no]?|xiong|xing|xu|xi[enu]?|xuan|xu[en]|yang|ya[no]?|ye|ying|yi[n]?|yong|you|yo|yuan|yu|yu[en]?|zang|za[ino]?|zeng|ze[in]?|zhang|zha[ino]?|zheng|zhe[in]?|zhi|zhong|zhou|zhuang|zhua[in]?|zhu[ino]?|zi|zong|zou|zuan|zu[ino]?";
		 File file = new File("E:/nipsconference2016.csv");
		 BufferedReader reader = new BufferedReader(new FileReader(file));
		 
		 File dicFile = new File("university.txt");
		 List<String> diclist = new ArrayList<String>();
		 BufferedReader reader2 = new BufferedReader(new FileReader(dicFile));
		 String readInput = "";
		 while((readInput=reader2.readLine())!=null){
			 diclist.add(readInput);
		 }
		 reader2.close();
		 
		 File file2 = new File("E:/nipsconference2016-04.csv");
		 BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
		 writer.write("Title,session,author 1,nationality 1,affiliation 1,category 1,author 2,nationality 2,affiliation 2,category 2,author 3,nationality 3,affiliation 3,category 3,author 4,nationality 4,affiliation 4,category 4,author 5,nationality 5,affiliation 5,category 5,author 6,nationality 6,affiliation 6,category 6,author 7,nationality 7,affiliation 7,category 7,author 8,nationality 8,affiliation 8,category 8");
		 writer.newLine();
		 String input = "";
		 while ((input =  reader.readLine())!=null) {
			String[] list = input.split(",");
			int start = 2;
			for (int i = 0; i < list.length; i++) {
				if (start<list.length) {
					String[] nameList = list[start].trim().split(" ");
					if (nameList.length>1) {
						if (nameList[1].toLowerCase().matches(reg)) {
							list[start] = list[start].concat(",chinese");
						}else {
							list[start] = list[start].concat(",non-chinese");
						}
					}
				}
				start++;
				if (start < list.length) {
					boolean flag = true;
					for (String string : diclist) {
						if (list[start].toLowerCase().contains(string.toLowerCase())) {
							list[start] = list[start].concat(",university");
							flag = false;
							break;
						}
					}
					if (flag) {
						list[start] = list[start].concat(",non-university");
					}
				}
				start++;
				
			}
			
			for (String string : list) {
				writer.write(string+",");
			}
			writer.newLine();
			writer.flush();
		}
		reader.close();
		writer.close();
	}
}
