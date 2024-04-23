package uap;

import java.util.Random;

public abstract class Property {
	private String id;
	private String location;
	private double floorspace;
	private double rent;
	private boolean isAvailable;
	private String latestRecordId;

	public Property(String location, double rent, double floorspace) {

		this.location = location;
		this.floorspace = floorspace;
		this.rent = rent;
		Random rand = new Random();
		String id = "" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);

		this.isAvailable = true;

	}

	public String getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}

	public double getFloorspace() {
		return floorspace;
	}

	public double getRent() {
		return rent;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public String getLatestRecordId() {
		return latestRecordId;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public void setAvailable(boolean available) {
		isAvailable = available;
	}

	public void setLatestRecordId(String latestRecordId) {
		this.latestRecordId = latestRecordId;
	}

	protected void addPrefixToId(String prefix) {
		this.id = prefix + id;
	}

	public void lease() throws NotAvailableException {
		if (!isAvailable) {
			throw new NotAvailableException("Property is leased.");
		}
		isAvailable = false;
	}

	public abstract double getSecurityDeposit();

}