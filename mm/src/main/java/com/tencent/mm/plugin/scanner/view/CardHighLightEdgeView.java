package com.tencent.mm.plugin.scanner.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Arrays;

public class CardHighLightEdgeView extends View {
    private boolean[] CUR;
    private boolean[] CUS;
    private Rect CUT;
    private long CUU;
    private MMHandler CUV;
    private int tHg;
    private Paint xY;

    public CardHighLightEdgeView(Context context) {
        super(context);
        AppMethodBeat.i(118369);
        this.CUR = new boolean[4];
        this.CUS = new boolean[4];
        this.CUV = new MMHandler() {
            /* class com.tencent.mm.plugin.scanner.view.CardHighLightEdgeView.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(118368);
                CardHighLightEdgeView.this.CUU = System.currentTimeMillis();
                CardHighLightEdgeView.this.CUR = Arrays.copyOf(CardHighLightEdgeView.this.CUS, 4);
                CardHighLightEdgeView.this.invalidate();
                AppMethodBeat.o(118368);
            }
        };
        init();
        AppMethodBeat.o(118369);
    }

    public CardHighLightEdgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(118370);
        this.CUR = new boolean[4];
        this.CUS = new boolean[4];
        this.CUV = new MMHandler() {
            /* class com.tencent.mm.plugin.scanner.view.CardHighLightEdgeView.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(118368);
                CardHighLightEdgeView.this.CUU = System.currentTimeMillis();
                CardHighLightEdgeView.this.CUR = Arrays.copyOf(CardHighLightEdgeView.this.CUS, 4);
                CardHighLightEdgeView.this.invalidate();
                AppMethodBeat.o(118368);
            }
        };
        init();
        AppMethodBeat.o(118370);
    }

    public CardHighLightEdgeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(118371);
        this.CUR = new boolean[4];
        this.CUS = new boolean[4];
        this.CUV = new MMHandler() {
            /* class com.tencent.mm.plugin.scanner.view.CardHighLightEdgeView.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(118368);
                CardHighLightEdgeView.this.CUU = System.currentTimeMillis();
                CardHighLightEdgeView.this.CUR = Arrays.copyOf(CardHighLightEdgeView.this.CUS, 4);
                CardHighLightEdgeView.this.invalidate();
                AppMethodBeat.o(118368);
            }
        };
        init();
        AppMethodBeat.o(118371);
    }

    private void init() {
        AppMethodBeat.i(118372);
        this.tHg = a.decodeResource(getResources(), R.drawable.cmo).getWidth() / 4;
        this.xY = new Paint();
        this.xY.setColor(6676738);
        this.xY.setAlpha(255);
        this.xY.setStrokeWidth((float) this.tHg);
        this.xY.setStyle(Paint.Style.STROKE);
        AppMethodBeat.o(118372);
    }

    public void setCardRect(Rect rect) {
        AppMethodBeat.i(118373);
        this.CUT = new Rect(rect);
        AppMethodBeat.o(118373);
    }

    public void setHighLightEdges(boolean[] zArr) {
        long j2;
        boolean z = false;
        AppMethodBeat.i(118374);
        if (zArr.length == 4) {
            Log.d("MicroMsg.CardHighLightEdgeView", "%s,%s,%s,%s", Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Boolean.valueOf(zArr[2]), Boolean.valueOf(zArr[3]));
            int i2 = 0;
            while (true) {
                if (i2 >= 4) {
                    z = true;
                    break;
                } else if (this.CUR[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                j2 = 600 - (System.currentTimeMillis() - this.CUU);
            } else {
                j2 = 0;
            }
            this.CUS = Arrays.copyOf(zArr, 4);
            this.CUV.removeMessages(1);
            MMHandler mMHandler = this.CUV;
            if (j2 <= 0) {
                j2 = 0;
            }
            mMHandler.sendEmptyMessageDelayed(1, j2);
        }
        AppMethodBeat.o(118374);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(118375);
        super.onDraw(canvas);
        if (this.CUT != null) {
            if (this.CUR[0]) {
                canvas.drawLine((float) (this.CUT.left + (this.tHg / 2)), (float) this.CUT.top, (float) (this.CUT.left + (this.tHg / 2)), (float) this.CUT.bottom, this.xY);
            }
            if (this.CUR[1]) {
                canvas.drawLine((float) (this.CUT.right - (this.tHg / 2)), (float) this.CUT.top, (float) (this.CUT.right - (this.tHg / 2)), (float) this.CUT.bottom, this.xY);
            }
            if (this.CUR[2]) {
                canvas.drawLine((float) this.CUT.left, (float) (this.CUT.top + (this.tHg / 2)), (float) this.CUT.right, (float) (this.CUT.top + (this.tHg / 2)), this.xY);
            }
            if (this.CUR[3]) {
                canvas.drawLine((float) this.CUT.left, (float) (this.CUT.bottom - (this.tHg / 2)), (float) this.CUT.right, (float) (this.CUT.bottom - (this.tHg / 2)), this.xY);
            }
        }
        AppMethodBeat.o(118375);
    }
}
