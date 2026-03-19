package SkillSwap.src.domain;
//import lib.org.slf4j.LoggerFactory;

public class Skill{
    //Skills: skill_id;name;category
    private final String skillId;
    private final String name;
    private final SkillCategory Scatg;


    public Skill(String line){

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
        if(lines.length != 3){
            throw new IllegalArgumentException("Unrecognized amount of information");
        }

        //check for empty string
        if (lines[0].isEmpty()){
            throw new IllegalArgumentException("No identifier");
        }
        if (lines[0].length() < 2) {
            throw new IllegalArgumentException("Identifier too short");
        }
        if(lines[0].charAt(0) != 'K'){
            throw new IllegalArgumentException("Unrecognized identifier syntaxsis");
        }
        this.skillId = lines[0].trim();

        //check for empty string
        if (lines[1].isEmpty()){
            throw new IllegalArgumentException("No identifier");
        }
        this.name = lines[1].trim();

        if(lines[2].isEmpty()){
            throw new IllegalArgumentException("No type of skill.");
        }
        try {
            this.Scatg = SkillCategory.valueOf(lines[2].trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unrecognized type of skill");
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

    public SkillCategory getScatg() {
        return Scatg;
    }
}
