package academic;

public class Mark {
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;

    public Mark(double firstAttestation, double secondAttestation, double finalExam) {
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.finalExam = finalExam;
    }

    public double getFirstAttestation() {
        return firstAttestation;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public double getTotal() {
        return firstAttestation + secondAttestation + finalExam;
    }

    public boolean isPassed() {
        return getTotal() >= 50;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "att1=" + firstAttestation +
                ", att2=" + secondAttestation +
                ", final=" + finalExam +
                ", total=" + getTotal() +
                ", passed=" + isPassed() +
                '}';
    }
}