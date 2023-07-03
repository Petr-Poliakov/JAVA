/*Реализовать алгоритм сортировки слиянием*/

import java.util.Arrays;
import java.util.Scanner;
public class Ex6 {
    
    public static int[] sort(int[] array) {
        int[] array1 = Arrays.copyOf(array, array.length);
        int[] buffer = new int[array.length];
        int[] result = merge(array1, buffer, 0, array.length);
        return result;
    }

    public static int[] merge(int[] array1, int[] buffer,
            int left, int right) {
        if (left >= right - 1) {
            return array1;
        }
        
        int middle = left + (right - left) / 2;
        int[] sort = merge(array1, buffer, left, middle);
        int[] sort1 = merge(array1, buffer, middle, right);
        
        int i = left;
        int j = middle;
        int k = left;
        int[] result = sort == array1 ? buffer : array1;
        while (i < middle && j < right) {
            result[k++] = sort[i] < sort1[j]
                    ? sort[i++] : sort1[j++];
        }
        while (i < middle) {
            result[k++] = sort[i++];
        }
        while (j < right) {
            result[k++] = sort1[j++];
        }
        return result;
    }

    static int[] input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input massive size: ");
        int size = scanner.nextInt(); 
        int array[] = new int[size]; 
        System.out.println("Insert array elements:");
        
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt(); 
        }
        
        scanner.close();
        return array;
    }

    static void printArray(int array[])
    {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        int[] array = input();
        printArray(array);
        int[] result = sort(array);
        printArray(result);
    }
}