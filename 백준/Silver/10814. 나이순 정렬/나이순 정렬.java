import java.io.*;
import java.util.*;

class User{
    private int regCount;
    private int age;
    private String name;

    public User(int regCount, int age, String name){
        this.regCount = regCount;
        this.age = age;
        this.name = name;
    }

    public int getRegCount() {
        return regCount;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}


class CustomComparator implements Comparator<User> {

    @Override
    public int compare(User u1, User u2){
        if(u1.getAge() != u2.getAge()){
            return u1.getAge() - u2.getAge();
        } else {
            return u1.getRegCount() - u2.getRegCount();
        }
    }
}


public class Main {

    private BufferedReader br;
    private StringTokenizer st;
    private StringBuilder sb;

    private Set<User> users;
    private int n;
    private int regCount;


    public Main(){
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        users = new TreeSet<>(new CustomComparator());
        regCount = 0;
    }

    private void input(){
        try{
            n = Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                users.add(new User(
                        regCount++,
                        Integer.parseInt(st.nextToken()),
                        st.nextToken()
                        ));
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void print(){
        for(User user : users){
            sb.append(user.getAge() + " " + user.getName() + "\n");
        }

        System.out.print(sb);
    }

    private void run(){
        input();
        print();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}