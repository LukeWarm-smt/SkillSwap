package SkillSwap.src.state;

import SkillSwap.src.domain.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateSkillSwap {
    private Map<String, Student> studentState = new HashMap<>();
    private Map<String, Skill> skillState = new HashMap<>();
    private Map<String, Offer> offerState = new HashMap<>();
    private Map<String, Request> requestState = new HashMap<>();

    public void addStudent(String id, Student student) { studentState.put(id, student); }
    public void addSkill(String id, Skill skill) { skillState.put(id, skill); }
    public void addOffer(String id, Offer offer) { offerState.put(id, offer); }
    public void addRequest(String id, Request request) { requestState.put(id, request); }

    public Map<String, Student> getStudents() { return studentState; }
    public Map<String, Skill> getSkills() { return skillState; }
    public Map<String, Offer> getOffers() { return offerState; }
    public Map<String, Request> getRequest() { return requestState; }

    public StateSkillSwap() throws IllegalArgumentException{
        List<String> list;
        try {
            list = Files.readAllLines(Paths.get("SkillSwap/resources/csv/student.csv"));
        } catch (IOException e) {
            throw new IllegalArgumentException("File student not found");
        }

        for (String string : list) {
            Student e = new Student(string);
            addStudent(e.getId(), e);
        }

        try {
            list = Files.readAllLines(Paths.get("SkillSwap/resources/csv/skills.csv"));
        } catch (IOException e) {
            throw new IllegalArgumentException("File skills not found");
        }

        for (String string : list) {
            Skill e = new Skill(string);
            addSkill(e.getSkillId(), e);
        }

        try {
            list = Files.readAllLines(Paths.get("SkillSwap/resources/csv/offers.csv"));
        } catch (IOException e) {
            throw new IllegalArgumentException("File offers not found");
        }

        for (String string : list) {
            Offer e = new Offer(string);
            addOffer(e.getOfferId(), e);
        }

        try {
            list = Files.readAllLines(Paths.get("SkillSwap/resources/csv/requests.csv"));
        } catch (IOException e) {
            throw new IllegalArgumentException("File requests not found");
        }

        for (String string : list) {
            Request e = new Request(string);
            addRequest(e.getRequestId(), e);
        }
    }

    //debug stuff
    @Override
    public String toString()
    {
        return ("Students:\n" + studentState + "\nSkills:\n" + skillState + "\nOffers:\n" + offerState + "\nRequest:\n" + requestState);
    }
}
