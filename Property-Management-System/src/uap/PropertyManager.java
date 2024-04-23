package uap;

import java.util.ArrayList;

public class PropertyManager {
	private String name;
	private ArrayList<Property> properties = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<LeaseRecord> records = new ArrayList<>();

	public PropertyManager(String name) {
		this.name = name;
	}

	public String getname() {
		return name;
	}

	public ArrayList<Property> getPropeties() {
		return properties;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<LeaseRecord> getRecords() {
		return records;
	}

	public String addUser(String name, int age, boolean isAdmin) {
	}

	// Apartment
	public String addProperty(String location, double rent, double floorSpace, int noOfBedRoom, int noOfWashRoom,
			boolean hasGenerator) {
		Apartment apartment = new Apartment(location, rent, floorSpace, noOfBedRoom, noOfWashRoom, hasGenerator);
		properties.add(apartment);
		return apartment.getId();

	}

	// Method to add a CommercialSpace property
	public String addProperty(String location, double rent, double floorSpace, boolean hasFireExit) {
		CommercialSpace c = new CommercialSpace(location, rent, floorSpace, hasFireExit);
		properties.add(c);
		return c.getId();
	}
  
	// Need to fix 
	/*
    		public ArrayList<Apartment> getApartments() throws NotAvailableException {
    		    ArrayList<Apartment> apartmentList = new ArrayList<>();

    		    if (apartmentList.isEmpty()) {
    		        throw new NotAvailableException("No apartments available");
    		    }

    		    return apartmentList;
    		}
     */
    		
	
    // Method to find apartments based on location, number of bedrooms, and number of washrooms
	public ArrayList<Apartment> findApartments(String location, int noOfBedRooms, int noOfWashRooms) {
		ArrayList<Apartment> foundApartments = new ArrayList<>();
		for (Property property : properties) {
			if (property instanceof Apartment) {
				Apartment apartment = (Apartment) property;
				if (apartment.getLocation().equalsIgnoreCase(location) && apartment.getNoOfBedRoom() == noOfBedRooms
						&& apartment.getNoOfWashRoom() == noOfWashRooms) {
					foundApartments.add(apartment);
				}
			}
		}
		return foundApartments;
	}

	// Method to find apartments based on location, number of bedrooms, number of
	// washrooms, minimum rent, and maximum rent
	public ArrayList<Apartment> findApartments(String location, int noOfBedRooms, int noOfWashRooms, int minRate,
			int maxRate) {
		ArrayList<Apartment> foundApartments = new ArrayList<>();
		for (Property property : properties) {
			if (property instanceof Apartment) {
				Apartment apartment = (Apartment) property;
				if (apartment.getLocation().equalsIgnoreCase(location) && apartment.getNoOfBedRoom() == noOfBedRooms
						&& apartment.getNoOfWashRoom() == noOfWashRooms && apartment.getRent() >= minRate
						&& apartment.getRent() <= maxRate) {
					foundApartments.add(apartment);
				}
			}
		}
		return foundApartments;
	}

	// Method to find stores based on location, floor space, minimum rent, and
	// maximum rent
	public ArrayList<Store> findStores(String location, double minFloorSpace, double maxFloorSpace, int minRate,
			int maxRate) {
		ArrayList<Store> foundStores = new ArrayList<>();
		for (Property property : properties) {
			if (property instanceof Store) {
				Store store = (Store) property;
				if (store.getLocation().equalsIgnoreCase(location) && store.getFloorspace() >= minFloorSpace
						&& store.getFloorspace() <= maxFloorSpace && store.getRent() >= minRate
						&& store.getRent() <= maxRate) {
					foundStores.add(store);
				}
			}
		}
		return foundStores;
	}

	// Method to find office spaces based on location, floor space, minimum rent,
	// and maximum rent
	public ArrayList<OfficeSpace> findOfficeSpaces(String location, double minFloorSpace, double maxFloorSpace) {
		ArrayList<OfficeSpace> foundOfficeSpaces = new ArrayList<>();
		for (Property property : properties) {
			if (property instanceof OfficeSpace) {
				OfficeSpace officeSpace = (OfficeSpace) property;
				if (officeSpace.getLocation().equalsIgnoreCase(location) && officeSpace.getFloorspace() >= minFloorSpace
						&& officeSpace.getFloorspace() <= maxFloorSpace) {
					foundOfficeSpaces.add(officeSpace);
				}
			}
		}
		return foundOfficeSpaces;
	}

	// Method to find a property by its id
	public Property findProperty(String id) {
		for (Property property : properties) {
			if (property.getId().equals(id)) {
				return property;
			}
		}
		return null;
	}

	// Method to rent a property
	public void rentProperty(String id, double rent, String rentedBy) {
		Property property = findProperty(id);
		if (property != null && property.isAvailable()) {
			property.rentProperty(rent, rentedBy);
			System.out.println("Property rented successfully!");
		} else {
			System.out.println("Property not available for rent.");
		}
	}

	// Method to mark lease over for a property
	public void leaseOver(String id) {
		Property property = findProperty(id);
		if (property != null && !property.isAvailable()) {
			property.leaseOver();
			System.out.println("Lease over successfully!");
		} else {
			System.out.println("No property found or property is already available for rent.");
		}
	}

	// Getter method for properties attribute
	public ArrayList<Property> getProperties() {
		return properties;
	}

	// Method to view all properties
	public void viewAll() {
		for (Property property : properties) {
			System.out.println(property);
		}
	}

	// Method to view details of a property by its id
	public void viewDetails(String id) {
		Property property = findProperty(id);
		if (property != null) {
			System.out.println(property);
		} else {
			System.out.println("Property not found.");
		}
	}
}
