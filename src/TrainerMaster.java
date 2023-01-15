import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class TrainerMaster {
    Robot robot;
    HashMap keysMap;

    /**
     * Creates TrainerMaster object with action-key mapping.
     * Action-key mapping is set to game default. If you wish to add or change mapping, you need to edit keysMap object
     * in below constructor.
     * @throws AWTException
     */
    public TrainerMaster() throws AWTException {
        robot = new Robot();
        keysMap = new HashMap<Activity, Integer>();
        keysMap.put(Activity.jump, KeyEvent.VK_E);
        keysMap.put(Activity.spell, KeyEvent.VK_C);
        keysMap.put(Activity.changeActiveSpellTo6, KeyEvent.VK_6);
        keysMap.put(Activity.changeActiveSpellTo8, KeyEvent.VK_8);
    }

    /**
     * Trains Conjuration skill. Remember to have proper conjuration spell as active spell.
     * @param trainingRounds - how many times will action be performed.
     * @throws Exception
     */
    public void trainConjuration(int trainingRounds) throws Exception {
        if(trainingRounds<=0) {throw new Exception("ERROR: training rounds need to be higher than 0!");}
        for( ; trainingRounds>0; trainingRounds--) {
            performActivity(Activity.spell, 6);
            System.out.println("Still "+trainingRounds+" training rounds to be performed.");
        }
    }

    /**
     * Trains Acrobatics skill.
     * @param trainingRounds - how many times will action be performed.
     * @throws Exception
     */
    public void trainAcrobatics(int trainingRounds) throws Exception {
        if(trainingRounds<=0) {throw new Exception("ERROR: training rounds need to be higher than 0!");}
        for( ; trainingRounds>0; trainingRounds--) {
            performActivity(Activity.jump, 1);
            System.out.println("Still "+trainingRounds+" training rounds to be performed.");
        }
    }

    /**
     * Trains Destruction skill.
     * Prerequisites to make this training work:
     * 1. Under '6' hotkey, have some cheap summon spell.
     * 2. Under '8' hotkey, have some cheap destruction spell.
     * 3. Stand in 'save' place so you won't hit any NPC with fireball. Make sure it's enough place to summon creature
     *    and throw at it with fireballs or smth.
     * Remember: destruction skill only increases if you hit enemy with your offensive spell.
     * @param trainingRounds
     * @throws Exception
     */
    public void trainDestruction(int trainingRounds) throws Exception {
        if(trainingRounds<=0) {throw new Exception("ERROR: training rounds need to be higher than 0!");}
        for( ; trainingRounds>0; trainingRounds--) {

            //Summon creature
            performActivity(Activity.changeActiveSpellTo6, 1); //Under '6' you need to have Summon 'creature' spell
            trainConjuration(1);

            //Throw fireballs or some other offensive spell
            performActivity(Activity.changeActiveSpellTo8, 1); //Under '8' you need to have cheap destruction spell
            for(int j = 5; j > 0; j--){
                performActivity(Activity.spell, 1); //Throw fireball at summoned creature
            }
            System.out.println("Still "+trainingRounds+" training rounds to be performed.");
        }
    }

    /**
     * Performs activity in game once.
     * @param activity - type of activity you with to perform.
     * @param restAfterTrainingRoundsInSecods - how much time will hero spent on resting after performing activity.
     * @throws InterruptedException
     */
    private void performActivity(Activity activity, int restAfterTrainingRoundsInSecods) throws InterruptedException {
        int key = (int) this.keysMap.get(activity);
        robot.keyPress(key);
        Thread.sleep(500); //Time needed between press and release for game to notice it
        robot.keyRelease(key);
        Thread.sleep(restAfterTrainingRoundsInSecods*1000);
    }
}