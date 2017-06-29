package pireslabs.com.backgroundtests.tasks;

import android.os.AsyncTask;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CounterAsyncTask extends AsyncTask<Integer, Void, Boolean> {

    private static final String TIMESTAMP_FORMAT = "HH:mm:ss:S";

    private CounterCallback counterCallback;

    public CounterAsyncTask(CounterCallback counterCallback) {
        this.counterCallback = counterCallback;
    }

    @Override
    protected void onPreExecute() {
        log("Starting Counter Task...");
    }

    @Override
    protected void onPostExecute(Boolean taskResult) {
        if (taskResult) {
            this.counterCallback.onTrue();
            log("Counter Task result: TRUE");
        } else {
            this.counterCallback.onFalse();
            log("Counter Task result: FALSE");
        }
        log("Counter Task execution completed!");
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {
        int finalCount = integers[0];
        int count = 1;
        while (count <= finalCount) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log(e.getMessage());
                return false;
            }
            log("Current count value: " + count);
            count++;
        }
        return true;
    }

    private String getMyTag() {
        return String.format("[%1$s]", this.getClass().getSimpleName());
    }

    private String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIMESTAMP_FORMAT, Locale.US);
        return simpleDateFormat.format(new Date().getTime());
    }

    private void log(String message) {
        Log.d(getMyTag(), String.format("{%1$s} %2$s", getCurrentTime(), message));
    }

    public interface CounterCallback {
        void onTrue();

        void onFalse();
    }
}
