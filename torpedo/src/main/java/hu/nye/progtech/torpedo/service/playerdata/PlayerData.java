package hu.nye.progtech.torpedo.service.playerdata;

public class PlayerData {

    private String playerName;
    private int winRecord;

    public PlayerData(String playerName, int winRecord) {
        this.playerName = playerName;
        this.winRecord = winRecord;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getWinRecord() {
        return winRecord;
    }

    public void setWinRecord(int winRecord) {
        this.winRecord = winRecord;
    }



}
