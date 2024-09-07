package src.main;
/*
 * Name: Huy Truong
 * netID: htruon5
 * G#: 01452512
 * Lecture section: 003
 * Lab section: 205
 */

import java.util.ArrayList;
import java.util.List;

public class Dolores extends Robot implements Wipeable{
    private List<NarrativeLoop> narrativeLoops = new ArrayList<>();
    public Dolores() {
        super(new String[] {},0,false,true,true);
    }

    public final void addNarrativeLoop(NarrativeLoop narrativeLoop) {
        narrativeLoops.add(narrativeLoop);
    }

    public final Machine[] getAbsoluteCapabilities() {
        throw new UnsupportedOperationException("fetching absolute capabilities directly is not supported");
    }

    public boolean freezeAllMotorFunctions() { // do it later
        return false;
    }
    @Override
    public MemorySnapshot analyze() {
        if (narrativeLoops.isEmpty()) {
            return null;
        }
        else {
            NarrativeLoop last_element = narrativeLoops.getLast();
            return new MemorySnapshot(last_element.emulation,last_element.simulacra,last_element.simulation);
        }
    }
    public void wipe() {

    }

}
