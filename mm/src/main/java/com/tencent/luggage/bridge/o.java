package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

public final class o {
    private s csH;
    n csI;
    public f csJ;
    public p csK;
    public ConcurrentHashMap<String, l> csL = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, j> csM = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, h> csN = new ConcurrentHashMap<>();
    private AtomicInteger csO = new AtomicInteger(1);

    public o(s sVar) {
        AppMethodBeat.i(140336);
        this.csH = sVar;
        this.csI = new n(this);
        this.csJ = new f(this.csH);
        this.csK = new q(this);
        this.csH.addJavascriptInterface(new r(this.csI), "_luggageBridgeNative");
        AppMethodBeat.o(140336);
    }

    public final void cN(String str) {
        AppMethodBeat.i(140337);
        this.csH.evaluateJavascript(str, null);
        AppMethodBeat.o(140337);
    }

    /* access modifiers changed from: package-private */
    public final e a(m mVar, boolean z) {
        AppMethodBeat.i(140338);
        try {
            k kVar = new k(this.csJ, mVar, z);
            l lVar = this.csL.get(kVar.csu);
            if (lVar != null) {
                lVar.a(kVar);
            } else {
                Log.e("LuggageBridge", "Invoke Listener Not Found: %s", kVar.csu);
                kVar.c("system:function_not_exist", null);
            }
            if (kVar.csA) {
                e KZ = kVar.KZ();
                AppMethodBeat.o(140338);
                return KZ;
            }
            AppMethodBeat.o(140338);
            return null;
        } catch (JSONException e2) {
            Log.e("LuggageBridge", "inflate Js2JavaInvokeContext failed: %s", e2);
            AppMethodBeat.o(140338);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(m mVar) {
        AppMethodBeat.i(140339);
        try {
            i iVar = new i(mVar);
            Log.i("LuggageBridge", "processEventFromJs, EventName = %s", iVar.csx);
            a(iVar);
            AppMethodBeat.o(140339);
        } catch (JSONException e2) {
            Log.e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", e2);
            AppMethodBeat.o(140339);
        }
    }

    private void a(i iVar) {
        AppMethodBeat.i(140340);
        if (this.csM.get(iVar.csx) == null) {
            Log.e("LuggageBridge", "no listener for event: %s", iVar.csx);
            AppMethodBeat.o(140340);
            return;
        }
        AppMethodBeat.o(140340);
    }

    /* access modifiers changed from: package-private */
    public final void b(m mVar) {
        AppMethodBeat.i(140341);
        try {
            g gVar = new g(mVar);
            if (this.csN.get(Integer.valueOf(gVar.csv)) == null) {
                Log.e("LuggageBridge", "no listener for callback: %d", Integer.valueOf(gVar.csv));
                AppMethodBeat.o(140341);
                return;
            }
            if (!gVar.csw) {
                this.csN.remove(Integer.valueOf(gVar.csv));
            }
            AppMethodBeat.o(140341);
        } catch (JSONException e2) {
            Log.e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", e2);
            AppMethodBeat.o(140341);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046 A[SYNTHETIC, Splitter:B:13:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082 A[SYNTHETIC, Splitter:B:26:0x0082] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void La() {
        /*
        // Method dump skipped, instructions count: 157
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.bridge.o.La():void");
    }
}
