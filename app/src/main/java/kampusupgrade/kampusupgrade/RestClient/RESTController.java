package kampusupgrade.kampusupgrade.RestClient;

import android.util.Log;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.util.ArrayList;

import kampusupgrade.kampusupgrade.Data.Building;
import kampusupgrade.kampusupgrade.Data.Room;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


/**
 * Created by Mathijs on 21-3-2017.
 */

public class RESTController extends Thread {
    Retrofit retrofit;
    final  String BASE_URL = "http://192.168.137.1:8080/kampusupgrade/services/";
public RESTController(){

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.addInterceptor(logging);

    Serializer serializer = new Persister();
         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .client(httpClient.build() )
                .build();
    }








    public ArrayList<Building> getBuilding() {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTBuildingList buildingList = null;

        Call<RESTBuildingList> call = kampusUpgradeAPI.getBuilding();
        try {


             buildingList  = call.execute().body();

        } catch (IOException e) {
           Log.d("IO",e.toString());
        }

        return buildingList.getList();

    }

    public ArrayList<Building> getBuilding(int id) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTBuildingList buildingList = null;

        Call<RESTBuildingList> call = kampusUpgradeAPI.getBuilding(id);
        try {


            buildingList  = call.execute().body();

        } catch (IOException e) {
            Log.d("IO",e.toString());
        }

        return buildingList.getList();

    }
    public ArrayList<Building> getBuilding(String city) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTBuildingList buildingList = null;

        Call<RESTBuildingList> call = kampusUpgradeAPI.getBuilding(city);
        try {


            buildingList  = call.execute().body();

        } catch (IOException e) {
            Log.d("IO",e.toString());
        }

        return buildingList.getList();

    }
    public ArrayList<Building> getBuildingByStreet(String street) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTBuildingList buildingList = null;

        Call<RESTBuildingList> call = kampusUpgradeAPI.getBuildingByStreet(street);
        try {


            buildingList  = call.execute().body();

        } catch (IOException e) {
            Log.d("IO",e.toString());
        }

        return buildingList.getList();


    }

    public ArrayList<Building> getBuildingByName(String name) {

        KampusUpgradeAPI kampusUpgradeAPI = retrofit.create(KampusUpgradeAPI.class);
        RESTBuildingList buildingList = null;

        Call<RESTBuildingList> call = kampusUpgradeAPI.getBuildingByName(name);
        try {
            buildingList  = call.execute().body();
        } catch (IOException e) {
            Log.d("IO",e.toString());
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
            roomList  = call.execute().body();
        } catch (IOException e) {
            Log.d("IO",e.toString());
        }

        return roomList.getList();

    }




}
