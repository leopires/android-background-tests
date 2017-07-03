package pireslabs.com.backgroundtests.ui.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pireslabs.com.backgroundtests.R;
import pireslabs.com.backgroundtests.tasks.CounterAsyncTask;
import pireslabs.com.backgroundtests.ui.fragments.DoneFragment;
import pireslabs.com.backgroundtests.ui.fragments.LoadingFragment;
import pireslabs.com.backgroundtests.ui.fragments.OpsFragment;
import pireslabs.com.backgroundtests.util.Utils;

public class FragmentManagerActivity extends AbstractBasicAppCompactActivity {

    private Button btnTaskStarter;

    @Override
    protected int getFragmentContainerId() {
        return R.id.container_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_manager);
        this.initControls();
    }

    private void initControls() {
        this.btnTaskStarter = (Button) findViewById(R.id.btn_start_task);
        this.btnTaskStarter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disableStartButton();
                replaceFragment(new LoadingFragment());
                startCounterTask();
            }
        });
    }

    private void startCounterTask() {

        CounterAsyncTask counterTask = new CounterAsyncTask(new CounterAsyncTask.CounterCallback() {
            @Override
            public void onTrue() {
                enableStartButton();
                replaceFragment(new DoneFragment());
            }

            @Override
            public void onFalse() {
                enableStartButton();
                replaceFragment(new OpsFragment());
            }
        });

        counterTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Utils.Constants.TASK_DURATION_IN_SECONDS);

    }

    private void disableStartButton() {
        this.btnTaskStarter.setEnabled(false);
        this.btnTaskStarter.setAlpha(0.5f);
    }

    private void enableStartButton() {
        this.btnTaskStarter.setEnabled(true);
        this.btnTaskStarter.setAlpha(1f);
    }
}
