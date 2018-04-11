/**
 * IServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package server;

import handler.Handler;
import org.apache.ws.axis2.xsd.Item;
import soap.GetItemsResponse;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 *  IServiceSkeleton java skeleton for the axisService
 */
public class IServiceSkeleton {
    private final static Handler handler = new Handler();
    /**
     * Auto generated method signature
     *
     * @param getItems
     * @return getItemsResponse
     */
    public soap.GetItemsResponse getItems(soap.GetItems getItems) throws JAXBException {
        //TODO : fill this with the necessary business logic
        GetItemsResponse response = new GetItemsResponse();
        List<Item> items = handler.getItems();
        response.set_return(items.toArray(new Item[items.size()]));
        return response;
    }

    /**
     * Auto generated method signature
     *
     * @param addItem
     * @return
     */
    public void addItem(soap.AddItem addItem) {
        //TODO : fill this with the necessary business logic
        handler.addItem(addItem.getArgs0());
    }

    /**
     * Auto generated method signature
     *
     * @param deleteItem
     * @return
     */
    public void deleteItem(soap.DeleteItem deleteItem) {
        //TODO : fill this with the necessary business logic
        handler.deleteItem(deleteItem.getArgs0());
    }

    /**
     * Auto generated method signature
     *
     * @param updateItem
     * @return
     */
    public void updateItem(soap.UpdateItem updateItem) {
        //TODO : fill this with the necessary business logic
        handler.updateItem(updateItem.getArgs0());
    }
}
