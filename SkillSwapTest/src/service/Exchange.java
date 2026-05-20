package SkillSwap.src.service;

import SkillSwap.src.domain.*;
import SkillSwap.src.state.StateSkillSwap;
import java.util.Objects;
public class Exchange {
    private int exchange_id;
    private Student student_searcher;
    private Student student_matched;
    private Transaction_Result final_outcome;

    public Exchange(Student student1, Student student2)
    {
        student_matched = student2;
        student_searcher = student1;
        if (Math.random() > 0.25)
        {
            System.out.println("Exchange completed!");
            final_outcome = Transaction_Result.COMPLETED;
        }
        else
        {
            System.out.println("Exchange failed...");
            final_outcome = Transaction_Result.FAILED;

        }
    }

    public Exchange(String line, StateSkillSwap state) throws IllegalArgumentException{
        //EXId; searcher; matched; outcome
        if (line.isEmpty()){
            throw new IllegalArgumentException("Empty String");
        }
        String parsed[] = line.split(";", -1);

        if(parsed.length != 4){
            throw new IllegalArgumentException("Not the correct amount of information");
        }

        if(Integer.parseInt(parsed[0]) < 1){
            throw new IllegalArgumentException("Not a valid Id number");
        }
        exchange_id = Integer.parseInt(parsed[0]);

        student_matched = state.getStudentById(parsed[1]);
        if (student_matched == null) { throw new IllegalArgumentException("Student Matched not found");}
        student_searcher = state.getStudentById(parsed[2]);
        if (student_searcher == null) { throw new IllegalArgumentException("Student Searcher not found");}
        
        final_outcome = Transaction_Result.valueOf(parsed[3]);
    }

    public Transaction_Result getOutcome() { return final_outcome; }
    public int getID() {return exchange_id;}
    public Student getStudentMatched() { return student_matched; }
    public Student getSearcher() {return student_searcher;}
    public void giveID(int c) {exchange_id = c;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exchange)) return false;
        Exchange other = (Exchange) o;
        return Objects.equals(student_matched, other.getStudentMatched()) &&
            Objects.equals(student_searcher, other.getSearcher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_matched, student_searcher);
    }
    
    @Override
    public String toString()
    {
        return ("Exchange [" + getID() + "]: " + student_searcher.getId() + " [" + student_searcher.getName() + "], " + student_matched.getId() + " [" + student_matched.getName() + "] | " + final_outcome + " | ");
    }

    public String parseToCsv(){
        return (exchange_id + ";" + student_matched.getId() + ";" + student_searcher.getId() + ";" + final_outcome); //try .name()
    }
}
