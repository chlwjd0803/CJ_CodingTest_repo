import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.print(n + " is ");
        System.out.print((n%2==0) ? "even" : "odd");
    }
}