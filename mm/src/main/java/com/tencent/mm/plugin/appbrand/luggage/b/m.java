package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.luggage.bridge.impl.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import java.io.InputStream;
import java.util.Map;

public final class m extends c {
    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a, com.tencent.luggage.bridge.impl.a.c
    public final boolean match(String str) {
        AppMethodBeat.i(219348);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(219348);
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || lowerCase.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            AppMethodBeat.o(219348);
            return true;
        }
        AppMethodBeat.o(219348);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a, com.tencent.luggage.bridge.impl.a.c
    public final Bitmap b(String str, Rect rect, final a.b bVar) {
        com.tencent.mm.plugin.appbrand.luggage.a.a aVar;
        AppMethodBeat.i(219349);
        if (!match(str)) {
            AppMethodBeat.o(219349);
            return null;
        }
        if (rect != null) {
            aVar = new com.tencent.mm.plugin.appbrand.luggage.a.a(rect.left, rect.top, rect.width(), rect.height());
        } else {
            aVar = null;
        }
        Bitmap a2 = b.aXY().a(str, aVar);
        if (a2 == null) {
            b.aXY().a(new b.k() {
                /* class com.tencent.mm.plugin.appbrand.luggage.b.m.AnonymousClass1 */

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void aYg() {
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void I(Bitmap bitmap) {
                    AppMethodBeat.i(219344);
                    if (bVar == null) {
                        AppMethodBeat.o(219344);
                    } else if (bitmap == null || bitmap.isRecycled()) {
                        bVar.Q(null);
                        AppMethodBeat.o(219344);
                    } else {
                        bVar.Q(bitmap);
                        AppMethodBeat.o(219344);
                    }
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void oD() {
                    AppMethodBeat.i(219345);
                    if (bVar == null) {
                        AppMethodBeat.o(219345);
                        return;
                    }
                    bVar.Q(null);
                    AppMethodBeat.o(219345);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                public final String Lb() {
                    AppMethodBeat.i(219346);
                    String str = "WxaIcon" + hashCode();
                    AppMethodBeat.o(219346);
                    return str;
                }
            }, str, (b.h) null, aVar);
        }
        AppMethodBeat.o(219349);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a, com.tencent.luggage.bridge.impl.a.a
    public final void a(String str, Map<String, String> map, final a.c cVar) {
        AppMethodBeat.i(219350);
        b aXY = b.aXY();
        AnonymousClass2 r4 = new android.arch.a.c.a<InputStream, Void>() {
            /* class com.tencent.mm.plugin.appbrand.luggage.b.m.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.a.c.a
            public final /* synthetic */ Void apply(InputStream inputStream) {
                AppMethodBeat.i(219347);
                InputStream inputStream2 = inputStream;
                if (cVar != null) {
                    cVar.C(inputStream2);
                }
                AppMethodBeat.o(219347);
                return null;
            }
        };
        if (TextUtils.isEmpty(str)) {
            r4.apply(null);
            AppMethodBeat.o(219350);
            return;
        }
        aXY.iIK.iJf.post(new b.a(aXY, new b.q(str, (byte) 0), r4, str, map));
        AppMethodBeat.o(219350);
    }
}
