package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public class HighlightRectSideView extends View {
    private Rect CKA;
    private int CKB;
    private int CKC;
    private int CKD;
    private int CKE = 0;
    private boolean[] CKz;
    private MTimerHandler cve = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.scanner.ui.HighlightRectSideView.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(51794);
            HighlightRectSideView.a(HighlightRectSideView.this);
            HighlightRectSideView.this.invalidate();
            AppMethodBeat.o(51794);
            return true;
        }
    }, true);
    private Paint xY;

    static /* synthetic */ int a(HighlightRectSideView highlightRectSideView) {
        int i2 = highlightRectSideView.CKE;
        highlightRectSideView.CKE = i2 + 1;
        return i2;
    }

    public HighlightRectSideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(51795);
        Bitmap decodeResource = a.decodeResource(getResources(), R.drawable.cmo);
        this.CKB = decodeResource.getWidth();
        this.CKC = decodeResource.getHeight();
        if (this.CKC != this.CKB) {
            Log.e("MicroMsg.HighlightRectSideView", "width is not same as height");
        }
        this.CKD = (this.CKB * 6) / 24;
        this.CKz = new boolean[4];
        this.xY = new Paint();
        this.xY.setColor(6676738);
        this.xY.setAlpha(255);
        this.xY.setStrokeWidth((float) this.CKD);
        this.xY.setStyle(Paint.Style.STROKE);
        AppMethodBeat.o(51795);
    }

    public void setMaskRect(Rect rect) {
        AppMethodBeat.i(51796);
        this.CKA = rect;
        Log.d("MicroMsg.HighlightRectSideView", "rect:%s", rect);
        AppMethodBeat.o(51796);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(51797);
        super.onAttachedToWindow();
        this.cve.startTimer(300);
        AppMethodBeat.o(51797);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(51798);
        super.onDetachedFromWindow();
        if (this.cve != null) {
            this.cve.stopTimer();
            this.cve = null;
        }
        AppMethodBeat.o(51798);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z;
        AppMethodBeat.i(51799);
        super.onDraw(canvas);
        int i2 = 0;
        while (true) {
            if (i2 >= 4) {
                z = true;
                break;
            } else if (!this.CKz[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        int i3 = this.CKD / 2;
        if (this.CKz[0] && (true == z || this.CKE % 2 == 0)) {
            canvas.drawLine((float) (this.CKA.left + i3), (float) (this.CKA.top + this.CKC), (float) (this.CKA.left + i3), (float) (this.CKA.bottom - this.CKC), this.xY);
        }
        if (this.CKz[1] && (true == z || this.CKE % 2 == 0)) {
            canvas.drawLine((float) (this.CKA.right - i3), (float) (this.CKA.top + this.CKC), (float) (this.CKA.right - i3), (float) (this.CKA.bottom - this.CKC), this.xY);
        }
        if (this.CKz[2] && (true == z || this.CKE % 3 == 0)) {
            canvas.drawLine((float) (this.CKA.left + this.CKB), (float) (this.CKA.top + i3), (float) (this.CKA.right - this.CKB), (float) (this.CKA.top + i3), this.xY);
        }
        if (this.CKz[3] && (true == z || this.CKE % 3 == 0)) {
            canvas.drawLine((float) (this.CKA.left + this.CKB), (float) (this.CKA.bottom - i3), (float) (this.CKA.right - this.CKB), (float) (this.CKA.bottom - i3), this.xY);
        }
        AppMethodBeat.o(51799);
    }

    public void setShowRectEdges(boolean[] zArr) {
        AppMethodBeat.i(51800);
        if (zArr == null || 4 != zArr.length) {
            AppMethodBeat.o(51800);
            return;
        }
        Log.d("MicroMsg.HighlightRectSideView", "%s, %s, %s, %s", Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Boolean.valueOf(zArr[2]), Boolean.valueOf(zArr[3]));
        for (int i2 = 0; i2 < 4; i2++) {
            this.CKz[i2] = zArr[i2];
        }
        invalidate();
        AppMethodBeat.o(51800);
    }
}
