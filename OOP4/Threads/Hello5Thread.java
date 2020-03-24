package OOP4.Threads;

public class Hello5Thread extends Thread {
    private int _Id;

    public Hello5Thread(int id) {
        _Id = id;
    }

    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("hello world fra tråd: " + _Id);
        }
    }
}