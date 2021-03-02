package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.QbarNative;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.HashMap;
import org.json.JSONObject;

public final class j extends bc {
    private static final int CTRL_INDEX = 455;
    public static final String NAME = "onCameraScanCode";
    public static j lQe = new j();

    static {
        AppMethodBeat.i(46221);
        AppMethodBeat.o(46221);
    }

    public static void a(f fVar, int i2, String str, int i3, String str2, byte[] bArr, QbarNative.QBarPoint qBarPoint) {
        AppMethodBeat.i(226731);
        HashMap hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(i2));
        hashMap.put("type", str);
        hashMap.put("result", str2);
        hashMap.put("codeVersion", Integer.valueOf(i3));
        if (qBarPoint != null) {
            hashMap.put("scanArea", new float[]{g.aS(qBarPoint.x0), g.aS(qBarPoint.y0), g.aS(qBarPoint.x1 - qBarPoint.x0), g.aS(qBarPoint.y3 - qBarPoint.y0)});
        }
        if (bArr != null && bArr.length > 0) {
            String encodeToString = Base64.encodeToString(bArr, 2);
            hashMap.put("charSet", ProtocolPackage.ServerEncoding);
            hashMap.put("rawData", encodeToString);
        }
        String jSONObject = new JSONObject(hashMap).toString();
        Log.d("MicroMsg.JsApiCameraScanCode", "onCameraScanCode:%s", jSONObject);
        fVar.b(lQe.getName(), jSONObject, null);
        AppMethodBeat.o(226731);
    }
}
