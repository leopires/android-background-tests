package pireslabs.com.backgroundtests.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Utils {

    public static String getClassTag(Object object) {
        return String.format("[%1$s]", object.getClass().getSimpleName());
    }

    private static String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.TIMESTAMP_FORMAT, Locale.US);
        return simpleDateFormat.format(new Date().getTime());
    }

    public static void log(String tag, String message) {
        Log.d(tag, String.format("(%1$s) %2$s ", getCurrentTime(), message));
    }

    public static class Constants {

        public static final String TIMESTAMP_FORMAT = "HH:mm:ss:S";

        public static final int TASK_DURATION_IN_SECONDS = 25;

    }
}
