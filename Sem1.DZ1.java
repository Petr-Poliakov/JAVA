"Урок 1. Знакомство с языком программирования Java
+Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
Пример 1: а = 3, b = 2, ответ: 9
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1
Пример 4: а = 0, b = 0, ответ: не определено
Пример 5
входные данные находятся в файле input.txt в виде
b 3
a 10
Результат нужно сохранить в файле output.txt
1000

можно использовать знания прошедших вебинаров. в т ч 2, 3, 4, 5..."


import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main_Pow {
    public static void main(String[] args) throws IOException {  
        
        File inp_File = new File("input.txt");
        
        PrintWriter pr_Writer = new PrintWriter(inp_File);

        Scanner scan = new Scanner(System.in);


        System.out.printf("Input the integer 'a' (from -30 to 30): ");
        int num_a = scan.nextInt();
        
        while (num_a > 30 || num_a < -30) {
            System.out.printf("Input the integer correctly please (from -30 to 30): ");            
            num_a = scan.nextInt();
        } 


        System.out.printf("Input the integer 'b' (from -30 to 30): ");
        int num_b = scan.nextInt();

        while (num_b > 30 || num_b < -30) {
            System.out.printf("Input the integer correctly please (from -30 to 30): ");            
            num_b = scan.nextInt();
        } 
        
        pr_Writer.printf("b %d \n", num_b);
        pr_Writer.printf("a %d \n", num_a);
        
        pr_Writer.close();



        int[] arr_num = new int[2];
        
        while (scan.hasNextLine()) {
        for (int i = 0; i < 2; i++) {
            String[] a_str = scan.nextLine().split(" ");
            arr_num[i] = Integer.decode(a_str[1]);                
            }
        }
        System.out.println(arr_num[0]);
        System.out.println(arr_num[1]);        
        scan.close();
        

        double res = 0;
        int a = arr_num[1];
        int b = arr_num[0];

        if (a == 0 && b == 0) {
            System.out.println("There is no solution");
        }   else {
                res = Math.pow(a, b);
                System.out.println(res);
        }

        File out_File = new File("output.txt");
        PrintWriter pr_Writer2 = new PrintWriter(out_File);
        pr_Writer2.println(res);

        pr_Writer2.close();
    
    }

}