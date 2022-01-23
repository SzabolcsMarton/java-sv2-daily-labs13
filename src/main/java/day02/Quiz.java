package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {

    private String correctAnswer;
    private List<Player> players = new ArrayList<>();


    public Quiz(Path path) {
        readFromFile(path);
    }

    public boolean isAnswerCorrect(String playerCode, int questionNumber) {
        String playerAnswer = "";
        for (Player actual : players) {
            if (actual.getCodeName().equals(playerCode)) {
                playerAnswer = actual.getAnswers();
            }
        }

        return playerAnswer.charAt(questionNumber - 1) == correctAnswer.charAt(questionNumber - 1);
    }

    public String getWinnersCodeName() {
        Player player = null;
        int max = Integer.MIN_VALUE;
        for (Player actual : players) {
            if (actual.getPoints() > max) {
                player = actual;
                max = actual.getPoints();
            }
        }
        return player.getCodeName();
    }


    private void readFromFile(Path path) {
        try {
            parseAllLines(Files.readAllLines(path));
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }

    private void parseAllLines(List<String> linesFromFile) {
        this.correctAnswer = linesFromFile.get(0);
        linesFromFile.remove(0);
        createAndAddPlayersToList(linesFromFile);
    }

    private Map<String, String> parseAnswers(List<String> answerLines) {
        Map<String, String> result = new HashMap<>();
        for (String actual : answerLines) {
            String[] temp = actual.split(" ");
            if (result.containsKey(temp[0])) {
                result.put(temp[0], result.get(temp[0]) + temp[1]);
            } else {
                result.put(temp[0], temp[1]);
            }
        }
        return result;
    }

    private void createAndAddPlayersToList(List<String> answerLines) {
        for (Map.Entry actual : parseAnswers(answerLines).entrySet()) {
            players.add(new Player(actual.getKey().toString(), actual.getValue().toString(), this.correctAnswer));
        }
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<Player> getPlayers() {
        return players;
    }

}
