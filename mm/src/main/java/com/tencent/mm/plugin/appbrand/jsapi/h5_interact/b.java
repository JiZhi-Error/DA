package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class b extends d<c> {
    private static final int CTRL_INDEX = 459;
    private static final String NAME = "sendDataToH5";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46354);
        c cVar2 = cVar;
        if (!jSONObject.has("webviewId")) {
            cVar2.i(i2, h("fail:invalid data", null));
            Log.e("MicroMsg.AppBrand.JsApiSendDataToH5", "invoke with nil webviewId");
            AppMethodBeat.o(46354);
            return;
        }
        String appId = cVar2.getAppId();
        int optInt = jSONObject.optInt("webviewId");
        String optString = jSONObject.optString("data");
        SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = new SendDataToH5FromMiniProgramEvent();
        sendDataToH5FromMiniProgramEvent.lWc = appId;
        sendDataToH5FromMiniProgramEvent.data = optString;
        sendDataToH5FromMiniProgramEvent.lWd = optInt;
        ToolsProcessIPCService.a(sendDataToH5FromMiniProgramEvent, a.class);
        cVar2.i(i2, h("ok", null));
        AppMethodBeat.o(46354);
    }

    static final class a implements com.tencent.mm.ipcinvoker.b<SendDataToH5FromMiniProgramEvent, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(46353);
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent2 = sendDataToH5FromMiniProgramEvent;
            if (sendDataToH5FromMiniProgramEvent2 != null) {
                EventCenter.instance.publish(sendDataToH5FromMiniProgramEvent2);
            }
            AppMethodBeat.o(46353);
        }
    }
}
