package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class i extends d {
    public i(String str, c cVar, s sVar) {
        super(str, cVar, sVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.d
    public final void cdf() {
        AppMethodBeat.i(135550);
        if (this.kGT.getFileSystem() == null || this.oFe == null) {
            this.oFf.a("Failed to load icon via temp file", this);
            AppMethodBeat.o(135550);
            return;
        }
        h.RTc.aX(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.appbrand.widget.tabbar.i.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "TempFileIconLoader";
            }

            public final void run() {
                AppMethodBeat.i(135549);
                o VY = i.this.kGT.getFileSystem().VY(i.this.oFe);
                if (VY == null) {
                    i.this.oFf.a("Failed to load icon via temp file", i.this);
                    AppMethodBeat.o(135549);
                    return;
                }
                Bitmap decodeFile = BitmapFactory.decodeFile(aa.z(VY.mUri));
                if (decodeFile != null) {
                    i.this.X(decodeFile);
                    AppMethodBeat.o(135549);
                    return;
                }
                i.this.oFf.a("Failed to load icon via temp file", i.this);
                AppMethodBeat.o(135549);
            }
        });
        AppMethodBeat.o(135550);
    }
}
