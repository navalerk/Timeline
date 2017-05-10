package timeline.timeline.HRService.HRDAO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 27/4/2560.
 */

public class Position_history {
    @SerializedName("posh_id")
    public String posh_id;

    @SerializedName("posh_ps_id")
    public String posh_ps_id;

    @SerializedName("posh_alp_name")
    public String posh_alp_name;

    @SerializedName("posh_amp_name")
    public String posh_amp_name;

    @SerializedName("posh_place_name")
    public String posh_place_name;

    @SerializedName("posh_start_date")
    public String posh_start_date;

    @SerializedName("posh_end_date")
    public String posh_end_date;

}
