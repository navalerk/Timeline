package timeline.timeline.HRService;

import retrofit2.Call;
import retrofit2.http.POST;
import timeline.timeline.HRService.HRDAO.HRDAO;

/**
 * Created by Administrator on 27/4/2560.
 */

public interface HRService {
    @POST("/TSP57/PCK/index.php/hr/Dataservices/Timeline/SendServie")
    Call<HRDAO> getHRData();
}
