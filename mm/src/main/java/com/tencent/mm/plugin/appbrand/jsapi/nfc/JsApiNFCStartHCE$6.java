package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

/* access modifiers changed from: package-private */
public class JsApiNFCStartHCE$6 extends ResultReceiver {
    final /* synthetic */ g mhh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JsApiNFCStartHCE$6(g gVar, Handler handler) {
        super(handler);
        this.mhh = gVar;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        boolean z;
        AppMethodBeat.i(136113);
        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver resultCode: %d", Integer.valueOf(i2));
        if (bundle == null || i2 != 10002) {
            AppMethodBeat.o(136113);
            return;
        }
        int i3 = bundle.getInt("key_event_type", -1);
        String string = bundle.getString("key_appid");
        int i4 = bundle.getInt("errCode", -1);
        String string2 = bundle.getString("errMsg");
        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver onReceiveResult eventType: %d, appId: %s", Integer.valueOf(i3), string);
        switch (i3) {
            case 31:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                a.a(this.mhh.kSY, i3, bundle);
                AppMethodBeat.o(136113);
                return;
            case 12:
                if (bundle != null) {
                    g gVar = this.mhh;
                    synchronized (gVar.mLock) {
                        try {
                            z = gVar.isFinished;
                            if (!z) {
                                gVar.isFinished = true;
                            }
                        } finally {
                            AppMethodBeat.o(136113);
                        }
                    }
                    if (z) {
                        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEFinish has finished, return");
                        AppMethodBeat.o(136113);
                        return;
                    } else if (HCEEventLogic.bHI()) {
                        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
                        AppMethodBeat.o(136113);
                        return;
                    } else {
                        HashMap hashMap = new HashMap();
                        int currentTimeMillis = (int) (System.currentTimeMillis() - gVar.mStartTime);
                        if (gVar.mTimer != null) {
                            Log.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE timer cancel");
                            gVar.mTimer.cancel();
                        }
                        if (string == null || string.equals(gVar.kSY.getAppId())) {
                            Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo HCE start HCEService callback onRefreshed errCode: %d, errMsg: %s", Integer.valueOf(i4), string2);
                            if (i4 == 0) {
                                HCEEventLogic.aau(gVar.kSY.getAppId());
                                hashMap.put("errCode", 0);
                                gVar.ZA(gVar.n("ok", hashMap));
                            } else {
                                hashMap.put("errCode", Integer.valueOf(i4));
                                gVar.ZA(gVar.n("fail: ".concat(String.valueOf(string2)), hashMap));
                            }
                            c.R(gVar.kSY.getAppId(), i4, currentTimeMillis);
                            HCEEventLogic.hI(true);
                            break;
                        } else {
                            Log.e("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCESevice callback appId invalid, appId: %s", string);
                            hashMap.put("errCode", 13010);
                            c.R(gVar.kSY.getAppId(), 13010, currentTimeMillis);
                            gVar.ZA(gVar.n("fail: unknown error", hashMap));
                            AppMethodBeat.o(136113);
                            return;
                        }
                    }
                }
                break;
        }
    }
}
