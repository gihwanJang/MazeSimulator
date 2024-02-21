package map;

import java.util.Random;
import java.util.Arrays;

public class Map {
    private int size;
    private int[][] map;

    public Map() {
        int wall;
        long seed = System.currentTimeMillis();
        Random rand = new Random(seed);

        this.size = rand.nextInt(15) + 5;
        this.map = new int[size][size];
        wall = size * size / 4;
        while (wall > 0) {
            int row = rand.nextInt(size);
            int column = rand.nextInt(size);

            if (!(row == 0 && column == 0) && map[row][column] == 0) {
                map[row][column] = 1;
                --wall;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean getMapInfo(int row, int column) {
        return (map[row][column] == 0);
    }

    public boolean isValidate(int row, int column) {
        return (0 <= row && row < size
                &&
                0 <= column && column < size
                &&
                map[row][column] == 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; ++i) {
            sb.append(Arrays.toString(map[i])).append("\n");
        }
        return sb.toString();
    }
}
