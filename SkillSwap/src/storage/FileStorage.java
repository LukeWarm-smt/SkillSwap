package SkillSwap.src.storage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import SkillSwap.src.state.StateSkillSwap;
import SkillSwap.src.domain.*;
import java.lang.reflect.Array;

public class FileStorage implements Storage{

    public FileStorage(List<String> i){}

    @Override
    public StateSkillSwap load(){
        

        
    }
    @Override
    public void saveState(StateSkillSwap skillSwapState){
        //files should be in SkillSwap/resources/csv
        Path path = Path.of("resources", "csv", "student.csv");
        List<String> lines = Files.readAllLines(path);
        for (String e : lines) {
            Student a = new Student(e);
            skillSwapState.addStudent(a.getId(), a);
        }

        path = Path.of("resources", "csv", "skill.csv");
        lines = Files.readAllLines(path);
        for (String e : lines) {
            Skill a = new Skill(e);
            skillSwapState.addSkill(a.getSkillId(), a);
        }

        path = Path.of("resources", "csv", "offer.csv");
        lines = Files.readAllLines(path);
        for (String e : lines) {
            Offer a = new Offer(e);
            skillSwapState.addOffer(a.getOfferId(), a);
        }

        path = Path.of("resources", "csv", "request.csv");
        lines = Files.readAllLines(path);
        for (String e : lines) {
            Request a = new Request(e);
            skillSwapState.addRequest(a.getRequestId(), a);
        }
    }
}
