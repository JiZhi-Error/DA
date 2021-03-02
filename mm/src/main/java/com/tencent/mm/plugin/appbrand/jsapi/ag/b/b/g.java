package com.tencent.mm.plugin.appbrand.jsapi.ag.b.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends d {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "xwebCanvasToTempFilePath";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.b.d, com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(215837);
        Log.i("MicroMsg.JsApiXWebCanvasToTempFilePath2", "invokeXWebCanvasJsApi data:%s", jSONObject);
        int i3 = (int) Util.getFloat(jSONObject.optString("x"), 0.0f);
        int i4 = (int) Util.getFloat(jSONObject.optString("y"), 0.0f);
        int i5 = (int) Util.getFloat(jSONObject.optString("width"), 0.0f);
        int i6 = (int) Util.getFloat(jSONObject.optString("height"), 0.0f);
        int optInt = jSONObject.optInt("viewId", 0);
        SkiaCanvasView xS = b.xS(optInt);
        if (xS == null) {
            Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath2", "get skiaCanvasView failed, viewId:%d", Integer.valueOf(optInt));
            fVar.i(i2, h("fail:internal error", null));
            AppMethodBeat.o(215837);
            return;
        }
        Bitmap snapshot = xS.getSnapshot(new Rect(i3, i4, i5, i6));
        if (snapshot == null) {
            Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath2", "oriBitmap is null, err, return");
            fVar.i(i2, h("fail:illegal bitmap", null));
            AppMethodBeat.o(215837);
            return;
        }
        float f2 = Util.getFloat(jSONObject.optString("destWidth"), (float) i5);
        float f3 = Util.getFloat(jSONObject.optString("destHeight"), (float) i6);
        if (!(((float) snapshot.getWidth()) == f2 && ((float) snapshot.getHeight()) == f3)) {
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(snapshot, (int) f2, (int) f3, false);
                Log.i("MicroMsg.JsApiXWebCanvasToTempFilePath2", "bitmap recycle %s %s ", snapshot, createScaledBitmap);
                snapshot = createScaledBitmap;
            } catch (Exception e2) {
                Log.printInfoStack("MicroMsg.JsApiXWebCanvasToTempFilePath2", "create scaledbitmap fail:%s", e2);
            } catch (Throwable th) {
                Log.printInfoStack("MicroMsg.JsApiXWebCanvasToTempFilePath2", "create scaledbitmap fail:%s", th);
            }
        }
        if (snapshot == null) {
            Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath2", "oriBitmap is null, err, return");
            fVar.i(i2, h("fail:illegal bitmap", null));
            AppMethodBeat.o(215837);
            return;
        }
        Bitmap.CompressFormat S = S(jSONObject);
        String str = S == Bitmap.CompressFormat.JPEG ? "jpg" : "png";
        o Wa = fVar.getFileSystem().Wa("canvas_" + System.currentTimeMillis() + "." + str);
        if (Wa == null) {
            Log.e("MicroMsg.JsApiXWebCanvasToTempFilePath2", "toTempFilePath, alloc file failed");
            fVar.i(i2, h("fail alloc file failed", null));
            AppMethodBeat.o(215837);
            return;
        }
        String z = aa.z(Wa.her());
        Log.d("MicroMsg.JsApiXWebCanvasToTempFilePath2", "toTempFilePath, savePath = %s", z);
        try {
            BitmapUtil.saveBitmapToImage(snapshot, R(jSONObject), S, z, true);
            i<String> iVar = new i<>();
            fVar.getFileSystem().a(new o(z), str, false, iVar);
            T t = iVar.value;
            Log.d("MicroMsg.JsApiXWebCanvasToTempFilePath2", "toTempFilePath, returnPath = %s", t);
            HashMap hashMap = new HashMap();
            hashMap.put("tempFilePath", t);
            fVar.i(i2, n("ok", hashMap));
            AppMethodBeat.o(215837);
        } catch (IOException e3) {
            Log.w("MicroMsg.JsApiXWebCanvasToTempFilePath2", "save bitmap to file failed. exception : %s", e3);
            fVar.i(i2, h("fail:write file failed", null));
            AppMethodBeat.o(215837);
        }
    }
}
