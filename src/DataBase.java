import java.util.ArrayList;
public class DataBase {
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Product> products = new ArrayList<Product>();
    private static ArrayList<PromoCode> promoCodes = new ArrayList<PromoCode>();
    private static ArrayList<Admin> admins = new ArrayList<>();

    static {
        // Dummy Users
        users.add(new User("zeraiyasmine@gmail.com", "mypass", "yasmina", 1, "laMarsa"));
        users.add(new User("zeraiemna@gmail.com", "herpass", "ammouna", 2, "tunis"));
        users.add(new User("zeraisyrine@gmail.com", "herpass2", "sarrouna", 3, "tunis"));
        users.add(new User("salahali@gmail.com", "hispass", "salah", 4, "zaghouan"));
        users.add(new User("ahmed@gmail.com", "hispass2", "hammouda", 5, "bizerte"));

        // Dummy Products
        products.add(new SkinCareProduct("moisturizer", 20.99, 1, 50, "Cerave", "Dry Skin"));
        products.add(new MakeUpProduct("lipstick", 15.99, 2, 6, "essence", "Red"));
        products.add(new MakeUpProduct("lipstick", 13.99, 3, 11, "revolution", "Peachy"));
        products.add(new MakeUpProduct("lipstick", 15.99, 4, 40, "essence", "Pink"));
        products.add(new MakeUpProduct("lipstick", 15.99, 5, 30, "Kolsi", "Brown"));
        products.add(new Perfume("Libre", 399.99, 6, 40, "YvesSaintLaurent", "30ml"));
        products.add(new Perfume("L'interdit", 369.99, 7, 30, "Givenchy", "30ml"));
        products.add(new Perfume("Donna Born In Roma", 349.99, 8, 40, "valentino", "30ml"));
        products.add(new Perfume("My Way", 399.99, 9, 40, "Gorgio Armani", "50ml"));
        products.add(new Perfume("Bianco Latte", 499.99, 10, 40, "Giardini Di Toscana", "100ml"));
        products.add(new SkinCareProduct("Sun Screen", 25.99, 11, 60, "SVR", "Oily Skin"));
        products.add(new MakeUpProduct("Blush", 18.99, 12, 25, "MakeUpForever", "Pink"));
        products.add(new SkinCareProduct("moisturizer", 20.99, 1, 50, "La Roche Posay", "Dry Skin"));
        products.add(new SkinCareProduct("moisturizer", 29.99, 1, 50, "Cerave", "mixed skin"));
        products.add(new SkinCareProduct("moisturizer", 39.99, 1, 50, "Cerave", "oily skin"));
        //Dummy PromoCodes
        PromoCode promoCode1 = new PromoCode("SUMMER20", 20.0);
        PromoCode promoCode2 = new PromoCode("FALL25", 25.0);
        PromoCode promoCode3 = new PromoCode("WINTER15", 15.0);
        promoCodes.add(promoCode1);
        promoCodes.add(promoCode2);
        promoCodes.add(promoCode3);
        Admin admin1 = new Admin("admoun", "admin1pass");
        Admin admin2 = new Admin("yasmina", "mypass");
        Admin admin3 = new Admin("ahmed", "hamoudapass");

        admins.add(admin1);
        admins.add(admin2);
        admins.add(admin3);
    }
    public static ArrayList<Admin> getAdmins() {
        return admins;
    }
    public static ArrayList<User> getUsers() {
        return users;
    }
    public static ArrayList<Product> getProducts() {
        return products;
    }
    public static ArrayList<PromoCode> getPromoCodes(){return  promoCodes;}
    public static void addProduct(Product p){
        products.add(p);
    }
    public static void addPromoCode(PromoCode code){
       promoCodes.add(code);
    }
    public static void addAdmin(Admin admin) {
        admins.add(admin);
    }
    public static void addUser(User user){users.add(user);}

}
