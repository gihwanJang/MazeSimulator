package agent;

public enum Direction {
    LEFT(0, "left"), DWON(1, "down"), RIGHT(2, "right"), UP(3, "up");

    private int direction;
    private int[] dy = { 0, 1, 0, -1 };
    private int[] dx = { -1, 0, 1, 0 };
    private String text;

    private Direction(int direction, String text) {
        this.direction = direction;
        this.text = text;
    }

    public int getDiarection() {
        return direction;
    }

    public String getText() {
        return text;
    }

    public int getNextX() {
        return dx[this.getDiarection()];
    }

    public int getNextY() {
        return dy[this.getDiarection()];
    }

    public Direction turnLeft() {
        if (this.getDiarection() == LEFT.getDiarection()) {
            return DWON;
        } else if (this.getDiarection() == DWON.getDiarection()) {
            return RIGHT;
        } else if (this.getDiarection() == RIGHT.getDiarection()) {
            return UP;
        } else {
            return LEFT;
        }
    }

    public Direction turnRight() {
        if (this.getDiarection() == LEFT.getDiarection()) {
            return UP;
        } else if (this.getDiarection() == DWON.getDiarection()) {
            return LEFT;
        } else if (this.getDiarection() == RIGHT.getDiarection()) {
            return DWON;
        } else {
            return RIGHT;
        }
    }
}
