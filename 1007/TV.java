package report4;
class Device {
    void on() {
        System.out.println("켜졌습니다.");
    }

    void off() {
        System.out.println("종료합니다.");
    }
    void watch() {
        System.out.println("방송중입니다.");
    }
}

public class TV extends Device {
    public static void main(String[] args) {
        TV myTV = new TV();
        myTV.on();
        myTV.watch();
        myTV.off();
    }
}

