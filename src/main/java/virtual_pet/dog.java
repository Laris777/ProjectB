package virtual_pet;

public class Dog extends Organics {

    private int cageDirtiness = 0;

    public Dog(String petName, String petDescription, int hunger, int thirst, int bathroom, int sleep, int happiness, int health) {
        super(petName, petDescription, true, false, hunger, thirst, bathroom, sleep, happiness, health);
        this.cageDirtiness = 0;
    }

    public int getCageDirtiness() {
        return cageDirtiness;
    }

    public void walk() {
        bathroom +=5;
        sleep--;
        happiness++;
    }

    public void cleanDogCages() {
        cageDirtiness = 0;
        health = 30;
    }

    public void dirtyCage() {
        happiness -=10;
        health -=10;
        cageDirtiness++;
    }

    public void tick() {
        super.tick();
        if (bathroom >= 10) {
            dirtyCage();
        }
    }

}
