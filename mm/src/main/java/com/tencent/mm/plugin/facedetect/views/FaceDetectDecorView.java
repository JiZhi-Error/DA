package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceDetectDecorView extends View {
    public boolean sVK;
    public boolean sVL;
    public boolean sVM;
    public RectF sVN;
    private Paint sVO;

    public FaceDetectDecorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectDecorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(104134);
        this.sVK = false;
        this.sVL = false;
        this.sVM = false;
        this.sVN = null;
        this.sVO = null;
        this.sVO = new Paint();
        this.sVO.setColor(getResources().getColor(R.color.fm));
        this.sVO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        setLayerType(1, null);
        AppMethodBeat.o(104134);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(104135);
        super.onDraw(canvas);
        Log.i("MicroMsg.FaceDetectDecorView", "mTargetCoverMode: %b, mIsInCoverMode: %b, %s", Boolean.valueOf(this.sVL), Boolean.valueOf(this.sVK), this.sVN);
        if (this.sVL != this.sVK || this.sVM) {
            if (this.sVL) {
                canvas.drawColor(getResources().getColor(R.color.nx));
                canvas.drawRect(this.sVN, this.sVO);
            } else {
                canvas.drawColor(getResources().getColor(R.color.ac_));
            }
        }
        this.sVK = this.sVL;
        AppMethodBeat.o(104135);
    }
}
