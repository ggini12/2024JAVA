package report13;
import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class chapter14_7 {

    private static Clip audioClip;

    public static void main(String[] args) {
        // JFrame 설정
        JFrame frame = new JFrame("오디오 연주 프로그램");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();

        // "오디오" 메뉴
        JMenu audioMenu = new JMenu("오디오");

        // "연주" 메뉴아이템
        JMenuItem playItem = new JMenuItem("연주");
        playItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAudio();
            }
        });

        // "종료" 메뉴아이템
        JMenuItem stopItem = new JMenuItem("종료");
        stopItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAudio();
            }
        });

        // "오디오" 메뉴에 아이템 추가
        audioMenu.add(playItem);
        audioMenu.add(stopItem);

        // 메뉴바에 "오디오" 메뉴 추가
        menuBar.add(audioMenu);

        // 메뉴바를 JFrame에 설정
        frame.setJMenuBar(menuBar);

        // JFrame 보이기
        frame.setVisible(true);
    }

    // 오디오 파일을 선택하여 연주하는 메소드
    private static void playAudio() {
        // JFileChooser를 이용하여 파일 선택
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("오디오 파일 선택");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("WAV Files", "wav"));

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File audioFile = fileChooser.getSelectedFile();

            try {
                // 선택한 WAV 파일을 오디오 입력 스트림으로 읽음
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                audioClip = AudioSystem.getClip();
                audioClip.open(audioStream);

                // 오디오 재생
                audioClip.start();
                JOptionPane.showMessageDialog(null, "오디오 연주 시작!");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                JOptionPane.showMessageDialog(null, "오디오 파일을 열 수 없습니다: " + ex.getMessage());
            }
        }
    }

    // 오디오 연주를 종료하는 메소드
    private static void stopAudio() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
            JOptionPane.showMessageDialog(null, "오디오 연주 종료");
        } else {
            JOptionPane.showMessageDialog(null, "연주 중인 오디오가 없습니다.");
        }
    }
}
