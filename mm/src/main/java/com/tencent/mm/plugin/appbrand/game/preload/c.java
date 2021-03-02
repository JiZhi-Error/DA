package com.tencent.mm.plugin.appbrand.game.preload;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import junit.framework.Assert;

public final class c implements k {
    private AppBrandRuntime kEc;
    public final LinkedHashSet<m> ltP = new LinkedHashSet<>();

    public c(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(45278);
        this.kEc = appBrandRuntime;
        AppMethodBeat.o(45278);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void co(String str, String str2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void a(bc bcVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void a(bc bcVar, o oVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void b(String str, String str2, int[] iArr) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void a(bc bcVar, int[] iArr) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void i(int i2, String str) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final int getComponentId() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final String getAppId() {
        return this.kEc.mAppId;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Context getContext() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final boolean isRunning() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final i Oo() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final i getJsRuntime() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final b getAppState() {
        AppMethodBeat.i(45279);
        if (this.kEc == null) {
            b bVar = b.DESTROYED;
            AppMethodBeat.o(45279);
            return bVar;
        }
        b bwY = this.kEc.kAH.kQM.bwY();
        AppMethodBeat.o(45279);
        return bwY;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Map<String, p> Op() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object, com.tencent.mm.plugin.appbrand.jsapi.m] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final <T extends m> T av(Class<T> cls) {
        boolean z;
        AppMethodBeat.i(45280);
        T t = null;
        Iterator<m> it = this.ltP.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            m next = it.next();
            if (cls.isInstance(next)) {
                t = next;
                break;
            }
        }
        if (t == null) {
            try {
                t = cls.newInstance();
            } catch (Exception e2) {
                Log.e("MicroMsg.WAGamePreloadComponent", "Make sure %s has default constructor", cls.getName());
            }
        }
        if (t != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        AppMethodBeat.o(45280);
        return t;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final <T extends n> T aw(Class<T> cls) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final boolean a(n nVar) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Handler getAsyncHandler() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final q getFileSystem() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final com.tencent.mm.plugin.appbrand.widget.dialog.m getDialogContainer() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void P(Runnable runnable) {
        AppMethodBeat.i(45281);
        if (runnable == null) {
            AppMethodBeat.o(45281);
            return;
        }
        MMHandlerThread.postToMainThread(runnable);
        AppMethodBeat.o(45281);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void i(Runnable runnable, long j2) {
        AppMethodBeat.i(226632);
        if (runnable == null) {
            AppMethodBeat.o(226632);
            return;
        }
        if (j2 < 0) {
            j2 = 0;
        }
        MMHandlerThread.postToMainThreadDelayed(runnable, j2);
        AppMethodBeat.o(226632);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final <T extends com.tencent.luggage.a.b> T M(Class<T> cls) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k
    public final AppBrandRuntime getRuntime() {
        return this.kEc;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k
    public final ICommLibReader bqZ() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final boolean bsV() {
        return false;
    }
}
