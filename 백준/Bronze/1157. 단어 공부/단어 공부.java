import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    private Scanner sc;
    private HashMap<Character, Integer> map;
    private HashSet<Character> set;
    private String input;
    char maxKey;
    int maxValue;

    public Main(){
        sc = new Scanner(System.in);
        map = new HashMap<>();
        set = new HashSet<>();

        for(char c='A'; c<='Z'; c++)
            map.put(c, 0);

        input = "";
        char maxKey = ' ';
        int maxValue = -1;
    }

    private void count(){
        for(int i=0; i<input.length(); i++){
            map.put(input.charAt(i), map.get(input.charAt(i))+1);
        }
    }

    private boolean findMax(){

        for(char c='A'; c<='Z'; c++){
            if(map.get(c) > maxValue){
                set = new HashSet<>();
                set.add(c);
                maxKey = c;
                maxValue = map.get(c);
            }
            if(map.get(c) == maxValue){
                set.add(c);
            }
        }

        return (set.size() == 1) ? true : false;
    }

    private void run(){
        input = sc.next();
        input = input.toUpperCase();
        count();
        System.out.print(findMax() ? maxKey : "?");

    }

    public static void main(String[] args) {
        new Main().run();
    }
}