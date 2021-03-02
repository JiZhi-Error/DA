package com.tencent.mm.plugin.story.ui.view;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import com.tencent.mm.pluginsdk.ui.c;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "avatarDrawable", "Landroid/graphics/drawable/LayerDrawable;", "(Landroid/graphics/drawable/LayerDrawable;)V", "TAG", "", "centerX", "", "centerY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-story_release"})
public final class a extends b {
    private final LayerDrawable FAD;
    private final String TAG = "MicroMsg.CommentConfetti";
    private final int centerX = (this.FAD.getIntrinsicWidth() / 2);
    private final int centerY = (this.FAD.getIntrinsicHeight() / 2);

    public a(LayerDrawable layerDrawable) {
        p.h(layerDrawable, "avatarDrawable");
        AppMethodBeat.i(120006);
        this.FAD = layerDrawable;
        AppMethodBeat.o(120006);
    }

    @Override // com.tencent.mm.particles.a.b
    public final int getWidth() {
        AppMethodBeat.i(120003);
        int intrinsicWidth = this.FAD.getIntrinsicWidth();
        AppMethodBeat.o(120003);
        return intrinsicWidth;
    }

    @Override // com.tencent.mm.particles.a.b
    public final int getHeight() {
        AppMethodBeat.i(120004);
        int intrinsicHeight = this.FAD.getIntrinsicHeight();
        AppMethodBeat.o(120004);
        return intrinsicHeight;
    }

    @Override // com.tencent.mm.particles.a.b
    public final void a(Canvas canvas, Matrix matrix, Paint paint, float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(120005);
        p.h(canvas, "canvas");
        p.h(matrix, "matrix");
        p.h(paint, "paint");
        float f6 = 1.0f - f5;
        float f7 = 1.0f - f5;
        paint.setAlpha((int) (f7 * 255.0f));
        canvas.save();
        canvas.translate(f2, f3);
        canvas.scale(f6, f6);
        Drawable drawable = this.FAD.getDrawable(1);
        if (drawable == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.AvatarRoundDrawable");
            AppMethodBeat.o(120005);
            throw tVar;
        }
        ((c) drawable).aib((int) (f7 * 255.0f));
        this.FAD.draw(canvas);
        canvas.restore();
        AppMethodBeat.o(120005);
    }
}
