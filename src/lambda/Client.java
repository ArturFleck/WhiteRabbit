package lambda;

class Client {
    String name;
    int sum;
    boolean isActive;

    public Client(String name, int sum, boolean isActive) {
        this.name = name;
        this.sum = sum;
        this.isActive = isActive;
    }

    public int getBalance() {
        return sum;
    }

    public void setBalance(int sum) {
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", sum=" + sum +
                ", isActive=" + isActive;
    }
}
