package report2;

import java.nio.file.spi.FileSystemProvider;
import java.util.Random;
import java.util.Scanner;

public class chapter3_12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String boyMiddleList[] = {"기","민","용","종","현","진","재","승","소","상","지"};
		String boyLastList[] = {"태","진","광","혁","우","철","빈","준","구","호","석"};
		String girlMiddleList[] = {"은","원","경","수","현","예","여","송","서","채","하"};
		String girlLastList[] = {"진","연","경","서","리","숙","미","원","린","희","수"};
		
		while(true) {
			System.out.print("성별을 입력하세요 남/여/그만 입력 : ");
			String gender = scanner.nextLine();
			
			if(gender.equals("그만")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			System.out.print("성을 입력해주세요 : ");
			String firstName = scanner.nextLine();
			if(gender.equals("남")) {
				String boyMiddleName = boyMiddleList[random.nextInt(boyMiddleList.length)];
				String boyLastName = boyLastList[random.nextInt(boyLastList.length)];
				System.out.println("생성된 남자 이름 : "+firstName+boyMiddleName+boyLastName);
			}
			else if(gender.equals("여")) {
				String girlMiddleName = girlMiddleList[random.nextInt(girlMiddleList.length)];
				String girlLastName = girlLastList[random.nextInt(girlLastList.length)];
				System.out.println("생성된 여자 이름 : "+firstName+girlMiddleName+girlLastName);
			}
			else {
				System.out.println("잘못된 입력입니다. (남/여/그만)을 입력하세요.");
			}
	}
}
}

