package SkillSwap.src.domain;

public class Offer {
    private final String offerId;
    private final String studentId;
    private final String skillId;
    private final Level skillLevel;
    private final String note;
    private boolean active;  

    public Offer(String line){
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
        if(lines.length != 6){
            throw new IllegalArgumentException("Unrecognized amount of information");
        }

        //check for empty string
        if (lines[0].isEmpty()){
            throw new IllegalArgumentException("No offer identifier");
        }
        if (lines[0].length() < 2) {
            throw new IllegalArgumentException("offer identifier too short");
        }
        if(lines[0].charAt(0) != 'O'){
            throw new IllegalArgumentException("Unrecognized offer identifier syntaxsis");
        }
        this.offerId = lines[0].trim();

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
            skillLevel = Level.valueOf(lines[3].trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unrecognized level");
        }

        //check for empty string
        if (lines[4].isEmpty()){
            throw new IllegalArgumentException("No note");
        }
        note = lines[4].trim();

        if(lines[5].isEmpty()){
            throw new IllegalArgumentException("No activity status");
        }
        if(!lines[5].equalsIgnoreCase("true") && !lines[5].equalsIgnoreCase("false")){
            throw new IllegalArgumentException("not recognized status");
        }
        active = Boolean.valueOf(lines[5]);
        
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

    public String getNote() {
        return note;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
