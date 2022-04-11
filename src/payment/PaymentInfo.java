package payment;

public class PaymentInfo() {

    private String name;
    private String address;
    private long creditCard;
    private int csv;
    private int zip;

    PaymentInfo() {
        this.name;
        this.address;
        this.creditCard = 4012888888881881;
        this.csv = 111;
        this.zip = 11111;
    }

    PaymentInfo(String n, String a, long cc, int cv, int z) {
        this.name = n;
        this.address = a;
        this.creditCard = cc;
        this.csv = cv;
        this.zip = z;
    }

    public int getCsv() {
        return csv;
    }

    public int getZip() {
        return zip;
    }

    public long getCreditCard() {
        return creditCard;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public

    public boolean verifyForm(long creditCard) {
        if (creditCard.startsWith('37') || creditCard.startsWith('34')) {
            return creditCard.length() == 15;
        } else {
            if (creditCard.startsWith('4') || creditCard.startsWith('5') || creditCard.startsWith('6')) {
                return creditCard.length() == 16;
            }
            return false;
        }
    } // is this even necessary
}