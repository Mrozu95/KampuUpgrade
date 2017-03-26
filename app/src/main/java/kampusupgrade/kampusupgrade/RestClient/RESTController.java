package kampusupgrade.kampusupgrade.RestClient;

import kampusupgrade.kampusupgrade.Data.Building;
import kampusupgrade.kampusupgrade.Data.Room;
import kampusupgrade.kampusupgrade.Data.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


/**
 * Created by Mathijs on 21-3-2017.
 */

public class RESTController {
    Retrofit retrofit;
public RESTController(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    public void getAllrooms(){
        KampusUpgradeAPI kampusUpgradeAPI=  retrofit.create(KampusUpgradeAPI.class);

        Call<Room> call = kampusUpgradeAPI.getRooms();
        call.enqueue(new Callback<Room>() {

            @Override
            public void onResponse(Call<Room> call, Response<Room> response) {
                int statusCode = response.code();
                Room room = response.body();
            }

            @Override
            public void onFailure(Call<Room> call, Throwable t) {
                // Log error here since request failed





            }
        });




    }

    public void getBuilding(){
        KampusUpgradeAPI kampusUpgradeAPI=  retrofit.create(KampusUpgradeAPI.class);

        Call<Building> call = kampusUpgradeAPI.getBuilding();
        call.enqueue(new Callback<Building>() {

            @Override
            public void onResponse(Call<Building> call, Response<Building> response) {
                int statusCode = response.code();
                Building building = response.body();
            }

            @Override
            public void onFailure(Call<Building> call, Throwable t) {
                // Log error here since request failed





            }
        });




    }





}
