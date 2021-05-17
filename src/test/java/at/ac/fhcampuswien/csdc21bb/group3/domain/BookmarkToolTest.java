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

    @Test
    public void ensureRightAmountOfSecureURLsInBookmarkList() throws MalformedURLException {
        Bookmark b1 = new Bookmark("https://www.orf.at");
        Bookmark b2 = new Bookmark("https://www.fh-campuswien.ac.at");
        Bookmark b3 = new Bookmark("http://www.google.at");
        BookmarkTool bookmarkTool = new BookmarkTool();
        bookmarkTool.addBookmark(b1);
        bookmarkTool.addBookmark(b2);
        bookmarkTool.addBookmark(b3);

        int expectedAmount = 2;
        int actualAmount = bookmarkTool.getSecureURLsAmount();

        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void ensureBookmarksGetAssociatedWhenSameDomain() throws MalformedURLException {
        Bookmark b1 = new Bookmark("https://www.orf.at/basti-hats-verkackt");
        Bookmark b2 = new Bookmark("https://www.orf.at/api/rest/v1/");
        Bookmark b3 = new Bookmark("https://www.orf.at");
        Bookmark b4 = new Bookmark("https://www.fh-campuswien.ac.at/api/rest/v1/");
        Bookmark b5 = new Bookmark("https://www.moodle.fh-campuswien.ac.at");

        BookmarkTool bookmarkTool = new BookmarkTool();
        bookmarkTool.addBookmark(b1);
        bookmarkTool.addBookmark(b2);
        bookmarkTool.addBookmark(b3);
        bookmarkTool.addBookmark(b4);
        bookmarkTool.addBookmark(b5);

        Bookmark b6 = new Bookmark("https://www.orf.at");

        int expected = 3;
        int actual = bookmarkTool.getAssociatedBookmarks(b6).size();

        assertEquals(expected, actual);
    }

}