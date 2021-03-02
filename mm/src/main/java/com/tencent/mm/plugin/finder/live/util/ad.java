package com.tencent.mm.plugin.finder.live.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJR\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0016J4\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/FinderLiveSysTagSpan;", "Landroid/text/style/ReplacementSpan;", "bgColor", "", "textColor", "extraBottom", "contentSize", "", "(IIIF)V", "getBgColor", "()I", "setBgColor", "(I)V", "getContentSize", "()F", "getExtraBottom", "setExtraBottom", "getTextColor", "setTextColor", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "getSizePadding", "plugin-finder_release"})
public final class ad extends ReplacementSpan {
    private int UNj;
    private final float UNk;
    private int bgColor;
    private int textColor;

    private ad(int i2, int i3, int i4, float f2) {
        this.bgColor = i2;
        this.textColor = i3;
        this.UNj = i4;
        this.UNk = f2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ad(int i2, int i3, int i4, float f2, int i5) {
        this(i2, i3, (i5 & 4) != 0 ? 0 : i4, (i5 & 8) != 0 ? 12.0f : f2);
        AppMethodBeat.i(260757);
        AppMethodBeat.o(260757);
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(260755);
        p.h(paint, "paint");
        int measureText = (int) (paint.measureText(charSequence, i2, i3) + ((float) d.e(MMApplicationContext.getContext(), 15.0f)) + 0.0f);
        AppMethodBeat.o(260755);
        return measureText;
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        CharSequence charSequence2;
        AppMethodBeat.i(260756);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        int color = paint.getColor();
        float textSize = paint.getTextSize();
        paint.setColor(this.bgColor);
        paint.setTextSize((float) d.e(MMApplicationContext.getContext(), this.UNk));
        canvas.drawRoundRect(new RectF(f2, (((float) i4) - 4.0f) + ((float) this.UNj), ((float) (((int) paint.measureText(charSequence, i2, i3)) + 40)) + f2, (float) ((i6 + 4) - this.UNj)), 45.0f, 45.0f, paint);
        paint.setColor(this.textColor);
        if (charSequence != null) {
            charSequence2 = charSequence;
        }
        canvas.drawText(charSequence2, i2, i3, f2 + 20.0f, (float) i5, paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
        AppMethodBeat.o(260756);
    }
}
