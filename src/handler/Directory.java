package handler;

import org.apache.ws.axis2.xsd.Item;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"items"}, name = "directory")
@XmlRootElement
public class Directory {
    private List<Item> items= new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
