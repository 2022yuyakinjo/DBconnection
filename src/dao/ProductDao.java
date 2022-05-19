package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDao {

	private static final String SQL_SELECT_ALL = "SELECT product_id, product_name, price FROM products ORDER BY product_id";
	private static final String SQL_INSERT = "INSERT INTO products (product_name, price) VALUES (?, ?)";

	Connection connection;  //コネクション型のコネクション

	public ProductDao(Connection connection) {
		this.connection = connection;
	}

	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();
			//SELECT命令を実行するには、PreparedStatement#executeQueryメソッドを利用します。

			while (rs.next()) {  
				//next⇒次がある限り、繰り返し処理する
				Product u = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
				list.add(u);  
				//繰り返し処理した結果をlistに追加
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;   //結果が入ったlistはfindAllで呼び出されるようになっている
	}
	public void register(Product product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			//上部のプレースホルダー（？）に入れる値
			stmt.setString(1, product.getproduct_name());
			stmt.setInt(2, product.getprice());
			stmt.executeUpdate();  //

			return;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
//findAllの実装から