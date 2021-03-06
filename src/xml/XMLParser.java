package xml;

import org.apache.ws.axis2.xsd.Chapter;
import org.apache.ws.axis2.xsd.Item;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    private final String currentDirectory;

    public XMLParser(){
        currentDirectory = "D:\\work\\java\\AIPOS\\resources\\db.xml";
    }

    public List<Item> read(){
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = saxParserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            FileHandler fileHandler = new FileHandler();
            reader.setContentHandler(fileHandler);
            reader.parse(currentDirectory);
            return fileHandler.getItems();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return  new ArrayList<Item>();
        }
    }

    public void write(List<Item> items){
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = null;
        try {
            writer = factory.createXMLStreamWriter(new FileOutputStream(currentDirectory));
            writer.writeStartDocument();
            writer.writeStartElement(FileHandler.DIRECTORY);
            for(Item item : items){
                writer.writeStartElement(FileHandler.ITEM);
                writer.writeStartElement(FileHandler.ITEM_NAME);
                writer.writeCharacters(item.getName());
                writer.writeEndElement();
                writer.writeStartElement(FileHandler.YEAR_OF_PUBLICATION);
                writer.writeCharacters(String.valueOf(item.getYearOfPublication()));
                writer.writeEndElement();
                writer.writeStartElement(FileHandler.AUTHOR);
                writer.writeStartElement(FileHandler.FIRST_NAME);
                writer.writeCharacters(item.getAuthor().getFirstName());
                writer.writeEndElement();
                writer.writeStartElement(FileHandler.SECOND_NAME);
                writer.writeCharacters(item.getAuthor().getSecondName());
                writer.writeEndElement();
                writer.writeEndElement();
                writer.writeStartElement(FileHandler.CHAPTERS);
                for(Chapter chapter : item.getChapters()){
                    writer.writeStartElement(FileHandler.CHAPTER);
                    writer.writeStartElement(FileHandler.CHAPTER_NAME);
                    writer.writeCharacters(chapter.getName());
                    writer.writeEndElement();
                    writer.writeStartElement(FileHandler.TEXT);
                    writer.writeCharacters(chapter.getText());
                    writer.writeEndElement();
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
