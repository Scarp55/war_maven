import java.util.Arrays;
import java.util.Random;

class Main {
    private static final int HUMANS_COUNT = 4;
    private static final Human[] HUMANS = new Human[HUMANS_COUNT];
    private static final int START_HUMAN_HEALTH = 100;
    private static final int START_HUMAN_HITS = 15;
    private static final int ORCS_COUNT = 2;
    private static final Orc[] ORCS = new Orc[ORCS_COUNT];
    private static final int START_ORC_HEALTH = 200;
    private static final int START_ORC_HITS = 30;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        //Устанавливаем войска альянса
        for (int i = 0; i < HUMANS.length; i++) {
            HUMANS[i] = new Human("Чел" + (i + 1), START_HUMAN_HEALTH, START_HUMAN_HITS);
        }

        //Устанавливаем войска орды
        for (int i = 0; i < ORCS.length; i++) {
            ORCS[i] = new Orc("Орк" + (i + 1), START_ORC_HEALTH, START_ORC_HITS);
        }

        //бой идет до тех пор пока в одно из команд не останется живых бойцов
        while (isAlive()) {
            //индекс случайного живого орка
            int indexOrc = selectPlayer(ORCS);
            //индекс случайного живого человека
            int indexHuman = selectPlayer(HUMANS);
            //передает кто атакует, случайного орка, случайного человека
            hit(RANDOM.nextBoolean(), ORCS[indexOrc], HUMANS[indexHuman]);

            printText();
        }
    }

    //индекс случайного живого бойца
    private static int selectPlayer(Player[] players) {
        while (true) {
            Player player = players[RANDOM.nextInt(players.length)];
            if (player.getHealth() > 0) {
                return Arrays.asList(players).indexOf(player);
            }
        }
    }

    //наносим удар
    private static void hit(boolean whoHit, Orc orc, Human human) {
        //передаем человека, орка, зона атаки, зона защиты, сила атаки
        if (whoHit) {
            human.attack(human, orc, RANDOM.nextInt(3), RANDOM.nextInt(3), RANDOM.nextInt(5));
        } else {
            orc.attack(orc, human, RANDOM.nextInt(3), RANDOM.nextInt(3), RANDOM.nextInt(3));
        }
    }

    private static boolean isAlive() {

        boolean isAliveHuman = false;

        for (Human h : HUMANS) {
            if (h.health > 0) {
                isAliveHuman = true;
                break;
            }
        }

        boolean isAliveOrc = false;

        for (Orc o : ORCS) {
            if (o.health > 0) {
                isAliveOrc = true;
                break;
            }
        }

        if (!isAliveHuman) {
            System.out.println("Победила Орда");
            return false;
        }

        if (!isAliveOrc) {
            System.out.println("Победил Альянс");
            return false;
        }

        return true;
    }

    private static void printText() {

        StringBuilder text = new StringBuilder();

        for(Human h:HUMANS) {
            text.append(h.health);
            text.append(" ");
        }

        text.append("    ");

        for(Orc o:ORCS) {
            text.append(o.health);
            text.append(" ");
        }

        System.out.println(text);
    }
}