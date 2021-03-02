package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m extends d<s> {
    public static final int CTRL_INDEX = 787;
    public static final String NAME = "previewMedia";
    private final int mdT = 524288;
    final int mdU = a.aK(this);

    public m() {
        AppMethodBeat.i(180248);
        AppMethodBeat.o(180248);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        com.tencent.mm.plugin.appbrand.game.f.a aVar;
        AppMethodBeat.i(180253);
        s sVar2 = sVar;
        Log.i("MicroMsg.JsApiPreviewMedia", "previewMedia data:%s", jSONObject);
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) sVar2.getRuntime().OU();
        if (!(appBrandInitConfigWC == null || !appBrandInitConfigWC.NA() || (aVar = (com.tencent.mm.plugin.appbrand.game.f.a) sVar2.getCurrentPageView().S(com.tencent.mm.plugin.appbrand.game.f.a.class)) == null || aVar.bDj() == null || !aVar.bDj().bDk())) {
            Log.i("MicroMsg.JsApiPreviewMedia", "addCustomDataListener to report canvas data");
            b.b(sVar2, sVar2.getAppId());
        }
        sVar2.i(i2, a(sVar2.ay(Activity.class), sVar2.getCurrentPageView(), sVar2.getAppId(), jSONObject));
        AppMethodBeat.o(180253);
    }

    private String a(Context context, ac acVar, String str, JSONObject jSONObject) {
        int i2;
        o VY;
        o VY2;
        AppMethodBeat.i(180249);
        JSONArray optJSONArray = jSONObject.optJSONArray("sources");
        if (optJSONArray == null) {
            String h2 = h("fail:invalid data", null);
            AppMethodBeat.o(180249);
            return h2;
        }
        String[] strArr = new String[optJSONArray.length()];
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            AppBrandMediaSource appBrandMediaSource = new AppBrandMediaSource();
            appBrandMediaSource.url = optJSONObject.optString("url");
            appBrandMediaSource.igV = optJSONObject.optString("type");
            appBrandMediaSource.igW = optJSONObject.optString("poster");
            strArr[i3] = appBrandMediaSource.url;
            if (!TextUtils.isEmpty(appBrandMediaSource.igW) && (VY2 = acVar.getFileSystem().VY(appBrandMediaSource.igW)) != null) {
                appBrandMediaSource.igW = aa.z(VY2.her());
            }
            if (!TextUtils.isEmpty(appBrandMediaSource.url) && (VY = acVar.getFileSystem().VY(appBrandMediaSource.url)) != null) {
                strArr[i3] = aa.z(VY.her());
                appBrandMediaSource.url = aa.z(VY.her());
            }
            arrayList.add(appBrandMediaSource);
        }
        int i4 = 0;
        Object opt = jSONObject.opt("current");
        if (opt instanceof Integer) {
            i2 = ((Integer) opt).intValue();
        } else {
            if (opt instanceof String) {
                for (int i5 = 0; i5 < strArr.length; i5++) {
                    if (opt.equals(strArr[i5])) {
                        i4 = i5;
                    }
                }
            }
            i2 = i4;
        }
        if (i2 < 0 || i2 >= strArr.length) {
            i2 = 0;
        }
        String[] q = com.tencent.mm.plugin.appbrand.jsapi.ac.a.q(strArr);
        final String[] a2 = com.tencent.mm.plugin.appbrand.jsapi.ac.a.a(q, strArr);
        if (i2 >= q.length) {
            i2 = 0;
        }
        if (!(context instanceof Activity)) {
            String h3 = h("fail:internal error invalid android context", null);
            AppMethodBeat.o(180249);
            return h3;
        }
        boolean optBoolean = jSONObject.optBoolean("showmenu", true);
        Log.i("MicroMsg.JsApiPreviewMedia", "showmenu:%b", Boolean.valueOf(optBoolean));
        Intent intent = new Intent();
        intent.putExtra("nowUrl", q[i2]);
        intent.putParcelableArrayListExtra("mediaSource", arrayList);
        intent.putExtra("urlList", q);
        intent.putExtra("type", -255);
        intent.putExtra("isFromWebView", true);
        intent.putExtra("isFromAppBrand", true);
        intent.putExtra("showmenu", optBoolean);
        com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) acVar.av(com.tencent.mm.plugin.appbrand.s.a.class);
        if (aVar == null || Util.isNullOrNil(aVar.referer)) {
            Log.w("MicroMsg.JsApiPreviewMedia", "config.referer is null");
        } else {
            s.a(acVar, jSONObject, intent, aVar.referer);
        }
        intent.putExtra("shouldShowScanQrCodeMenu", true);
        intent.putExtra("scanQrCodeGetA8KeyScene", 44);
        intent.putExtra("scanCodeTypes", new int[]{3});
        intent.putExtra("scanResultCodeTypes", new int[]{22});
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", 6);
        bundle.putString("stat_app_id", str);
        bundle.putString("stat_url", acVar.lBI);
        intent.putExtra("_stat_obj", bundle);
        intent.setClassName(context, MMApplicationContext.getSourcePackageName() + ".plugin.subapp.ui.gallery.GestureGalleryUI");
        try {
            int length = intent.getExtras().toString().length();
            if (length > 524288) {
                Log.e("MicroMsg.JsApiPreviewMedia", "data too large size:%d", Integer.valueOf(length));
                String h4 = h("fail:data too large", null);
                AppMethodBeat.o(180249);
                return h4;
            }
            f.aK(context).b(new f.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.m.AnonymousClass1 */

                @Override // com.tencent.luggage.h.f.c
                public final boolean c(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(180247);
                    if (m.this.mdU == i2) {
                        com.tencent.mm.plugin.appbrand.jsapi.ac.a.r(a2);
                        AppMethodBeat.o(180247);
                        return true;
                    }
                    AppMethodBeat.o(180247);
                    return false;
                }
            });
            c.a(context, "subapp", ".ui.gallery.GestureGalleryUI", intent, this.mdU, false);
            String h5 = h("ok", null);
            AppMethodBeat.o(180249);
            return h5;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.JsApiPreviewMedia", e2, "JsApiPreviewImage get size error", new Object[0]);
            String h6 = h("fail", null);
            AppMethodBeat.o(180249);
            return h6;
        }
    }
}
