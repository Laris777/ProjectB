package virtual_pet;

import java.util.Scanner;

public class Application {

  public static void main(String[] args) {

    VirtualPetShelter larisShelter = new VirtualPetShelter();
    
    //Intro
    larisShelter.intro();

    //game rules
    larisShelter.rules();

    for (VirtualPet pet:larisShelter.getAllPets()) {
        System.out.println(pet.getPetName());
    }

    //Game loop
    boolean isRunning = true; 
    Scanner input = new Scanner(System.in);
    while (isRunning) {
      System.out.println(" ");
      System.out.println("Here are the current status of pets.");
      for(VirtualPet pet: larisShelter.getAllPets()) {
        if (pet.isRobotic) {
          Robot roboPet = (Robot) pet;
          System.out.println("Name: " + roboPet.getPetName() + "\t|" + " Description: " + roboPet.getPetDescription() + "\t|" + " Oil: " + roboPet.getOil() + "\t|" + " Repair: " + roboPet.getRepair() + "\t|" + " Maintenance: " + roboPet.getMaintenance() + "\t|" + " Charge: " + roboPet.getCharge() + "\t|" + " Health: " + roboPet.getHealth() + "\t|" + " Happiness: " + roboPet.getHappiness());
        } else {
          Organics orgPet = (Organics) pet;
          System.out.println("Name: " + orgPet.getPetName() + "\t|" + " Description: " + orgPet.getPetDescription() + "\t|" + " Hunger: " + orgPet.getHunger() + "\t|" + " Thirst: " + orgPet.getThirst() + "\t|" + " Bathroom: " + orgPet.getBathroom() + "    \t|" + " Sleep: " + orgPet.getSleep() + "\t|" + " Happiness: " + orgPet.getHappiness() + "\t|" + " Health: " + orgPet.getHealth());
        }
      }
      System.out.println(" ");
      System.out.println("1 - Give food to all organic pets.");
      System.out.println("2 - Give water to all organic pets.");
      System.out.println("3 - Cats use litter box.");
      System.out.println("4 - Walk dogs.");
      System.out.println("5 - Play with all pets.");
      System.out.println("6 - Put all organic pets to bed.");
      System.out.println("7 - Clean litter box.");
      System.out.println("8 - Clean dog cages.");
      System.out.println("9 - Oil robots.");
      System.out.println("10 - Replace robot parts.");
      System.out.println("11 - Use tools to perform maintenance.");
      System.out.println("12 - Charge robots.");
      System.out.println("13 - adopt pet");
      System.out.println("14 - admit pet");
      System.out.println("0 - Exit game.");

      // Get user input
      System.out.println("Please select an option to continue.");
      int selection = input.nextInt();
      input.nextLine();

      switch(selection) {
        case 1:
          larisShelter.feedPets();
          break;
        case 2:
          larisShelter.waterPets();
          break;
        case 3:
          larisShelter.catsUseLitterBox();
          break;
        case 4:
          larisShelter.walkAllDogs();
          break;
        case 5:
          larisShelter.playPets();
          break;
        case 6:
          larisShelter.sleepPets();
          break;
        case 7:
          larisShelter.litterBoxCleaning();
          break;
        case 8:
          larisShelter.dogCageCleaning();
          break;
        case 9:
          larisShelter.oilPets();
          break;
        case 10:
          larisShelter.replacementPartPets();
          break;
        case 11:
          larisShelter.toolPets();
          break;
        case 12:
          larisShelter.chargePets();
          break;
        case 13:
          System.out.println("Enter the name of the pet you want to adopt.");
          String adoptName = input.nextLine();
          boolean wasAdopted = larisShelter.adoptPet(adoptName);
          if(wasAdopted) {
            System.out.println("You adopted " + adoptName);
          }
          break;
        case 14:
          System.out.println("Enter the new pets name");
          String admitPetName = input.nextLine();
          System.out.println("Enter the description of the new pet.");
          String admitPetDescription = input.nextLine();
          System.out.println("Is your pet robotic? Type: True, for robotic or False for organic.");
          boolean isRobotic = input.nextBoolean();
          System.out.println("Is your pet a dog? Type: True for dog or False for cat.");
          boolean isDog = input.nextBoolean();
          if(isRobotic) {
            Robot roboPet = new Robot(admitPetName, admitPetDescription, isDog, 30, 30, 30, 30, 30, 30);
            larisShelter.admitPet(roboPet);
            
          } else {
            if(isDog) {
              Dog dog = new Dog(admitPetName, admitPetDescription, 30, 30, 30, 30, 30, 30);
              larisShelter.admitPet(dog);
            } else {
              Cat cat = new Cat(admitPetName, admitPetDescription, 30, 30, 30, 30, 30, 30);
              larisShelter.admitPet(cat);
            }

          }
          break;
        case 0:
          isRunning = false;
          System.out.println("Thanks for playing!");
          continue;
        default:
          System.out.println("Selection must be 0 - 14.");
          break;
      }
      larisShelter.tick();
    }
    input.close();
  }
}