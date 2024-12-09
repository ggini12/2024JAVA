package report8;
// 왼쪽에 10개의 색상버튼, 가운데에 랜덤한 위치와 0~9 숫자 출력하기 
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class chapter9_10 {
    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("West Grid 프레임");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // ContentPane의 Layout 설정
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // WEST 영역 패널 (GridLayout 사용)
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(10, 1, 5, 5)); // 10개의 버튼, 세로로 배치
        westPanel.setPreferredSize(new Dimension(40, 0)); // 살짝 넓게 보이도록 설정

        // 버튼 색상 배열 (임의로 정의)
        Color[] buttonColors = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.CYAN, Color.BLUE, Color.MAGENTA, Color.PINK,
            Color.LIGHT_GRAY, new Color(128, 0, 128) // 보라색
        };

        // WEST 영역에 버튼 추가
        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton();
            button.setBackground(buttonColors[i - 1]); // 색상 적용
            button.setOpaque(true); // 배경색이 표시되도록 설정
            button.setBorderPainted(false); // 테두리 제거
            westPanel.add(button);
        }
        contentPane.add(westPanel, BorderLayout.WEST);

        // CENTER 영역 패널
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE); // 하얀 배경 설정
        centerPanel.setLayout(null); // 절대 배치 사용
        contentPane.add(centerPanel, BorderLayout.CENTER);

        // 랜덤 숫자 출력
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(String.valueOf(random.nextInt(10))); // 0~9 랜덤 숫자
            label.setFont(new Font("Arial", Font.BOLD, 16)); // 숫자 크기와 스타일 설정

            // 랜덤 좌표 설정 (50,50 ~ 200,200 범위)
            int x = 50 + random.nextInt(151); // 50~200
            int y = 50 + random.nextInt(151); // 50~200
            label.setBounds(x, y, 20, 20); // 위치와 크기 설정
            centerPanel.add(label); // CENTER 패널에 추가
        }

        // JFrame 보이도록 설정
        frame.setVisible(true);
    }
}

