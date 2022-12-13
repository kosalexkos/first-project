import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Ввести количество шагов за определённый день");
            System.out.println("2 - Узнать статистику за определённый месяц");
            System.out.println("3 - Изменить цель по количеству шагов в день");
            System.out.println("0 - Выйти из приложения");

            int command = scanner.nextInt();

            if (command == 1) {
                StepTracker.saveStepsPerDay();

            } else if (command == 2) {
                StepTracker.countAndOutputSteps();
            } else if (command == 3) {
                StepTracker.setTheGoal();
            }
            else if (command == 0) {
                System.out.println("Выход");
                return; }
              else {
                System.out.println("Такой команды нет");
            }
        }
    }
}
