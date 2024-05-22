package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class hewanView extends JFrame{
    JLabel labelNama = new JLabel("Nama");
    JLabel labelKelas = new JLabel("Kelas");
    JLabel labelJenis = new JLabel("Jenis");
    
    public JTextField inputId = new JTextField();
    public JTextField inputNama = new JTextField();
    public JTextField inputKelas = new JTextField();
    public JTextField inputJenis = new JTextField();
    
    public JButton buttonAdd = new JButton("Tambah");
    public JButton buttonUpdate = new JButton("Edit");
    public JButton buttonDelete = new JButton("Hapus");
    public JButton buttonBack = new JButton("Kembali");
    
    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    
    public Object[] columnName = {"Id", "Nama","Kelas","Jenis_makanan"};
    
    public hewanView(){
    dtm = new DefaultTableModel(columnName,0);
    table = new JTable(dtm);
    scrollPane = new JScrollPane(table);
    setTitle("Data Hewan");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
    setResizable(false);
    setLayout(null);
    setSize(700,400);
    add(scrollPane);
    scrollPane.setBounds(20, 20, 480, 300);
    add(labelNama);
    labelNama.setBounds(510, 20, 90, 20);
    add(inputNama);
    inputNama.setBounds(510, 40, 90, 20);
    add(labelKelas);
    labelKelas.setBounds(510, 60, 90, 20);
    add(inputKelas);
    inputKelas.setBounds(510, 80, 90, 20);
    add(labelJenis);
    labelJenis.setBounds(510, 100, 90, 20);
    add(inputJenis);
    inputJenis.setBounds(510, 120, 90, 20);
    
    add(buttonAdd);
    buttonAdd.setBounds(510, 190, 90, 20);
    add(buttonUpdate);
    buttonUpdate.setBounds(510, 220, 90, 20);
    add(buttonDelete);
    buttonDelete.setBounds(510, 250, 90, 20);
    add(buttonBack);
    buttonBack.setBounds(510, 280, 90, 20);
    
    setLocationRelativeTo(null);
    }

    public String getNama(){
        return inputNama.getText();
    }
    public String getKelas(){
        return inputKelas.getText();
    }
    public String getJenis(){
        return inputJenis.getText();
    }
}
