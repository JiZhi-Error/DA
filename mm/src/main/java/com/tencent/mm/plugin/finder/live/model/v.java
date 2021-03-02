package com.tencent.mm.plugin.finder.live.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JR\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Config;", "(Landroid/graphics/drawable/Drawable;Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Config;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "Companion", "Config", "plugin-finder_release"})
public final class v extends ImageSpan {
    public static final a ukj = new a((byte) 0);
    private final b uki;

    static {
        AppMethodBeat.i(246283);
        AppMethodBeat.o(246283);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(Drawable drawable, b bVar) {
        super(drawable);
        p.h(drawable, "drawable");
        p.h(bVar, "config");
        AppMethodBeat.i(246282);
        this.uki = bVar;
        AppMethodBeat.o(246282);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Companion;", "", "()V", "generateDrawable", "Landroid/graphics/drawable/Drawable;", "spanStr", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        AppMethodBeat.i(246281);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        int color = paint.getColor();
        float textSize = paint.getTextSize();
        paint.setTextSize((float) this.uki.textSize);
        paint.setColor(this.uki.bgColor);
        canvas.drawRoundRect(new RectF(f2, (float) i4, paint.measureText(this.uki.text, i2, i3) + this.uki.ujl + this.uki.ujm + f2, (float) i6), this.uki.radius, this.uki.radius, paint);
        paint.setColor(this.uki.textColor);
        canvas.drawText(this.uki.text, i2, i3, f2 + this.uki.ujl, (Math.abs(paint.ascent() + paint.descent()) / 2.0f) + ((float) ((i6 - i4) / 2)) + 1.0f, paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
        AppMethodBeat.o(246281);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0002\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Config;", "", "text", "", "leftPading", "", "rightPading", "topPading", "bottomPading", "leftMargin", "rightMargin", "topMargin", "bottomMargin", "radius", "bgColor", "", "textColor", "textSize", "(Ljava/lang/CharSequence;FFFFFFFFFIII)V", "getBgColor", "()I", "getBottomMargin", "()F", "getBottomPading", "getLeftMargin", "getLeftPading", "getRadius", "getRightMargin", "getRightPading", "getText", "()Ljava/lang/CharSequence;", "getTextColor", "getTextSize", "getTopMargin", "getTopPading", "plugin-finder_release"})
    public static final class b {
        final int bgColor;
        private final float bottomMargin = 0.0f;
        private final float leftMargin;
        final float radius;
        private final float rightMargin = 0.0f;
        final CharSequence text;
        final int textColor;
        final int textSize;
        private final float topMargin = 0.0f;
        final float ujl;
        final float ujm;
        private final float ukg;
        private final float ukh;

        public b(CharSequence charSequence, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3, int i4) {
            p.h(charSequence, "text");
            AppMethodBeat.i(246280);
            this.text = charSequence;
            this.ujl = f2;
            this.ujm = f3;
            this.ukg = f4;
            this.ukh = f5;
            this.leftMargin = f6;
            this.radius = f7;
            this.bgColor = i2;
            this.textColor = i3;
            this.textSize = i4;
            AppMethodBeat.o(246280);
        }
    }
}
