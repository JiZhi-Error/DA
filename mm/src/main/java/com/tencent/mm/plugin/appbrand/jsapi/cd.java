package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class cd extends d {
    public static final int CTRL_INDEX = 982;
    public static final String NAME = "openWCExDeviceList";

    cd() {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(226679);
        Log.i("MicroMsg.JsApiOpenWCExDeviceList", "invoke JsApiOpenWCExDeviceList!");
        if (fVar == null) {
            Log.e("MicroMsg.JsApiOpenWCExDeviceList", "fail:component is null");
            AppMethodBeat.o(226679);
        } else if (fVar.getContext() == null) {
            Log.e("MicroMsg.JsApiOpenWCExDeviceList", "fail:context is null");
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(226679);
        } else {
            c.b(fVar.getContext(), "exdevice", ".ui.ExdeviceManageDeviceUI", new Intent());
            fVar.i(i2, h("ok", null));
            AppMethodBeat.o(226679);
        }
    }
}
