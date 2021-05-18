package at.ac.fhcampuswien.csdc21bb.group3.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bookmark {
    private ArrayList<String> tags;
    private URL url;
    private int rating;
    private LocalDateTime date;

    public Bookmark(String url) throws MalformedURLException {
        this(url, new ArrayList<>());
    }

    public Bookmark(String url, ArrayList<String> tags) throws MalformedURLException {
        this.url = new URL(url);
        this.tags = tags;
        this.rating = 1;
        this.date = LocalDateTime.now();
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

    public URL getURL() {
        return this.url;
    }

    public void addTag(String tag) {
        if (!this.tags.contains(tag)) this.tags.add(tag);
    }

    public void removeTag(String tag) {
        this.tags.remove(tag);
    }

    public LocalDateTime getDate() {
        return this.date;
    }
}
