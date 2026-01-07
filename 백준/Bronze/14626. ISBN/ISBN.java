import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private BufferedReader br;
    private StringBuilder sb;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    private int find(String input, int m, int option){
        int sum=0;
        for(int i=0; i<input.length()-1; i++){
            if(i%2 == 0){
                sum += (int)input.charAt(i) - 48;
            } else {
                sum += ((int)input.charAt(i) - 48) * 3;
            }
        }

        int cal = ((10-m-(sum%10)) >= 0) ? (10-m-(sum%10)) % 10 : (10 + (10-m-(sum%10))) % 10;

        if(option == 0){
            return 10 - (sum%10);
        }
        else if(option == 1){
            return cal;
        }
        else if(option == 2){
            int x;
            for(x=0; (3*x)%10 != cal; x++);
            return x;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void run(){
        try{

            String input = br.readLine();
            int m = -1;

            int i;
            for(i=0; i<input.length()-1; i++){
                if(input.charAt(i) == '*'){
                    sb = new StringBuilder(input);
                    sb.setCharAt(i, '0');
                    input = sb.toString();
                    m = (int)input.charAt(input.length()-1) - 48;
                    break;
                }
            }

            if(m<0){
                System.out.print(find(input, m, 0));
            } else if(i%2 == 0){
                System.out.print(find(input, m, 1));
            } else {
                System.out.print(find(input, m, 2));
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}