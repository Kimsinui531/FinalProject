package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout 이동 예제");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430, 600);


        // 카드 레이아웃 생성
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // 패널 추가
        cardPanel.add(createPanel1(cardLayout, cardPanel), "패널 1");
        cardPanel.add(createPanel2(cardLayout, cardPanel), "패널 2");

        // 프레임에 카드 패널 추가
        frame.add(cardPanel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // 화면 중앙에 위치
    }

    // 패널 1 생성 메서드
    private static JPanel createPanel1(CardLayout cardLayout, JPanel cardPanel) {
        JPanel panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 패널 1a (상단 버튼)
        JPanel panel1a = new JPanel(new FlowLayout());
        JButton buttonToPanel2 = new JButton("06-408로 이동");
        panel1a.add(buttonToPanel2);

        // 패널 1b (중간 레이블)
        JPanel panel1b = new JPanel(new FlowLayout());
        JLabel screen310 = new JLabel("                   06-310 스크린                ");
        screen310.setOpaque(true); // 배경색을 보이게 하려면 Opaque를 true로 설정
        screen310.setBackground(new Color(51, 153, 255)); // 배경색 설정
        screen310.setForeground(Color.WHITE); // 글자색 설정
        panel1b.add(screen310);

        // 패널 1c (하단 버튼들)
        JPanel panel1c = new JPanel(new FlowLayout());
        JButton[] b1 = new JButton[5];
        for (int i = 0; i < 5; i++) {
            b1[i] = new JButton(i + 1 + "번 자리");
            b1[i].setPreferredSize(new Dimension(76, 30)); // 버튼 크기 설정
            panel1c.add(b1[i]);
        }

        // GridBagConstraints 설정
        gbc.fill = GridBagConstraints.BOTH;

        // panel1a 추가 (1 비율)
        gbc.weightx = 1; // 가로 비율
        gbc.weighty = 0; // 세로 비율
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(panel1a, gbc);

        // panel1b 추가 (1 비율)
        gbc.weightx = 1; // 가로 비율
        gbc.weighty = 0; // 세로 비율
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(panel1b, gbc);

        // panel1c 추가 (8 비율)
        gbc.weightx = 8; // 가로 비율
        gbc.weighty = 1; // 세로 비율
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(panel1c, gbc);

        // 버튼에 액션 리스너 추가
        buttonToPanel2.addActionListener(e -> cardLayout.show(cardPanel, "패널 2")); // 패널 2로 전환

        return panel1;
    }

    // 패널 2 생성 메서드
    private static JPanel createPanel2(CardLayout cardLayout, JPanel cardPanel) {
        JPanel panel2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 패널 2a (상단 버튼)
        JPanel panel2a = new JPanel(new FlowLayout());
        JButton buttonToPanel1 = new JButton("06-310로 이동");
        panel2a.add(buttonToPanel1);

        // 패널 2b (중간 레이블)
        JPanel panel2b = new JPanel(new FlowLayout());
        JLabel screen408 = new JLabel("                   06-408 스크린                ");
        screen408.setOpaque(true); // 배경색을 보이게 하려면 Opaque를 true로 설정
        screen408.setBackground(new Color(51, 153, 255)); // 배경색 설정
        screen408.setForeground(Color.WHITE); // 글자색 설정
        panel2b.add(screen408);

        // 패널 2c (하단 버튼들)
        JPanel panel2c = new JPanel(new FlowLayout());
        JButton[] b2 = new JButton[7];
        for (int i = 0; i < b2.length; i++) {
            b2[i] = new JButton(i + 1 + "번 자리");
            b2[i].setPreferredSize(new Dimension(76, 30)); // 버튼 크기 설정
            panel2c.add(b2[i]);
        }

        // GridBagConstraints 설정
        gbc.fill = GridBagConstraints.BOTH;

        // panel2a 추가 (1 비율)
        gbc.weightx = 1; // 가로 비율
        gbc.weighty = 0; // 세로 비율
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel2.add(panel2a, gbc);

        // panel2b 추가 (1 비율)
        gbc.weightx = 1; // 가로 비율
        gbc.weighty = 0; // 세로 비율
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel2.add(panel2b, gbc);

        // panel2c 추가 (8 비율)
        gbc.weightx = 8; // 가로 비율
        gbc.weighty = 1; // 세로 비율
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel2.add(panel2c, gbc);

        // 버튼에 액션 리스너 추가
        buttonToPanel1.addActionListener(e -> cardLayout.show(cardPanel, "패널 1")); // 패널 1로 전환

        return panel2;
    }
}