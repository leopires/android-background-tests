package pireslabs.com.backgroundtests.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pireslabs.com.backgroundtests.util.Utils;

abstract class AbstractBasicAppCompactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logMethod("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logMethod("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logMethod("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logMethod("onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logMethod("onDestroy");
    }

    protected String getMyTag() {
        return Utils.getClassTag(this);
    }

    protected void log(String message) {
        Utils.log(getMyTag(), message);
    }

    protected void logMethod(String method) {
        log(method + " executed.");
    }

}
