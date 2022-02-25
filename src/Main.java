public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        new Runner().start();
        new Runner().start();
        new Runner().start();

        new Thread(new RunnerRunnable()).start();
        new Thread(new RunnerRunnable()).start();
// просуммировать числа от 0 до 1000 , запустив программу в новом потоке и вывести
        // результат на экран. Сделать двумя способами - через  Thread and Runnable

        SunIntegers sum = new SunIntegers();
        sum.start();
        sum.join();
        System.out.println(sum.getCounter());
    }
}
