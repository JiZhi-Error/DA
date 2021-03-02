package com.tencent.mm.plugin.shake.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class b implements s {
    private c.a DlR = null;
    private String thumburl = "";

    public b(c.a aVar) {
        this.DlR = aVar;
    }

    public b(String str) {
        this.thumburl = str;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(28617);
        if (this.DlR != null && this.DlR.field_thumburl != null) {
            String jP = m.jP(this.DlR.field_thumburl, "@S");
            AppMethodBeat.o(28617);
            return jP;
        } else if (this.thumburl != null) {
            String jP2 = m.jP(this.thumburl, "@S");
            AppMethodBeat.o(28617);
            return jP2;
        } else {
            AppMethodBeat.o(28617);
            return "";
        }
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blB() {
        if (this.DlR == null || this.DlR.field_thumburl == null) {
            return this.thumburl;
        }
        return this.DlR.field_thumburl;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blC() {
        AppMethodBeat.i(28618);
        String str = blB() + "_tv";
        AppMethodBeat.o(28618);
        return str;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String getCacheKey() {
        AppMethodBeat.i(28619);
        String str = blB() + "_tv";
        AppMethodBeat.o(28619);
        return str;
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
        AppMethodBeat.i(28620);
        if (s.a.NET == aVar) {
            try {
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.TVImgGetStrategy", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(28620);
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
        AppMethodBeat.i(28621);
        if (MMApplicationContext.getContext() == null) {
            AppMethodBeat.o(28621);
            return null;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
        AppMethodBeat.o(28621);
        return decodeResource;
    }

    @Override // com.tencent.mm.platformtools.s
    public final s.b blz() {
        return null;
    }
}
