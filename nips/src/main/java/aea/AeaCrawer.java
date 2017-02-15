package aea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class AeaCrawer {
	public static void main(String[] args) throws Exception {
		HtmlCleaner cleaner = new HtmlCleaner();
		List<AeaDao> listaAeaDaos = new ArrayList<AeaDao>();
		for(int i=1;i<=15;i++){
			System.out.println(i);
			String urlString = "https://www.aeaweb.org/conference/2017/preliminary?sessionType%5Bsession%5D=1&sessionType%5Bevent%5D=2&organization_name=&search_terms=&day=&time=&page="+i+"&per-page=50";
			URL url2 = new URL(urlString);
			TagNode node = cleaner.clean(url2);
			Object[] article = node.evaluateXPath("//article[@class='session-item']");
			
			for (Object object : article) {
				TagNode newNode = (TagNode)object;
				AeaDao aeadao = new AeaDao();
				Object detailLinkObject[] = newNode.evaluateXPath("/h3[@class='title']/a/@href");
				Object titleObject[] = newNode.evaluateXPath("/h3[@class='title']/a/text()");
				Object cateObject[] = newNode.evaluateXPath("/section[@class='event-info']/span[@class='location']/text()");
				Object dateObject[] = newNode.evaluateXPath("/section[@class='event-info']/h4/span[@class='date']/text()");
				Object timeObject[] = newNode.evaluateXPath("/section[@class='event-info']/h4/span[@class='time']/text()");
				Object locationObject[] = newNode.evaluateXPath("/section[@class='event-info']/div[@class='location']/text()");
				Object hostedByObject[] = newNode.evaluateXPath("/section[@class='event-info']/span[@class='association-name']/text()");
				Object chairObject[] = newNode.evaluateXPath("/section[@class='event-info']/ul/li[@class='presiding']/span[@class='name']/text()");
				
				StringBuilder titleString = (StringBuilder)titleObject[0];
				aeadao.setTitle(titleString.toString().trim());
				String nextLink = (String)detailLinkObject[0];
				aeadao.setNextLink("https://www.aeaweb.org/conference/2017/"+nextLink);
				
				getSubAea(aeadao.getNextLink(),aeadao);
				
				StringBuilder cateString = (StringBuilder)cateObject[0];
				aeadao.setCategory(cateString.toString().trim());
				
				if (dateObject.length>0) {
					StringBuilder dateBuilder = (StringBuilder)dateObject[0];
					aeadao.setDate(dateBuilder.toString().trim());
				}
				
				if (timeObject.length>0) {
					StringBuilder timeBuilder = (StringBuilder)timeObject[0];
					int start = timeBuilder.indexOf("&ndash;");
					timeBuilder.replace(start, start+7, "");
					aeadao.setTime(timeBuilder.toString().trim());
					
				}
				
				if (locationObject.length>0) {
					StringBuilder locationBuilder = (StringBuilder)locationObject[0];
					aeadao.setLocation(locationBuilder.toString().trim());
				}
				
				if (hostedByObject.length>0) {
					StringBuilder hostBuilder = (StringBuilder)hostedByObject[0];
					aeadao.setHostedBy(hostBuilder.toString().trim());
				}
				if (chairObject.length>0) {
					StringBuilder chairBuilder = (StringBuilder)chairObject[0];
					aeadao.setChair(chairBuilder.toString().trim());
				}
				
				listaAeaDaos.add(aeadao);
			}
			
		}
		
		print(listaAeaDaos);
		print2(listaAeaDaos);
		
	}
	
	private static void getSubAea(String nextLink,AeaDao aeaDao) throws Exception {
		List<SubAea> subAeas = new ArrayList<SubAea>();
		HtmlCleaner cleaner = new HtmlCleaner();
		URL url = new URL(nextLink);
		TagNode node = cleaner.clean(url);
		Object object[] = node.evaluateXPath("//section[@class='papers-group panelists-group']/article[@class='paper']");
		Object[] jelClassObjects = node.evaluateXPath("//div[@class='jel-codes']/ul/li/text()");
		
		List<String>jels = new ArrayList<String>();
		for (Object object2 : jelClassObjects) {
			StringBuilder jelBuilder = (StringBuilder)object2;
			jels.add(jelBuilder.toString().trim());
		} 
		aeaDao.setJelClf(jels);
		
		for (Object object2 : object) {
			SubAea subAea = new SubAea();
			TagNode newNode = (TagNode)object2;
			Object[] titleObject = newNode.evaluateXPath("/h3[@class='paper-title']/text()");
			Object[] authors = newNode.evaluateXPath("/section[@class='authors']/div[@class='author']");
			Object[] text = newNode.evaluateXPath("/section[@class='abstract']/text()");
			
			
			if (text.length>0) {
				StringBuilder textBuilder = (StringBuilder)text[0];
				String textString = textBuilder.substring(9);
				subAea.setText(textString.trim());
			}
			
			if (titleObject.length>0) {
				StringBuilder titleBuilder = (StringBuilder) titleObject[0];
				subAea.setTitle(titleBuilder.toString().trim());
			}
			
			List<Attendee> attendees = new ArrayList<Attendee>();
			for (Object object3 : authors) {
				Attendee attendee = new Attendee();
				TagNode tagNode = (TagNode)object3;
				Object[] names = tagNode.evaluateXPath("/div[@class='name']/text()");
				Object[] organization = tagNode.evaluateXPath("/div[@class='organization']/text()");
				if (names.length>0) {
					StringBuilder nameBuilder = (StringBuilder)names[0];
					attendee.setName(nameBuilder.toString().trim());
				}
				if (organization.length>0) {
					StringBuilder organBuilder = (StringBuilder)organization[0];
					attendee.setInstitute(organBuilder.toString().trim());
				}
				attendees.add(attendee);
			}
			subAea.setListAttendees(attendees);
			subAeas.add(subAea);
		}
		
		aeaDao.setSubAeas(subAeas);
	}

	public  static void print(List<AeaDao> aeaDaos) throws Exception {
		String reg = "bang|ba[ino]?|beng|be[in]?|bing|bia[no]?|bi[en]?|bu|cang|ca[ino]?|ceng|ce[in]?|chang|cha[ino]?|cheng|che[n]?|chi|chong|chou|chuang|chua[in]|chu[ino]?|ci|cong|cou|cuan|cu[ino]?|dang|da[ino]?|deng|de[in]?|dia[no]?|ding|di[ae]?|dong|dou|duan|du[ino]?|fang|fan|fa|feng|fe[in]{1}|fo[u]?|fu|gang|ga[ino]?|geng|ge[in]?|gong|gou|guang|gua[in]?|gu[ino]?|hang|ha[ino]?|heng|he[in]?|hong|hou|huang|hua[in]?|hu[ino]?|jiang|jia[no]?|jiong|ji[nu]?|juan|ju[en]?|kang|ka[ino]?|keng|ke[n]?|kong|kou|kuang|kua[in]?|ku[ino]?|lang|la[ino]?|leng|le[i]?|liang|lia[no]?|ling|li[enu]?|long|lou|luan|lu[no]?|lv[e]?|mang|ma[ino]?|meng|me[in]?|mia[no]?|ming|mi[nu]?|mo[u]?|mu|nang|na[ino]?|neng|ne[in]?|niang|nia[no]?|ning|ni[enu]?|nong|nou|nuan|nu[on]?|nv[e]?|pang|pa[ino]?|pa|peng|pe[in]?|ping|pia[no]?|pi[en]?|po[u]?|pu|qiang|qia[no]?|qiong|qing|qi[aenu]?|quan|qu[en]?|rang|ra[no]{1}|reng|re[n]?|rong|rou|ri|ruan|ru[ino]?|sang|sa[ino]?|seng|se[n]?|shang|sha[ino]?|sheng|she[in]?|shi|shou|shuang|shua[in]?|shu[ino]?|si|song|sou|suan|su[ino]?|tang|ta[ino]?|teng|te|ting|ti[e]?|tia[no]?|tong|tou|tuan|tu[ino]?|wang|wa[ni]?|weng|we[in]{1}|w[ou]{1}|xiang|xia[no]?|xiong|xing|xu|xi[enu]?|xuan|xu[en]|yang|ya[no]?|ye|ying|yi[n]?|yong|you|yo|yuan|yu|yu[en]?|zang|za[ino]?|zeng|ze[in]?|zhang|zha[ino]?|zheng|zhe[in]?|zhi|zhong|zhou|zhuang|zhua[in]?|zhu[ino]?|zi|zong|zou|zuan|zu[ino]?";
		
		File dicFile = new File("university.txt");
		 List<String> diclist = new ArrayList<String>();
		 BufferedReader reader2 = new BufferedReader(new FileReader(dicFile));
		 String readInput = "";
		 while((readInput=reader2.readLine())!=null){
			 diclist.add(readInput);
		 }
		 reader2.close();
		
		File file = new File("E:/aea/5.csv");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write("title\t" + "category\t" + "date\t" + "time\t"+"location\t"+"hostby\t"+"jel\t"+"title\t"+"author1\t"+"isChinese\t"+"affiliation1\t" + "is-university\t" +"author2\t"+"is-Chinese\t"+"affiliation2\t"+"is-university\t"+"author3\t"+"is-chinese\t"+"affiliation3\t"+"is-university\t"+"author4\t"+"is-chinese\t"+"affiliation4\t"+"is-university\t"+"author5\t"+"is-chinese\t"+"affiliation5\t"+"is-university\t");
		writer.newLine();
		for (AeaDao aeaDao : aeaDaos) {
			List<SubAea> subAeas = aeaDao.getSubAeas();
			//如果某些session没有子菜单，则输出一级菜单。
			if (subAeas.size()<=0) {
				writer.write(aeaDao.getTitle()+"\t");
				writer.write(aeaDao.getCategory()+"\t");
				writer.write(aeaDao.getDate()+"\t");
				writer.write(aeaDao.getTime()+"\t");
				writer.write(aeaDao.getLocation()+"\t");
				writer.write(aeaDao.getHostedBy()+"\t");
				List<String> jel = aeaDao.getJelClf();
				for (String string : jel) {
					writer.write(string+"  ");
				}
				writer.write("\t");
				writer.newLine();
			}
			
			for (SubAea subAea : subAeas) {
				//重复输出
				writer.write(aeaDao.getTitle()+"\t");
				writer.write(aeaDao.getCategory()+"\t");
				writer.write(aeaDao.getDate()+"\t");
				writer.write(aeaDao.getTime()+"\t");
				writer.write(aeaDao.getLocation()+"\t");
				writer.write(aeaDao.getHostedBy()+"\t");
				List<String> jel = aeaDao.getJelClf();
				for (String string : jel) {
					writer.write(string+"  ");
				}
				writer.write("\t");
				//
				writer.write(subAea.getTitle()+"\t");
//				writer.write(subAea.getText()+"\t");
				List<Attendee> attendees = subAea.getListAttendees();
				for (Attendee attendee : attendees) {
					writer.write(attendee.getName()+"\t");
					String listStr[] = attendee.getName().split("              ");
					if (listStr.length>1) {
						if (listStr[1].toLowerCase().matches(reg)) {
							writer.write("chinese"+"\t");
						}else {
							writer.write("non-chinese"+"\t");
						}
					}else {
						writer.write("non-chinese"+"\t");
					}
					writer.write(attendee.getInstitute()+"\t");
					boolean flag = true;
					for (String string : diclist) {
						if (attendee.getInstitute().toLowerCase().contains(string.toLowerCase())) {
							writer.write("university\t");
							flag = false;
							break;
						}
					}
					if (flag) {
						writer.write("non-university\t");
					}
				}
				writer.newLine();
			}
		}
		writer.flush();
		writer.close();
	}
	
	public  static void print2(List<AeaDao> aeaDaos) throws Exception {
		String reg = "bang|ba[ino]?|beng|be[in]?|bing|bia[no]?|bi[en]?|bu|cang|ca[ino]?|ceng|ce[in]?|chang|cha[ino]?|cheng|che[n]?|chi|chong|chou|chuang|chua[in]|chu[ino]?|ci|cong|cou|cuan|cu[ino]?|dang|da[ino]?|deng|de[in]?|dia[no]?|ding|di[ae]?|dong|dou|duan|du[ino]?|fang|fan|fa|feng|fe[in]{1}|fo[u]?|fu|gang|ga[ino]?|geng|ge[in]?|gong|gou|guang|gua[in]?|gu[ino]?|hang|ha[ino]?|heng|he[in]?|hong|hou|huang|hua[in]?|hu[ino]?|jiang|jia[no]?|jiong|ji[nu]?|juan|ju[en]?|kang|ka[ino]?|keng|ke[n]?|kong|kou|kuang|kua[in]?|ku[ino]?|lang|la[ino]?|leng|le[i]?|liang|lia[no]?|ling|li[enu]?|long|lou|luan|lu[no]?|lv[e]?|mang|ma[ino]?|meng|me[in]?|mia[no]?|ming|mi[nu]?|mo[u]?|mu|nang|na[ino]?|neng|ne[in]?|niang|nia[no]?|ning|ni[enu]?|nong|nou|nuan|nu[on]?|nv[e]?|pang|pa[ino]?|pa|peng|pe[in]?|ping|pia[no]?|pi[en]?|po[u]?|pu|qiang|qia[no]?|qiong|qing|qi[aenu]?|quan|qu[en]?|rang|ra[no]{1}|reng|re[n]?|rong|rou|ri|ruan|ru[ino]?|sang|sa[ino]?|seng|se[n]?|shang|sha[ino]?|sheng|she[in]?|shi|shou|shuang|shua[in]?|shu[ino]?|si|song|sou|suan|su[ino]?|tang|ta[ino]?|teng|te|ting|ti[e]?|tia[no]?|tong|tou|tuan|tu[ino]?|wang|wa[ni]?|weng|we[in]{1}|w[ou]{1}|xiang|xia[no]?|xiong|xing|xu|xi[enu]?|xuan|xu[en]|yang|ya[no]?|ye|ying|yi[n]?|yong|you|yo|yuan|yu|yu[en]?|zang|za[ino]?|zeng|ze[in]?|zhang|zha[ino]?|zheng|zhe[in]?|zhi|zhong|zhou|zhuang|zhua[in]?|zhu[ino]?|zi|zong|zou|zuan|zu[ino]?";
		
		File dicFile = new File("university.txt");
		 List<String> diclist = new ArrayList<String>();
		 BufferedReader reader2 = new BufferedReader(new FileReader(dicFile));
		 String readInput = "";
		 while((readInput=reader2.readLine())!=null){
			 diclist.add(readInput);
		 }
		 reader2.close();
		
		File file = new File("E:/aea/6.csv");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write("title\t" + "category\t" + "date\t" + "time\t"+"location\t"+"hostby\t"+"jel\t"+"title\t"+""+"author1\t"+"is-chinese\t"+"affiliation1\t"+"is-university\t");
		writer.newLine();
		for (AeaDao aeaDao : aeaDaos) {
			List<SubAea> subAeas = aeaDao.getSubAeas();
			
			//如果某些session没有子菜单，则输出一级菜单。
			if (subAeas.size()<=0) {
				writer.write(aeaDao.getTitle()+"\t");
				writer.write(aeaDao.getCategory()+"\t");
				writer.write(aeaDao.getDate()+"\t");
				writer.write(aeaDao.getTime()+"\t");
				writer.write(aeaDao.getLocation()+"\t");
				writer.write(aeaDao.getHostedBy()+"\t");
				List<String> jel = aeaDao.getJelClf();
				for (String string : jel) {
					writer.write(string+"  ");
				}
				writer.write("\t");
				writer.newLine();
			}
			
			for (SubAea subAea : subAeas) {
				
				List<Attendee> attendees = subAea.getListAttendees();
				for (Attendee attendee : attendees) {
					//重复输出
					writer.write(aeaDao.getTitle()+"\t");
					writer.write(aeaDao.getCategory()+"\t");
					writer.write(aeaDao.getDate()+"\t");
					writer.write(aeaDao.getTime()+"\t");
					writer.write(aeaDao.getLocation()+"\t");
					writer.write(aeaDao.getHostedBy()+"\t");
					List<String> jel = aeaDao.getJelClf();
					for (String string : jel) {
						writer.write(string+"  ");
					}
					writer.write("\t");
					//
					writer.write(subAea.getTitle()+"\t");
					//writer.write(subAea.getText()+"\t");
					writer.write(attendee.getName()+"\t");
					String listStr[] = attendee.getName().split("              ");
					if (listStr.length>1) {
						if (listStr[1].toLowerCase().matches(reg)) {
							writer.write("chinese"+"\t");
						}else {
							writer.write("non-chinese"+"\t");
						}
					}else {
						writer.write("non-chinese"+"\t");
					}
					writer.write(attendee.getInstitute()+"\t");
					boolean flag = true;
					for (String string : diclist) {
						if (attendee.getInstitute().toLowerCase().contains(string.toLowerCase())) {
							writer.write("university\t");
							flag = false;
							break;
						}
					}
					if (flag) {
						writer.write("non-university\t");
					}
					writer.newLine();
				}
				
			}
		}
		writer.flush();
		writer.close();
	}
}
