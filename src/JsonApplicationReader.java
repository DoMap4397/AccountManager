import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonApplicationReader {
    public static void main(String[] args) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("customer.json"));
//        Identify json Object or Array structure create JsonObject
        JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();
//        read detail aka parser json file
        System.out.println(parser.get("id").getAsLong());
        System.out.println(parser.get("name").getAsString());
        System.out.println(parser.get("email").getAsString());
        System.out.println(parser.get("age").getAsLong());
//        read address
        JsonObject address = parser.get("address").getAsJsonObject();
        System.out.println(address.get("street").getAsString());
        System.out.println(address.get("city").getAsString());
        System.out.println(address.get("code").getAsLong());
// read payment method
        for (JsonElement pm : parser.get("paymentMethod").getAsJsonArray()) {
            System.out.println(pm.getAsString());
        }
        for (JsonElement project : parser.get("project").getAsJsonArray()) {
            JsonObject object = project.getAsJsonObject();
            System.out.println(object.get("title").getAsString());
            System.out.println(object.get("budget").getAsLong());
        }
    }
}
