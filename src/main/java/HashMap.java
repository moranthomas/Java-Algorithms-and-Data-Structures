import lombok.Data;

import java.util.Map;

@Data
public class HashMap {

    public class Product {
        String productName;
        String productDescription;

        public Product(String productName, String productDescription) {
            this.productName = productName;
            this.productDescription = productDescription;
        }
    }

    public void createNewHashMap() {

        Map<String, Product> productsByName = (Map<String, Product>) new HashMap();

        //Add products to the Map
        Product eBike = new Product("E-Bike", "A bike with a battery");
        Product roadBike = new Product("Road bike", "A bike for competition");
       /* productsByName.put(eBike.getName(), eBike);
        productsByName.put(roadBike.getName(), roadBike);*/
    }


}
