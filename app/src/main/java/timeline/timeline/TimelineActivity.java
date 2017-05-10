package timeline.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timeline.timeline.HRService.HRDAO.HRDAO;
import timeline.timeline.HRService.HRService;

public class TimelineActivity extends AppCompatActivity {

    private HRService service_timeline;
    public static final String ORIENTATION = "orientation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);


        final int orientation = getIntent().getIntExtra(ORIENTATION, LinearLayoutManager.VERTICAL);
        final RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this, orientation, false));

        final List<ListItem> items = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service_timeline = retrofit.create(HRService.class);

        service_timeline.getHRData().enqueue(new Callback<HRDAO>() {
            @Override
            public void onResponse(Call<HRDAO> call, Response<HRDAO> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < response.body().position_history.size(); i++) {
                        ListItem item = new ListItem();
                        item.set_posh_start_end(response.body().position_history.get(i).posh_end_date + " | " + response.body().position_history.get(i).posh_start_date);
                        if (response.body().position_history.get(i).posh_amp_name != "") {
                            item.set_posh_place_name(response.body().position_history.get(i).posh_amp_name);
                        } else {
                            item.set_posh_place_name(response.body().position_history.get(i).posh_alp_name);
                        }
                        items.add(item);
                    }

                    TimelineAdapter adapter = new TimelineAdapter(orientation, items);
                    recycler.setAdapter(adapter);

                } else {
                    Log.d("RESPONSE", "service fail" + response.message());
                }
            }

            @Override
            public void onFailure(Call<HRDAO> call, Throwable t) {
                Log.d("RESPONSE", t.getMessage());
            }
        });
    }
}
