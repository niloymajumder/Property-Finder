package uap;

import java.util.Random;

public class User {
	private int id;
	private String name;
	private int age;
	private boolean isAdmin;

	public User(String name, int age, boolean isAdmin) {
		this.name = name;
		this.age = age;
		this.isAdmin = isAdmin;
		this.id = generateId(isAdmin);
	}

	private int generateId(boolean isAdmin) {
		Random rand = new Random();
		String randomNumber = "" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		String prefix;
		if (isAdmin) {
			prefix = "11-";
		} else {
			prefix = "22-";
		}

		String idString = prefix + randomNumber;
		return Integer.parseInt(idString);
	}

}
