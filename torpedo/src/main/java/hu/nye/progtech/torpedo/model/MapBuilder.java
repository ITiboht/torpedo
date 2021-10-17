package hu.nye.progtech.torpedo.model;

import java.util.Objects;

public class MapBuilder {
    public static MapBuilder builder() {
        return new MapBuilder();
    }
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public MapBuilder() {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MapBuilder that = (MapBuilder) o;
        return minX == that.minX && maxX == that.maxX && minY == that.minY && maxY == that.maxY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minX, maxX, minY, maxY);
    }

    @Override
    public String toString() {
        return "MapBuilder{" +
                "minX=" + minX +
                ", maxX=" + maxX +
                ", minY=" + minY +
                ", maxY=" + maxY +
                '}';
    }

}
