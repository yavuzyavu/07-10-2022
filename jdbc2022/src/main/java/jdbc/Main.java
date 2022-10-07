package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {


        // DbWork objesini olustur.
        DbWork db = new DbWork ();


        Connection con = db.connect_to_db("techproed", "postgres"," Hak210709.,");

        //Yeni table olusturma methodu cagır.
        db.createTable(con,"employees");







    }
}
