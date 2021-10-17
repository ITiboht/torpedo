package hu.nye.progtech.torpedo.ui;

import hu.nye.progtech.torpedo.service.map.parser.MapParser;

public class MapRender {
    public static void main(String[] args) {
        MapParser mapRender = new MapParser(10,10);
        for(int i=0;i<10;i++){
            for(int j=0;i<10;i++){
                System.out.println(mapRender);
            }
        }
    }
}
