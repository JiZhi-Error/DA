package com.tencent.mm.plugin.game.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public final class ai implements s {
    protected String mPicUrl;

    public ai(String str) {
        AppMethodBeat.i(41574);
        this.mPicUrl = str;
        o oVar = new o(b.aKO());
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(41574);
    }

    @Override // com.tencent.mm.platformtools.s
    public final s.b blz() {
        return null;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(41575);
        String str = b.aKO() + g.getMessageDigest(this.mPicUrl.getBytes());
        AppMethodBeat.o(41575);
        return str;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blB() {
        return this.mPicUrl;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blC() {
        AppMethodBeat.i(41576);
        String sb = new StringBuilder().append(this.mPicUrl.hashCode()).toString();
        AppMethodBeat.o(41576);
        return sb;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String getCacheKey() {
        AppMethodBeat.i(41577);
        String sb = new StringBuilder().append(this.mPicUrl.hashCode()).toString();
        AppMethodBeat.o(41577);
        return sb;
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
        AppMethodBeat.i(41578);
        Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjn);
        AppMethodBeat.o(41578);
        return decodeResource;
    }

    @Override // com.tencent.mm.platformtools.s
    public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
        AppMethodBeat.i(41579);
        if (s.a.DISK == aVar) {
            AppMethodBeat.o(41579);
        } else {
            try {
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.GetGamePicStrategy", e2, "", new Object[0]);
            }
            AppMethodBeat.o(41579);
        }
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
