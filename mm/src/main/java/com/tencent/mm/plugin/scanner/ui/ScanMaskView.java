package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;

public class ScanMaskView extends View {
    private Bitmap CLS = null;
    private Bitmap CLT = null;
    private Bitmap CLU = null;
    private Bitmap CLV = null;
    int CLW = 0;
    int CLX = 0;
    private boolean CLY = false;
    private Rect CLZ = new Rect();
    private Rect CMa = new Rect();
    private Rect CMb = new Rect();
    private Rect CMc = new Rect();
    private Rect CMd = new Rect();
    private Rect CMe = new Rect();
    private Rect CMf = new Rect();
    private Rect CMg = new Rect();
    private Rect CMh = new Rect();
    private Rect CMi;
    private int CMj = R.color.a5z;
    private long CMk = 0;
    private boolean CMl = false;
    private int CMm = 300;
    private float CMn = 0.0f;
    private float CMo = 0.0f;
    private float CMp = 0.0f;
    private float CMq = 0.0f;
    private Paint CMr;
    private ValueAnimator CMs = null;
    private a CMt;
    private Paint mPaint;
    private Path rqV = new Path();

    interface a {
    }

    public ScanMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(51913);
        AppMethodBeat.o(51913);
    }

    public Rect getMaskRect() {
        return this.CMi;
    }

    public int getMaskAnimDuration() {
        return this.CMm;
    }

    public void setMastAnimaDuration(int i2) {
        this.CMm = i2;
    }

    public void setMaskAnimaListener(a aVar) {
        this.CMt = aVar;
    }

    public void setMaskColorRsid(int i2) {
        this.CMj = i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(51914);
        if (this.CMi == null || this.CLY) {
            AppMethodBeat.o(51914);
            return;
        }
        System.currentTimeMillis();
        System.currentTimeMillis();
        int save = canvas.save();
        this.mPaint.reset();
        if (d.oE(18)) {
            this.CMe.left = 0;
            this.CMe.top = this.CMi.top;
            this.CMe.right = this.CMi.left;
            this.CMe.bottom = this.CMi.bottom;
            this.CMf.left = this.CMi.left;
            this.CMf.top = 0;
            this.CMf.right = this.CMi.right;
            this.CMf.bottom = this.CMi.top;
            this.CMg.left = this.CMi.right;
            this.CMg.top = this.CMi.top;
            this.CMg.right = getWidth();
            this.CMg.bottom = this.CMi.bottom;
            this.CMh.left = this.CMi.left;
            this.CMh.top = this.CMi.bottom;
            this.CMh.right = this.CMi.right;
            this.CMh.bottom = getHeight();
            this.CMa.left = 0;
            this.CMa.top = 0;
            this.CMa.right = this.CMi.left;
            this.CMa.bottom = this.CMi.top;
            this.CMb.left = this.CMi.right;
            this.CMb.top = 0;
            this.CMb.right = getWidth();
            this.CMb.bottom = this.CMi.top;
            this.CMc.left = 0;
            this.CMc.top = this.CMi.bottom;
            this.CMc.right = this.CMi.left;
            this.CMc.bottom = getHeight();
            this.CMd.left = this.CMi.right;
            this.CMd.top = this.CMi.bottom;
            this.CMd.right = getWidth();
            this.CMd.bottom = getHeight();
            canvas.save();
            canvas.clipRect(this.CMe, Region.Op.REPLACE);
            canvas.drawColor(getResources().getColor(this.CMj));
            canvas.restore();
            canvas.save();
            canvas.clipRect(this.CMf, Region.Op.REPLACE);
            canvas.drawColor(getResources().getColor(this.CMj));
            canvas.restore();
            canvas.save();
            canvas.clipRect(this.CMg, Region.Op.REPLACE);
            canvas.drawColor(getResources().getColor(this.CMj));
            canvas.restore();
            canvas.save();
            canvas.clipRect(this.CMh, Region.Op.REPLACE);
            canvas.drawColor(getResources().getColor(this.CMj));
            canvas.restore();
            canvas.save();
            canvas.clipRect(this.CMa, Region.Op.REPLACE);
            canvas.drawColor(getResources().getColor(this.CMj));
            canvas.restore();
            canvas.save();
            canvas.clipRect(this.CMb, Region.Op.REPLACE);
            canvas.drawColor(getResources().getColor(this.CMj));
            canvas.restore();
            canvas.save();
            canvas.clipRect(this.CMc, Region.Op.REPLACE);
            canvas.drawColor(getResources().getColor(this.CMj));
            canvas.restore();
            canvas.save();
            canvas.clipRect(this.CMd, Region.Op.REPLACE);
            canvas.drawColor(getResources().getColor(this.CMj));
            canvas.restore();
        } else {
            canvas.clipRect(this.CMi, Region.Op.DIFFERENCE);
            canvas.drawColor(getResources().getColor(this.CMj));
        }
        System.currentTimeMillis();
        System.currentTimeMillis();
        canvas.restoreToCount(save);
        this.mPaint.reset();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setColor(-3355444);
        this.mPaint.setAntiAlias(true);
        canvas.drawRect(this.CMi, this.mPaint);
        System.currentTimeMillis();
        System.currentTimeMillis();
        canvas.drawBitmap(this.CLS, (float) this.CMi.left, (float) this.CMi.top, this.CMr);
        canvas.drawBitmap(this.CLT, (float) (this.CMi.right - this.CLW), (float) this.CMi.top, this.CMr);
        canvas.drawBitmap(this.CLU, (float) this.CMi.left, (float) (this.CMi.bottom - this.CLX), this.CMr);
        canvas.drawBitmap(this.CLV, (float) (this.CMi.right - this.CLW), (float) (this.CMi.bottom - this.CLX), this.CMr);
        System.currentTimeMillis();
        super.onDraw(canvas);
        System.currentTimeMillis();
        AppMethodBeat.o(51914);
    }
}
