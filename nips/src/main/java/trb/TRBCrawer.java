package trb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class TRBCrawer {
	public static Map<String,Integer> authorMap = new HashMap<String, Integer>();
	
	public TRBCrawer() {
		
	}
	public static void craw() {
		int start  = 1130822;
		int end = 1439069;
		HtmlCleaner cleaner = new HtmlCleaner();
		authorMap.put("Byrum, Christopher R", 1);
		
		for (int i = start; i <=end; i++) {
			String url = "http://pubsindex.trb.org/view/2017/C/" + i;
			try {
				URL url2 = new URL(url);
				TagNode node = cleaner.clean(url2);
				Object object[] = node.evaluateXPath("//*[@id='publicationView']/div[2]/div[2]/div/text()");
				//accessNumber
				StringBuilder accessNumber = new StringBuilder("0000000");
				if (object.length>=1) {
					accessNumber = (StringBuilder )object[0];
					System.out.println(accessNumber);
				}
				//作者列表
				Object authorObject[] = node.evaluateXPath("//div[@id='publicationView']/div[@class='recordWrapper']/div[12]//h6/text()");
				for (Object author : authorObject) {
					StringBuilder authorBuilder = (StringBuilder)author;
					if (authorMap.containsKey(authorBuilder.toString())) {
						String authorString  = (String) authorBuilder.toString();
						Integer integer = authorMap.get(authorString) + 1;
						authorMap.put(authorString, integer);
					}else {
						String authorString  = (String) authorBuilder.toString();
						authorMap.put(authorString,1);
					}
				}
								
			} catch (Exception e) {				
							
			}
		}
	}
	
	public static void print() throws IOException {
		File file = new File("E:\\haha.csv");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Map.Entry<String, Integer> entry:authorMap.entrySet()) {
			writer.write(entry.getKey()+"	"+entry.getValue()+"\r\n");
			System.out.println(entry.getKey()+"	"+entry.getValue());
		}
		writer.close();
		
	}
	
	public static void sort() {
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(authorMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
		});
	}
	
	public static void main(String[] args) {
		craw();
		
		//sort();
		try {
			print();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
