public class XMLJSONAdapter implements XMLService, JSONService {

    private WebJSONService jsonService;
    private LegacyXMLSystem xmlSystem;

    public XMLJSONAdapter(WebJSONService jsonService, LegacyXMLSystem xmlSystem) {
        this.jsonService = jsonService;
        this.xmlSystem = xmlSystem;
    }

    @Override
    public String sendXML(String xmlData) {
        String json = convertXMLtoJSON(xmlData);
        return jsonService.sendJSON(json);
    }

    @Override
    public String sendJSON(String jsonData) {
        String xml = convertJSONtoXML(jsonData);
        return xmlSystem.sendXML(xml);
    }

    private String convertXMLtoJSON(String xml) {
        return "{converted-from-xml:" + xml + "}";
    }

    private String convertJSONtoXML(String json) {
        return "<converted-from-json>" + json + "</converted-from-json>";
    }

}