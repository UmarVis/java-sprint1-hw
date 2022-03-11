public class MonthData {
    int[] monthDays;

    MonthData() {
        monthDays = new int[30];
    }

    void addSteps(int day, int steps) {
        monthDays[day] = steps;
    }

}

