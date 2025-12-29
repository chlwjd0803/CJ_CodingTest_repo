import java.util.Scanner;

public class Main {
    private Scanner sc;
    private final int KING = 1;
    private final int QUEEN = 1;
    private final int ROOK = 2;
    private final int BISHOP = 2;
    private final int KNIGHT = 2;
    private final int PAWN = 8;

    public Main(){
        sc = new Scanner(System.in);
    }

    private void run(){
        int king = sc.nextInt();
        int queen = sc.nextInt();
        int rook = sc.nextInt();
        int bishop = sc.nextInt();
        int knight = sc.nextInt();
        int pawn = sc.nextInt();

        System.out.print((KING - king) + " ");
        System.out.print((QUEEN - queen) + " ");
        System.out.print((ROOK - rook) + " ");
        System.out.print((BISHOP - bishop) + " ");
        System.out.print((KNIGHT - knight) + " ");
        System.out.print((PAWN - pawn) + "");
    }

    public static void main(String[] args) {
        new Main().run();
    }

}
