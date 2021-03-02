package com.tencent.mm.plugin.appbrand.ag;

import android.util.SparseArray;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public class c extends v {
    private com.tencent.mm.plugin.appbrand.u.b.a nMl = null;
    final SparseArray<com.tencent.luggage.sdk.b.a.c.a> oFn = new SparseArray<>(1);

    c(w wVar) {
        super(wVar);
        AppMethodBeat.i(230024);
        AppMethodBeat.o(230024);
    }

    static class a extends v.a {
        String appId;
        String oFu;
        boolean oFv;

        a(v.a aVar, String str, String str2, boolean z) {
            super(aVar.filePath, aVar.script);
            this.oFu = str;
            this.appId = str2;
            this.oFv = z;
        }

        a(String str, String str2, String str3, boolean z) {
            super(str, str2);
            this.oFu = null;
            this.appId = str3;
            this.oFv = z;
        }
    }

    @Override // com.tencent.mm.appbrand.v8.v
    public final void a(m mVar, final v.a aVar) {
        AppMethodBeat.i(147756);
        if (aVar instanceof a) {
            String str = ((a) aVar).oFu;
            if (!Util.isNullOrNil(str)) {
                Log.i("MicroMsg.V8EngineWorkerManagerLU", "hy: %s has sourcemap", aVar.filePath);
                mVar.a(str, (m.b) null);
            }
        }
        Log.i("MicroMsg.V8EngineWorkerManagerLU", "hy: evaluating %s", aVar.filePath);
        final long currentTimeMillis = System.currentTimeMillis();
        mVar.a(aVar.filePath, aVar.script, new m.b() {
            /* class com.tencent.mm.plugin.appbrand.ag.c.AnonymousClass1 */

            @Override // com.tencent.mm.appbrand.v8.m.b
            public final void a(String str, m.c cVar) {
                AppMethodBeat.i(147755);
                System.currentTimeMillis();
                c.this.a(aVar);
                AppMethodBeat.o(147755);
            }
        });
        AppMethodBeat.o(147756);
    }

    /* access modifiers changed from: protected */
    public void a(v.a aVar) {
    }

    @Override // com.tencent.mm.appbrand.v8.v
    public final void a(ArrayList<v.a> arrayList, i iVar, g gVar) {
        AppMethodBeat.i(230025);
        if (!(gVar instanceof s)) {
            Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: component is not service. do nothing");
            AppMethodBeat.o(230025);
            return;
        }
        this.nMl = new com.tencent.mm.plugin.appbrand.u.b.a();
        this.nMl.a((s) gVar, iVar);
        arrayList.add(0, new v.a(((s) gVar).Ou() + "node.js", this.nMl.bPX()));
        AppMethodBeat.o(230025);
    }

    @Override // com.tencent.mm.appbrand.v8.v
    public final void terminate(final int i2) {
        AppMethodBeat.i(230026);
        Log.i("MicroMsg.V8EngineWorkerManagerLU", "hy: trigger terminate %d", Integer.valueOf(i2));
        m iT = iT(i2);
        if (iT == null) {
            Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: worker not in map!");
            AppMethodBeat.o(230026);
            return;
        }
        iT.dpQ.r(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ag.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(230017);
                com.tencent.luggage.sdk.b.a.c.a aVar = c.this.oFn.get(i2);
                if (aVar == null) {
                    Log.w("MicroMsg.V8EngineWorkerManagerLU", "hy: not prepared binding!");
                    AppMethodBeat.o(230017);
                    return;
                }
                aVar.cAF.destroy();
                aVar.cAE.notifyDestroy();
                c.this.oFn.remove(i2);
                AppMethodBeat.o(230017);
            }
        });
        super.terminate(i2);
        AppMethodBeat.o(230026);
    }

    @Override // com.tencent.mm.appbrand.v8.v
    public final void a(final int i2, final g gVar) {
        AppMethodBeat.i(230027);
        Log.i("MicroMsg.V8EngineWorkerManagerLU", "hy: trigger bind to %d", Integer.valueOf(i2));
        final m iT = iT(i2);
        if (iT == null || gVar == null) {
            Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: worker not in map!");
            AppMethodBeat.o(230027);
            return;
        }
        iT.dpQ.r(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ag.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(230022);
                com.tencent.luggage.sdk.b.a.c.a aVar = new com.tencent.luggage.sdk.b.a.c.a(new a.AbstractC0181a(gVar) {
                    /* class com.tencent.mm.plugin.appbrand.ag.c.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.appbrand.commonjni.a.a.b, com.tencent.luggage.sdk.b.a.c.a.AbstractC0181a
                    public final String nativeInvokeHandler(String str, String str2, int i2, boolean z) {
                        AppMethodBeat.i(230019);
                        if (gVar == null) {
                            Log.e("MicroMsg.V8EngineWorkerManagerLU", "hy: component released when nativeInvokeHandler: %s, %s, %d, %b", str, str2, Integer.valueOf(i2), Boolean.valueOf(z));
                            AppMethodBeat.o(230019);
                            return null;
                        }
                        try {
                            String a2 = gVar.a(str, str2, i2, z, new o() {
                                /* class com.tencent.mm.plugin.appbrand.ag.c.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.m.o
                                public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
                                    AppMethodBeat.i(230018);
                                    c cVar = c.this;
                                    m mVar = iT;
                                    if (mVar == null) {
                                        Log.w("MicroMsg.V8EngineWorkerManagerLU", "hy: engine context released");
                                        AppMethodBeat.o(230018);
                                    } else if (valueCallback != null) {
                                        mVar.a(str, new m.b(valueCallback) {
                                            /* class com.tencent.mm.plugin.appbrand.ag.c.AnonymousClass4 */
                                            final /* synthetic */ ValueCallback dri;

                                            {
                                                this.dri = r2;
                                            }

                                            @Override // com.tencent.mm.appbrand.v8.m.b
                                            public final void a(String str, m.c cVar) {
                                                AppMethodBeat.i(230023);
                                                this.dri.onReceiveValue(str);
                                                AppMethodBeat.o(230023);
                                            }
                                        });
                                        AppMethodBeat.o(230018);
                                    } else {
                                        mVar.a(str, (m.b) null);
                                        AppMethodBeat.o(230018);
                                    }
                                }
                            });
                            AppMethodBeat.o(230019);
                            return a2;
                        } catch (Throwable th) {
                            Log.printErrStackTrace("MicroMsg.V8EngineWorkerManagerLU", th, "IMBInvokeHandler.invoke", new Object[0]);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.ag.c.AnonymousClass3.AnonymousClass1.AnonymousClass2 */

                                public final void run() {
                                    throw th;
                                }
                            });
                            AppMethodBeat.o(230019);
                            return "";
                        }
                    }

                    @Override // com.tencent.mm.appbrand.commonjni.a.a.b
                    public final void resumeLoopTasks() {
                        AppMethodBeat.i(230020);
                        iT.dpQ.resumeLoopTasks();
                        AppMethodBeat.o(230020);
                    }

                    @Override // com.tencent.mm.appbrand.commonjni.a.a.b
                    public final boolean doInnerLoopTask() {
                        AppMethodBeat.i(230021);
                        boolean doInnerLoopTask = iT.dpQ.doInnerLoopTask();
                        AppMethodBeat.o(230021);
                        return doInnerLoopTask;
                    }
                });
                AppBrandCommonBindingJniParams appBrandCommonBindingJniParams = new AppBrandCommonBindingJniParams();
                appBrandCommonBindingJniParams.jsContext = iT.XK();
                appBrandCommonBindingJniParams.jsEngine = iT.dpQ.getIsolatePtr();
                appBrandCommonBindingJniParams.uvLoop = iT.dpQ.getUVLoopPtr();
                appBrandCommonBindingJniParams.wasmCachePath = c.this.OB();
                aVar.cAE.notifyCreate(appBrandCommonBindingJniParams);
                aVar.cAF.bindTo(iT.dpQ.getIsolatePtr(), iT.XK());
                c.this.oFn.put(i2, aVar);
                aVar.cAE.notifyRuntimeReady(gVar.getAppId(), c.this.a(gVar));
                AppMethodBeat.o(230022);
            }
        });
        AppMethodBeat.o(230027);
    }

    /* access modifiers changed from: protected */
    public String a(g gVar) {
        return "";
    }

    /* access modifiers changed from: protected */
    public String OB() {
        return "";
    }
}
