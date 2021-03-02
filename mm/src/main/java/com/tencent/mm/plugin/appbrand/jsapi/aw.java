package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

public class aw<S extends s> extends d<S> {
    public static final int CTRL_INDEX = 250;
    public static final String NAME = "captureScreen";

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.tencent.mm.plugin.appbrand.jsapi.aw<S extends com.tencent.mm.plugin.appbrand.s> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(139840);
        s sVar = (s) fVar;
        Log.i("MicroMsg.JsApiCaptureScreen", "captureScreen, appId:%s", sVar.getAppId());
        w brh = sVar.getRuntime().brh();
        if (brh == null || brh.getPageView() == null) {
            Log.e("MicroMsg.JsApiCaptureScreen", "captureScreen, container or page is null");
            sVar.i(i2, h("fail:container or page is null", null));
            AppMethodBeat.o(139840);
        } else if (brh.getPageView() == null) {
            Log.e("MicroMsg.JsApiCaptureScreen", "captureScreen, container or page is null");
            sVar.i(i2, h("fail:container or page is null", null));
            AppMethodBeat.o(139840);
        } else {
            Bitmap i3 = i(sVar);
            if (i3 == null) {
                Log.e("MicroMsg.JsApiCaptureScreen", "bitmap is null, err return");
                sVar.i(i2, h("fail:can't captureScreen", null));
                AppMethodBeat.o(139840);
                return;
            }
            i<String> iVar = new i<>();
            if (sVar.getFileSystem().a(iVar) != m.OK) {
                sVar.i(i2, h("fail:gen temp file failed", null));
                AppMethodBeat.o(139840);
                return;
            }
            String z = aa.z(new o((String) iVar.value, "appbrand_capture_" + System.currentTimeMillis()).her());
            Log.i("MicroMsg.JsApiCaptureScreen", "capture bitmap path:%s", z);
            try {
                BitmapUtil.saveBitmapToImage(i3, 100, Bitmap.CompressFormat.PNG, z, true);
                i<String> iVar2 = new i<>();
                if (sVar.getFileSystem().a(new o(z), "png", true, iVar2) != m.OK) {
                    Log.w("MicroMsg.JsApiCaptureScreen", "create temp file failed, path:%s", z);
                    sVar.i(i2, h("fail:gen temp file failed", null));
                    if (i3 != null && !i3.isRecycled()) {
                        Log.i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", i3);
                        i3.recycle();
                    }
                    AppMethodBeat.o(139840);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("tempFilePath", iVar2.value);
                Log.i("MicroMsg.JsApiCaptureScreen", "capture bitmap tempFilePath:%s", iVar2.value);
                sVar.i(i2, n("ok", hashMap));
                if (i3 != null && !i3.isRecycled()) {
                    Log.i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", i3);
                    i3.recycle();
                }
                AppMethodBeat.o(139840);
            } catch (IOException e2) {
                Log.w("MicroMsg.JsApiCaptureScreen", "save bitmap to file failed, . exception : %s", e2);
                sVar.i(i2, h("fail:IOException", null));
                if (i3 != null && !i3.isRecycled()) {
                    Log.i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", i3);
                    i3.recycle();
                }
                AppMethodBeat.o(139840);
            } catch (Exception e3) {
                Log.w("MicroMsg.JsApiCaptureScreen", "save bitmap to file failed, . exception : %s", e3);
                sVar.i(i2, h("fail:Exception", null));
                if (i3 != null && !i3.isRecycled()) {
                    Log.i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", i3);
                    i3.recycle();
                }
                AppMethodBeat.o(139840);
            } catch (Throwable th) {
                if (i3 != null && !i3.isRecycled()) {
                    Log.i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", i3);
                    i3.recycle();
                }
                AppMethodBeat.o(139840);
                throw th;
            }
        }
    }

    public Bitmap i(S s) {
        AppMethodBeat.i(139839);
        final ac currentPageView = s.getCurrentPageView();
        if (currentPageView == null) {
            AppMethodBeat.o(139839);
            return null;
        }
        Bitmap bitmap = (Bitmap) new SyncTask<Bitmap>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.aw.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Bitmap run() {
                AppMethodBeat.i(139838);
                Bitmap bRB = currentPageView.bRB();
                AppMethodBeat.o(139838);
                return bRB;
            }
        }.exec(new MMHandler(Looper.getMainLooper()));
        AppMethodBeat.o(139839);
        return bitmap;
    }
}
