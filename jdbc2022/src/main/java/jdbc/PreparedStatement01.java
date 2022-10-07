package jdbc;

import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Hak210709.,");
        Statement st = con.createStatement();

        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.

        //1. adim: Prepared statement querysini olustur

        String sql1 = "update companies set number_of_employees = ? = where company = ?";

        //2.adim:Preparedstatement objesini  olustur.
        PreparedStatement pst1 = con.prepareStatement(sql1);


        // 3. adim : set...() methodlari ile soru iisaretleri icin deger gir.
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        //4. adim:
        int updateRowSayisi = pst1.executeUpdate();
        System.out.println(updateRowSayisi+" satir guncellendi");

        String sql2 = "SELECT * FROM companies";
        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()) {

            System.out.println(result1.getInt(1) + "--" + result1.getString(2) + "--" + result1.getInt(3));
        }


        // google icin degisiklik
        pst1.setInt(1, 15000);
        pst1.setString(2, "GOOGLE");


        int updateRowSayisi2 = pst1.executeUpdate();

        System.out.println(updateRowSayisi2 + "satir guncellendi");

        String sql3 = "SELECT * FROM COMPANİES";
        ResultSet result2 = st.executeQuery(sql2);

        while (result1.next()) {

            System.out.println(result2.getInt(1) + "--" + result2.getString(2) + "--" + result2.getInt(3));
        }


//        //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.

            read_data(con,"companies");
    }
        // bir tablonun istenilen datasini preparend statement ile cagirmak icin kullanilan method.
        public static void read_data (Connection con , String tablenane){
            try {

                String query = String.format(" SELECT * FROM %s",tablenane);//format methodu dimamik String olusturmak icin kullanilir

                Statement statement = con.createStatement();
                //SQL query'yi calistir
                ResultSet rs = statement.executeQuery(query); // datayi cagirip ResultSet konteynirina koyyoruz

                while (rs.next()){//tum datayi cagıralim

                    System.out.println(rs.getString(1)+ "--"+rs.getString(2)+"--"+rs.getInt(3));

                }


                 }catch (Exception e){

                System.out.println(e);
            }




        }


    }

