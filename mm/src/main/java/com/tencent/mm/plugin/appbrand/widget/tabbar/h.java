package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;

public final class h extends d {
    public h(String str, c cVar, s sVar) {
        super(str, cVar, sVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.d
    public final void cdf() {
        AppMethodBeat.i(135548);
        final AppBrandRuntime runtime = this.kGT.getRuntime();
        if (!(runtime == null || this.oFe == null)) {
            com.tencent.f.h.RTc.aX(new com.tencent.f.i.h() {
                /* class com.tencent.mm.plugin.appbrand.widget.tabbar.h.AnonymousClass1 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "PackageIconLoader";
                }

                public final void run() {
                    AppMethodBeat.i(135547);
                    InputStream f2 = bg.f(runtime, h.this.oFe);
                    Bitmap decodeStream = BitmapFactory.decodeStream(f2);
                    if (decodeStream == null) {
                        h.this.oFf.a("Failed to load icon via package path", h.this);
                    } else {
                        h.this.X(decodeStream);
                    }
                    if (f2 != null) {
                        Util.qualityClose(f2);
                    }
                    AppMethodBeat.o(135547);
                }
            });
        }
        AppMethodBeat.o(135548);
    }
}
