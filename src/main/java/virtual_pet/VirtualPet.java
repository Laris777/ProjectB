package virtual_pet;

import java.util.UUID;

abstract public class VirtualPet { 
    protected String petId;
    protected String petName;
    protected String petDescription;
    protected boolean isDog;
    protected boolean isRobotic;

    public VirtualPet(String petName, String petDescription, boolean isDog, boolean isRobotic) {
        UUID uuid = UUID.randomUUID();
        petId = uuid.toString();
        this.petName = petName;
        this.petDescription = petDescription;
        this.isDog = isDog;
        this.isRobotic = isRobotic;
    }

    public boolean getIsRobot() {
        return isRobotic;
    }

    public boolean getIsDog() {
        return isDog;
    }

    public String getPetId() {
        return petId;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetDescription() {
        return petDescription;
    }

    protected void tick() {
        System.out.println(petName + " got a little older.");
    }

}
