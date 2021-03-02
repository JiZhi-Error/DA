package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.g.b.c;

public class MultiTouchImageView extends ImageView implements g {
    private g.a CIB;
    private final float[] DZ;
    private boolean EEg;
    protected Bitmap EiY;
    protected Matrix OUN;
    private final Matrix OUO;
    int OUP;
    int OUQ;
    private float OUR;
    private float OUS;
    private float OUT;
    private Float OUU;
    private boolean OUV;
    private float OUW;
    private float OUX;
    private float OUY;
    private float OUZ;
    public float OVa;
    private boolean OVb;
    private float OVc;
    private float OVd;
    private a OVe;
    float OVf;
    public boolean OVg;
    public Drawable OVh;
    public boolean aXp;
    public boolean aXq;
    protected Matrix aYH;
    private float aYU;
    private boolean dXX;
    private int gRD;
    private int gRE;
    private Paint hob;
    private boolean iCs;
    private int imageHeight;
    private int imageWidth;
    private float lPE;
    protected MMHandler mHandler;

    public interface a {
    }

    @Override // com.tencent.mm.ui.base.g
    public final boolean gKw() {
        return this.aXq;
    }

    @Override // com.tencent.mm.ui.base.g
    public final boolean gKx() {
        return this.aXp;
    }

    public float getScaleWidth() {
        return this.OVc;
    }

    public float getScaleHeight() {
        return this.OVd;
    }

    public float getMaxZoom() {
        return this.lPE;
    }

    public float getMinZoom() {
        return this.OUS;
    }

    @Override // com.tencent.mm.ui.base.g
    public void setMaxZoomLimit(float f2) {
        AppMethodBeat.i(142340);
        if (Float.compare(f2, 1.0f) < 0) {
            Log.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
            AppMethodBeat.o(142340);
            return;
        }
        this.OUY = f2;
        AppMethodBeat.o(142340);
    }

    public void setMinZoomLimit(float f2) {
        AppMethodBeat.i(142341);
        if (Float.compare(f2, 1.0f) > 0) {
            Log.w("MicroMsg.MultiTouchImageView", "min scale limit is greater than 1.0, change nothing, return");
            AppMethodBeat.o(142341);
        } else if (Float.compare(f2, 0.0f) < 0) {
            Log.w("MicroMsg.MultiTouchImageView", "min scale limit is less than 0.0, change nothing, return");
            AppMethodBeat.o(142341);
        } else {
            this.OUX = f2;
            AppMethodBeat.o(142341);
        }
    }

    public void setDoubleTabScaleLimit(float f2) {
        AppMethodBeat.i(142342);
        if (Float.compare(f2, 0.0f) < 0) {
            Log.w("MicroMsg.MultiTouchImageView", "double tab scale limit is less than 0.0, change nothing, return");
            AppMethodBeat.o(142342);
            return;
        }
        this.OUW = f2;
        AppMethodBeat.o(142342);
    }

    public void setMaxZoomDoubleTab(boolean z) {
        this.OVb = z;
    }

    public void setOriginScale(float f2) {
        this.OUZ = f2;
    }

    public float getOriginScale() {
        return this.OUZ;
    }

    private MultiTouchImageView(Context context, int i2, int i3) {
        super(context);
        AppMethodBeat.i(142343);
        this.OUN = new Matrix();
        this.aYH = new Matrix();
        this.OUO = new Matrix();
        this.DZ = new float[9];
        this.EiY = null;
        this.OUP = -1;
        this.OUQ = -1;
        this.OUR = 0.0f;
        this.lPE = 0.0f;
        this.OUS = 0.0f;
        this.iCs = false;
        this.dXX = false;
        this.OUV = true;
        this.OUW = 2.0f;
        this.OUX = 0.75f;
        this.OUY = 20.0f;
        this.OUZ = 0.0f;
        this.OVa = 1.0f;
        this.OVb = false;
        this.aXq = false;
        this.aXp = false;
        this.EEg = true;
        this.hob = null;
        this.mHandler = new MMHandler();
        this.aYU = 1.0f;
        this.OVf = 0.0f;
        this.OVg = false;
        this.imageHeight = i3;
        this.imageWidth = i2;
        this.OVe = null;
        init();
        AppMethodBeat.o(142343);
    }

