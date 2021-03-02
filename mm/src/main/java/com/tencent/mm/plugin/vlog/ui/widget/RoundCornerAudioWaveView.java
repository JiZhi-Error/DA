package com.tencent.mm.plugin.vlog.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0015J(\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0014J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\tJ\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/RoundCornerAudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "heightStep", "isRunningShow", "", "mRandom", "", "mRectCount", "mRectHeight", "mRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "mWidth", "spacing", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "color", "setShow", "isShow", "setWaveCount", "count", "plugin-vlog_release"})
public final class RoundCornerAudioWaveView extends View {
    private int Caf;
    private Paint Cag;
    private int Cai;
    private double Caj;
    private boolean Cak;
    private int GQA;
    private final String TAG = "MicroMsg.RoundCornerAudioWaveView";
    private int mWidth;
    private int qSb;
    private final int spacing = a.fromDPToPix(getContext(), 2.0f);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundCornerAudioWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(192220);
        initView();
        AppMethodBeat.o(192220);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoundCornerAudioWaveView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(192221);
        initView();
        AppMethodBeat.o(192221);
    }

    private final void initView() {
        AppMethodBeat.i(192216);
        this.Cai = 20;
        this.Cag = new Paint();
        Paint paint = this.Cag;
        if (paint == null) {
            p.hyc();
        }
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = this.Cag;
        if (paint2 == null) {
            p.hyc();
        }
        paint2.setColor(-3355444);
        Paint paint3 = this.Cag;
        if (paint3 == null) {
            p.hyc();
        }
        paint3.setAntiAlias(true);
        AppMethodBeat.o(192216);
    }

    public final void setColor(int i2) {
        AppMethodBeat.i(192217);
        Paint paint = this.Cag;
        if (paint == null) {
            p.hyc();
        }
        paint.setColor(i2);
        AppMethodBeat.o(192217);
    }

    public final void setShow(boolean z) {
        this.Cak = z;
    }

    public final void setWaveCount(int i2) {
        this.Cai = i2;
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(192218);
        super.onSizeChanged(i2, i3, i4, i5);
        this.mWidth = getWidth();
        this.Caf = getHeight() / 2;
        this.qSb = this.mWidth / this.Cai;
        this.qSb -= this.spacing;
        this.GQA = this.Caf / (this.Cai / 2);
        AppMethodBeat.o(192218);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(192219);
        p.h(canvas, "canvas");
        canvas.save();
        canvas.translate((float) this.spacing, (float) (getHeight() / 2));
        int i2 = this.Cai;
        for (int i3 = 0; i3 < i2; i3++) {
            this.Caj = Math.random();
            double abs = ((double) ((((this.Cai / 2) - Math.abs(i3 - (this.Cai / 2))) + 1) * this.GQA)) * this.Caj;
            int i4 = (this.qSb * i3) + (this.spacing * i3);
            RectF rectF = new RectF((float) i4, (float) (abs / 2.0d), (float) (this.qSb + i4), (float) ((-abs) / 2.0d));
            float f2 = (float) (this.qSb / 2);
            float f3 = (float) (this.qSb / 2);
            Paint paint = this.Cag;
            if (paint == null) {
                p.hyc();
            }
            canvas.drawRoundRect(rectF, f2, f3, paint);
        }
        canvas.restore();
        if (this.Cak) {
            postInvalidateDelayed(100);
        }
        AppMethodBeat.o(192219);
    }
}
