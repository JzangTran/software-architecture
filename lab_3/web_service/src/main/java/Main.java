public class Main {

    public static void main(String[] args) {

        WebJSONService jsonService = new WebJSONService();
        LegacyXMLSystem xmlSystem = new LegacyXMLSystem();

        XMLJSONAdapter adapter = new XMLJSONAdapter(jsonService, xmlSystem);

        adapter.sendXML("<user>John</user>");

        adapter.sendJSON("{name:John}");
    }

}