package jdbcpracdeces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Hak210709.,");
        Statement st =con.createStatement();

        //soru: ogrenciler tablosuna bir kayit ekleyin
       // int s1 = st.executeUpdate("insert into ogrenciler values (300, 'Sena Can', 12 'K'");

        //System.out.println(s1+ "satir database'e eklendi.");

        //soru : ogrenciler tablosuna birden fazla deger ekleyin
        //(400, 'Sena Can', 12 'K'"),(401, 'Sena Can', 12 'K'"),(402, 'Sena Can', 12 'K'")
        /*
        String [] veri = {"insert into ogrenciler values (300, 'Sena Can', 12 'K')",
                          "insert into ogrenciler values (300, 'Sena Can', 12 'K')",
                         "insert into ogrenciler values (300, 'Sena Can', 12 'K')"};

    int count = 0;
    for (String each : veri) {
         count +=st.executeUpdate(each);

    }



        System.out.println(count + "satir eklendi");

         */

    // 2. yol:

        String [] veri2 = {"insert into ogrenciler values (500, 'Sena Can', 12 'K')",
                "insert into ogrenciler values (501, 'Sena Can', 12 'K')",
                "insert into ogrenciler values (502, 'Sena Can', 12 'K')"};

        for (String each : veri2){
            st.addBatch(each);// yukaridaki datalarin hepsini birlestiriyor

        }
        st.executeBatch(); // datalari tek seferde gonderiyor


    }

}
