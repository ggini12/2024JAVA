package report8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class challenge extends JFrame {
    private String text = "I can't help falling in love with you";
    private String[] words = text.split(" "); // 단어 분리
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel gameLabel, inputLabel;
    private JTextField inputField;
    private JButton newTextButton;

    public challenge() {
        setTitle("단어 조합 게임");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ContentPane의 Layout 설정
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // NORTH 패널
        northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        gameLabel = new JLabel("단어 조합 게임!");
        newTextButton = new JButton("New Text");
        northPanel.add(gameLabel);
        northPanel.add(newTextButton);
        contentPane.add(northPanel, BorderLayout.NORTH);

        // CENTER 패널
        centerPanel = new JPanel();
        centerPanel.setLayout(null); // 절대 배치 사용
        addWordsToCenterPanel();
        contentPane.add(centerPanel, BorderLayout.CENTER);

        // SOUTH 패널
        southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        inputLabel = new JLabel("단어 입력:");
        inputField = new JTextField(20);
        southPanel.add(inputLabel);
        southPanel.add(inputField);
        contentPane.add(southPanel, BorderLayout.SOUTH);

        // New Text 버튼 이벤트 리스너
        newTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerPanel.removeAll(); // 기존 단어 제거
                addWordsToCenterPanel(); // 새 단어 추가
                centerPanel.revalidate();
                centerPanel.repaint();
            }
        });

        setVisible(true);
    }

    private void addWordsToCenterPanel() {
        Random rand = new Random();
        for (String word : words) {
            JLabel wordLabel = new JLabel(word);
            int x = rand.nextInt(350); // x 좌표: 0~350
            int y = rand.nextInt(180); // y 좌표: 0~180
            wordLabel.setBounds(x, y, 100, 20); // 절대 배치에서 위치 설정
            centerPanel.add(wordLabel);
        }
    }

    public static void main(String[] args) {
        new challenge();
    }
}

