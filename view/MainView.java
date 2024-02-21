package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import simulator.Simulator;

public class MainView extends JFrame {
    public MainView() {
        setTitle("Maze");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMainView();
        setVisible(true);
    }

    private void setMainView() {
        Container mainContainer = getContentPane();

        mainContainer.setLayout(null);
        mainContainer.add(getMainTitle());
        mainContainer.add(getStarButton());
    }

    private JLabel getMainTitle() {
        int hight = 40;
        int width = 250;
        JLabel mainText = new JLabel("Maze Simulator", JLabel.CENTER);

        mainText.setFont(new Font("SERIF", Font.BOLD, 25));
        mainText.setBounds(500 / 2 - width / 2, 500 / 8 + hight, width, hight);
        return mainText;
    }

    private JButton getStarButton() {
        int hight = 50;
        int width = 150;
        JButton startButton = new JButton("Start");

        startButton.setBounds(500 / 2 - width / 2, 500 / 2 + hight, width, hight);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Simulator().start();
            }
        });
        return startButton;
    }

}
