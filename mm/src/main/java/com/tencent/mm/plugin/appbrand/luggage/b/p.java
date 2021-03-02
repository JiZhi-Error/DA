package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.bridge.impl.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.http.HttpWrapperBase;

public final class p extends a implements b {
    private final AppBrandRuntime kEc;

    p(AppBrandRuntime appBrandRuntime) {
        this.kEc = appBrandRuntime;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final String Lb() {
        return "WxaPkgImageReader";
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final boolean match(String str) {
        AppMethodBeat.i(134912);
        if (str == null || !str.startsWith("wxapkg://")) {
            AppMethodBeat.o(134912);
            return false;
        }
        AppMethodBeat.o(134912);
        return true;
    }

    private static Pair<String, String> acr(String str) {
        AppMethodBeat.i(219351);
        Uri parse = Uri.parse(str);
        Pair<String, String> create = Pair.create(parse.getQueryParameter("appId"), parse.getQueryParameter("path"));
        AppMethodBeat.o(219351);
        return create;
    }

    @Override // com.tencent.luggage.bridge.impl.a.a
    public final void a(String str, a.c cVar) {
        AppMethodBeat.i(219352);
        if (cVar == null) {
            AppMethodBeat.o(219352);
            return;
        }
        String str2 = (String) acr(str).second;
        if (TextUtils.isEmpty(str2)) {
            cVar.C(null);
            AppMethodBeat.o(219352);
            return;
        }
        cVar.C(bg.f(this.kEc, str2));
        AppMethodBeat.o(219352);
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final Bitmap b(String str, Rect rect, a.b bVar) {
        AppMethodBeat.i(134913);
        if (!match(str)) {
            AppMethodBeat.o(134913);
            return null;
        }
        String str2 = (String) acr(str).second;
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(134913);
            return null;
        }
        Bitmap k = z.k(this.kEc, Uri.decode(str2));
        if (rect != null) {
            k = new com.tencent.mm.plugin.appbrand.luggage.a.b(rect.left, rect.top, rect.width(), rect.height()).J(k);
        }
        AppMethodBeat.o(134913);
        return k;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.b
    public final boolean a(f fVar, String str) {
        AppMethodBeat.i(134914);
        if (fVar == null || str == null || str.length() == 0) {
            AppMethodBeat.o(134914);
            return false;
        } else if (str.startsWith("wxapkg://") || str.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS) || str.startsWith("wxfile://") || str.contains("://")) {
            AppMethodBeat.o(134914);
            return false;
        } else {
            AppMethodBeat.o(134914);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.f.b
    public final String b(f fVar, String str) {
        AppMethodBeat.i(134915);
        if (!a(fVar, str)) {
            AppMethodBeat.o(134915);
            return str;
        }
        String str2 = "wxapkg://" + "icon?" + "appId=" + fVar.getAppId() + "&" + "path=" + Uri.encode(str);
        AppMethodBeat.o(134915);
        return str2;
    }
}
