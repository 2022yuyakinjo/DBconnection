
//Entityクラス
package entity;
public class Product {

    private Integer product_id;
    private String product_name;
    private Integer price;

    public Product() {
    }
    
    public Product(Integer product_id, String product_name, Integer price) {
    	this.product_id = product_id;
    	this.product_name = product_name;
    	this.price = price;
    }

    public Integer getproduct_id() {
        return product_id;
    }

    public void setproduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getproduct_name() {
        return product_name;
    }

    public void setproduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getprice() {
        return price;
    }

    public void setprice(Integer price) {
        this.price = price;
    }

}
