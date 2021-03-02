package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a;

public class RoundedCornerFrameLayout extends FrameLayout {
    private Bitmap Afd;
    private a QEZ;
    private Paint paint;

    public RoundedCornerFrameLayout(Context context) {
        super(context);
        AppMethodBeat.i(143450);
        c(context, null, 0);
        AppMethodBeat.o(143450);
    }

    public RoundedCornerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143451);
        c(context, attributeSet, 0);
        AppMethodBeat.o(143451);
    }

    public RoundedCornerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143452);
        c(context, attributeSet, i2);
        AppMethodBeat.o(143452);
    }

    private void c(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(143453);
        float dimension = context.obtainStyledAttributes(attributeSet, a.C0244a.RoundedCornerFrameLayout, i2, 0).getDimension(0, 0.0f);
        this.QEZ = new a(dimension, dimension, dimension, dimension);
        this.paint = new Paint(1);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setWillNotDraw(false);
        AppMethodBeat.o(143453);
    }

    public void setRadius(float f2) {
        AppMethodBeat.i(143454);
        s(f2, f2, f2, f2);
        AppMethodBeat.o(143454);
    }

    public final void s(float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(143455);
        this.QEZ.QEV = f2;
        this.QEZ.QEW = f3;
        this.QEZ.QEX = f4;
        this.QEZ.QEY = f5;
        if (this.Afd != null) {
            this.Afd = null;
            postInvalidate();
        }
        AppMethodBeat.o(143455);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(143456);
        super.onLayout(z, i2, i3, i4, i5);
        this.Afd = null;
        AppMethodBeat.o(143456);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(143457);
        if (canvas.getWidth() <= 0 || canvas.getHeight() <= 0) {
            AppMethodBeat.o(143457);
            return;
        }
        int saveLayer = canvas.saveLayer(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight()), null, 31);
        super.draw(canvas);
        if (this.QEZ.QEV > 0.0f || this.QEZ.QEW > 0.0f || this.QEZ.QEX > 0.0f || this.QEZ.QEY > 0.0f) {
            if (this.Afd == null) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ALPHA_8);
                Canvas canvas2 = new Canvas(createBitmap);
                Path path = new Path();
                path.addRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), new float[]{this.QEZ.QEV, this.QEZ.QEV, this.QEZ.QEW, this.QEZ.QEW, this.QEZ.QEY, this.QEZ.QEY, this.QEZ.QEX, this.QEZ.QEX}, Path.Direction.CCW);
                path.setFillType(Path.FillType.WINDING);
                canvas2.drawPath(path, new Paint(1));
                this.Afd = createBitmap;
            }
            canvas.drawBitmap(this.Afd, 0.0f, 0.0f, this.paint);
        }
        canvas.restoreToCount(saveLayer);
        AppMethodBeat.o(143457);
    }

    /* access modifiers changed from: package-private */
    public class a {
        float QEV;
        float QEW;
        float QEX;
        float QEY;

        a(float f2, float f3, float f4, float f5) {
            this.QEV = f2;
            this.QEW = f3;
            this.QEX = f4;
            this.QEY = f5;
        }
    }
}
