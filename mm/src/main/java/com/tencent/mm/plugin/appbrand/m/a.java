package com.tencent.mm.plugin.appbrand.m;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.m.e;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.p;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a extends d implements i, k, m, p, t, u, v {
    private final IJSRuntime dqn;
    public final m mNC;
    private final e mND;
    private ArrayList<m.a> mNE;
    private final Object mNF;
    private ArrayList<p.a> mNG;
    private final boolean mNH;

    /* access modifiers changed from: protected */
    public abstract com.tencent.mm.appbrand.v8.m a(IJSRuntime iJSRuntime, int i2);

    /* access modifiers changed from: protected */
    public abstract IJSRuntime g(IJSRuntime.Config config);

    @Override // com.tencent.mm.plugin.appbrand.m.q, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ boolean LO() {
        return super.LO();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.q, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ String LP() {
        return super.LP();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.k, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ ByteBuffer N(int i2, boolean z) {
        return super.N(i2, z);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.v, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ long XK() {
        return super.XK();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.k, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void a(y yVar) {
        super.a(yVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.q, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void a(Runnable runnable, boolean z) {
        super.a(runnable, z);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.l, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void a(String str, String str2, ValueCallback valueCallback) {
        super.a(str, str2, valueCallback);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void a(URL url, String str, ValueCallback valueCallback) {
        super.a(url, str, valueCallback);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void a(URL url, String str, String str2, int i2, String str3, ValueCallback valueCallback) {
        super.a(url, str, str2, i2, str3, valueCallback);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.v, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void a(URL url, String str, String str2, int i2, String str3, m.b bVar) {
        super.a(url, str, str2, i2, str3, bVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.v, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void a(ArrayList arrayList, URL url, String str, String str2, m.b bVar) {
        super.a(arrayList, url, str, str2, bVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.l, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void abQ(String str) {
        super.abQ(str);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.plugin.appbrand.m.d
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.g, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void b(g gVar, String str) {
        super.b(gVar, str);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.k, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ y bMF() {
        return super.bMF();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.k, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void bufferStoreBindTo(long j2, long j3) {
        super.bufferStoreBindTo(j2, j3);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.q, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void cS(boolean z) {
        super.cS(z);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.q, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ boolean doInnerLoopTask() {
        return super.doInnerLoopTask();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.o, com.tencent.mm.plugin.appbrand.m.d
    public /* bridge */ /* synthetic */ void evaluateJavascript(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.v, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ long getIsolatePtr() {
        return super.getIsolatePtr();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.k, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ int getNativeBufferId() {
        return super.getNativeBufferId();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.v, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ long getUVLoopPtr() {
        return super.getUVLoopPtr();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.u, com.tencent.mm.plugin.appbrand.m.d
    public /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.q, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void post(Runnable runnable) {
        super.post(runnable);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.k, com.tencent.mm.plugin.appbrand.m.d
    public /* bridge */ /* synthetic */ void releaseDirectByteBuffer(ByteBuffer byteBuffer) {
        super.releaseDirectByteBuffer(byteBuffer);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.u, com.tencent.mm.plugin.appbrand.m.d
    public /* bridge */ /* synthetic */ void resume() {
        super.resume();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.q, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void resumeLoopTasks() {
        super.resumeLoopTasks();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.k, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void setNativeBuffer(int i2, ByteBuffer byteBuffer) {
        super.setNativeBuffer(i2, byteBuffer);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.q, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void setThreadPriority(int i2) {
        super.setThreadPriority(i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.k, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ boolean supportBufferStoreBindTo() {
        return super.supportBufferStoreBindTo();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.s, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ void xZ(int i2) {
        super.xZ(i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.s, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ ByteBuffer ya(int i2) {
        return super.ya(i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.s, com.tencent.mm.plugin.appbrand.m.d
    public final /* bridge */ /* synthetic */ int yb(int i2) {
        return super.yb(i2);
    }

    public a() {
        this((IJSRuntime.Config) null);
    }

    public a(byte b2) {
        this(new IJSRuntime.Config(null, null));
    }

    public a(IJSRuntime.Config config) {
        this.mNE = new ArrayList<>();
        this.mNF = new byte[0];
        this.mNG = new ArrayList<>();
        this.dqn = g(config);
        this.mNH = config != null && config.dpm;
        this.mNC = a(this.dqn, e.bMG());
        this.dqn.r(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.m.a.AnonymousClass1 */

            public final void run() {
                ArrayList arrayList;
                AppMethodBeat.i(144154);
                synchronized (a.this.mNF) {
                    try {
                        arrayList = new ArrayList(a.this.mNG);
                        a.this.mNG.clear();
                        a.this.mNG = null;
                    } finally {
                        AppMethodBeat.o(144154);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((p.a) it.next()).onInitialized();
                }
            }
        });
        this.mND = new e(new e.a() {
            /* class com.tencent.mm.plugin.appbrand.m.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.m.e.a
            public final com.tencent.mm.appbrand.v8.m yc(int i2) {
                AppMethodBeat.i(144155);
                com.tencent.mm.appbrand.v8.m iP = a.this.dqn.iP(i2);
                AppMethodBeat.o(144155);
                return iP;
            }
        });
        e eVar = this.mND;
        Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", 1);
        eVar.mNS.put(1, this);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.plugin.appbrand.m.d
    public final <T extends j> T R(Class<T> cls) {
        if (cls != n.class || this.mNH) {
            return (T) super.R(cls);
        }
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.d
    public final IJSRuntime bMz() {
        return this.dqn;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.d
    public final com.tencent.mm.appbrand.v8.m bMA() {
        return this.mNC;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.g
    public final boolean bMB() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.g
    public final int bMC() {
        return e.bMG();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.t
    public final g xX(int i2) {
        return this.mND.xX(i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.t
    public final g bMD() {
        return this.mND.xX(1);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.t
    public final g bME() {
        return this.mND.bME();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.t
    public final void xY(int i2) {
        d dVar;
        e eVar = this.mND;
        Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", Integer.valueOf(i2));
        synchronized (eVar.mNS) {
            dVar = eVar.mNS.get(i2);
            eVar.mNS.delete(i2);
        }
        if (dVar != null) {
            dVar.destroy();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.m.m
    public final synchronized void a(m.a aVar) {
        this.mNE.add(aVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.p
    public final void a(p.a aVar) {
        synchronized (this.mNF) {
            if (this.mNG != null) {
                this.mNG.add(aVar);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.plugin.appbrand.m.g, com.tencent.mm.plugin.appbrand.m.d
    public void destroy() {
        this.mNC.dpQ.t(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.m.a.AnonymousClass3 */

            public final void run() {
                ArrayList arrayList;
                AppMethodBeat.i(144156);
                synchronized (a.this) {
                    try {
                        arrayList = new ArrayList(a.this.mNE);
                        a.this.mNE.clear();
                    } finally {
                        AppMethodBeat.o(144156);
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    m.a aVar = (m.a) arrayList.get(i2);
                    if (aVar != null) {
                        aVar.onDestroy();
                    }
                }
                if (BuildInfo.IS_FLAVOR_RED) {
                    synchronized (a.this) {
                        try {
                            if (a.this.mNE.size() != 0) {
                                IllegalStateException illegalStateException = new IllegalStateException("OnDestroyListener execute failed. Add Destroy listener recursively is forbidden.");
                                AppMethodBeat.o(144156);
                                throw illegalStateException;
                            }
                        } finally {
                            AppMethodBeat.o(144156);
                        }
                    }
                    return;
                }
                AppMethodBeat.o(144156);
            }
        });
        e eVar = this.mND;
        synchronized (eVar.mNS) {
            for (int i2 = 0; i2 < eVar.mNS.size(); i2++) {
                int keyAt = eVar.mNS.keyAt(i2);
                if (keyAt != 1) {
                    Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", Integer.valueOf(keyAt));
                    if (eVar.mNS.get(keyAt) == null) {
                        Log.w("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", Integer.valueOf(keyAt));
                    } else {
                        eVar.mNS.get(keyAt).destroy();
                    }
                }
            }
            eVar.mNS.clear();
        }
        super.destroy();
        this.dqn.quit();
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public void setJsExceptionHandler(h hVar) {
        this.mNC.a(e.bMG(), hVar);
    }
}
