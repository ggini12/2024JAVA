package report9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class chapter10_5 extends JFrame {
    private JLabel labelC;  // "C"를 표시하는 레이블
    private Random random;  // 랜덤 숫자 생성기

    public chapter10_5() {
        setTitle("Click Practice");
        setSize(400, 400); // 창 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  // 위치를 절대값으로 설정

        random = new Random();  // 랜덤 객체 생성

        // "C"를 표시하는 JLabel 생성
        labelC = new JLabel("C");
        labelC.setFont(new Font("Serif", Font.BOLD, 35));
        labelC.setBounds(100, 100, 50, 50); // 초기 위치 (100, 100) 설정 JLabel 가로 세로 크기
        labelC.setForeground(Color.black);

        // "C" 레이블에 마우스 클릭 이벤트 리스너 추가
        labelC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                moveLabelRandomly();  // "C" 클릭 시 랜덤한 위치로 이동
            }
        });

        // "C" 레이블을 프레임에 추가
        add(labelC);

        setLocationRelativeTo(null); // 화면 중앙에 위치
    }

    // "C"를 랜덤한 위치로 이동하는 메서드
    private void moveLabelRandomly() {
        // 창의 크기 내에서 랜덤 위치 생성 (0부터 350까지)
        int x = random.nextInt(getWidth() - labelC.getWidth());
        int y = random.nextInt(getHeight() - labelC.getHeight());

        // "C" 레이블을 랜덤한 위치로 이동
        labelC.setLocation(x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	chapter10_5 frame = new chapter10_5();
                frame.setVisible(true);
            }
        });
    }
}
