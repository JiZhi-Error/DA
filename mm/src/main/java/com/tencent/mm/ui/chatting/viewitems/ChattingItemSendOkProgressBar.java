package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.wxmm.v2helper;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar extends ProgressBar {
    private static SoftReference<Bitmap> POA = null;
    private static int POG;
    private static int POH;
    private static SoftReference<Bitmap> POy = null;
    private static SoftReference<Bitmap> POz = null;
    private Bitmap POB = null;
    private Bitmap POC = null;
    private Bitmap POD = null;
    private boolean POE = false;
    private a POF = null;
    private int POu = 0;
    private int POv = 0;
    private boolean POw = false;
    private boolean POx = false;
    private boolean iTN = false;
    private float rotation = 0.0f;

    public interface a {
    }

    static {
        AppMethodBeat.i(37374);
        POG = 0;
        POH = 0;
        POG = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
        POH = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6);
        AppMethodBeat.o(37374);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(37373);
        if (!this.POE) {
            super.onDraw(canvas);
            AppMethodBeat.o(37373);
            return;
        }
        canvas.saveLayerAlpha(new RectF(0.0f, 0.0f, (float) this.POB.getWidth(), (float) this.POB.getHeight()), 255, 31);
        if (!this.iTN) {
            canvas.drawBitmap(this.POD, new Rect(0, 0, this.POD.getWidth(), this.POD.getHeight()), new Rect(POG, POH, this.POD.getWidth() + POG, this.POD.getHeight() + POH), (Paint) null);
            AppMethodBeat.o(37373);
        } else if (!this.POw) {
            if (((int) (this.rotation - 270.0f)) % v2helper.VOIP_ENC_HEIGHT_LV1 != 0 || !this.POx) {
                Matrix matrix = new Matrix();
                matrix.setRotate(this.rotation, (float) (this.POB.getWidth() / 2), (float) (this.POB.getHeight() / 2));
                canvas.drawBitmap(this.POB, matrix, null);
                this.rotation += 6.0f;
                invalidate();
                AppMethodBeat.o(37373);
                return;
            }
            this.POw = true;
            invalidate();
            AppMethodBeat.o(37373);
        } else if (this.POu <= this.POC.getWidth()) {
            Matrix matrix2 = new Matrix();
            this.rotation += 6.0f;
            matrix2.setRotate(this.rotation, (float) (this.POB.getWidth() / 2), (float) (this.POB.getHeight() / 2));
            int i2 = ((int) this.rotation) % v2helper.VOIP_ENC_HEIGHT_LV1;
            if (i2 < 270) {
                i2 += v2helper.VOIP_ENC_HEIGHT_LV1;
            }
            if (i2 >= 270 && i2 < 450) {
                Paint paint = new Paint();
                paint.setColor(-16776961);
                canvas.drawBitmap(this.POB, matrix2, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                canvas.drawRect(0.0f, 0.0f, (float) this.POB.getWidth(), (float) (this.POB.getHeight() / 2), paint);
            }
            canvas.drawBitmap(this.POC, new Rect(0, 0, this.POu, this.POC.getHeight()), new Rect(POG, POH, this.POu + POG, this.POC.getHeight() + POH), (Paint) null);
            this.POu += 2;
            invalidate();
            AppMethodBeat.o(37373);
        } else {
            Rect rect = new Rect(0, 0, this.POC.getWidth(), this.POC.getHeight());
            Rect rect2 = new Rect(POG, POH, this.POC.getWidth() + POG, this.POC.getHeight() + POH);
            canvas.drawBitmap(this.POC, rect, rect2, (Paint) null);
            if (this.POv < 255) {
                Paint paint2 = new Paint();
                paint2.setAlpha(this.POv);
                canvas.drawBitmap(this.POD, rect, rect2, paint2);
                this.POv += 20;
                invalidate();
                AppMethodBeat.o(37373);
                return;
            }
            canvas.drawBitmap(this.POD, rect, rect2, (Paint) null);
            this.iTN = false;
            this.rotation = 0.0f;
            this.POu = 0;
            this.POv = 0;
            this.POx = false;
            this.POw = false;
            AppMethodBeat.o(37373);
        }
    }

    public void setDrawListener(a aVar) {
        this.POF = aVar;
    }

    public a getDrawListener() {
        return this.POF;
    }
}
