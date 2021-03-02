package com.tencent.mm.plugin.finder.live.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J4\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/RoundBackgroundSpan;", "Landroid/text/style/ReplacementSpan;", "config", "Lcom/tencent/mm/plugin/finder/live/model/RoundBackgroundSpan$Config;", "(Lcom/tencent/mm/plugin/finder/live/model/RoundBackgroundSpan$Config;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "Config", "plugin-finder_release"})
public final class u extends ReplacementSpan {
    private final a ukf;

    public u(a aVar) {
        p.h(aVar, "config");
        AppMethodBeat.i(246279);
        this.ukf = aVar;
        AppMethodBeat.o(246279);
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(246277);
        p.h(paint, "paint");
        float textSize = paint.getTextSize();
        paint.setTextSize((float) this.ukf.textSize);
        int measureText = (int) (paint.measureText(charSequence, i2, i3) + this.ukf.ujl + this.ukf.ujm + this.ukf.leftMargin + this.ukf.rightMargin);
        paint.setTextSize(textSize);
        AppMethodBeat.o(246277);
        return measureText;
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        CharSequence charSequence2;
        AppMethodBeat.i(246278);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        if (charSequence != null) {
            charSequence2 = charSequence;
        }
        int color = paint.getColor();
        float textSize = paint.getTextSize();
        paint.setTextSize((float) this.ukf.textSize);
        paint.setColor(this.ukf.bgColor);
        canvas.drawRoundRect(new RectF(f2, (float) i4, paint.measureText(charSequence2, i2, i3) + this.ukf.ujl + this.ukf.ujm + f2, (float) i6), this.ukf.radius, this.ukf.radius, paint);
        paint.setColor(this.ukf.textColor);
        canvas.drawText(charSequence2, i2, i3, f2 + this.ukf.ujl, (Math.abs(paint.ascent() + paint.descent()) / 2.0f) + ((float) ((i6 - i4) / 2)) + 1.0f, paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
        AppMethodBeat.o(246278);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0002\u0010\u0010R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/RoundBackgroundSpan$Config;", "", "leftPading", "", "rightPading", "topPading", "bottomPading", "leftMargin", "rightMargin", "topMargin", "bottomMargin", "radius", "bgColor", "", "textColor", "textSize", "(FFFFFFFFFIII)V", "getBgColor", "()I", "getBottomMargin", "()F", "getBottomPading", "getLeftMargin", "getLeftPading", "getRadius", "getRightMargin", "getRightPading", "getTextColor", "getTextSize", "getTopMargin", "getTopPading", "plugin-finder_release"})
    public static final class a {
        final int bgColor;
        private final float bottomMargin = 0.0f;
        final float leftMargin;
        final float radius;
        final float rightMargin = 0.0f;
        final int textColor;
        final int textSize;
        private final float topMargin = 0.0f;
        final float ujl;
        final float ujm;
        private final float ukg;
        private final float ukh;

        public a(float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3, int i4) {
            this.ujl = f2;
            this.ujm = f3;
            this.ukg = f4;
            this.ukh = f5;
            this.leftMargin = f6;
            this.radius = f7;
            this.bgColor = i2;
            this.textColor = i3;
            this.textSize = i4;
        }
    }
}
