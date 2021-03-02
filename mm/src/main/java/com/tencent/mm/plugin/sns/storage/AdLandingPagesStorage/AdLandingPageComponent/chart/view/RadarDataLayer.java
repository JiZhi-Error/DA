package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.DataLayerView;
import java.util.Map;
import java.util.Set;

public class RadarDataLayer extends DataLayerView {
    public static final Point Ebi = new Point(0, 0);
    private int Ebe = 4;
    private a Ebj;
    private a Ebk;
    private b Ebl = new b();
    private ValueAnimator Ebm;
    private boolean Ebn = true;
    private int Ebo = 80;
    private Point Ebp = Ebi;
    private float maxValue = 1.0f;
    private Path xT = new Path();

    static {
        AppMethodBeat.i(96360);
        AppMethodBeat.o(96360);
    }

    public RadarDataLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(96347);
        fcR();
        AppMethodBeat.o(96347);
    }

    public RadarDataLayer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(96348);
        fcR();
        AppMethodBeat.o(96348);
    }

    public RadarDataLayer(Context context, float f2, a aVar) {
        super(context);
        AppMethodBeat.i(96349);
        this.maxValue = f2;
        this.Ebl = aVar.Ear;
        this.Ebe = aVar.size();
        this.Ebj = aVar;
        Interpolator interpolator = aVar.Eas;
        long j2 = aVar.duration;
        if (j2 > 0) {
            this.Ebm = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.Ebk = new a();
            this.Ebm.setDuration(j2);
            this.Ebm.setInterpolator(interpolator);
            this.Ebm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarDataLayer.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(96346);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    for (Map.Entry entry : RadarDataLayer.this.Ebj.entrySet()) {
                        RadarDataLayer.this.Ebk.put(entry.getKey(), Float.valueOf(((Float) entry.getValue()).floatValue() * floatValue));
                        RadarDataLayer.this.invalidate();
                    }
                    AppMethodBeat.o(96346);
                }
            });
        }
        AppMethodBeat.o(96349);
    }

    private void fcR() {
        AppMethodBeat.i(96350);
        setMinimumHeight(160);
        setMinimumWidth(160);
        AppMethodBeat.o(96350);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.DataLayerView
    public final int fcO() {
        return this.Ebo * 2;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.DataLayerView
    public final int fcP() {
        return this.Ebo * 2;
    }

    public void onDraw(Canvas canvas) {
        Set<Map.Entry> entrySet;
        AppMethodBeat.i(96351);
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.Ebo = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.Ebp.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.Ebj == null) {
            RuntimeException runtimeException = new RuntimeException("Error: NullPointerException at data.");
            AppMethodBeat.o(96351);
            throw runtimeException;
        }
        if (this.Ebj != null) {
            if (this.Ebk == null) {
                entrySet = this.Ebj.entrySet();
            } else {
                entrySet = this.Ebk.entrySet();
            }
            int i2 = 0;
            for (Map.Entry entry : entrySet) {
                float floatValue = (float) (((double) this.Ebp.x) - (((double) ((((Float) entry.getValue()).floatValue() / this.maxValue) * ((float) this.Ebo))) * Math.sin(6.283185307179586d - ((((double) (i2 * 2)) * 3.141592653589793d) / ((double) this.Ebe)))));
                float floatValue2 = (float) (((double) this.Ebp.y) - (((double) ((((Float) entry.getValue()).floatValue() / this.maxValue) * ((float) this.Ebo))) * Math.cos(6.283185307179586d - ((((double) (i2 * 2)) * 3.141592653589793d) / ((double) this.Ebe)))));
                if (i2 == 0) {
                    this.xT.moveTo(floatValue, floatValue2);
                } else {
                    this.xT.lineTo(floatValue, floatValue2);
                }
                if (this.Ebn) {
                    canvas.drawCircle(floatValue, floatValue2, (float) this.Ebl.Eaz, getPaintLayerDotPoint());
                }
                i2++;
            }
            this.xT.close();
            canvas.drawPath(this.xT, getPaintLayerFilling());
            canvas.drawPath(this.xT, getPaintLayerBorder());
            this.xT.reset();
        }
        AppMethodBeat.o(96351);
    }

    private Paint getPaintLayerFilling() {
        int i2;
        AppMethodBeat.i(96352);
        Paint paint = new Paint();
        b bVar = this.Ebl;
        if (bVar.Eaw == -1) {
            i2 = bVar.Eau;
        } else {
            i2 = bVar.Eaw;
        }
        paint.setColor(i2);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setAlpha(this.Ebl.Eax);
        AppMethodBeat.o(96352);
        return paint;
    }

    private Paint getPaintLayerBorder() {
        AppMethodBeat.i(96353);
        Paint paint = new Paint();
        paint.setColor(this.Ebl.Eau);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Ebl.Eav);
        paint.setAntiAlias(true);
        AppMethodBeat.o(96353);
        return paint;
    }

    private Paint getPaintLayerPoint() {
        AppMethodBeat.i(96354);
        Paint paint = new Paint();
        paint.setColor(this.Ebl.Eau);
        paint.setStrokeWidth(this.Ebl.Eav);
        AppMethodBeat.o(96354);
        return paint;
    }

    private Paint getPaintLayerDotPoint() {
        AppMethodBeat.i(96355);
        Paint paint = new Paint();
        paint.setColor(this.Ebl.Eay);
        AppMethodBeat.o(96355);
        return paint;
    }

    public void setGlobalMax(float f2) {
        AppMethodBeat.i(96356);
        this.maxValue = f2;
        invalidate();
        AppMethodBeat.o(96356);
    }

    public void setData(a aVar) {
        AppMethodBeat.i(96357);
        this.Ebj = aVar;
        invalidate();
        AppMethodBeat.o(96357);
    }

    public void setLayerStyle(b bVar) {
        AppMethodBeat.i(96358);
        this.Ebl = bVar;
        invalidate();
        AppMethodBeat.o(96358);
    }

    public void setMaxValue(float f2) {
        AppMethodBeat.i(96359);
        this.maxValue = f2;
        invalidate();
        AppMethodBeat.o(96359);
    }
}
