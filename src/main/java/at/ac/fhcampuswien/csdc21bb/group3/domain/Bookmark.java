package at.ac.fhcampuswien.csdc21bb.group3.domain;

import jdk.vm.ci.meta.Local;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Bookmark {
    private ArrayList<String> tags;
    private URL url;
    private int rating;
    private LocalDateTime creationDate;

    public Bookmark(String url) throws MalformedURLException {
        this(url, LocalDateTime.now(), new ArrayList<>());
    }

    public Bookmark(String url, LocalDateTime creationDate) throws MalformedURLException {
        this(url, creationDate, new ArrayList<>());
    }

    public Bookmark(String url, ArrayList<String> tags) throws MalformedURLException {
        this(url, LocalDateTime.now(), tags);
    }

    public Bookmark(String url, LocalDateTime creationDate, ArrayList<String> tags) throws MalformedURLException {
        this.url = new URL(url);
        this.tags = tags;
        this.rating = 1;
        this.creationDate = creationDate;
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

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

}

