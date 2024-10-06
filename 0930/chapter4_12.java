package report3;

import java.util.Scanner;

class dictionary{
	private static String[] kor = {"사랑","아기","돈","미래","희망"};
	private static String[] eng = {"love","baby","money","future","hope"};
	public static String kor2eng(String word) {
		for(int i=0;i<kor.length;i++) {
			if(kor[i].equals(word)) {
				return eng[i];
			}
		}
		return null;
	}		
}

public class chapter4_12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		while(true) {
			System.out.print("한글 단어?");
			input = scanner.next();
			
			if(input.equals("그만")) {
				break;
			}
			String translation = dictionary.kor2eng(input);
			if (translation != null) {
                System.out.println(input + "은 " + translation);
            } else {
                System.out.println(input + "의 저의 사전에 없습니다.");
            }
		}
	}
}
