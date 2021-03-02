package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextNodeJS;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.i;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.b.e;
import com.tencent.mm.b.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.File;

public final class h extends a {
    private i dpA;
    private MultiContextNodeJS dpy;
    private volatile m dpz;

    private h(IJSRuntime.Config config) {
        super(config);
    }

    static h e(IJSRuntime.Config config) {
        AppMethodBeat.i(144022);
        h hVar = new h(config);
        AppMethodBeat.o(144022);
        return hVar;
    }

    static {
        AppMethodBeat.i(144026);
        MultiContextNodeJS.setGetTmpFileDirectoryDelegate(new MultiContextNodeJS.IGetTmpFileDirectory() {
            /* class com.tencent.mm.appbrand.v8.h.AnonymousClass1 */

            @Override // com.eclipsesource.v8.MultiContextNodeJS.IGetTmpFileDirectory
            public final File getDirectory() {
                AppMethodBeat.i(144017);
                String str = MMApplicationContext.getContext().getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/tmp/";
                e.f(str);
                o oVar = new o(str);
                if (!oVar.exists()) {
                    Log.e("MicroMsg.NodeJSRuntime", "try mkdirs again");
                    oVar.mkdirs();
                }
                Log.i("MicroMsg.NodeJSRuntime", "tmpDir:%s exist:%b", str, Boolean.valueOf(oVar.exists()));
                File file = new File(q.k(aa.z(oVar.her()), true));
                AppMethodBeat.o(144017);
                return file;
            }
        });
        AppMethodBeat.o(144026);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.appbrand.v8.a
    public final MultiContextV8 Xs() {
        AppMethodBeat.i(144023);
        synchronized (h.class) {
            try {
                this.dpy = MultiContextNodeJS.createMultiContextNodeJS(1, this.doX, this.doY, this.dpa);
            } catch (Throwable th) {
                AppMethodBeat.o(144023);
                throw th;
            }
        }
        this.dpy.getRuntime().getV8().setNativeJavaCallback(new Runnable() {
            /* class com.tencent.mm.appbrand.v8.h.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(216881);
                h.this.dpA.XD();
                AppMethodBeat.o(216881);
            }
        });
        this.dpy.getRuntime().getV8().setJavaTaskScheduler(new V8.JavaTaskScheduler() {
            /* class com.tencent.mm.appbrand.v8.h.AnonymousClass3 */

            @Override // com.eclipsesource.v8.V8.JavaTaskScheduler
            public final void Schedule(Runnable runnable) {
                AppMethodBeat.i(216882);
                h.this.dpA.u(runnable);
                AppMethodBeat.o(216882);
            }
        });
        this.doY = null;
        MultiContextV8 runtime = this.dpy.getRuntime();
        AppMethodBeat.o(144023);
        return runtime;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.appbrand.v8.a
    public final c Xt() {
        AppMethodBeat.i(144024);
        this.dpA = i.a(new i.a() {
            /* class com.tencent.mm.appbrand.v8.h.AnonymousClass4 */

            @Override // com.tencent.mm.appbrand.v8.i.a
            public final boolean XB() {
                AppMethodBeat.i(216883);
                boolean handleMessage = h.this.dpy.handleMessage();
                AppMethodBeat.o(216883);
                return handleMessage;
            }

            @Override // com.tencent.mm.appbrand.v8.i.a
            public final void wakeUpUVLoop() {
                AppMethodBeat.i(216884);
                if (h.this.dpy != null) {
                    h.this.dpy.wakeUpUVLoop();
                }
                AppMethodBeat.o(216884);
            }

            @Override // com.tencent.mm.appbrand.v8.i.a
            public final void closeUVLoop() {
                AppMethodBeat.i(216885);
                if (h.this.dpy != null) {
                    h.this.dpy.closeUVLoop();
                }
                AppMethodBeat.o(216885);
            }
        }, this.dpf.dpp);
        i iVar = this.dpA;
        AppMethodBeat.o(144024);
        return iVar;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.appbrand.v8.a
    public final void Xu() {
        AppMethodBeat.i(144025);
        Log.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
        try {
            this.dpy.release();
            Log.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd done");
            AppMethodBeat.o(144025);
        } catch (Exception e2) {
            Log.e("MicroMsg.NodeJSRuntime", "cleanUpWhenThreadEnd exp = %s", e2);
            AppMethodBeat.o(144025);
        }
    }

    public final m XA() {
        AppMethodBeat.i(216887);
        if (this.dpz == null) {
            this.dpz = new m(this, Xv(), new m.a() {
                /* class com.tencent.mm.appbrand.v8.h.AnonymousClass5 */

                @Override // com.tencent.mm.appbrand.v8.m.a
                public final V8Context Xy() {
                    AppMethodBeat.i(216886);
                    if (h.this.dpy == null) {
                        IllegalStateException illegalStateException = new IllegalStateException("getMainContext mNodeJS not ready!");
                        AppMethodBeat.o(216886);
                        throw illegalStateException;
                    }
                    Log.i("MicroMsg.NodeJSRuntime", "getMainContext %s", Integer.valueOf(h.this.dpy.getMainContext().hashCode()));
                    V8Context mainContext = h.this.dpy.getMainContext();
                    AppMethodBeat.o(216886);
                    return mainContext;
                }
            });
        }
        m mVar = this.dpz;
        AppMethodBeat.o(216887);
        return mVar;
    }
}
