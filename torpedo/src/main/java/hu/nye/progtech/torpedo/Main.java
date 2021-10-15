package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.service.exception.MapReadException;
import hu.nye.progtech.torpedo.service.map.reader.MapReader;
import hu.nye.progtech.torpedo.service.map.reader.impl.MapReaderImpl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        char ship = 'S';
        char hit = '+';
        char miss = 'X';
        char clearShip = '#';


        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/gameBoard");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        MapReader mapReader = new MapReaderImpl(bufferedReader);
        try {
            List<String> strings = mapReader.readMap();
            System.out.println(strings);
        } catch (MapReadException e) {
            e.printStackTrace();
        }

    }

}
