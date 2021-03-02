package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class WebViewBagBgView extends View {
    int FNL;
    private int JkK = -7829368;
    private int JkL = -65536;
    private float JkM = 0.0f;
    private float JkN;
    private float JkO;
    private int JkP;
    private int JkQ;
    boolean JkR;
    private RectF JkS;
    int atU;
    private Paint mPaint = new Paint();
    long mStartTime;

    public WebViewBagBgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(80429);
        this.mPaint.setAntiAlias(true);
        this.JkQ = -1;
        AppMethodBeat.o(80429);
    }

    public void setStartColor(int i2) {
        this.JkK = i2;
    }

    public void setAngryColor(int i2) {
        this.JkL = i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(80430);
        super.onDraw(canvas);
        if (this.JkO == this.JkN) {
            this.JkN -= 0.001f;
        }
        this.mPaint.setShader(new LinearGradient(0.0f, this.JkN, 0.0f, this.JkO, new int[]{this.JkK, this.JkL}, (float[]) null, Shader.TileMode.CLAMP));
        canvas.drawOval(this.JkS, this.mPaint);
        if (this.JkR && this.JkO > 0.0f) {
            this.JkN -= this.JkM;
            this.JkN = this.JkN < ((float) (-this.JkP)) ? (float) (-this.JkP) : this.JkN;
            this.JkO = ((float) this.JkQ) - this.JkN < ((float) this.JkP) ? (float) this.JkQ : this.JkN + ((float) this.JkP);
            postInvalidateDelayed((long) this.FNL);
        }
        AppMethodBeat.o(80430);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(80431);
        super.onMeasure(i2, i3);
        this.JkQ = View.MeasureSpec.getSize(i2);
        this.JkS = new RectF(0.0f, 0.0f, (float) this.JkQ, (float) this.JkQ);
        this.JkP = this.JkQ / 2;
        Mg(System.currentTimeMillis());
        AppMethodBeat.o(80431);
    }

    /* access modifiers changed from: package-private */
    public final void Mg(long j2) {
        float f2;
        WebViewBagBgView webViewBagBgView;
        AppMethodBeat.i(80432);
        if (this.JkQ < 0) {
            Log.i("MicroMsg.WebViewBagBgView", "doUpdateAngryInfo not measured, mDiameter:%d", Integer.valueOf(this.JkQ));
            AppMethodBeat.o(80432);
            return;
        }
        this.JkM = ((float) (this.JkQ * 2)) / (((float) this.atU) / ((float) this.FNL));
        if (j2 - this.mStartTime <= 0) {
            f2 = (float) this.JkQ;
            webViewBagBgView = this;
        } else {
            this.JkN = ((float) this.JkQ) - (((float) (((int) (((float) (j2 - this.mStartTime)) / ((float) this.FNL))) + 1)) * this.JkM);
            if (this.JkN < ((float) (-this.JkP))) {
                f2 = (float) (-this.JkP);
                webViewBagBgView = this;
            } else {
                f2 = this.JkN;
                webViewBagBgView = this;
            }
        }
        webViewBagBgView.JkN = f2;
        this.JkO = ((float) this.JkQ) - this.JkN < ((float) this.JkP) ? (float) this.JkQ : this.JkN + ((float) this.JkP);
        AppMethodBeat.o(80432);
    }
}
