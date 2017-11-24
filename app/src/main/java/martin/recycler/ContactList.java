package martin.recycler;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Gele on 21.11.2017.
 */

public class ContactList {

    @SerializedName("contacts")
    @Expose
    private ArrayList<Contact> contacts = new ArrayList<>();


    /**
     * @return contacts when you type the method contacts
     */
    public ArrayList<Contact> getContacts() {

        return contacts;

    }


    /**
     * @param contacts
     */

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
