package at.ac.fhcampuswien.csdc21bb.group3.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.util.ArrayList;

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

    @Test
    public void filterBookmarksByOneKeyword() throws MalformedURLException {
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

        BookmarkTool expectedBookmarkTool = new BookmarkTool();
        expectedBookmarkTool.addBookmark(b2);
        expectedBookmarkTool.addBookmark(b4);
        ArrayList<Bookmark> expectedBookmarks = expectedBookmarkTool.getBookmarks();

        ArrayList<Bookmark> actualBookmarks = bookmarkTool.filterByKeywords("rest");

        assertEquals(expectedBookmarks, actualBookmarks);

    }

    @Test
    public void filterBookmarksByMultipleKeywords() throws MalformedURLException {
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

        BookmarkTool expectedBookmarkTool = new BookmarkTool();
        expectedBookmarkTool.addBookmark(b2);
        expectedBookmarkTool.addBookmark(b4);
        expectedBookmarkTool.addBookmark(b5);
        ArrayList<Bookmark> expectedBookmarks = expectedBookmarkTool.getBookmarks();

        ArrayList<Bookmark> actualBookmarks = bookmarkTool.filterByKeywords("rest", "moodle");

        assertEquals(expectedBookmarks, actualBookmarks);

    }

    @Test
    public void filterBookmarksByMultipleSameKeywords() throws MalformedURLException {
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

        BookmarkTool expectedBookmarkTool = new BookmarkTool();
        expectedBookmarkTool.addBookmark(b2);
        expectedBookmarkTool.addBookmark(b4);
        expectedBookmarkTool.addBookmark(b5);
        ArrayList<Bookmark> expectedBookmarks = expectedBookmarkTool.getBookmarks();

        ArrayList<Bookmark> actualBookmarks = bookmarkTool.filterByKeywords("rest", "moodle", "moodle");

        assertEquals(expectedBookmarks, actualBookmarks);

    }

    /**
     * Unsure how to interpret the choice of which bookmark to remove
     */

    @Test
    public void ensureRemovingABookmarkFromTheBookmarkTool() throws MalformedURLException {
        Bookmark b1 = new Bookmark("https://www.fh-campuswien.ac.at");
        BookmarkTool bookmarkTool = new BookmarkTool();
        bookmarkTool.addBookmark(b1);

        Bookmark b2 = new Bookmark("https://www.fh-campuswien.ac.at");
        bookmarkTool.removeBookmark(b2);

        assertEquals(0, bookmarkTool.getBookmarks().size());
    }

    @Test
    public void ensureRemovingANonPresentBookmarkFromTheBookmarkTool() throws MalformedURLException {
        Bookmark b1 = new Bookmark("https://www.fh-campuswien.ac.at");
        BookmarkTool bookmarkTool = new BookmarkTool();
        bookmarkTool.addBookmark(b1);

        Bookmark b2 = new Bookmark("https://www.google.at");
        bookmarkTool.removeBookmark(b2);

        assertEquals(1, bookmarkTool.getBookmarks().size());
    }

    @Test
    public void ensureDescendingSortOfBookMarksByRate() throws MalformedURLException {
        Bookmark urlYoutube = new Bookmark("https://www.youtube.com");
        Bookmark urlGoogle1 = new Bookmark("https://www.google.com");
        Bookmark urlGoogle2 = new Bookmark("https://www.google.com");
        Bookmark urlORF1 = new Bookmark("https://www.orf.at");
        Bookmark urlORF2 = new Bookmark("https://www.orf.at");
        Bookmark urlORF3 = new Bookmark("https://www.orf.at");

        BookmarkTool bookmarkTool = new BookmarkTool();

        bookmarkTool.addBookmark(urlYoutube);
        bookmarkTool.addBookmark(urlGoogle1);
        bookmarkTool.addBookmark(urlGoogle2);
        bookmarkTool.addBookmark(urlORF1);
        bookmarkTool.addBookmark(urlORF2);
        bookmarkTool.addBookmark(urlORF3);

        bookmarkTool.sortBookmarkListByRate();

        assertAll(()->{
            assertEquals(3,bookmarkTool.getBookmarks().get(0).getRating());
            assertEquals(2,bookmarkTool.getBookmarks().get(1).getRating());
            assertEquals(1,bookmarkTool.getBookmarks().get(2).getRating());
        });
    }

}