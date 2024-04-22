import java.util.List;

public class Product {
    int id;
    String name;
    int price;
    String data;
     String category;

    public Product(int _id, String _name, int _price, String _data, String _category){
        Setvalues(_id,_name,_price,_data, _category);
    }


public void Setvalues(int _id, String _name, int _price, String _data, String _category) {
    id = _id;
    name = _name;
    price = _price;
    data = _data;
    category = _category;
}
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getData() {
        return data;
    }

    public String getCategory() {
        return category;
    }

}

