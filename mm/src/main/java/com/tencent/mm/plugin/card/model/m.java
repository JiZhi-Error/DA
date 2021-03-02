package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public final class m implements s {
    public static final String pTN = (b.aKJ() + "card");
    public static final String pTO = (pTN + "/video");
    private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
    private String mPicUrl = null;

    static {
        AppMethodBeat.i(112795);
        AppMethodBeat.o(112795);
    }

    public m(String str) {
        this.mPicUrl = str;
    }

    @Override // com.tencent.mm.platformtools.s
    public final s.b blz() {
        return null;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(112791);
        String format = String.format("%s/%s", pTN, g.getMessageDigest(this.mPicUrl.getBytes()));
        AppMethodBeat.o(112791);
        return format;
    }

    public static String ajp(String str) {
        AppMethodBeat.i(112792);
        String format = String.format("%s/%s", pTN, g.getMessageDigest(str.getBytes()));
        AppMethodBeat.o(112792);
        return format;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blB() {
        return this.mPicUrl;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blC() {
        return this.mPicUrl;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String getCacheKey() {
        return this.mPicUrl;
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
        AppMethodBeat.i(112793);
        Log.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
        AppMethodBeat.o(112793);
        return null;
    }

    @Override // com.tencent.mm.platformtools.s
    public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
        AppMethodBeat.i(112794);
        if (s.a.NET == aVar) {
            try {
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
            } catch (IOException e2) {
                try {
                    o oVar = new o(blA());
                    if (!oVar.exists()) {
                        oVar.mkdirs();
                    }
                    Log.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
                    BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
                } catch (IOException e3) {
                    Log.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", e3, "", new Object[0]);
                    Log.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
                }
            }
        }
        Log.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", aVar.toString());
        AppMethodBeat.o(112794);
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
