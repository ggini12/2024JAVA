package report13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoffeeVendingMachine extends JFrame {

    // 재료 변수
    private int cup = 10;
    private int coffee = 10;
    private int water = 10;
    private int sugar = 10;
    private int cream = 10;

    // UI 컴포넌트
    private JProgressBar cupProgress;
    private JProgressBar coffeeProgress;
    private JProgressBar waterProgress;
    private JProgressBar sugarProgress;
    private JProgressBar creamProgress;
    private JLabel coffeeImageLabel;
    
    private JButton blackCoffeeButton;
    private JButton sugarCoffeeButton;
    private JButton dabangCoffeeButton;
    private JButton resetButton;

    public CoffeeVendingMachine() {
        setTitle("커피 자판기");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);

        // 1. NORTH에 "Welcome, Hot Coffee!!" 레이블을 가진 패널
        JPanel northPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome, Hot Coffee!!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        northPanel.add(welcomeLabel);
        add(northPanel, BorderLayout.NORTH);

        // 2. SOUTH에 4개의 버튼을 부착한 패널
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 4));
        
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetMachine();
            }
        });
        southPanel.add(resetButton);
        
        blackCoffeeButton = new JButton("Black Coffee");
        blackCoffeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serveCoffee("black");
            }
        });
        
        sugarCoffeeButton = new JButton("Sugar Coffee");
        sugarCoffeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serveCoffee("sugar");
            }
        });
        
        dabangCoffeeButton = new JButton("Dabang Coffee");
        dabangCoffeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serveCoffee("dabang");
            }
        });

        southPanel.add(blackCoffeeButton);
        southPanel.add(sugarCoffeeButton);
        southPanel.add(dabangCoffeeButton);
        add(southPanel, BorderLayout.SOUTH);

        // 3. CENTER에 커피 자판기 시뮬레이터의 핵심 기능을 가진 패널
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(6, 1));

        // 진행 바 표시
        cupProgress = createProgressBar();
        coffeeProgress = createProgressBar();
        waterProgress = createProgressBar();
        sugarProgress = createProgressBar();
        creamProgress = createProgressBar();
        
        centerPanel.add(new JLabel("컵"));
        centerPanel.add(cupProgress);
        centerPanel.add(new JLabel("커피"));
        centerPanel.add(coffeeProgress);
        centerPanel.add(new JLabel("물"));
        centerPanel.add(waterProgress);
        centerPanel.add(new JLabel("설탕"));
        centerPanel.add(sugarProgress);
        centerPanel.add(new JLabel("크림"));
        centerPanel.add(creamProgress);

        coffeeImageLabel = new JLabel();
        centerPanel.add(coffeeImageLabel);

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JProgressBar createProgressBar() {
        JProgressBar progressBar = new JProgressBar(0, 10);
        progressBar.setStringPainted(false);
        progressBar.setMaximum(10);
        progressBar.setValue(10);
        progressBar.setForeground(Color.GRAY);
        return progressBar;
    }

    private void serveCoffee(String coffeeType) {
        if (coffeeType.equals("black")) {
            if (coffee >= 1 && water >= 1 && cup >= 1) {
                coffee -= 1;
                water -= 1;
                cup -= 1;
                coffeeImageLabel.setIcon(new ImageIcon("black_coffee.png"));
                JOptionPane.showMessageDialog(this, "Black Coffee가 준비되었습니다 뜨거워요!");
            } else {
                showWarning("부족한 것이 있습니다. 채워주세요.");
            }
        } else if (coffeeType.equals("sugar")) {
            if (coffee >= 1 && water >= 1 && sugar >= 1 && cup >= 1) {
                coffee -= 1;
                water -= 1;
                sugar -= 1;
                cup -= 1;
                coffeeImageLabel.setIcon(new ImageIcon("sugar_coffee.png"));
                JOptionPane.showMessageDialog(this, "Sugar Coffee가 준비되었습니다 뜨거워요!");
            } else {
                showWarning("부족한 것이 있습니다. 채워주세요.");
            }
        } else if (coffeeType.equals("dabang")) {
            if (coffee >= 1 && water >= 1 && sugar >= 1 && cream >= 1 && cup >= 1) {
                coffee -= 1;
                water -= 1;
                sugar -= 1;
                cream -= 1;
                cup -= 1;
                coffeeImageLabel.setIcon(new ImageIcon("dabang_coffee.png"));
                JOptionPane.showMessageDialog(this, "Dabang Coffee가 준비되었습니다 뜨거워요!");
            } else {
                showWarning("부족한 것이 있습니다. 채워주세요.");
            }
        }
        updateProgressBars();
    }

    private void resetMachine() {
        cup = 10;
        coffee = 10;
        water = 10;
        sugar = 10;
        cream = 10;
        coffeeImageLabel.setIcon(null);
        updateProgressBars();
    }

    private void updateProgressBars() {
        cupProgress.setValue(cup);
        coffeeProgress.setValue(coffee);
        waterProgress.setValue(water);
        sugarProgress.setValue(sugar);
        creamProgress.setValue(cream);
    }

    private void showWarning(String message) {
        JOptionPane.showMessageDialog(this, message, "커피 자판기 경고", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CoffeeVendingMachine();
            }
        });
    }
}
