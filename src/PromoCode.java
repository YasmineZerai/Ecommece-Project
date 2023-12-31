public class PromoCode {
    private String code;
    private double discountPourcentage;
    private boolean isActive;
    public PromoCode(String code, double discountPourcentage) {
        this.code = code;
        this.discountPourcentage = discountPourcentage;
        this.isActive = true; // Promo code is active by default
    }

    public String getCode() {
        return code;
    }
    public double getDiscountPercentage() {
        return discountPourcentage;
    }
    public boolean isActive() {
        return isActive;
    }
    public void deactivate() {
        isActive = false;
    }
    public void activate() {
        isActive = true;
    }
}