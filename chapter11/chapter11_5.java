package report10;
// 게이지바 
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable; // 이 줄을 추가합니다

public class chapter11_5 extends JFrame {

    private JLabel label;
    private JSlider slider;

    public chapter11_5() {
        setTitle("Slider Example");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel("100");
        slider = new JSlider(100, 200, 100);
        slider.setMajorTickSpacing(20); // 주요 눈금 간격 설정
        slider.setPaintTicks(true); // 눈금 표시
        slider.setPaintLabels(true); // 레이블 표시

        // 커스텀 레이블 추가
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(100, new JLabel("100"));
        labelTable.put(120, new JLabel("120"));
        labelTable.put(140, new JLabel("140"));
        labelTable.put(160, new JLabel("160"));
        labelTable.put(180, new JLabel("180"));
        labelTable.put(200, new JLabel("200"));
        slider.setLabelTable(labelTable);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText("" + slider.getValue());
            }
        });

        add(slider);
        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new chapter11_5();
            }
        });
    }
}
