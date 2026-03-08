public class LegacyXMLSystem implements XMLService {

    @Override
    public String sendXML(String xmlData) {
        System.out.println("Processing XML data: " + xmlData);
        return "XML processed";
    }

}