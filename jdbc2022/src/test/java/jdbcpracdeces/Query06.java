package jdbcpracdeces;

import static jdbcPractise.DatabaseUtilty.*;

public class Query06 {
    public static void main(String[] args) {

        createConnection();

        String query =  "select * from ogrenciler";

        System.out.println("Sutun isimleri"+ getColumnNames(query));

        System.out.println("okul no: "+getColumnData(query , "okul no")) ;
        System.out.println("Öğrenci İsmi: " + getColumnData(query, "ogrenci_ismi"));
        System.out.println("Sinif: " + getColumnData(query, "sinif"));
        System.out.println("Cinsiyet: " + getColumnData(query, "cinsiyet"));
    }
}