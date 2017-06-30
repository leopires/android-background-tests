package pireslabs.com.backgroundtests.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pireslabs.com.backgroundtests.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initControls();
    }

    private void initControls() {
        Button btnActivityTaskExecution = (Button) findViewById(R.id.btn_open_single_task_execution);
        Button btnFragmentTaskExecution = (Button) findViewById(R.id.btn_task_execution_with_fragment);

        btnActivityTaskExecution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(SingleTaskExecutionActivity.class);
            }
        });

        btnFragmentTaskExecution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(FragmentManagerActivity.class);
            }
        });
    }

    private void openActivity(Class activity) {
        Intent intent = new Intent(getApplicationContext(), activity);
        startActivity(intent);
    }
}
