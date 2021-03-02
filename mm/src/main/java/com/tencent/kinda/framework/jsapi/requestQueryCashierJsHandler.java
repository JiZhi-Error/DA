package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.framework.jsapi.KindaJSInvokeListener;
import com.tencent.kinda.framework.module.impl.KindaJSEvent;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaJSEventType;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.plugin.appbrand.jsapi.bo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public class requestQueryCashierJsHandler implements KindaJSInvokeListener.JSHandler {
    public int type;

    @Override // com.tencent.kinda.framework.jsapi.KindaJSInvokeListener.JSHandler
    public int handleType() {
        return this.type;
    }

    @Override // com.tencent.kinda.framework.jsapi.KindaJSInvokeListener.JSHandler
    public String handleJsApi() {
        return bo.NAME;
    }

    @Override // com.tencent.kinda.framework.jsapi.KindaJSInvokeListener.JSHandler
    public void handle(final ll llVar) {
        AppMethodBeat.i(214449);
        KindaJSEvent kindaJSEvent = new KindaJSEvent();
        kindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate() {
            /* class com.tencent.kinda.framework.jsapi.requestQueryCashierJsHandler.AnonymousClass1 */

            @Override // com.tencent.kinda.gen.KJSEvent
            public KindaJSEventType kindaGetType() {
                if (llVar.dQJ.type == 1) {
                    return KindaJSEventType.WEB;
                }
                return KindaJSEventType.TINYAPP;
            }

            @Override // com.tencent.kinda.gen.KJSEvent
            public void kindaEndWithResult(String str, HashMap<String, String> hashMap) {
                AppMethodBeat.i(214447);
                Log.i(bo.NAME, "callback: %s", str);
                if (llVar.dQK.result == null) {
                    llVar.dQK.result = new Bundle();
                }
                llVar.dQK.result.putString("ret", str);
                llVar.dQJ.dQN.run();
                AppMethodBeat.o(214447);
            }

            @Override // com.tencent.kinda.gen.KJSEvent
            public void kindaCloseWebViewImpl(boolean z, VoidCallback voidCallback) {
                AppMethodBeat.i(214448);
                if (llVar.dQK.result == null) {
                    llVar.dQK.result = new Bundle();
                }
                llVar.dQK.result.putInt("closeWindow", 1);
                AppMethodBeat.o(214448);
            }
        });
        ITransmitKvData create = ITransmitKvData.create();
        create.putJSEvent("jsEvent", kindaJSEvent);
        create.putString("notifyType", llVar.dQJ.dQL.getString("notifyType"));
        create.putString("appId", llVar.dQJ.dQL.getString("appId"));
        create.putString("nonceStr", llVar.dQJ.dQL.getString("nonceStr"));
        create.putString("timeStamp", llVar.dQJ.dQL.getString("timeStamp"));
        create.putString("package", llVar.dQJ.dQL.getString("package"));
        create.putString("paySign", llVar.dQJ.dQL.getString("paySign"));
        create.putString("signType", llVar.dQJ.dQL.getString("signType"));
        if (llVar.dQJ.type == 1) {
            create.putInt("jsApiScene", 1);
        } else if (llVar.dQJ.type == 0) {
            create.putInt("jsApiScene", 2);
        }
        Log.d("requestQueryCashierJsHandler", "data: %s", llVar.dQJ.dQL.toString());
        KindaApp.appKinda().notifyAllUseCases(create);
        llVar.dQK.result.putString("ret", "fail");
        llVar.dQJ.dQN.run();
        AppMethodBeat.o(214449);
    }
}
