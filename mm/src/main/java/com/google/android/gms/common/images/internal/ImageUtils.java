package com.google.android.gms.common.images.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public final class ImageUtils {
    public static Bitmap frameBitmapInCircle(Bitmap bitmap) {
        int i2;
        int i3;
        AppMethodBeat.i(11772);
        if (bitmap == null) {
            AppMethodBeat.o(11772);
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width >= height) {
            i3 = (height - width) / 2;
            i2 = 0;
        } else {
            i2 = (width - height) / 2;
            i3 = 0;
            height = width;
        }
        Bitmap createBitmap = Bitmap.createBitmap(height, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(WebView.NIGHT_MODE_COLOR);
        canvas.drawCircle((float) (height / 2), (float) (height / 2), (float) (height / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (float) i3, (float) i2, paint);
        AppMethodBeat.o(11772);
        return createBitmap;
    }

    public static Drawable frameDrawableInCircle(Resources resources, Drawable drawable) {
        Bitmap createBitmap;
        AppMethodBeat.i(11773);
        if (drawable == null) {
            createBitmap = null;
        } else if (drawable instanceof BitmapDrawable) {
            createBitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, frameBitmapInCircle(createBitmap));
        AppMethodBeat.o(11773);
        return bitmapDrawable;
    }
}
