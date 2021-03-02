package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class FreeWifiStateView extends ImageView {
    private int bottom;
    private MMHandler hAk;
    private int left;
    private Context mContext;
    private Paint mPaint;
    int rHF;
    private int rHG;
    private Runnable rHH;
    private int right;
    private int state;
    private int top;

    public FreeWifiStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FreeWifiStateView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(25140);
        this.rHF = 2;
        this.left = -1;
        this.top = -1;
        this.right = -1;
        this.bottom = -1;
        this.rHG = -1;
        this.rHH = new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiStateView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(25139);
                FreeWifiStateView.this.invalidate();
                AppMethodBeat.o(25139);
            }
        };
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.left = a.fromDPToPix(this.mContext, 2);
        this.top = this.left;
        this.rHG = a.fromDPToPix(this.mContext, 3);
        this.hAk = new MMHandler(Looper.getMainLooper());
        AppMethodBeat.o(25140);
    }

    public void setState(int i2) {
        AppMethodBeat.i(25141);
        this.state = i2;
        GF(10);
        AppMethodBeat.o(25141);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(25142);
        super.onDraw(canvas);
        if (this.state == 1) {
            int width = getWidth() / 2;
            this.mPaint.setARGB(255, 103, 209, 79);
            this.mPaint.setStrokeWidth((float) this.rHG);
            if (this.right == -1) {
                this.right = (width * 2) - this.left;
            }
            if (this.bottom == -1) {
                this.bottom = this.right;
            }
            canvas.drawArc(new RectF((float) this.left, (float) this.top, (float) this.right, (float) this.bottom), 270.0f, (float) this.rHF, false, this.mPaint);
            this.rHF += 5;
            if (this.rHF > 365) {
                this.rHF = 0;
            }
            GF(100);
        }
        AppMethodBeat.o(25142);
    }

    private void GF(int i2) {
        AppMethodBeat.i(25143);
        this.hAk.removeCallbacks(this.rHH);
        this.hAk.postDelayed(this.rHH, (long) i2);
        AppMethodBeat.o(25143);
    }
}
