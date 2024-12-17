package org.example.Transactions.StandartThread;

public class Ex2 {
    private static final String MESSAGE_TEMPLATE_THREAD_STATE = "%s : %s\n";
    public static void main(String[] args) {
        final Thread thread = new Thread(() -> showThreadState(Thread.currentThread()));
        showThreadState(thread);
        thread.start();
    }

    private static void showThreadState(final Thread thread){
        System.out.println(String.format(MESSAGE_TEMPLATE_THREAD_STATE,thread.getName(), thread.getState()));
    }
}
