package android.support.v4.app;

import android.app.Service;
import android.content.ComponentName;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService extends Service {
    static final HashMap<ComponentName, Object> GL = new HashMap<>();
    static final Object sLock = new Object();
    boolean GJ = false;
    final ArrayList<Object> GK;
    boolean mDestroyed = false;
    boolean mStopped = false;

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.GK = null;
        } else {
            this.GK = new ArrayList<>();
        }
    }
}