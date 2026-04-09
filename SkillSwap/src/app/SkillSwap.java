package SkillSwap.src.app;

import SkillSwap.src.domain.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.plaf.nimbus.State;

import SkillSwap.src.app.*;
import SkillSwap.src.service.*;
import SkillSwap.src.state.*;

public class SkillSwap {
    public static void main(String[] args) {
        StateSkillSwap state = new StateSkillSwap();

        Scanner scanf = new Scanner(System.in);
        int i = 0;

        List<String> students;
        try {
            students = Files.readAllLines(Paths.get("SkillSwap/src/app/student.csv"));
        } catch (IOException e) {
            System.out.println("Impossible reading names file...");
            return;
        }
        students.stream().forEach(studenty -> { try { Student student = new Student(studenty); state.addStudent(student.getId(), student); } catch (Exception e) { System.out.println("Errore in studente " + studenty);}  });
        List<String> skills;
        try {
            skills = Files.readAllLines(Paths.get("SkillSwap/src/app/skills.csv"));
        } catch (IOException e) {
            System.out.println("Impossible reading names file...");
            return;
        }
        skills.stream().forEach(skilly -> { try { Skill skill = new Skill(skilly); state.addSkill(skill.getSkillId(), skill); } catch (Exception e) { System.out.println("Errore in skill " + skilly);} });
        List<String> offers;
        try {
            offers = Files.readAllLines(Paths.get("SkillSwap/src/app/offers.csv"));
        } catch (IOException e) {
            System.out.println("Impossible reading names file...");
            return;
        }
        offers.stream().forEach(offerty -> { try { Offer offer = new Offer(offerty); state.addOffer(offer.getOfferId(), offer); } catch (Exception e) { System.out.println("Errore in offer " + offerty);} });
        List<String> requests;
        try {
            requests = Files.readAllLines(Paths.get("SkillSwap/src/app/requests.csv"));
        } catch (IOException e) {
            System.out.println("Impossible reading names file...");
            return;
        }
        requests.stream().forEach(requesty -> { try { Request request = new Request(requesty); state.addRequest(request.getRequestId(), request); } catch (Exception e) { System.out.println("Errore in request " + requesty);} });
        MatchingService Mservices = new MatchingService(state);

        while(true)
        {
            System.out.println("Skill Swap \n\n 1- show state\n 2 - match\n");
            switch(scanf.nextLine()) {
                case "1": System.out.println(state.toString() + "\n\n"); break;
                case "2": Match matched = Mservices.simpleMatching(state.getRequest().get("S1")); System.out.println(matched.toString()); break;

            }
        }
        
    }
}
