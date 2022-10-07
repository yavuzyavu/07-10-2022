package jdbc;

import java.sql.*;

public class AAA {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Hak210709.,");
        Statement st = con.createStatement();


        //1. Örnek: Prepared statement kullanarak company adı IBM olan
        // number_of_employees değerini 9999 olarak güncelleyin.

        // 1. Adım: Prepared Statement query'sini oluştur.
        String sql1= "update companies set number_of_employees = ? where company = ?";


        //2. Adım: PreparedStatement Objesini oluştur
        PreparedStatement pst1=con.prepareStatement(sql1);

        //3. Adım: set...() methodları ile soru işaretleri için değer gir.
        pst1.setInt(1, 9999);
        pst1.setString(2,"IBM");

        //4. Adım: Execute query
        int updateRowSayisi=pst1.executeUpdate();
        System.out.println(updateRowSayisi + " satır güncellendi");

        String sql2= "select * from companies";
        ResultSet result1= st.executeQuery(sql2);

        while (result1.next()) {
            System.out.println(result1.getInt(1) + " " + result1.getString(2) + " " + result1.getString(3));

        }

        //Google için değişiklik
        pst1.setInt(1, 15000);
        pst1.setString(2,"GOOGLE");

        //4. Adım: Execute query
        int updateRowSayisi2=pst1.executeUpdate();
        System.out.println(updateRowSayisi2 + " satır güncellendi");

        String sql3= "select * from companies";
        ResultSet result2= st.executeQuery(sql3);

        while (result2.next()) {
            System.out.println(result2.getInt(1) + " " + result2.getString(2) + " " + result2.getString(3));

        }

        //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.

        System.out.println("=====================");
        read_data(con,"companies");
    }

    //Bir tablonun istenilen datasını prepared statement ile çağırtmak için kullanılan method
    public static void read_data(Connection con,String tableName) {

        try{
            String query= String.format("Select * from %s", tableName); // Froma() methodu dinamik String oluşturmak için kullanılır
            Statement statement=con.createStatement();
            ResultSet rs=statement.executeQuery(query);

            while(rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));


            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
