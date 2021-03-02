package com.tencent.mm.plugin.sns.device.appstore;

import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d {
    private static d DFf = null;
    private ApkInstalledWatcher DFb = new a(this, (byte) 0);
    private boolean DFc = false;
    private final Map<String, e> DFd = new HashMap();
    private final b DFe = new b(this, (byte) 0);

    static /* synthetic */ e a(d dVar, String str) {
        AppMethodBeat.i(202657);
        e aOC = dVar.aOC(str);
        AppMethodBeat.o(202657);
        return aOC;
    }

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(202658);
        dVar.eZG();
        AppMethodBeat.o(202658);
    }

    static /* synthetic */ boolean b(d dVar) {
        AppMethodBeat.i(202659);
        boolean eZH = dVar.eZH();
        AppMethodBeat.o(202659);
        return eZH;
    }

    static /* synthetic */ void c(d dVar) {
        AppMethodBeat.i(202660);
        dVar.eZF();
        AppMethodBeat.o(202660);
    }

    public static synchronized void a(e eVar) {
        synchronized (d.class) {
            AppMethodBeat.i(202648);
            try {
                eZD().b(eVar);
                AppMethodBeat.o(202648);
            } catch (Throwable th) {
                Log.e("ApkInstalledWatcherManager", "watchStatic: watch info failed!");
                AppMethodBeat.o(202648);
            }
        }
    }

    private static synchronized d eZD() {
        d dVar;
        synchronized (d.class) {
            AppMethodBeat.i(202649);
            if (DFf == null) {
                DFf = new d();
            }
            dVar = DFf;
            AppMethodBeat.o(202649);
        }
        return dVar;
    }

    private d() {
        AppMethodBeat.i(202650);
        AppMethodBeat.o(202650);
    }

    private synchronized void b(e eVar) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(202651);
            Log.i("ApkInstalledWatcherManager", "watch is called");
            if (eVar != null) {
                if (TextUtils.isEmpty(eVar.DFh) || TextUtils.isEmpty(eVar.DFi)) {
                    Log.i("ApkInstalledWatcherManager", "checkWatchInfo is called, the input param is invalid");
                } else {
                    z = true;
                }
            }
            if (!z) {
                AppMethodBeat.o(202651);
            } else {
                eZE();
                synchronized (this.DFd) {
                    try {
                        this.DFd.put(eVar.DFh, eVar);
                    } catch (Throwable th) {
                        AppMethodBeat.o(202651);
                        throw th;
                    }
                }
                eZG();
                b bVar = this.DFe;
                if (!bVar.mStarted) {
                    bVar.mStarted = true;
                    MMHandlerThread.postToMainThreadDelayed(bVar, 300000);
                    Log.i("ApkInstalledWatcherManager", "startTimer is called, the timer is to start.");
                    AppMethodBeat.o(202651);
                } else {
                    Log.i("ApkInstalledWatcherManager", "startTimer is called, the timer is started!");
                    AppMethodBeat.o(202651);
                }
            }
        }
    }

    private synchronized void eZE() {
        AppMethodBeat.i(202652);
        try {
            if (this.DFb == null) {
                this.DFb = new a(this, (byte) 0);
            }
            if (!this.DFc) {
                Log.i("ApkInstalledWatcherManager", "registerWatcher: the watcher is to be registered");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                MMApplicationContext.getContext().registerReceiver(this.DFb, intentFilter);
                this.DFc = true;
            }
            AppMethodBeat.o(202652);
        } catch (Throwable th) {
            Log.e("ApkInstalledWatcherManager", "register ApkInstalledWatcher failed");
            AppMethodBeat.o(202652);
        }
    }

    private synchronized void eZF() {
        AppMethodBeat.i(202653);
        try {
            if (this.DFb != null && this.DFc) {
                MMApplicationContext.getContext().unregisterReceiver(this.DFb);
                this.DFc = false;
            }
            AppMethodBeat.o(202653);
        } catch (Throwable th) {
            Log.e("ApkInstalledWatcherManager", "unregister ApkInstalledWatcher failed");
            AppMethodBeat.o(202653);
        }
    }

    private e aOC(String str) {
        e remove;
        AppMethodBeat.i(202654);
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.DFd) {
                try {
                    remove = this.DFd.remove(str);
                } finally {
                    AppMethodBeat.o(202654);
                }
            }
            return remove;
        }
        AppMethodBeat.o(202654);
        return null;
    }

    private void eZG() {
        AppMethodBeat.i(202655);
        synchronized (this.DFd) {
            try {
                Iterator<Map.Entry<String, e>> it = this.DFd.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<String, e> next = it.next();
                    if (next.getValue() != null) {
                        if (next.getValue().DFk + 300000 < SystemClock.elapsedRealtime()) {
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                }
            } finally {
                AppMethodBeat.o(202655);
            }
        }
    }

    private boolean eZH() {
        boolean z;
        AppMethodBeat.i(202656);
        synchronized (this.DFd) {
            try {
                z = !this.DFd.isEmpty();
            } finally {
                AppMethodBeat.o(202656);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public class a extends ApkInstalledWatcher {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.sns.device.appstore.ApkInstalledWatcher
        public final boolean aOB(String str) {
            AppMethodBeat.i(202646);
            e a2 = d.a(d.this, str);
            if (a2 != null) {
                ArrayMap arrayMap = new ArrayMap();
                if (a2.DFj) {
                    arrayMap.put("outSns", 1);
                }
                a.a(a2.DFi, a2.uxInfo, a2.adExtInfo, 3, AppEventsConstants.EVENT_PARAM_VALUE_NO, arrayMap);
                AppMethodBeat.o(202646);
                return true;
            }
            Log.i("ApkInstalledWatcherManager", "onAppInstalled is called, but the pkg is not existed!");
            AppMethodBeat.o(202646);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        volatile boolean mStarted;

        private b() {
            this.mStarted = false;
        }

        /* synthetic */ b(d dVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(202647);
            try {
                d.a(d.this);
                if (d.b(d.this)) {
                    MMHandlerThread.postToMainThreadDelayed(this, 300000);
                    Log.i("ApkInstalledWatcherManager", "there are some watcher info, the timer is going on");
                    AppMethodBeat.o(202647);
                    return;
                }
                d.c(d.this);
                this.mStarted = false;
                Log.i("ApkInstalledWatcherManager", "the timer is end!");
                AppMethodBeat.o(202647);
            } catch (Throwable th) {
                Log.e("ApkInstalledWatcherManager", "there is something wrong in timer run function");
                AppMethodBeat.o(202647);
            }
        }
    }
}
