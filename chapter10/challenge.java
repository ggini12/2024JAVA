package report9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class challenge extends JFrame {
    private JLabel numberLabel;  // 숫자가 나타날 레이블
    private JLabel resultLabel;  // 결과가 나타날 레이블
    private JButton oddButton, evenButton, checkButton, resetButton;  // 버튼들
    private int hiddenNumber;  // 숨겨진 숫자
    private String selectedAnswer = "";  // 사용자가 선택한 답 ('홀' 또는 '짝')

    public challenge() {
        setTitle("홀짝 맞추기 게임");
        setSize(400, 300); // 적절한 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 숫자 표시 레이블 (정사각형 모양)
        numberLabel = new JLabel("?", JLabel.CENTER);
        numberLabel.setFont(new Font("Serif", Font.BOLD, 100));
        numberLabel.setPreferredSize(new Dimension(100, 100));  // 정사각형 크기
        numberLabel.setBackground(Color.MAGENTA);
        numberLabel.setOpaque(true);

        // 결과 레이블 (기본 메시지 설정)
        resultLabel = new JLabel("답을 맞추기 전까지 무엇일까요?", JLabel.CENTER);
        resultLabel.setFont(new Font("Serif", Font.BOLD, 20));
        resultLabel.setForeground(Color.BLUE);

        // 버튼 생성
        oddButton = new JButton("홀");
        evenButton = new JButton("짝");
        checkButton = new JButton("확인");
        resetButton = new JButton("다시");

        // 홀 버튼 클릭 리스너
        oddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedAnswer = "홀";
            }
        });

        // 짝 버튼 클릭 리스너
        evenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedAnswer = "짝";
            }
        });

        // 확인 버튼 클릭 리스너
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "홀" 또는 "짝" 버튼이 눌렸는지 체크
                if (selectedAnswer.isEmpty()) {
                    resultLabel.setText("먼저 '홀' 또는 '짝'을 선택하세요.");
                    return;
                }

                // 숨겨진 숫자 생성 및 레이블 갱신
                if (numberLabel.getText().equals("?")) {
                    hiddenNumber = new Random().nextInt(10) + 1; // 1에서 10까지 숫자 생성
                    numberLabel.setText("?"); // 숫자는 숨겨둠
                }

                // 정답 확인
                checkAnswer();
            }
        });

        // 다시 버튼 클릭 리스너
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        // 버튼을 아래쪽에 배치
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(oddButton);
        buttonPanel.add(evenButton);
        buttonPanel.add(checkButton);
        buttonPanel.add(resetButton);

        // 중앙에 숫자 레이블과 결과 레이블 추가
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(numberLabel, BorderLayout.CENTER);
        centerPanel.add(resultLabel, BorderLayout.SOUTH);

        // 프레임에 컴포넌트 추가
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // 화면 중앙에 위치
    }

    // 게임 상태 초기화
    private void resetGame() {
        selectedAnswer = "";
        numberLabel.setText("?");
        resultLabel.setText("어떤 숫자일까요?"); // 초기 메시지로 되돌리기
    }

    // 정답 확인
    private void checkAnswer() {
        boolean isEven = hiddenNumber % 2 == 0;
        boolean isCorrect = (selectedAnswer.equals("홀") && !isEven) || (selectedAnswer.equals("짝") && isEven);

        // 숨겨진 숫자 보이기
        numberLabel.setText(String.valueOf(hiddenNumber));

        // 정답 유무 표시
        String message = isCorrect ? "정답!" : "틀렸습니다!";
        resultLabel.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                challenge game = new challenge();
                game.setVisible(true);
            }
        });
    }
}
