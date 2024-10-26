package report4;
import java.util.Arrays;
import java.util.Scanner;

class BaseArrays {
    protected int[] array;  // 배열 메모리
    protected int nextIndex = 0;  // 다음에 삽입할 배열에 대한 인덱스

    public BaseArrays(int size) {
        array = new int[size];
    }

    public int length() {
        return array.length;
    }

    public void add(int n) { // 정수 n을 배열 끝에 추가
        if (nextIndex == array.length) return;  // 배열이 꽉찼으면 추가 안함
        array[nextIndex] = n;
        nextIndex++;
    }

    public void print() {
        Arrays.sort(array, 0, nextIndex); // 현재까지의 요소를 정렬
        for (int i = 0; i < nextIndex; i++) {
            System.out.print(array[i] + " "); // 현재까지의 요소 출력
        }
        System.out.println();
    }
}

class BinaryArrays extends BaseArrays {
    private int threshold; // 임계값

    public BinaryArrays(int size, int threshold) {
        super(size);
        this.threshold = threshold;
    }

    @Override
    public void add(int n) {
        if (nextIndex == array.length) return; // 배열이 꽉찼으면 추가 안함
        // 임계값보다 크면 1, 그렇지 않으면 0
        array[nextIndex] = (n > threshold) ? 1 : 0;
        nextIndex++;
    }
}

public class chapter5_10 {
    public static void main(String[] args) {
        int threshold = 50; // 임계값 50
        BaseArrays bArray = new BaseArrays(10); // BaseArray 사용

        Scanner scanner = new Scanner(System.in);
        System.out.print(">> ");
        for (int i = 0; i < bArray.length(); i++) {  // bArray.length()는 10
            int n = scanner.nextInt();
            bArray.add(n);
        }
        bArray.print();
        scanner.close();
    }
}
