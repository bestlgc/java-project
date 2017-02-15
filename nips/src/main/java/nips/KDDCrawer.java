package nips;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class KDDCrawer {
	public static void main(String[] args) throws Exception {  
        HtmlCleaner cleaner = new HtmlCleaner();  
        URL url = new URL("http://www.kdd.org/kdd2016/program/accepted-papers");
        TagNode node = cleaner.clean(url);
       
        Object[] ns = node.evaluateXPath("//table[@class='table table-hover table-striped table-bordered']/tbody/tr"); 
        File file = new File("E:/kdd2016.csv");
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        
        for(Object on : ns) {  
    
			TagNode n = (TagNode) on;
            Object[] nextLinks = n.evaluateXPath("/td/strong/a[1]/@href");
            Object[] authors = n.evaluateXPath("/td/small");
            Object[] titles = n.evaluateXPath("/td/strong/a/span");
            
            String nextLink = (String)nextLinks[0];
            TagNode author = (TagNode) authors[0];
            TagNode title = (TagNode)titles[0];
            
            URL nextUrl = new URL(nextLink);
            TagNode PDFnode = cleaner.clean(nextUrl);
            Object[] pdfObject = PDFnode.evaluateXPath("//section[@class='bs-docs-section']/a/@href");
            String pdfLink = (String)pdfObject[0];
            CharSequence titleSequence = title.getText();
            String titleStr = (String)titleSequence.subSequence(0, titleSequence.length());
            writer.write(titleStr+",");
            
            //分离作者
            CharSequence authorSeq = author.getText();
            String authorStr = (String)authorSeq.subSequence(10, authorSeq.length());
            String[] authorStrings = authorStr.split(";");
            for (int i = 0; i <=5; i++) {
            	String institute="";
            	String author1="";
            	if (i<authorStrings.length) {
            		String tempString[] = authorStrings[i].split(",");
    				author1 = tempString[0];
    				
    				if (tempString.length>=2) {
    					 institute = tempString[1];
    				}
				}
				
				writer.write(author1+",");
				writer.write(institute+",");
				System.out.println("作者："+ author1);
				System.out.println("组织："+ institute);
			}
            
            writer.write(pdfLink);
            writer.newLine();
            System.out.println("nextlink is : "+nextLink);
            System.out.println("authors is: " + author.getText());
            System.out.println("title is :" + title.getText());
            System.out.println("pdf is :" + pdfLink);
            
//            for (Object object : nextLinks) {
//            	String  liNode = (String)object;
//            	System.out.println("\ttext="+liNode);  
//			}
            //System.out.println("\ttext="+n.getText());  
        }  
        writer.flush();
        writer.close();
    }  
}
