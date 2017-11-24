package martin.recycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import martin.recycler.InternetCalls.ApiService;
import martin.recycler.InternetCalls.RetroClient;
import martin.recycler.adapters.MyContactAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /**
     * Views
     */
    private ListView listView;
    private View parentView;

    private ArrayList<Contact> contactList;
    private MyContactAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Array List for Binding Data from JSON to this List
         */
        contactList = new ArrayList<>();

        parentView = findViewById(R.id.parentLayout);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.listView);


        /**
         * Just to know onClick and Printing Hello Toast in Center.
         */

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<ContactList> call = api.getMyJson();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                //Dismiss Dialog

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    contactList = response.body().getContacts();

                    /**
                     * Binding that List to Adapter
                     */
                    adapter = new MyContactAdapter(MainActivity.this, contactList);
                    listView.setAdapter(adapter);

                } else {
                    // Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ContactList> call, Throwable t) {
                //dialog.dismiss();
            }
        });

    }
}