package report10;
// 흩뿌려진 텍스트를 조합해서 맞추면 성공하는 게임
// You are the dancing queen 
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class chapter11_10 extends JFrame {
    private JLabel instructionLabel;
    private JLabel displayLabel;
    private JButton newTextButton;
    private JPanel wordPanel;
    private String sentence = "You are the dancing queen";
    private String[] words = sentence.split(" ");
    private List<JLabel> wordLabels;
    private StringBuilder completedSentence;
    
    public chapter11_10() {
        setTitle("문장 완성 게임");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.GRAY);
        
        instructionLabel = new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요~~");
        displayLabel = new JLabel(">> ");
        newTextButton = new JButton("New Text");
        
        topPanel.add(instructionLabel, BorderLayout.CENTER);
        topPanel.add(newTextButton, BorderLayout.EAST);
        
        wordPanel = new JPanel(null);
        wordPanel.setBackground(Color.WHITE);
        
        add(topPanel, BorderLayout.NORTH);
        add(wordPanel, BorderLayout.CENTER);
        add(displayLabel, BorderLayout.SOUTH);
        
        completedSentence = new StringBuilder();
        wordLabels = new ArrayList<>();
        
        newTextButton.addActionListener(e -> addNewWord());
        
        setVisible(true);
    }
    
    private void addNewWord() {
        if (wordLabels.size() < words.length) {
            String word = words[wordLabels.size()];
            JLabel wordLabel = new JLabel(word);
            wordLabel.setOpaque(true);
            wordLabel.setBackground(new Color(0, 0, 0, 0));
            wordLabel.setForeground(Color.BLACK);
            wordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            wordLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (wordLabel.getBackground().getAlpha() == 0) {
                        completedSentence.append(word).append(" ");
                        displayLabel.setText(">> " + completedSentence.toString().trim());
                        wordLabel.setBackground(new Color(211, 211, 211)); // 더 옅은 회색
                        
                        if (completedSentence.toString().trim().equals(sentence)) {
                            displayLabel.setText(displayLabel.getText() + " 성공!");
                        }
                    }
                }
            });
            wordLabels.add(wordLabel);

            int x = (int) (Math.random() * (wordPanel.getWidth() - 50));
            int y = (int) (Math.random() * (wordPanel.getHeight() - 30));
            wordLabel.setBounds(x, y, wordLabel.getPreferredSize().width, wordLabel.getPreferredSize().height);
            wordPanel.add(wordLabel);
        }
        
        wordPanel.revalidate();
        wordPanel.repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(chapter11_10::new);
    }
}
