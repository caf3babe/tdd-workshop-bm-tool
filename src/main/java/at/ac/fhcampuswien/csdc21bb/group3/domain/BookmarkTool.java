package at.ac.fhcampuswien.csdc21bb.group3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class BookmarkTool {

    private ArrayList<Bookmark> bookmarks;

    public BookmarkTool() {
        this.bookmarks = new ArrayList<>();
    }

    public int addBookmark(Bookmark bookmark) {
        // is bookmark present
        int idx = -1;
        for (int i = 0, bookmarksSize = bookmarks.size(); i < bookmarksSize; i++) {
            Bookmark b = bookmarks.get(i);
            if (b.getURL().toString().equals(bookmark.getURL().toString())) {
                idx = i;
                break;
            }
        }

        // unequal -1 means bookmark found in list
        if(idx != -1){
            bookmarks.get(idx).increaseRating();
        } else {
            this.bookmarks.add(bookmark);
        }

        return this.bookmarks.size();
    }

    public Bookmark getBookmark(Bookmark bookmark) {
        Bookmark found = null;

        for(Bookmark b : this.bookmarks){
            if(b.equals(bookmark)){
                found = b;
            }
        }
        return found;
    }

    public int getSecureURLsAmount() {
        int httpsUrlsAmount = 0;

        Iterator<Bookmark> iterator = bookmarks.iterator();
        Bookmark bookmark;
        while(iterator.hasNext()){
            bookmark = iterator.next();
            if(bookmark.isURLSecure()) httpsUrlsAmount++ ;
        }

        return httpsUrlsAmount;
    }

    public ArrayList<Bookmark> getAssociatedBookmarks(Bookmark bookmark) {
        ArrayList<Bookmark> associatedBookmarks = new ArrayList<>();
        for(Bookmark b : this.bookmarks){
            if(b.getURL().getHost().equals(bookmark.getURL().getHost())) associatedBookmarks.add(b);
        }
        return associatedBookmarks;
    }

    public ArrayList<Bookmark> getBookmarks() {
        return this.bookmarks;
    }

    public ArrayList<Bookmark> filterByKeywords(String... keywords) {
        ArrayList<Bookmark> filteredBookmarks = new ArrayList<>();

        for (String keyword : keywords) {
            for (Bookmark b : this.bookmarks) {
                if (b.getURL().toString().contains(keyword))
                    // ensure single entry of each bookmark
                    if (!filteredBookmarks.contains(b)) filteredBookmarks.add(b);
            }
        }

        return filteredBookmarks;
    }

    public void removeBookmark(Bookmark bookmark) {
        this.bookmarks.removeIf(bookmark1 -> bookmark1.getURL().toString()
                .equals(bookmark.getURL().toString())
        );
    }

    public void sortBookmarkListByRate() {
        bookmarks.sort((o1, o2) -> Integer.compare(o2.getRating(), o1.getRating()));
    }
}
