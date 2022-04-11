package payment;

public class PaymentInfo() {

    private String name;
    private String address;
    private long creditCard;
    private int csv;
    private int zip;

    PaymentInfo() {
        String name;
        String address;
        long creditCard = 4012888888881881;
        int csv = 111;
        int zip = 11111;
    }

    PaymentInfo(String n, String a, long cc, int cv, int z) {
        String name = n;
        String address = a;
        long creditCard = cc;
        int csv = cv;
        int zip = z;
    }

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