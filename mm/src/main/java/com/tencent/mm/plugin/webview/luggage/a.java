package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.webview.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements f.a {
    @Override // com.tencent.mm.plugin.webview.model.f.a
    public final void a(boolean z, int i2, int i3, String str, String str2) {
        AppMethodBeat.i(78186);
        Log.i("MicroMsg.CdnProgressCallback", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), str, str2);
        if (z) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ch.COL_LOCALID, str);
                jSONObject.put("percent", i3);
                Bundle bundle = new Bundle();
                bundle.putString("name", "onMediaFileUploadProgress");
                bundle.putString("data", jSONObject.toString());
                ToolsProcessIPCService.a(bundle, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
                AppMethodBeat.o(78186);
                return;
            } catch (JSONException e2) {
            }
        }
        AppMethodBeat.o(78186);
    }
}
