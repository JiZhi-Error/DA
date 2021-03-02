package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public final class g implements s {
    private int height;
    private String tev;
    private String url;
    private int width;

    public g(String str, String str2, int i2, int i3) {
        this.tev = str;
        this.url = str2;
        this.width = i2;
        this.height = i3;
    }

    @Override // com.tencent.mm.platformtools.s
    public final s.b blz() {
        return null;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(106733);
        String str = b.cUf() + com.tencent.mm.b.g.getMessageDigest(this.url.getBytes());
        AppMethodBeat.o(106733);
        return str;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blB() {
        return this.url;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blC() {
        return this.tev;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String getCacheKey() {
        return this.tev;
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
        AppMethodBeat.i(106734);
        Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjp);
        AppMethodBeat.o(106734);
        return decodeResource;
    }

    @Override // com.tencent.mm.platformtools.s
    public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
        AppMethodBeat.i(106735);
        if (s.a.NET == aVar) {
            try {
                Log.v("MicroMsg.FavGetPicStrategy", "handlerBitmap get from net url:%s", this.url);
                o oVar = new o(b.cUf());
                if (!oVar.exists()) {
                    oVar.mkdirs();
                }
                if (this.width > 0 && this.height > 0) {
                    bitmap = BitmapUtil.getCenterCropBitmap(bitmap, this.width, this.height, true);
                }
                o oVar2 = new o(blA());
                oVar2.createNewFile();
                OutputStream outputStream = null;
                try {
                    outputStream = com.tencent.mm.vfs.s.ap(oVar2);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                    outputStream.flush();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (FileNotFoundException e2) {
                    Log.printErrStackTrace("MicroMsg.FavGetPicStrategy", e2, "", new Object[0]);
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th) {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    AppMethodBeat.o(106735);
                    throw th;
                }
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.FavGetPicStrategy", e3, "", new Object[0]);
            }
        }
        AppMethodBeat.o(106735);
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
