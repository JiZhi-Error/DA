package com.tencent.mm.plugin.location.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.tencentmap.mapsdk.map.TencentMap;

public class PoiPoint extends View {
    private Context context;
    RectF cuN = new RectF();
    private int position;
    private int tHg;
    d yHK;
    boolean yHM = false;
    private Paint yIb;
    private int yIc;
    private Paint yId;
    private int yIe;
    private Paint yIf;
    private int yIg;
    private Paint yIh;
    private int yIi;
    private ValueAnimator yIj;
    private ValueAnimator yIk;
    private ValueAnimator yIl;
    private double yIm;
    private double yIn;
    private int yIo;
    private float yIp;
    b yIq = b.SIT;
    a yIr;

    public interface a {
        void a(b bVar, PoiPoint poiPoint);
    }

    public double getLat() {
        return this.yIm;
    }

    public double getLng() {
        return this.yIn;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public int getPosition() {
        return this.position;
    }

    public PoiPoint(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(55862);
        init(context2);
        AppMethodBeat.o(55862);
    }

    public PoiPoint(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(55863);
        init(context2);
        AppMethodBeat.o(55863);
    }

    public PoiPoint(Context context2, d dVar) {
        super(context2);
        AppMethodBeat.i(55864);
        this.yHK = dVar;
        init(context2);
        AppMethodBeat.o(55864);
    }

    private void init(Context context2) {
        AppMethodBeat.i(55865);
        setLayerType(1, null);
        this.context = context2;
        this.yIb = new Paint(1);
        this.yIb.setColor(-1);
        this.yIc = at.fromDPToPix(context2, 12);
        this.yId = new Paint(1);
        this.yId.setColor(context2.getResources().getColor(R.color.afp));
        int fromDPToPix = at.fromDPToPix(context2, 8);
        int fromDPToPix2 = at.fromDPToPix(context2, 16);
        this.yIe = fromDPToPix;
        this.yIf = new Paint(1);
        this.yIf.setColor(-1);
        int fromDPToPix3 = at.fromDPToPix(context2, 7);
        this.yIg = 0;
        this.yIh = new Paint(1);
        this.yIh.setColor(context2.getResources().getColor(R.color.afp));
        this.yIh.setStrokeWidth((float) at.fromDPToPix(context2, 4));
        int fromDPToPix4 = at.fromDPToPix(context2, 20);
        AnonymousClass1 r4 = new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.location.ui.PoiPoint.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(55857);
                if (valueAnimator == PoiPoint.this.yIj) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    Log.i("MicroMsg.PoiPoint", "greenRadiusChangeAnim, val: %s.", Integer.valueOf(intValue));
                    PoiPoint.this.yIe = intValue;
                } else if (valueAnimator == PoiPoint.this.yIk) {
                    int intValue2 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    Log.i("MicroMsg.PoiPoint", "whiteRadiusChangeAnim, val: %s.", Integer.valueOf(intValue2));
                    PoiPoint.this.yIg = intValue2;
                } else if (valueAnimator == PoiPoint.this.yIl) {
                    int intValue3 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    Log.i("MicroMsg.PoiPoint", "greenLineChangeAnim, val: %s.", Integer.valueOf(intValue3));
                    PoiPoint.this.yIi = intValue3;
                }
                PoiPoint poiPoint = PoiPoint.this;
                if (poiPoint.yHM) {
                    poiPoint.yHK.updateMarkerView(poiPoint);
                }
                AppMethodBeat.o(55857);
            }
        };
        this.yIj = ValueAnimator.ofInt(fromDPToPix, fromDPToPix2);
        this.yIj.setDuration(300L);
        this.yIj.addUpdateListener(r4);
        this.yIk = ValueAnimator.ofInt(0, fromDPToPix3);
        this.yIk.setDuration(300L);
        this.yIk.addUpdateListener(r4);
        this.yIl = ValueAnimator.ofInt(0, fromDPToPix4);
        this.yIl.setDuration(300L);
        this.yIl.addUpdateListener(r4);
        this.yIl.setStartDelay(100);
        this.yIo = at.fromDPToPix(context2, 1);
        this.tHg = at.fromDPToPix(context2, 4);
        this.yIp = at.getDensity(context2) * 2.5f;
        AppMethodBeat.o(55865);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(55866);
        super.onMeasure(i2, i3);
        int fromDPToPix = at.fromDPToPix(this.context, 32);
        int fromDPToPix2 = at.fromDPToPix(this.context, 52);
        Log.d("MicroMsg.PoiPoint", "point size: %s*%s.", Integer.valueOf(fromDPToPix), Integer.valueOf(fromDPToPix2));
        setMeasuredDimension(fromDPToPix, fromDPToPix2);
        AppMethodBeat.o(55866);
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(55867);
        super.onDraw(canvas);
        Log.d("MicroMsg.PoiPoint", "onDraw, greenCircleRadius: %s.", Integer.valueOf(this.yIe));
        int width = getWidth() / 2;
        float height = (float) ((getHeight() - (getWidth() / 2)) - this.yIi);
        if (b.SIT == this.yIq && 0.0f == this.yIj.getAnimatedFraction()) {
            Log.i("MicroMsg.PoiPoint", "draw shade.");
            this.yIb.setShadowLayer((float) at.fromDPToPix(this.context, 1), 0.0f, (float) this.yIo, this.context.getResources().getColor(R.color.BW_0_Alpha_0_1));
        }
        canvas.drawCircle((float) width, height, (float) this.yIc, this.yIb);
        canvas.drawCircle((float) width, height, (float) this.yIe, this.yId);
        canvas.drawCircle((float) width, height, (float) this.yIg, this.yIf);
        this.cuN.set(((float) width) - (((float) this.tHg) / 2.0f), (((float) this.yIe) + height) - this.yIp, ((float) width) + (((float) this.tHg) / 2.0f), height + ((float) this.yIe) + ((float) this.yIi));
        canvas.drawRoundRect(this.cuN, this.yIp, this.yIp, this.yIh);
        AppMethodBeat.o(55867);
    }

    public final void edi() {
        AppMethodBeat.i(55868);
        if (b.STAND == this.yIq) {
            this.yIq = b.SIT;
            this.yIj.reverse();
            this.yIk.reverse();
            this.yIl.reverse();
        }
        AppMethodBeat.o(55868);
    }

    public final void edj() {
        AppMethodBeat.i(55869);
        if (b.SIT == this.yIq) {
            this.yIq = b.STAND;
            this.yIj.start();
            this.yIk.start();
            this.yIl.start();
        }
        AppMethodBeat.o(55869);
    }

    public final void c(double d2, double d3, boolean z) {
        AppMethodBeat.i(55870);
        if (!this.yHM) {
            this.yHM = true;
            this.yIm = d2;
            this.yIn = d3;
            this.yHK.addPinView(this, d2, d3);
            this.yHK.setMarkerClickListener(this, new TencentMap.OnMarkerClickListener() {
                /* class com.tencent.mm.plugin.location.ui.PoiPoint.AnonymousClass2 */

                @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener
                public final boolean onMarkerClick(Marker marker) {
                    AppMethodBeat.i(55858);
                    Log.i("MicroMsg.PoiPoint", "onClick.");
                    if (PoiPoint.this.yIr != null) {
                        PoiPoint.this.yIr.a(PoiPoint.this.yIq, PoiPoint.this);
                        AppMethodBeat.o(55858);
                        return true;
                    }
                    AppMethodBeat.o(55858);
                    return false;
                }
            });
            if (z) {
                edj();
            }
        }
        AppMethodBeat.o(55870);
    }

    public final void remove() {
        AppMethodBeat.i(55871);
        if (this.yHM) {
            this.yHK.removeView(this);
        }
        this.yHM = false;
        AppMethodBeat.o(55871);
    }

    public enum b {
        STAND,
        SIT;

        public static b valueOf(String str) {
            AppMethodBeat.i(55860);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(55860);
            return bVar;
        }

        static {
            AppMethodBeat.i(55861);
            AppMethodBeat.o(55861);
        }
    }

    public void setOnPointClick(a aVar) {
        this.yIr = aVar;
    }
}
