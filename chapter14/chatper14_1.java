package report13;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chatper14_1 {

    public static void main(String[] args) {
        // JFrame을 생성하고 기본 설정
        JFrame frame = new JFrame("메뉴 만들기");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();

        // "파일" 메뉴
        JMenu fileMenu = new JMenu("파일");
        

        // "편집" 메뉴
        JMenu editMenu = new JMenu("편집");
        

        // "보기" 메뉴
        JMenu viewMenu = new JMenu("보기");
        JMenuItem zoomInItem = new JMenuItem("화면확대");
        JMenuItem outlineItem = new JMenuItem("쪽윤곽");
        viewMenu.add(zoomInItem);
        viewMenu.add(outlineItem);

        // "입력" 메뉴
        JMenu inputMenu = new JMenu("입력");
        

        // 메뉴바에 메뉴 추가
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(inputMenu);

        // 메뉴바를 JFrame에 설정
        frame.setJMenuBar(menuBar);

        // JFrame 표시
        frame.setVisible(true);
    }
}
