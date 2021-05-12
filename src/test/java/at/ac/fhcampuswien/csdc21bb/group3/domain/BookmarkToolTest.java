package at.ac.fhcampuswien.csdc21bb.group3.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;

class BookmarkToolTest {

    @Test
    public void ensureBookmarkIsAdded() throws MalformedURLException {
        Bookmark bookmark = new Bookmark("https://www.orf.at");
        BookmarkTool bookmarkTool = new BookmarkTool();

        assertEquals(1, bookmarkTool.addBookmark(bookmark));
    }

    @Test
    public void ensureSingleEntryWhenBookmarkAlreadyPresent() throws MalformedURLException {
        Bookmark bookmark = new Bookmark("https://www.orf.at");
        BookmarkTool bookmarkTool = new BookmarkTool();

        int sizeOfBookmarkListAfterFirstEntry = bookmarkTool.addBookmark(bookmark);
        int sizeOfBookmarkListAfterSecondEntry = bookmarkTool.addBookmark(bookmark);

        assertEquals(sizeOfBookmarkListAfterFirstEntry, sizeOfBookmarkListAfterSecondEntry);
    }

    @Test
    public void increaseRatingOfBookmarkWhenBookmarkAlreadyExists() throws MalformedURLException {
        Bookmark bookmark = new Bookmark("https://www.orf.at");
        BookmarkTool bookmarkTool = new BookmarkTool();

        bookmarkTool.addBookmark(bookmark);
        int ratingAfterFirstInsert = bookmarkTool.getBookmark(bookmark).getRating();

        bookmarkTool.addBookmark(bookmark);
        int ratingAfterSecondInsert = bookmarkTool.getBookmark(bookmark).getRating();

        assertTrue(ratingAfterFirstInsert < ratingAfterSecondInsert);
    }
}