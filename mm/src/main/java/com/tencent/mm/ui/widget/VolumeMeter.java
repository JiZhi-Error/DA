package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class VolumeMeter extends ImageView implements Runnable {
    private boolean iTN = false;
    private Context mContext;
    private Paint paint;
    private float radius = 0.0f;
    private int yKA = -6751336;
    private int yKB = 70;
    private float yKC = 0.5f;
    private float yKD = 0.001f;
    private int yKE = 20;
    private float yKF;
    private float yKG;
    private float yKH = 40.0f;
    private float yKI = 30.0f;
    private boolean yKr = false;
    private View yKs;
    private int yKt = -1;
    private int yKu = -1;
    private MMHandler yKv = null;
    private float yKw;
    private float yKx;
    private float yKy;
    private float yKz;

    public void run() {
        float f2;
        AppMethodBeat.i(143498);
        if (this.iTN) {
            float f3 = this.yKy;
            if (this.yKx > this.yKw) {
                float f4 = (this.yKx - this.yKw) / this.yKI;
                if (f4 > this.yKC) {
                    f4 = this.yKC;
                } else if (f4 < this.yKD) {
                    f4 = this.yKD;
                }
                f2 = f4 + f3;
            } else if (this.yKx <= this.yKw) {
                float f5 = (this.yKw - this.yKx) / this.yKH;
                if (f5 > this.yKC) {
                    f5 = this.yKC;
                } else if (f5 < this.yKD) {
                    f5 = this.yKD;
                }
                f2 = f3 - f5;
            } else {
                f2 = f3;
            }
            this.yKy = f2;
            this.yKz = this.yKy;
            this.radius = ((float) ((260.0d * Math.sqrt((double) this.yKy)) - ((double) (130.0f * this.yKy)))) / 1.5f;
            postInvalidate();
            this.yKv.postDelayed(this, (long) this.yKE);
        }
        AppMethodBeat.o(143498);
    }

    public VolumeMeter(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143499);
        this.mContext = context;
        init();
        AppMethodBeat.o(143499);
    }

    public VolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143500);
        this.mContext = context;
        init();
        AppMethodBeat.o(143500);
    }

    private void init() {
        AppMethodBeat.i(143501);
        this.paint = new Paint();
        AppMethodBeat.o(143501);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(143502);
        super.onDraw(canvas);
        getWidth();
        getHeight();
        if (!(this.yKs == null || this.yKs.getVisibility() == 4)) {
            int[] iArr = new int[2];
            this.yKs.getLocationInWindow(iArr);
            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                int width = this.yKs.getWidth();
                int height = this.yKs.getHeight();
                if (!(width == 0 || height == 0)) {
                    int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 50.0f);
                    this.yKt = iArr[0] + (width / 2);
                    this.yKu = (iArr[1] + (height / 2)) - (fromDPToPix / 2);
                    this.yKG = (float) (width / 2);
                    this.yKF = ((float) (width / 2)) * 2.0f;
                }
            }
        }
        if (this.yKt < 0 || this.yKu < 0) {
            AppMethodBeat.o(143502);
            return;
        }
        this.paint.setColor(this.yKA);
        this.paint.setAlpha(this.yKB);
        float fromDPToPix2 = (float) BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, this.radius);
        if (fromDPToPix2 > this.yKF) {
            fromDPToPix2 = this.yKF;
        }
        if (fromDPToPix2 < this.yKG) {
            fromDPToPix2 = this.yKG;
        }
        canvas.drawCircle((float) this.yKt, (float) this.yKu, fromDPToPix2, this.paint);
        AppMethodBeat.o(143502);
    }

    public void setVolume(float f2) {
        this.yKw = this.yKx;
        this.yKx = f2;
    }

    public void setArchView(View view) {
        this.yKs = view;
    }
}
