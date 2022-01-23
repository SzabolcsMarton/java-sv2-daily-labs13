package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getPlayersPointsTest() {
        Player player = new Player("AH2", "XBAXD", "ABACD");
        Player otherPlayer = new Player("BD452", "XXBCX", "ABACD");

        assertEquals(10, player.getPoints());
        assertEquals(2, otherPlayer.getPoints());
    }

}