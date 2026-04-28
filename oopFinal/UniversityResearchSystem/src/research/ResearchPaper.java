package research;

import enums.Format;
import interfaces.Researcher;
import java.util.*;

public class ResearchPaper {
    private String title;
    private List<Researcher> authors = new ArrayList<>();
    private String journal;
    private int pages;
    private int citations;
    private String date;

    public ResearchPaper(String title, String journal, int pages, int citations, String date) {
        this.title = title;
        this.journal = journal;
        this.pages = pages;
        this.citations = citations;
        this.date = date;
    }

    public void addAuthor(Researcher r) { authors.add(r); }
    public int getCitations() { return citations; }

    public String getCitation(Format format) {
        return format == Format.BIBTEX ? "@article{" + title + ", journal=" + journal + "}" : title + ". " + journal;
    }
}