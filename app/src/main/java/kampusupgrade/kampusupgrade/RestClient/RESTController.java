package kampusupgrade.kampusupgrade.RestClient;

import android.util.Log;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

import kampusupgrade.kampusupgrade.Data.Building;
import kampusupgrade.kampusupgrade.Data.Room;
import kampusupgrade.kampusupgrade.Data.User;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


/**
 * Created by Mathijs on 21-3-2017.
 */

public class RESTController extends Thread {
    Retrofit retrofit;
public RESTController(){

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.addInterceptor(logging);

    Serializer serializer = new Persister();
         retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.137.1:8080/kampusupgrade/services/")
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .client(httpClient.build() )
                .build();
    }








    public ArrayList<RESTBuilding> getBuilding() {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTBuildingList buildingList = null;

        Call<RESTBuildingList> call = kampusUpgradeAPI.getBuilding();
        try {


             buildingList  = call.execute().body();

        } catch (IOException e) {
           Log.d("kanker",e.toString());
        }

        return buildingList.getList();


       /*
            @Override
            public void  onResponse(Call<RESTBuildingList> call, Response<RESTBuildingList> response) {
                int statusCode = response.code();

                RESTBuildingList buildingList = response.body();


            }

            @Override
            public void onFailure(Call<RESTBuildingList> call, Throwable t) {
                // Log error here since request failed



            }

        }); */


    }







}
