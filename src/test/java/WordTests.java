import at.tarnoczi.model.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import at.tarnoczi.model.Word;

/**
 * Beschreibung des Programms
 *
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class WordTests {
    @Test
    @DisplayName("Normal Test")
    void test1() {
        Word w1 = new Word("Auto", "https://i.pinimg.com/originals/8e/b7/f8/8eb7f846e94c68d25df1d127bfd945c4.png");
        assertEquals("Auto", w1.getWord());
    }

    @Test
    @DisplayName("Word null")
    void test2() {
        assertThrows(IllegalArgumentException.class, () ->
            { Word w1 = new Word(null, "https://i.pinimg.com/originals/8e/b7/f8/8eb7f846e94c68d25df1d127bfd945c4.png"); }
        );
    }

    @Test
    @DisplayName("Word empty")
    void test3() {
        assertThrows(IllegalArgumentException.class, () ->
            { Word w1 = new Word("", "https://i.pinimg.com/originals/8e/b7/f8/8eb7f846e94c68d25df1d127bfd945c4.png"); }
        );
    }

    @Test
    @DisplayName("URL null")
    void test4() {
        assertThrows(IllegalArgumentException.class, () ->
            { Word w1 = new Word("Auto", null); }
        );
    }

    @Test
    @DisplayName("URL empty")
    void test5() {
        assertThrows(IllegalArgumentException.class, () ->
            { Word w1 = new Word("Auto", ""); }
        );
    }

    @Test
    @DisplayName("URL invalid")
    void test6() {
        assertThrows(IllegalArgumentException.class, () ->
            { Word w1 = new Word("Auto", "Auto"); }
        );
    }
}
