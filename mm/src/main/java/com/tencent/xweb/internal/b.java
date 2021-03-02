package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;
import com.tencent.xweb.util.h;
import com.tencent.xweb.y;
import java.util.Date;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class b {
    public static HashMap<String, b> SDB = new HashMap<>();
    static String SDC = "";
    boolean SDA = false;
    SharedPreferences SDs;
    private String SDt;
    private String SDu;
    private String SDv;
    private long SDw;
    private long SDx;
    public long SDy;
    private String SDz;

    private b(String str, WebView.c cVar) {
        AppMethodBeat.i(156958);
        this.SDs = e(str, cVar);
        this.SDt = "INIT_START_TIME".concat(String.valueOf(str));
        this.SDu = "INIT_END_TIME".concat(String.valueOf(str));
        this.SDv = "INIT_TRY_COUNT".concat(String.valueOf(str));
        this.SDz = str;
        if (this.SDs == null) {
            AppMethodBeat.o(156958);
            return;
        }
        this.SDw = this.SDs.getLong(this.SDt, 0);
        this.SDx = this.SDs.getLong(this.SDu, 0);
        this.SDy = this.SDs.getLong(this.SDv, 0);
        AppMethodBeat.o(156958);
    }

    static {
        AppMethodBeat.i(156967);
        AppMethodBeat.o(156967);
    }

    public static synchronized b c(String str, WebView.c cVar) {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(156959);
            String d2 = d(str, cVar);
            bVar = SDB.get(d2);
            if (bVar == null) {
                bVar = new b(str, cVar);
                SDB.put(d2, bVar);
            }
            AppMethodBeat.o(156959);
        }
        return bVar;
    }

    public final synchronized void htA() {
        AppMethodBeat.i(156960);
        if (this.SDA) {
            AppMethodBeat.o(156960);
        } else {
            this.SDA = true;
            if (this.SDs == null) {
                AppMethodBeat.o(156960);
            } else {
                SharedPreferences.Editor edit = this.SDs.edit();
                edit.putLong(this.SDv, this.SDy + 1);
                long time = new Date().getTime();
                if (OO(time)) {
                    edit.commit();
                    AppMethodBeat.o(156960);
                } else {
                    edit.putLong(this.SDt, time);
                    edit.commit();
                    AppMethodBeat.o(156960);
                }
            }
        }
    }

    public final synchronized void htB() {
        AppMethodBeat.i(156961);
        if (this.SDs == null) {
            AppMethodBeat.o(156961);
        } else {
            SharedPreferences.Editor edit = this.SDs.edit();
            edit.putLong(this.SDu, new Date().getTime());
            edit.putLong(this.SDv, 0);
            edit.commit();
            this.SDs = null;
            AppMethodBeat.o(156961);
        }
    }

    public static synchronized boolean c(WebView.c cVar) {
        boolean z = false;
        synchronized (b.class) {
            AppMethodBeat.i(156962);
            if (y.hsF().SzY) {
                AppMethodBeat.o(156962);
            } else if (c("LOAD_CORE", cVar).htC()) {
                h.a(cVar, h.b.a.SEM);
                AppMethodBeat.o(156962);
                z = true;
            } else if (new b("CREATE_WEBVIEW", cVar).htC()) {
                h.a(cVar, h.b.a.SEN);
                AppMethodBeat.o(156962);
                z = true;
            } else {
                AppMethodBeat.o(156962);
            }
        }
        return z;
    }

    private synchronized boolean OO(long j2) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(156963);
            if (0 == this.SDw) {
                AppMethodBeat.o(156963);
            } else if (this.SDx - this.SDw >= 0 || Math.abs(j2 - this.SDw) > 10800000) {
                AppMethodBeat.o(156963);
            } else if (this.SDx < this.SDw) {
                z = true;
                AppMethodBeat.o(156963);
            } else {
                AppMethodBeat.o(156963);
            }
        }
        return z;
    }

    private synchronized boolean htC() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(156964);
            if (this.SDs == null) {
                AppMethodBeat.o(156964);
            } else {
                long time = new Date().getTime();
                if (!OO(time)) {
                    AppMethodBeat.o(156964);
                } else if (this.SDy > 4) {
                    XWalkEnvironment.addXWalkInitializeLog("Scene " + this.SDz + " crashed " + ((time - this.SDw) / Util.MILLSECONDS_OF_MINUTE) + " minutes ago, try count = " + this.SDy);
                    z = true;
                    AppMethodBeat.o(156964);
                } else {
                    AppMethodBeat.o(156964);
                }
            }
        }
        return z;
    }

    private static String d(String str, WebView.c cVar) {
        AppMethodBeat.i(156965);
        String str2 = "INIT_SP_TAG_" + cVar.toString() + str;
        AppMethodBeat.o(156965);
        return str2;
    }

    private static synchronized SharedPreferences e(String str, WebView.c cVar) {
        SharedPreferences mMKVSharedTransportOld;
        synchronized (b.class) {
            AppMethodBeat.i(156966);
            if (cVar == WebView.c.WV_KIND_CW || cVar == WebView.c.WV_KIND_SYS) {
                String d2 = d(str, cVar);
                SDC = d2;
                mMKVSharedTransportOld = XWalkEnvironment.getMMKVSharedTransportOld(d2);
                AppMethodBeat.o(156966);
            } else {
                mMKVSharedTransportOld = null;
                AppMethodBeat.o(156966);
            }
        }
        return mMKVSharedTransportOld;
    }
}
