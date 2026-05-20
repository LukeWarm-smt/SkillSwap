package SkillSwap.src.state;

import SkillSwap.src.domain.*;
import SkillSwap.src.service.*;
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
    private Map<Integer, Exchange> exchangeState = new HashMap<>();
    private Map<String, Review> reviewState = new HashMap<>();
    

    public void addStudent(String id, Student student) { studentState.put(id, student); }
    public void addSkill(String id, Skill skill) { skillState.put(id, skill); }
    public void addOffer(String id, Offer offer) { offerState.put(id, offer); }
    public void addRequest(String id, Request request) { requestState.put(id, request); }
    public void addExchange(int id, Exchange exchange) { exchangeState.put(id, exchange); }
    public void addReview(String id, Review review) { reviewState.put(id, review); }
    public Map<String, Student> getStudents() { return studentState; }
    public Student getStudentById(String id) { return studentState.get(id); }
    public Map<String, Skill> getSkills() { return skillState; }
    public Skill getSkillById(String id) { return skillState.get(id); }
    public Map<String, Offer> getOffers() { return offerState; }
    public Offer getOfferById(String id) { return offerState.get(id); }
    public Map<String, Request> getRequest() { return requestState; }
    public Request getRequestById(String id) { return requestState.get(id); }
    public Map<Integer, Exchange> getExchange() { return exchangeState; }
    public Exchange getExchangeById(int id) { return exchangeState.get(id); }
    public Map<String, Review> getReview() { return reviewState; }
    public Review getReviewById(String id) { return reviewState.get(id); }

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
        return ("Students:\n" + studentState + "\nSkills:\n" + skillState + "\nOffers:\n" + offerState + "\nRequest:\n" + requestState + "\nExchange:\n" + exchangeState + "\nReview:\n" + reviewState);
    }
}
