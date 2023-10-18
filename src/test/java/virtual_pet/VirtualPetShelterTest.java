package virtual_pet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.*;

public class VirtualPetShelterTest {
    
    VirtualPetShelter shelter;
    
    @BeforeEach
    public void init() {
        shelter = new VirtualPetShelter();
    }

    @Test
    public void testFeedAll() {// test feed all
        System.out.println(shelter.getAllPets().size());
        VirtualPet pet = shelter.getPetByName("Cujo");
        if(pet.getIsDog()) {
            Dog dog = (Dog) pet;
            int hungerBefore = dog.getHunger();
            shelter.feedPets();
            int hungerAfter = dog.getHunger();
            assertTrue(hungerBefore < hungerAfter);
        }
    }

    @Test
    public void testSleepAll() {// test feed all
        System.out.println(shelter.getAllPets().size());
        VirtualPet pet = shelter.getPetByName("Cujo");
        if(pet.getIsDog()) {
            Dog dog = (Dog) pet;
            int sleepBefore = dog.getSleep();
            shelter.sleepPets();
            int sleepAfter = dog.getSleep();
            assertTrue(sleepBefore < sleepAfter);
        }
    }

    @Test
    public void testWaterAll() {// test water all
        System.out.println(shelter.getAllPets().size());
        VirtualPet pet = shelter.getPetByName("Cujo");
        if(pet.getIsDog()) {
            Dog dog = (Dog) pet;
            int thirstBefore = dog.getThirst();
            shelter.waterPets();
            int thirstAfter = dog.getThirst();
            assertTrue(thirstBefore < thirstAfter);
        }
    }
}
