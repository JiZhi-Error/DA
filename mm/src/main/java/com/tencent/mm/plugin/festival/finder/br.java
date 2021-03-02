package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.b;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalPrepareWishZoomInCoverView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "BLUR_COLOR", "", "BLUR_RADIUS", "", "RECT_RADIUS", "RECT_STROKE_COLOR", "RECT_STROKE_WIDTH", "blurMask", "Landroid/graphics/BlurMaskFilter;", "paint", "Landroid/graphics/Paint;", "rectF", "Landroid/graphics/RectF;", "vRect", "getVRect", "()Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "plugin-festival_release"})
public final class br extends View {
    private final int UwI;
    private final float UwJ;
    private final int UwK;
    private final float UwL;
    private final float UwM;
    private final BlurMaskFilter UwN = new BlurMaskFilter(this.UwJ, BlurMaskFilter.Blur.NORMAL);
    private final RectF hO = new RectF();
    private final Paint paint;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public br(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(262849);
        setClickable(false);
        setLayerType(1, null);
        this.UwI = b.n(context, R.color.agi);
        this.UwJ = (float) context.getResources().getDimensionPixelSize(R.dimen.arb);
        this.UwK = b.n(context, R.color.agj);
        this.UwL = (float) context.getResources().getDimensionPixelSize(R.dimen.arf);
        this.UwM = (float) context.getResources().getDimensionPixelSize(R.dimen.are);
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        this.paint = paint2;
        AppMethodBeat.o(262849);
    }

    public final RectF getVRect() {
        AppMethodBeat.i(262846);
        RectF rectF = new RectF(this.hO);
        AppMethodBeat.o(262846);
        return rectF;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(262847);
        super.onMeasure(i2, i3);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
        this.hO.set(this.UwJ, this.UwJ, ((float) getMeasuredWidth()) - this.UwJ, ((float) getMeasuredWidth()) - this.UwJ);
        AppMethodBeat.o(262847);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(262848);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        this.paint.setStrokeWidth(this.UwL);
        this.paint.setColor(this.UwI);
        this.paint.setMaskFilter(this.UwN);
        canvas.drawRoundRect(this.hO, this.UwM, this.UwM, this.paint);
        this.paint.setStrokeWidth(this.UwL);
        this.paint.setColor(this.UwK);
        this.paint.setMaskFilter(null);
        canvas.drawRoundRect(this.hO, this.UwM, this.UwM, this.paint);
        AppMethodBeat.o(262848);
    }
}
