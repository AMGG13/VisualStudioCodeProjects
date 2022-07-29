package OBJECTS;

import java.util.ArrayList;

public class Menu {
    private String Tittle;
    private ArrayList<String> Options;

    public Menu(String tittle) {
        setTittle(tittle);
        Options = new ArrayList<>();
    }
    public void setTittle(String tittle) {
        Tittle = tittle.toUpperCase();
    }
    public void addOptions(String[] options){
        for (int i = 0; i < options.length; i++) {
            Options.add(options[i]);
        }
    }
    public void showMenu(){
        System.out.println("-----"+getTittle()+"-----");
        int i = Options.size()-1;
        for (String menu: Options){
            System.out.println(i+"-"+menu);
            i--;
        }
    }

    public String getTittle() {
        return Tittle;
    }

    public ArrayList<String> getOptions() {
        return Options;
    }
}