    public MultiTouchImageView(Context context, int i2, int i3, byte b2) {
        this(context, i2, i3);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private MultiTouchImageView(Context context, AttributeSet attributeSet, byte b2) {
        super(context, attributeSet);
        AppMethodBeat.i(142344);
        this.OUN = new Matrix();
        this.aYH = new Matrix();
        this.OUO = new Matrix();
        this.DZ = new float[9];
        this.EiY = null;
        this.OUP = -1;
        this.OUQ = -1;
        this.OUR = 0.0f;
        this.lPE = 0.0f;
        this.OUS = 0.0f;
        this.iCs = false;
        this.dXX = false;
        this.OUV = true;
        this.OUW = 2.0f;
        this.OUX = 0.75f;
        this.OUY = 20.0f;
        this.OUZ = 0.0f;
        this.OVa = 1.0f;
        this.OVb = false;
        this.aXq = false;
        this.aXp = false;
        this.EEg = true;
        this.hob = null;
        this.mHandler = new MMHandler();
        this.aYU = 1.0f;
        this.OVf = 0.0f;
        this.OVg = false;
        this.imageHeight = 0;
        this.imageWidth = 0;
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.MultiTouchImageView);
        try {
            setImageBackgroundColor(obtainStyledAttributes.getColor(0, 0));
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(142344);
        }
    }

    public void setCanRefresh(boolean z) {
        this.OUV = z;
    }

    public final void cN(int i2, int i3) {
        this.imageWidth = i2;
        this.imageHeight = i3;
    }

    public final void kY(int i2, int i3) {
        this.gRE = i3;
        this.gRD = i2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(142345);
        super.onMeasure(i2, i3);
        if (this.gRD == View.MeasureSpec.getSize(i2) && this.gRE == View.MeasureSpec.getSize(i3)) {
            this.dXX = false;
        } else {
            this.dXX = true;
        }
        this.gRD = View.MeasureSpec.getSize(i2);
        this.gRE = View.MeasureSpec.getSize(i3);
        if (!this.iCs) {
            this.iCs = true;
            init();
        }
        if (this.dXX && this.OUV) {
            gKy();
        }
        AppMethodBeat.o(142345);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(142346);
        this.OVg = false;
        this.EiY = bitmap;
        this.iCs = false;
        super.setImageBitmap(bitmap);
        AppMethodBeat.o(142346);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Matrix imageMatrix;
        AppMethodBeat.i(142347);
        if (this.OVg || this.EiY == null || !this.EiY.isRecycled()) {
            if (this.hob != null && (((this.OVg && this.OVh != null) || this.EiY != null) && (imageMatrix = getImageMatrix()) != null)) {
                canvas.save();
                canvas.concat(imageMatrix);
                if (this.OVg) {
                    if (this.OVh.getIntrinsicWidth() > 2 && this.OVh.getIntrinsicHeight() > 2) {
                        canvas.drawRect(1.0f, 1.0f, (float) (this.OVh.getIntrinsicWidth() - 1), (float) (this.OVh.getIntrinsicHeight() - 1), this.hob);
                    }
                } else if (this.EiY.getWidth() > 2 && this.EiY.getHeight() > 2) {
                    canvas.drawRect(1.0f, 1.0f, (float) (this.EiY.getWidth() - 1), (float) (this.EiY.getHeight() - 1), this.hob);
                }
                canvas.restore();
            }
            super.onDraw(canvas);
            AppMethodBeat.o(142347);
            return;
        }
        Log.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
        AppMethodBeat.o(142347);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void gKy() {
        AppMethodBeat.i(142348);
        this.aYH.reset();
        gLq();
        r(this.OUT, 0.0f, 0.0f);
        gKz();
        AppMethodBeat.o(142348);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void at(float f2, float f3) {
        AppMethodBeat.i(142349);
        gLq();
        s(this.OUT, f2, f3);
        AppMethodBeat.o(142349);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            this.iCs = false;
        }
    }

    private void gLq() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(205258);
        if (this.OUU != null) {
            this.OUT = this.OUU.floatValue();
            AppMethodBeat.o(205258);
            return;
        }
        this.OVc = ((float) this.gRD) / ((float) this.imageWidth);
        this.OVd = ((float) this.gRE) / ((float) this.imageHeight);
        this.aXq = ((float) this.imageWidth) > ((float) this.imageHeight) * 2.2f;
        if (((float) this.imageHeight) > ((float) this.imageWidth) * 2.2f) {
            z = true;
        } else {
            z = false;
        }
        this.aXp = z;
        if (!this.aXq || this.imageWidth <= this.gRD) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.aXq = z2;
        if (!this.aXp || this.imageHeight <= this.gRE) {
            z3 = false;
        }
        this.aXp = z3;
        float f2 = ((float) this.imageHeight) / ((float) this.imageWidth);
        float f3 = 1.8f;
        if (!(this.gRD == 0 || this.gRE == 0)) {
            f3 = ((float) this.gRE) / ((float) this.gRD);
        }
        if (f2 <= f3 || ((double) f2) > 2.2d) {
            this.OUT = this.OVc * this.OVa;
            AppMethodBeat.o(205258);
            return;
        }
        this.OUT = this.OVd * this.OVa;
        AppMethodBeat.o(205258);
    }

