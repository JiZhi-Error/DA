package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.sdk.http.HttpWrapperBase;

final class c implements e {
    c() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.e
    public final Bitmap a(d dVar, String str) {
        AppMethodBeat.i(121254);
        Bitmap a2 = a(dVar, str, null);
        AppMethodBeat.o(121254);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.e
    public final Bitmap a(d dVar, String str, e.a aVar) {
        AppMethodBeat.i(121255);
        Bitmap a2 = a(dVar, str, null, aVar);
        AppMethodBeat.o(121255);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.e
    public final Bitmap a(final d dVar, final String str, Rect rect, final e.a aVar) {
        Bitmap bitmap;
        AppMethodBeat.i(121256);
        final String string = dVar.hpn.getString("id", "");
        if (str.startsWith("wxfile://")) {
            AppBrandLocalMediaObject av = AppBrandLocalMediaObjectManager.av(string, str);
            if (av == null || TextUtils.isEmpty(av.iGf)) {
                AppMethodBeat.o(121256);
                return null;
            }
            String str2 = av.iGf;
            if (!str2.startsWith("file://")) {
                str2 = "file://".concat(String.valueOf(str2));
            }
            bitmap = b.aXY().a(str2, (b.f) null);
        } else if (str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS) || str.startsWith(HttpWrapperBase.PROTOCAL_HTTP)) {
            Bitmap a2 = b.aXY().a(str, (b.f) null);
            if (a2 == null) {
                b.aXY().a(new b.k() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.b.c.AnonymousClass1 */

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void aYg() {
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void I(Bitmap bitmap) {
                        AppMethodBeat.i(121252);
                        if (aVar == null || bitmap == null || bitmap.isRecycled()) {
                            AppMethodBeat.o(121252);
                            return;
                        }
                        aVar.a(dVar);
                        AppMethodBeat.o(121252);
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void oD() {
                        AppMethodBeat.i(121253);
                        Bundle bundle = new Bundle();
                        bundle.putString("id", string);
                        bundle.putInt("widgetState", 2103);
                        h.a(i.bBL().Yn(string), bundle, f.a.class, null);
                        AppMethodBeat.o(121253);
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                    public final String Lb() {
                        return "WxaWidgetIcon";
                    }
                }, str, (b.h) null, (b.f) null);
                bitmap = a2;
            } else {
                bitmap = a2;
            }
        } else {
            bitmap = a.db(string, str);
        }
        AppMethodBeat.o(121256);
        return bitmap;
    }
}
