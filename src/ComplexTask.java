public class ComplexTask implements Runnable {
    public void execute() {
        System.out.println(Thread.currentThread().getName() + " is executing a complex task.");
        run();
    }

    @Override
    public void run() {
        // Какая-то сложная логика выполнения задачи
    }
}
