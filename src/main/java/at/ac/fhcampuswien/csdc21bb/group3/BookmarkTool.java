package at.ac.fhcampuswien.csdc21bb.group3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BookmarkTool {

    ArrayList<Bookmark> bookmarks;

    public BookmarkTool() {
        this.bookmarks = new ArrayList<>();
    }

    public static URL validateURL(String urlString) throws MalformedURLException {
        return new URL(urlString);
    }

    public boolean addURL(String urlString) throws MalformedURLException {
        URL url = validateURL(urlString);
        this.bookmarks.add(new Bookmark(url));
        return true;
    }

    public ArrayList<Bookmark> getBookmarks() {
        return this.bookmarks;
    }
}
