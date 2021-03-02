package com.tencent.mm.plugin.appbrand.luggage.a;

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
    private int mX;
    private int mY;

    public b(int i2, int i3, int i4, int i5) {
        boolean z = true;
        AppMethodBeat.i(134893);
        Assert.assertFalse(i4 == 0);
        Assert.assertFalse(i5 != 0 ? false : z);
        this.mX = i2;
        this.mY = i3;
        this.mWidth = i4;
        this.mHeight = i5;
        AppMethodBeat.o(134893);
    }

    @Override // com.tencent.mm.modelappbrand.a.b.h
    public final Bitmap J(Bitmap bitmap) {
        int i2;
        AppMethodBeat.i(134894);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(134894);
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = this.mX;
        int i4 = this.mY;
        if (this.mX < 0) {
            i3 = 0;
        } else if (this.mX > width) {
            i3 = width;
        }
        if (this.mY < 0) {
            i4 = 0;
        } else if (this.mY > height) {
            i4 = height;
        }
        int i5 = (this.mWidth + this.mX) - i3;
        int i6 = (this.mHeight + this.mY) - i4;
        if (i3 + i5 > width) {
            i5 = width - i3;
        }
        if (i4 + i6 > height) {
            i2 = height - i4;
        } else {
            i2 = i6;
        }
        if (i5 <= 0 || i2 <= 0) {
            Bitmap createBitmap = BitmapUtil.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            AppMethodBeat.o(134894);
            return createBitmap;
        }
        Bitmap createBitmap2 = BitmapUtil.createBitmap(i5, i2, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap2).drawBitmap(bitmap, new Rect(i3, i4, i3 + i5, i4 + i2), new Rect(0, 0, i5, i2), (Paint) null);
        AppMethodBeat.o(134894);
        return createBitmap2;
    }

    @Override // com.tencent.mm.modelappbrand.a.c
    public final String Lb() {
        AppMethodBeat.i(134895);
        String format = String.format("Transformation_x%s_y%s_w%s_h%s", Integer.valueOf(this.mX), Integer.valueOf(this.mY), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
        AppMethodBeat.o(134895);
        return format;
    }
}
