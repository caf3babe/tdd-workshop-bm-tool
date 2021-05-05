package at.ac.fhcampuswien.csdc21bb.group3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

class BookmarkToolTest {

    @Test
    public void ensureBookmarkIsAdded() {
        BookmarkTool bookmarkTool = new BookmarkTool();
        String url = "https://www.orf.at";
        int bookmarks = bookmarkTool.getBookmarks().size();
        assertAll("Bookmarks", () -> {
            assertTrue(bookmarkTool.addURL(url));
            assertEquals(bookmarks + 1, bookmarkTool.getBookmarks().size());
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"https://www.orf.at", "https://junit.org/junit5/docs/current", "https://github.com/starvis/tdd-workshop-bm-tool"})
    public void checkIfValidURLReturnsValidURL(String urlString) throws MalformedURLException {
        assertEquals(BookmarkTool.validateURL(urlString), new URL(urlString));
    }


    @ParameterizedTest
    @ValueSource(strings = {"htt://www.orf.at", "tt://www.orf.at", "asdf://www.orf.at"})
    public void checkIfURLProtocolIsValid(String urlString) {
        Exception exception = assertThrows(MalformedURLException.class, () -> BookmarkTool.validateURL(urlString));
        assertTrue(exception.getMessage().contains("unknown protocol"));
    }

    @Test
    public void ensureSingleEntryWhenBookmarkAlreadyPresent() throws MalformedURLException {
        String urlString = "https://www.orf.at";
        BookmarkTool bookmarkTool = new BookmarkTool();
        bookmarkTool.addURL(urlString);
        int sizeOfBookmarkListAfterFirstEntry = bookmarkTool.getBookmarks().size();
        bookmarkTool.addURL(urlString);
        int sizeOfBookmarkListAfterSecondEntry = bookmarkTool.getBookmarks().size();
        assertEquals(sizeOfBookmarkListAfterFirstEntry, sizeOfBookmarkListAfterSecondEntry);
    }

    @Test
    public void increaseRatingOfBookmarkWhenBookmarkAlreadyExists() throws MalformedURLException {
        String urlString = "https://www.orf.at";
        URL url = BookmarkTool.validateURL(urlString);
        BookmarkTool bookmarkTool = new BookmarkTool();
        bookmarkTool.addURL(urlString);
        int ratingAfterFirstInsert = bookmarkTool.getBookmarkByURL(url).getRating();
        bookmarkTool.addURL(urlString);
        int ratingAfterSecondInsert = bookmarkTool.getBookmarkByURL(url).getRating();
        assertTrue(ratingAfterFirstInsert < ratingAfterSecondInsert);
    }
}