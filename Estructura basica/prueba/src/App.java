public class App {
    private static final int EDAD_MAYOR_DE_EDAD = 18;
    public static void main(String[] args) throws Exception {
        int tuEdad = 15;
        boolean mayorDeEdad = esMayorDeEdad(tuEdad);
        String phrase = mayorDeEdad ? "Eres mayor de edad" : "Eres menor de edad";
        System.out.println(phrase);
    }

    private static boolean esMayorDeEdad(int tuEdad) {
        //＜＞
        return !(tuEdad < EDAD_MAYOR_DE_EDAD);
    }
}
