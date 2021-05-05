package at.ac.fhcampuswien.csdc21bb.group3;

import java.awt.print.Book;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

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

        // if no bookmark with this url is present
        if (this.bookmarks.stream().noneMatch(bookmark -> bookmark.getUrl().equals(url))) {
            this.bookmarks.add(new Bookmark(url));
        } else {
            this.bookmarks.stream().filter(bookmark -> bookmark.getUrl().equals(url)).findFirst().ifPresent(Bookmark::increaseRating);
            // this.bookmarks.get().increaseRating();
        }
        return true;
    }

    public ArrayList<Bookmark> getBookmarks() {
        return this.bookmarks;
    }

    public Bookmark getBookmarkByURL(URL url) {
        Optional<Bookmark> presentBookmark = this.bookmarks.stream().filter(bookmark -> bookmark.getUrl().equals(url)).findFirst();
        return presentBookmark.orElse(null);
    }
}
