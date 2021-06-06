package at.ac.fhcampuswien.csdc21bb.group3.domain;

public class User {
    private String username;
    private String firstname;
    private String secondName;
    private BookmarkTool bookmarkTool;

    public User(String username, String firstname, String secondName) {
        this.username = username;
        this.firstname = firstname;
        this.secondName = secondName;
    }

    public void setBookmarkTool(BookmarkTool bookmarkTool) {
        this.bookmarkTool = bookmarkTool;
    }

    public BookmarkTool getBookmarkTool(){
        return this.bookmarkTool;
    }
}
