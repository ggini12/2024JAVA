package report4;

class tele {
    private int size;

    public tele(int size) {
        this.size = size;
    }

    protected int getSize() {
        return size;
    }
}

class ColorTV extends tele {
    private int color;

    public ColorTV(int size, int color) {
    	super(size);
        this.color = color;
    }

    public void printProperty() {
        System.out.println(getSize() + "인치 " + color + "컬러");
    }

    public static void main(String[] args) {
        ColorTV myTv = new ColorTV(65, 65536);  // 65인치 크기에 65536 컬러 TV
        myTv.printProperty();
    }
}
