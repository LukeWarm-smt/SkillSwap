package SkillSwap.src.service;

import SkillSwap.src.domain.*;
import SkillSwap.src.state.StateSkillSwap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleReportPrinter {
    private int counter;
    private StateSkillSwap state;


    public ConsoleReportPrinter(StateSkillSwap state) {this.state = state; counter = 0;}

    public void addMatch(Exchange exchange, String review)
    {
        counter++;
        exchange.giveID(counter);
        Review rev = new Review(exchange, review);
        state.addExchange(counter, exchange);
        state.addReview(rev.getReviewID(), rev);
    }

    public void addMatch(Exchange exchange, Review review)
    {
        counter++;
    }

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

    public void setCounter(int counter) {
        if (counter < 1) {
            throw new IllegalArgumentException("Counter must be a positive integer.");
        }
        this.counter = counter;
    }
}