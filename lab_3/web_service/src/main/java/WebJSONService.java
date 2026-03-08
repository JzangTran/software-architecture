public class WebJSONService implements JSONService {

    @Override
    public String sendJSON(String jsonData) {
        System.out.println("Processing JSON data: " + jsonData);
        return "JSON processed";
    }

}