import java.util.Scanner;

public class Scheduling {
    public static void main(String[] args) {
        final int SIZE = 1000001;
        Queue q = new Queue(SIZE);
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int quantum = Integer.parseInt(sc.next());
        String name;
        int time;
        int nowTime = 0;
        int rest = N;
        for (int i = 0; i < N; i++) {
            name = sc.next();
            time = Integer.parseInt(sc.next());
            q.enqueue(new Process(name, time));
        }

        StringBuilder sb = new StringBuilder();
        while (rest > 0) {
            Process stock = q.dequeue();
            int t;
            if (stock.getTime() > quantum) {
                t = stock.getTime() - quantum;
                stock.setTime(t);
                nowTime += quantum;
            } else {
                nowTime += stock.getTime();
                t = 0;
                stock.setTime(t);
            }
            if (stock.getTime() == 0) {
                rest--;
                sb.append(stock.getName()).append(" ").append(Integer.toString(nowTime)).append("\n");
                continue;
            }
            q.enqueue(new Process(stock.getName(), stock.getTime()));
        }
        sc.close();
        System.out.print(sb.toString());
    }
}

class Process {
    private String name;
    private int time;

    Process(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    public int getTime() {
        return this.time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

class Queue {
    int head;
    int tail;
    int size;
    Process[] P;

    Queue(int size) {
        this.head = 0;
        this.tail = 0;
        this.size = size;
        this.P = new Process[size];
    }

    public void enqueue(Process p) {
        P[tail] = p;
        tail = (tail + 1) % size;
    }

    public Process dequeue() {
        Process stock = P[head];
        head = (head + 1) % size;
        return stock;
    }
}
