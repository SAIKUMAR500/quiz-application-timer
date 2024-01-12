import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class quizss {

    private static final int TIMER_SECONDS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a timer
        Timer timer = new Timer();

        // Create a timer task to decrement the timer and check if the user has answered the question
        TimerTask timerTask = new TimerTask() {
            private int secondsRemaining = TIMER_SECONDS;

            @Override
            public void run() {
                secondsRemaining--;

                if (secondsRemaining == 0) {
                    // The timer has expired
                    System.out.println("Time's up!");
                    timer.cancel();
                } else {
                    // The timer is still running
                    System.out.println("Time remaining: " + secondsRemaining + " seconds");
                }
            }
        };

        // Schedule the timer task to run every second
        timer.scheduleAtFixedRate(timerTask, 0, 1000);

        // Ask the user a question
        System.out.println("What is the capital of France?");

        // Get the user's answer
        String answer = scanner.nextLine();

        // Check if the user's answer is correct
        if (answer.equalsIgnoreCase("Paris")) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The correct answer is Paris.");
        }

        // Cancel the timer
        timer.cancel();
    }
}