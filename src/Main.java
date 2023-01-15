/**
 * This program simulates button click on a keyboard.
 * It's aim is to train your hero in Oblivion game in particular skill
 * so she/he can obtain maximal level.
 *
 * How to use program:
 * 0. Configure program if needed. Follow //TODO instructions
 *    In main class, add training sessions and type you wish to perform.
 *    You can also configure action-key mapping in TrainerMaster if not default.
 * 1. Load game in Oblivion.
 * 2. Use Alt+Tab shortcut to minimalize game.
 * 3. Start this program.
 * 4. Re-activate game. You have 10 seconds.
 * 5. Close any journals, maps etc. Game needs to be in a state in which you can perform actions.
 * 6. Your hero will start training :)
 * Kysiek2D2
 */

public class Main {
    public static void main(String[] args) throws Exception {
        int timeBeforeProgramStartsInseconds = 10;

        System.out.println("Start the training!");
        Thread.sleep(timeBeforeProgramStartsInseconds*1000); // wait X seconds so player can re-activate game screen
        TrainerMaster masterTrainer = new TrainerMaster();

        //TODO -> change trainingSession to any positive non-zero number
        int trainingSessions = 20;
        //TODO -> add any number of training type, invoke proper method on masterTrainer instance
        //masterTrainer.trainConjuration(trainingSessions);
        //masterTrainer.trainAcrobatics(trainingSessions);
        masterTrainer.trainDestruction(trainingSessions);

        System.out.println("END");
    }
}
