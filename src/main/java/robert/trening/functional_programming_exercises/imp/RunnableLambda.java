package robert.trening.functional_programming_exercises.imp;

public class RunnableLambda {
    public static void main(String[] args) throws InterruptedException {
//        Runnable runnable = new Runnable() {
//
//            @Override
//            public void run() {
//                for (int i = 0; i < 4; i++) {
//                    System.out.println("Hello World from thread [" + Thread.currentThread().getName() + "]");
//                }
//
//            }
//        };

        Runnable runnableLambda = () -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("Hello World from thread [" + Thread.currentThread().getName() + "]");
            }
        };

        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(runnableLambda);
            t.start();
            t.join();
        }
    }

}
