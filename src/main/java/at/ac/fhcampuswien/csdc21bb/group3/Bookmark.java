package at.ac.fhcampuswien.csdc21bb.group3;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Bookmark {
    private ArrayList<String> tags;
    private URL url;

    public Bookmark(URL url) {
        this.url = url;
    }

    public Bookmark(URL url, ArrayList<String> tags) {
        this.url = url;
        this.tags = tags;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }
}
