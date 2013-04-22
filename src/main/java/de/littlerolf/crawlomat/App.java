package de.littlerolf.crawlomat;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebLink;

import java.net.MalformedURLException;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HttpUnitOptions.setScriptingEnabled(false);

        System.out.println("Starting to Crawl!");
        try {
        WebCrawler crawler = new WebCrawler("http://www.heise.de", 2);

        System.out.println("Crawling finished, here are your URLs:");
        for (WebLink link : crawler) {
                System.out.println(link.getRequest().getURL());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
