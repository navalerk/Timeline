package timeline.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(this, TimelineActivity.class);
//        intent.putExtra(TimelineActivity.ORIENTATION, LinearLayoutManager.VERTICAL);
//        startActivity(intent);
    }
}
