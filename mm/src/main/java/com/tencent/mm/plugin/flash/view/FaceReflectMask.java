package com.tencent.mm.plugin.flash.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;

public class FaceReflectMask extends YTReflectLayout {
    private static final int wIW = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.bt);
    private Paint lun;
    private ColorMatrixColorFilter mColorMatrixColorFilter;
    private float progress = 0.0f;
    private Rect rect = new Rect();
    private Paint sXU;
    private Paint sXV;
    private PorterDuffXfermode sXW;
    private boolean sXX = false;
    private boolean wIX;
    private a wIY;
    private float y = 0.0f;

    public interface a {
        void dKQ();
    }

    static {
        AppMethodBeat.i(186723);
        AppMethodBeat.o(186723);
    }

    public FaceReflectMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(186718);
        setLayerType(1, null);
        this.sXU = new Paint(1);
        this.sXU.setStyle(Paint.Style.FILL);
        this.sXV = new Paint(1);
        this.sXV.setColor(com.tencent.mm.cb.a.n(getContext(), R.color.ac_));
        this.lun = new Paint(1);
        this.lun.setStyle(Paint.Style.STROKE);
        this.lun.setStrokeWidth((float) wIW);
        this.lun.setColor(com.tencent.mm.cb.a.n(getContext(), R.color.BW_100_Alpha_0_8));
        setWillNotDraw(false);
        this.sXW = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.wIX = true;
        AppMethodBeat.o(186718);
    }

    @Override // com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout
    public void setColorMatrixColorFilter(ColorMatrixColorFilter colorMatrixColorFilter) {
        AppMethodBeat.i(186719);
        Log.i("MicroMsg.FaceReflectMask", "setColorMatrixColorFilter");
        this.mColorMatrixColorFilter = colorMatrixColorFilter;
        postInvalidate();
        AppMethodBeat.o(186719);
    }

    public final void dLo() {
        AppMethodBeat.i(186720);
        setColorMatrixColorFilter(new ColorMatrixColorFilter(new float[]{1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        AppMethodBeat.o(186720);
    }

    public void setProgress(float f2) {
        AppMethodBeat.i(186721);
        Log.d("MicroMsg.FaceReflectMask", "setProgress :%s", Float.valueOf(f2));
        if (f2 <= 0.0f) {
            this.progress = 0.0f;
        } else if (f2 <= 1.0f) {
            this.progress = f2;
        } else if (((double) f2) <= 1.05d) {
            this.progress = 1.0f;
        } else {
            AppMethodBeat.o(186721);
            return;
        }
        postInvalidate();
        AppMethodBeat.o(186721);
    }

    @Override // com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(186722);
        canvas.save();
        float min = ((float) Math.min(getWidth(), getHeight())) * 0.27f;
        float width = (float) (((double) getWidth()) * 0.5d);
        this.y = ((float) com.tencent.mm.cb.a.aG(getContext(), R.dimen.a3r)) + min;
        this.rect.left = 0;
        this.rect.right = getWidth();
        this.rect.top = 0;
        this.rect.bottom = getHeight();
        this.sXU.setColor(-1);
        if (this.mColorMatrixColorFilter != null) {
            this.sXU.setColorFilter(this.mColorMatrixColorFilter);
        }
        canvas.drawARGB(255, 0, 0, 0);
        canvas.drawRect(this.rect, this.sXU);
        if (!this.sXX) {
            setAlpha(0.998f);
            this.sXV.setStyle(Paint.Style.FILL_AND_STROKE);
            this.sXV.setXfermode(this.sXW);
            canvas.drawCircle(width, this.y, min, this.sXV);
        }
        canvas.drawArc((width - min) + ((float) (wIW >> 1)), (this.y - min) + ((float) (wIW >> 1)), (width + min) - ((float) (wIW >> 1)), (min + this.y) - ((float) (wIW >> 1)), -90.0f, this.progress * 360.0f, false, this.lun);
        canvas.restore();
        if (this.wIY != null) {
            this.wIY.dKQ();
            this.wIY = null;
        }
        AppMethodBeat.o(186722);
    }

    public float getCircleY() {
        return this.y;
    }

    public void setCallback(a aVar) {
        this.wIY = aVar;
    }
}
