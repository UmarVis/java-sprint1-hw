import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    Scanner scanner = new Scanner(System.in);
    MonthData monthData = new MonthData();
    Converter converter = new Converter();
    int targetSteps = 10000;

    public StepTracker() {

        for (int i = 1; i < 13; i++) {
            monthToData.put(i, new MonthData());

        }
    }

    public void addStepsPerDay() {
        System.out.println("За какой месяц вы хотите ввести шаги.");
        System.out.println("Введите месяц от 1 (янв) до 12 (дек).");
        int month = scanner.nextInt();
        System.out.println("За какой день вы хотите ввести шаги. Веберите значение от 1 до 30.");
        int day = scanner.nextInt();
        System.out.println("Введите количество пройденных шагов");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Введите положительное значение!");
            steps = scanner.nextInt();
        }
        monthToData.get(month).addSteps(--day, steps);
    }

    public void getStatistic(int month) {
        System.out.println("\nОбщее количество шагов за " + month + " месяц: " + getMonthSteps(month));
        System.out.println("Максимальное пройденное количество шагов в " + month + " месяце: " + getMaxStepsMonth(month));
        System.out.println("Среднее количество шагов за " + month + " месяц: " + getAverageSteps(month));
        getDistance(month);
        getCalories(month);
        System.out.println("Лучшая серия: " + getMaxTargetSteps(month) + " дней.");
    }

    public void getDaySteps(int month) {
        System.out.println("Статистика за " + month + " месяц:");
        for (int i = 0; i < monthData.monthDays.length; i++) {
            System.out.print((i + 1) + " день: " + monthToData.get(month).monthDays[i] + ", ");
        }
    }

    public int getMonthSteps(int month) {
        int steps = 0;
        for (int i = 0; i < monthData.monthDays.length; i++) {
            steps = monthToData.get(month).monthDays[i] + steps;
        }
        return steps;
    }

    public int getMaxStepsMonth(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthData.monthDays.length; i++) {
            if (monthToData.get(month).monthDays[i] > maxSteps) {
                maxSteps = monthToData.get(month).monthDays[i];
            }
        }
        return maxSteps;
    }

    public int getAverageSteps(int month) {
        return getMonthSteps(month) / monthData.monthDays.length;
    }

    public void getDistance(int month) {
        int steps = getMonthSteps(month);
        System.out.println("Пройденная дистанция (в км): " + converter.convertingSteps(steps));
    }

    public void getCalories(int month) {
        int steps = getMonthSteps(month);
        System.out.println("Количество сожжённых килокалорий: " + converter.converingtCallories(steps));
    }

    public int getMaxTargetSteps(int month) {
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < monthData.monthDays.length; i++) {
            if (monthToData.get(month).monthDays[i] >= targetSteps) {
                max1 = max1 + 1;
                if (max1 > max2) {
                    max2 = max1;
                }
            } else if (monthToData.get(month).monthDays[i] < targetSteps) {
                if (max1 > max2) {
                    max2 = max1;

                }
                max1 = 0;
            }
        }
        return max2;
    }

    public void changeTargetSteps(int target) {
        targetSteps = target;
        System.out.println("Значение сохранено.");
    }
}

