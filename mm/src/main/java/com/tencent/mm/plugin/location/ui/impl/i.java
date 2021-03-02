package com.tencent.mm.plugin.location.ui.impl;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class i implements s {
    private String iconUrl;
    private s.b qvE = new s.b() {
        /* class com.tencent.mm.plugin.location.ui.impl.i.AnonymousClass2 */

        @Override // com.tencent.mm.platformtools.s.b
        public final Bitmap So(String str) {
            AppMethodBeat.i(56142);
            Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
            AppMethodBeat.o(56142);
            return decodeFile;
        }
    };

    public i(String str) {
        AppMethodBeat.i(56143);
        this.iconUrl = str;
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.location.ui.impl.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(56141);
                if (!com.tencent.mm.vfs.s.YS(i.eea())) {
                    com.tencent.mm.vfs.s.boN(i.eea());
                }
                AppMethodBeat.o(56141);
            }
        });
        AppMethodBeat.o(56143);
    }

    public static String eea() {
        AppMethodBeat.i(56144);
        String str = b.aKJ() + "taxi_icon";
        AppMethodBeat.o(56144);
        return str;
    }

    @Override // com.tencent.mm.platformtools.s
    public final s.b blz() {
        return this.qvE;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(56145);
        String format = String.format("%s/%s", eea(), com.tencent.mm.b.g.getMessageDigest(this.iconUrl.getBytes()));
        AppMethodBeat.o(56145);
        return format;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blB() {
        return this.iconUrl;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blC() {
        return this.iconUrl;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String getCacheKey() {
        return this.iconUrl;
    }

    @Override // com.tencent.mm.platformtools.s
    public final boolean blD() {
        return true;
    }

    @Override // com.tencent.mm.platformtools.s
    public final boolean blE() {
        return false;
    }

    @Override // com.tencent.mm.platformtools.s
    public final Bitmap blF() {
        return null;
    }

    @Override // com.tencent.mm.platformtools.s
    public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
        AppMethodBeat.i(56146);
        if (s.a.NET == aVar) {
            if (bitmap == null || bitmap.getNinePatchChunk() == null) {
                try {
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
                } catch (IOException e2) {
                    try {
                        com.tencent.mm.vfs.s.boN(eea());
                        Log.w("MicroMsg.TaxiWeappIconStrategy", "retry saving bitmap.");
                        BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
                    } catch (IOException e3) {
                        Log.printErrStackTrace("MicroMsg.TaxiWeappIconStrategy", e3, "", new Object[0]);
                        Log.w("MicroMsg.TaxiWeappIconStrategy", "save bitmap fail.");
                    }
                }
            } else {
                Log.v("MicroMsg.TaxiWeappIconStrategy", "get ninePatch chChunk.");
                com.tencent.mm.vfs.s.nw(str, blA());
                AppMethodBeat.o(56146);
                return bitmap;
            }
        }
        Log.d("MicroMsg.TaxiWeappIconStrategy", "get bitmap, from %s.", aVar.toString());
        AppMethodBeat.o(56146);
        return bitmap;
    }

    @Override // com.tencent.mm.platformtools.s
    public final void blG() {
    }

    @Override // com.tencent.mm.platformtools.s
    public final void ad(String str, boolean z) {
    }

    @Override // com.tencent.mm.platformtools.s
    public final void a(s.a aVar, String str) {
    }
}
