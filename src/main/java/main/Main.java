package main;

public class Main {


    private String a = "C";
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {



   Main n = new Main();
   new Thread(() ->{
       try {
           while (counter != 5) {
               n.printA();
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }).start();


        new Thread(() ->{
            try {
                while (counter != 5) {
                n.printB();}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->{
            try {
                while (counter != 5) {
                    n.printC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }

    public synchronized void printA () throws InterruptedException {
if (a.equals("A") || a.equals("B") ) {
wait();} else {
            System.out.print("A");
            a = "A";
            notifyAll();}
    }
    public synchronized void printB () throws InterruptedException {
        if (a.equals("B") || a.equals("C")) {
            wait();
        } else {
        System.out.print("B");
        a = "B";
        notifyAll();}
    }
    public synchronized void printC () throws InterruptedException {
        if (a.equals("C") || a.equals("A")) {
            wait();} else {
        System.out.print("C");
        a = "C";
        counter++;
        notifyAll();}
    }


}
