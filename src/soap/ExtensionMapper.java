/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:50 GMT)
 */
package soap;


/**
 *  ExtensionMapper class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ExtensionMapper {
    public static java.lang.Object getTypeObject(
        java.lang.String namespaceURI, java.lang.String typeName,
        javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
        if ("http://ws.apache.org/axis2/xsd".equals(namespaceURI) &&
                "Item".equals(typeName)) {
            return org.apache.ws.axis2.xsd.Item.Factory.parse(reader);
        }

        if ("http://ws.apache.org/axis2/xsd".equals(namespaceURI) &&
                "Chapter".equals(typeName)) {
            return org.apache.ws.axis2.xsd.Chapter.Factory.parse(reader);
        }

        if ("http://ws.apache.org/axis2/xsd".equals(namespaceURI) &&
                "Author".equals(typeName)) {
            return org.apache.ws.axis2.xsd.Author.Factory.parse(reader);
        }

        throw new org.apache.axis2.databinding.ADBException("Unsupported type " +
            namespaceURI + " " + typeName);
    }
}
