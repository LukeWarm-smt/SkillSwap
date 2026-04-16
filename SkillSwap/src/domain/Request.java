package SkillSwap.src.domain;

public class Request {
    private final String requestId;
    private final String studentId;
    private final String skillId;
    private final Level min_requested;
    private final Subjects subject;

    //request_id;student_id;skill_id;min_level;note
    //R1;S1;K1;BEGINNER;mi blocco sulle stringhe    

    public Request(String line) {
        if (line == null) {
            throw new NullPointerException("String is null");
        }

        line = line.trim();
        if (line.isEmpty()) {
            throw new IllegalArgumentException("String is empty, no information provided");
        }

        String[] parts = line.split(";", -1);

        if (parts.length != 5) {
            throw new IllegalArgumentException("Unrecognized amount of information");
        }

        // REQUEST ID
        String reqId = parts[0].trim();
        if (reqId.isEmpty()) {
            throw new IllegalArgumentException("No request identifier");
        }
        if (reqId.length() < 2 || reqId.charAt(0) != 'R') {
            throw new IllegalArgumentException("Invalid request identifier");
        }
        this.requestId = reqId;

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
            this.min_requested = Level.valueOf(parts[3].trim().toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Unrecognized requested level");
        }

        // NOTE
        try {
            this.subject = Subjects.valueOf(parts[4].trim().toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Unrecognized subject");
        }
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Request){
            Request o = (Request) obj;
            if(this.requestId.equals(o.requestId)){
                return true;
            }
        }
        return false;
    }

        @Override
    public int hashCode(){
        int hash = 13;
        hash *= requestId.hashCode() * 17;
        return hash;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSkillId() {
        return skillId;
    }

    public Level getSkillLevel() {
        return min_requested;
    }

    public Subjects getSubject() {
        return subject;
    }

    @Override
    public String toString()
    {
        return ("Request: " + getRequestId() + ", " + getStudentId() + ", " + getSkillId() + ", " + getSkillLevel() + ", " + getSubject());
    }
}
