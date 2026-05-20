package SkillSwap.src.storage;
import SkillSwap.src.service.ConsoleReportPrinter;
import SkillSwap.src.state.*;
import java.io.IOException;

public interface Storage {
    public StateSkillSwap loadState(StateSkillSwap e, ConsoleReportPrinter c)  throws IllegalArgumentException ;
    public void saveState(StateSkillSwap skillSwapState) throws IOException;
}
