package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import java.util.HashMap;

final class b extends bc implements c.b {
    private static final int CTRL_INDEX = 678;
    public static final String NAME = "onImageViewLoad";
    private final ad.b lTf;
    private final h lTg;

    b(int i2, ad.b bVar, h hVar) {
        AppMethodBeat.i(193662);
        p("viewId", Integer.valueOf(i2));
        this.lTf = bVar;
        this.lTg = hVar;
        AppMethodBeat.o(193662);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.c.b
    public final void f(final BitmapFactory.Options options) {
        AppMethodBeat.i(193663);
        if (options != null) {
            p("errMsg", "ok");
            p("size", new HashMap<String, Object>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.b.AnonymousClass1 */

                {
                    AppMethodBeat.i(193661);
                    put("width", Integer.valueOf(options.outWidth));
                    put("height", Integer.valueOf(options.outHeight));
                    AppMethodBeat.o(193661);
                }
            });
        } else {
            p("errMsg", "fail");
        }
        if (this.lTf == null || !"webview".equals(this.lTf.getString("sendTo", null))) {
            this.lTg.a(this, (int[]) null);
            AppMethodBeat.o(193663);
            return;
        }
        this.lTg.a(this);
        AppMethodBeat.o(193663);
    }
}
