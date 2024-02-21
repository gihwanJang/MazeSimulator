package img;

import javax.swing.ImageIcon;

public enum Image {
    ROAD(new ImageIcon(Image.class.getResource("/img/road.png"))),
    WALL(new ImageIcon(Image.class.getResource("/img/wall.png"))),
    VISITED(new ImageIcon(Image.class.getResource("/img/visited.png"))),
    AGENT_DOWN(new ImageIcon(Image.class.getResource("/img/agent_down.png"))),
    AGENT_UP(new ImageIcon(Image.class.getResource("/img/agent_up.png"))),
    AGENT_RIGHT(new ImageIcon(Image.class.getResource("/img/agent_right.png"))),
    AGENT_LEFT(new ImageIcon(Image.class.getResource("/img/agent_left.png")));

    private ImageIcon image;

    private Image(ImageIcon icon) {
        this.image = icon;
    }

    public ImageIcon getImage() {
        return image;
    }
}
