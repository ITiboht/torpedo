package hu.nye.progtech.torpedo.service.map.reader.impl;

import hu.nye.progtech.torpedo.service.exception.MapReadException;
import hu.nye.progtech.torpedo.service.map.reader.MapReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MapReaderImpl implements MapReader {

    private BufferedReader bufferedReader;

    public MapReaderImpl(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public List<String> readMap() throws MapReadException {


        String line;
        List<String> result = new ArrayList<>();

        try {
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            throw new MapReadException("Failed to load map");
        }

        return result;
    }
}
