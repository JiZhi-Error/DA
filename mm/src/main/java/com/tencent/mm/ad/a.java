package com.tencent.mm.ad;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.WeakHashMap;

public final class a implements Application.ActivityLifecycleCallbacks {
    private static final WeakHashMap<Activity, Integer> hvw = new WeakHashMap<>();

    static {
        AppMethodBeat.i(125087);
        AppMethodBeat.o(125087);
    }

    public static String aBz() {
        String sb;
        AppMethodBeat.i(125080);
        synchronized (hvw) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(hvw.size());
                ArrayList<Activity> arrayList = new ArrayList();
                try {
                    arrayList.addAll(hvw.keySet());
                } catch (ConcurrentModificationException e2) {
                    Log.w("MicroMsg.ActivityRefDump", "ConcurrentModificationException occur.");
                    sb2.append("concurrent modification exception");
                }
                for (Activity activity : arrayList) {
                    if (activity != null) {
                        sb2.append("|");
                        sb2.append(activity.getClass().getSimpleName());
                        sb2.append(":");
                        sb2.append(hvw.get(activity));
                    }
                }
                sb = sb2.toString();
            } finally {
                AppMethodBeat.o(125080);
            }
        }
        return sb;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.i(125081);
        synchronized (hvw) {
            try {
                hvw.put(activity, 0);
            } finally {
                AppMethodBeat.o(125081);
            }
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(125082);
        synchronized (hvw) {
            try {
                hvw.put(activity, 5);
            } finally {
                AppMethodBeat.o(125082);
            }
        }
    }

    public final void onActivityStarted(Activity activity) {
        AppMethodBeat.i(125083);
        synchronized (hvw) {
            try {
                hvw.put(activity, 1);
            } finally {
                AppMethodBeat.o(125083);
            }
        }
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.i(125084);
        synchronized (hvw) {
            try {
                hvw.put(activity, 2);
            } finally {
                AppMethodBeat.o(125084);
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        AppMethodBeat.i(125085);
        synchronized (hvw) {
            try {
                hvw.put(activity, 3);
            } finally {
                AppMethodBeat.o(125085);
            }
        }
    }

    public final void onActivityStopped(Activity activity) {
        AppMethodBeat.i(125086);
        synchronized (hvw) {
            try {
                hvw.put(activity, 4);
            } finally {
                AppMethodBeat.o(125086);
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
