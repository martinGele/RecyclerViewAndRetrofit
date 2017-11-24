package martin.recycler.InternetCalls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gele on 21.11.2017.
 */

public class RetroClient {

    /********
     * URLS
     *******/
    private static final String ROOT_URL = "http://pratikbutani.x10.mx";


    /**
     * now we need to get the retrofit instance
     */

    private static Retrofit getRetrofitInstance() {

        return new Retrofit.Builder().baseUrl(ROOT_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);

    }
}
