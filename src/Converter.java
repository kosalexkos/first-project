public class Converter {
    public static double stepsToKilometers(int steps) {
        double kilometers;
        kilometers = steps * 75d /100000d;
        return kilometers;
    }
    public static double stepsToCalories(int steps) {
        double kilocalories;
        kilocalories = (steps * 50d)/1000d;
        return kilocalories;
    }
}
