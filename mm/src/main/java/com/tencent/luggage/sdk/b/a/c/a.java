package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.a.a;
import com.tencent.mm.appbrand.commonjni.a.b;
import com.tencent.mm.appbrand.commonjni.a.c;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class a {
    public final AppBrandCommonBindingJni cAE;
    public final BufferURLManager cAF = new BufferURLManager();

    static {
        AppMethodBeat.i(229849);
        b.a(new b.a() {
            /* class com.tencent.luggage.sdk.b.a.c.a.AnonymousClass1 */

            @Override // com.tencent.mm.appbrand.commonjni.a.b.a
            public final void loadLibrary(String str) {
                AppMethodBeat.i(229844);
                long currentTicks = Util.currentTicks();
                j.load(str);
                Log.i("MicroMsg.AppBrandCommonBinding", "hy: test loading %s using %d ms", str, Long.valueOf(Util.ticksToNow(currentTicks)));
                AppMethodBeat.o(229844);
            }
        });
        c.C0267c.a(new c.b() {
            /* class com.tencent.luggage.sdk.b.a.c.a.AnonymousClass2 */

            @Override // com.tencent.mm.appbrand.commonjni.a.c.b
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(229845);
                Log.i(str, str2, objArr);
                AppMethodBeat.o(229845);
            }

            @Override // com.tencent.mm.appbrand.commonjni.a.c.b
            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(229846);
                Log.w(str, str2, objArr);
                AppMethodBeat.o(229846);
            }

            @Override // com.tencent.mm.appbrand.commonjni.a.c.b
            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(229847);
                Log.e(str, str2, objArr);
                AppMethodBeat.o(229847);
            }
        });
        b.loadLibrary("wxa-runtime-binding");
        AppMethodBeat.o(229849);
    }

    /* renamed from: com.tencent.luggage.sdk.b.a.c.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0181a implements a.b {
        private final WeakReference<g> cAG;

        public AbstractC0181a(g gVar) {
            this.cAG = new WeakReference<>(gVar);
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public String nativeInvokeHandler(String str, String str2, int i2, boolean z) {
            if (this.cAG.get() == null) {
                Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when nativeInvokeHandler: %s, %s, %d, %b", str, str2, Integer.valueOf(i2), Boolean.valueOf(z));
                return null;
            }
            try {
                return this.cAG.get().a(str, str2, i2, z);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.AbsAppBrandDelegate", th, "IMBInvokeHandler.invoke", new Object[0]);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.luggage.sdk.b.a.c.a.AbstractC0181a.AnonymousClass1 */

                    public final void run() {
                        throw th;
                    }
                });
                return "";
            }
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public final String[] getAsyncableJsApis() {
            if (this.cAG.get() != null) {
                return this.cAG.get().getAsyncableJsApis();
            }
            Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when getAsyncableJsApis");
            return new String[0];
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public final ByteBuffer readWeAppFile(String str) {
            if (this.cAG.get() == null) {
                Log.e("MicroMsg.AbsAppBrandDelegate", "hy: component released when readWeAppFile");
                return null;
            }
            i<ByteBuffer> iVar = new i<>();
            m b2 = ((q) Objects.requireNonNull(this.cAG.get().getFileSystem())).b(str, iVar);
            if (b2 == m.OK) {
                return x.q(iVar.value);
            }
            Log.e("MicroMsg.AbsAppBrandDelegate", "readFile %s failed: %s", str, b2);
            return null;
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public boolean syncInitModule(String str, String str2) {
            return false;
        }
    }

    public a(a.b bVar) {
        AppMethodBeat.i(229848);
        this.cAE = new AppBrandCommonBindingJni(bVar);
        AppMethodBeat.o(229848);
    }

    public final AppBrandCommonBindingJni Oh() {
        return this.cAE;
    }
}
