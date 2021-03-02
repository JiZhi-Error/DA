package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g;

public class FixAspectRatioImageView extends AppCompatImageView {
    private int height;
    private int radius = 0;
    private float tEJ = 0.0f;
    private int width;
    private int xzL = 0;
    private int xzM = 0;
    private int xzN = 0;
    private int xzO = 0;

    public FixAspectRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40891);
        c(context, attributeSet, 0);
        AppMethodBeat.o(40891);
    }

    public FixAspectRatioImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(40892);
        c(context, attributeSet, i2);
        AppMethodBeat.o(40892);
    }

    private void c(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(40893);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.FixAspectRatioImageView, i2, 0);
        this.tEJ = obtainStyledAttributes.getFloat(0, 0.0f);
        this.radius = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
        this.xzL = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.xzM = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
        this.xzN = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.xzO = obtainStyledAttributes.getDimensionPixelOffset(4, 0);
        this.xzL = this.xzL == 0 ? this.radius : this.xzL;
        this.xzM = this.xzM == 0 ? this.radius : this.xzM;
        this.xzN = this.xzN == 0 ? this.radius : this.xzN;
        this.xzO = this.xzO == 0 ? this.radius : this.xzO;
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(40893);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(40894);
        if (this.tEJ != 0.0f) {
            int size = View.MeasureSpec.getSize(i2);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (this.tEJ * ((float) size)), 1073741824));
            AppMethodBeat.o(40894);
            return;
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(40894);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(204107);
        super.onLayout(z, i2, i3, i4, i5);
        this.width = getWidth();
        this.height = getHeight();
        AppMethodBeat.o(204107);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(204108);
        int max = Math.max(this.xzL, this.xzN) + Math.max(this.xzM, this.xzO);
        int max2 = Math.max(this.xzL, this.xzM) + Math.max(this.xzN, this.xzO);
        if (this.width >= max && this.height >= max2) {
            Path path = new Path();
            path.moveTo((float) this.xzL, 0.0f);
            path.lineTo((float) (this.width - this.xzM), 0.0f);
            path.quadTo((float) this.width, 0.0f, (float) this.width, (float) this.xzM);
            path.lineTo((float) this.width, (float) (this.height - this.xzO));
            path.quadTo((float) this.width, (float) this.height, (float) (this.width - this.xzO), (float) this.height);
            path.lineTo((float) this.xzN, (float) this.height);
            path.quadTo(0.0f, (float) this.height, 0.0f, (float) (this.height - this.xzN));
            path.lineTo(0.0f, (float) this.xzL);
            path.quadTo(0.0f, 0.0f, (float) this.xzL, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
        AppMethodBeat.o(204108);
    }
}
