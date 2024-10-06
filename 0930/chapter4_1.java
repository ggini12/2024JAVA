package report3;

class TV {
    String brand;  // TV 브랜드
    int size;      // TV 크기 (인치)
    int price;     // TV 가격 (만원)

    // 생성자
    public TV(String brand, int size, int price) {
        this.brand = brand;
        this.size = size;
        this.price = price;
    }

    // TV 정보를 출력하는 메소드
    public void show() {
        System.out.println(brand + "에서 만든 "+ price + "만원짜리 "  + size + "인치 TV");
    }
}

public class chapter4_1 {
	public static void main(String[] args) {
		TV tv = new TV("Samsung", 50, 300);  // 300만원짜리 Samsung에서 만든 50인치 TV
		tv.show();
	}
}
