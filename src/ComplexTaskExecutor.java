import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final CyclicBarrier barrier;
    private final ExecutorService executorService;
    private final ComplexTask task;

    public ComplexTaskExecutor(int numberOfTasks) {
        Runnable barrierAction = () -> System.out.println("Well done, guys!");
        this.barrier = new CyclicBarrier(numberOfTasks, barrierAction);
        this.executorService = Executors.newFixedThreadPool(numberOfTasks);
        this.task = new ComplexTask();
    }

    public void executeTasks(int numberOfTasks) {
        for (int i = 0; i < numberOfTasks; i++) {
            executorService.submit(() -> {
                task.execute(); // Выполнение части сложной задачи
                try {
                    barrier.await(); // Ожидание завершения каждого потока задачи
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }
}
