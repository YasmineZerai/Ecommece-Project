import java.util.Random;

public class SpinWheel {
    private static String[] prizeArray = {"Free Shipping", "Discount 20%", "Try Again", "Discount 30%", "No Luck"};

    public static String spin() {
        Random random = new Random();
        int randomIndex = random.nextInt(prizeArray.length);
        return prizeArray[randomIndex];
    }

}