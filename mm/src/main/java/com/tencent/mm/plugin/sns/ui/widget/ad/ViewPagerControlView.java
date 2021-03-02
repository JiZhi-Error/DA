package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;

public class ViewPagerControlView extends LinearLayout {
    protected int Fgm;
    private float Fgn;
    private float Fgo;
    private Paint Fgp;
    private Paint Fgq;
    private Paint Fgr;
    private Paint Fgs;
    private int Fgt;
    private float Fgu;
    private int Fgv;
    private float Fgw;
    private float Fgx;
    private boolean autoCarousel;
    protected Context context;
    protected int count;
    private float height;
    private float left;
    private Paint lun;
    private int mEX;
    float progress;
    private float radius;
    private float width;

    public ViewPagerControlView(Context context2) {
        this(context2, null);
    }

    public ViewPagerControlView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public ViewPagerControlView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(204030);
        this.autoCarousel = false;
        this.context = context2;
        this.mEX = ap.ha(this.context)[0];
        this.width = (float) a.fromDPToPix(this.context, 28);
        this.height = (float) a.fromDPToPix(this.context, 7);
        this.radius = this.height / 2.0f;
        this.Fgo = this.width - this.height;
        this.Fgp = new Paint();
        this.Fgp.setFlags(1);
        this.Fgp.setColor(this.context.getResources().getColor(R.color.a89));
        this.Fgq = new Paint();
        this.Fgq.setStyle(Paint.Style.STROKE);
        this.Fgq.setStrokeWidth(0.5f);
        this.Fgq.setFlags(1);
        this.Fgq.setColor(this.context.getResources().getColor(R.color.a88));
        this.Fgr = new Paint();
        this.Fgr.setFlags(1);
        this.Fgr.setColor(this.context.getResources().getColor(R.color.a89));
        this.Fgs = new Paint();
        this.Fgs.setFlags(1);
        this.Fgs.setColor(-1);
        this.Fgs.setAlpha(0);
        this.lun = new Paint();
        this.lun.setFlags(1);
        this.lun.setColor(-1);
        this.lun.setAlpha(0);
        this.lun.setStyle(Paint.Style.STROKE);
        this.lun.setStrokeWidth(this.height);
        this.lun.setStrokeCap(Paint.Cap.ROUND);
        setWillNotDraw(false);
        AppMethodBeat.o(204030);
    }

    public final void aX(int i2, boolean z) {
        this.count = i2;
        this.Fgm = i2 - 2;
        this.Fgn = ((((float) this.mEX) - (((float) ((this.Fgm - 1) * 2)) * this.height)) - this.width) / 2.0f;
        this.autoCarousel = z;
    }

    public final void v(int i2, float f2) {
        AppMethodBeat.i(204031);
        if (i2 > this.Fgm) {
            AppMethodBeat.o(204031);
            return;
        }
        if (i2 <= 0) {
            this.Fgv = 1;
        } else if (i2 == this.Fgm) {
            this.Fgv = 2;
        } else {
            this.Fgv = 0;
        }
        this.Fgt = i2;
        this.Fgu = f2;
        invalidate();
        AppMethodBeat.o(204031);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(204032);
        super.onDraw(canvas);
        this.left = this.Fgn;
        this.Fgw = this.left + this.radius;
        this.Fgx = this.radius;
        if (this.Fgv == 1 || this.Fgv == 2) {
            e(canvas, false);
            for (int i2 = 2; i2 <= this.Fgm - 1; i2++) {
                v(canvas);
            }
            e(canvas, true);
            AppMethodBeat.o(204032);
            return;
        }
        for (int i3 = 1; i3 < this.Fgt; i3++) {
            v(canvas);
        }
        e(canvas, true);
        e(canvas, false);
        for (int i4 = this.Fgt + 2; i4 <= this.Fgm; i4++) {
            v(canvas);
        }
        AppMethodBeat.o(204032);
    }

    private void v(Canvas canvas) {
        AppMethodBeat.i(204033);
        canvas.drawCircle(this.Fgw, this.Fgx, this.radius, this.Fgr);
        canvas.drawCircle(this.Fgw, this.Fgx, this.radius, this.Fgq);
        this.left += 2.0f * this.height;
        this.Fgw = this.left + this.radius;
        AppMethodBeat.o(204033);
    }

    private void e(Canvas canvas, boolean z) {
        float f2;
        float f3;
        AppMethodBeat.i(204034);
        if (z) {
            float f4 = this.width - (this.Fgu * this.Fgo);
            f2 = this.Fgu <= 0.3f ? 1.0f - ((this.Fgu * 10.0f) / 3.0f) : 0.0f;
            f3 = f4;
        } else {
            float f5 = this.height + (this.Fgu * this.Fgo);
            f2 = this.Fgu >= 0.7f ? ((this.Fgu - 0.7f) * 10.0f) / 3.0f : 0.0f;
            f3 = f5;
        }
        int i2 = (int) (f2 * 255.0f);
        float f6 = this.left + f3;
        RectF rectF = new RectF(this.left, 0.0f, f6, this.height);
        canvas.drawRoundRect(rectF, this.radius, this.radius, this.Fgp);
        if (z) {
            this.lun.setAlpha(i2);
            canvas.drawLine(this.Fgw, this.radius, ((f3 - (this.radius * 2.0f)) * this.progress) + this.Fgw, this.radius, this.lun);
        } else if (!this.autoCarousel) {
            this.lun.setAlpha(i2);
            canvas.drawLine(this.Fgw, this.radius, ((f3 - (this.radius * 2.0f)) * this.progress) + this.Fgw, this.radius, this.lun);
        } else {
            this.Fgs.setAlpha(i2);
            canvas.drawCircle(this.Fgw, this.Fgx, this.radius, this.Fgs);
        }
        canvas.drawRoundRect(rectF, this.radius, this.radius, this.Fgq);
        this.left = this.height + f6;
        this.Fgw = this.left + this.radius;
        AppMethodBeat.o(204034);
    }
}
