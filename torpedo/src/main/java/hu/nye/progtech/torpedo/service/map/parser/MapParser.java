package hu.nye.progtech.torpedo.service.map.parser;

import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.service.exception.MapParserException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MapParser {

    private static final String VALID_ROW_REGEX = "[~]+";

    private int numberOfRows;
    private int numberOfColumns;

    public MapParser(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public MapVO parseMap(List<String> rawMap) throws MapParserException {
        checkNumberOfRow(rawMap);
        checkNumberOfColumns(rawMap);
        checkForInvalidValues(rawMap);

        String[][] map = getMap(rawMap);

        return new MapVO(numberOfRows,numberOfColumns,map);
    }

    private void checkNumberOfRow(List<String> rows) throws MapParserException {
        if(rows.size() != numberOfRows){
            throw new MapParserException("Number of rows must be " + numberOfRows);
        }
    }
    private void checkNumberOfColumns(List<String> rows) throws MapParserException {
        for (String row : rows) {
            if(row.length() != numberOfColumns){
                throw new MapParserException("Number of columns must be " + numberOfColumns);
            }
        }
    }

    private void checkForInvalidValues(List<String> rows) throws MapParserException {
        for(String row : rows){
            if(!Pattern.matches(VALID_ROW_REGEX, row)){
                throw new MapParserException("Row contains invalid character(s)");
            }
        }
    }

    private String[][] getMap(List<String> rawMap){
        String[][] result = new String[numberOfRows][];

        for(int i=0; i<numberOfRows; i++){

            result[i] = new String[numberOfColumns];
            String line = rawMap.get(i);
            String[] parts = line.split("");

            for(int j=0; j<numberOfColumns; j++){
                String parsed = String.valueOf(parts[j]);
                result[i][j] = parsed;
            }
        }

        return result;
    }

}
