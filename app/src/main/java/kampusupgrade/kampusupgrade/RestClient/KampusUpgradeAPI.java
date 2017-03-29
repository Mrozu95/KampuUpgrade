package kampusupgrade.kampusupgrade.RestClient;

/**
 * Created by Mathijs on 21-3-2017.
 */
import kampusupgrade.kampusupgrade.Data.Building;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface KampusUpgradeAPI {


    @GET("building")
    Call<RESTBuildingList> getBuilding();

    @GET("building/id/{id}")
    Call<RESTBuildingList> getBuilding(@Path("id") int id);

    @GET("building/city/{city}")
    Call<RESTBuildingList> getBuilding(@Path("city") String city);

    @GET("building/street/{street}")
    Call<RESTBuildingList> getBuildingByStreet(@Path("street") String city);

    @GET("building/name/{name}")
    Call<RESTBuildingList> getBuildingByName(@Path("name") String name);

    @GET("room")
    Call<RESTRoomList> getRoom();

    @GET("room/id/{id}")
    Call<RESTRoomList> getRoomByID(@Path("id") int id);

    @GET("room/no/{no}")
    Call<RESTRoomList> getRoomByNo(@Path("no") int no);

    @GET("room/building/{id}")
    Call<RESTRoomList> getRoomByBuilding(@Path("id") int id);












}
