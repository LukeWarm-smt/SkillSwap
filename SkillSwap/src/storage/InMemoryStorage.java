package SkillSwap.src.storage;

import SkillSwap.src.state.StateSkillSwap;

public class InMemoryStorage implements Storage{
    public InMemoryStorage(){
    }

    @Override
    public StateSkillSwap load(){
        //you take the information and then you work with it to turn it into a state to pass to the main's state
    }
    @Override
    public void saveState(StateSkillSwap skillSwapState){
        
    }
}
