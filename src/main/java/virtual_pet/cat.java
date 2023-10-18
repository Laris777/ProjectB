package virtual_pet;

public class Cat extends Organics {
    
    private int litterBoxDirtiness = 0;

    public Cat(String petName, String petDescription, int hunger, int thirst, int bathroom, int sleep, int happiness, int health) {
        super(petName, petDescription, false, false, hunger, thirst, bathroom, sleep, happiness, health);
        this.litterBoxDirtiness = 0;
    }

    public int getLitterBoxDirtiness() {
        return litterBoxDirtiness;
    }

    public void useLitterBox() {
        litterBoxDirtiness += 5;
        dirtyLitterBox();
    }

    public void dirtyLitterBox() {
        happiness -=10;
        health -=10;
    }

    public void cleanLitterBox() {
        litterBoxDirtiness = 0;
    }    

    public void tick() {
        super.tick();
        litterBoxDirtiness++;
    }
}
