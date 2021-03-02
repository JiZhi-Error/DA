package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal;

public final class d {
    private static d SyO;
    static CookieInternal.ICookieSyncManagerInternal SyP;

    public static synchronized d lA(Context context) {
        d dVar;
        synchronized (d.class) {
            AppMethodBeat.i(156723);
            if (SyO == null) {
                SyO = new d(context.getApplicationContext());
            }
            dVar = SyO;
            AppMethodBeat.o(156723);
        }
        return dVar;
    }

    public static synchronized d hsr() {
        d dVar;
        synchronized (d.class) {
            AppMethodBeat.i(156724);
            if (SyO == null) {
                IllegalStateException illegalStateException = new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
                AppMethodBeat.o(156724);
                throw illegalStateException;
            }
            dVar = SyO;
            AppMethodBeat.o(156724);
        }
        return dVar;
    }

    private d(Context context) {
        AppMethodBeat.i(156725);
        if (SyP != null) {
            SyP.init(context);
        }
        AppMethodBeat.o(156725);
    }

    public static void sync() {
        AppMethodBeat.i(156726);
        if (SyP != null) {
            SyP.sync();
        }
        AppMethodBeat.o(156726);
    }
}
