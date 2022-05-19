package util;

import java.sql.Connection;
import java.sql.DriverManager;
//getConnectionメソッドは、データベースへの接続のためのコネクションを取得する処理です。
//メソッド化して、再利用できるようにしています。
public class DbUtil {
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbconnection", "axizuser", "axiz");
        } catch (Exception e) {
            // 本来は専用の例外クラスを作成したほうがよい
            throw new RuntimeException(e);
        }
    }
}
