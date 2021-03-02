package io.flutter.app;

import android.app.Activity;
import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.view.FlutterMain;

public class FlutterApplication extends Application {
    private Activity mCurrentActivity = null;

    public void onCreate() {
        AppMethodBeat.i(9604);
        super.onCreate();
        FlutterMain.startInitialization(this);
        AppMethodBeat.o(9604);
    }

    public Activity getCurrentActivity() {
        return this.mCurrentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        this.mCurrentActivity = activity;
    }
}
