package seedu.duke.writing;

import seedu.duke.history.History;
import seedu.duke.writing.Writings;

public class Essay extends Writings {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /*
    public void setAuthor(String author) {
        super.author = author;
    }

    @Override
    public String getAuthor() {
        return super.author;
    }

     */
}
