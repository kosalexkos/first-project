
import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    static int[][] entireAmountOfSteps = new int[12][30]; /*Создали двумерный массив, где номер строки - это месяц,
    а номер столбца - это день */
    static int goalPerDay = 10000;

    public static void saveStepsPerDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца, за который вы хотели бы сохранить данные, от 0 до 11");
        int month = scanner.nextInt();
        System.out.println("Введите номер дня от 0 до 29");
        int day = scanner.nextInt();
        System.out.println("Введите количество шагов за день");
        int stepsPerDay = scanner.nextInt();
        if (stepsPerDay < 0) {
            System.out.println("Вы ввели недопустимое значение. " +
                    "Количество шагов не может быть отрицательным.");
            return;
        }
        entireAmountOfSteps[month][day] = stepsPerDay;
        System.out.println("Значение сохраненно");
    }

    public static void countAndOutputSteps() {  //метод для подсчета и вывода статистики
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Что бы вы хотели узнать?");
            System.out.println("1 - Количество пройденных шагов по дням");
            System.out.println("2 - Общее количество шагов за месяц");
            System.out.println("3 - Максимальное пройденное количество шагов в месяце");
            System.out.println("4 - Среднее количество шагов за месяц");
            System.out.println("5 - Пройденная дистанция (в км)");
            System.out.println("6 - Количество сожжённых килокалорий");
            System.out.println("7 - Лучшая серия: максимальное количество подряд идущих дней" +
                    "в течение которых количество шагов за день было равно или выше целевого.");
            System.out.println("0 - Выход в главное меню");
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Введите месяц, за который вы бы хотели получить информацию, от 0 до 11");
                int monthToBeChecked = scanner.nextInt();
                showStepsPerMonth(monthToBeChecked);

            } else if (command == 2) {
                System.out.println("Введите месяц, за который вы бы хотели получить информацию, от 0 до 11");
                int monthToBeChecked = scanner.nextInt();
                System.out.println("Общее количество шагов за выбранный месяц - " +
                        showTheSumPerMonth(monthToBeChecked));

            } else if (command == 3) {
                System.out.println("Введите месяц, за который вы бы хотели получить информацию, от 0 до 11");
                int monthToBeChecked = scanner.nextInt();

                System.out.println("Максимальное количество шагов за выбранный месяц " +
                        findMaxAmountOfSteps(monthToBeChecked));

            } else if (command == 4) {
                System.out.println("Введите месяц, за который вы бы хотели получить информацию, от 0 до 11");
                int monthToBeChecked = scanner.nextInt();
                System.out.println("Среднее количество шагов за выбранный месяц - " +
                        findAverageAmountOfSteps(monthToBeChecked));

            } else if (command == 5) {
                System.out.println("Введите месяц, за который вы бы хотели получить информацию, от 0 до 11");
                int monthToBeChecked = scanner.nextInt();
                System.out.println("Введите день, за который вы бы хотели получить информацию, от 0 до 29");
                int dayToBeChecked = scanner.nextInt();
                System.out.println("Количество пройденных километров за выбранный день составляет " +
                        Converter.stepsToKilometers(entireAmountOfSteps[monthToBeChecked][dayToBeChecked]));
            } else if (command == 6) {
                System.out.println("Введите месяц, за который вы бы хотели получить информацию, от 0 до 11");
                int monthToBeChecked = scanner.nextInt();
                System.out.println("Введите день, за который вы бы хотели получить информацию, от 0 до 29");
                int dayToBeChecked = scanner.nextInt();
                System.out.println("Количество сожжённых килокалорий за выбранный день составляет " +
                        Converter.stepsToCalories(entireAmountOfSteps[monthToBeChecked][dayToBeChecked]));
            } else if (command == 7) {
                System.out.println("Введите месяц, за который вы бы хотели получить информацию, от 0 до 11");
                int monthToBeChecked = scanner.nextInt();
                System.out.println("Максимальное количество дней подряд составляет " +
                        findTheBestSeries(monthToBeChecked));
            } else if (command == 0) {
                System.out.println("Выход");
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    public static void showStepsPerMonth(int x) {
        for (int i = 0; i < entireAmountOfSteps[x].length; i++) {
            System.out.println("За день  вы прошли " +
                    entireAmountOfSteps[x][i] + " шагов.");
        }
    }

    public static int showTheSumPerMonth(int x) {
        int sum = 0;
        for (int i = 0; i < entireAmountOfSteps[x].length; i++) {
            sum += entireAmountOfSteps[x][i];
        }
        return sum;
    }

    public static int findMaxAmountOfSteps(int x) {
        int maxStepsAmount = 0;
        for (int i = 0; i < entireAmountOfSteps[x].length; i++) {
            if (maxStepsAmount < entireAmountOfSteps[x][i]) {
                maxStepsAmount = entireAmountOfSteps[x][i];
            }
        }
        return maxStepsAmount;
    }
    public static double findAverageAmountOfSteps(int x) {
        int sum = 0;
        for (int i = 0; i < entireAmountOfSteps[x].length; i++) {
            sum += entireAmountOfSteps[x][i];
        }
        double averageAmountOfSteps = (double) sum / (double) (entireAmountOfSteps[x].length - 1);
        return averageAmountOfSteps;
    }
    public static int findTheBestSeries(int x) {
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 1; i < entireAmountOfSteps[x].length; i++) {
            if (entireAmountOfSteps[x][i] > goalPerDay) {
                counter1++;
            } else {
                if (counter2 > counter1) {
                    counter1 = 0;
                } else {
                    counter2 = counter1;
                }
            }
        }
        return counter2;
    }
    public static void setTheGoal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество шагов, чтобы задать себе цель");
        int newGoal = scanner.nextInt();
        goalPerDay = newGoal;
        System.out.println("Ваша цель на каждый день обновлена и теперь составляет " + goalPerDay + " шагов.");
    }
}

