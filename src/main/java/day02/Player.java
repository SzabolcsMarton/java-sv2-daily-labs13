package day02;

public class Player {

    private String codeName;
    private String answers;
    private int points;

    public Player(String codeName, String answers, String correctAnswer) {
        this.codeName = codeName;
        this.answers = answers;
        this.points = getPlayersPoints(correctAnswer);
    }

    private int getPlayersPoints(String correctAnswers) {
        int result = 0;
        for (int i = 0; i < correctAnswers.length(); i++) {
            if (answers.charAt(i) != 'X' && correctAnswers.charAt(i) == this.answers.charAt(i)) {
                result += i + 1;
            }
            if (answers.charAt(i) != 'X' && correctAnswers.charAt(i) != this.answers.charAt(i)) {
                result -= 2;
            }
        }

        return result;
    }

    public int getPoints() {
        return points;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getAnswers() {
        return answers;
    }
}
