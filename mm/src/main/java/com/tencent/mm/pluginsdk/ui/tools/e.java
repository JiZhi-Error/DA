package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public final class e implements s {
    private int height = 0;
    private String tev;
    private String url;
    private int width = 0;

    public e(String str, String str2) {
        this.tev = str;
        this.url = str2;
    }

    @Override // com.tencent.mm.platformtools.s
    public final String blA() {
        AppMethodBeat.i(152382);
        String str = d.aSY() + FilePathGenerator.ANDROID_DIR_SEP + g.getMessageDigest(this.url.getBytes());
        AppMethodBeat.o(152382);
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
        AppMethodBeat.i(152383);
        Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bjp);
        AppMethodBeat.o(152383);
        return decodeResource;
    }

    @Override // com.tencent.mm.platformtools.s
    public final Bitmap a(Bitmap bitmap, s.a aVar, String str) {
        AppMethodBeat.i(152384);
        if (s.a.NET == aVar) {
            try {
                Log.v("MicroMsg.DefaultPicStrategy", "handlerBitmap get from net url:%s", this.url);
                if (this.width > 0 && this.height > 0) {
                    bitmap = BitmapUtil.getCenterCropBitmap(bitmap, this.width, this.height, true);
                }
                o oVar = new o(blA());
                oVar.createNewFile();
                OutputStream outputStream = null;
                try {
                    outputStream = com.tencent.mm.vfs.s.ap(oVar);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                    outputStream.flush();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (FileNotFoundException e2) {
                    Log.printErrStackTrace("MicroMsg.DefaultPicStrategy", e2, "", new Object[0]);
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th) {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    AppMethodBeat.o(152384);
                    throw th;
                }
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.DefaultPicStrategy", e3, "", new Object[0]);
            }
        }
        AppMethodBeat.o(152384);
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
