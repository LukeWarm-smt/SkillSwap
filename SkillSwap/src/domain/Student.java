package SkillSwap.src.domain;
public class Student {
    private final String name;
    private final String student_id;
    private final String school_class;
    private final String email;
    private final double ratings;
    private final int rating_counts;

    public Student(String line)
    {
        String lines[] = line.trim().split(";");
        this.student_id = lines[0];
        this.name = lines[1];
        this.school_class = lines[2];
        this.email = lines[3];
        try {
            this.ratings = Double.parseDouble(lines[4]);
        } catch (NumberFormatException e) {
            System.out.println(lines[4] + " contiene un double invalido");
            throw new IllegalArgumentException();
        }
        try 
        {
            this.rating_counts = Integer.parseInt(lines[5]);
        }
        catch (NumberFormatException e)
        {
            System.out.println (lines[5] + " contiene un numero finale invalido");
            throw new IllegalArgumentException();
        }
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getSchoolClass() { return school_class; }
    public String getId() { return student_id; }
    public double getRatings() { return ratings; }
    public int getRatingsCount() { return rating_counts; }
    public String toString()
    {
        return (student_id + " " + 
        name + " " +
        school_class + " " +
        email + " " +
        ratings + " " +
        rating_counts);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student o = (Student) obj;
            if(this.student_id.equals(o.student_id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        int hash = 13;
        hash *= student_id.hashCode() * 17;
        return hash;
    }
}