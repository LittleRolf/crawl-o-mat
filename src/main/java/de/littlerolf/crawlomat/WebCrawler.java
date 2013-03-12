package de.littlerolf.crawlomat;

import java.util.Iterator;

class WebCrawler implements Iterable<String> {

    private String url;

    public WebCrawler(String url) {
        this.url = url;
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = new Iterator<String>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return null;
            }

            @Override
            public void remove() {

            }
        };
        return it;
    }
}