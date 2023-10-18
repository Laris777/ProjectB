package virtual_pet;

public class Organics extends VirtualPet {

    protected int hunger;
    protected int thirst;
    protected int bathroom;
    protected int sleep;
    protected int happiness;
    protected int health;

    public Organics(String petName, String petDescription, boolean isDog, boolean isRobotic, int hunger, int thirst, int bathroom, int sleep, int happiness, int health) {
        super(petName, petDescription, isDog, isRobotic);
        this.hunger = hunger;
        this.thirst = thirst;
        this.bathroom = bathroom;
        this.sleep = sleep;
        this.happiness = happiness;
        this.health = health;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBathroom() {
        return bathroom;
    }

    public int getSleep() {
        return sleep;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHealth() {
        return health;
    }

    public void feed() {
        hunger +=5;
        thirst--;
        sleep--;
    }

    public void water() {
        thirst +=5;
        bathroom -=5;
    }

    public void sleep() {
        sleep +=5;
        hunger -=5;
        thirst -=5;
        bathroom -=5;
        health +=5;
    }

    public void play() {
        happiness +=5;
        sleep--;
        thirst--;
        bathroom--;
    }

    protected void tick() {
        super.tick();
        bathroom --;
        hunger--;
        thirst--;
        happiness--;
        sleep--;
        if (hunger == 10) {
            health = 10;
            System.out.println(petName + " is starving.");
        }
        if (thirst == 10) {
            health = 10;
            System.out.println(petName + " is dehydrated");
        }
        if (happiness == 10) {
            health = 10;
            System.out.println(petName + " is getting depressed!");
        }
    }

}
