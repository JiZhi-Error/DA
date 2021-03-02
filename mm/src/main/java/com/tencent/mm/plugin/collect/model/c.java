package com.tencent.mm.plugin.collect.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class c implements s {
    private s.b qvE = new s.b() {
        /* class com.tencent.mm.plugin.collect.model.c.AnonymousClass1 */

        @Override // com.tencent.mm.platformtools.s.b
        public final Bitmap So(String str) {
            AppMethodBeat.i(63772);
            Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
            AppMethodBeat.o(63772);
            return decodeFile;
        }
    };
    private String url;

    public c(String str) {
        AppMethodBeat.i(63773);
        this.url = str;
        AppMethodBeat.o(63773);
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(63774);
        String aKj = b.aKj(this.url);
        AppMethodBeat.o(63774);
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
        AppMethodBeat.i(63775);
        if (s.a.NET == aVar) {
            try {
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, b.aKj(this.url), false);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(63775);
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
