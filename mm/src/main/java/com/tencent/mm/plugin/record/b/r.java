package com.tencent.mm.plugin.record.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

final class r implements s {
    private int height;
    private String tev;
    private String url;
    private int width;

    public r(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(27813);
        this.tev = str;
        this.url = str2;
        this.width = i2;
        this.height = i3;
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        o oVar = new o(sb.append(c.aTi()).append("web/").toString());
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(27813);
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(27814);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(c.aTi()).append("web/").append(g.getMessageDigest(this.url.getBytes())).toString();
        AppMethodBeat.o(27814);
        return sb2;
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
        AppMethodBeat.i(27815);
        Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjp);
        AppMethodBeat.o(27815);
        return decodeResource;
    }

    @Override // com.tencent.mm.platformtools.s
    public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
        AppMethodBeat.i(27816);
        if (s.a.NET == aVar) {
            try {
                Log.v("MicroMsg.FavGetPicStrategy", "handlerBitmap get from net url:%s", this.url);
                if (this.width > 0 && this.height > 0) {
                    bitmap = BitmapUtil.getCenterCropBitmap(bitmap, this.width, this.height, true);
                }
                o oVar = new o(blA());
                oVar.createNewFile();
                OutputStream outputStream = null;
                try {
                    outputStream = com.tencent.mm.vfs.s.ap(oVar);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
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
                    AppMethodBeat.o(27816);
                    throw th;
                }
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.FavGetPicStrategy", e3, "", new Object[0]);
            }
        }
        AppMethodBeat.o(27816);
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
        return null;
    }
}
