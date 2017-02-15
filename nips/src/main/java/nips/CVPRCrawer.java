package nips;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class CVPRCrawer {
	public static void main(String[] args) throws Exception {  
        HtmlCleaner cleaner = new HtmlCleaner();  
        URL url = new URL("http://www.cv-foundation.org/openaccess/CVPR2014.py");
        File file = new File("E:/cvpr2014.csv");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        
        TagNode node = cleaner.clean(url);
       
        int count = 1;
        Object[] ns = node.evaluateXPath("//div[@id='content']/dl/dt/a/text()");          
        for(Object on : ns) {  
        	StringBuilder title = (StringBuilder)on;
        	writer.write(title+",");
        	System.out.println(title);
        	String authorXpath = "//div[@id='content']/dl/dd[" + (count++)+"]/form/a/text()";
        	String pdfXpath = "//div[@id='content']/dl/dd[" + (count++)+"]/a[1]/@href";
        	
        	Object authorObject[] = node.evaluateXPath(authorXpath);
        	Object PdfObject[] = node.evaluateXPath(pdfXpath);
        	String pdf = (String) PdfObject[0];
        	writer.write("http://www.cv-foundation.org/openaccess/"+pdf+",");
            
            for (Object object : authorObject) {
            	StringBuilder  author = (StringBuilder)object;
            	writer.write(author+",");
            	
			}
            writer.newLine();
//            System.out.println("\ttext="+n.getText());  
        }  
        writer.flush();
        writer.close();
        
    }  
}
