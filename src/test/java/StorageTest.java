import at.tarnoczi.model.WordTrainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Beschreibung des Programms
 *
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class StorageTest {
    @DisplayName("Test der Laden-Methode")
    @Test
    void test1() {
        WordTrainer wordTrainer = new WordTrainer();
        assertEquals(14, wordTrainer.getTotal());
        assertEquals(7, wordTrainer.getWords().size());
        assertEquals(7, wordTrainer.getCorrect());
        assertEquals("Auto", wordTrainer.getWords().get(0).getWord());
    }

    @DisplayName("Testen der Speichern-Methode")
    @Test
    void test2() {
        WordTrainer wordTrainer = new WordTrainer();
        wordTrainer.setTotal(14);
        wordTrainer.store();
        wordTrainer.load();
        assertEquals(14, wordTrainer.getTotal());
    }
}
