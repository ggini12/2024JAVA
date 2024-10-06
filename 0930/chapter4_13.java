package report3;

import java.util.Scanner;

public class chapter4_13 {
    private static final int SEAT_COUNT = 10;
    private static final String[][] seats = new String[3][SEAT_COUNT];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("명품 콘서트홀 예약 시스템입니다.");
            System.out.println("예약 : 1, 조회 : 2, 취소 : 3, 끝내기 : 4");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    reserveSeat(scanner);
                    break;
                case 2:
                    showSeats();
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    System.out.println("시스템을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴입니다. 다시 시도하세요.");
            }
        } while (choice != 4);
        
        scanner.close();
    }

    private static void reserveSeat(Scanner scanner) {
        System.out.println("좌석구분 s(1), a(2), b(3)");
        int section = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (section < 1 || section > 3) {
            System.out.println("잘못된 좌석 구분입니다.");
            return;
        }

        String seatType = (section == 1) ? "s" : (section == 2) ? "a" : "b";
        System.out.println(seatType + ">> " + displaySeats(section - 1));

        System.out.print("이름 >> ");
        String name = scanner.nextLine();
        System.out.print("번호 >> ");
        int number = scanner.nextInt() - 1; // Convert to 0-index
        scanner.nextLine(); // Consume newline

        if (number < 0 || number >= SEAT_COUNT) {
            System.out.println("잘못된 좌석 번호입니다.");
            return;
        }

        if (seats[section - 1][number] != null) {
            System.out.println("이미 예약된 좌석입니다.");
        } else {
            seats[section - 1][number] = name;
            System.out.println("예약 완료되었습니다.");
        }
    }

    private static void showSeats() {
        System.out.println("s>> " + displaySeats(0));
        System.out.println("a>> " + displaySeats(1));
        System.out.println("b>> " + displaySeats(2));
    }

    private static String displaySeats(int section) {
        StringBuilder seatDisplay = new StringBuilder();
        for (String seat : seats[section]) {
            seatDisplay.append(seat == null ? "---" : seat).append(" ");
        }
        return seatDisplay.toString().trim();
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("이름 >> ");
        String name = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < SEAT_COUNT; j++) {
                if (name.equals(seats[i][j])) {
                    seats[i][j] = null;
                    found = true;
                    System.out.println("예약이 취소되었습니다.");
                }
            }
        }

        if (!found) {
            System.out.println("해당 이름으로 예약된 좌석이 없습니다.");
        }
    }
}
