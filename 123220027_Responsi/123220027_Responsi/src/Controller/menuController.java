package Controller;

import Model.menuModel;
import View.Menu;

public class menuController {
    menuModel model;
    Menu view;

    public menuController(menuModel model, Menu view) {
       this.model = model;
        this.view = view;
        String user = model.username;
        view.labelWelcome.setText("Selamat Datang " + user);
    }
    
}
