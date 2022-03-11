import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        stepTracker.StepTracker();
        printMenu();

        int userInput = scanner.nextInt();

        while (userInput != 0) {

            if (userInput == 1) {

                stepTracker.addStepsPerDay();
            } else if (userInput == 2) {
                System.out.println("За какой месяц напечатать статитстику?");
                int month = scanner.nextInt();
                stepTracker.getDaySteps(month);
                System.out.println("\nОбщее количество шагов за " + month + " месяц: " + stepTracker.getMonthSteps(month));
                System.out.println("Максимальное пройденное количество шагов в " + month + " месяце: " + stepTracker.getMaxStepsMonth(month));
                System.out.println("Среднее количество шагов за " + month + " месяц: " + stepTracker.getAverageSteps(month));
                stepTracker.getDistance(month);
                stepTracker.getCalories(month);
                System.out.println("Лучшая серия: " + stepTracker.getMaxTargetSteps(month) + " дней.");
            } else if (userInput == 3) {
                System.out.println("Введите новый целевой показатель:");
                int target = scanner.nextInt();
                if (target >= 0) {
                    stepTracker.changeTargetSteps(target);
                } else {
                    System.out.println("Введено некоректное значение!");
                }
            } else {
                System.out.println("Неверная комманда, такой комманды нет");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день;");
        System.out.println("2 - Напечатать статистику за определённый месяц;");
        System.out.println("3 - Изменить цель по количеству шагов в день;");
        System.out.println("0 - Выйти из приложения.");
    }
}

