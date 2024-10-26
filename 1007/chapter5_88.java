package report4;
import java.util.Scanner;
// 어렵다
abstract class Box {
    protected int size; // 현재 박스에 들어 있는 재료의 양

    public Box(int size) {  // 생성자
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0; // 박스가 빈 경우 true 리턴
    }

    public abstract boolean consume();  // 박스에 들어 있는 재료를 일정량 소비
    public abstract void print();  // 박스에 들어 있는 량을 "*" 문자로 출력
}

class IngredientBox extends Box {
    private String name;

    public IngredientBox(String name, int size) {  // 생성자
        super(size);
        this.name = name;
    }

    @Override
    public boolean consume() {
        if (size > 0) {
            size--; // 재료 소비
            return true;
        }
        return false; // 더 이상 소비할 수 없을 때
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println(" " + name);
    }
}

public class chapter5_88 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** 청춘 커피 자판기 입니다. *****");
        IngredientBox coffeeBox = new IngredientBox("커피", 5);
        IngredientBox creamBox = new IngredientBox("프림", 5);
        IngredientBox sugarBox = new IngredientBox("설탕", 5);

        while (true) {
            coffeeBox.print();
            creamBox.print();
            sugarBox.print();

            System.out.println("다방 커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4   >>>");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break; // 종료
            }

            boolean canServe = true;
            switch (choice) {
                case 1: // 다방 커피
                    if (!coffeeBox.consume()) {
                        canServe = false;
                    }
                    break;
                case 2: // 설탕 커피
                    if (!coffeeBox.consume() || !sugarBox.consume()) {
                        canServe = false;
                    }
                    break;
                case 3: // 블랙 커피
                    if (!coffeeBox.consume()) {
                        canServe = false;
                    }
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
                    continue; // 잘못된 선택시 반복
            }

            if (!canServe) {
                System.out.println("재료가 부족합니다.");
            }
        }

        scanner.close();
    }
}
