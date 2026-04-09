package SkillSwap.src.service;

import SkillSwap.src.state.StateSkillSwap;
import SkillSwap.src.domain.*;

import java.util.HashMap;
import java.util.Map;
public class Match {
    private String student_searcher;
    private String student_matched;

    public Match(String student1, String student2)
    {
        student_matched = student2;
        student_searcher = student1;
    }

    @Override
    public String toString()
    {
        return ("Match:\n 1- " + student_searcher + "\n 2- " + student_matched);
    }
}
