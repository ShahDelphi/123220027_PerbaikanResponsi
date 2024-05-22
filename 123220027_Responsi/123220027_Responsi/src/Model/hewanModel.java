package Model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class hewanModel {
    Connection connection;
    Statement statement;
    
    public hewanModel() throws ClassNotFoundException{       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo","root","");
            System.out.println("Koneksi Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(hewanModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        }}
    public int getHewanData(){
    try{
        int totalData = 0;
        String query = "SELECT * FROM `hewan`";
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
    public void addHewan(String nama, String kelas, String jenis) throws Exception{
    try{
        String query = "INSERT `hewan`(`id`,`nama`,`kelas`,`jenis_makanan`)" +
                "VALUES (NULL" + ",'" + nama +"','" +kelas+"','" +jenis+ "')";
        statement = connection.createStatement();
        statement.executeUpdate(query);
        
    }   catch (SQLException ex) {
            Logger.getLogger(hewanModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String[][] readHewan(){
        try{
            int totalData = 0;
            String data[][] = new String[getHewanData()][4];
            String query = "SELECT * FROM `hewan`";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                data[totalData][0] = rs.getString("id");
                data[totalData][1] = rs.getString("nama");
                data[totalData][2] = rs.getString("kelas");
                data[totalData][3] = rs.getString("jenis_makanan");
                totalData++;
            }
            statement.close();
            return data;
            
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage() );
            return null;
        }
    }
    public void deleteHewan(String nama){
         try{
            String query = "DELETE FROM `hewan` WHERE `nama` = '"+nama+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage() );
        }
    }

    public void updateHewan(String id, String nama, String kelas, String jenis) {
         try{
        String query = "UPDATE `hewan`" + "SET" +
                "`nama`='" + nama + "'," +
                "`kelas`='" + kelas + "'," +
                "`jenis_makanan`='" + jenis + "'" +
                "WHERE `hewan`.`id` = " + id + "";
        statement = connection.createStatement();
        statement.executeUpdate(query);
        
    }   catch (SQLException ex) {
            Logger.getLogger(hewanModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(hewanModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}

