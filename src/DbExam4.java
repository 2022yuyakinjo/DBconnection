import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class DbExam4 {
	    public static void main(String[] args) {
	        Connection con = null;
	        PreparedStatement stmt = null;

	        try {
	            // load JDBC Driver
	            Class.forName("org.postgresql.Driver");

	            // confirm
	            System.out.println(" --- before connection --- ");

	            // database connect
	            con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

	            // confirm
	            System.out.println(" --- after connection --- ");


	            // SQL query string
	            String sql = "SELECT * FROM products WHERE product_name = ? OR product_id = ?";//第一因数　OR　第二因数
	            //productsテーブルに対して、product_idが 101 または product_nameが “地球儀” のレコードを取得する処理を実装してください

	            // create statement
	            String param = "地球儀";
	            int param2 = 101;
	            
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, param);
	            stmt.setInt(2, param2);
	            // execute
	            ResultSet rs = stmt.executeQuery();   //カラムとか

	            // output
	            while (rs.next()) {
	                int id = rs.getInt("product_id");
	                String name = rs.getString("product_name");
	                int price = rs.getInt("price");

	                System.out.print("product_id:" + id);
	                System.out.print(", product_name:" + name);
	                System.out.println(", price:" + price);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // close
	            if (stmt != null) {
	                try {
	                    stmt.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }

	            if (con != null) {
	                try {
	                    con.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}

