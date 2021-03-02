package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/FinderPreviewView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "borderPaint", "Landroid/graphics/Paint;", "linePaint", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "plugin-vlog_release"})
public final class FinderPreviewView extends View {
    private final Paint GQi = new Paint();
    private final Paint borderPaint = new Paint();

    public FinderPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(192170);
        this.borderPaint.setColor(-1);
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setStrokeWidth((float) a.fromDPToPix(getContext(), 2));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.GQi.setColor(Color.parseColor("#4DFFFFFF"));
        this.GQi.setAntiAlias(true);
        this.GQi.setStrokeWidth((float) a.fromDPToPix(getContext(), 1));
        this.GQi.setStyle(Paint.Style.STROKE);
        AppMethodBeat.o(192170);
    }

    public FinderPreviewView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(192171);
        this.borderPaint.setColor(-1);
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setStrokeWidth((float) a.fromDPToPix(getContext(), 2));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.GQi.setColor(Color.parseColor("#4DFFFFFF"));
        this.GQi.setAntiAlias(true);
        this.GQi.setStrokeWidth((float) a.fromDPToPix(getContext(), 1));
        this.GQi.setStyle(Paint.Style.STROKE);
        AppMethodBeat.o(192171);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(192169);
        p.h(canvas, "canvas");
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.borderPaint);
        for (int i2 = 1; i2 <= 2; i2++) {
            float height = (((float) getHeight()) * ((float) i2)) / 3.0f;
            float width = (((float) getWidth()) * ((float) i2)) / 3.0f;
            canvas.drawLine(0.0f, height, (float) getWidth(), height, this.GQi);
            canvas.drawLine(width, 0.0f, width, (float) getHeight(), this.GQi);
        }
        AppMethodBeat.o(192169);
    }
}
