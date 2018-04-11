package handler;

import org.apache.ws.axis2.xsd.Author;
import org.apache.ws.axis2.xsd.Chapter;
import org.apache.ws.axis2.xsd.Item;
import xml.XMLParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    private List<Item> items = new ArrayList<>();

    public Handler(){
        //items = parser.read();
        /*
        Item item = new Item();
        item.setName("Pascal beginer");
        item.setYearOfPublication(2010);
        Author author = new Author();
        author.setFirstName("Egor");
        author.setSecondName("Lobach");
        item.setAuthor(author);
        Chapter chapter = new Chapter();
        chapter.setName("Introduction");
        chapter.setText("Pascal is a general-purpose programming language.");
        item.addChapters(chapter);
        chapter = new Chapter();
        chapter.setName("Part 1");
        chapter.setText("The text of the program consists of three parts. This is the title, descriptions, operators.");
        item.addChapters(chapter);
        items.add(item);

        item = new Item();
        item.setName("Pascal for all");
        item.setYearOfPublication(2014);
        author = new Author();
        author.setFirstName("Sasha");
        author.setSecondName("Lobach");
        item.setAuthor(author);
        chapter = new Chapter();
        chapter.setName("Introduction");
        chapter.setText("Pascal is one of the most well-known programming languages used for teaching programming in high school, it is the basis for several other languages.");
        item.addChapters(chapter);
        items.add(item);
        */

    }

    public void addItem(Item Item) throws JAXBException {
        items = unmarshal();
        if (items.indexOf(Item)==-1)
            items.add(Item);
        marshal(items);
    }

    public void updateItem(Item Item) throws JAXBException {
        items = unmarshal();
        for(Item i: items)
            if(i.getName().equals(Item.getName())) {
                items.set(items.indexOf(i), Item);
                marshal(items);
            }
    }

    public void deleteItem(String name) throws JAXBException {
        items = unmarshal();
        for(Item i: items)
            if(i.getName().equals(name)) {
                items.remove(i);
                marshal(items);
            }
    }

    public List<Item> getItems() throws JAXBException {
        //return parser.read();
        return unmarshal();
        //return directory.getItems();
    }

    private List<Item> unmarshal() throws JAXBException {
        File file = new File("D:\\work\\java\\AIPOS\\resources\\temp2.xml");
        JAXBContext context = JAXBContext.newInstance(Directory.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Directory directory = (Directory) unmarshaller.unmarshal(file);
        List<Item> itemList = directory.getItems();
        List<Item> items1 = new ArrayList<>();
        for (Item item:itemList){
            Item item1 = new Item();
            item1.setYearOfPublication(item.getYearOfPublication());
            item1.setName(item.getName());
            Author author = new Author();
            author.setFirstName(item.getAuthor().getFirstName());
            author.setSecondName(item.getAuthor().getSecondName());
            item1.setAuthor(author);
            for (Chapter chapter:item.getChapters()){
                Chapter chapter1 = new Chapter();
                chapter1.setName(chapter.getName());
                chapter1.setText(chapter.getText());
                item1.addChapters(chapter1);
            }
            items1.add(item1);
        }
        return items1;
    }
    private void marshal(List<Item> items) throws JAXBException {
        Directory directory = new Directory();
        directory.setItems(items);
        File file = new File("D:\\work\\java\\AIPOS\\resources\\temp2.xml");
        JAXBContext context = JAXBContext.newInstance(Directory.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(directory, file);
    }
}
