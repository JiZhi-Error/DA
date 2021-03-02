package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Queue;

public final class h implements Application.ActivityLifecycleCallbacks {
    public Application app;
    public final Queue<a> ogJ = new LinkedList();
    private int ogK = 0;
    public boolean ogL = false;

    public interface a {
        void bZq();

        void er(Context context);
    }

    public h() {
        AppMethodBeat.i(137911);
        AppMethodBeat.o(137911);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.i(137912);
        this.ogK++;
        if (this.ogK == 1) {
            Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
            for (a aVar : this.ogJ) {
                aVar.er(activity);
            }
        }
        AppMethodBeat.o(137912);
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(137913);
        this.ogK--;
        if (this.ogK == 0) {
            Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
            for (a aVar : this.ogJ) {
                aVar.bZq();
            }
            if (this.ogL && this.app != null) {
                Application application = this.app;
                Log.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
                application.unregisterActivityLifecycleCallbacks(this);
                this.ogJ.clear();
                this.app = null;
                this.ogL = false;
                this.ogL = false;
                this.app = null;
            }
        }
        AppMethodBeat.o(137913);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
