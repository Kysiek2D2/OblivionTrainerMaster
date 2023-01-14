import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) throws Exception {
        int trainingSessions = 20;
        int restAfterTrainingSessionInSecods = 3;

        System.out.println("Start the training!");
        Thread.sleep(5000); // wait 5 seconds so player can re-activate game screen

        Robot robot = new Robot();

        for( ; trainingSessions>0; trainingSessions--){
            robot.keyPress(KeyEvent.VK_C);
            Thread.sleep(2000);
            robot.keyRelease(KeyEvent.VK_C);
            Thread.sleep(restAfterTrainingSessionInSecods*1000);
        }
        System.out.println("END");
    }
}
