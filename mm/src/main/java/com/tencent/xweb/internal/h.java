package com.tencent.xweb.internal;

import android.content.SharedPreferences;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import java.util.ArrayList;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;

public final class h {
    static h SDL = null;
    int SDE = 0;
    int SDF = 0;
    long SDG = 0;
    ArrayList<Long> SDH = new ArrayList<>();
    WebView.c SDI;
    long SDJ = 0;
    boolean SDK = false;

    public static synchronized h htF() {
        h hVar;
        synchronized (h.class) {
            AppMethodBeat.i(156969);
            if (SDL == null) {
                WebView.c curWebType = WebView.getCurWebType();
                WebView.getCurStrModule();
                SDL = new h(curWebType);
            }
            hVar = SDL;
            AppMethodBeat.o(156969);
        }
        return hVar;
    }

    public static synchronized void d(WebView.c cVar) {
        synchronized (h.class) {
            AppMethodBeat.i(156970);
            SDL = new h(cVar);
            AppMethodBeat.o(156970);
        }
    }

    private h(WebView.c cVar) {
        boolean z = false;
        AppMethodBeat.i(156971);
        this.SDI = cVar;
        if (this.SDI == WebView.c.WV_KIND_SYS || (!"tools".equals(WebView.getCurStrModule()) && !"toolsmp".equals(WebView.getCurStrModule()))) {
            this.SDK = false;
        } else {
            String nS = a.nS("enable_err_watchdog", "tools");
            if (nS != null && nS.trim().toLowerCase().equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                z = true;
            }
            this.SDK = z;
            this.SDJ = e(this.SDI).getLong("SP_KEY_NEED_SWITCH_TIME", 0);
            if (Math.abs(System.currentTimeMillis() - this.SDJ) < 43200000) {
                this.SDE = 3;
                AppMethodBeat.o(156971);
                return;
            }
        }
        AppMethodBeat.o(156971);
    }

    public final synchronized void htA() {
        AppMethodBeat.i(156972);
        this.SDG = System.currentTimeMillis();
        AppMethodBeat.o(156972);
    }

    public final synchronized void htG() {
        AppMethodBeat.i(156973);
        if (!this.SDK) {
            AppMethodBeat.o(156973);
        } else {
            if (NetworkUtil.isNetworkAvailable()) {
                this.SDH.add(Long.valueOf(System.currentTimeMillis()));
            }
            if (this.SDH.size() >= 3) {
                if (Math.abs(System.currentTimeMillis() - this.SDH.get(this.SDH.size() - 3).longValue()) < 120000) {
                    this.SDE = 1;
                    if (this.SDI == WebView.c.WV_KIND_CW) {
                        com.tencent.xweb.util.h.OQ(220);
                        AppMethodBeat.o(156973);
                    } else if (this.SDI == WebView.c.WV_KIND_X5) {
                        com.tencent.xweb.util.h.OQ(226);
                    }
                }
            }
            AppMethodBeat.o(156973);
        }
    }

    private synchronized int htH() {
        return this.SDE;
    }

    public final synchronized boolean htI() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(156974);
            if (htH() == 3 || htH() == 2) {
                if (this.SDI == WebView.c.WV_KIND_CW) {
                    com.tencent.xweb.util.h.OQ(222);
                } else if (this.SDI == WebView.c.WV_KIND_X5) {
                    com.tencent.xweb.util.h.OQ(228);
                }
            }
            if (htH() == 1 || htH() == 3 || htH() == 2) {
                AppMethodBeat.o(156974);
            } else {
                z = false;
                AppMethodBeat.o(156974);
            }
        }
        return z;
    }

    public final synchronized boolean htJ() {
        boolean z;
        AppMethodBeat.i(156975);
        if (htH() == 2) {
            z = true;
            AppMethodBeat.o(156975);
        } else {
            z = false;
            AppMethodBeat.o(156975);
        }
        return z;
    }

    public final synchronized boolean htK() {
        boolean z;
        AppMethodBeat.i(156976);
        if (htH() == 3) {
            z = true;
            AppMethodBeat.o(156976);
        } else {
            z = false;
            AppMethodBeat.o(156976);
        }
        return z;
    }

    public final synchronized void htB() {
        AppMethodBeat.i(156977);
        if (!this.SDK) {
            AppMethodBeat.o(156977);
        } else {
            this.SDG = 0;
            this.SDH.clear();
            this.SDJ = 0;
            this.SDE = 0;
            AppMethodBeat.o(156977);
        }
    }

    public final synchronized void htL() {
        AppMethodBeat.i(156978);
        if (!this.SDK) {
            AppMethodBeat.o(156978);
        } else if (1 != this.SDE) {
            AppMethodBeat.o(156978);
        } else {
            if (this.SDH.size() > 0) {
                if (Math.abs(System.currentTimeMillis() - this.SDH.get(this.SDH.size() - 1).longValue()) < Util.MILLSECONDS_OF_MINUTE) {
                    if (this.SDI == WebView.c.WV_KIND_CW) {
                        com.tencent.xweb.util.h.OQ(221);
                    } else if (this.SDI == WebView.c.WV_KIND_X5) {
                        com.tencent.xweb.util.h.OQ(227);
                    }
                    this.SDG = 0;
                    this.SDH.clear();
                    this.SDE = 2;
                    this.SDJ = System.currentTimeMillis();
                    e(this.SDI).edit().putLong("SP_KEY_NEED_SWITCH_TIME", this.SDJ).commit();
                    AppMethodBeat.o(156978);
                }
            }
            this.SDE = 0;
            AppMethodBeat.o(156978);
        }
    }

    public final synchronized void htM() {
        AppMethodBeat.i(156979);
        if (!this.SDK) {
            AppMethodBeat.o(156979);
        } else if (1 != this.SDE) {
            AppMethodBeat.o(156979);
        } else {
            this.SDG = 0;
            this.SDH.clear();
            this.SDE = 0;
            AppMethodBeat.o(156979);
        }
    }

    private static synchronized SharedPreferences e(WebView.c cVar) {
        SharedPreferences processSafePreferences;
        synchronized (h.class) {
            AppMethodBeat.i(156980);
            processSafePreferences = XWalkEnvironment.getProcessSafePreferences(XWalkEnvironment.getProcessName() + "_LOAD_URL_" + cVar, 4);
            AppMethodBeat.o(156980);
        }
        return processSafePreferences;
    }
}
