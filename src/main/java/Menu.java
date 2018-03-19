import java.io.BufferedReader;
import java.io.IOException;

public class Menu {

    private BufferedReader bufferedReader;


    public Menu(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String returnOptions() {
        return "1. List Books";
    }

    public String readUserMenuChoice() {
        String output = "";
        String choice = readLine();
        if (choice.equals("1")) {
            output = "You've selected List Books";
        }
        else {
            output = "That is an invalid menu option!\nPlease enter the number next to the option you want.";
        }

        return output;
    }

    public String readLine() {
        String choice = null;
        try {
            choice = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }


}
