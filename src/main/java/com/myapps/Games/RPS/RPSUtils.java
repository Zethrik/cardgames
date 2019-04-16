package com.myapps.Games.RPS;

public class RPSUtils {
    public static void intro() {
        System.out.println("\n" +
                "    )  (                                      )   )     )   (       )          (        )    )         )  \n" +
                " ( /(  )\\ )  *   )   (      *   )      (   ( /(( /(  ( /(   )\\ ) ( /(          )\\ )  ( /( ( /(      ( /(  \n" +
                " )\\())(()/(` )  /(   )\\   ` )  /((     )\\  )\\())\\()) )\\()) (()/( )\\())   (  ( (()/(  )\\()))\\())(    )\\()) \n" +
                "((_)\\  /(_))( )(_)|(((_)(  ( )(_))\\  (((_)((_)((_)\\ ((_)\\   /(_)|(_)\\    )\\ )\\ /(_))((_)\\((_)\\ )\\ |((_)\\  \n" +
                "  ((_)(_)) (_(_()) )\\ _ )\\(_(_()|(_) )\\___ _((_)((_)_ ((_) (_))   ((_)  ((_|(_|_))___ ((_)_((_|(_)|_ ((_) \n" +
                " / _ \\/ __||_   _| (_)_\\(_)_   _| __((/ __|_  / \\| \\ \\ / / | _ \\ / _ \\ _ | | __|   \\ \\ / / \\| | __| |/ /  \n" +
                "| (_) \\__ \\  | |    / _ \\   | | | _| | (__ / /| .` |\\ V /  |  _/| (_) | || | _|| |) \\ V /| .` | _|  ' <   \n" +
                " \\___/|___/  |_|   /_/ \\_\\  |_| |___| \\___/___|_|\\_| |_|   |_|   \\___/ \\__/|___|___/ |_| |_|\\_|___|_|\\_\\  \n" +
                "                                                                                                          \n");
        System.out.println("Oto pojedynek, w którym rozstrzygną się losy wszechświata!");
        System.out.println("Walka toczy się do trzech zdobytych punktów.");
        System.out.println("\nMasz następujące możliwości:");
        System.out.println("[p]apier");
        System.out.println("[n]ożyce");
        System.out.println("[k]amień");
    }

    public static void rpsActions(String name, String player, int cpu) {
        switch (player) {
            case "p":
                System.out.println(name + " wachluje papierem.");
                break;
            case "n":
                System.out.println(name + " ciacha nożycami.");
                break;
            case "k":
                System.out.println(name + " wali z kamienia.");
                break;
        }

        if (cpu == 0) {
            System.out.println("Przeciwnik wachluje papierem.");
        } else if (cpu == 1) {
            System.out.println("Przeciwnik ciacha nożycami.");
        } else if (cpu == 2) {
            System.out.println("Przeciwnik wali z kamienia.");
        }
        System.out.println();
    }

    public static String rpsResult(String player, int cpu) {
        if (player.equals("p") && cpu == 0 || player.equals("n") && cpu == 1 || player.equals("k") && cpu == 2) {
            return "tie";
        } else if (player.equals("p") && cpu == 2 || player.equals("n") && cpu == 0 || player.equals("k") && cpu == 1) {
            return "win";
        } else {
            return "lose";
        }
    }

    public static void rpsScore(String name, int playerPoints, int cpuPoints) {
        System.out.println(name + " " + playerPoints);
        System.out.println("Przeciwnik " + cpuPoints);
    }
}
