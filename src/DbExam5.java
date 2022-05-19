//動作確認用mainメソッドの作成
import java.sql.Connection;
import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbExam5 {
	public static void main(String[] args) {
		
		ProductDao productDao;
		Connection connection;  //定義
		
		connection = DbUtil.getConnection();  //DbUtilクラスからgetConnectionメソッドを引っ張る
		
		productDao = new ProductDao(connection);  //インスタンスを生成
		
		List<Product> list = productDao.findAll();
		
		Product newproduct = new Product(null, "ボールペン", 200);
		productDao.register(newproduct);

		for(Product i : list)  {  //for(型 変数(なんでもいい) : 回したいもの)
			System.out.println("product_id" + i.getproduct_id() + ", product_name:" + i.getproduct_name() + ", price:" + i.getprice());
			//iのid・name・priceが入って、回して、次のやつが入る
		}

	}
}

