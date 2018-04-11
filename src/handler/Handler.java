package handler;

import org.apache.ws.axis2.xsd.Author;
import org.apache.ws.axis2.xsd.Chapter;
import org.apache.ws.axis2.xsd.Item;
import xml.XMLParser;

import java.util.ArrayList;
import java.util.List;

public class Handler {
    //private final static XMLParser parser = new XMLParser();
    private List<Item> items = new ArrayList<>();

    public Handler(){
        //items = parser.read();
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

    }

    public void addItem(Item Item){
        //items = parser.read();
        if (items.indexOf(Item)==-1)
            items.add(Item);
        //parser.write(items);
    }

    public void updateItem(Item Item){
        //items = parser.read();
        for(Item i: items)
            if(i.getName().equals(Item.getName()))
                items.set(items.indexOf(i), Item);
                //parser.write(items);
    }

    public void deleteItem(String name){
        //items = parser.read();
        for(Item i: items)
            if(i.getName().equals(name))
                items.remove(i);
                //parser.write(items);
    }

    public List<Item> getItems(){
        //return parser.read();
        return items;
    }
}
