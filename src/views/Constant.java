package views;

import java.awt.*;

public class Constant {

    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();


    //Images
    public static final String IMG_LOGO = "/logo.png";
    public static final String IMG_SLEEP_BARBER = "/sleep.gif";
    public static final String IMG_HAIRCUT = "/barberWorking.jpeg";
    public static final String IMG_DOOR = "/door.jpeg";
    public static final String IMG_CLIENT_LEAVING = "/leaving.jpeg";
    public static final String IMG_CLIENT_ENTERING = "/entering.png";
    public static final String IMG_CLIENT_NO_SPACE = "/nospace.png";


    //Text
    public static final String TITLE_STORE = "Barberia de Pepe";
    public static final String EXIT = "Salir";
    public static final String T_SIMULATOR = "Simulador";


    public static final String[] H_PRODUCTS = {"ID", "Nombre", "Prioridad"};
    public static final String[] CLIENTS = {"ID", "Nombre", "Prioridad", "Tiempo atencion"};

    //Colors
    public static final Color COLOR_WHITE = Color.decode("#ffffff");
    public static final Color COLOR_BLACK = Color.decode("#000000");
    public static final Color COLOR_BLUE_LIGHT_1 = Color.decode("#2fb7ec");
    public static final Color COLOR_RED_LIGHT_1 = Color.decode("#FF3030");
    public static final Color COLOR_YELLOW_1 = Color.decode("#EBC623");
    public static final Color COLOR_GRAY_LIGHT_1 = Color.decode("#c0c0c0");
    public static final Color COLOR_GRAY_LIGHT_2 = Color.decode("#f0f5f7");
    public static final Color COLOR_GRAY_LIGHT_3 = Color.decode("#f1f1f1");
    public static final Color COLOR_GRAY_LIGHT_4 = Color.decode("#D2CBDE");
    public static final Color COLOR_BLUE_DARK_1 = Color.decode("#131921");
    public static final Color COLOR_BLUE_DARK_2 = Color.decode("#232f3e");
    public static final Color COLOR_ORANGE_1 = Color.decode("#ff9900");
    public static final Color COLOR_ORANGE_2 = Color.decode("#FF4528");
    public static final Color COLOR_GREEN_1 = Color.decode("#5eb95e");
    public static final Color BLUE = Color.decode("#0C45A6");


    //Fonts
    public static final Font FONT_ARIAL_ROUNDER_17 = new Font("Arial Rounded MT Bold", Font.PLAIN, 17);
    public static final Font FONT_ARIAL_ROUNDER_20 = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
    public static final Font FONT_ARIAL_ROUNDER_25 = new Font("Arial Rounded MT Bold", Font.PLAIN, 25);
    public static final Font FONT_ARIAL_ROUNDER_25_B = new Font("Arial Rounded MT Bold", Font.BOLD, 25);
    public static final Font FONT_ARIAL_ROUNDER_35_B = new Font("Arial Rounded MT Bold", Font.BOLD, 30);
    public static final Font FONT_ARIAL_ROUNDER_30 = new Font("Arial Rounded MT Bold", Font.PLAIN, 30);
    public static final Font FONT_ARIAL_ROUNDER_15 = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
}
