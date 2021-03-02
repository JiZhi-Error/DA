package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class c implements s {
    private s.b qvE = new s.b() {
        /* class com.tencent.mm.plugin.wallet_core.ui.view.c.AnonymousClass1 */

        @Override // com.tencent.mm.platformtools.s.b
        public final Bitmap So(String str) {
            AppMethodBeat.i(71511);
            Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
            AppMethodBeat.o(71511);
            return decodeFile;
        }
    };
    private String url;

    public c(String str) {
        AppMethodBeat.i(71512);
        this.url = str;
        AppMethodBeat.o(71512);
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(71513);
        String aKj = b.aKj(this.url);
        AppMethodBeat.o(71513);
        return aKj;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blB() {
        return this.url;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blC() {
        return this.url;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String getCacheKey() {
        return this.url;
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
        AppMethodBeat.i(71514);
        if (s.a.NET == aVar) {
            if (bitmap == null || bitmap.getNinePatchChunk() == null) {
                try {
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, b.aKj(this.url), false);
                } catch (IOException e2) {
                    try {
                        com.tencent.mm.vfs.s.boN(b.fSn());
                        Log.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
                        BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, b.aKj(this.url), false);
                    } catch (IOException e3) {
                        Log.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e3, "", new Object[0]);
                        Log.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
                    }
                }
            } else {
                Log.v("MicroMsg.WalletGetPicStrategy", " get the ninePathchChunk");
                com.tencent.mm.vfs.s.nw(str, b.aKj(this.url));
                AppMethodBeat.o(71514);
                return bitmap;
            }
        }
        Log.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", aVar.toString());
        AppMethodBeat.o(71514);
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

    @Override // com.tencent.mm.platformtools.s
    public final s.b blz() {
        return this.qvE;
    }
}
