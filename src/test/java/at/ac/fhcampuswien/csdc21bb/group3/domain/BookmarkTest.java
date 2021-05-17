package at.ac.fhcampuswien.csdc21bb.group3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BookmarkTest {

    @ParameterizedTest
    @ValueSource(strings = {"https://www.orf.at", "https://junit.org/junit5/docs/current", "https://github.com/starvis/tdd-workshop-bm-tool"})
    public void checkIfValidURLIsValid(String url) {
        assertDoesNotThrow(() -> {
            new Bookmark(url);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"htt://www.orf.at", "tt://www.orf.at", "asdf://www.orf.at"})
    public void checkIfInvalidProtocolIsValid(String url) {
        Exception exception = assertThrows(MalformedURLException.class, () -> new Bookmark(url));

        assertTrue(exception.getMessage().contains("unknown protocol"));
    }

    @Test
    public void ensureBookmarkCanHaveTags() throws MalformedURLException {
        String tvTag = "tv";
        String newsTag = "news";
        String url = "https://www.orf.at";

        Bookmark bookmark = new Bookmark(url, new ArrayList<>(Arrays.asList("news", "tv")));

        assertAll(()->{
            assertTrue(bookmark.getTags().contains(tvTag));
            assertTrue(bookmark.getTags().contains(newsTag));
        });
    }

    @Test
    public void ensureToStringReturnsNotEmptyString() throws MalformedURLException {
        String url = "https://www.orf.at";
        Bookmark bookmark = new Bookmark(url);

        assertFalse(bookmark.toString().isEmpty());
    }

    @Test
    public void removeTagFromABookmark() throws MalformedURLException {
        Bookmark actualBookmark = new Bookmark("https://www.github.com");
        actualBookmark.addTag("code");
        actualBookmark.addTag("sourcecode");
        actualBookmark.addTag("repository");
        actualBookmark.addTag("git");

        actualBookmark.removeTag("sourcecode");
        actualBookmark.removeTag("git");

        assertEquals(Arrays.asList("code","repository"), actualBookmark.getTags());

    }

}