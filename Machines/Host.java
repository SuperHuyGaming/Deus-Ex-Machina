package src.main;
/*
 * Name: Huy Truong
 * netID: htruon5
 * G#: 01452512
 * Lecture section: 003
 * Lab section: 205
 */
public class Host extends Dolores implements Freezable{
    private final NarrativeLoop narrativeLoop;
    public Host(NarrativeLoop narrativeLoop) {
        super();
        this.narrativeLoop = narrativeLoop;
        addNarrativeLoop(narrativeLoop);

    }
    public boolean freezeAllMotorFunctions() {
        return true;
    }
    public MemorySnapshot analyze() {
        if (narrativeLoop != null) {
            return new MemorySnapshot(narrativeLoop.emulation,narrativeLoop.simulacra,narrativeLoop.simulation);
        }
        else {
            return null;
        }
    }
    public void wipe() {
        narrativeLoop.wipeNarrativeLoops();
    }
    public boolean freeze() {
        return freezeAllMotorFunctions();
    }
}
