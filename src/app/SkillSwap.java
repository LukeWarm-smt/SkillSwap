package SkillSwap.src.app;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import SkillSwap.src.domain.*;

public class SkillSwap {
    public static void main(String[] args) {
            Map<String, Student> studentmap = new HashMap<>();
            Map<String, Skill> skillmap = new HashMap<>();
            Map<String, Offer> offermap = new HashMap<>();
            Map<String, Request> requestmap = new HashMap<>();
            
            List<String> students;
            try {
                students = Files.readAllLines(Paths.get("SkillSwap/src/app/student.csv"));
            } catch (IOException e) {
                System.out.println("Impossible reading names file...");
                return;
            }
            students.stream().forEach(studenty -> { try { Student student = new Student(studenty); studentmap.put(student.getId(), student); } catch (Exception e) { System.out.println("Errore in studente " + studenty);} });
            List<String> skills;
            try {
                skills = Files.readAllLines(Paths.get("SkillSwap/src/app/skills.csv"));
            } catch (IOException e) {
                System.out.println("Impossible reading names file...");
                return;
            }
            skills.stream().forEach(skilly -> { try { Skill skill = new Skill(skilly); skillmap.put(skill.getSkillId(), skill); } catch (Exception e) { System.out.println("Errore in skill " + skilly);} });
            List<String> offers;
            try {
                offers = Files.readAllLines(Paths.get("SkillSwap/src/app/offers.csv"));
            } catch (IOException e) {
                System.out.println("Impossible reading names file...");
                return;
            }
            offers.stream().forEach(offerty -> { try { Offer offer = new Offer(offerty); offermap.put(offer.getOfferId(), offer); } catch (Exception e) { System.out.println("Errore in offer " + offerty);} });
            List<String> requests;
            try {
                requests = Files.readAllLines(Paths.get("SkillSwap/src/app/requests.csv"));
            } catch (IOException e) {
                System.out.println("Impossible reading names file...");
                return;
            }
            requests.stream().forEach(requesty -> { try { Request request = new Request(requesty); requestmap.put(request.getRequestId(), request); } catch (Exception e) { System.out.println("Errore in request " + requesty);} });
            System.out.println(studentmap);
            System.out.println(skillmap);
            System.out.println(offermap);
    }
}
