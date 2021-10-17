package hu.nye.progtech.torpedo.gamecontroller;

public class GameController {
    private int loop;
    private char ship = 'S';
    private char hit = '+';
    private char miss = 'X';
    private char clearShip = '#';

    public GameController(int loop, char ship, char hit, char miss, char clearShip) {
        this.loop = loop;
        this.ship = ship;
        this.hit = hit;
        this.miss = miss;
        this.clearShip = clearShip;
    }

    public int getLoop() {
        return loop;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    public char getShip() {
        return ship;
    }

    public void setShip(char ship) {
        this.ship = ship;
    }

    public char getHit() {
        return hit;
    }

    public void setHit(char hit) {
        this.hit = hit;
    }

    public char getMiss() {
        return miss;
    }

    public void setMiss(char miss) {
        this.miss = miss;
    }

    public char getClearShip() {
        return clearShip;
    }

    public void setClearShip(char clearShip) {
        this.clearShip = clearShip;
    }



}
