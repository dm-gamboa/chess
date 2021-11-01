package A01207448;

import A01207448.Enums.MenuOption;
import java.util.List;
import javax.swing.JFrame;

public class Menu extends JFrame {
    List<MenuOption> options;
    String message;

    Menu(List<MenuOption> options) {
        this.options = options;
        message = "";
    }

    void setOptions(List<MenuOption> options) {
        this.options = options;
    }

    List<MenuOption> getOptions() {
        return options;
    }

    void createOptionButtons() {}

    public void hide() {}

    public void display() {}
}
