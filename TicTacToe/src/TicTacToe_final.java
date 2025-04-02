import java.util.Scanner; // Import Scanner
public class TicTacToe_final {
    public static void main(String[] args) {
        char player1 = 'x';
        char player2 = 'o';
        char[][] playingField = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}}; // Spielfelderstellung

        printFrame(playingField);

        // Spielfeldablaufschleife

        int counter = 0; // Rundenzähler für das unentschieden Ergebnis, Verknüpfung weiter unten im Code
        for (int i = 0; i < 9; i++) {
            counter++;
            char user;
            if (i % 2 == 0) {
                user = player1; // Spieler 1 ist an der Reihe bei gerader Rundenzahl
            } else {
                user = player2; // Speieler 2 ist an der Reihe bei ungerader Rundenzahl
            }
            boolean playerLoop = true;
            while (playerLoop) { /* Es wird nachgefragt ob eine korrekte Eingabe stattgefunden hat, das wird solange
             wiederholt bis eine korrekte Eingabe erfolgt ist */
                playerLoop = dontSwitchPlayerAndChangeField(userInputOutput(user), user, playingField);
                printFrame(playingField); // nach jeder Runde wird das veränderte Spielfeld erneut ausgegeben
            }

            // Schleife zur Ausgabe des Spielgewinners

            boolean won = rowCheck(playingField, user); // Rückgabewert aus Spielreihenprüfmethode
            if (won) {
                if (user == 'x') {
                    System.out.println("Spieler 1 hat gewonnen!! ");
                    break;
                } else {
                    System.out.println("Spieler 2 hat gewonnen!! ");
                    break;
                }
            }
            if (counter == 9){ // Rundenzähler Funktion für das Unentschieden
                System.out.println("Unentschieden!! ");
                break;
            }
        }
    }
    // Methode gibt ein 2D Char Array auf der Kommandozeile aus
    public static void printFrame(char[][] frame) {
        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame[i].length; j++) {
                System.out.print(frame[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Methode um an einer entsprechenden Ziffer ein x für Player1 oder o für Player2 zu setzten
    public static int userInputOutput(char player) {
        Scanner scan = new Scanner(System.in);
        int input = 0; // Ziffereingabe auf Komandozeile
        boolean isLoop = true;

        if (player == 'x') { // Abrage ob Spieler 1 oder Spieler 2an der Reihe ist
            while (isLoop) { // Prüfung ob Eingabe auf Kommandozeile richtig ist
                System.out.println("Spieler 1 gib eine Zahl ein: ");
                try {
                    input = scan.nextInt();
                    if (input > 0 && input < 10) {
                        isLoop = false;
                    } else {
                        System.out.println("Eingabe falsch! ");
                    }
                } catch (Exception e) {
                    System.out.println("Das war kein gültiges Zeichen! ");
                    scan.next();
                }
            }
        } else {
            System.out.println("Spieler 2 gib eine Zahl ein: ");
            try {
                input = scan.nextInt();
                if (input > 0 && input < 10) {
                    isLoop = false;
                } else {
                    System.out.println("Eingabe falsch! ");
                }
            } catch (Exception e) {
                System.out.println("Das war kein gültiges Zeichen! ");
                scan.next();
            }
        }
        return input;
    }

    // Methode zur Prüfung ob Feld belegt ist, zur Pfüfung ob ein Spielerwechsel stattfinden soll und zur Überschreibung
    // der Ziffer
    public static boolean dontSwitchPlayerAndChangeField(int userinput, char player, char[][] field) {
        switch (userinput) {
            case 1: // Spieler drückt 1 und überschreibt Feld mit x oder o
                if (field[0][0] == 'x' || field[0][0] == 'o') { // Prüfung ob das Feld bereits belegt ist
                    System.out.println("Dieses Feld ist bereits belegt. ");
                    return true; // wenn if ist true dann soll kein Spielwechsel stattfinden
                }
                field[0][0] = player;
                return false; // wenn if ist false dann findet ein Spielerwechsel statt
            case 2:
                if (field[0][1] == 'x' || field[0][1] == 'o') {
                    System.out.println("Dieses Feld ist bereits belegt. ");
                    return true;
                }
                field[0][1] = player;
                return false;
            case 3:
                if (field[0][2] == 'x' || field[0][2] == 'o') {
                    System.out.println("Dieses Feld ist bereits belegt. ");
                    return true;
                }
                field[0][2] = player;
                return false;
            case 4:
                if (field[1][0] == 'x' || field[1][0] == 'o') {
                    System.out.println("Dieses Feld ist bereits belegt. ");
                    return true;
                }
                field[1][0] = player;
                return false;
            case 5:
                if (field[1][1] == 'x' || field[1][1] == 'o') {
                    System.out.println("Feld ist bereits belegt. ");
                    return true;
                }
                field[1][1] = player;
                return false;
            case 6:
                if (field[1][2] == 'x' || field[1][2] == 'o') {
                    System.out.println("Dieses Feld ist bereits belegt. ");
                    return true;
                }
                field[1][2] = player;
                return false;
            case 7:
                if (field[2][0] == 'x' || field[2][0] == 'o') {
                    System.out.println("Dieses Feld ist bereits belegt. ");
                    return true;
                }
                field[2][0] = player;
                return false;
            case 8:
                if (field[2][1] == 'x' || field[2][1] == 'o') {
                    System.out.println("Feld ist bereits belegt. ");
                    return true;
                }
                field[2][1] = player;
                return false;
            case 9:
                if (field[2][2] == 'x' || field[2][2] == 'o') {
                    System.out.println("Feld ist bereits belegt. ");
                    return true;
                }
                field[2][2] = player;
                return false;
            default:
        }
        return true;
    }

    // Methode zur überprüfung ob die Felder der Horizontalen, Vertikalen oder Diagonalen das selbe Zeichen haben
    public static boolean rowCheck(char[][] field, char userinput) {
        if (field[0][0] == field[0][1] && field[0][1] == field[0][2] && field[0][2] == userinput) {
            return true;
        } else if (field[1][0] == field[1][1] && field[1][1] == field[1][2] && field[1][2] == userinput) {
            return true;
        } else if (field[2][0] == field[2][1] && field[2][1] == field[2][2] && field[2][2] == userinput) {
            return true;
        } else if (field[0][0] == field[1][0] && field[1][0] == field[2][0] && field[2][0] == userinput) {
            return true;
        } else if (field[0][1] == field[1][1] && field[1][1] == field[2][1] && field[2][1] == userinput) {
            return true;
        } else if (field[0][2] == field[1][2] && field[1][2] == field[2][2] && field[2][2] == userinput) {
            return true;
        } else if (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[2][2] == userinput) {
            return true;
        } else if (field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[2][0] == userinput) {
            return true;
        } else {
            return false;
        }
    }
}


