import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class jsonApplication {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();

//        write
//        Create Writer:
//        BufferedWriter: Tăng tốc độ đọc cho file
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("customer.json"));
//        Create Map collection
        Map<String, Object> customer = new HashMap<>();
        customer.put("id", 2);
        customer.put("name", "xyz");
        customer.put("email", "xyz@gmail.com");
        customer.put("age", 20);
//        Address
        Map<String, Object> address = new HashMap<>();
        address.put("stress", "Ngo Quyen");
        address.put("city", "HCM City");
        address.put("code", 3000);
        //    Add address to customer object
        customer.put("address",address);
//    Payment Method
        customer.put("paymentMethod",Arrays.asList("Payment", "Momo", "ApplePay"));
//        Add project
//        Create project1
        Map<String, Object> project1 = new HashMap<>();
        project1.put("title", "project1");
        project1.put("budget", 10000);
        //        Create project2
        Map<String, Object> project2 = new HashMap<>();
        project2.put("title", "project2");
        project2.put("budget", 10000);
//
    }
}
