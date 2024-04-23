package uap;

public class InvalidPropertyException extends Exception {
public InvalidPropertyException(String id) {
super(String.format("Property with id:%s is not a valid item", id));
}
}