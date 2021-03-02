package com.tencent.mm.particles.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends b {
    private final Bitmap bitmap;
    private final float jJg;
    private final float jJh;

    public a(Bitmap bitmap2) {
        AppMethodBeat.i(151371);
        this.bitmap = bitmap2;
        this.jJg = ((float) bitmap2.getWidth()) / 2.0f;
        this.jJh = ((float) bitmap2.getHeight()) / 2.0f;
        AppMethodBeat.o(151371);
    }

    @Override // com.tencent.mm.particles.a.b
    public final int getWidth() {
        AppMethodBeat.i(151372);
        int width = this.bitmap.getWidth();
        AppMethodBeat.o(151372);
        return width;
    }

    @Override // com.tencent.mm.particles.a.b
    public final int getHeight() {
        AppMethodBeat.i(151373);
        int height = this.bitmap.getHeight();
        AppMethodBeat.o(151373);
        return height;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.particles.a.b
    public final void a(Canvas canvas, Matrix matrix, Paint paint, float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(151374);
        matrix.preTranslate(f2, f3);
        matrix.preRotate(f4, this.jJg, this.jJh);
        canvas.drawBitmap(this.bitmap, matrix, paint);
        AppMethodBeat.o(151374);
    }
}
