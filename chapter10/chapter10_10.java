package report9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class chapter10_10 extends JFrame {
    private ArrayList<JLabel> blocks;  // 블록들을 저장할 리스트
    private Point offset;  // 드래그 오프셋
    private JLabel draggedBlock;  // 현재 드래그 중인 블록
    private Random random;  // 랜덤 색상 생성기

    public chapter10_10() {
        setTitle("Drag and Drop Blocks");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        blocks = new ArrayList<>();  // 블록 리스트 초기화
        random = new Random();  // 랜덤 객체 초기화

        // 키 이벤트 리스너: 'm' 키를 눌렀을 때 블록을 생성
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
                    createBlock();
                }
            }
        });

        // 포커스를 받을 수 있도록 설정
        setFocusable(true);

        setLocationRelativeTo(null);  // 화면 중앙에 위치
    }

    // 블록 생성 메서드
    private void createBlock() {
        JLabel block = new JLabel();
        block.setOpaque(true);
        block.setBounds(100, 100, 80, 80);  // 초기 위치 (100, 100) 및 크기 (80x80)
        block.setBackground(getRandomColor());  // 랜덤 색상 설정
        block.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                draggedBlock = block;
                offset = e.getPoint();  // 마우스 클릭 위치로부터의 오프셋 저장
            }
        });
        block.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (draggedBlock != null) {
                    int x = e.getX() + draggedBlock.getX() - offset.x;  // 새로운 x 좌표 계산
                    int y = e.getY() + draggedBlock.getY() - offset.y;  // 새로운 y 좌표 계산
                    draggedBlock.setLocation(x, y);  // 블록 이동
                }
            }
        });

        blocks.add(block);  // 블록을 리스트에 추가
        add(block);  // 프레임에 블록을 추가
        repaint();  // 화면 갱신
    }

    // 랜덤 색상 생성 메서드
    private Color getRandomColor() {
        int r = random.nextInt(256);  // 빨강 (0-255)
        int g = random.nextInt(256);  // 초록 (0-255)
        int b = random.nextInt(256);  // 파랑 (0-255)
        return new Color(r, g, b);  // 랜덤 색상 반환
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	chapter10_10 frame = new chapter10_10();
                frame.setVisible(true);
            }
        });
    }
}
