package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static volatile e llX;
    public Map<String, WeakReference<View>> mViewMap = new ConcurrentHashMap();

    private e() {
        AppMethodBeat.i(121159);
        AppMethodBeat.o(121159);
    }

    public static e bBI() {
        AppMethodBeat.i(121160);
        if (llX == null) {
            synchronized (e.class) {
                try {
                    if (llX == null) {
                        llX = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121160);
                    throw th;
                }
            }
        }
        e eVar = llX;
        AppMethodBeat.o(121160);
        return eVar;
    }

    public final boolean c(String str, View view) {
        AppMethodBeat.i(121161);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
            AppMethodBeat.o(121161);
            return false;
        } else if (view == null) {
            Log.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
            AppMethodBeat.o(121161);
            return false;
        } else {
            WeakReference<View> put = this.mViewMap.put(str, new WeakReference<>(view));
            if (!(put == null || put.get() == null)) {
                Log.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", str);
            }
            AppMethodBeat.o(121161);
            return true;
        }
    }

    public final View Yj(String str) {
        AppMethodBeat.i(121162);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
            AppMethodBeat.o(121162);
            return null;
        }
        WeakReference<View> weakReference = this.mViewMap.get(str);
        if (weakReference != null) {
            View view = weakReference.get();
            AppMethodBeat.o(121162);
            return view;
        }
        AppMethodBeat.o(121162);
        return null;
    }
}
