package report3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        this.score += points;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}

class GuessGame {
    private List<Player> players;

    public GuessGame() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void playRound() {
        Random random = new Random();
        int hiddenNumber = random.nextInt(100) + 1; // 1~100 사이의 숫자 생성
        System.out.println("숨겨진 숫자가 생성되었습니다. (1~100 사이)");

        Scanner scanner = new Scanner(System.in);
        int closestDifference = Integer.MAX_VALUE;
        Player closestPlayer = null;

        for (Player player : players) {
            System.out.print(player.getName() + ", 숫자를 추측하세요: ");
            int guess = scanner.nextInt();
            int difference = Math.abs(hiddenNumber - guess);

            if (difference < closestDifference) {
                closestDifference = difference;
                closestPlayer = player;
            }
        }

        System.out.println("숨겨진 숫자: " + hiddenNumber);
        System.out.println(closestPlayer.getName() + "가 가장 가까운 숫자를 맞췄습니다!");
        closestPlayer.addScore(1);
    }

    public void showScores() {
        System.out.println("\n현재 점수:");
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public Player findWinner() {
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
        }
        return winner;
    }
}

public class chapter4_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GuessGame game = new GuessGame();

        System.out.print("게임에 참여할 플레이어 수를 입력하세요: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("플레이어 이름을 입력하세요: ");
            String name = scanner.nextLine();
            Player player = new Player(name);
            game.addPlayer(player);
        }

        boolean continuePlaying = true;

        while (continuePlaying) {
            game.playRound();
            game.showScores();

            System.out.print("다시 플레이하시겠습니까? (예: y / 아니오: n): ");
            String response = scanner.next();
            continuePlaying = response.equalsIgnoreCase("y");
        }

        Player winner = game.findWinner();
        System.out.println("\n최종 승자는 " + winner.getName() + "입니다! 총 점수: " + winner.getScore());
    }
}
