package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;

public class w extends br<s> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return f.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<s>.a aVar) {
        AppMethodBeat.i(78558);
        Log.i("MicroMsg.JsApiGetNetworkType", "invoke");
        if (!NetStatusUtil.isConnected(aVar.cta.mContext)) {
            Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, not connected");
            aVar.c("network_type:fail", null);
            AppMethodBeat.o(78558);
            return;
        }
        Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, type = ".concat(String.valueOf(NetStatusUtil.getNetType(aVar.cta.mContext))));
        HashMap hashMap = new HashMap();
        hashMap.put("simtype", (IPCInteger) h.a(MainProcessIPCService.dkO, null, a.class));
        if (NetStatusUtil.isWifi(aVar.cta.mContext)) {
            Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, wifi");
            aVar.e("network_type:wifi", hashMap);
            AppMethodBeat.o(78558);
            return;
        }
        if (NetStatusUtil.is2G(aVar.cta.mContext)) {
            Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 2g");
            hashMap.put("subtype", "2g");
        } else if (NetStatusUtil.is3G(aVar.cta.mContext)) {
            Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 3g");
            hashMap.put("subtype", "3g");
        } else if (NetStatusUtil.is4G(aVar.cta.mContext)) {
            Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 4g");
            hashMap.put("subtype", "4g");
        } else if (NetStatusUtil.is5G(aVar.cta.mContext)) {
            Log.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 5g");
            hashMap.put("subtype", "5g");
        }
        aVar.e("network_type:wwan", hashMap);
        AppMethodBeat.o(78558);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    static class a implements k<IPCVoid, IPCInteger> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCInteger invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(78557);
            int Qr = g.af(com.tencent.mm.plugin.misc.a.a.class) != null ? ((com.tencent.mm.plugin.misc.a.a) g.af(com.tencent.mm.plugin.misc.a.a.class)).Qr(16) : 0;
            int i2 = Qr == 0 ? 0 : Qr == 1 ? 1 : 2;
            IPCInteger iPCInteger = new IPCInteger();
            iPCInteger.value = i2;
            AppMethodBeat.o(78557);
            return iPCInteger;
        }
    }
}
