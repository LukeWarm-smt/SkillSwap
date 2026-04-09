package SkillSwap.src.state;

import java.util.HashMap;
import java.util.Map;

import SkillSwap.src.domain.*;

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

    public StateSkillSwap getStateSkillSwap() { return this; }
    
    //debug stuff
    @Override
    public String toString()
    {
        return ("Students:\n" + studentState + "\nSkills:\n" + skillState + "\nOffers:\n" + offerState + "\nRequest:\n" + requestState);
    }
}
