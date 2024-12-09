package report10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class challenge extends JFrame {
    private JLabel imageLabel;
    private ArrayList<ImageIcon> images;
    private int currentIndex;

    public challenge() {
        setTitle("Image Gallery");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 이미지 리스트 초기화
        images = new ArrayList<>();
        images.add(new ImageIcon("C:\\Users\\ggini\\Downloads\\cat.jpg"));
        images.add(new ImageIcon("C:\\Users\\ggini\\Downloads\\dog.jpg"));
        images.add(new ImageIcon("C:\\Users\\ggini\\Downloads\\horse.jpg"));
        images.add(new ImageIcon("C:\\Users\\ggini\\Downloads\\tiger.jpg"));
        // 필요한 만큼 이미지를 추가

        currentIndex = 0;

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        updateImage();

        MenuPanel menuPanel = new MenuPanel();

        add(imageLabel, BorderLayout.CENTER);
        add(menuPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateImage() {
        if (currentIndex < 0) {
            currentIndex = images.size() - 1;
        } else if (currentIndex >= images.size()) {
            currentIndex = 0;
        }
        imageLabel.setIcon(images.get(currentIndex));
    }

    private class MenuPanel extends JPanel {
        public MenuPanel() {
            JButton leftButton = new JButton(new ImageIcon("C:\\Users\\ggini\\Downloads\\left.jpg"));
            JButton rightButton = new JButton(new ImageIcon("C:\\Users\\ggini\\Downloads\\right.jpg"));

            // 버튼 크기 조정
            int buttonWidth = 50;  // 원하는 너비
            int buttonHeight = 50;  // 원하는 높이
            Dimension buttonSize = new Dimension(buttonWidth, buttonHeight);

            leftButton.setPreferredSize(buttonSize);
            rightButton.setPreferredSize(buttonSize);

            leftButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentIndex--;
                    updateImage();
                }
            });

            rightButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentIndex++;
                    updateImage();
                }
            });

            setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
            add(leftButton);
            add(rightButton);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new challenge();
            }
        });
    }
}
