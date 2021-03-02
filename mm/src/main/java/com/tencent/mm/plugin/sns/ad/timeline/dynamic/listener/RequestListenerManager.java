package com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;

public class RequestListenerManager implements LifecycleObserver {
    private static final Map<Integer, RequestListenerManager> DxT = new ArrayMap();
    public b DxU = new b();

    static {
        AppMethodBeat.i(202151);
        AppMethodBeat.o(202151);
    }

    public static RequestListenerManager aF(Activity activity) {
        AppMethodBeat.i(202144);
        if (activity instanceof LifecycleOwner) {
            RequestListenerManager requestListenerManager = DxT.get(Integer.valueOf(activity.hashCode()));
            if (requestListenerManager == null && (requestListenerManager = aG(activity)) != null) {
                Log.i("RequestListenerManager", "new one RequestListenerManager instance!!!");
                DxT.put(Integer.valueOf(activity.hashCode()), requestListenerManager);
            }
            AppMethodBeat.o(202144);
            return requestListenerManager;
        }
        AppMethodBeat.o(202144);
        return null;
    }

    private static RequestListenerManager aG(Activity activity) {
        AppMethodBeat.i(202145);
        try {
            if (activity instanceof LifecycleOwner) {
                RequestListenerManager e2 = e((LifecycleOwner) activity);
                AppMethodBeat.o(202145);
                return e2;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202145);
        return null;
    }

    private static RequestListenerManager e(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(202146);
        if (lifecycleOwner == null) {
            try {
                Log.w("RequestListenerManager", "the input life cycle owner is null!");
                AppMethodBeat.o(202146);
                return null;
            } catch (Throwable th) {
                Log.e("RequestListenerManager", "new one instance of RequestListenerManager failed!");
                AppMethodBeat.o(202146);
                return null;
            }
        } else {
            RequestListenerManager requestListenerManager = new RequestListenerManager();
            if (!requestListenerManager.f(lifecycleOwner)) {
                AppMethodBeat.o(202146);
                return null;
            }
            AppMethodBeat.o(202146);
            return requestListenerManager;
        }
    }

    private RequestListenerManager() {
        AppMethodBeat.i(202147);
        AppMethodBeat.o(202147);
    }

    private boolean f(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(202148);
        if (lifecycleOwner != null) {
            try {
                lifecycleOwner.getLifecycle().addObserver(this);
                AppMethodBeat.o(202148);
                return true;
            } catch (Throwable th) {
                Log.e("RequestListenerManager", "RequestListenerManager attachToOwner failed!");
            }
        } else {
            Log.w("RequestListenerManager", "the life cycle owner is null!");
            AppMethodBeat.o(202148);
            return false;
        }
    }

    public final void a(String str, a aVar) {
        String str2;
        AppMethodBeat.i(202149);
        b bVar = this.DxU;
        if (bVar != null) {
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(202149);
                return;
            }
            WeakReference<a> weakReference = bVar.iIE.get(str);
            if (weakReference == null || weakReference.get() != aVar) {
                Iterator<Map.Entry<String, WeakReference<a>>> it = bVar.iIE.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str2 = null;
                        break;
                    }
                    Map.Entry<String, WeakReference<a>> next = it.next();
                    if (next != null && next.getValue() == aVar) {
                        str2 = next.getKey();
                        break;
                    }
                }
                if (!TextUtils.isEmpty(str2) && !str2.equals(str)) {
                    bVar.iIE.remove(str2);
                }
                bVar.iIE.put(str, new WeakReference<>(aVar));
            }
        }
        AppMethodBeat.o(202149);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void doDestroy(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(202150);
        try {
            b bVar = this.DxU;
            if (bVar != null) {
                bVar.iIE.clear();
            }
            AppMethodBeat.o(202150);
        } catch (Throwable th) {
            AppMethodBeat.o(202150);
        }
    }
}
