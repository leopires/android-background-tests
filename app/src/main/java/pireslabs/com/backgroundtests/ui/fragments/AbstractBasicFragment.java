package pireslabs.com.backgroundtests.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pireslabs.com.backgroundtests.util.Utils;


abstract class AbstractBasicFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        logMethod("onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logMethod("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        logMethod("onCreateView");
        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        logMethod("onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        logMethod("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        logMethod("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        logMethod("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        logMethod("onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        logMethod("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        logMethod("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        logMethod("onDetach");
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
