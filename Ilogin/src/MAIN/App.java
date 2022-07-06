package MAIN;

import DAO.UsersManagement;
import EXCEPTIONS.IncorrectPasswordException;
import EXCEPTIONS.TooShortIDException;
import OBJECTS.Menu;
import OBJECTS.User;
import java.util.Scanner;

public class App {
    static Menu MiMenu;
    static UsersManagement DAO;
    static App app;
    public static void main(String[] args) throws IncorrectPasswordException, TooShortIDException {
        app = new App();
        app.run();
    }

    private void run() throws IncorrectPasswordException, TooShortIDException {
        DAO = new UsersManagement();
        MiMenu = new Menu("LOG IN");
        int option;
        loadoptions();
        do{
            MiMenu.showMenu();
            option = entradaInt("Choose: ");
            actions(option);
        }while(option != 0);
    }

    private void actions(int option) throws IncorrectPasswordException, TooShortIDException {
        switch (option) {
            case 0:
                System.out.println("Saliendo");
                break;
            case 1:
                removeAcc();
                break;
            case 2:
                registerApp();
                break;
            case 3:
                loginApp();
                break;
            default:
                System.err.println("Not implemented yet");
        }
    }

    private void loginApp() throws IncorrectPasswordException, TooShortIDException {
        int intentos = 3;
        int res = 0;
        do{
            String id = entradaString("Nombre de usuario:");
            String password = entradaString("Contraseña:");
            User aux = new User(id,password);
            if(DAO.login(aux)==2){
                res=2;
                System.out.println("[+]Successful");
            }
            else if (DAO.login(aux)==1){
                res=1;
                System.err.println("Incorrect password");
            }
            else{
                res=0;
                System.err.println("Account doesn't exist");
            }
            intentos--;
        }while(res != 2 && intentos != 0);
        if(intentos == 0){
            System.err.println("Demasiados intentos...");
        }

    
    }

    private void registerApp() throws IncorrectPasswordException, TooShortIDException {
        String id = entradaString("Nombre de usuario:");
        String password = entradaString("Contraseña:");
        String confirm_password = entradaString("Confirmar contraseña:");
        User aux = new User(id,password);
        if(password.equals(confirm_password)) {
            if (DAO.register(aux)) {
                System.out.println("Registered");
            } else {
                System.out.println("Already exist");
            }
        }else{
            System.out.println("La contraseña no coincide");
        }
    }

    private void removeAcc() throws IncorrectPasswordException, TooShortIDException {
        String id = entradaString("Nombre de usuario:");
        String password = entradaString("Contraseña:");
        String confirm = entradaString("Esta seguro de eliminar esta cuenta?");
        boolean afirm;
        if(confirm.equalsIgnoreCase("Si")){
            afirm = true;
        }else{
            afirm = false;
        }
        User aux = new User(id,password);
        if(DAO.removeUser(aux,afirm)){
            System.out.println("[+]User removed");
        }else{
            System.err.println("[-]Already exist");
        }
    }

    private int entradaInt(String phrase) {
        System.out.print(phrase);
        Scanner ent = new Scanner(System.in);
            return ent.nextInt();
    }

    private String entradaString(String phrase) {
        System.out.print(phrase);
        Scanner ent = new Scanner(System.in);
            return ent.nextLine();
    }
    private void loadoptions() {
        String opciones[] = {"Log in","Register","Remove account", "salir"};
        MiMenu.addOptions(opciones);
    }
}
