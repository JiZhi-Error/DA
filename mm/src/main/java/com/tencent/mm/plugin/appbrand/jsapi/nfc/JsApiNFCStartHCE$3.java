package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

class JsApiNFCStartHCE$3 extends ResultReceiver {
    final /* synthetic */ g mhh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JsApiNFCStartHCE$3(g gVar, Handler handler) {
        super(handler);
        this.mhh = gVar;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        AppMethodBeat.i(136110);
        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI ResultReceiver resultCode: %d", Integer.valueOf(i2));
        if (bundle == null || i2 != 10001) {
            AppMethodBeat.o(136110);
            return;
        }
        int i3 = bundle.getInt("errCode", -1);
        String string = bundle.getString("errMsg");
        g gVar = this.mhh;
        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI onResult errCode: %d, errMsg: %s", Integer.valueOf(i3), string);
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i3));
        if (i3 == 0) {
            gVar.onSuccess();
            AppMethodBeat.o(136110);
            return;
        }
        c.R(gVar.kSY.getAppId(), i3, -1);
        gVar.ZA(gVar.n("fail: ".concat(String.valueOf(string)), hashMap));
        AppMethodBeat.o(136110);
    }
}
