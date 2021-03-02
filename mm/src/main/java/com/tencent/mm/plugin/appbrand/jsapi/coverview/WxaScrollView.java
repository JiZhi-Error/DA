package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.g;
import com.tencent.mm.sdk.platformtools.Log;

public class WxaScrollView extends FrameLayout implements g, u, v {
    private float gPO;
    private float lSR;
    private float[] lSS;
    private int lST;
    private Paint lSU;
    GradientDrawable lTc;
    float[] lTd;
    private FrameLayout lTv;
    private ScrollView lTw;
    private t lTx;
    private boolean lTy;
    private boolean lTz;
    private int mBgColor;

    public WxaScrollView(Context context) {
        super(context);
        AppMethodBeat.i(137552);
        this.lTy = true;
        this.lTz = true;
        this.lSU = new Paint();
        this.lTc = new GradientDrawable();
        this.lTd = new float[8];
        init();
        AppMethodBeat.o(137552);
    }

    public WxaScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(137553);
        this.lTy = true;
        this.lTz = true;
        this.lSU = new Paint();
        this.lTc = new GradientDrawable();
        this.lTd = new float[8];
        init();
        AppMethodBeat.o(137553);
    }

    public WxaScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(137554);
        this.lTy = true;
        this.lTz = true;
        this.lSU = new Paint();
        this.lTc = new GradientDrawable();
        this.lTd = new float[8];
        init();
        AppMethodBeat.o(137554);
    }

    private void init() {
        AppMethodBeat.i(137555);
        this.lTw = new ScrollView(getContext()) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final void onScrollChanged(int i2, int i3, int i4, int i5) {
                AppMethodBeat.i(137549);
                super.onScrollChanged(i2, i3, i4, i5);
                if (WxaScrollView.this.lTx != null) {
                    WxaScrollView.this.lTx.p(WxaScrollView.this, i2, i3);
                }
                AppMethodBeat.o(137549);
            }

            public final boolean onTouchEvent(MotionEvent motionEvent) {
                AppMethodBeat.i(137550);
                switch (motionEvent.getAction()) {
                    case 2:
                        if (!WxaScrollView.this.lTy) {
                            Log.e("MicroMsg.WxaScrollView", "can not move");
                            AppMethodBeat.o(137550);
                            return false;
                        }
                        break;
                }
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.o(137550);
                return onTouchEvent;
            }
        };
        this.lTv = new FrameLayout(getContext());
        super.addView(this.lTw, 0, new ViewGroup.LayoutParams(-1, -1));
        this.lTw.addView(this.lTv, 0, new ViewGroup.LayoutParams(-1, -2));
        this.lSU.setStyle(Paint.Style.STROKE);
        this.lSU.setAntiAlias(true);
        setWillNotDraw(false);
        AppMethodBeat.o(137555);
    }

    public void draw(Canvas canvas) {
        boolean z;
        float f2 = 0.0f;
        AppMethodBeat.i(137556);
        if (this.lSS == null || this.lSS.length != 4) {
            boolean z2 = this.lSR > 0.0f;
            if (z2) {
                canvas.save();
                Path path = new Path();
                path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), this.lSR, this.lSR, Path.Direction.CW);
                canvas.clipPath(path);
            }
            if (this.mBgColor != 0) {
                canvas.drawColor(this.mBgColor);
            }
            if (this.gPO > 0.0f) {
                float f3 = this.gPO / 2.0f;
                canvas.drawRoundRect(new RectF(f3, f3, ((float) getWidth()) - f3, ((float) getHeight()) - f3), this.lSR, this.lSR, this.lSU);
                if (z2) {
                    canvas.restore();
                }
                canvas.save();
                Path path2 = new Path();
                if (this.lSR > 0.0f && this.lSR - this.gPO > 0.0f) {
                    f2 = this.lSR - this.gPO;
                }
                path2.addRoundRect(new RectF(this.gPO, this.gPO, ((float) getWidth()) - this.gPO, ((float) getHeight()) - this.gPO), f2, f2, Path.Direction.CW);
                canvas.clipPath(path2);
                z = true;
            } else {
                z = z2;
            }
            int save = canvas.save();
            super.draw(canvas);
            canvas.restoreToCount(save);
            if (z) {
                canvas.restore();
            }
            AppMethodBeat.o(137556);
            return;
        }
        super.draw(canvas);
        AppMethodBeat.o(137556);
    }

    private Drawable getShadowDrawable() {
        AppMethodBeat.i(193675);
        if (this.mBgColor != 0) {
            this.lTc.setColor(this.mBgColor);
        }
        if (this.lSS != null && this.lSS.length > 3) {
            this.lTd[0] = this.lSS[0];
            this.lTd[1] = this.lSS[0];
            this.lTd[2] = this.lSS[1];
            this.lTd[3] = this.lSS[1];
            this.lTd[4] = this.lSS[3];
            this.lTd[5] = this.lSS[3];
            this.lTd[6] = this.lSS[2];
            this.lTd[7] = this.lSS[2];
            this.lTc.setCornerRadii(this.lTd);
        }
        if (this.gPO > 0.0f && this.lST != 0) {
            this.lTc.setStroke((int) this.gPO, this.lST);
        }
        GradientDrawable gradientDrawable = this.lTc;
        AppMethodBeat.o(193675);
        return gradientDrawable;
    }

    public ViewGroup getTargetView() {
        return this.lTv;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.coverview.u
    public int getTargetViewChildCount() {
        AppMethodBeat.i(137557);
        int childCount = this.lTv.getChildCount();
        AppMethodBeat.o(137557);
        return childCount;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        AppMethodBeat.i(137558);
        this.lTv.addView(view, i2);
        AppMethodBeat.o(137558);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(137559);
        this.lTv.addView(view, i2, layoutParams);
        AppMethodBeat.o(137559);
    }

    public void removeView(View view) {
        AppMethodBeat.i(137560);
        this.lTv.removeView(view);
        AppMethodBeat.o(137560);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.g
    public void setBorderRadius(float f2) {
        this.lSR = f2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.g
    public void setBorderRadius(float[] fArr) {
        AppMethodBeat.i(193676);
        this.lSS = fArr;
        if (this.lSS != null && this.lSS.length > 0) {
            setBackground(getShadowDrawable());
        }
        AppMethodBeat.o(193676);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.g
    public void setBorderColor(int i2) {
        AppMethodBeat.i(137561);
        this.lST = i2;
        this.lSU.setColor(i2);
        AppMethodBeat.o(137561);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.g
    public void setBorderWidth(float f2) {
        AppMethodBeat.i(137562);
        this.gPO = f2;
        this.lSU.setStrokeWidth(f2);
        AppMethodBeat.o(137562);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ac.g
    public void setBgColor(int i2) {
        this.mBgColor = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r14) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnScrollChangedListener(t tVar) {
        this.lTx = tVar;
    }

    public void setScrollVertical(boolean z) {
        this.lTy = z;
    }

    public void setScrollHorizontal(boolean z) {
        this.lTz = z;
    }

    public void scrollTo(int i2, int i3) {
        AppMethodBeat.i(137564);
        this.lTw.scrollTo(i2, i3);
        invalidate();
        AppMethodBeat.o(137564);
    }
}
