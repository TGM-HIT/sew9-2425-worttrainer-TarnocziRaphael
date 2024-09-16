import at.tarnoczi.model.WordTrainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Beschreibung des Programms
 *
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class WordTrainerTests {
    @Test
    @DisplayName("Testen der check-Methode")
    void test1() {
        WordTrainer wordTrainer = new WordTrainer();
        String word = wordTrainer.getCurrentWord().getWord();
        assertEquals(true, wordTrainer.check(word));
        assertEquals(false, wordTrainer.check("Raphael"));
    }

    @Test
    @DisplayName("Testen der setTotal-Methode")
    void test2() {
        WordTrainer wordTrainer = new WordTrainer();
        assertThrows(IllegalArgumentException.class, () -> {wordTrainer.setTotal(-1);});
    }
    @Test
    @DisplayName("Testen der setTotal-Methode")
    void test3() {
        WordTrainer wordTrainer = new WordTrainer();
        assertThrows(IllegalArgumentException.class, () -> {wordTrainer.setCorrect(-1);});
    }

    @Test
    @DisplayName("Testen der setWords-Methode mittels null")
    void test4() {
        WordTrainer wordTrainer = new WordTrainer();
        assertThrows(IllegalArgumentException.class, () -> {wordTrainer.setWords(null);});
    }

    @Test
    @DisplayName("Testen der setWords-Methode mittels leerer Liste")
    void test5() {
        WordTrainer wordTrainer = new WordTrainer();
        assertThrows(IllegalArgumentException.class, () -> {wordTrainer.setWords(new ArrayList<>());});
    }
}
