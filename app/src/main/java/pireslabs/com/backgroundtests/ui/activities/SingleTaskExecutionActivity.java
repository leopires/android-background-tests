package pireslabs.com.backgroundtests.ui.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import pireslabs.com.backgroundtests.R;
import pireslabs.com.backgroundtests.tasks.CounterAsyncTask;
import pireslabs.com.backgroundtests.util.Utils;

public class SingleTaskExecutionActivity extends AbstractBasicAppCompactActivity {

    private ProgressBar prgrssbrLoading;

    private TextView txtvwLoading;

    private TextView txtvwTaskResult;

    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task_execution);
        this.initControls();
    }

    private void initControls() {
        this.prgrssbrLoading = (ProgressBar) findViewById(R.id.prgrssbr_loading);
        this.txtvwLoading = (TextView) findViewById(R.id.txtvw_loading);
        this.txtvwTaskResult = (TextView) findViewById(R.id.txtvw_resultado);
        this.btnStart = (Button) findViewById(R.id.btn_start);
        this.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTask();
            }
        });
    }

    private void startTask() {

        this.showLoading();

        CounterAsyncTask counterAsyncTask = new CounterAsyncTask(new CounterAsyncTask.CounterCallback() {
            @Override
            public void onTrue() {
                showResult("Done!!!!");
            }

            @Override
            public void onFalse() {
                showResult("Incomplete!!!");
            }
        });
        counterAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Utils.Constants.TASK_DURATION_IN_SECONDS);
    }

    private void showLoading() {
        this.txtvwTaskResult.setVisibility(View.GONE);
        this.prgrssbrLoading.setVisibility(View.VISIBLE);
        this.txtvwLoading.setVisibility(View.VISIBLE);
    }

    private void showResult(String result) {
        this.txtvwTaskResult.setText(result);
        this.txtvwTaskResult.setVisibility(View.VISIBLE);
        this.prgrssbrLoading.setVisibility(View.GONE);
        this.txtvwLoading.setVisibility(View.GONE);
    }
}
