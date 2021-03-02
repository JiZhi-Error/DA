package com.tencent.mm.plugin.appbrand.share;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import junit.framework.Assert;

public final class b implements b.h {
    private int mHeight;
    private int mWidth;

    public b(int i2, int i3) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(48317);
        if (i2 == 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertFalse(z);
        Assert.assertFalse(i3 != 0 ? false : z2);
        this.mWidth = i2;
        this.mHeight = i3;
        AppMethodBeat.o(48317);
    }

    @Override // com.tencent.mm.modelappbrand.a.b.h
    public final Bitmap J(Bitmap bitmap) {
        AppMethodBeat.i(48318);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(48318);
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = ((float) this.mHeight) / ((float) this.mWidth);
        Bitmap createBitmap = BitmapUtil.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        if (f2 <= ((float) height) / ((float) width)) {
            rect.right = width;
            rect.bottom = (int) (((float) width) * f2);
        } else {
            rect.right = (int) (((float) height) / f2);
            rect.bottom = height;
        }
        Rect rect2 = new Rect();
        rect2.left = 0;
        rect2.top = 0;
        rect2.right = this.mWidth;
        rect2.bottom = this.mHeight;
        canvas.drawBitmap(bitmap, rect, rect2, (Paint) null);
        AppMethodBeat.o(48318);
        return createBitmap;
    }

    @Override // com.tencent.mm.modelappbrand.a.c
    public final String Lb() {
        AppMethodBeat.i(48319);
        String format = String.format("Transformation_w%s_h%s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
        AppMethodBeat.o(48319);
        return format;
    }
}
