package com.tencent.mm.plugin.soter.e;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.soter.core.c.i;

public final class e implements a<Boolean, Boolean> {
    private b jSi = null;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.vending.c.a
    public final /* synthetic */ Boolean call(Boolean bool) {
        AppMethodBeat.i(130886);
        Boolean bool2 = bool;
        this.jSi = g.hdx();
        Log.v("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo isNeedSaveDeviceInfo: %b", bool2);
        if (!com.tencent.soter.a.a.hlC()) {
            Log.w("MicroMsg.SoterSaveDeviceInfoFunc", "alvinluo not support soter");
            this.jSi.ej(g.P(2, "not support soter"));
        } else if (bool2.booleanValue()) {
            d.flN();
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath());
            if (mmkv != null) {
                String string = mmkv.getString("cpu_id", null);
                String string2 = mmkv.getString("uid", null);
                Log.i("MicroMsg.SoterDeviceInfoManager", "alvinluo old cpuId: %s, old uid: %s", string, string2);
                i hlo = com.tencent.soter.core.a.hlo();
                if (hlo != null) {
                    String str = hlo.FhU;
                    String valueOf = String.valueOf(hlo.uid);
                    Log.i("MicroMsg.SoterDeviceInfoManager", "new cpuid: %s, uid: %s", str, valueOf);
                    if (str.equals(string) && !valueOf.equals(string2)) {
                        h.INSTANCE.dN(1104, 20);
                    }
                    if (string2 != null && string2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        h.INSTANCE.dN(1104, 21);
                    }
                    if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(valueOf) && !Util.isNullOrNil(str)) {
                        h.INSTANCE.dN(1104, 32);
                    }
                    if (!Util.isNullOrNil(str) && !Util.isNullOrNil(valueOf)) {
                        d.kV(str, valueOf);
                    }
                    h.INSTANCE.dN(1104, 22);
                }
            }
        }
        Boolean bool3 = Boolean.TRUE;
        AppMethodBeat.o(130886);
        return bool3;
    }
}
