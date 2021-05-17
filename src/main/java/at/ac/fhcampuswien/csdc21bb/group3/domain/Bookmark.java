package at.ac.fhcampuswien.csdc21bb.group3.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Bookmark {
    private ArrayList<String> tags;
    private URL url;
    private int rating;

    public Bookmark(String url) throws MalformedURLException {
        this(url, new ArrayList<String>());
    }

    public Bookmark(String url, ArrayList<String> tags) throws MalformedURLException {
        this.url = new URL(url);
        this.tags = tags;
        this.rating = 0;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public int getRating() {
        return this.rating;
    }

    public void increaseRating() {
        this.rating++;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "tags=" + tags +
                ", url=" + url +
                ", rating=" + rating +
                '}';
    }

    public boolean isURLSecure() {
        return this.url.getProtocol().equals("https");
    }
}
