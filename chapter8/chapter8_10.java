package report7;
import java.util.*;

public class chapter8_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("문자열들을 입력하세요 >> ");
            String input = scanner.nextLine();

            // "그만"을 입력하면 종료
            if (input.equals("그만")) {
                break;
            }

            // 문자열을 공백 기준으로 분리
            String[] words = input.split(" ");
            
            // Set을 사용하여 중복된 단어 제거
            Set<String> uniqueWords = new LinkedHashSet<>(Arrays.asList(words));
            
            // 중복 제거된 단어 출력
            System.out.println(String.join(" ", uniqueWords));
        }

        scanner.close();
    }
}
