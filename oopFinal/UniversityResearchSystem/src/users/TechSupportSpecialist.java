package users;

import system.Request;

import java.util.ArrayList;
import java.util.List;

public class TechSupportSpecialist extends Employee {
    private List<Request> requests;

    public TechSupportSpecialist(String id, String name, String email, double salary, int yearsOfService) {
        super(id, name, email, salary, yearsOfService);
        this.requests = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "TechSupportSpecialist";
    }

    public void seeRequest(Request request) {
        request.markViewed();
        if (!requests.contains(request)) {
            requests.add(request);
        }
    }

    public void acceptRequest(Request request) {
        request.accept();
    }

    public void rejectRequest(Request request) {
        request.reject();
    }

    public void completeRequest(Request request) {
        request.done();
    }

    public List<Request> getRequests() {
        return requests;
    }

    @Override
    public String toString() {
        return "TechSupportSpecialist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", requestsCount=" + requests.size() +
                '}';
    }
}