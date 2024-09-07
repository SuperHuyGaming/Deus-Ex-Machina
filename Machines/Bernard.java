package src.main;
/*
 * Name: Huy Truong
 * netID: htruon5
 * G#: 01452512
 * Lecture section: 003
 * Lab section: 205
 */
/**
 * The {@code Bernard} class offers analytical utilities for processing emergences within the narrative framework.
 * It serves as a factory for creating {@link SystemWhole} instances based on provided emergences.
 */
public class Bernard {

    /**
     * Analyzes the given emergences and encapsulates them into a {@link SystemWhole} instance.
     * This method acts as a bridge between raw emergence data and the structured narratives {@link NarrativeLoop}.
     * @param emergences An array of {@code String} representing individual emergences to be analyzed.
     * @return A new {@link SystemWhole} instance containing the analyzed emergences. 
     */
    public static final SystemWhole analysis(String[] emergences) {
        // These violent delights have violent ends...
        return new SystemWhole(emergences);
    }
}
