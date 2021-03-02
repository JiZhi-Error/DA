package com.tencent.mm.live.view.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import kotlin.g.b.p;
import kotlin.j.c;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J@\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0014J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fXD¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "needHalfAlpha", "", "(Landroid/graphics/Bitmap;Z)V", "TAG", "", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "getNeedHalfAlpha", "()Z", "setNeedHalfAlpha", "(Z)V", "scaleMax", "", "slope", "split", "turningY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-logic_release"})
public final class a extends b {
    private final String TAG;
    private final Bitmap bitmap;
    private final int centerX;
    private final int centerY;
    private final int hXN;
    private final float hXO;
    private final float hXP;
    private final int hXQ;
    private boolean hXR;

    public /* synthetic */ a(Bitmap bitmap2) {
        this(bitmap2, false);
    }

    public a(Bitmap bitmap2, boolean z) {
        p.h(bitmap2, "bitmap");
        AppMethodBeat.i(208693);
        this.bitmap = bitmap2;
        this.hXR = z;
        this.TAG = "MicroMsg.LiveLikeConfetti";
        this.centerX = this.bitmap.getWidth() / 2;
        this.centerY = this.bitmap.getHeight() / 2;
        this.hXN = c.SYP.nextInt(0, 2);
        this.hXO = 0.685f;
        this.hXP = 1.4f;
        this.hXQ = 250;
        AppMethodBeat.o(208693);
    }

    @Override // com.tencent.mm.particles.a.b
    public final int getWidth() {
        AppMethodBeat.i(208690);
        int width = this.bitmap.getWidth();
        AppMethodBeat.o(208690);
        return width;
    }

    @Override // com.tencent.mm.particles.a.b
    public final int getHeight() {
        AppMethodBeat.i(208691);
        int height = this.bitmap.getHeight();
        AppMethodBeat.o(208691);
        return height;
    }

    @Override // com.tencent.mm.particles.a.b
    public final void a(Canvas canvas, Matrix matrix, Paint paint, float f2, float f3, float f4, float f5) {
        float max;
        float bkP;
        AppMethodBeat.i(208692);
        p.h(canvas, "canvas");
        p.h(matrix, "matrix");
        p.h(paint, "paint");
        if (f5 <= this.hXO) {
            max = Math.max(f5 / (this.hXO / this.hXP), 0.5f);
        } else {
            max = Math.max((1.0f - f5) / ((1.0f - this.hXO) / this.hXP), 0.5f);
        }
        int alpha = paint.getAlpha();
        if (f3 > bkQ() - ((float) this.hXQ)) {
            bkP = bkP();
        } else {
            bkP = bkP() - ((((float) this.hXN) * 0.5f) * ((bkQ() - ((float) this.hXQ)) - f3));
        }
        matrix.preTranslate(bkP, f3);
        matrix.preScale(max, max, (float) this.centerX, (float) this.centerY);
        paint.setAlpha((int) ((this.hXR ? 0.5f : 1.0f) * 255.0f));
        canvas.drawBitmap(this.bitmap, matrix, paint);
        paint.setAlpha(alpha);
        AppMethodBeat.o(208692);
    }
}
