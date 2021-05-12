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
    public void ensureAddingBookmarkWhichIsNotInTheBookmarksList() throws MalformedURLException {
        Bookmark b1 = new Bookmark("https://www.orf.at");
        Bookmark b2 = new Bookmark("https://www.fh-campuswien.ac.at");
        BookmarkTool bookmarkTool = new BookmarkTool();

        bookmarkTool.addBookmark(b1);
        bookmarkTool.addBookmark(b1);
        int listSize = bookmarkTool.addBookmark(b2);

        assertEquals(2, listSize);
    }

    @Test
    public void getBookmarkWhichWasNeverAdded() throws MalformedURLException {
        Bookmark b1 = new Bookmark("https://www.orf.at");
        Bookmark b2 = new Bookmark("https://www.fh-campuswien.ac.at");
        BookmarkTool bookmarkTool = new BookmarkTool();

        bookmarkTool.addBookmark(b1);

        assertNull(bookmarkTool.getBookmark(b2));
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