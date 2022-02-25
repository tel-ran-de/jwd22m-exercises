public class SunIntegers extends Thread {
    int counter=0;

    public void run(){
        for (int i=0;i<1000;i++){
            counter++;
        }
    }
    public int getCounter(){
        return counter;
    }

}
