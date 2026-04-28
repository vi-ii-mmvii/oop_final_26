package research;

import exceptions.NotResearcherException;
import interfaces.Researcher;
import java.util.*;

public class ResearchProject {
    private String topic;
    private List<Researcher> participants = new ArrayList<>();

    public ResearchProject(String topic) { this.topic = topic; }

    public void addParticipant(Researcher r) throws NotResearcherException {
        if (r == null) throw new NotResearcherException("Not a researcher!");
        participants.add(r);
    }
}