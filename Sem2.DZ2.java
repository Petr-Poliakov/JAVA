import java.util.Scanner;

public class Ex3 {
    
    static int input() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("input number: ");
        int n = scanner.nextInt();
        scanner.close();

        return n;
    }
    
    public static int triangularNumber(int n){
        int result = (n * (n + 1)) / 2;
        return  result;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.print(triangularNumber(input()));
    }
}