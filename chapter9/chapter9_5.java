package report8;
// 16개 색을 가진 4x4 바둑판 
import javax.swing.*;
import java.awt.*;

public class chapter9_5 {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("4x4 16 배경색 바둑판");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // GridLayout 설정 (4x4)
        frame.setLayout(new GridLayout(4, 4));

        // 수동으로 정의한 색상 배열
        Color[] colors = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.CYAN, Color.BLUE, Color.MAGENTA, Color.PINK,
            Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.BLACK,
            Color.WHITE, new Color(128, 0, 128), new Color(255, 165, 0), new Color(0, 128, 128)
        };

        // 16개의 JPanel 생성
        for (int i = 0; i < 16; i++) {
            // JPanel 생성
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            // 배경색 설정 (수동 정의된 색상)
            panel.setBackground(colors[i]);

            // JLabel 생성 및 번호 설정
            JLabel label = new JLabel(String.valueOf(i + 1)); // 1부터 시작
            label.setHorizontalAlignment(SwingConstants.LEFT); // 텍스트를 왼쪽 정렬
            label.setVerticalAlignment(SwingConstants.CENTER); // 텍스트를 중앙 정렬

            // 글자 색 설정 (배경색 대비를 위해)
            if (colors[i].equals(Color.BLACK)) {
                label.setForeground(Color.WHITE); // 검은 배경엔 흰 글자
            } else {
                label.setForeground(Color.BLACK); // 나머지는 검정 글자
            }

            // JLabel을 JPanel에 추가
            panel.add(label);

            // JPanel을 JFrame에 추가
            frame.add(panel);
        }

        // JFrame 보이도록 설정
        frame.setVisible(true);
    }
}
