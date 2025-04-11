/**
 * User - Abstract base class for all users in the ATM system
 */
public abstract class User {
    protected String userId;
    protected String pin;
    
    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }
    
    public String getPin() {
        return pin;
    }
}