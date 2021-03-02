package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a;

public class RoundCornerImageView extends AppCompatImageView {
    private int QEQ = 8;
    private int QER = 8;
    private Path QES = new Path();
    private RectF QET = new RectF();
    private Paint borderPaint;
    private Paint paint = new Paint();
    public int shadowColor;
    public int shadowDx;
    public int shadowDy;
    public int shadowRadius = 0;

    public RoundCornerImageView(Context context) {
        super(context);
        AppMethodBeat.i(205442);
        init(context, null);
        AppMethodBeat.o(205442);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143445);
        init(context, attributeSet);
        AppMethodBeat.o(143445);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143446);
        init(context, attributeSet);
        AppMethodBeat.o(143446);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(143447);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.RoundCornerImageView);
            this.QEQ = obtainStyledAttributes.getDimensionPixelSize(1, this.QEQ);
            this.QER = obtainStyledAttributes.getDimensionPixelSize(0, this.QER);
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(143447);
            return;
        }
        float f2 = context.getResources().getDisplayMetrics().density;
        this.QEQ = (int) (((float) this.QEQ) * f2);
        this.QER = (int) (f2 * ((float) this.QER));
        AppMethodBeat.o(143447);
    }

    public final void lx(int i2, int i3) {
        AppMethodBeat.i(205443);
        this.borderPaint = new Paint();
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setStrokeWidth((float) i2);
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setColor(i3);
        AppMethodBeat.o(205443);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(143448);
        if (getWidth() <= 0 || getHeight() <= 0) {
            super.draw(canvas);
            AppMethodBeat.o(143448);
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        if (createBitmap.isRecycled()) {
            createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            canvas2 = new Canvas(createBitmap);
        }
        super.draw(canvas2);
        this.paint.setAntiAlias(true);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.QET.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.QES.addRoundRect(this.QET, (float) this.QEQ, (float) this.QER, Path.Direction.CW);
        this.QES.setFillType(Path.FillType.INVERSE_WINDING);
        canvas2.drawPath(this.QES, this.paint);
        if (this.borderPaint != null) {
            float strokeWidth = this.borderPaint.getStrokeWidth() / 2.0f;
            canvas2.drawRoundRect(new RectF(strokeWidth, strokeWidth, ((float) getWidth()) - strokeWidth, ((float) getHeight()) - strokeWidth), (float) this.QEQ, (float) this.QER, this.borderPaint);
        }
        this.paint.reset();
        this.paint.setXfermode(null);
        if (this.shadowRadius > 0) {
            this.paint.setShadowLayer((float) this.shadowRadius, (float) this.shadowDx, (float) this.shadowDy, this.shadowColor);
        }
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.paint);
        createBitmap.recycle();
        AppMethodBeat.o(143448);
    }

    public final void ly(int i2, int i3) {
        this.QEQ = i2;
        this.QER = i3;
    }
}
