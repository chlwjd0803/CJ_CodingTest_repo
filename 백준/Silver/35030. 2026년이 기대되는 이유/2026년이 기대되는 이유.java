import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private BufferedReader br;
    private ArrayList<Integer> list;
    private StringBuilder sb;
    private int maxIndex;


    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        list.add(0);
        sb = new StringBuilder();
        maxIndex = 0;
    }

    // 소수 판별 함수 0->false 1->true
    private int isPrime(int n){
        
        if(n==2) return 1;
        
        if((n<2) || (n%2==0)) return 0;

        for(int i=3; i<=Math.sqrt(n); i+=2){
            
            if(n%i==0) return 0;
        }
        
        return 1;
    }


    private int partition(String target){
        
        int flag = 1;

        for(int i=0; (i<target.length()) && flag>0; i++){
            if(i==0){
                
                flag *= isPrime(Integer.parseInt(target) + 1);
                
            } else {
                
                flag *= isPrime(
                        Integer.parseInt(target.substring(0,i))
                        * Integer.parseInt(target.substring(i))
                        + 1);
            }
        }
        
        return (flag > 0) ? 1 : 0;
    }


    private void run(){

        try{
            int count = Integer.parseInt(br.readLine());

            for(int i=0; i<count; i++){

                String target = br.readLine();
                int targetNum = Integer.parseInt(target);
                
                while(list.size() <= targetNum){
                    list.add(partition(String.valueOf(list.size())) + list.get(list.size()-1));
                }
                
                sb.append(list.get(targetNum));
                sb.append("\n");

            }

            System.out.print(sb);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Main().run();
    }

}
