import java.util.*;
import java.io.*;

public class Main {

    private BufferedReader br;
    private StringBuilder sb;

    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    private String validate(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '[' || s.charAt(i) =='(')
                stack.push(s.charAt(i));
            if(s.charAt(i) == ']'){
                if(stack.isEmpty()){
                    stack.push(s.charAt(i));
                    break;
                }
                if(stack.peek() == '[')
                    stack.pop();
                else
                    break;
            }
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    stack.push(s.charAt(i));
                    break;
                }
                if(stack.peek() == '(')
                    stack.pop();
                else
                    break;
            }
        }
        return (stack.isEmpty()) ? "yes\n" : "no\n";
    }

    private void run(){
        while(true){
            try{
                String inputLine = br.readLine();
                if(inputLine.equals("."))
                    break;
                sb.append(validate(inputLine));
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}