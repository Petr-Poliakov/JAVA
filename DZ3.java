import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(10);
        numbers.add(3);
        numbers.add(7);
        numbers.add(8);

        removeEvenNumbers(numbers);
        System.out.println("Список после удаления чётных чисел: " + numbers);

        int min = findMinValue(numbers);
        System.out.println("Минимальное значение: " + min);

        int max = findMaxValue(numbers);
        System.out.println("Максимальное значение: " + max);

        double average = findAverageValue(numbers);
        System.out.println("Среднее значение: " + average);
    }

    private static void removeEvenNumbers(List<Integer> numbers) {
        numbers.removeIf(number -> number % 2 == 0);
    }

    private static int findMinValue(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    private static int findMaxValue(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static double findAverageValue(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }
}