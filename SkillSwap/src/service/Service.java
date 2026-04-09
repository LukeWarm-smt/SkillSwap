package SkillSwap.src.service;

import SkillSwap.src.domain.*;

import javax.swing.plaf.nimbus.State;

import SkillSwap.src.app.*;
import SkillSwap.src.service.*;
import SkillSwap.src.state.*;

public class Service {
    
    private StateSkillSwap state;

    public Service(StateSkillSwap state) { this.state = state;}

    public boolean validateId(String id) {
        return state.getStudents().containsKey(id); }
}
