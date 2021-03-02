package com.tencent.mm.plugin.appbrand.widget.music;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a extends Drawable {
    private RectF hO;
    private Drawable oyW;
    float oyX;
    private int oyY = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.cb);
    private Paint paint;

    public a(Drawable drawable) {
        AppMethodBeat.i(133769);
        this.oyW = drawable;
        this.paint = new Paint(1);
        this.paint.setColor(MMApplicationContext.getResources().getColor(R.color.wq));
        AppMethodBeat.o(133769);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(133770);
        Drawable drawable = this.oyW;
        Rect bounds = drawable.getBounds();
        int i2 = bounds.right - bounds.left;
        int save = canvas.save();
        canvas.rotate(this.oyX, (((float) i2) * 0.5f) + ((float) bounds.left), ((float) bounds.top) + (((float) (bounds.bottom - bounds.top)) * 0.5f));
        canvas.drawOval(this.hO, this.paint);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
        AppMethodBeat.o(133770);
    }

    public final void setBounds(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(133771);
        if (this.oyW != null) {
            this.oyW.setBounds(i2, i3, i4, i5);
        }
        this.hO = new RectF((float) i2, (float) i3, (float) i4, (float) i5);
        AppMethodBeat.o(133771);
    }

    public final int getIntrinsicWidth() {
        return this.oyY;
    }

    public final int getIntrinsicHeight() {
        return this.oyY;
    }

    public final void setAlpha(int i2) {
        AppMethodBeat.i(133772);
        if (this.oyW != null) {
            this.oyW.setAlpha(i2);
        }
        this.paint.setAlpha(i2);
        AppMethodBeat.o(133772);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(133773);
        this.paint.setColorFilter(colorFilter);
        AppMethodBeat.o(133773);
    }

    public final int getOpacity() {
        AppMethodBeat.i(133774);
        if (this.oyW != null) {
            int opacity = this.oyW.getOpacity();
            AppMethodBeat.o(133774);
            return opacity;
        }
        AppMethodBeat.o(133774);
        return -2;
    }
}
