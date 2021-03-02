package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends d {
    public b(String str, c cVar) {
        super(str, cVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.d
    public final void cdf() {
        AppMethodBeat.i(135541);
        if (this.oFe != null) {
            h.RTc.aX(new com.tencent.f.i.h() {
                /* class com.tencent.mm.plugin.appbrand.widget.tabbar.b.AnonymousClass1 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "Base64IconLoader";
                }

                public final void run() {
                    AppMethodBeat.i(135540);
                    try {
                        b bVar = b.this;
                        byte[] decode = Base64.decode(b.this.oFe, 0);
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                        if (decodeByteArray == null) {
                            bVar.oFf.a("Failed to load icon via base64 icon", bVar);
                        }
                        b.this.X(decodeByteArray);
                        AppMethodBeat.o(135540);
                    } catch (Exception e2) {
                        b.this.oFf.a("Failed to load icon via base64 icon", b.this);
                        AppMethodBeat.o(135540);
                    }
                }
            });
            AppMethodBeat.o(135541);
            return;
        }
        this.oFf.a("Failed to load icon via base64 icon", this);
        AppMethodBeat.o(135541);
    }
}
