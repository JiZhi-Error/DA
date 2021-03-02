package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends Canvas {
    public Bitmap mBitmap;

    public f() {
    }

    public f(Bitmap bitmap) {
        super(bitmap);
        this.mBitmap = bitmap;
    }

    public final void l(float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(144853);
        Bitmap bitmap = this.mBitmap;
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.mBitmap.getWidth(), (float) this.mBitmap.getHeight());
        RectF rectF2 = new RectF(f2, f3, f4, f5);
        Region.Op op = Region.Op.DIFFERENCE;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.clipRect(rectF);
        canvas.clipRect(rectF2, op);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (createBitmap != null && !createBitmap.isRecycled()) {
            this.mBitmap.eraseColor(0);
            drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
            createBitmap.recycle();
        }
        AppMethodBeat.o(144853);
    }

    public final void setBitmap(Bitmap bitmap) {
        AppMethodBeat.i(144854);
        super.setBitmap(bitmap);
        this.mBitmap = bitmap;
        AppMethodBeat.o(144854);
    }
}
