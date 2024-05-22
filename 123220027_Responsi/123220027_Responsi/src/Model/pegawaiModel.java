package Model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pegawaiModel {
    Connection connection;
    Statement statement;
    
    public pegawaiModel() throws ClassNotFoundException{       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo","root","");
            System.out.println("Koneksi Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(hewanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        }}
    public int getPegawaiData(){
    try{
        int totalData = 0;
        String query = "SELECT * FROM `pegawai`";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
        totalData++;
        }
        statement.close();
        return totalData;
    }
    catch(Exception e){
        System.out.println("Error :" + e.getMessage());
        return 0;
    }} 

    public String[][] readPegawai(){
        try{
            int totalData = 0;
            String data[][] = new String[getPegawaiData()][5];
            String query = "SELECT * FROM `pegawai`";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                data[totalData][0] = rs.getString("id");
                data[totalData][1] = rs.getString("nama");
                data[totalData][2] = rs.getString("email");
                data[totalData][3] = rs.getString("password");
                data[totalData][4] = rs.getString("role");
                totalData++;
            }
            statement.close();
            return data;
            
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage() );
            return null;
        }
    }

    
}

