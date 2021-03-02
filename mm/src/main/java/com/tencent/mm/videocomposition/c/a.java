package com.tencent.mm.videocomposition.c;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/videocomposition/sdk/BitmapUtil;", "", "()V", "TAG", "", "calculateInSampleSize", "", "originWidth", "originHeight", "reqWidth", "reqHeight", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "Landroid/graphics/Bitmap;", "temBmp", "degree", "", "video_composition_release"})
public final class a {
    public static final a Rig = new a();

    static {
        AppMethodBeat.i(216860);
        AppMethodBeat.o(216860);
    }

    private a() {
    }

    public static int calculateInSampleSize(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(216858);
        int i6 = 1;
        if (i2 > i5 || i3 > i4) {
            if (i3 > i2) {
                i6 = Math.round((((float) i2) / ((float) i5)) + 0.5f);
            } else {
                i6 = Math.round((((float) i3) / ((float) i4)) + 0.5f);
            }
            while ((((float) i3) * ((float) i2)) / ((float) (i6 * i6)) > ((float) (i4 * i5)) * 2.0f) {
                i6++;
            }
        }
        AppMethodBeat.o(216858);
        return i6;
    }

    public static Bitmap rotate(Bitmap bitmap, float f2) {
        boolean z;
        AppMethodBeat.i(216859);
        if (bitmap == null || f2 % 360.0f == 0.0f) {
            AppMethodBeat.o(216859);
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(f2, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            StringBuilder sb = new StringBuilder("resultBmp is null: ");
            if (createBitmap == null) {
                z = true;
            } else {
                z = false;
            }
            b.d("BitmapUtil", sb.append(z).append("  degree:").append(f2).toString(), new Object[0]);
            if (!p.j(bitmap, createBitmap)) {
                b.i("BitmapUtil", "rotate bitmap recycle ajsdfasdf adsf. %s", bitmap);
                bitmap.recycle();
            }
            AppMethodBeat.o(216859);
            return createBitmap;
        } catch (Throwable th) {
            b.d("BitmapUtil", "createBitmap failed : %s ", e.stackTraceToString(th));
            AppMethodBeat.o(216859);
            return bitmap;
        }
    }
}
