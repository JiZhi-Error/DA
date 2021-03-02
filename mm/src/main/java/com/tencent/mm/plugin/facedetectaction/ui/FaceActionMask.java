package com.tencent.mm.plugin.facedetectaction.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class FaceActionMask extends RelativeLayout {
    private Rect rect = new Rect();
    private Paint sXU = new Paint(1);
    private Paint sXV;
    private PorterDuffXfermode sXW;
    private boolean sXX = false;

    public FaceActionMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(104229);
        this.sXU.setStyle(Paint.Style.FILL);
        this.sXV = new Paint(1);
        setWillNotDraw(false);
        this.sXW = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        setLayerType(1, null);
        AppMethodBeat.o(104229);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(104230);
        canvas.save();
        float width = (float) (((double) getWidth()) * 0.35d);
        float width2 = (float) (((double) getWidth()) * 0.5d);
        float height = (float) (((double) getHeight()) * 0.4d);
        this.rect.left = 0;
        this.rect.right = getWidth();
        this.rect.top = 0;
        this.rect.bottom = getHeight();
        this.sXU.setColor(getContext().getResources().getColor(R.color.afz));
        canvas.drawARGB(255, 0, 0, 0);
        canvas.drawRect(this.rect, this.sXU);
        if (!this.sXX) {
            this.sXV.setStyle(Paint.Style.FILL_AND_STROKE);
            this.sXV.setXfermode(this.sXW);
            canvas.drawCircle(width2, height, width, this.sXV);
        }
        canvas.restore();
        AppMethodBeat.o(104230);
    }
}
