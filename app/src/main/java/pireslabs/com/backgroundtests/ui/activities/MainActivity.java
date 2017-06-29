package pireslabs.com.backgroundtests.ui.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import pireslabs.com.backgroundtests.R;
import pireslabs.com.backgroundtests.tasks.CounterAsyncTask;

public class MainActivity extends AppCompatActivity {

    private static final String TIMESTAMP_FORMAT = "HH:mm:ss:S";

    private static final int TASK_DURATION = 20;

    private ProgressBar prgrssbrLoading;

    private TextView txtvwLoading;

    private TextView txtvwTaskResult;

    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initControls();
        this.log("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.log("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.log("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.log("onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.log("onDestroy");
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
        counterAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, TASK_DURATION);
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

    protected String getMyTag() {
        return String.format("[%1$s]", this.getClass().getSimpleName());
    }

    protected String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIMESTAMP_FORMAT, Locale.US);
        return simpleDateFormat.format(new Date().getTime());
    }

    protected void log(String method) {
        Log.d(getMyTag(), String.format("{%1$s} %2$s executed.", getCurrentTime(), method));
    }
}
