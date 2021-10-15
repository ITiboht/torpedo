package hu.nye.progtech.torpedo.service.map.reader.impl;

import hu.nye.progtech.torpedo.service.exception.MapReadException;
import hu.nye.progtech.torpedo.service.map.reader.MapReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class MapReaderImplTest {

    private static final String LINE_1 = "line1";
    private static final String LINE_2 = "line2";

    @Mock
    private BufferedReader bufferedReader;

    private MapReaderImpl underTest;

    @BeforeEach
    public void setUp() {
        underTest = new MapReaderImpl(bufferedReader);
    }
    @Test
    public void testReadMapShouldReturnRowsReadFromMapReaderImpl() throws MapReadException, IOException {
        //given
        given(bufferedReader.readLine()).willReturn(LINE_1, LINE_2, null);

        //when
        List<String> result = underTest.readMap();

        //then
        assertEquals(List.of(LINE_1,LINE_2),result);

    }

    @Test
    public void testReadMapShouldThrowMapReadExceptionWhenMapReaderImplFailsToRead() throws MapReadException, IOException {
       //give
       doThrow(IOException.class).when(bufferedReader).readLine();

       //when - then
        assertThrows(MapReadException.class, () -> {
            underTest.readMap();
        });

    }

}
