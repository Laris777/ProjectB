package virtual_pet;

public class Robot extends VirtualPet {
    
    private int oil;
    private int repair;
    private int maintenance;
    private int charge;
    private int health;
    private int happiness;

    public Robot(String petName, String petDescription, boolean isDog, int oil, int repair, int maintenance, int charge, int health, int happiness) {
        super(petName, petDescription, isDog, true);
        this.oil = oil;
        this.repair = repair;
        this.maintenance = maintenance;
        this.charge = charge;
        this.health = health;
        this.happiness = happiness;
    }

    public int getOil() {
        return oil;
    }

    public int getRepair() {
        return repair;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public int getCharge() {
        return charge;
    }

    public int getHealth() {
        return health;
    }

    public int getHappiness() {
        return happiness;
    }

    public void oilCan() {
        oil +=5;
        charge --;
    }

    public void replacementParts() {
        repair +=5;
        charge --;
    }

    public void tools() {
        maintenance +=5;
        charge --;
    }

    public void charger() {
        charge +=5;
        oil -=2;
        maintenance -=2;
        repair -=2;
    }

    public void play() {
        happiness +=5;
        charge--;
        oil--;
        maintenance--;
        repair--;
    }

    public void walk() {
        if(isDog) {
            happiness += 5;
            oil -= 5;
            charge -= 2;
        } else {
            System.out.println("Can't walk a cat!");
        }
    }

    public void tick() {
        super.tick();
        oil--;
        repair--;
        maintenance--;
        charge--;
        if (oil == 10) {
            health = 10;
            happiness = 10;
            System.out.println(petName + " is getting rusty!");
        }
        if (happiness == 10) {
            health = 10;
            System.out.println(petName + " is getting depressed!");
        }
    }
}
