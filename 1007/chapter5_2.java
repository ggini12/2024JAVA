package report4;

class SmartTV {
    private String ipAddress;
    private int size;
    private int color;

    public SmartTV(String ipAddress, int size, int color) {
        this.ipAddress = ipAddress;
        this.size = size;
        this.color = color;
    }

    public void printProperty() {
        System.out.println("나의 SmartTV는 " + ipAddress + " 주소의 " + size + "인치 " + color + "컬러 TV");
    }
}

public class chapter5_2 {
    public static void main(String[] args) {
        SmartTV smartTV = new SmartTV("192.168.0.5", 77, 20000000);  // 192.168.0.5 주소의 77인치 20000000 컬러 TV
        smartTV.printProperty();
    }
}
