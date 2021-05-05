package at.ac.fhcampuswien.csdc21bb.group3;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Bookmark {
    private ArrayList<String> tags;
    private URL url;
    private int rating;

    public Bookmark(URL url) {
        this.url = url;
        this.rating = 0;
    }

    public Bookmark(URL url, ArrayList<String> tags) {
        this.url = url;
        this.tags = tags;
        this.rating = 0;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public URL getUrl() {
        return this.url;
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
}
