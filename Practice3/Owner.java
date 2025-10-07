public class Owner {
    private String cmnd;
    private String fullName;
    private String email;

    public Owner(String cmnd, String fullName, String email) {
        if (!cmnd.matches("\\d{12}")) {
            throw new IllegalArgumentException("CMND must have exactly 12 digits");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.cmnd = cmnd;
        this.fullName = fullName;
        this.email = email;
    }

    public String getCmnd() {
        return cmnd;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return fullName + " (CMND: " + cmnd + ", Email: " + email + ")";
    }
}
