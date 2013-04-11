package de.littlerolf.crawlomat;

import com.meterware.httpunit.*;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class WebCrawler implements Iterable<WebLink> {

    private String targetURL;
    private int maxDepth;
    private List<WebLink> linkList = new ArrayList<WebLink>();


    public WebCrawler(String targetURL, int maxDepth) {
        this.targetURL = targetURL;
        this.maxDepth = maxDepth;

        init();
    }

    private void init() {
        linkList.addAll(crawlURL(getLinksFromSite(this.targetURL), 1));
    }

    private List<WebLink> crawlURL(WebLink[] links, int depth) {
        if (depth >= maxDepth) return null;
        depth++;
        List<WebLink> returnLinks = new ArrayList<WebLink>();
        for (WebLink link : links) {
            WebLink[] resultLinks = getLinksFromSite(link.getURLString());
            if (resultLinks == null) continue;
            for (WebLink resLink : resultLinks) {
                returnLinks.add(resLink);
            }
            this.crawlURL(resultLinks, depth);
        }
        return returnLinks;
    }

    public WebLink[] getLinksFromSite(String url) {
        try {
            if (!(url.startsWith("http"))) return null;
            WebConversation conversation = new WebConversation();
            WebRequest request = new GetMethodWebRequest(url);

            WebResponse response = conversation.getResponse(request);
            List<WebLink> list = new ArrayList<WebLink>();

            for (WebLink link : response.getLinks()) {
                if (!linkList.contains(link))
                    list.add(link);
            }

            return list.toArray(new WebLink[list.size()]);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        } catch (HttpNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (HttpException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }


    }

    public Iterator<WebLink> iterator() {
        return linkList.iterator();
    }
}