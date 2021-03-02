package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import org.json.JSONObject;

public final class l extends d<c> {
    public static final int CTRL_INDEX = 74;
    public static final String NAME = "shareTimeline";
    private static boolean mrQ = false;
    private final int mrR = a.aK(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        final String str;
        AppMethodBeat.i(46787);
        final c cVar2 = cVar;
        final Activity ay = cVar2.ay(Activity.class);
        if (ay == null) {
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46787);
            return;
        }
        final AppBrandInitConfigWC bsC = cVar2.getRuntime().bsC();
        final String appId = cVar2.getAppId();
        String str2 = bsC.username;
        String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("path");
        String optString3 = jSONObject.optString("imageUrl");
        final String optString4 = jSONObject.optString("messageExtraData");
        String optString5 = jSONObject.optString("preloadResources");
        int optInt = jSONObject.optInt("cardSubType", 0);
        if (Util.isNullOrNil(optString)) {
            optString = cVar2.bsz().bDn();
        }
        final String str3 = Util.isNullOrNil(optString) ? bsC.brandName : optString;
        String Ur = w.Ur(cVar2.getAppId());
        final int i3 = bsC.appVersion;
        int i4 = bsC.eix;
        final String sb = y.bN(appId, p.Un(appId).kCQ.getAndIncrement()).toString();
        final z zVar = new z();
        zVar.dCC = sb;
        zVar.msM = 1;
        zVar.msN = str3;
        zVar.msO = optString2;
        zVar.msP = optString3;
        zVar.msQ = 0;
        Log.d("MicroMsg.JsApiShareTimeline", "doTimeline, errorUrl:[%s] data:[%s]", Ur, jSONObject.toString());
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_link", Ur);
        intent.putExtra("Ksnsupload_contentattribute", 0);
        intent.putExtra("ksnsis_appbrand", true);
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        intent.putExtra("KsnsUpload_BrandUsername", str2);
        intent.putExtra("KsnsUpload_BrandPath", optString2);
        intent.putExtra("KsnsUpload_BrandVersion", i3);
        intent.putExtra("KsnsUpload_BrandVersionType", i4);
        intent.putExtra("KsnsUpload_BrandShareActionId", sb);
        intent.putExtra("KsnsUpload_isGame", bsC.NA());
        intent.putExtra("KsnsUpload_MessageExtraData", optString4);
        intent.putExtra("Ksnsupload_title", str3);
        intent.putExtra("KsnsUpload_SubType", optInt);
        intent.putExtra("KsnsUpload_PreloadResouces", optString5);
        if (optString3.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || optString3.startsWith(HttpWrapperBase.PROTOCAL_HTTPS) || Util.isNullOrNil(optString3)) {
            String str4 = Util.isNullOrNil(optString3) ? bsC.iconUrl : optString3;
            intent.putExtra("Ksnsupload_imgurl", str4);
            str = str4;
        } else if (optString3.startsWith("wxfile://")) {
            String str5 = null;
            o VY = cVar2.getFileSystem().VY(optString3);
            if (VY == null || !VY.exists()) {
                intent.putExtra("Ksnsupload_imgurl", bsC.iconUrl);
            } else {
                str5 = aa.z(VY.her());
                intent.putExtra("KsnsUpload_imgPath", str5);
            }
            Log.i("MicroMsg.JsApiShareTimeline", "local imagePath:%s", str5);
            str = optString3;
        } else {
            byte[] bArr = new byte[0];
            Bitmap k = z.k(cVar2.getRuntime(), optString3);
            if (k == null || k.isRecycled()) {
                Log.e("MicroMsg.JsApiShareTimeline", "thumb image is null");
            } else {
                Log.i("MicroMsg.JsApiShareTimeline", "thumb image is not null ");
                Bitmap createBitmap = Bitmap.createBitmap(k.getWidth(), k.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(-1);
                canvas.drawBitmap(k, 0.0f, 0.0f, (Paint) null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
                Log.i("MicroMsg.JsApiShareTimeline", "bitmap recycle %s", createBitmap);
                createBitmap.recycle();
                k.recycle();
            }
            Log.d("MicroMsg.JsApiShareTimeline", "getImageBufferForShare :%d", Integer.valueOf(bArr.length));
            if (bArr == null || bArr.length <= 0) {
                intent.putExtra("Ksnsupload_imgurl", bsC.iconUrl);
                str = optString3;
            } else {
                intent.putExtra("Ksnsupload_imgbuf", bArr);
                str = optString3;
            }
        }
        Log.d("MicroMsg.JsApiShareTimeline", "report, appId : %s, path: %s", appId, optString2);
        String JX = ad.JX("wxapp_" + appId + optString2);
        ad.aVe().G(JX, true).l("prePublishId", "wxapp_" + appId + optString2);
        intent.putExtra("reportSessionId", JX);
        f.aK(ay).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.share.l.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174919);
                if (i2 == l.this.mrR) {
                    if (i3 == -1) {
                        h.cD(ay, ay.getResources().getString(R.string.z0));
                        l.b(appId, optString2, "", 1, i3);
                        Log.i("MicroMsg.JsApiShareTimeline", "result is success");
                        cVar2.i(i2, l.this.h("success", null));
                        String str = cVar2.bsz().nna;
                        String bDn = cVar2.bsz().bDn();
                        int i4 = bsC.cyo;
                        aa.a(sb, zVar);
                        y.a(appId, bsC.cyA.scene, bsC.cyA.dCw, bsC.cym, null, str3, optString2, str, bDn, 0, sb, null, i4, str, i3, 3, optString4);
                    } else {
                        Log.i("MicroMsg.JsApiShareTimeline", "result is cancel");
                        cVar2.i(i2, l.this.h("cancel", null));
                        l.b(appId, optString2, "", 3, i3);
                    }
                    AppMethodBeat.o(174919);
                    return true;
                }
                AppMethodBeat.o(174919);
                return false;
            }
        });
        com.tencent.mm.br.c.a((Context) ay, "sns", ".ui.SnsUploadUI", intent, this.mrR, false);
        AppMethodBeat.o(46787);
    }

    public l() {
        AppMethodBeat.i(180273);
        AppMethodBeat.o(180273);
    }

    static /* synthetic */ void b(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(174920);
        i.a(str, str2, 3, str3, Util.nowSecond(), i2, i3);
        AppMethodBeat.o(174920);
    }
}
