import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;


public class Main {
    private Scanner sc;
    private HashSet<Character> set;
    private ArrayList<String> list;
    private Character buf;
    private int capacity;
    private int result;

    public Main(){
        sc = new Scanner(System.in);
        buf = null;
        result = 0;
    }

    private void insert(){
        capacity = sc.nextInt();
        sc.nextLine();
        list = new ArrayList<>(capacity);

        for(int i=0; i<capacity; i++)
            list.add(sc.nextLine());
    }

    private void count(){
        int i;

        for(String str : list){
            set = new HashSet<>();
            buf = null;
            i=0;

            for(; i<str.length(); i++){
                if(set.contains(str.charAt(i))){
                    if(buf != str.charAt(i))
                        break;
                } else {
                    set.add(str.charAt(i));
                    buf = str.charAt(i);
                }
            }
            if(i==str.length()) result++;
        }
        System.out.print(result);
    }


    private void run(){
        insert();
        count();
    }


    public static void main(String[] args){
        new Main().run();
    }

}
