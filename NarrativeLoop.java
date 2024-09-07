package src.main;
/*
 * Name: Huy Truong
 * netID: htruon5
 * G#: 01452512
 * Lecture section: 003
 * Lab section: 205
 */
import java.util.List;
import java.util.ArrayList;

public abstract class NarrativeLoop {

    public enum Realm {
        EMULATION, // Represents high-fidelity replications of the original system.
        SIMULACRA,// Denotes abstracted or distorted representations, not directly tied to the original.
        SIMULATION, // indicates simplified models for exploring system behaviors.
    }

    protected final List<SystemWhole> emulation;
    protected final List<SystemWhole> simulacra;
    protected final List<SystemWhole> simulation;

    public NarrativeLoop() {
        emulation = new ArrayList<>();
        simulacra = new ArrayList<>();
        simulation = new ArrayList<>();
    }
    public void wipeNarrativeLoops() {
        emulation.clear();
        simulacra.clear();
        simulation.clear();
    }
     public final void updateNarrativeLoops(SystemWhole[] emulationContext, SystemWhole[] simulacraContext) {
        // EMULATION
        for (SystemWhole object : emulationContext) {
            for (Machine machine_object : object.reify()) {
                Realm determineRealmResults = determineRealm(machine_object.getKind(), emulationContext,simulacraContext);
                /*
                 determineRealm returns Realm.EMULATION and containsKind confirms
                 the emulation list doesn't already
                  include a Machine of this kind or
                   the same SystemWhole reference, add the SystemWhole to emulation.
                */
                if (determineRealmResults.equals(Realm.EMULATION) && !containsKind(emulation, machine_object.getKind())) {
                    emulation.add(object);
                }
            }
        }
        // SIMULACRA
        for (SystemWhole object : simulacraContext) {
            for (Machine machine_object : object.reify()) {
                Realm determineRealmResults = determineRealm(machine_object.getKind(), emulationContext,simulacraContext);
                /*
                 determineRealm returns Realm.EMULATION and containsKind confirms
                 the emulation list doesn't already
                  include a Machine of this kind or
                   the same SystemWhole reference, add the SystemWhole to emulation.
                */
                if (determineRealmResults.equals(Realm.SIMULACRA) && !containsKind(simulacra, machine_object.getKind())) {
                    simulacra.add(object);
                }
            }
        }
        // SIMULATION
        for (SystemWhole object : simulacraContext) {
            for (Machine machine_object : object.reify()) {
                Realm determineRealmResults = determineRealm(machine_object.getKind(), emulationContext,simulacraContext);
                /*
                 determineRealm returns Realm.EMULATION and containsKind confirms
                 the emulation list doesn't already
                  include a Machine of this kind or
                   the same SystemWhole reference, add the SystemWhole to emulation.
                */
                if (determineRealmResults.equals(Realm.SIMULATION) && !containsKind(simulation, machine_object.getKind())) {
                    simulation.add(object);
                }
            }
        }
    }

    private final Realm determineRealm(String kind, SystemWhole[] emulationContext, SystemWhole[] simulacraContext) {
        if (isInContext(kind,emulationContext) && isInContext(kind,simulacraContext)) {
            return Realm.SIMULATION;
        }
        else if (isInContext(kind,simulacraContext)) {
            return Realm.SIMULACRA;
        }
        else {
            return Realm.EMULATION;
        }
    }

    private final boolean isInContext(String kind, SystemWhole[] context) {
        for (SystemWhole systemWhole : context) {
            for (Machine machine : systemWhole.reify() ) {
                if (machine.getKind().equals(kind)) {
                    return true;
                }
            }

        }
        return false;
    }

    private final boolean containsKind(List<SystemWhole> list, String kind) {
        for (SystemWhole systemWhole : list) {
            for (Machine machine : systemWhole.reify()) { // for machine objects in systemwhole.reify() method
                String machineKind = machine.getKind(); // get the machine kind from Machine class
                if (machineKind.equals(kind)) {
                    return true;
                }
            }

        }
        return false;
    }

}
