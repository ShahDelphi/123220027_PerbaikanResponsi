package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Controller.menuController;
import View.Menu;

public class userModel {
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/zoo";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection connection;
    Statement statement;
    
    public userModel() {
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    public void loginUser(String username, String password){
           try {
            String query = "SELECT * FROM `pegawai` WHERE `nama` = '" +username+"' AND `password` = '" +password+ "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                menuModel model = new menuModel(username);
                Menu view = new Menu();
                menuController controller = new menuController(model,view);
                view.setVisible(true);
            }
            else if (username.isEmpty() || password.isEmpty()) {
                Menu view = new Menu();
             JOptionPane.showMessageDialog(view, "Username atau Password anda kosong");
            }
            else{
                 Menu view = new Menu();
             JOptionPane.showMessageDialog(view, "Username atau Password anda salah");
             statement.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        }
    
    }
