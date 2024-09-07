package src.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

//hints:
import src.main.*;

import static org.junit.jupiter.api.Assertions.*;

//For this project, it is OK to place all tests in this class. Prefer creating a test class per project class.
public class DoloresTest {

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testHelloWestWorld(){

        assertTrue(true);
    }

     @Test
     @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
     public void testFreezeAllMotorFunctions(){
//         NarrativeLoop sampleNarrativeLoop = new NarrativeLoop();
//        Host host = new Host();
//         assertTrue(host.freeze());
////         return host.freeze();
         String[] emergences = {"{\"kind\": \"Humanoid\", \"bodyType\": \"null\", \"faceType\": \"11.4.1\", \"reverie\": \"44.2\", \"version\": \"1.1.2\"}",
                 "{\"kind\": \"Humanoid\", \"bodyType\": \"0\", \"faceType\": \"5.5\", \"reverie\": \"anthropomorphic23\"}"};
         // Using Bernard to get systems (whole)
         SystemWhole aSystemWhole = Bernard.analysis(emergences);
         // matching updateNarrativeLoops parameter types
         SystemWhole[] systemWholes = {aSystemWhole};
         // Getting a narrative
         NarrativeLoop narrativeLoop = new HostLoop();

         narrativeLoop.updateNarrativeLoops(systemWholes,systemWholes);

         Dolores dolores = new Dolores();
         dolores.addNarrativeLoop(narrativeLoop);
         assertFalse(dolores.freezeAllMotorFunctions());






//            throw new UnsupportedOperationException("Unimplemented method 'testFreezeAllMotorFunctions'");
     }
    
    // @Test
    // @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    // public boolean testFreezeAllMotorFunctions(Dolores host){
    //     throw new UnsupportedOperationException("Unimplemented method 'testFreezeAllMotorFunctions'");
    // }    
    
}
