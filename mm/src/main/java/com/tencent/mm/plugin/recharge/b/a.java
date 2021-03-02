package com.tencent.mm.plugin.recharge.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.wallet_core.c;
import java.io.IOException;

public final class a implements s {
    private static final String pTN = c.hgG();
    private String url;

    public a(String str) {
        this.url = str;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(67329);
        String str = this.url;
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.WalletGetPicStrategy", "getStoragePath: but url is null");
            AppMethodBeat.o(67329);
            return null;
        }
        String format = String.format("%s/%s", pTN, g.getMessageDigest(str.getBytes()));
        AppMethodBeat.o(67329);
        return format;
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
        AppMethodBeat.i(67330);
        if (s.a.NET == aVar) {
            try {
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
            } catch (IOException e2) {
                try {
                    o oVar = new o(pTN);
                    if (!oVar.exists()) {
                        oVar.mkdirs();
                    }
                    Log.w("MicroMsg.WalletGetPicStrategy", " retry saving bitmap");
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
                } catch (IOException e3) {
                    Log.printErrStackTrace("MicroMsg.WalletGetPicStrategy", e3, "", new Object[0]);
                    Log.w("MicroMsg.WalletGetPicStrategy", "save bitmap fail");
                }
            }
        }
        Log.d("MicroMsg.WalletGetPicStrategy", "get bitmap, from %s", aVar.toString());
        AppMethodBeat.o(67330);
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

    static {
        AppMethodBeat.i(67331);
        AppMethodBeat.o(67331);
    }

    @Override // com.tencent.mm.platformtools.s
    public final s.b blz() {
        return null;
    }
}
