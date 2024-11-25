package report7;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class chapter8_13 {
    private static Path currentDir = Paths.get("C:\\");  // C:\를 제대로 처리하려면 이와 같이 \\ 사용

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 초기 디렉터리 체크
        if (!Files.exists(currentDir) || !Files.isDirectory(currentDir)) {
            System.out.println("초기 디렉터리가 존재하지 않거나 디렉터리가 아닙니다.");
            return;
        }

        while (true) {
            try {
                // 현재 디렉터리 출력
                System.out.println("****** 파일 탐색기입니다. ******");
                System.out.println("[" + currentDir.toString() + "]");
                printDirectoryContents(currentDir);

                // 사용자 입력 받기
                System.out.print(">> ");
                String input = scanner.nextLine().trim();

                if (input.equals("그만")) {
                    break;  // 프로그램 종료
                } else if (input.equals("..")) {
                    // 부모 디렉터리로 이동
                    if (currentDir.getParent() != null) {
                        currentDir = currentDir.getParent();
                    } else {
                        System.out.println("더 이상 부모 디렉터리가 없습니다.");
                    }
                } else {
                    // 서브 디렉터리로 이동
                    Path newDir = currentDir.resolve(input);
                    if (Files.isDirectory(newDir)) {
                        currentDir = newDir;
                    } else {
                        System.out.println("유효하지 않은 디렉터리입니다.");
                    }
                }
            } catch (IOException e) {
                System.out.println("디렉터리 정보를 가져오는 데 오류가 발생했습니다.");
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    // 디렉터리 내용 출력
    private static void printDirectoryContents(Path dir) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    long size = getDirectorySize(entry);
                    System.out.printf("dir %d바이트 %s\n", size, entry.getFileName());
                } else {
                    long size = Files.size(entry);
                    System.out.printf("file %d바이트 %s\n", size, entry.getFileName());
                }
            }
        }
    }

    // 디렉터리 크기 계산
    private static long getDirectorySize(Path dir) throws IOException {
        final long[] size = {0};
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                size[0] += attrs.size();
                return FileVisitResult.CONTINUE;
            }
        });
        return size[0];
    }
}