    @Override // com.tencent.mm.ui.base.g
    public float getScaleRate() {
        return this.OUT;
    }

    @Override // com.tencent.mm.ui.base.g
    public int getImageWidth() {
        return this.imageWidth;
    }

    public void setImageWidth(int i2) {
        this.imageWidth = i2;
    }

    @Override // com.tencent.mm.ui.base.g
    public int getImageHeight() {
        return this.imageHeight;
    }

    public void setImageHeight(int i2) {
        this.imageHeight = i2;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(142350);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            f.f(keyEvent);
            AppMethodBeat.o(142350);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(142350);
        return onKeyDown;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(142351);
        if (i2 != 4 || !f.g(keyEvent) || f.h(keyEvent) || getScale() <= 1.0f) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(142351);
            return onKeyUp;
        }
        r(1.0f, ((float) this.gRD) / 2.0f, ((float) this.gRE) / 2.0f);
        gKz();
        AppMethodBeat.o(142351);
        return true;
    }

    private void be(boolean z, boolean z2) {
        RectF rectF;
        float f2;
        float f3 = 0.0f;
        AppMethodBeat.i(142352);
        if (this.EiY == null && !this.OVg) {
            AppMethodBeat.o(142352);
        } else if (this.OVh != null || !this.OVg) {
            Matrix imageViewMatrix = getImageViewMatrix();
            if (this.OVg) {
                rectF = new RectF(0.0f, 0.0f, (float) this.OVh.getIntrinsicWidth(), (float) this.OVh.getIntrinsicHeight());
            } else {
                rectF = new RectF(0.0f, 0.0f, (float) this.EiY.getWidth(), (float) this.EiY.getHeight());
            }
            imageViewMatrix.mapRect(rectF);
            float height = rectF.height();
            float width = rectF.width();
            if (!z2) {
                float f4 = rectF.top;
                float f5 = ((float) this.gRE) - rectF.bottom;
                float f6 = (f4 + f5) / 2.0f;
                if (f6 < 0.0f) {
                    f6 = 0.0f;
                }
                if (rectF.top > 0.0f) {
                    f2 = f6 - rectF.top;
                } else {
                    if (rectF.bottom < ((float) this.gRE)) {
                        f2 = f5 - f6;
                    }
                    f2 = 0.0f;
                }
            } else if (height < ((float) this.gRE)) {
                f2 = ((((float) this.gRE) - height) / 2.0f) - rectF.top;
            } else if (rectF.top > 0.0f) {
                f2 = -rectF.top;
            } else {
                if (rectF.bottom < ((float) this.gRE)) {
                    f2 = ((float) this.gRE) - rectF.bottom;
                }
                f2 = 0.0f;
            }
            if (!z) {
                float f7 = rectF.left;
                float f8 = ((float) this.gRD) - rectF.right;
                float f9 = (f7 + f8) / 2.0f;
                if (f9 < 0.0f) {
                    f9 = 0.0f;
                }
                if (rectF.left > 0.0f) {
                    f3 = f9 - rectF.left;
                } else if (rectF.right < ((float) this.gRD)) {
                    f3 = f8 - f9;
                }
            } else if (width < ((float) this.gRD)) {
                f3 = ((((float) this.gRD) - width) / 2.0f) - rectF.left;
            } else if (rectF.left > 0.0f) {
                f3 = -rectF.left;
            } else if (rectF.right < ((float) this.gRD)) {
                f3 = ((float) this.gRD) - rectF.right;
            }
            au(f3, f2);
            Matrix imageViewMatrix2 = getImageViewMatrix();
            setImageMatrix(imageViewMatrix2);
            imageViewMatrix2.mapRect(rectF);
            rectF.height();
            rectF.width();
            AppMethodBeat.o(142352);
        } else {
            AppMethodBeat.o(142352);
        }
    }

    private void init() {
        AppMethodBeat.i(142353);
        Log.d("dktest", "init screenWidth:" + this.gRD + " screenHeight :" + this.gRE);
        setScaleType(ImageView.ScaleType.MATRIX);
        float f2 = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
        if (f2 > 1.0f) {
            this.aYU = f2;
        }
        gKy();
        AppMethodBeat.o(142353);
    }

    public void setImageBackgroundColor(int i2) {
        AppMethodBeat.i(205259);
        if (Color.alpha(i2) == 0) {
            this.hob = null;
        } else {
            this.hob = new Paint(1);
            this.hob.setStyle(Paint.Style.FILL);
            this.hob.setColor(i2);
        }
        invalidate();
        AppMethodBeat.o(205259);
    }

    @Override // com.tencent.mm.ui.base.g
    public float getScale() {
        AppMethodBeat.i(142354);
        this.aYH.getValues(this.DZ);
        gLq();
        this.lPE = this.OUY * this.aYU;
        this.OUS = this.OUT * this.OUX;
        if (this.lPE < 1.0f) {
            this.lPE = 1.0f;
        }
        if (this.OUS > 1.0f) {
            this.OUS = 1.0f;
        }
        float f2 = this.DZ[0];
        AppMethodBeat.o(142354);
        return f2;
    }

    private float i(Matrix matrix) {
        AppMethodBeat.i(205260);
        if (matrix != null) {
            matrix.getValues(this.DZ);
            float f2 = this.DZ[0];
            AppMethodBeat.o(205260);
            return f2;
        }
        AppMethodBeat.o(205260);
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public Matrix getImageViewMatrix() {
        AppMethodBeat.i(142355);
        this.OUO.set(this.OUN);
        this.OUO.postConcat(this.aYH);
        Matrix matrix = this.OUO;
        AppMethodBeat.o(142355);
        return matrix;
    }

    @Override // com.tencent.mm.ui.base.g
    public void setImageViewMatrix(Matrix matrix) {
        AppMethodBeat.i(205261);
        float i2 = i(getImageViewMatrix());
        this.aYH.reset();
        this.aYH.set(matrix);
        float i3 = i(this.aYH);
        setImageMatrix(getImageViewMatrix());
        if (!(i3 == i2 || this.CIB == null)) {
            this.CIB.aj(i2, i3);
        }
        AppMethodBeat.o(205261);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void gKz() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(142356);
        if (!this.EEg || !this.aXq) {
            z = true;
        } else {
            z = false;
        }
        if (this.aXp) {
            z2 = false;
        }
        be(z, z2);
        AppMethodBeat.o(142356);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void gKA() {
        AppMethodBeat.i(142357);
        if (this.OVb && 0.0f == this.OUR) {
            this.OUR = getDoubleTabScale();
        }
        AppMethodBeat.o(142357);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void l(float f2, float f3, float f4) {
        AppMethodBeat.i(205262);
        s(f2, f3, f4);
        AppMethodBeat.o(205262);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void r(float f2, float f3, float f4) {
        AppMethodBeat.i(142358);
        float scale = getScale();
        if (this.OVb) {
            this.lPE = 0.0f == this.OUR ? this.OUY * this.aYU : this.OUR;
        }
        if (f2 > this.lPE * 2.0f) {
            f2 = (this.lPE * 2.0f) + ((f2 - this.lPE) * 0.1f);
        } else if (f2 < this.OUS) {
            f2 = this.OUS;
        }
        float f5 = f2 / scale;
        if (!this.OVg) {
            setImageMatrix(getImageViewMatrix());
            this.aYH.postScale(f5, f5, f3, f4);
        }
        if (this.CIB != null) {
            this.CIB.aj(scale, f2);
        }
        AppMethodBeat.o(142358);
    }

    @Override // com.tencent.mm.ui.base.g
    public float getDoubleTabScale() {
        float scaleRate;
        AppMethodBeat.i(142359);
        float scaleRate2 = getScaleRate();
        if (getScaleWidth() * 0.7f > scaleRate2) {
            scaleRate = getScaleWidth();
        } else if (getScaleHeight() * 0.7f > scaleRate2) {
            scaleRate = getScaleHeight();
        } else {
            scaleRate = getScaleRate() * this.OUW;
        }
        if (((double) scaleRate) < 1.0d) {
            scaleRate = 1.0f;
        }
        if (scaleRate > getMaxZoom()) {
            scaleRate = getMaxZoom();
        }
        AppMethodBeat.o(142359);
        return scaleRate;
    }

    @Override // com.tencent.mm.ui.base.g
    public final float y(float f2, float f3) {
        AppMethodBeat.i(205263);
        this.OUR = getDoubleTabScale();
        s(this.OUR, f2, f3);
        float f4 = this.OUR;
        AppMethodBeat.o(205263);
        return f4;
    }

    public final void av(float f2, float f3) {
        AppMethodBeat.i(205264);
        gLq();
        this.OUT *= getOriginScale();
        s(this.OUT, f2, f3);
        gKz();
        AppMethodBeat.o(205264);
    }

    public final void aw(float f2, float f3) {
        AppMethodBeat.i(205265);
        gLq();
        this.OUT *= getOriginScale();
        s(this.OUT, f2, f3);
        gKz();
        AppMethodBeat.o(205265);
    }

    public void setEnableHorLongBmpMode(boolean z) {
        this.EEg = z;
    }

    private void s(float f2, final float f3, final float f4) {
        AppMethodBeat.i(142361);
        final float scale = (f2 - getScale()) / 128.0f;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.ui.base.MultiTouchImageView.AnonymousClass1 */
            final /* synthetic */ float OVi = 128.0f;

            public final void run() {
                AppMethodBeat.i(142339);
                float min = Math.min(this.OVi, (float) (System.currentTimeMillis() - currentTimeMillis));
                MultiTouchImageView.this.r(scale2 + (scale * min), f3, f4);
                MultiTouchImageView.this.gKz();
                if (min < this.OVi) {
                    MultiTouchImageView.this.mHandler.post(this);
                }
                AppMethodBeat.o(142339);
            }
        });
        AppMethodBeat.o(142361);
    }

    public final void cs(float f2) {
        AppMethodBeat.i(205266);
        if (getScale() >= this.lPE) {
            AppMethodBeat.o(205266);
        } else if (getScale() <= this.OUS) {
            AppMethodBeat.o(205266);
        } else if (this.EiY == null && !this.OVg) {
            AppMethodBeat.o(205266);
        } else if (this.OVh != null || !this.OVg) {
            this.aYH.postScale(f2, f2, ((float) this.gRD) / 2.0f, ((float) this.gRE) / 2.0f);
            setImageMatrix(getImageViewMatrix());
            AppMethodBeat.o(205266);
        } else {
            AppMethodBeat.o(205266);
        }
    }

    public float getRealWidth() {
        AppMethodBeat.i(142362);
        float scale = getScale() * ((float) getImageWidth());
        AppMethodBeat.o(142362);
        return scale;
    }

    @Override // com.tencent.mm.ui.base.g
    public final void au(float f2, float f3) {
        AppMethodBeat.i(142363);
        this.aYH.postTranslate(f2, f3);
        setImageMatrix(getImageViewMatrix());
        AppMethodBeat.o(142363);
    }

    public void setGifPath(String str) {
        AppMethodBeat.i(142364);
        this.OVg = true;
        try {
            this.OVh = c.nl(str, str);
            setImageDrawable(this.OVh);
            if (this.OVh != null) {
                cN(this.OVh.getIntrinsicWidth(), this.OVh.getIntrinsicHeight());
            }
            AppMethodBeat.o(142364);
        } catch (Exception e2) {
            this.OVg = false;
            AppMethodBeat.o(142364);
        }
    }

    public void setGifDrawable(Drawable drawable) {
        AppMethodBeat.i(142365);
        this.OVg = true;
        this.OVh = drawable;
        setImageDrawable(this.OVh);
        AppMethodBeat.o(142365);
    }

    public final void start() {
        AppMethodBeat.i(142366);
        if (this.OVg && this.OVh != null) {
            ((com.tencent.mm.ui.g.b.a) this.OVh).start();
        }
        AppMethodBeat.o(142366);
    }

    @Override // com.tencent.mm.ui.base.g
    public final PointF a(PointF pointF, int i2, int i3) {
        AppMethodBeat.i(205267);
        if (pointF == null) {
            AppMethodBeat.o(205267);
            return null;
        }
        int i4 = this.imageWidth;
        int i5 = (int) (((1.0f * ((float) this.imageWidth)) * ((float) i3)) / ((float) i2));
        float[] fArr = {pointF.x * ((float) i4), pointF.y * ((float) i5)};
        Log.v("MicroMsg.MultiTouchImageView", "mapPoint srcPoint: %s, width: %d, height: %d, viewWidth: %d, viewHeight: %d, targetWidth: %d, targetHeight: %d", pointF, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.gRD), Integer.valueOf(this.gRE), Integer.valueOf(i4), Integer.valueOf(i5));
        Matrix imageViewMatrix = getImageViewMatrix();
        if (imageViewMatrix != null) {
            float[] fArr2 = new float[2];
            Log.v("MicroMsg.MultiTouchImageView", "mapPoint scaleRate: %s", Float.valueOf(this.OUT));
            imageViewMatrix.mapPoints(fArr2, fArr);
            PointF pointF2 = new PointF(fArr2[0], fArr2[1]);
            AppMethodBeat.o(205267);
            return pointF2;
        }
        AppMethodBeat.o(205267);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0030  */
    @Override // com.tencent.mm.ui.base.g
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.PointF c(android.graphics.PointF r12) {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.base.MultiTouchImageView.c(android.graphics.PointF):android.graphics.PointF");
    }

    @Override // com.tencent.mm.ui.base.g
    public PointF getImageViewMatrixScale() {
        AppMethodBeat.i(205269);
        this.aYH.getValues(this.DZ);
        PointF pointF = new PointF(this.DZ[0], this.DZ[4]);
        AppMethodBeat.o(205269);
        return pointF;
    }

    @Override // com.tencent.mm.ui.base.g
    public PointF getImageViewMatrixTranslation() {
        AppMethodBeat.i(205270);
        this.aYH.getValues(this.DZ);
        PointF pointF = new PointF(this.DZ[2], this.DZ[5]);
        AppMethodBeat.o(205270);
        return pointF;
    }

    @Override // com.tencent.mm.ui.base.g
    public void setCustomScaleRate(Float f2) {
        AppMethodBeat.i(205271);
        this.OUU = f2;
        if (f2 != null) {
            this.OUT = f2.floatValue();
        }
        AppMethodBeat.o(205271);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void gKB() {
        AppMethodBeat.i(205272);
        this.OUU = null;
        gLq();
        AppMethodBeat.o(205272);
    }

    @Override // com.tencent.mm.ui.base.g
    public void setOnZoomScaleChangedListener(g.a aVar) {
        this.CIB = aVar;
    }
}
