package report3;

import java.util.HashMap;
import java.util.Scanner;

class MonthDiary {
    private int year;
    private int month;
    private HashMap<Integer, String> diaryEntries;

    public MonthDiary(int year, int month) {
        this.year = year;
        this.month = month;
        this.diaryEntries = new HashMap<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("기록 : 1, 보기 : 2, 종료 : 3  >>> ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    recordEntry(scanner);
                    break;
                case 2:
                    displayEntries();
                    break;
                case 3:
                    System.out.println("다이어리를 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private void recordEntry(Scanner scanner) {
        System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자 이하) >>> ");
        int date = scanner.nextInt();
        String text = scanner.next();

        if (date < 1 || date > 30) {
            System.out.println("유효한 날짜를 입력하세요.");
            return;
        }
        if (text.length() > 4) {
            System.out.println("텍스트는 4글자 이하로 입력하세요.");
            return;
        }

        diaryEntries.put(date, text);
        System.out.println("기록되었습니다.");
    }

    private void displayEntries() {
        if (diaryEntries.isEmpty()) {
            System.out.println("기록된 내용이 없습니다.");
            return;
        }

        for (int date = 1; date <= 30; date++) {
            String entry = diaryEntries.get(date);
            if (entry != null) {
                System.out.printf("%-4s     ", entry); // 4글자 너비로 정렬하고 공백 추가
            } else {
                System.out.printf("###     "); // 비어있는 경우 '###'로 표시
            }
            if (date % 7 == 0) { // 7개마다 줄바꿈
                System.out.println();
            }
        }
        System.out.println("\n");
    }
}

public class chapter4_10 {
    public static void main(String[] args) {
        MonthDiary monthDiary = new MonthDiary(2024, 10);  // 2024년 10월 다이어리
        monthDiary.run();
    }
}
