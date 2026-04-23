package SkillSwap.src.service;

import SkillSwap.src.domain.*;
public class Exchange {
    private String exchange_id;
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
    public Transaction_Result getOutcome() { return final_outcome; }
    public String getID() {return exchange_id;}

    public Student getSearcher() {return student_searcher;}
    @Override
    public String toString()
    {
        return ("Exchange: " + student_searcher.getId() + " [" + student_searcher.getName() + "], " + student_matched.getId() + " [" + student_matched.getName() + "] | " + final_outcome + " | ");
    }
}
