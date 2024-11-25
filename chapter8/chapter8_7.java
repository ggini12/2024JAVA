package report7;
import java.io.*;

public class chapter8_7 {
    public static void main(String[] args) {
        // 복사할 파일 경로와 대상 파일 경로 지정
        String sourceFile = "a.jpg";
        String destinationFile = "b.jpg";
        
        // 파일 복사 진행
        copyFileWithProgress(sourceFile, destinationFile);
    }
    
    public static void copyFileWithProgress(String sourceFile, String destinationFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        File source = new File(sourceFile);
        
        try {
            // 입력 스트림과 출력 스트림을 생성
            fis = new FileInputStream(source);
            fos = new FileOutputStream(destinationFile);
            
            // 원본 파일의 크기 확인
            long totalBytes = source.length();
            long bytesCopied = 0;
            byte[] buffer = new byte[1024]; // 1KB씩 읽어옴
            int bytesRead;
            
            // 파일을 읽고 쓰면서 진행 상태 출력
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                bytesCopied += bytesRead;
                
                // 10%마다 '*' 출력
                if (bytesCopied * 100 / totalBytes >= (bytesCopied - bytesRead) * 100 / totalBytes + 10) {
                    System.out.print("*");
                }
            }
            System.out.println(); // 진행 상태가 끝난 후 줄 바꿈
            System.out.println("파일 복사가 완료되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
