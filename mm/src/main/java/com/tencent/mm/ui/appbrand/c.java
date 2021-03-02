package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class c implements h {
    @Override // com.tencent.mm.plugin.appbrand.service.h
    public final boolean bVr() {
        AppMethodBeat.i(232751);
        i eiy = ((l) g.af(l.class)).eiy();
        if (eiy == null) {
            Log.i("MicroMsg.AppBrandNotifyMsgService", "get info storage fail");
            AppMethodBeat.o(232751);
            return false;
        }
        int Ku = eiy.Ku("appbrand_notify_message");
        Log.i("MicroMsg.AppBrandNotifyMsgService", "conversation count: %d", Integer.valueOf(Ku));
        if (Ku <= 1) {
            AppMethodBeat.o(232751);
            return false;
        }
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_appbrand_notify_msg_enable, false);
        Log.i("MicroMsg.AppBrandNotifyMsgService", "showNotifyMsgPreference, isABtestEnable: %b", Boolean.valueOf(a2));
        if (!a2) {
            AppMethodBeat.o(232751);
            return false;
        }
        AppMethodBeat.o(232751);
        return true;
    }
}
