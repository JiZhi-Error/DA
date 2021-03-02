package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class l extends s {
    public static final int CTRL_INDEX = 520;
    public static final String NAME = "onVoIPChatInterrupted";

    public l() {
        AppMethodBeat.i(180259);
        c.aem(NAME);
        AppMethodBeat.o(180259);
    }

    public final void a(q.a aVar) {
        AppMethodBeat.i(226941);
        Log.i("MicroMsg.OpenVoice.OnVoIPChatInterruptedJsEvent", "hy: dispath reason: %s", aVar);
        HashMap hashMap = new HashMap(2);
        a b2 = b(aVar);
        hashMap.put("errMsg", b2.cXS + ", room id: " + q.INSTANCE.qtF);
        hashMap.put("errCode", Integer.valueOf(b2.errCode));
        hashMap.put("reason", b2.cXS);
        L(hashMap).bEo();
        AppMethodBeat.o(226941);
    }

    /* access modifiers changed from: package-private */
    public class a {
        String cXS;
        int errCode;

        public a(String str, int i2) {
            this.cXS = str;
            this.errCode = i2;
        }
    }

    private a b(q.a aVar) {
        AppMethodBeat.i(226942);
        switch (aVar) {
            case ReasonInterrupted:
                a aVar2 = new a("call interrupted due to native reason", -1000);
                AppMethodBeat.o(226942);
                return aVar2;
            case ReasonManual:
                a aVar3 = new a("user manually exit the call", -1000);
                AppMethodBeat.o(226942);
                return aVar3;
            case ReasonDevice:
                a aVar4 = new a("device start failed", -1000);
                AppMethodBeat.o(226942);
                return aVar4;
            case ReasonInCommingCall:
                a aVar5 = new a("in comming call", -2);
                AppMethodBeat.o(226942);
                return aVar5;
            case ReasonSessionUpdateFailed:
                a aVar6 = new a("session update failed", -1000);
                AppMethodBeat.o(226942);
                return aVar6;
            case ReasonWeappEnterBackground:
                a aVar7 = new a("current mini app entered background", -1);
                AppMethodBeat.o(226942);
                return aVar7;
            case ReasonWeappStopFromPassiveFloatBall:
                a aVar8 = new a("call interrupted due to close passive float ball", -3);
                AppMethodBeat.o(226942);
                return aVar8;
            default:
                a aVar9 = new a("unknown reason", -1000);
                AppMethodBeat.o(226942);
                return aVar9;
        }
    }
}
