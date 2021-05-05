package at.ac.fhcampuswien.csdc21bb.group3;

import at.ac.fhcampuswien.csdc21bb.group3.BookmarkTool;
import org.junit.jupiter.api.Test;
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

    @Test
    public void checkIfValidURLisValid() throws MalformedURLException {
        String url = "https://www.orf.at";
        assertEquals(BookmarkTool.validateURL(url), new URL(url));
    }

    @Test
    public void checkIfURLProtocolIsValid() {
        String url = "htt://www.orf.at";
        Exception exception = assertThrows(MalformedURLException.class, () -> BookmarkTool.validateURL(url));
        assertTrue(exception.getMessage().contains("unknown protocol"));
    }
}