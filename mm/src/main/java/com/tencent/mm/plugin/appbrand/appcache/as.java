package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class as {
    private static final WxaCommLibRuntimeReader.a kMa = new WxaCommLibRuntimeReader.a();

    static {
        AppMethodBeat.i(44336);
        AppMethodBeat.o(44336);
    }

    public static void bvQ() {
        AppMethodBeat.i(44332);
        doNotify();
        AppMethodBeat.o(44332);
    }

    public static void bvR() {
        AppMethodBeat.i(44333);
        doNotify();
        AppMethodBeat.o(44333);
    }

    public static void bvS() {
        AppMethodBeat.i(44334);
        try {
            WxaCommLibRuntimeReader.a aVar = kMa;
            IPCVoid iPCVoid = IPCVoid.hnE;
            aVar.bvZ();
            AppMethodBeat.o(44334);
        } catch (WxaCommLibRuntimeReader.AccountNotReadyError e2) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(44334);
            throw bVar;
        }
    }

    private static void doNotify() {
        AppMethodBeat.i(44335);
        WxaCommLibRuntimeReader.a aVar = kMa;
        IPCVoid iPCVoid = IPCVoid.hnE;
        Object bvZ = aVar.bvZ();
        if (bvZ instanceof WxaPkgWrappingInfo) {
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) bvZ;
            Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check ok ret[%s]", bvZ);
            String[] strArr = g.hrf;
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str = MMApplicationContext.getPackageName() + strArr[i2];
                if (MMApplicationContext.isProcessExist(str)) {
                    XIPCInvoker.a(str, wxaPkgWrappingInfo, a.class, null);
                }
            }
            AppMethodBeat.o(44335);
            return;
        }
        Log.e("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check failed ret[%s]", bvZ);
        AppMethodBeat.o(44335);
    }

    /* access modifiers changed from: package-private */
    public static final class a implements com.tencent.mm.ipcinvoker.b<WxaPkgWrappingInfo, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(WxaPkgWrappingInfo wxaPkgWrappingInfo, d<IPCVoid> dVar) {
            AppMethodBeat.i(44331);
            final WxaPkgWrappingInfo wxaPkgWrappingInfo2 = wxaPkgWrappingInfo;
            if (!((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_update_commlib_no_reboot_process_new, !com.tencent.mm.protocal.d.KyP)) {
                int bqV = com.tencent.mm.plugin.appbrand.a.bqV();
                Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "IPC_resetAppBrandCommLibReader#invoke(), process[%s] runtimeCount[%d] notify by rebooting process", MMApplicationContext.getProcessName(), Integer.valueOf(bqV));
                if (bqV <= 0) {
                    AppBrandProcessSuicideLogic.buq();
                }
                AppMethodBeat.o(44331);
                return;
            }
            Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "IPC_resetAppBrandCommLibReader#invoke(), process[%s], pkgInfo[%s]", MMApplicationContext.getProcessName(), wxaPkgWrappingInfo2);
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.appcache.as.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(44330);
                    final k kVar = new k(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.appcache.as.a.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(226359);
                            new b(wxaPkgWrappingInfo2).buw();
                            AppMethodBeat.o(226359);
                        }
                    }, 2);
                    e.f(com.tencent.mm.plugin.appbrand.task.g.WASERVICE).c(new com.tencent.mm.vending.c.a<Object, Void>() {
                        /* class com.tencent.mm.plugin.appbrand.appcache.as.a.AnonymousClass1.AnonymousClass2 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Object call(Void r3) {
                            AppMethodBeat.i(226360);
                            kVar.countDown();
                            AppMethodBeat.o(226360);
                            return null;
                        }
                    }).hdy();
                    e.f(com.tencent.mm.plugin.appbrand.task.g.WAGAME).c(new com.tencent.mm.vending.c.a<Object, Void>() {
                        /* class com.tencent.mm.plugin.appbrand.appcache.as.a.AnonymousClass1.AnonymousClass3 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Object call(Void r3) {
                            AppMethodBeat.i(226361);
                            kVar.countDown();
                            AppMethodBeat.o(226361);
                            return null;
                        }
                    }).hdy();
                    AppMethodBeat.o(44330);
                }
            });
            AppMethodBeat.o(44331);
        }
    }

    static class b implements com.tencent.mm.vending.c.a<Void, Void> {
        private WxaPkgWrappingInfo kMf;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Void call(Void r3) {
            AppMethodBeat.i(226363);
            Void buw = buw();
            AppMethodBeat.o(226363);
            return buw;
        }

        public b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            this.kMf = wxaPkgWrappingInfo;
        }

        public final Void buw() {
            AppMethodBeat.i(226362);
            boolean b2 = WxaCommLibRuntimeReader.b(this.kMf);
            int bqV = com.tencent.mm.plugin.appbrand.a.bqV();
            Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "IPC_resetAppBrandCommLibReader#invoke() waitForPreloaded entered, process[%s], pkgInfo[%s], globalReaderUpdated[%b], runningRuntimeCount[%d]", MMApplicationContext.getProcessName(), this.kMf, Boolean.valueOf(b2), Integer.valueOf(bqV));
            if (b2 && bqV <= 0) {
                e.bVQ();
            }
            Void r0 = QZL;
            AppMethodBeat.o(226362);
            return r0;
        }
    }
}
