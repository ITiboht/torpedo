package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.MapVO;
import hu.nye.progtech.torpedo.service.exception.MapParserException;
import hu.nye.progtech.torpedo.service.exception.MapReadException;
import hu.nye.progtech.torpedo.service.map.parser.MapParser;
import hu.nye.progtech.torpedo.service.map.reader.MapReader;
import hu.nye.progtech.torpedo.service.map.reader.impl.MapReaderImpl;
import hu.nye.progtech.torpedo.service.playerdata.PlayerData;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/gameBoard");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        MapReader mapReader = new MapReaderImpl(bufferedReader);
        try {
            List<String> strings = mapReader.readMap();
            System.out.println(strings);

            MapParser mapParser = new MapParser(10,10);
            MapVO mapVO1 = mapParser.parseMap(strings);
            System.out.printf(String.valueOf(mapVO1));
        } catch (MapReadException e) {
            e.printStackTrace();
        } catch (MapParserException e) {
            e.printStackTrace();
        }

        System.out.println("Welcome to BattelShip!");
        System.out.println("[1] - New Game");
        System.out.println("[2] - Leaderboard");
        System.out.println("[3] - Exit");

        Scanner in = new Scanner(System.in);
        int menu = Integer.parseInt(in.nextLine());

        if(menu == 1){
            System.out.printf("Enter name: ");
            String playerName = in.nextLine();
            PlayerData playerData = new PlayerData(playerName,0);
            System.out.println("");
            System.out.printf(String.valueOf(playerName));
        } else if(in.equals(menu == 2)){
            System.out.println("Not yet implemented.");
        } else if(in.equals(menu == 3)){
            System.out.println("");
        }

    }


}
