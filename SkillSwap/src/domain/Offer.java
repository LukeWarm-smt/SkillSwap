package SkillSwap.src.domain;

public class Offer {
    private final String offerId;
    private final String studentId;
    private final String skillId;
    private final Level skillLevel;
    private final Subjects subject;
    private boolean active;  

    public Offer(String line) {
        if (line == null) {
            throw new NullPointerException("String is null");
        }

        line = line.trim();
        if (line.isEmpty()) {
            throw new IllegalArgumentException("String is empty, no information provided");
        }

        String[] parts = line.split(";", -1);

        if (parts.length != 6) {
            throw new IllegalArgumentException("Unrecognized amount of information");
        }

        // OFFER ID
        String offId = parts[0].trim();
        if (offId.isEmpty()) {
            throw new IllegalArgumentException("No offer identifier");
        }
        if (offId.length() < 2 || offId.charAt(0) != 'O') {
            throw new IllegalArgumentException("Invalid offer identifier");
        }
        this.offerId = offId;

        // STUDENT ID
        String studId = parts[1].trim();
        if (studId.isEmpty()) {
            throw new IllegalArgumentException("No student identifier");
        }
        if (studId.length() < 2 || studId.charAt(0) != 'S') {
            throw new IllegalArgumentException("Invalid student identifier");
        }
        this.studentId = studId;

        // SKILL ID
        String skId = parts[2].trim();
        if (skId.isEmpty()) {
            throw new IllegalArgumentException("No skill identifier");
        }
        if (skId.length() < 2 || skId.charAt(0) != 'K') {
            throw new IllegalArgumentException("Invalid skill identifier");
        }
        this.skillId = skId;

        // LEVEL
        try {
            this.skillLevel = Level.valueOf(parts[3].trim().toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Unrecognized level");
        }

        // NOTE
        try {
            this.subject = Subjects.valueOf(parts[4].trim().toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Unrecognized subject");
        }

        // ACTIVE
        String status = parts[5].trim().toLowerCase();
        if (!status.equals("true") && !status.equals("false")) {
            throw new IllegalArgumentException("Not recognized status");
        }
        this.active = Boolean.parseBoolean(status);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Offer){
            Offer o = (Offer) obj;
            if(this.offerId.equals(o.offerId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        int hash = 13;
        hash *= offerId.hashCode() * 17;
        return hash;
    }

    public String getOfferId() {
        return offerId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSkillId() {
        return skillId;
    }

    public Level getSkillLevel() {
        return skillLevel;
    }

    public Subjects getSubject() {
        return subject;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Override
    public String toString()
    {
        return ("Offer: " + getOfferId() + ", " + getStudentId() + ", " + getSkillId() + ", " + getSkillLevel() + ", " + getSubject() + ", " + isActive());
    }
}
