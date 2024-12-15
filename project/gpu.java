package ject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class gpu {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // JDBC 드라이버 로딩 (명시적으로 추가)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  // MySQL JDBC 드라이버 로딩
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "JDBC 드라이버 로드 실패: " + e.getMessage(),
                        "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JFrame frame = new JFrame("GPT가 추천해주는 그래픽카드");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // JTable과 DefaultTableModel 생성
            DefaultTableModel tableModel = new DefaultTableModel();
            JTable table = new JTable(tableModel);

            // 데이터베이스 연결 및 데이터 가져오기
            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/gpu", "root", "1234");
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM gpu")) {

                // ResultSet의 메타데이터로 테이블 헤더 설정
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    tableModel.addColumn(metaData.getColumnName(i));
                }

                // ResultSet 데이터를 행으로 추가
                while (resultSet.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = resultSet.getObject(i);
                    }
                    tableModel.addRow(row);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "데이터베이스 연결 오류: " + e.getMessage(),
                        "오류", JOptionPane.ERROR_MESSAGE);
            }

            // JTable을 스크롤 가능한 형태로 추가
            frame.add(new JScrollPane(table));
            frame.setSize(1500, 400);
            frame.setVisible(true);
        });
    }
}
