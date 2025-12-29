import java.util.Scanner;

public class Main {
    private Scanner sc;
    private int num;
    private int blank;
    private int star;


    public Main(){
        sc = new Scanner(System.in);
    }


    private void init(){
        num = sc.nextInt();
        blank = num - 1;
        star = 1;
    }


    private void print(){
        for(int i=0; i<blank; i++)
            System.out.print(" ");
        for(int i=0; i<star; i++)
            System.out.print("*");
        System.out.println();

        if(blank==0) return;

        --blank;
        star += 2;
        print();

        ++blank;
        star -= 2;

        for(int i=0; i<blank; i++)
            System.out.print(" ");
        for(int i=0; i<star; i++)
            System.out.print("*");
        System.out.println();
    }


    private void run(){
        init();
        
        if(num<=0)
            return;

        print();
    }


    public static void main(String[] args){
        new Main().run();
    }

}
