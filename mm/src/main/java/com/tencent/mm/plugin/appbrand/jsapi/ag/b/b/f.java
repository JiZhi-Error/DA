package com.tencent.mm.plugin.appbrand.jsapi.ag.b.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.jsapi.b.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends d {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "canvasToTempFilePath";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.b.d, com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        boolean z;
        AppMethodBeat.i(139464);
        if (jSONObject == null || !jSONObject.has("data")) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            Log.i("MicroMsg.JsApiXWebCanvasToTempFilePath", "invokeXWebCanvasJsApi data:%s", jSONObject);
            int optInt = jSONObject.optInt("width", 300);
            int optInt2 = jSONObject.optInt("height", 150);
            float f2 = Util.getFloat(jSONObject.optString("destWidth"), (float) optInt);
            float f3 = Util.getFloat(jSONObject.optString("destHeight"), (float) optInt2);
            try {
                Object obj = jSONObject.get("data");
                if (!(obj instanceof ByteBuffer)) {
                    Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "get data failed, value is not a ByteBuffer");
                    fVar.i(i2, h("fail:illegal data", null));
                    AppMethodBeat.o(139464);
                    return;
                }
                byte[] p = com.tencent.mm.plugin.appbrand.ac.d.p((ByteBuffer) obj);
                int[] iArr = new int[(p.length / 4)];
                int i3 = 0;
                for (int i4 = 0; i4 < iArr.length; i4++) {
                    int i5 = i3 + 1;
                    int i6 = i5 + 1;
                    int i7 = ((p[i3] & 255) << 16) | ((p[i5] & 255) << 8);
                    int i8 = i6 + 1;
                    int i9 = (p[i6] & 255) | i7;
                    i3 = i8 + 1;
                    iArr[i4] = ((p[i8] & 255) << 24) | i9;
                }
                Bitmap bitmap = null;
                try {
                    bitmap = Bitmap.createBitmap(iArr, optInt, optInt2, Bitmap.Config.ARGB_8888);
                } catch (Exception e2) {
                    Log.printInfoStack("MicroMsg.JsApiXWebCanvasToTempFilePath", "create bitmap fail:%s", e2);
                } catch (Throwable th) {
                    Log.printInfoStack("MicroMsg.JsApiXWebCanvasToTempFilePath", "create bitmap fail:%s", th);
                }
                if (bitmap == null) {
                    Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "oriBitmap is null, err, return");
                    fVar.i(i2, h("fail:illegal bitmap", null));
                    AppMethodBeat.o(139464);
                    return;
                }
                if (!(((float) bitmap.getWidth()) == f2 && ((float) bitmap.getHeight()) == f3)) {
                    try {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) f2, (int) f3, false);
                        Log.i("MicroMsg.JsApiXWebCanvasToTempFilePath", "bitmap recycle %s %s ", bitmap, createScaledBitmap);
                        bitmap = createScaledBitmap;
                    } catch (Exception e3) {
                        Log.printInfoStack("MicroMsg.JsApiXWebCanvasToTempFilePath", "create scaledbitmap fail:%s", e3);
                    } catch (Throwable th2) {
                        Log.printInfoStack("MicroMsg.JsApiXWebCanvasToTempFilePath", "create scaledbitmap fail:%s", th2);
                    }
                }
                if (bitmap == null) {
                    Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "oriBitmap is null, err, return");
                    fVar.i(i2, h("fail:illegal bitmap", null));
                    AppMethodBeat.o(139464);
                    return;
                }
                Bitmap.CompressFormat S = S(jSONObject);
                String str = S == Bitmap.CompressFormat.JPEG ? "jpg" : "png";
                o Wa = fVar.getFileSystem().Wa("canvas_" + System.currentTimeMillis() + "." + str);
                if (Wa == null) {
                    Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, alloc file failed");
                    fVar.i(i2, h("fail alloc file failed", null));
                    AppMethodBeat.o(139464);
                    return;
                }
                String z2 = aa.z(Wa.her());
                Log.d("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, savePath = %s", z2);
                try {
                    BitmapUtil.saveBitmapToImage(bitmap, R(jSONObject), S, z2, true);
                    i<String> iVar = new i<>();
                    fVar.getFileSystem().a(new o(z2), str, true, iVar);
                    T t = iVar.value;
                    Log.d("MicroMsg.JsApiXWebCanvasToTempFilePath", "toTempFilePath, returnPath = %s", t);
                    HashMap hashMap = new HashMap();
                    hashMap.put("tempFilePath", t);
                    fVar.i(i2, n("ok", hashMap));
                    AppMethodBeat.o(139464);
                } catch (IOException e4) {
                    Log.w("MicroMsg.JsApiXWebCanvasToTempFilePath", "save bitmap to file failed. exception : %s", e4);
                    fVar.i(i2, h("fail:write file failed", null));
                    AppMethodBeat.o(139464);
                }
            } catch (JSONException e5) {
                Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath", "get data failed, %s", android.util.Log.getStackTraceString(e5));
                fVar.i(i2, h("fail:missing data", null));
                AppMethodBeat.o(139464);
            }
        } else {
            super.a(fVar, jSONObject, i2);
            AppMethodBeat.o(139464);
        }
    }
}
