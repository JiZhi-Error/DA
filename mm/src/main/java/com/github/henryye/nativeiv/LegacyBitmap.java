package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.a.b;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class LegacyBitmap implements IBitmap<Bitmap> {
    private Bitmap baI = null;
    private long lastDecodeUsing = -1;

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Keep
    public BitmapType getType() {
        return BitmapType.Legacy;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    public long getDecodeTime() {
        return this.lastDecodeUsing;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Keep
    public Bitmap provide() {
        return this.baI;
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    @Keep
    public void recycle() {
        AppMethodBeat.i(127350);
        if (this.baI != null) {
            this.baI.recycle();
        }
        AppMethodBeat.o(127350);
    }

    @Override // com.github.henryye.nativeiv.bitmap.IBitmap
    public void decodeInputStream(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, c cVar) {
        AppMethodBeat.i(127349);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.baI = a(inputStream, imageDecodeConfig, cVar);
        this.lastDecodeUsing = SystemClock.elapsedRealtime() - elapsedRealtime;
        AppMethodBeat.o(127349);
    }

    /* access modifiers changed from: protected */
    public Bitmap a(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, c cVar) {
        Bitmap bitmap;
        AppMethodBeat.i(219804);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = imageDecodeConfig.mConfig;
        options.inPremultiplied = imageDecodeConfig.mPremultiplyAlpha;
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        if (decodeStream == null || decodeStream.getConfig() == Bitmap.Config.ARGB_8888) {
            bitmap = decodeStream;
        } else {
            b.w("Ni.LegacyBitmap", "hy: config not argb-8888", new Object[0]);
            bitmap = Bitmap.createBitmap(decodeStream.getWidth(), decodeStream.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(bitmap).drawBitmap(decodeStream, 0.0f, 0.0f, (Paint) null);
            decodeStream.recycle();
        }
        AppMethodBeat.o(219804);
        return bitmap;
    }
}
