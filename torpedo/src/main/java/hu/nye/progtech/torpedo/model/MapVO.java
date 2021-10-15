package hu.nye.progtech.torpedo.model;

import java.util.Arrays;
import java.util.Objects;

public class MapVO {

    private final int numberOfRows;
    private final int nuberofColumns;
    private final char[][] gameBoard;
    private final char[][] fixed;

    public MapVO(int numberOfRows, int nuberofColumns, char[][] gameBoard, char[][] fixed) {
        this.numberOfRows = numberOfRows;
        this.nuberofColumns = nuberofColumns;
        this.gameBoard = deepcopy(gameBoard);
        this.fixed = deepcopy(fixed);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNuberofColumns() {
        return nuberofColumns;
    }

    public char[][] getGameBoard() {
        return deepcopy(this.gameBoard);
    }

    public char[][] getFixed() {
        return deepcopy(this.fixed);
    }

    private char[][] deepcopy(char[][] gameBoard){
        char[][] result = new char[gameBoard.length][];

        for (int i=0;i< gameBoard.length;i++){
            result[i] = new char[gameBoard[i].length];
            for (int j=0;j< gameBoard[i].length;j++){
                result[i][j] = gameBoard[i][j];
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapVO mapVO = (MapVO) o;
        return numberOfRows == mapVO.numberOfRows && nuberofColumns == mapVO.nuberofColumns && Arrays.equals(gameBoard, mapVO.gameBoard) && Arrays.equals(fixed, mapVO.fixed);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRows, nuberofColumns);
        result = 31 * result + Arrays.hashCode(gameBoard);
        result = 31 * result + Arrays.hashCode(fixed);
        return result;
    }

    @Override
    public String toString() {
        return "MapVO{" +
                "numberOfRows=" + numberOfRows +
                ", nuberofColumns=" + nuberofColumns +
                ", gameBoard=" + Arrays.deepToString(gameBoard) +
                ", fixed=" + Arrays.deepToString(fixed) +
                '}';
    }
}
