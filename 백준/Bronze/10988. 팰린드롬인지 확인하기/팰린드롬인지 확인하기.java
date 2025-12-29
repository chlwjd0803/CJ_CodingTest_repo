import java.util.Scanner;

public class Main {
    private Scanner sc;
    private String input;
    private boolean flag;

    public Main(){
        sc = new Scanner(System.in);
        flag = true;
    }

    public void run() {
        input = sc.next();

        for (int i = 0; i < input.length()/2; i++) {
            flag = input.charAt(i)
                    == input.charAt(input.length() - 1 - i);

            if(!flag){
                break;
            }
        }

        System.out.print(flag ? 1:0);
    }

    public static void main(String[] args) {
        new Main().run();
    }

}
