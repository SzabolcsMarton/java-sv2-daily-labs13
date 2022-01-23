package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    @Test
    void readFileTest() {
        Quiz quiz = new Quiz(Paths.get("src/test/resources/result.txt"));
        String expectedCorrectAnswers = "ABACD";

        assertEquals(expectedCorrectAnswers, quiz.getCorrectAnswer());
        assertEquals(4, quiz.getPlayers().size());
    }

    @Test
    void isCorrectTest() {
        Quiz quiz = new Quiz(Paths.get("src/test/resources/result.txt"));

        assertTrue(quiz.isAnswerCorrect("AB123", 1));
        assertTrue(quiz.isAnswerCorrect("AH2", 5));
        assertTrue(quiz.isAnswerCorrect("BD452", 4));

        assertFalse(quiz.isAnswerCorrect("AB123", 2));
        assertFalse(quiz.isAnswerCorrect("AB123", 4));
        assertFalse(quiz.isAnswerCorrect("BD452", 3));
    }

}