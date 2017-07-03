package pireslabs.com.backgroundtests.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import pireslabs.com.backgroundtests.ui.fragments.AbstractBasicFragment;
import pireslabs.com.backgroundtests.util.Utils;

abstract class AbstractBasicAppCompactActivity extends AppCompatActivity {

    protected boolean isPaused = false;

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
        this.isPaused = true;
        log("isPaused changed to TRUE");
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

    protected int getFragmentContainerId() {
        return 0;
    }

    protected void replaceFragment(AbstractBasicFragment replaceFragment) {

        if (this.isPaused)
            return;

        if (getFragmentContainerId() == 0)
            throw new IllegalStateException("The fragment container ID isn't specified. Please, override the getFragmentContainerId() method specifying the container ID.");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(getFragmentContainerId(), replaceFragment, replaceFragment.getMyTag());
        fragmentTransaction.commit();
    }

}
