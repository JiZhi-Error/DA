package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class q implements s {
    private String mPicUrl = null;

    public q(String str) {
        this.mPicUrl = str;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(52068);
        String jP = j.eOR().jP(this.mPicUrl, "@S");
        AppMethodBeat.o(52068);
        return jP;
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
        return false;
    }

    @Override // com.tencent.mm.platformtools.s
    public final boolean blE() {
        return false;
    }

    @Override // com.tencent.mm.platformtools.s
    public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
        AppMethodBeat.i(52069);
        if (s.a.NET == aVar) {
            try {
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.ScannerGetPicStrategy", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(52069);
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
    public final Bitmap blF() {
        AppMethodBeat.i(52070);
        if (MMApplicationContext.getContext() == null) {
            AppMethodBeat.o(52070);
            return null;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
        AppMethodBeat.o(52070);
        return decodeResource;
    }

    @Override // com.tencent.mm.platformtools.s
    public final s.b blz() {
        return null;
    }
}
