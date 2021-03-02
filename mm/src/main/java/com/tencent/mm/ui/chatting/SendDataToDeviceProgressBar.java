package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMHandler;

/* access modifiers changed from: package-private */
public class SendDataToDeviceProgressBar extends ImageView {
    private int bottom;
    private MMHandler hAk;
    private int left;
    private Context mContext;
    private Paint mPaint;
    private int rHF;
    private int rHG;
    private Runnable rHH;
    private int right;
    private int top;
    private int vXu;

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SendDataToDeviceProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(34884);
        this.rHF = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.rHG = -1;
        this.vXu = 10;
        this.rHH = new Runnable() {
            /* class com.tencent.mm.ui.chatting.SendDataToDeviceProgressBar.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(34883);
                SendDataToDeviceProgressBar.this.invalidate();
                AppMethodBeat.o(34883);
            }
        };
        setImageResource(R.drawable.apj);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.left = this.mContext.getResources().getDimensionPixelSize(R.dimen.aim);
        this.top = this.left;
        this.rHG = this.mContext.getResources().getDimensionPixelSize(R.dimen.ain);
        this.hAk = new MMHandler(Looper.getMainLooper());
        AppMethodBeat.o(34884);
    }

    public final void amr(int i2) {
        AppMethodBeat.i(34885);
        if (i2 >= 100) {
            i2 = 100;
        }
        this.rHF = (int) ((((float) i2) / 100.0f) * 360.0f);
        gOp();
        AppMethodBeat.o(34885);
    }

    public final int getProgress() {
        return (int) ((((float) this.rHF) / 360.0f) * 100.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(34886);
        super.onDraw(canvas);
        int width = getWidth() / 2;
        this.mPaint.setColor(this.mContext.getResources().getColor(R.color.a4l));
        this.mPaint.setStrokeWidth((float) this.rHG);
        if (this.right == -1) {
            this.right = (width * 2) - this.left;
        }
        if (this.bottom == -1) {
            this.bottom = this.right;
        }
        RectF rectF = new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom);
        canvas.drawArc(rectF, 270.0f, (float) this.rHF, false, this.mPaint);
        int i2 = this.rHF + 270;
        if (i2 > 360) {
            i2 -= 360;
        }
        this.mPaint.setColor(this.mContext.getResources().getColor(R.color.a4i));
        canvas.drawArc(rectF, (float) i2, (float) (360 - this.rHF), false, this.mPaint);
        AppMethodBeat.o(34886);
    }

    private void gOp() {
        AppMethodBeat.i(34887);
        this.hAk.removeCallbacks(this.rHH);
        this.hAk.postDelayed(this.rHH, 0);
        AppMethodBeat.o(34887);
    }
}
