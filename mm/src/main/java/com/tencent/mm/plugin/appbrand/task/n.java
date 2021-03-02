package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.preload.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class n {
    private final Object lock = new Object();
    int nPc = -1;
    final String nQk;
    final Class<? extends Activity> nQl;
    public final String nQm;
    private final Class nQn;
    final Class nQo;
    final Class nQp;
    private final Class nQq;
    private final Class nQr;
    private final o nQs;
    private final Map<String, a> nQt = new LinkedHashMap();
    private final Map<String, AppBrandRemoteTaskController> nQu = new LinkedHashMap();
    g nQv = g.NIL;
    public final AtomicBoolean nQw = new AtomicBoolean(false);

    n(Class<? extends Activity> cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6) {
        AppMethodBeat.i(48475);
        this.nQk = cls.getName();
        this.nQl = cls;
        this.nQn = cls2;
        this.nQo = cls3;
        this.nQp = cls4;
        this.nQm = aH(this.nQl);
        this.nQq = cls5;
        this.nQr = cls6;
        this.nQs = new o(this, this.nQm);
        AppMethodBeat.o(48475);
    }

    /* access modifiers changed from: package-private */
    public final String bWo() {
        return this.nQm;
    }

    /* access modifiers changed from: package-private */
    public final boolean bWp() {
        boolean isEmpty;
        AppMethodBeat.i(227516);
        synchronized (this.lock) {
            try {
                isEmpty = this.nQt.isEmpty();
            } finally {
                AppMethodBeat.o(227516);
            }
        }
        return isEmpty;
    }

    /* access modifiers changed from: package-private */
    public final void z(g gVar) {
        AppMethodBeat.i(48476);
        if (!c(gVar)) {
            IllegalStateException illegalStateException = new IllegalStateException("AppBrandUITask not support this type. [" + gVar.name() + "]");
            AppMethodBeat.o(48476);
            throw illegalStateException;
        }
        this.nQv = gVar;
        AppMethodBeat.o(48476);
    }

    public final g bWq() {
        return this.nQv;
    }

    /* access modifiers changed from: protected */
    public boolean c(g gVar) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void iB(boolean z) {
        AppMethodBeat.i(227517);
        R(2, z);
        AppMethodBeat.o(227517);
    }

    /* access modifiers changed from: package-private */
    public final void R(int i2, boolean z) {
        AppMethodBeat.i(227518);
        if (this.nQn == null) {
            AppMethodBeat.o(227518);
            return;
        }
        q.bWB();
        try {
            Intent intent = new Intent(MMApplicationContext.getContext(), this.nQq);
            AppBrandPreloadProfiler appBrandPreloadProfiler = new AppBrandPreloadProfiler();
            appBrandPreloadProfiler.bVM();
            intent.putExtra("preloadProfiler", appBrandPreloadProfiler);
            if (z) {
                intent.putExtra("EXTRA_KEY_AGGRESSIVE", true);
            }
            intent.putExtra("EXTRA_KEY_LEVEL", i2);
            intent.addFlags(268435456);
            intent.putExtra("EXTRA_KEY_TRIGGER_TIME", SystemClock.elapsedRealtime());
            this.nQv.K(intent);
            iE(true);
            XIPCInvoker.a(this.nQm, intent, d.class, new e<IPCVoid>() {
                /* class com.tencent.mm.plugin.appbrand.task.n.AnonymousClass1 */

                @Override // com.tencent.mm.ipcinvoker.e
                public final void axY() {
                    AppMethodBeat.i(227514);
                    Log.w("MicroMsg.AppBrandUITask", "onBridgeNotFound: proc [%s]", n.this.nQm);
                    AppMethodBeat.o(227514);
                }

                @Override // com.tencent.mm.ipcinvoker.e
                public final void i(Exception exc) {
                    AppMethodBeat.i(227515);
                    Log.e("MicroMsg.AppBrandUITask", "onCaughtInvokeException %s, process:%s", exc, n.this.nQm);
                    AppMethodBeat.o(227515);
                }

                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Object obj) {
                    AppMethodBeat.i(48474);
                    Log.i("MicroMsg.AppBrandUITask", "preload by ipc invoke, callback received, targetProcess[%s]", n.this.nQm);
                    AppMethodBeat.o(48474);
                }
            });
            AppMethodBeat.o(227518);
        } catch (Exception e2) {
            AppMethodBeat.o(227518);
        }
    }

    /* access modifiers changed from: package-private */
    public final String bWr() {
        return this.nQk;
    }

    /* access modifiers changed from: package-private */
    public final Class<? extends Activity> bWs() {
        return this.nQl;
    }

    /* access modifiers changed from: package-private */
    public final Class bWt() {
        return this.nQo;
    }

    /* access modifiers changed from: package-private */
    public final Class bWu() {
        return this.nQp;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, int i2, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.i(48478);
        synchronized (this.lock) {
            try {
                this.nQt.put(str, new a(i2, System.currentTimeMillis(), appBrandRemoteTaskController));
                this.nQu.put(str, appBrandRemoteTaskController);
            } finally {
                AppMethodBeat.o(48478);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int bWv() {
        return this.nPc;
    }

    /* access modifiers changed from: package-private */
    public final void afk(String str) {
        AppMethodBeat.i(227519);
        synchronized (this.lock) {
            try {
                this.nQt.remove(str);
                this.nQu.remove(str);
                if (this.nQt.isEmpty()) {
                    this.nQv = g.NIL;
                }
            } finally {
                AppMethodBeat.o(227519);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Collection<String> bWw() {
        ArrayList arrayList;
        AppMethodBeat.i(227520);
        synchronized (this.lock) {
            try {
                arrayList = new ArrayList(this.nQt.keySet());
            } finally {
                AppMethodBeat.o(227520);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final Integer afo(String str) {
        a aVar;
        AppMethodBeat.i(48479);
        synchronized (this.lock) {
            try {
                aVar = this.nQt.get(str);
            } catch (Throwable th) {
                AppMethodBeat.o(48479);
                throw th;
            }
        }
        if (aVar == null) {
            AppMethodBeat.o(48479);
            return null;
        }
        Integer valueOf = Integer.valueOf(aVar.eix);
        AppMethodBeat.o(48479);
        return valueOf;
    }

    /* access modifiers changed from: package-private */
    public final long afp(String str) {
        a aVar;
        AppMethodBeat.i(227521);
        synchronized (this.lock) {
            try {
                aVar = this.nQt.get(str);
            } catch (Throwable th) {
                AppMethodBeat.o(227521);
                throw th;
            }
        }
        if (aVar != null) {
            long j2 = aVar.nQy;
            AppMethodBeat.o(227521);
            return j2;
        }
        Log.w("MicroMsg.AppBrandUITask", "getStartTByAppID: find startupT=0");
        AppMethodBeat.o(227521);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final AppBrandRemoteTaskController afq(String str) {
        AppBrandRemoteTaskController appBrandRemoteTaskController;
        AppMethodBeat.i(48480);
        synchronized (this.lock) {
            try {
                appBrandRemoteTaskController = this.nQu.get(str);
            } finally {
                AppMethodBeat.o(48480);
            }
        }
        return appBrandRemoteTaskController;
    }

    /* access modifiers changed from: package-private */
    public final Collection<AppBrandRemoteTaskController> bWx() {
        ArrayList arrayList;
        AppMethodBeat.i(227522);
        synchronized (this.lock) {
            try {
                arrayList = new ArrayList(this.nQu.values());
            } finally {
                AppMethodBeat.o(227522);
            }
        }
        return arrayList;
    }

    private static String aH(Class<?> cls) {
        String str = null;
        AppMethodBeat.i(48481);
        PackageManager packageManager = MMApplicationContext.getContext().getPackageManager();
        if (packageManager == null) {
            AppMethodBeat.o(48481);
        } else {
            try {
                str = packageManager.getActivityInfo(new ComponentName(MMApplicationContext.getContext(), cls), 128).processName;
                AppMethodBeat.o(48481);
            } catch (Exception e2) {
                AppMethodBeat.o(48481);
            }
        }
        return str;
    }

    public final Class bWy() {
        return this.nQq;
    }

    public final Class bWz() {
        return this.nQr;
    }

    public final boolean bWA() {
        AppMethodBeat.i(261637);
        boolean z = this.nQw.get();
        AppMethodBeat.o(261637);
        return z;
    }

    public String toString() {
        AppMethodBeat.i(227524);
        String str = "AppBrandUITask{mUIProcessName='" + this.nQm + '\'' + ", mUsedAs=" + this.nQv + ", isProcExisted=" + this.nQw.get() + ", isAppAttached=" + (!bWp()) + ", attach appIds=" + this.nQt.toString() + '}';
        AppMethodBeat.o(227524);
        return str;
    }

    public final void iE(boolean z) {
        AppMethodBeat.i(227525);
        synchronized (this.nQs) {
            try {
                if (!this.nQw.get()) {
                    AppBrandMainProcessService.a(this.nQs);
                    this.nQs.nQC = z;
                } else {
                    Log.d("MicroMsg.AppBrandUITask", "preload: name = [%s], had bound!", this.nQm);
                }
            } finally {
                AppMethodBeat.o(227525);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public final int eix;
        public final long nQy;
        public final AppBrandRemoteTaskController nQz;

        public a(int i2, long j2, AppBrandRemoteTaskController appBrandRemoteTaskController) {
            this.eix = i2;
            this.nQy = j2;
            this.nQz = appBrandRemoteTaskController;
        }
    }
}
