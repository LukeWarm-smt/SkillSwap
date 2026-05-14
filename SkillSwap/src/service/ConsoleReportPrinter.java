package SkillSwap.src.service;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import SkillSwap.src.state.StateSkillSwap;
import java.util.Comparator;
import SkillSwap.src.domain.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ConsoleReportPrinter {
    private int counter;
    private StateSkillSwap state;
    private Map<Exchange, Integer> matches_created = new HashMap<>();

    public ConsoleReportPrinter(StateSkillSwap state) {this.state = state; counter = matches_created.size() + 1;}

    public void addMatch(Exchange exchange, Integer review)
    {
            counter = matches_created.size() + 1;
            exchange.giveID(counter);
            matches_created.put(exchange, review);
    }

    public Map<Exchange, Integer> getMatchesCreatedMap() { return matches_created;}

    public String printExchangeDetails() {return "wip";}

    public String printStudentProfile(String studentId)
    {
        StringBuilder sb = new StringBuilder();
        Map<String, Student> state_students = state.getStudents();
        Student student = state_students.get(studentId);
        if (student == null) return "Student not found...";
        else
        {
            sb.append("Risultato trovato: ");
            sb.append(student.getName());
            return sb.toString();
        }
    }

    public String printLeaderboard()
    {
        StringBuilder sb = new StringBuilder();
        Map<String, Student> state_students = state.getStudents();
        List<Student> sortedStudents = state_students.values()
            .stream()
            .sorted(Comparator.comparingDouble(Student::getRatings).reversed())
            .collect(Collectors.toList());

        int index = 1;
        for (Student student : sortedStudents) {
            sb.append(index);
            sb.append(": ");
            sb.append(student.getId());
            sb.append(" - ");
            sb.append(student.getName());
            sb.append(" - ");
            sb.append(student.getRatings());
            sb.append("\n");
            index++;
        }
        return sb.toString();
    }

}
