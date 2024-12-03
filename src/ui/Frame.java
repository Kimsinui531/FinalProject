package ui;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        setTitle("CardLayout 이동 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        Information310 info310 = new Information310();
        Information408 info408 = new Information408();

        cardPanel.add(new Panel310(cardLayout, cardPanel, info310), "패널 1");
        cardPanel.add(new Panel408(cardLayout, cardPanel, info408), "패널 2");

        SideBarPanel sidebar = new SideBarPanel(cardLayout, cardPanel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(cardPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}