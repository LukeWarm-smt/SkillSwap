package SkillSwap.src.domain;

public class Request {
    private final String requestId;
    private final String studentId;
    private final String skillId;
    private final Level min_requested;
    private final String note;

    //request_id;student_id;skill_id;min_level;note
    //R1;S1;K1;BEGINNER;mi blocco sulle stringhe    

    public Request(String line){
        //check if null and if empty
        if (line == null) {
            throw new NullPointerException("String is null");
        }
        else if(line.isEmpty()){
            throw new IllegalArgumentException("String is empty, no information provided");
        }
        //split the string into segments
        //expected separator ";"
        String lines[] = line.trim().split(";");
        
        //Check for line's input of information.
        if(lines.length != 5){
            throw new IllegalArgumentException("Unrecognized amount of information");
        }

        //check for empty string
        if (lines[0].isEmpty()){
            throw new IllegalArgumentException("No request identifier");
        }
        if (lines[0].length() < 2) {
            throw new IllegalArgumentException("request identifier too short");
        }
        if(lines[0].charAt(0) != 'R'){
            throw new IllegalArgumentException("Unrecognized request identifier syntaxsis");
        }
        this.requestId = lines[0].trim();

        //check for empty string
        if (lines[1].isEmpty()){
            throw new IllegalArgumentException("No student identifier");
        }
        if (lines[1].length() < 2) {
            throw new IllegalArgumentException("student identifier too short");
        }
        if(lines[1].charAt(1) != 'S'){
            throw new IllegalArgumentException("Unrecognized student identifier syntaxsis");
        }
        this.studentId = lines[1].trim();

        //check for empty string
        if (lines[2].isEmpty()){
            throw new IllegalArgumentException("No skill identifier");
        }
        if (lines[2].length() < 2) {
            throw new IllegalArgumentException("skill identifier too short");
        }
        if(lines[2].charAt(0) != 'K'){
            throw new IllegalArgumentException("Unrecognized skill identifier syntaxsis");
        }
        this.skillId = lines[2].trim();

        try {
            min_requested = Level.valueOf(lines[3].trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unrecognized requested level");
        }

        //check for empty string
        if (lines[4].isEmpty()){
            throw new IllegalArgumentException("No note");
        }
        note = lines[4].trim();
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

    public Level getMin_requested() {
        return min_requested;
    }

    public String getNote() {
        return note;
    }
}
