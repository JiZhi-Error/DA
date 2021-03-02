package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MemberCardTopCropImageView extends ImageView {
    public int itemPadding = -1;
    public int kn = -1;
    public int qmd = -1;
    private float qme;
    private Path qmf;
    private RectF qmg;
    private float radius;

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113915);
        init();
        AppMethodBeat.o(113915);
    }

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(113916);
        init();
        AppMethodBeat.o(113916);
    }

    public float getShowScale() {
        return this.qme;
    }

    public void setRadius(float f2) {
        AppMethodBeat.i(113917);
        this.radius = f2;
        if (f2 > 0.0f) {
            this.qmf = new Path();
            this.qmg = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        AppMethodBeat.o(113917);
    }

    private void init() {
        AppMethodBeat.i(113918);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.kn = a.aG(MMApplicationContext.getContext(), R.dimen.va);
        this.itemPadding = a.aG(MMApplicationContext.getContext(), R.dimen.ib) * 2;
        AppMethodBeat.o(113918);
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(113919);
        if (getDrawable() == null) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            AppMethodBeat.o(113919);
            return frame;
        }
        Matrix imageMatrix = getImageMatrix();
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        this.qmd = getContext().getResources().getDisplayMetrics().widthPixels - this.itemPadding;
        int i6 = this.qmd;
        int i7 = this.kn;
        if (intrinsicWidth * i7 > intrinsicHeight * i6) {
            this.qme = ((float) i7) / ((float) intrinsicHeight);
        } else {
            this.qme = ((float) i6) / ((float) intrinsicWidth);
        }
        imageMatrix.setScale(this.qme, this.qme);
        setImageMatrix(imageMatrix);
        boolean frame2 = super.setFrame(i2, i3, i4, i5);
        AppMethodBeat.o(113919);
        return frame2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(113920);
        if (!(this.qmg == null || this.qmf == null)) {
            this.qmg.right = (float) getWidth();
            this.qmg.bottom = (float) getHeight();
            this.qmf.addRoundRect(this.qmg, this.radius, this.radius, Path.Direction.CW);
            canvas.clipPath(this.qmf);
        }
        super.onDraw(canvas);
        AppMethodBeat.o(113920);
    }
}
