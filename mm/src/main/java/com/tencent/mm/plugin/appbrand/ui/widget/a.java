package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class a implements b.h {
    private final int gCk;
    private final int gCm;
    private final int gCn;

    public a(int i2, int i3, int i4) {
        this.gCk = i2;
        this.gCm = i3;
        this.gCn = i4;
    }

    @Override // com.tencent.mm.modelappbrand.a.b.h
    public final Bitmap J(Bitmap bitmap) {
        AppMethodBeat.i(121083);
        Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) (bitmap.getWidth() / 2), false);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(roundedCornerBitmap, this.gCk, this.gCk, false);
        if (roundedCornerBitmap != createScaledBitmap) {
            l.aRY().x(roundedCornerBitmap);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.gCk + (this.gCm * 2), this.gCk + (this.gCm * 2), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(createScaledBitmap, (float) this.gCm, (float) this.gCm, new Paint());
        l.aRY().x(createScaledBitmap);
        Paint paint = new Paint();
        paint.setColor(this.gCn);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) this.gCm);
        canvas.drawCircle((float) ((this.gCk / 2) + this.gCm), (float) ((this.gCk / 2) + this.gCm), (float) (this.gCk / 2), paint);
        AppMethodBeat.o(121083);
        return createBitmap;
    }

    @Override // com.tencent.mm.modelappbrand.a.c
    public final String Lb() {
        return "WxaNearbyShowcaseIcon";
    }
}
