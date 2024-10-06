package report3;

class Average {
    int[] scores; 
    int count;     
    int MAX_SIZE = 10;  

   
    public Average() {
        scores = new int[MAX_SIZE];
        count = 0;
    }

   
    public void put(int score) {
        if (count < MAX_SIZE) {
            scores[count] = score;
            count++;
        } else {
            System.out.println("더 이상 점수를 저장할 수 없습니다. (최대 " + MAX_SIZE + "개)");
        }
    }

   
    public void showAll() {
        System.out.print("저장된 점수: ");
        for (int i = 0; i < count; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println(); 
    }

 
    public double getAvg() {
        if (count == 0) {
            return 0; 
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += scores[i];
        }
        return (double) sum / count; 
    }
}

public class chapter4_4 {
	public static void main(String[] args) {
		Average avg = new Average();
		avg.put(10);  // 10저장
		avg.put(15);  // 15저장
		avg.put(100);  // 100저장
		avg.showAll();  // 저장된 모든 원소출력
		System.out.println("평균은 "+avg.getAvg()); // 평균출력
	}
}
