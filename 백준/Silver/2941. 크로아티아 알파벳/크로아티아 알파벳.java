import java.util.Scanner;
import java.util.HashMap;

public class Main {
    private Scanner sc;
    private HashMap<String, Integer> map;
    private String input;
    private int len;

    public Main(){
        sc = new Scanner(System.in);
        map = new HashMap<>();
        input = null;
        len = 0;

        map.put("c=", 1);
        map.put("c-", 1);
        map.put("dz=", 2);
        map.put("d-", 1);
        map.put("lj", 1);
        map.put("nj", 1);
        map.put("s=", 1);
        map.put("z=", 1);
    }

    public void run(){
        input = sc.next();
        len = input.length();

        int i=0;
        String substr;

        while(i<input.length()-1){
            if(input.charAt(i) == 'd' && i<input.length()-2){
                substr = input.substring(i, i+3);
                if(map.containsKey(substr)){
                    len -= map.get(substr);
                    i += map.get(substr) + 1;
                    continue;
                }
            }
            substr = input.substring(i, i+2);
            if(map.containsKey(substr)){
                len -= map.get(substr);
                i += map.get(substr) + 1;
                continue;
            }
            i++;
        }

        System.out.print(len);
    }


    public static void main(String[] args){
        new Main().run();
    }

}
