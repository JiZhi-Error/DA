package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;

public class v extends bs<g> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "getLocalImgData";
    }

    static class a implements b<IPCString, IPCString> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, d<IPCString> dVar) {
            AppMethodBeat.i(210943);
            IPCString iPCString2 = new IPCString();
            iPCString2.value = ay.aZa(iPCString.value);
            dVar.bn(iPCString2);
            AppMethodBeat.o(210943);
        }
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final com.tencent.luggage.d.b<g>.a aVar) {
        AppMethodBeat.i(210944);
        String optString = aVar.ctb.csi.optString(ch.COL_LOCALID);
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiGetLocalImgData", "localId is nil");
            aVar.c("invaild_localid", null);
            AppMethodBeat.o(210944);
            return;
        }
        IPCString iPCString = new IPCString();
        iPCString.value = optString;
        h.a(MainProcessIPCService.dkO, iPCString, a.class, new d<IPCString>() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.v.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCString iPCString) {
                Bitmap decodeFile;
                AppMethodBeat.i(210942);
                IPCString iPCString2 = iPCString;
                if (iPCString2 == null || Util.isNullOrNil(iPCString2.value)) {
                    Log.e("MicroMsg.JsApiGetLocalImgData", "path is null");
                    aVar.c("fail", null);
                    AppMethodBeat.o(210942);
                    return;
                }
                try {
                    if (!(iPCString2.value == null || (decodeFile = BitmapUtil.decodeFile(iPCString2.value)) == null || decodeFile.isRecycled())) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        decodeFile.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        String encodeToString = Base64.encodeToString(byteArray, 0);
                        Log.i("MicroMsg.JsApiGetLocalImgData", "rawData lenght = %d, base64 lenght = %d", Integer.valueOf(byteArray.length), Integer.valueOf(encodeToString.length()));
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("localData", encodeToString);
                        aVar.c("", jSONObject);
                        decodeFile.recycle();
                        AppMethodBeat.o(210942);
                        return;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiGetLocalImgData", e2.getMessage());
                }
                aVar.c("fail", null);
                AppMethodBeat.o(210942);
            }
        });
        AppMethodBeat.o(210944);
    }
}
