package de.littlerolf.crawlomat;

import com.meterware.httpunit.*;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, SAXException {
        System.out.println("Test");
    	HttpUnitOptions.setScriptingEnabled(false);
        WebCrawler crawler = new WebCrawler("http://google.de");

        //Test:
        for (WebLink link :crawler.getLinksFromSite("www.google.de")) {
        	System.out.println(link.getRequest().getURL().toString());
        }
        
        
        for (String page : crawler) {
            System.out.println(page);
        }

        //Test:
/*
        WebConversation conversation = new WebConversation();

        WebRequest request = new GetMethodWebRequest("http://google.de");

        WebResponse response = conversation.getResponse(request);
        for (WebLink link : response.getLinks())
            System.out.println(link.getRequest().getURL().toString());*/
    }
}
