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




}
