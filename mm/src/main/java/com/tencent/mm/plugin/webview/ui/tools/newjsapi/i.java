package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.graphics.Bitmap;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetLocalImgData;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class i extends a {
    private static final int CDJ = 249;
    public static final i Jxk = new i();
    private static final String edq = edq;

    static {
        AppMethodBeat.i(210595);
        AppMethodBeat.o(210595);
    }

    private i() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return CDJ;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        Bitmap decodeFile;
        int i2;
        AppMethodBeat.i(210594);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        String str = (String) nVar.params.get(ch.COL_LOCALID);
        float f2 = Util.getFloat((String) nVar.params.get("compressionRatio"), 0.0f);
        if (Util.isNullOrNil(str)) {
            fVar.IQZ.h(nVar.ISe, "getLocalImgData:fail_invaild_localid", null);
            AppMethodBeat.o(210594);
            return false;
        }
        try {
            e eVar = fVar.mHh;
            String gu = eVar != null ? eVar.gu(str, 2) : null;
            if (!(gu == null || (decodeFile = BitmapUtil.decodeFile(gu)) == null || decodeFile.isRecycled())) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                double d2 = (double) f2;
                if (d2 < 0.1d || d2 > 0.99d) {
                    i2 = 90;
                } else {
                    i2 = (int) (100.0f * f2);
                }
                decodeFile.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                String encodeToString = Base64.encodeToString(byteArray, 0);
                Log.i("MicroMsg.JsApiGetLocalImgData", "rawData lenght = %d, base64 lenght = %d compressionRatio=".concat(String.valueOf(f2)), Integer.valueOf(byteArray.length), Integer.valueOf(encodeToString.length()));
                HashMap hashMap = new HashMap();
                p.g(encodeToString, "base64Content");
                hashMap.put("localData", encodeToString);
                fVar.IQZ.h(nVar.ISe, "getLocalImgData:ok", hashMap);
                Log.i("MicroMsg.JsApiGetLocalImgData", "bitmap recycle %s", decodeFile.toString());
                decodeFile.recycle();
                AppMethodBeat.o(210594);
                return true;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiGetLocalImgData", e2.getMessage());
        }
        fVar.IQZ.h(nVar.ISe, "getLocalImgData:fail", null);
        AppMethodBeat.o(210594);
        return false;
    }
}
