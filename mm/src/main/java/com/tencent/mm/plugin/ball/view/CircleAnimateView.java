package com.tencent.mm.plugin.ball.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.content.b;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.gif.MMAnimateView;

public class CircleAnimateView extends MMAnimateView {
    private int defaultHeight;
    private int defaultWidth;
    private long progress = -2147483648L;

    public CircleAnimateView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(106370);
        eH(context);
        AppMethodBeat.o(106370);
    }

    public CircleAnimateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106371);
        eH(context);
        AppMethodBeat.o(106371);
    }

    private void eH(Context context) {
        AppMethodBeat.i(106372);
        this.defaultWidth = a.aH(context, R.dimen.a5s);
        this.defaultHeight = a.aH(context, R.dimen.a5s);
        AppMethodBeat.o(106372);
    }

    public void draw(Canvas canvas) {
        int measuredHeight;
        Canvas canvas2;
        Bitmap bitmap;
        int measuredHeight2;
        AppMethodBeat.i(106373);
        int width = getWidth() > 0 ? getWidth() : getMeasuredWidth() > 0 ? getMeasuredWidth() : this.defaultWidth;
        if (getWidth() > 0) {
            measuredHeight = getWidth();
        } else {
            measuredHeight = getMeasuredHeight() > 0 ? getMeasuredHeight() : this.defaultHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas3 = new Canvas(createBitmap);
        if (createBitmap.isRecycled()) {
            Bitmap createBitmap2 = Bitmap.createBitmap(width, measuredHeight, Bitmap.Config.ARGB_8888);
            canvas2 = new Canvas(createBitmap2);
            bitmap = createBitmap2;
        } else {
            canvas2 = canvas3;
            bitmap = createBitmap;
        }
        super.draw(canvas2);
        if (this.progress >= 0) {
            int width2 = getWidth() > 0 ? getWidth() : getMeasuredWidth() > 0 ? getMeasuredWidth() : this.defaultWidth;
            if (getWidth() > 0) {
                measuredHeight2 = getWidth();
            } else {
                measuredHeight2 = getMeasuredHeight() > 0 ? getMeasuredHeight() : this.defaultHeight;
            }
            float f2 = ((float) width2) / 2.0f;
            float f3 = ((float) measuredHeight2) / 2.0f;
            float fromDPToPix = (float) a.fromDPToPix(getContext(), 1.5f);
            float f4 = ((((float) width2) * 0.75f) / 2.0f) - fromDPToPix;
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(fromDPToPix);
            paint.setColor(b.n(getContext(), R.color.BW_0_Alpha_0_1));
            canvas2.drawCircle(f2, f3, f4, paint);
            paint.setColor(b.n(getContext(), R.color.afp));
            canvas2.drawArc(f2 - f4, f3 - f4, f2 + f4, f3 + f4, -90.0f, (((float) this.progress) / 100.0f) * 360.0f, false, paint);
        }
        int width3 = getWidth() > 0 ? getWidth() : getMeasuredWidth() > 0 ? getMeasuredWidth() : this.defaultWidth;
        int width4 = getWidth() > 0 ? getWidth() : getMeasuredHeight() > 0 ? getMeasuredHeight() : this.defaultHeight;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, (float) width3, (float) width4), (float) width3, (float) width4, Path.Direction.CW);
        path.setFillType(Path.FillType.INVERSE_WINDING);
        canvas2.drawPath(path, paint2);
        Paint paint3 = new Paint();
        paint3.setXfermode(null);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint3);
        bitmap.recycle();
        AppMethodBeat.o(106373);
    }

    public void setProgress(long j2) {
        AppMethodBeat.i(176974);
        this.progress = j2;
        postInvalidate();
        AppMethodBeat.o(176974);
    }
}
