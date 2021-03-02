package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class NinePatchCropImageView extends AppCompatImageView {
    private RectF GPe = null;
    private NinePatch Rkb = null;
    private Drawable Rkc = null;
    private int Rkd = 0;
    private int Rke = 0;
    private boolean Rkf = true;
    private Paint paint = new Paint();

    public NinePatchCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(206176);
        init();
        AppMethodBeat.o(206176);
    }

    public NinePatchCropImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(206177);
        init();
        AppMethodBeat.o(206177);
    }

    private void init() {
        AppMethodBeat.i(206178);
        this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.paint.setAntiAlias(true);
        this.Rkc = getResources().getDrawable(R.color.BW_90);
        AppMethodBeat.o(206178);
    }

    public void setNinePatchId(int i2) {
        AppMethodBeat.i(206179);
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), i2);
        if (decodeResource != null) {
            this.Rkb = new NinePatch(decodeResource, decodeResource.getNinePatchChunk(), null);
        }
        AppMethodBeat.o(206179);
    }

    public final void lZ(int i2, int i3) {
        AppMethodBeat.i(206180);
        this.Rkd = i2;
        this.Rke = i3;
        invalidate();
        AppMethodBeat.o(206180);
    }

    public final void m(RectF rectF) {
        AppMethodBeat.i(206181);
        this.GPe = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        AppMethodBeat.o(206181);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float height;
        float f2;
        float f3;
        AppMethodBeat.i(206182);
        if (this.Rkb != null) {
            int saveLayer = canvas.saveLayer(null, null);
            if (this.Rkc != null) {
                this.Rkc.setBounds(0, 0, getWidth(), getHeight());
                this.Rkc.draw(canvas);
            }
            if (this.GPe != null && this.Rkf) {
                RectF rectF = this.GPe;
                RectF rectF2 = new RectF(rectF);
                if (rectF.width() > 1.0f) {
                    rectF2.left += 1.0f;
                    rectF2.right -= 1.0f;
                }
                if (rectF.height() > 1.0f) {
                    rectF2.top += 1.0f;
                    rectF2.bottom -= 1.0f;
                }
                canvas.clipRect(rectF2);
            }
            super.onDraw(canvas);
            float width = this.GPe == null ? (float) getWidth() : this.GPe.width();
            if (this.GPe == null) {
                height = (float) getHeight();
            } else {
                height = this.GPe.height();
            }
            if (!(this.Rke == 0 && this.Rkd == 0) && width > 0.0f && height > 0.0f) {
                int i2 = this.Rkd;
                int i3 = this.Rke;
                if (this.Rkd == 0) {
                    float f4 = height / ((float) this.Rke);
                    i2 = (int) ((width / height) * ((float) this.Rke));
                    f2 = f4;
                    f3 = f4;
                } else if (this.Rke == 0) {
                    float f5 = width / ((float) this.Rkd);
                    i3 = (int) ((height / width) * ((float) this.Rkd));
                    f2 = f5;
                    f3 = f5;
                } else {
                    f2 = width / ((float) this.Rkd);
                    f3 = height / ((float) this.Rke);
                }
                canvas.save();
                if (this.GPe != null) {
                    canvas.translate(this.GPe.left, this.GPe.top);
                }
                canvas.scale(f2, f3);
                this.Rkb.draw(canvas, new Rect(0, 0, i2, i3), this.paint);
                canvas.restore();
            } else {
                this.Rkb.draw(canvas, new Rect(0, 0, getWidth(), getHeight()), this.paint);
            }
            canvas.restoreToCount(saveLayer);
            AppMethodBeat.o(206182);
            return;
        }
        super.onDraw(canvas);
        AppMethodBeat.o(206182);
    }

    public void setEraseEdge(boolean z) {
        this.Rkf = z;
    }
}
