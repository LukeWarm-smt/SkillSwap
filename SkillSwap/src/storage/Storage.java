package SkillSwap.src.storage;
import SkillSwap.src.state.*;

public interface Storage {
    public StateSkillSwap load();
    public void saveState(StateSkillSwap skillSwapState);
}
