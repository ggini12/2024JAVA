package report3;

class ArrayUtil {
    public static int[] concat(int[] a, int[] b) {
        // 두 배열의 길이를 합쳐서 새로운 배열 생성
        int[] result = new int[a.length + b.length];
        
        // 첫 번째 배열 a를 결과 배열에 복사
        System.arraycopy(a, 0, result, 0, a.length);
        
        // 두 번째 배열 b를 결과 배열에 복사
        System.arraycopy(b, 0, result, a.length, b.length);
        
        return result; // 새로운 배열 리턴
    }

    public static void print(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(" "); // 배열 요소 사이에 공백 추가
            }
        }
        System.out.print("]");
    }
}

public class chapter4_11 {
    public static void main(String[] args) {
        int[] array1 = {1, 5, 7, 9};
        int[] array2 = {3, 6, -1, 100, 77};
        int[] array3 = ArrayUtil.concat(array1, array2); // 배열 합치기
        ArrayUtil.print(array3); // 배열 출력
    }
}
