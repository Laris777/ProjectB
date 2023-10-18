package virtual_pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class VirtualPetShelter {
    
    // HashMap of virtual pets
    HashMap<String, VirtualPet> petList; 
        
    // Default starting pets
    public VirtualPetShelter () {
        petList = new HashMap<String, VirtualPet>();
        Dog dog = new Dog("Cujo", "Organic Dog", 30, 30, 30, 30, 30, 30);
        petList.put(dog.getPetId(), dog);
        Cat cat = new Cat("Josie", "Organic Cat", 30, 30, 30, 30, 30, 30);
        petList.put(cat.getPetId(), cat);
        Robot roboDog = new Robot("Beethoven", "Robotic Dog", true, 30, 30, 30, 30, 30, 30);
        petList.put(roboDog.getPetId(), roboDog);
        Robot roboCat = new Robot("Chester", "Robotic Cat", false, 30, 30, 30, 30, 30, 30);
        petList.put(roboCat.getPetId(), roboCat);
    }

    public void intro() {
        System.out.println("Welcome to Laris' Second Chance Pet Shelter game, amok edition!");
        System.out.println("Your pets are patiently waiting for you and need your help!");
        System.out.println(" ");
    }

    public void doNothing() {
        tick();
    }

    public void rules() {
        System.out.println("For organic virtual pets: hunger, thirst, bathroom, happiness, sleep and health will start at 30 and decrease with time and other activities.");
        System.out.println("feed, water, walk / litter box, sleep, play will increase organic pets stat levels.");
        System.out.println("For robotic virtual pets: oil, repair, maintenance, happiness and charge will start at 30 and decrease with time and other activities");
        System.out.println("oil can, replacement parts, tools, play and charger will increase robotic pets stat levels.");
        System.out.println("Neglecting animals both organic and robotic will have negative consequences to health!!!");
        System.out.println(" ");
    }

    public Collection<VirtualPet> getAllPets() {
        return petList.values();
    }

    public void feedPets() {
        for(VirtualPet pet: petList.values()) {
            if(!pet.getIsRobot()) {
                Organics orgPet = (Organics) pet;
                orgPet.feed();
            }
            System.out.println("All organic pets have been given food.");
        }
    }

    public void walkAllDogs() {
        for(VirtualPet pet: petList.values()) {
            if(pet.getIsRobot()) {
                Robot roboPet = (Robot) pet;
                roboPet.walk();
            } else if(pet.getIsDog()){ 
                Dog dog = (Dog) pet;
                dog.walk();
            }
            System.out.println("All dogs have been walked.");
        }
    }

    public void waterPets() {
        for(VirtualPet pet: petList.values()) {
            if(!pet.getIsRobot()) {
                Organics orgPet = (Organics) pet;
                orgPet.water();
            }
            System.out.println("All organic pets have been given water.");
        }
    }

    public void sleepPets() {
        for(VirtualPet pet: petList.values()) {
            if(!pet.getIsRobot()) {
                Organics orgPet = (Organics) pet;
                orgPet.sleep();
            }
            System.out.println("All organic pets have slept.");
        }
    }

    public void playPets() {
        for(VirtualPet pet: petList.values()) {
            if(pet.getIsRobot()) {
                Robot roboPet = (Robot) pet;
                roboPet.play();
            } else {
                Organics orgPet = (Organics) pet;
                orgPet.play();
            }
            System.out.println("All pets have been played with.");
        }
    }

    public void catsUseLitterBox() {
        for(VirtualPet pet: petList.values()) {
            if(!pet.getIsRobot()) {
                if(!pet.getIsDog()) {
                    Cat cat = (Cat) pet;
                    cat.useLitterBox();
                }
            }
        }
        System.out.println("All organic cats have used the litter box.");
    }
    
    public void litterBoxCleaning() {
        for(VirtualPet pet: petList.values()) {
            if(!pet.getIsRobot()) {
                if(!pet.getIsDog()) {
                    Cat cat = (Cat) pet;
                    cat.cleanLitterBox();
                }
            }
        }
        System.out.println("All litter boxes have been cleaned.");
    }

    public void dogCageCleaning() {
        for(VirtualPet pet: petList.values()) {
            if(!pet.getIsRobot()) {
                if(pet.getIsDog()) {
                    Dog dog = (Dog) pet;
                    dog.cleanDogCages();
                }
            }
        }
        System.out.println("All organic dog cages have been cleaned.");
    }

    public void oilPets() {
        for(VirtualPet pet: petList.values()) {
            if(pet.getIsRobot()) {
                Robot roboPet = (Robot) pet;
                roboPet.oilCan();
            }
        }
    }

    public void replacementPartPets() {
        for(VirtualPet pet: petList.values()) {
            if(pet.getIsRobot()) {
                Robot roboPet = (Robot) pet;
                roboPet.replacementParts();
            }
        }
    }

    public void toolPets() {
        for(VirtualPet pet: petList.values()) {
            if(pet.getIsRobot()) {
                Robot roboPet = (Robot) pet;
                roboPet.tools();
            }
        }
    }
    
    public void chargePets() {
        for(VirtualPet pet: petList.values()) {
            if(pet.getIsRobot()) {
                Robot roboPet = (Robot) pet;
                roboPet.charger();
            }
        }
    }

    // tick to do all ticks from other classes
    public void tick() {
        for(VirtualPet pet: petList.values()) {
            pet.tick();
        }
    }

    public void admitPet(VirtualPet pet) {
        petList.put(pet.getPetId(), pet);
    }

    public boolean adoptPet(String petName) {
        for(VirtualPet pet: petList.values()) {
            if(pet.getPetName().equals(petName)) {
                petList.remove(pet.getPetId());
                return true;
            } 
        }
        System.out.println("Couldn't find " + petName);
        return false;
    }

    public VirtualPet getPetByName(String petName) {
        for(VirtualPet pet: petList.values()) {
            if(pet.getPetName().equals(petName)) {
                return pet;
            }
        }
        return null;
    }

}


