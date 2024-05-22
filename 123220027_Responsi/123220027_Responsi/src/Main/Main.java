package Main;

import Controller.loginController;
import Model.userModel;
import View.LoginPageView;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        userModel model = new userModel();
        LoginPageView view = new LoginPageView();
        loginController controller = new loginController(model,view);
        
    }
    
}
