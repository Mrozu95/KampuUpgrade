package kampusupgrade.kampusupgrade.RestClient;

import android.util.Log;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.util.ArrayList;

import kampusupgrade.kampusupgrade.Data.Building;
import kampusupgrade.kampusupgrade.Data.Room;
import kampusupgrade.kampusupgrade.Data.Screen;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


/**
 * Created by Mathijs on 21-3-2017.
 */

    /*
    Call these methods to get data from the Database
    Be sure to call these methods in a new thread(not in the UI thread )
    To connect to the RESTServer succesfully change the BASE_IP
    */
public class RESTController extends Thread {
    Retrofit retrofit;
    final String BASE_IP = "http://192.168.137.1:8080/";
    final String BASE_IP_Michal = "http://192.168.2.42:8080/";
    final String FINAL_DESTENATION_MICHAL = "KampusUpgradeRESTServer/services/";
    final String FINAL_DESTENATION = "KampusUpgradeRESTServer/services/";
    final String BASE_URL_MICHAL, BASE_URL_MATHIJS;


    public RESTController() {
        BASE_URL_MATHIJS = BASE_IP + FINAL_DESTENATION;
        BASE_URL_MICHAL = BASE_IP_Michal + FINAL_DESTENATION_MICHAL;

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Serializer serializer = new Persister();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_MICHAL)
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .client(httpClient.build())
                .build();
    }

    public ArrayList<Building> getBuilding() {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTBuildingList buildingList = null;

        Call<RESTBuildingList> call = kampusUpgradeAPI.getBuilding();
        try {


            buildingList = call.execute().body();

        } catch (IOException e) {
            Log.d("IO", e.toString());
        }

        return buildingList.getList();

    }

    public ArrayList<Building> getBuilding(int id) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTBuildingList buildingList = null;

        Call<RESTBuildingList> call = kampusUpgradeAPI.getBuilding(id);
        try {


            buildingList = call.execute().body();

        } catch (IOException e) {
            Log.d("IO", e.toString());
        }

        return buildingList.getList();

    }

    public ArrayList<Building> getBuilding(String city) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTBuildingList buildingList = null;

        Call<RESTBuildingList> call = kampusUpgradeAPI.getBuilding(city);
        try {


            buildingList = call.execute().body();

        } catch (IOException e) {
            Log.d("IO", e.toString());
        }

        return buildingList.getList();

    }

    public ArrayList<Building> getBuildingByStreet(String street) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTBuildingList buildingList = null;

        Call<RESTBuildingList> call = kampusUpgradeAPI.getBuildingByStreet(street);
        try {


            buildingList = call.execute().body();

        } catch (IOException e) {
            Log.d("IO", e.toString());
        }

        return buildingList.getList();


    }

    public ArrayList<Building> getBuildingByName(String name) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTBuildingList buildingList = null;

        Call<RESTBuildingList> call = kampusUpgradeAPI.getBuildingByName(name);
        try {
            buildingList = call.execute().body();
        } catch (IOException e) {
            Log.d("IO", e.toString());
        }

        return buildingList.getList();

    }
    public ArrayList<Room> getRoom() {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTRoomList roomList = null;

        Call<RESTRoomList> call = kampusUpgradeAPI.getRoom();
        try {
            roomList  = call.execute().body();
        } catch (IOException e) {
            Log.d("IO",e.toString());
        }

        return roomList.getList();

    }

    public ArrayList<Room> getRoomByID(int id) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTRoomList roomList = null;

        Call<RESTRoomList> call = kampusUpgradeAPI.getRoomByID(id);
        try {
            roomList  = call.execute().body();
        } catch (IOException e) {
            Log.d("IO",e.toString());
        }

        return roomList.getList();

    }
    public ArrayList<Room> getRoomByNo(int no) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTRoomList roomList = null;

        Call<RESTRoomList> call = kampusUpgradeAPI.getRoomByNo(no);
        try {
            roomList  = call.execute().body();
        } catch (IOException e) {
            Log.d("IO",e.toString());
        }

        return roomList.getList();

    }



    public ArrayList<Room> getRoomByBuilding(int id) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTRoomList roomList = null;

        Call<RESTRoomList> call = kampusUpgradeAPI.getRoomByBuilding(id);
        try {
            roomList = call.execute().body();
        } catch (IOException e) {
            Log.d("IO", e.toString());
        }

        return roomList.getList();

    }

    public ArrayList<Screen> getScreen() {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTScreenList screenList = null;

        Call<RESTScreenList> call = kampusUpgradeAPI.getScreen();
        try {
            screenList = call.execute().body();
        } catch (IOException e) {
            Log.d("IO", e.toString());
        }

        return screenList.getList();

    }

    public ArrayList<Screen> getScreenByID(int id) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTScreenList screenList = null;

        Call<RESTScreenList> call = kampusUpgradeAPI.getScreenByID(id);
        try {
            screenList = call.execute().body();
        } catch (IOException e) {
            Log.d("IO", e.toString());
        }

        return screenList.getList();

    }

    public ArrayList<Screen> getScreenByBuilding(int id) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTScreenList screenList = null;

        Call<RESTScreenList> call = kampusUpgradeAPI.getScreenByBuilding(id);
        try {
            screenList = call.execute().body();
        } catch (IOException e) {
            Log.d("IO", e.toString());
        }

        return screenList.getList();

    }


}
