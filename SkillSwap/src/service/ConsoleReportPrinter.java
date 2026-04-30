package SkillSwap.src.service;

import java.util.HashMap;
import java.util.Map;

import SkillSwap.src.state.StateSkillSwap;

import SkillSwap.src.domain.*;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class ConsoleReportPrinter {
    
    private StateSkillSwap state;
    private Map<Exchange, Integer> matches_created = new HashMap<>();

    public ConsoleReportPrinter(StateSkillSwap state) {this.state = state;}
    public void addMatch(Exchange exchange, Integer review)
    {
            matches_created.put(exchange, review);
    }

    public Map<Exchange, Integer> getMatchesCreatedMap() { return matches_created;}

    public String printStudentProfile(String studentId)
    {
        Map<String, Student> state_students = state.getStudents();
        Student student = state_students.get(studentId);
        if (student == null) return "Student not found...";
        else return student.toString();
    }

    public String printLeaderboard()
    {
        return "lol";
    }

}
