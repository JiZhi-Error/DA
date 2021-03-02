package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public class TabIconView extends ImageView {
    private int OLA = 0;
    private Bitmap OLu;
    private Bitmap OLv;
    private Bitmap OLw;
    private Rect OLx;
    private Rect OLy;
    private Rect OLz;
    private Paint bBJ;
    private Context mContext;
    private Paint paint;
    private float scale = 1.1666666f;

    public TabIconView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
    }

    public TabIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public final void i(int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(33778);
        if (z) {
            this.scale *= 1.2f;
        }
        this.OLu = BitmapUtil.getBitmapNative(i2, this.scale);
        this.OLv = BitmapUtil.getBitmapNative(i4, this.scale);
        this.OLw = BitmapUtil.getBitmapNative(i3, this.scale);
        if (this.OLu != null) {
            this.OLx = new Rect(0, 0, this.OLu.getWidth(), this.OLu.getHeight());
        }
        if (this.OLv != null) {
            this.OLy = new Rect(0, 0, this.OLv.getWidth(), this.OLv.getHeight());
        }
        if (this.OLw != null) {
            this.OLz = new Rect(0, 0, this.OLw.getWidth(), this.OLw.getHeight());
        }
        this.paint = new Paint(1);
        this.bBJ = new Paint(1);
        this.bBJ.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(R.color.FG_0), PorterDuff.Mode.SRC_ATOP));
        this.paint.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(R.color.afp), PorterDuff.Mode.SRC_ATOP));
        AppMethodBeat.o(33778);
    }

    public void setFocusAlpha(int i2) {
        AppMethodBeat.i(33779);
        this.OLA = i2;
        invalidate();
        AppMethodBeat.o(33779);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(33780);
        super.onDraw(canvas);
        if (this.paint == null) {
            AppMethodBeat.o(33780);
        } else if (this.OLA < 128) {
            this.bBJ.setAlpha(255 - this.OLA);
            canvas.drawBitmap(this.OLv, (Rect) null, this.OLy, this.bBJ);
            this.paint.setAlpha(this.OLA);
            canvas.drawBitmap(this.OLw, (Rect) null, this.OLz, this.paint);
            AppMethodBeat.o(33780);
        } else {
            this.paint.setAlpha(255 - this.OLA);
            canvas.drawBitmap(this.OLw, (Rect) null, this.OLz, this.paint);
            this.paint.setAlpha(this.OLA);
            canvas.drawBitmap(this.OLu, (Rect) null, this.OLx, this.paint);
            AppMethodBeat.o(33780);
        }
    }
}
