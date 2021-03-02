package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends d {
    public static final int CTRL_INDEX = 169;
    public static final String NAME = "getClipboardData";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137660);
        ClipboardManager clipboardManager = (ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            Log.i("MicroMsg.JsApiGetClipboardData", "getSystemService(CLIPBOARD_SERVICE) failed.");
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(137660);
            return;
        }
        try {
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            String str = "";
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                if (itemAt.getText() != null) {
                    str = itemAt.getText().toString();
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", str);
            fVar.i(i2, n("ok", hashMap));
            AppMethodBeat.o(137660);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiGetClipboardData", "invoke with appId:%s, but get Exception:%s", fVar.getAppId(), e2);
            AppMethodBeat.o(137660);
        }
    }
}
