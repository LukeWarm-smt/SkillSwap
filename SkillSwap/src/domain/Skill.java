package SkillSwap.src.domain;
//import lib.org.slf4j.LoggerFactory;

public class Skill{
    //Skills: skill_id;name;category
    private final String skillId;
    private final String name;
    private final /*SkillCategory*/ String Scatg;


    public Skill(String line) {
        if (line == null) {
            throw new NullPointerException("String is null");
        }

        line = line.trim();
        if (line.isEmpty()) {
            throw new IllegalArgumentException("String is empty, no information provided");
        }

        String[] parts = line.split(";", -1);

        if (parts.length != 3) {
            throw new IllegalArgumentException("Unrecognized amount of information");
        }

        // SKILL ID
        String id = parts[0].trim();
        if (id.isEmpty()) {
            throw new IllegalArgumentException("No skill identifier");
        }
        if (id.length() < 2 || id.charAt(0) != 'K') {
            throw new IllegalArgumentException("Invalid skill identifier");
        }
        this.skillId = id;

        // NAME
        String n = parts[1].trim();
        if (n.isEmpty()) {
            throw new IllegalArgumentException("No skill name");
        }
        this.name = n;

        // CATEGORY
        String cat = parts[2].trim();
        if (cat.isEmpty()) {
            throw new IllegalArgumentException("No skill category");
        }
        try {
            this.Scatg = parts[2];
        } catch (Exception e) {
            throw new IllegalArgumentException("Unrecognized skill category");
        }
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Skill){
            Skill o = (Skill) obj;
            if(this.skillId.equals(o.skillId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        int hash = 13;
        hash *= skillId.hashCode() * 17;
        return hash;
    }

    /*@Override
    public int compareTo(Skill o){

    }*/

    public String getSkillId() {
        return skillId;
    }

    public String getName(){
        return name;
    }

    public /*SkillCategory*/ String getScatg() {
        return Scatg;
    }
}
