package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq {
    public static Bitmap a(Bitmap bitmap, float f2) {
        AppMethodBeat.i(159110);
        if (bitmap == null || bitmap.isRecycled()) {
            as.e("WeUIBitmapUtil", "getRoundedCornerBitmap in bitmap is null", new Object[0]);
            AppMethodBeat.o(159110);
            return null;
        }
        Bitmap j2 = j(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (j2 == null) {
            AppMethodBeat.o(159110);
            return null;
        }
        Canvas canvas = new Canvas(j2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-4144960);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        as.i("WeUIBitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", bitmap);
        bitmap.recycle();
        AppMethodBeat.o(159110);
        return j2;
    }

    private static Bitmap j(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(159111);
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(i2, i3, config);
        } catch (Throwable th) {
        }
        AppMethodBeat.o(159111);
        return bitmap;
    }
}
