package at.ac.fhcampuswien.csdc21bb.group3.domain;

import java.util.ArrayList;
import java.util.Iterator;

public class BookmarkTool {

    ArrayList<Bookmark> bookmarks;

    public BookmarkTool() {
        this.bookmarks = new ArrayList<>();
    }

    public int addBookmark(Bookmark bookmark) {
        // is bookmark present
        int idx = -1;
        for (int i = 0, bookmarksSize = bookmarks.size(); i < bookmarksSize; i++) {
            Bookmark b = bookmarks.get(i);
            if (b.equals(bookmark))
                idx = i;
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
}
