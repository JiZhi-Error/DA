package com.tencent.mm.plugin.story.ui.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import java.util.Random;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J@\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0014J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/CommentSmallConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "TAG", "", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "startX", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "reset", "plugin-story_release"})
public final class d extends b {
    private final String TAG = "MicroMsg.CommentSmallConfetti";
    private final Bitmap bitmap;
    private final int centerX = (this.bitmap.getWidth() / 2);
    private final int centerY = (this.bitmap.getHeight() / 2);
    private int startX;

    public d(Bitmap bitmap2) {
        p.h(bitmap2, "bitmap");
        AppMethodBeat.i(120042);
        this.bitmap = bitmap2;
        this.startX = new Random().nextBoolean() ? this.centerX : -this.centerX;
        AppMethodBeat.o(120042);
    }

    @Override // com.tencent.mm.particles.a.b
    public final void reset() {
        AppMethodBeat.i(120038);
        super.reset();
        this.startX = new Random().nextBoolean() ? this.centerX : -this.centerX;
        AppMethodBeat.o(120038);
    }

    @Override // com.tencent.mm.particles.a.b
    public final int getWidth() {
        AppMethodBeat.i(120039);
        int width = this.bitmap.getWidth();
        AppMethodBeat.o(120039);
        return width;
    }

    @Override // com.tencent.mm.particles.a.b
    public final int getHeight() {
        AppMethodBeat.i(120040);
        int height = this.bitmap.getHeight();
        AppMethodBeat.o(120040);
        return height;
    }

    @Override // com.tencent.mm.particles.a.b
    public final void a(Canvas canvas, Matrix matrix, Paint paint, float f2, float f3, float f4, float f5) {
        float f6 = 1.0f;
        AppMethodBeat.i(120041);
        p.h(canvas, "canvas");
        p.h(matrix, "matrix");
        p.h(paint, "paint");
        if (((double) f5) > 0.8d) {
            f6 = (1.0f - f5) / 0.2f;
        }
        int alpha = paint.getAlpha();
        matrix.preTranslate(f2, f3);
        matrix.preScale(0.5f, 0.5f, (float) this.centerX, (float) this.centerY);
        paint.setAlpha((int) (f6 * 255.0f));
        canvas.drawBitmap(this.bitmap, matrix, paint);
        paint.setAlpha(alpha);
        AppMethodBeat.o(120041);
    }
}
