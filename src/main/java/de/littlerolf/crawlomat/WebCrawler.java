package de.littlerolf.crawlomat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.xml.sax.SAXException;

import com.meterware.httpunit.*;



class WebCrawler implements Iterable<String> {

    private String url;
    
    private List<String> LinkList = new ArrayList<String>();
    

    public WebCrawler(String url) {
        this.url = url;
    }
    
    public void crawl(int depth) throws MalformedURLException {
    	WebLink[] list = getLinksFromSite(this.url);
    	WebLink[] toCrawl;
    	
    	for (int i = depth;i>0;i--) { //For each depth one time
    		//TODO: Implement depth-first search with depth as depth...

    	}
    }
    

    
    public WebLink[] getLinksFromSite(String url) {
    	try {
    		
        WebConversation conversation = new WebConversation();
        WebRequest request = new GetMethodWebRequest(url);

        WebResponse response = conversation.getResponse(request);
        return response.getLinks();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (SAXException e) {
			e.printStackTrace();
			return null;
		}
        
        
    	
    }

    public Iterator<String> iterator() {
        Iterator<String> it = new Iterator<String>() {

            public boolean hasNext() {
                return false;
            }

            public String next() {
                return null;
            }

            public void remove() {

            }
        };
        return it;
    }
}