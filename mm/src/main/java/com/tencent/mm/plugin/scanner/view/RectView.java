package com.tencent.mm.plugin.scanner.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class RectView extends View {
    private Bitmap CLS = null;
    private Bitmap CLT = null;
    private Bitmap CLU = null;
    private Bitmap CLV = null;
    private Paint CMr = new Paint();
    int CVa = 0;
    int CVb = 0;
    private Paint paint = new Paint();
    private Rect rect;

    public RectView(Context context) {
        super(context);
        AppMethodBeat.i(91085);
        init();
        AppMethodBeat.o(91085);
    }

    public RectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(91086);
        init();
        AppMethodBeat.o(91086);
    }

    public RectView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(91087);
        init();
        AppMethodBeat.o(91087);
    }

    private void init() {
        AppMethodBeat.i(91088);
        this.CLS = BitmapFactory.decodeResource(getResources(), R.drawable.cmo);
        this.CLT = BitmapFactory.decodeResource(getResources(), R.drawable.cmp);
        this.CLU = BitmapFactory.decodeResource(getResources(), R.drawable.cmq);
        this.CLV = BitmapFactory.decodeResource(getResources(), R.drawable.cmr);
        this.CVa = this.CLS.getWidth();
        this.CVb = this.CLS.getHeight();
        this.paint.setAntiAlias(true);
        this.CMr.setAntiAlias(true);
        AppMethodBeat.o(91088);
    }

    public void setRect(Rect rect2) {
        this.rect = rect2;
    }

    public Rect getRect() {
        AppMethodBeat.i(91089);
        Rect rect2 = new Rect(this.rect);
        AppMethodBeat.o(91089);
        return rect2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(91090);
        super.onDraw(canvas);
        canvas.save();
        canvas.clipRect(this.rect, Region.Op.DIFFERENCE);
        canvas.drawRect(this.rect, this.paint);
        canvas.restore();
        canvas.drawBitmap(this.CLS, (float) this.rect.left, (float) this.rect.top, this.CMr);
        canvas.drawBitmap(this.CLT, (float) (this.rect.right - this.CVa), (float) this.rect.top, this.CMr);
        canvas.drawBitmap(this.CLU, (float) this.rect.left, (float) (this.rect.bottom - this.CVb), this.CMr);
        canvas.drawBitmap(this.CLV, (float) (this.rect.right - this.CVa), (float) (this.rect.bottom - this.CVb), this.CMr);
        AppMethodBeat.o(91090);
    }
}
