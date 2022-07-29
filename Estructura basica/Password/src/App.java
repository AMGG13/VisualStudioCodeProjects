public class App {
    private static String[] characters;

    public static void main(String[] args) throws Exception {
        String password = new String("");
        int lenghtPassword = 99999;
        //＜＞
        password = createPassword(password, lenghtPassword);
        System.out.println(password);
    }

    private static String createPassword(String password, int lenghtPassword) {
        String bigLetters = new String("QWERTYUIOPASDFGHJKLÑZXCVBNM");
        String lilLetters = new String("qwertyuiopasdfghjklñzxcvbnm");
        String numbers = new String("1234567890");
        String symbols = new String("!·$%&/=?¿^*¨_");

        characters = new String[] { bigLetters, lilLetters, numbers, symbols };
        for (int i = 0; i < lenghtPassword; i++) {
            double randomStringAux = Math.random() * characters.length;
            int randomString = (int) randomStringAux;
            double randomCharAux = Math.random() * characters[randomString].length();
            int randomChar = (int) randomCharAux;
            password = password + characters[randomString].charAt(randomChar);
        }
        return password;

    }
}
