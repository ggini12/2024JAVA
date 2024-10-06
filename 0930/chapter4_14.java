package report3;

import java.util.Arrays;

class VArray {
    private int[] array;
    private int size; // 현재 저장된 개수
    private int capacity; // 배열의 용량

    public VArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    // 현재 용량을 반환
    public int capacity() {
        return capacity;
    }

    // 저장된 개수를 반환
    public int size() {
        return size;
    }

    // 배열에 값 추가
    public void add(int value) {
        ensureCapacity();
        array[size++] = value;
    }

    // 배열의 인덱스에 값 삽입
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        ensureCapacity();
        // 인덱스부터 끝까지 한 칸씩 뒤로 이동
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    // 배열의 인덱스에 있는 값 삭제
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        // 인덱스 이후의 모든 요소를 한 칸씩 앞으로 이동
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    // 현재 배열의 모든 요소 출력
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 배열의 용량을 확보
    private void ensureCapacity() {
        if (size >= capacity) {
            capacity *= 2; // 용량 두 배로 증가
            array = Arrays.copyOf(array, capacity); // 새로운 크기의 배열로 복사
        }
    }

    @Override
    public String toString() {
        return "용량 : " + capacity + ", 저장된 개수 : " + size;
    }
}

public class chapter4_14 {
    public static void main(String[] args) {
        VArray v = new VArray(5);  // 5개의 정수를 저장하는 가변 배열 객체 생성
        System.out.println(v);

        for (int i = 0; i < 7; i++)  // 7개 저장
            v.add(i);
        System.out.println(v);
        v.printAll();

        v.insert(3, 100); // 배열의 인덱스 3에 100 삽입
        v.insert(5, 200); // 배열의 인덱스 5에 200 삽입
        System.out.println(v);
        v.printAll();

        v.remove(10);  // 배열의 인덱스 10의 정수 삭제
        System.out.println(v);
        v.printAll();

        for (int i = 50; i < 55; i++) // 5개 저장
            v.add(i); // 배열에 순서대로 정수 i 값 저장
        System.out.println(v);
        v.printAll();
    }
}
