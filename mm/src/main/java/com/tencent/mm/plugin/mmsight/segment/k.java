package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Locale;

public final class k implements d {
    private Canvas aTi = new Canvas();
    private int dstHeight;
    private int dstWidth;
    private Matrix gT;
    private Paint paint = new Paint(1);
    private Bitmap reuse = null;
    private MediaMetadataRetriever zyD;

    public k() {
        AppMethodBeat.i(107680);
        AppMethodBeat.o(107680);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public final void init(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(107681);
        if (i3 <= 0 || i4 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(Locale.CHINA, "destination width and height error, width %d, height %d", Integer.valueOf(i3), Integer.valueOf(i4)));
            AppMethodBeat.o(107681);
            throw illegalArgumentException;
        }
        try {
            this.zyD = new d();
            this.zyD.setDataSource(str);
        } catch (Exception e2) {
            Log.printErrStackTrace("MediaCodecThumbFetcher", e2, "init error:%s", e2.getMessage());
        }
        this.dstWidth = i3;
        this.dstHeight = i4;
        AppMethodBeat.o(107681);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public final void reuseBitmap(Bitmap bitmap) {
        this.reuse = bitmap;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public final Bitmap getFrameAtTime(long j2) {
        Bitmap bitmap;
        float f2;
        AppMethodBeat.i(107682);
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap frameAtTime = this.zyD.getFrameAtTime(1000 * j2);
        if (frameAtTime == null) {
            Log.w("MediaCodecThumbFetcher", "get frame fail at time:%s, rawBitmap is null", Long.valueOf(1000 * j2));
            AppMethodBeat.o(107682);
            return null;
        }
        int i2 = this.dstWidth;
        int i3 = this.dstHeight;
        if (frameAtTime == null || frameAtTime.isRecycled() || i2 <= 0 || i3 <= 0) {
            bitmap = null;
        } else {
            Log.d("MediaCodecThumbFetcher", "scaleBitmap(60) largeBitmap(width : %d, height : %d)", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
            Bitmap hb = hb(i2, i3);
            if (hb == null) {
                bitmap = null;
            } else {
                if (this.gT == null) {
                    int width = frameAtTime.getWidth();
                    int height = frameAtTime.getHeight();
                    Matrix matrix = new Matrix();
                    matrix.reset();
                    matrix.setTranslate(((float) (i2 - width)) / 2.0f, ((float) (i3 - height)) / 2.0f);
                    if (((float) height) / ((float) width) > ((float) i3) / ((float) i2)) {
                        f2 = ((float) i2) / ((float) width);
                    } else {
                        f2 = ((float) i3) / ((float) height);
                    }
                    matrix.postScale(f2, f2, ((float) i2) / 2.0f, ((float) i3) / 2.0f);
                    this.gT = matrix;
                }
                this.aTi.setBitmap(hb);
                this.aTi.drawBitmap(frameAtTime, this.gT, this.paint);
                bitmap = hb;
            }
        }
        frameAtTime.recycle();
        Log.d("MediaCodecThumbFetcher", "time flee : get video thumb bitmap cost time %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(107682);
        return bitmap;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public final int getDurationMs() {
        AppMethodBeat.i(107683);
        int duration = getDuration();
        AppMethodBeat.o(107683);
        return duration;
    }

    private int getDuration() {
        int i2 = 0;
        AppMethodBeat.i(107684);
        String extractMetadata = this.zyD.extractMetadata(9);
        if (extractMetadata == null) {
            AppMethodBeat.o(107684);
        } else {
            try {
                i2 = Integer.valueOf(extractMetadata).intValue();
                AppMethodBeat.o(107684);
            } catch (Exception e2) {
                Log.e("MediaCodecThumbFetcher", "getDuration error %s", e2.getMessage());
                AppMethodBeat.o(107684);
            }
        }
        return i2;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public final int getScaledWidth() {
        return this.dstWidth;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public final int getScaledHeight() {
        return this.dstHeight;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public final void release() {
        AppMethodBeat.i(107685);
        if (this.zyD != null) {
            this.zyD.release();
        }
        this.gT = null;
        this.paint = null;
        this.aTi = null;
        AppMethodBeat.o(107685);
    }

    private static Bitmap hb(int i2, int i3) {
        Bitmap bitmap;
        AppMethodBeat.i(107686);
        try {
            bitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e2) {
            Log.e("MediaCodecThumbFetcher", "%s OutOfMemory %s", f.apq(), e2.getMessage());
            System.gc();
            try {
                bitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            } catch (Exception e3) {
                Log.e("MediaCodecThumbFetcher", "%s try again Exception %s", f.apq(), e3.getMessage());
                bitmap = null;
            }
        }
        AppMethodBeat.o(107686);
        return bitmap;
    }
}
