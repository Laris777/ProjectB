package virtual_pet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.*;
public class VirtualPetTest {
    Dog pet;

    @BeforeEach
    public void init() {
        System.out.println("before our test.");
        pet = new Dog("Sadie", "Dog", 30, 30, 30, 30, 30, 30);
    }
    
    @Test
    void feed() {// testing feed method
        int hungerBefore = pet.getHunger();
        pet.feed();
        int hungerAfter = pet.getHunger();
        assertTrue(hungerBefore < hungerAfter);
    }

    @Test
    public void sleep() {// testing sleep method
        int sleepBefore = pet.getSleep();
        pet.sleep();
        int sleepAfter = pet.getSleep();
        assertTrue(sleepBefore < sleepAfter);
    }

    @Test
    public void play() {// testing play method
        int playBefore = pet.getHappiness();
        pet.play();
        int playAfter = pet.getHappiness();
        assertTrue(playBefore < playAfter);
    }

    
}
