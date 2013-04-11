package de.littlerolf.crawlomat;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebLink;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, SAXException {
        HttpUnitOptions.setScriptingEnabled(false);

        System.out.println("Starting to Crawl!");
        WebCrawler crawler = new WebCrawler("https://hgo-ol.de/idesk", 4);
        System.out.println("Crawling finished, here are your URLs:");
        for (WebLink link : crawler) {
            System.out.println(link.getURLString());
        }

    }
}
