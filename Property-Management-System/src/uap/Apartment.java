package uap;
public class Apartment extends Property {
    private int noOfBedRoom;
    private int noOfWashRoom;
    private boolean hasGenerator;
    public Apartment( String location, double floorspace, double rent, int noOfBedRoom, int noOfWashRoom, boolean hasGenerator) {
        super(location ,floorspace, rent);
        this.noOfBedRoom = noOfBedRoom;
        this.noOfWashRoom = noOfWashRoom;
        this.hasGenerator = hasGenerator;
        addPrefixToId("a-");
    }

    public int getNoofBedRoom() {
    	return noOfBedRoom;
    }
    
    public int getNoofWashRoom() {
    	return noOfWashRoom ;
    }
    
    public boolean hasGenerator() {
    	return hasGenerator;
    }
    
    
    @Override
    public double getSecurityDeposit() {
        return getRent() * 2; // Rent of 3 months as security deposit for apartment
    }
}
