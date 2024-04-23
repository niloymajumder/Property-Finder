package uap;

public class CommercialSpace extends Property {
	
	private boolean hasFireExit;
	
	
	
    public CommercialSpace(String location, double rent, double floorspace,boolean hasFireExit ) {
		super(location, rent, floorspace);
		this.hasFireExit=hasFireExit;
		addPrefixToId("c-");
	}

    public boolean hasFireExit() {
    	return hasFireExit;
    }

    public void setHasFireExit(boolean available) {
    	hasFireExit  = available;
    }
    
    @Override
    public double getSecurityDeposit() {
        return getRent() * 6; 
    }
}

