import task1.Runner;

import java.util.Scanner;

public class Main {
    public static void main(String arg[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter adress data base \n" + " Example: localhost:3306");
        String adr = scanner.nextLine();
        System.out.println("Enter name scheme");
        String scheme = scanner.nextLine();
        System.out.println("Enter username ");
        String userName = scanner.nextLine();
        System.out.println("Enter password" );
        String password = scanner.nextLine();
        System.out.println("Enter n" );
        int n = scanner.nextInt();
        Runner runner = new Runner();
        runner.runTask1(n,adr,scheme,userName,password);
    }
}
