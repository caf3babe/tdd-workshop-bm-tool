package at.ac.fhcampuswien.csdc21bb.group3;

import at.ac.fhcampuswien.csdc21bb.group3.Bookmark;
import at.ac.fhcampuswien.csdc21bb.group3.BookmarkTool;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BookmarkTest {

    @Test
    public void ensureBookmarkCanHaveTags() throws MalformedURLException {

        String tvTag = "tv";
        String newsTag = "news";
        String urlString = "https://www.orf.at";

        Bookmark bookmark = new Bookmark(BookmarkTool.validateURL(urlString), new ArrayList<>(Arrays.asList("news", "tv")));

        assertAll(()->{
            assertTrue(bookmark.getTags().contains(tvTag));
            assertTrue(bookmark.getTags().contains(newsTag));
        });
    }

}