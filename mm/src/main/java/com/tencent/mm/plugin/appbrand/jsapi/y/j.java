package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class j implements a {
    private static Boolean mqQ;
    private static Boolean mqR;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
    public final int bID() {
        return 5;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
    public final int bIE() {
        return 20;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
    public final boolean bIF() {
        boolean z;
        AppMethodBeat.i(226980);
        if (mqQ == null) {
            if (((b) g.af(b.class)).a(b.a.clicfg_android_wxa_sensor_not_use_frequency_limit, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            mqQ = Boolean.valueOf(z);
            Log.i("MicroMsg.SensorJsEventControllerWx", "ignorePublishFrequencyLimit:%b", mqQ);
        }
        boolean booleanValue = mqQ.booleanValue();
        AppMethodBeat.o(226980);
        return booleanValue;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
    public final boolean bIG() {
        boolean z;
        AppMethodBeat.i(226981);
        if (mqR == null) {
            if (((b) g.af(b.class)).a(b.a.clicfg_android_wxa_sensor_device_motion_use_new, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            mqR = Boolean.valueOf(z);
            Log.i("MicroMsg.SensorJsEventControllerWx", "useNewDeviceMotionStrategy:%b", mqR);
        }
        boolean booleanValue = mqR.booleanValue();
        AppMethodBeat.o(226981);
        return booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.tencent.mm.plugin.appbrand.permission.d */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.y.a
    public final boolean a(f fVar, bc bcVar) {
        boolean z;
        AppMethodBeat.i(226979);
        if (fVar == null || !fVar.isRunning() || bcVar == null) {
            z = false;
        } else if (!(fVar instanceof k)) {
            Log.e("MicroMsg.SensorJsEventControllerWx", "hasPermission AppBrandComponentWithExtra");
            z = false;
        } else {
            k kVar = (k) fVar;
            if (kVar.getRuntime() == null) {
                Log.e("MicroMsg.SensorJsEventControllerWx", "runtime is null, return");
                z = false;
            } else if (!(kVar.getRuntime() instanceof q)) {
                Log.e("MicroMsg.SensorJsEventControllerWx", "hasPermission not AppBrandRuntimeWC");
                z = false;
            } else {
                z = ((q) kVar.getRuntime()).cCn.a(fVar, (Class<? extends e>) bcVar.getClass());
            }
        }
        if (z) {
            AppMethodBeat.o(226979);
            return true;
        }
        AppMethodBeat.o(226979);
        return false;
    }
}
