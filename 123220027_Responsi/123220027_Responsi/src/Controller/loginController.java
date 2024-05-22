package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.userModel;
import View.LoginPageView;

public class loginController {
    userModel model;
    LoginPageView view;
    
    public loginController (userModel model, LoginPageView view){
        this.model = model;
        this.view = view;
    
        view.blogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               String username = view.GetUsername();
               String password = view.GetPassword();
               model.loginUser(username,password);
               view.logout();
            }
        });
        
    
    }
    
    
}
