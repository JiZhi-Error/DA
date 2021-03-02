package com.tencent.mm.plugin.ball.view;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends View {
    public int mHeight;
    private Paint mPaint = new Paint();
    public int mWidth;
    private Paint oZj = new Paint();
    private Bitmap pcQ;
    private Path pcR = new Path();
    private Rect pcS;
    private RectF pcT;
    private int pcU;
    public int pcV;
    public int pcW;
    public int pcX;
    public int pcY = -1;
    public boolean pcZ;
    private int pda;
    private AnimatorListenerAdapter pdb;

    public e(Context context, Bitmap bitmap) {
        super(context);
        AppMethodBeat.i(106522);
        this.oZj.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.pcQ = bitmap;
        this.mWidth = bitmap.getWidth();
        this.mHeight = bitmap.getHeight();
        this.pcS = new Rect(0, 0, this.mWidth, this.mHeight);
        this.pcT = new RectF();
        this.pcT.left = 0.0f;
        this.pcT.top = 0.0f;
        this.pcT.right = (float) this.mWidth;
        this.pcT.bottom = (float) this.mHeight;
        Log.i("MicroMsg.TransformToFloatBallAnimationMaskView", String.format("init: mWidth:%d mHeight:%d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)));
        AppMethodBeat.o(106522);
    }

    public final void setContentStartPosX(int i2) {
        this.pcY = i2;
    }

    public final void setListener(AnimatorListenerAdapter animatorListenerAdapter) {
        this.pdb = animatorListenerAdapter;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(106523);
        if (this.pcZ) {
            canvas.translate((float) this.pcU, 0.0f);
        } else {
            canvas.drawColor(Color.argb(this.pda, 0, 0, 0));
        }
        this.pcR.reset();
        this.pcR.addRoundRect(this.pcT, (float) this.pcV, (float) this.pcV, Path.Direction.CW);
        canvas.clipPath(this.pcR);
        canvas.drawBitmap(this.pcQ, this.pcS, this.pcS, this.mPaint);
        AppMethodBeat.o(106523);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(106524);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
        AppMethodBeat.o(106524);
    }
}
