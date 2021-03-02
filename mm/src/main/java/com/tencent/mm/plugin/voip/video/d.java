package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends View {
    public int HhA;
    private int HhB;
    private int HhC;
    private int HhD;
    private int HhE;
    private boolean HhF;
    private int HhG;
    public int Hhy;
    public int Hhz;
    private Matrix mMatrix;
    private Paint mPaint = new Paint();
    private RectF nYV;
    public int sT;

    public d(Context context) {
        super(context);
        AppMethodBeat.i(115580);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(-65536);
        this.mPaint.setStrokeWidth((float) a.fromDPToPix(getContext(), 3));
        this.mMatrix = new Matrix();
        AppMethodBeat.o(115580);
    }

    public final void setFaceLocation(int[] iArr) {
        int i2;
        int i3;
        float f2;
        float f3;
        AppMethodBeat.i(115581);
        if (iArr != null) {
            this.HhB = iArr[0];
            this.HhC = iArr[1];
            this.HhD = iArr[2];
            this.HhE = iArr[3];
            if (!(this.Hhz == 0 || this.HhA == 0 || this.sT == 0 || this.Hhy == 0)) {
                int i4 = this.HhD - this.HhB;
                int i5 = this.HhE - this.HhC;
                Log.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", Integer.valueOf(this.HhB), Integer.valueOf(this.HhC), Integer.valueOf(this.HhD), Integer.valueOf(this.HhD));
                Log.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", Integer.valueOf(this.Hhz), Integer.valueOf(this.HhA), Boolean.valueOf(this.HhF), Integer.valueOf(this.HhG));
                int i6 = (this.HhD + this.HhB) / 2;
                int i7 = (this.HhE + this.HhC) / 2;
                if (this.HhG == 90 || this.HhG == 270) {
                    i3 = i6;
                    i2 = i7;
                } else {
                    i3 = i7;
                    i2 = i6;
                }
                Log.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (this.HhG == 90 || this.HhG == 270) {
                    f2 = (float) (this.sT / this.Hhz);
                    f3 = (float) (this.Hhy / this.HhA);
                } else {
                    f2 = (float) (this.Hhy / this.Hhz);
                    f3 = (float) (this.sT / this.HhA);
                }
                float max = Math.max(f2, f3);
                float f4 = (float) ((int) (((float) i4) * max));
                float f5 = (float) ((int) (((float) i5) * max));
                int i8 = (int) (((float) i2) * max);
                int i9 = (int) (((float) i3) * max);
                this.HhB = di((int) (((float) i8) - (f4 / 2.0f)), this.Hhy);
                this.HhC = di((int) (((float) i9) - (f5 / 2.0f)), this.sT);
                this.HhD = di((int) (((float) i8) + (f4 / 2.0f)), this.Hhy);
                this.HhE = di((int) (((float) i9) + (f5 / 2.0f)), this.sT);
                this.nYV = new RectF((float) this.HhB, (float) this.HhC, (float) this.HhD, (float) this.HhE);
                Log.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", Float.valueOf(this.nYV.left), Float.valueOf(this.nYV.top), Float.valueOf(this.nYV.right), Float.valueOf(this.nYV.bottom));
            }
        }
        AppMethodBeat.o(115581);
    }

    private static int di(int i2, int i3) {
        int i4;
        if (i2 < 0) {
            i4 = 0;
        } else {
            i4 = i2;
        }
        return i4 > i3 ? i3 : i4;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(115582);
        if (this.nYV != null) {
            canvas.save();
            canvas.rotate(0.0f);
            canvas.drawRect(this.nYV, this.mPaint);
            canvas.restore();
        }
        AppMethodBeat.o(115582);
    }

    public final void setMirror(boolean z) {
        this.HhF = z;
    }

    public final void setRotateAngle(int i2) {
        this.HhG = i2;
    }
}
