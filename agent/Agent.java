package agent;

public class Agent {
    private Location location;
    private Direction direction;

    public Agent(Location location) {
        this.location = location;
        this.direction = Direction.DWON;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public Location getLocation() {
        return location;
    }

    public Direction getDirection() {
        return direction;
    }

    public void moveFront() {
        location = getFrontLocation();
    }

    public Location getFrontLocation() {
        return (new Location(location.getRow() + direction.getNextY(),
                location.getColumn() + direction.getNextX()));
    }

    public Location getRightLocation() {
        return (new Location(location.getRow() + direction.turnRight().getNextY(),
                location.getColumn() + direction.turnRight().getNextX()));
    }

    public Location getLeftLocation() {
        return (new Location(location.getRow() + direction.turnLeft().getNextY(),
                location.getColumn() + direction.turnLeft().getNextX()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("현재 위치 : (" + location.getRow() + ", " + location.getColumn() + ") \n");
        sb.append("현재 방향 : " + direction.getText() + "\n");
        return sb.toString();
    }
}