package simulator;

import javax.swing.JOptionPane;

import agent.Agent;
import agent.Location;
import map.Map;
import view.MazeView;

public class Simulator extends Thread {
    private Map map;
    private Agent agent;
    private MazeView view;
    private boolean[][][] visited;

    public Simulator() {
        this.map = new Map();
        this.view = new MazeView(map);
        this.agent = new Agent(new Location(0, 0));
        this.visited = new boolean[map.getSize()][map.getSize()][4];
    }

    @Override
    public void run() {
        System.out.println(map.toString());
        while (step() && !(agent.getLocation().getRow() == map.getSize() - 1
                && agent.getLocation().getColumn() == map.getSize() - 1)) {

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (agent.getLocation().getRow() == map.getSize() - 1 && agent.getLocation().getColumn() == map.getSize() - 1) {
            JOptionPane.showMessageDialog(null, "Success");
            System.out.println("Success");
        } else {
            JOptionPane.showMessageDialog(null, "Fail");
            System.out.println("Fail");
        }
    }

    private boolean step() {
        if (canMove(agent.getRightLocation())) {
            agent.turnRight();
            System.out.println(agent);
            view.moveTurn(agent.getLocation(), agent.getDirection());
            if (isExit()) {
                return false;
            }
            visited[agent.getLocation().getRow()][agent.getLocation().getColumn()][agent.getDirection()
                    .getDiarection()] = true;
            view.moveAget(agent.getLocation(), agent.getFrontLocation());
            agent.moveFront();
            System.out.println(agent);
        } else if (canMove(agent.getFrontLocation())) {
            if (isExit()) {
                return false;
            }
            visited[agent.getLocation().getRow()][agent.getLocation().getColumn()][agent.getDirection()
                    .getDiarection()] = true;
            view.moveAget(agent.getLocation(), agent.getFrontLocation());
            agent.moveFront();
            System.out.println(agent);
        } else {
            agent.turnLeft();
            System.out.println(agent);
            view.moveTurn(agent.getLocation(), agent.getDirection());
        }
        return true;
    }

    private boolean canMove(Location next) {
        return (map.isValidate(next.getRow(), next.getColumn()));
    }

    private boolean isExit() {
        return (visited[agent.getLocation().getRow()][agent.getLocation().getColumn()][agent.getDirection()
                .getDiarection()]);
    }
}
