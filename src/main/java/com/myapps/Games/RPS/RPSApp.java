package com.myapps.Games.RPS;

import com.myapps.utils.Utils;

import java.util.Random;

public class RPSApp {
    public void startRPS() {
        RPSUtils.intro();
        new Utils().pause();

        System.out.print("\nJak brzmi twe imię, śmiałku? ");
        String name = new Utils().getUserString();
        System.out.println("Jestem tuż za tobą, " + name + ".");

        int playerPoints = 0;
        int cpuPoints = 0;

        while (playerPoints != 3 && cpuPoints != 3) {
            System.out.print("\n\nWybierz swoje przeznaczenie: ");
            String player = new Utils().getUserString();
            System.out.println(" ");

            Random number = new Random();
            int cpu = number.nextInt(3);

            if (player.equals("p") || player.equals("n") || player.equals("k")) {
                RPSUtils.rpsActions(name, player, cpu);
                if (RPSUtils.rpsResult(player, cpu).equals("tie")) {
                    System.out.println("Remis!");
                } else if (RPSUtils.rpsResult(player, cpu).equals("win")) {
                    System.out.println("Zdobywasz punkt!");
                    playerPoints++;
                } else if (RPSUtils.rpsResult(player, cpu).equals("lose")) {
                    System.out.println("Przeciwnik zdobywa punkt!");
                    cpuPoints++;
                }
                RPSUtils.rpsScore(name, playerPoints, cpuPoints);
            } else {
                System.out.println("Stało się coś, co nie powinno. Chyba kości spadły ze stołu.");
            }
        }

        if (playerPoints == 3) {
            System.out.println("\n\nZwyciężyłeś!");
            System.out.println("Wszechświat ocalał... Lecz na jak długo?");
        } else {
            System.out.println("\n\nPrzegrałeś!");
            System.out.println("Przeciwnik okazał się być kultystą Azathotha.");
            System.out.println("Czas pożegnać się z bliskimi.");
        }
    }
}
