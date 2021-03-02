package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "Landroid/support/v7/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mBgColor", "", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "radius", "", "rectF", "Landroid/graphics/RectF;", "drawBg", "", "canvas", "Landroid/graphics/Canvas;", "onDraw", "setTextBackground", "color", "plugin-recordvideo_release"})
public final class PhotoTextView extends AppCompatTextView {
    private final RectF hO = new RectF();
    private final Path lR = new Path();
    private int mBgColor;
    private final Paint paint = new Paint();
    private final float radius;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(237745);
        this.radius = (float) a.fromDPToPix(context, 12);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setAntiAlias(true);
        AppMethodBeat.o(237745);
    }

    public final void setTextBackground(int i2) {
        AppMethodBeat.i(237743);
        this.mBgColor = i2;
        invalidate();
        AppMethodBeat.o(237743);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        boolean z;
        AppMethodBeat.i(237744);
        p.h(canvas, "canvas");
        if (this.mBgColor != 0) {
            CharSequence text = getText();
            if (text == null || text.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                this.paint.setColor(this.mBgColor);
                float f2 = this.radius * 2.0f;
                this.lR.reset();
                if (getLineCount() != 0) {
                    float lineBottom = ((float) getLayout().getLineBottom(getLineCount() - 1)) + ((float) getPaddingTop()) + ((float) getPaddingBottom());
                    if (getLineCount() == 1) {
                        this.hO.set(0.0f, 0.0f, getLayout().getLineWidth(0) + ((float) getPaddingLeft()) + ((float) getPaddingRight()), lineBottom);
                        this.lR.addRoundRect(this.hO, this.radius, this.radius, Path.Direction.CW);
                    } else {
                        float measuredWidth = (float) getMeasuredWidth();
                        float lineWidth = getLayout().getLineWidth(getLineCount() - 1);
                        if (lineWidth >= ((measuredWidth - f2) - ((float) getPaddingLeft())) - ((float) getPaddingRight())) {
                            this.hO.set(0.0f, 0.0f, measuredWidth, lineBottom);
                            this.lR.addRoundRect(this.hO, this.radius, this.radius, Path.Direction.CW);
                        } else {
                            float lineTop = ((float) getLayout().getLineTop(getLineCount() - 1)) + ((float) getPaddingTop()) + ((float) getPaddingBottom());
                            float paddingRight = lineWidth + ((float) getPaddingRight()) + ((float) getPaddingLeft());
                            this.lR.moveTo(0.0f, this.radius);
                            this.hO.set(0.0f, 0.0f, f2, f2);
                            this.lR.arcTo(this.hO, 180.0f, 90.0f);
                            this.lR.lineTo(measuredWidth - f2, 0.0f);
                            this.hO.set(measuredWidth - f2, 0.0f, measuredWidth, f2);
                            this.lR.arcTo(this.hO, 270.0f, 90.0f);
                            this.lR.lineTo(measuredWidth, lineTop - this.radius);
                            this.hO.set(measuredWidth - f2, lineTop - f2, measuredWidth, lineTop);
                            this.lR.arcTo(this.hO, 0.0f, 90.0f);
                            this.lR.lineTo(this.radius + paddingRight, lineTop);
                            this.hO.set(paddingRight, lineTop, paddingRight + f2, lineTop + f2);
                            this.lR.arcTo(this.hO, 270.0f, -90.0f);
                            this.lR.lineTo(paddingRight, lineBottom - this.radius);
                            this.hO.set(paddingRight - f2, lineBottom - f2, paddingRight, lineBottom);
                            this.lR.arcTo(this.hO, 0.0f, 90.0f);
                            this.lR.lineTo(this.radius, lineBottom);
                            this.hO.set(0.0f, lineBottom - f2, f2, lineBottom);
                            this.lR.arcTo(this.hO, 90.0f, 90.0f);
                            this.lR.lineTo(0.0f, this.radius);
                        }
                    }
                    this.lR.close();
                    canvas.drawPath(this.lR, this.paint);
                }
            }
        }
        super.onDraw(canvas);
        AppMethodBeat.o(237744);
    }
}
