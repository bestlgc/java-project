package nips;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class NipsAnalyser {
	public static void main(String[] args) throws Exception {  
        HtmlCleaner cleaner = new HtmlCleaner();  
        URL url = new URL("http://papers.nips.cc/book/advances-in-neural-information-processing-systems-29-2016");
        File file = new File("E:/nips2016.csv");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        
        TagNode node = cleaner.clean(url);
       
        Object[] ns = node.evaluateXPath("//div[@class='main wrapper clearfix']/ul/li");  
        
        for(Object on : ns) {  
            TagNode n = (TagNode) on;
            Object[] liList = n.evaluateXPath("/a/text()");
            for (Object object : liList) {
            	StringBuilder  liNode = (StringBuilder)object;
            	writer.write(liNode+",");
            	
			}
            writer.newLine();
//            System.out.println("\ttext="+n.getText());  
        }  
        writer.flush();
        writer.close();
        
    }  
}
