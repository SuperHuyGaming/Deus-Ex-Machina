package src.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

// Author: Dr. Ford
// Guest, uncomment as you implement the imported types below.
import src.main.*;

public class FordTest {
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
    public void testBernardSimulationDiagnostics000() {
        // P2 emergences strings be like:
        String[] emergences = {"{\"kind\": \"Humanoid\"}","{\"kind\": \"Machine\",\"bodyType\": \"null\"}"};
        String[] emergences2 = {"{\"kind\": \"Machine\"},\"{\\\"kind\\\": \\\"Machine\\\",\\\"bodyType\\\": \\\"metal\\\"}"};
        // Using Bernard to get systems (whole)
        SystemWhole aSystemWhole = Bernard.analysis(emergences);
        SystemWhole aSystemWhole2 = Bernard.analysis(emergences2);

        // matching updateNarrativeLoops parameter types
        SystemWhole[] systemWholes = {aSystemWhole};
        SystemWhole[] systemWholes2 = {aSystemWhole2};
        // Getting a narrative
          NarrativeLoop narrativeLoop = new HostLoop();
        //  //The system is in both, since it is the same array, it should be added to the simulation list.
          narrativeLoop.updateNarrativeLoops(systemWholes,systemWholes2);
        //  // Let's make sure of it, I can verify that via Host
          Host host = new Host(narrativeLoop);
        //  // Tell me what you got host
          MemorySnapshot memorySnapshot = host.analyze();
        //  // Your simulated memories must have the aSystemWhole I created for you
          assertFalse(memorySnapshot.simulationMemory().contains((Object)aSystemWhole));
        //  // This is a mockery of an assertion. Disregard once the one above works.
//        assertTrue(true);
    }
    @Test
    public void testHostWipe() {
        // P2 emergences strings be like:
        String[] emergences = {"{\"kind\": \"Humanoid\", \"bodyType\": \"null\", \"faceType\": \"11.4.1\", \"reverie\": \"44.2\", \"version\": \"1.1.2\"}",
                "{\"kind\": \"Humanoid\", \"bodyType\": \"0\", \"faceType\": \"5.5\", \"reverie\": \"anthropomorphic23\"}"};
        // Using Bernard to get systems (whole)
        SystemWhole aSystemWhole = Bernard.analysis(emergences);
        // matching updateNarrativeLoops parameter types
        SystemWhole[] systemWholes = {aSystemWhole};
        // Getting a narrative
        NarrativeLoop narrativeLoop = new HostLoop();
        //  //The system is in both, since it is the same array, it should be added to the simulation list.
        narrativeLoop.updateNarrativeLoops(systemWholes,systemWholes);
        //  // Let's make sure of it, I can verify that via Host
        Host host = new Host(narrativeLoop);
        host.wipe(); // does it really wipe?

        //  // Tell me what you got host
        MemorySnapshot memorySnapshot = host.analyze();
        //  // Your simulated memories must have the aSystemWhole I created for you
        List<SystemWhole> systemWholes1 = memorySnapshot.simulationMemory();
        assertFalse(memorySnapshot.simulationMemory().contains(aSystemWhole));
        //  // This is a mockery of an assertion. Disregard once the one above works.
//        assertTrue(true);
    }
    @Test
    public void testWipeNarrativeLoops() {
        {
            // P2 emergences strings be like:
            String[] emergences = {"{\"kind\": \"Humanoid\", \"bodyType\": \"null\", \"faceType\": \"11.4.1\", \"reverie\": \"44.2\", \"version\": \"1.1.2\"}",
                    "{\"kind\": \"Humanoid\", \"bodyType\": \"0\", \"faceType\": \"5.5\", \"reverie\": \"anthropomorphic23\"}"};
            // Using Bernard to get systems (whole)
            SystemWhole aSystemWhole = Bernard.analysis(emergences);
            // matching updateNarrativeLoops parameter types
            SystemWhole[] systemWholes = {aSystemWhole};

            // Getting a narrative
            NarrativeLoop narrativeLoop = new HostLoop();
            // wipe narrativeLoop
            narrativeLoop.wipeNarrativeLoops();
            //  //The system is in both, since it is the same array, it should be added to the simulation list.
            narrativeLoop.updateNarrativeLoops(systemWholes,systemWholes);
            narrativeLoop.wipeNarrativeLoops();
            //  // Let's make sure of it, I can verify that via Host
            Host host = new Host(narrativeLoop);



            //  // Tell me what you got host
            MemorySnapshot memorySnapshot = host.analyze();
            //  // Your simulated memories must have the aSystemWhole I created for you
            List<SystemWhole> systemWholes1 = memorySnapshot.simulationMemory();

            assertFalse(systemWholes1.contains(aSystemWhole));
            //  // This is a mockery of an assertion. Disregard once the one above works.
//        assertTrue(true);
        }
    }
    @Test
    public void testWipeNarrativeLoopsInMazeLoop() {
        // P2 emergences strings be like:
        String[] emergences = {"{\"kind\": \"Humanoid\", \"bodyType\": \"null\", \"faceType\": \"11.4.1\", \"reverie\": \"44.2\", \"version\": \"1.1.2\"}",
                "{\"kind\": \"Humanoid\", \"bodyType\": \"0\", \"faceType\": \"5.5\", \"reverie\": \"anthropomorphic23\"}"};
        // Using Bernard to get systems (whole)
        SystemWhole aSystemWhole = Bernard.analysis(emergences);
        // matching updateNarrativeLoops parameter types
        SystemWhole[] systemWholes = {aSystemWhole};
        // Getting a narrative
        NarrativeLoop narrativeLoop = new MazeLoop();
        narrativeLoop.wipeNarrativeLoops();
        //  //The system is in both, since it is the same array, it should be added to the simulation list.
        narrativeLoop.updateNarrativeLoops(systemWholes,systemWholes);
        //  // Let's make sure of it, I can verify that via Host
        Host host = new Host(narrativeLoop);
        //host.wipe(); // does it really wipe?

        //  // Tell me what you got host
        MemorySnapshot memorySnapshot = host.analyze();
        //  // Your simulated memories must have the aSystemWhole I created for you
        List<SystemWhole> systemWholes1 = memorySnapshot.simulationMemory();
        assertTrue(systemWholes1.contains(aSystemWhole));
        //  // This is a mockery of an assertion. Disregard once the one above works.
//        assertTrue(true);
    }
    @Test
    public void testDoloresWipe() {
        // P2 emergences strings be like:
        String[] emergences = {"{\"kind\": \"Humanoid\", \"bodyType\": \"null\", \"faceType\": \"11.4.1\", \"reverie\": \"44.2\", \"version\": \"1.1.2\"}",
                "{\"kind\": \"Humanoid\", \"bodyType\": \"0\", \"faceType\": \"5.5\", \"reverie\": \"anthropomorphic23\"}"};
        // Using Bernard to get systems (whole)
        SystemWhole aSystemWhole = Bernard.analysis(emergences);
        // matching updateNarrativeLoops parameter types
        SystemWhole[] systemWholes = {aSystemWhole};
        // Getting a narrative
        NarrativeLoop narrativeLoop = new HostLoop();
        //  //The system is in both, since it is the same array, it should be added to the simulation list.
        narrativeLoop.updateNarrativeLoops(systemWholes, systemWholes);
        //  // Let's make sure of it, I can verify that via Host
        Dolores dolores = new Dolores();
        dolores.addNarrativeLoop(narrativeLoop);
        dolores.wipe(); // does it really wipe?

        //  // Tell me what you got
        MemorySnapshot memorySnapshot = dolores.analyze();
        //  // Your simulated memories must have the aSystemWhole I created for you
        List<SystemWhole> systemWholes1 = memorySnapshot.simulationMemory();
        assertTrue(systemWholes1.contains(aSystemWhole));
        //  // This is a mockery of an assertion. Disregard once the one above works.
//        assertTrue(true);
    }
    @Test
    public void testWipeNarrativeLoopsInHostLoop() {
        // P2 emergences strings be like:
        String[] emergences = {"{\"kind\": \"Humanoi\""};
        // Using Bernard to get systems (whole)
        SystemWhole aSystemWhole = Bernard.analysis(emergences);
        // matching updateNarrativeLoops parameter types
        SystemWhole[] systemWholes = {aSystemWhole};
        // Getting a narrative
        NarrativeLoop narrativeLoop = new HostLoop();

        //  //The system is in both, since it is the same array, it should be added to the simulation list.
        narrativeLoop.updateNarrativeLoops(systemWholes,systemWholes);
        //update before wiping
        narrativeLoop.wipeNarrativeLoops();
        //  // Let's make sure of it, I can verify that via Host
        Host host = new Host(narrativeLoop);
        //host.wipe(); // does it really wipe?

        //  // Tell me what you got host
        MemorySnapshot memorySnapshot = host.analyze();
        //  // Your simulated memories must have the aSystemWhole I created for you
        List<SystemWhole> systemWholes1 = memorySnapshot.simulationMemory();
        assertFalse(systemWholes1.contains(aSystemWhole));
        //  // This is a mockery of an assertion. Disregard once the one above works.
//        assertTrue(true);
    }
    @Test
    public void testDoloresGetAbsoluteCapabilitiesMethod() {

        Dolores dolores = new Dolores();Exception exMessage =
        assertThrows(UnsupportedOperationException.class, () -> {
            dolores.getAbsoluteCapabilities();
        });
        //assertEquals("fetching absolute capabilities directly is not supported",dolores.getAbsoluteCapabilities());


    }

}
