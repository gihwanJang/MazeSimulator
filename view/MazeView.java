package view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import agent.Direction;
import agent.Location;
import img.Image;
import map.Map;

public class MazeView extends JFrame {
    private final int width = 500;
    private final int hight = 500;
    private JLabel[][] mapImage;

    public MazeView(Map map) {
        setMapImage(map);
        setTitle("Maze");
        setSize(width, hight);
        setMapView();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void moveAget(Location previous, Location current) {
        Icon tmp = mapImage[previous.getRow()][previous.getColumn()].getIcon();
        mapImage[current.getRow()][current.getColumn()].setIcon(tmp);
        mapImage[previous.getRow()][previous.getColumn()].setIcon(getReSizeImage(Image.VISITED.getImage()));
    }

    public void moveTurn(Location current, Direction direction) {
        if (direction == Direction.LEFT) {
            mapImage[current.getRow()][current.getColumn()].setIcon(getReSizeImage(Image.AGENT_LEFT.getImage()));
        } else if (direction == Direction.RIGHT) {
            mapImage[current.getRow()][current.getColumn()].setIcon(getReSizeImage(Image.AGENT_RIGHT.getImage()));
        } else if (direction == Direction.UP) {
            mapImage[current.getRow()][current.getColumn()].setIcon(getReSizeImage(Image.AGENT_UP.getImage()));
        } else {
            mapImage[current.getRow()][current.getColumn()].setIcon(getReSizeImage(Image.AGENT_DOWN.getImage()));
        }
    }

    private void setMapView() {
        Container mainContainer = getContentPane();

        mainContainer.removeAll();
        mainContainer.setLayout(new GridLayout(mapImage.length, mapImage.length));
        for (int r = 0; r < mapImage.length; ++r) {
            for (int c = 0; c < mapImage.length; ++c) {
                mainContainer.add(mapImage[r][c]);
            }
        }
    }

    private void setMapImage(Map map) {
        mapImage = new JLabel[map.getSize()][map.getSize()];
        for (int r = 0; r < mapImage.length; ++r) {
            for (int c = 0; c < mapImage.length; ++c) {
                if (map.getMapInfo(r, c)) {
                    mapImage[r][c] = getRoad();
                } else {
                    mapImage[r][c] = getWall();
                }
            }
        }
        mapImage[0][0] = getAgentDown();
    }

    private JLabel getRoad() {
        return new JLabel(getReSizeImage(Image.ROAD.getImage()));
    }

    private JLabel getWall() {
        return new JLabel(getReSizeImage(Image.WALL.getImage()));
    }

    private JLabel getAgentDown() {
        return new JLabel(getReSizeImage(Image.AGENT_DOWN.getImage()));
    }

    private ImageIcon getReSizeImage(ImageIcon icon) {
        return new ImageIcon(icon.getImage().getScaledInstance(width / mapImage.length, hight / mapImage.length, 0));
    }
}
