package de.littlerolf.crawlomat;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler("http://google.de");

        for (String page : crawler) {
            System.out.println(page);
        }
    }
}
