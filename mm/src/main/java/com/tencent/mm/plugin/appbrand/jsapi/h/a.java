package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.d.f;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public abstract class a<P extends f> extends d<ac> {
    a() {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0174 A[Catch:{ Exception -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0204  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(P r7, org.json.JSONObject r8, com.tencent.mm.plugin.appbrand.page.ac r9, int r10) {
        /*
        // Method dump skipped, instructions count: 575
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.h.a.a(com.tencent.mm.plugin.appbrand.widget.input.d.f, org.json.JSONObject, com.tencent.mm.plugin.appbrand.page.ac, int):boolean");
    }

    /* access modifiers changed from: protected */
    public boolean bGz() {
        return false;
    }

    protected static String xc(int i2) {
        return ad.aVe().G("AppBrandJsInput@".concat(String.valueOf(i2)), true).getString("passing_data", "");
    }

    protected static void al(int i2, String str) {
        ad.aVe().G("AppBrandJsInput@".concat(String.valueOf(i2)), true).aK("passing_data", str);
    }

    protected static void a(int i2, ac acVar) {
        if (acVar != null) {
            ad.aVe().G("AppBrandJsInput@".concat(String.valueOf(i2)), true).l("webview_reference", new WeakReference(acVar));
        }
    }
}
