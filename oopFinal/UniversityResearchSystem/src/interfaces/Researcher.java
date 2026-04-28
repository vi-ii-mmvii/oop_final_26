package interfaces;
import research.ResearchPaper;
import research.ResearchProject;
import java.util.List;

public interface Researcher {
    void publishPaper(ResearchPaper paper);
    List<ResearchPaper> getResearchPapers();
    int calculateHIndex();
}