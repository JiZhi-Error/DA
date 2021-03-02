package com.tencent.mm.plugin.appbrand.t;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.sdk.platformtools.Log;

final class a extends c {
    private volatile b njL = b.kQH;
    private c.a njM = null;
    private Intent njN = null;

    static /* synthetic */ void a(a aVar, Intent intent) {
        AppMethodBeat.i(240912);
        aVar.J(intent);
        AppMethodBeat.o(240912);
    }

    public a(String str, Activity activity, f fVar) {
        super(str, activity, fVar);
        AppMethodBeat.i(240905);
        J(this.lqg);
        AppMethodBeat.o(240905);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c
    public final void hK(boolean z) {
        AppMethodBeat.i(240906);
        Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "setRequireForegroundDispatch, requireForegroundDispatch: ".concat(String.valueOf(z)));
        super.hK(z);
        if (z) {
            J(this.lqg);
            AppMethodBeat.o(240906);
            return;
        }
        f fVar = this.lqg;
        c.a bPP = bPP();
        if (bPP == null) {
            Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, not need");
            AppMethodBeat.o(240906);
            return;
        }
        com.tencent.mm.plugin.appbrand.a.c K = K(fVar);
        if (K == null) {
            Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "stopListenRunningStateChangeIfNeed, runningStateController is null");
            AppMethodBeat.o(240906);
            return;
        }
        this.njL = b.kQH;
        K.b(bPP);
        AppMethodBeat.o(240906);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c
    public final void E(Intent intent) {
        AppMethodBeat.i(240907);
        b bVar = this.njL;
        Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryDispatchNfcTagDiscovered, curRunningState: ".concat(String.valueOf(bVar)));
        if (b.kQH == bVar) {
            J(intent);
            AppMethodBeat.o(240907);
            return;
        }
        Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryDispatchNfcTagDiscovered, dispatch pending");
        this.njN = intent;
        AppMethodBeat.o(240907);
    }

    private void J(f fVar) {
        AppMethodBeat.i(240908);
        com.tencent.mm.plugin.appbrand.a.c K = K(fVar);
        if (K == null) {
            Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryListenRunningStateChange, runningStateController is null");
            AppMethodBeat.o(240908);
            return;
        }
        b bwY = K.kQM.bwY();
        Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "tryListenRunningStateChange, curRunningState: ".concat(String.valueOf(bwY)));
        this.njL = bwY;
        K.a(bPQ());
        AppMethodBeat.o(240908);
    }

    private void J(Intent intent) {
        AppMethodBeat.i(240909);
        Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "realTryDispatchNfcTagDiscovered");
        super.E(intent);
        AppMethodBeat.o(240909);
    }

    private synchronized c.a bPP() {
        return this.njM;
    }

    private synchronized c.a bPQ() {
        c.a aVar;
        AppMethodBeat.i(240910);
        if (this.njM == null) {
            this.njM = new c.a() {
                /* class com.tencent.mm.plugin.appbrand.t.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.a.c.a
                public final void a(String str, b bVar) {
                    AppMethodBeat.i(240904);
                    Log.i("MicroMsg.AppBrand.WxaNFCReadWriteManager", "onRunningStateChanged, appId: %s, state: %s", str, bVar);
                    if (!a.this.appId.equals(str)) {
                        AppMethodBeat.o(240904);
                        return;
                    }
                    a.this.njL = bVar;
                    if (a.this.njN != null && b.kQH == bVar) {
                        a.a(a.this, a.this.njN);
                        a.this.njN = null;
                    }
                    AppMethodBeat.o(240904);
                }
            };
        }
        aVar = this.njM;
        AppMethodBeat.o(240910);
        return aVar;
    }

    private static com.tencent.mm.plugin.appbrand.a.c K(f fVar) {
        AppMethodBeat.i(240911);
        if (!(fVar instanceof k)) {
            Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, component is not AppBrandComponentWithExtra");
            AppMethodBeat.o(240911);
            return null;
        }
        AppBrandRuntime runtime = ((k) fVar).getRuntime();
        if (runtime == null) {
            Log.w("MicroMsg.AppBrand.WxaNFCReadWriteManager", "getRunningStateController, runtime is null");
            AppMethodBeat.o(240911);
            return null;
        }
        com.tencent.mm.plugin.appbrand.a.c cVar = runtime.kAH;
        AppMethodBeat.o(240911);
        return cVar;
    }
}
