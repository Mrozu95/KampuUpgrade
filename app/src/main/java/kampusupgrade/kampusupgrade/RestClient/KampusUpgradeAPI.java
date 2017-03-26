package kampusupgrade.kampusupgrade.RestClient;

/**
 * Created by Mathijs on 21-3-2017.
 */
import kampusupgrade.kampusupgrade.Data.Building;
import kampusupgrade.kampusupgrade.Data.Room;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface KampusUpgradeAPI {

    @GET("/building")
    Call<Room> getRooms();

    @GET("/rooms/{id}")
    Call<Room> getRoom(@Path("id") String id);

    @GET("/building")
    Call<Building> getBuilding();




}
