package models.generator;

import java.util.Random;

public class NameGenerator {
    public static final int
            MIN_APELLIDOS = 2, //Número de apellidos mínimo
            MAX_APELLIDOS = 3; //Número de apellidos máximo

    private static String[]
            nombres = {   //Conjunto de nombres posibles
            "Pablo",
            "Miguel",
            "Juan",
            "Elvira",
            "Carlos",
            "Sofia",
            "Karen",
            "Felipe",
            "Hermencia",
            "Luz",
            "Amara",
            "Yamile",
            "Lisa",
            "Bart",
            "Homero",
    },
            apellidos = {  //Conjunto de apellidos posibles
                    "Muñoz",
                    "Vargas",
                    "Bermudez",
                    "Gallegos",
                    "Peña",
                    "Sánchez",
                    "Domingo",
                    "Dominguez",
                    "Martinez",
                    "Acevedo",
                    "Bernal",
                    "Pena",
                    "Casteblanco",
                    "Suesca",
                    "Jimenez",
                    "Solano"
            };

    // Método que devuelve el nombre completo del cliente
    public static String generate() {
        Random rand = new Random();
        // Se elige de forma aleatoria un entero que corresponda
        // a un índice de los conjuntos de nombres y apellidos
        String name = nombres[rand.nextInt(nombres.length)]
                + " " + nombres[rand.nextInt(nombres.length)];

        // Regresa los nombres más dos apellidos o tres
        return name
                + escogeApellidos(rand.nextInt(MAX_APELLIDOS - MIN_APELLIDOS)
                + MIN_APELLIDOS);
    }

    // Método que devuelve n apellidos para el cliente
    private static String escogeApellidos(int n) {
        Random rand = new Random();
        String apellido = "";

        // Su suma la cadena de apellidos de forma que tenga n apellidos
        for (int i = 0; i < n; i++) {
            // Se elige un índice al azar para obtener un apellido del set
            apellido += " " + apellidos[rand.nextInt(apellidos.length)];
        }
        return apellido; // Regresa n apellidos

    }
}
