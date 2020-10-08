class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = java.util.Objects.requireNonNullElse(firstName, "");
    }

    public void setLastName(String lastName) {
        this.lastName = java.util.Objects.requireNonNullElse(lastName, "");
    }

    public String getFullName() {
        if (firstName.isEmpty() && lastName.isEmpty()) {
            return "Unknown";
        } else if (firstName.isEmpty()) {
            return lastName;
        } else if (lastName.isEmpty()) {
            return firstName;
        } else {
            return firstName + " " + lastName;
        }
    }
}