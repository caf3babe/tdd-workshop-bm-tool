package at.ac.fhcampuswien.csdc21bb.group3;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main (String [] args) throws MalformedURLException {
        String urlString = "https://www.orf.at";
        URL url = BookmarkTool.validateURL(urlString);
        BookmarkTool bookmarkTool = new BookmarkTool();
        bookmarkTool.addURL(urlString);
        bookmarkTool.getBookmarks().forEach(System.out::println);
        System.out.println(bookmarkTool.getBookmarkByURL(url).getRating());
        bookmarkTool.addURL(urlString);
        bookmarkTool.getBookmarks().forEach(System.out::println);
        System.out.println(bookmarkTool.getBookmarkByURL(url).getRating());
    }
}
