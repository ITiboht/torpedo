package hu.nye.progtech.torpedo.model;

import java.util.Arrays;
import java.util.Objects;

public class MapVO {

    private final int numberOfRows;
    private final int numberOfColumns;
    private final String[][] gameBoard;

    public MapVO(int numberOfRows, int numberOfColumns, String[][] gameBoard) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.gameBoard = deepcopy(gameBoard);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public String[][] getGameBoard() {
        return deepcopy(this.gameBoard);
    }


    private String[][] deepcopy(String[][] gameBoard){
        String[][] result = new String[gameBoard.length][];

        for (int i=0;i< gameBoard.length;i++){
            result[i] = new String[gameBoard[i].length];
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
        return numberOfRows == mapVO.numberOfRows && numberOfColumns == mapVO.numberOfColumns && Arrays.equals(gameBoard, mapVO.gameBoard);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRows, numberOfColumns);
        result = 31 * result + Arrays.hashCode(gameBoard);
        return result;
    }

    @Override
    public String toString() {
        return "MapVO{" +
                "numberOfRows=" + numberOfRows +
                ", numberOfColumns=" + numberOfColumns +
                ", gameBoard=" + Arrays.deepToString(gameBoard) +
                '}';
    }
}
