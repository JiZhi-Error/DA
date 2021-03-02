package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.ui.WxBaseImageView;
import com.tencent.mm.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.g;

public class WxImageView extends WxBaseImageView implements g {
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
    private boolean OVb;
    private float OVc;
    private float OVd;
    private boolean OVg;
    private Drawable OVh;
    private boolean aXp;
    private boolean aXq;
    protected Matrix aYH;
    private float aYU;
    private boolean dXX;
    private int gRD;
    private int gRE;
    private boolean iCs;
    private float lPE;
    protected MMHandler mHandler;
    private int orientation;

    public WxImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142468);
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
        this.OVb = false;
        this.aXq = false;
        this.aXp = false;
        this.EEg = true;
        this.OVg = false;
        this.mHandler = new MMHandler();
        this.aYU = 1.0f;
        initView();
        AppMethodBeat.o(142468);
    }

    public WxImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142469);
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
        this.OVb = false;
        this.aXq = false;
        this.aXp = false;
        this.EEg = true;
        this.OVg = false;
        this.mHandler = new MMHandler();
        this.aYU = 1.0f;
        initView();
        AppMethodBeat.o(142469);
    }

    private void initView() {
        AppMethodBeat.i(205277);
        a(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.base.WxImageView.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(205274);
                if (motionEvent.getAction() == 0) {
                    ad.b G = ad.aVe().G("basescanui@datacenter", true);
                    Log.i("MicroMsg.WxImageView", "alvinluo WxImageView get touchCoordinate touch x: %s, y: %s", Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()));
                    PointF a2 = WxImageView.a(WxImageView.this, motionEvent.getRawX(), motionEvent.getRawY());
                    if (a2 != null) {
                        G.l("key_basescanui_touch_normalize_x", Float.valueOf(a2.x));
                        G.l("key_basescanui_touch_normalize_y", Float.valueOf(a2.y));
                    } else {
                        Log.e("MicroMsg.WxImageView", "alvinluo get touchCoordinate is invalid");
                    }
                }
                AppMethodBeat.o(205274);
                return false;
            }
        });
        AppMethodBeat.o(205277);
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
        AppMethodBeat.i(142470);
        if (Float.compare(f2, 1.0f) < 0) {
            Log.w("MicroMsg.WxImageView", "max scale limit is less than 1.0, change nothing, return");
            AppMethodBeat.o(142470);
            return;
        }
        this.OUY = f2;
        AppMethodBeat.o(142470);
    }

    public void setMinZoomLimit(float f2) {
        AppMethodBeat.i(142471);
        if (Float.compare(f2, 1.0f) > 0) {
            Log.w("MicroMsg.WxImageView", "min scale limit is greater than 1.0, change nothing, return");
            AppMethodBeat.o(142471);
        } else if (Float.compare(f2, 0.0f) < 0) {
            Log.w("MicroMsg.WxImageView", "min scale limit is less than 0.0, change nothing, return");
            AppMethodBeat.o(142471);
        } else {
            this.OUX = f2;
            AppMethodBeat.o(142471);
        }
    }

    public void setDoubleTabScaleLimit(float f2) {
        AppMethodBeat.i(142472);
        if (Float.compare(f2, 0.0f) < 0) {
            Log.w("MicroMsg.WxImageView", "double tab scale limit is less than 0.0, change nothing, return");
            AppMethodBeat.o(142472);
            return;
        }
        this.OUW = f2;
        AppMethodBeat.o(142472);
    }

    public void setMaxZoomDoubleTab(boolean z) {
        this.OVb = z;
    }

    @Override // com.tencent.mm.graphics.ui.WxBaseImageView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(142473);
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
            this.OVg = false;
            Log.d("MicroMsg.WxImageView", "init screenWidth:" + this.gRD + " screenHeight :" + this.gRE);
            float f2 = ((float) getContext().getResources().getDisplayMetrics().widthPixels) / 720.0f;
            if (f2 > 1.0f) {
                this.aYU = f2;
            }
            gKy();
        }
        if (this.dXX && this.OUV) {
            gKy();
        }
        AppMethodBeat.o(142473);
    }

    public int getContentTop() {
        AppMethodBeat.i(142474);
        if (!this.iCs) {
            AppMethodBeat.o(142474);
            return 0;
        }
        int imageHeight = (int) ((((float) this.gRE) - (this.OUT * ((float) getImageHeight()))) / 2.0f);
        if (imageHeight < 0) {
            imageHeight = 0;
        }
        Log.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageHeight: %d, viewHeight: %d, top: %d", Float.valueOf(this.OUT), Integer.valueOf(getImageHeight()), Integer.valueOf(this.gRE), Integer.valueOf(imageHeight));
        AppMethodBeat.o(142474);
        return imageHeight;
    }

    public int getContentLeft() {
        AppMethodBeat.i(142475);
        if (!this.iCs) {
            AppMethodBeat.o(142475);
            return 0;
        }
        int i2 = (int) ((((float) this.gRD) - (this.OUT * ((float) this.imageWidth))) / 2.0f);
        if (i2 < 0) {
            i2 = 0;
        }
        Log.i("MicroMsg.WxImageView", "alvinluo scaleRate: %f, imageWidth: %d, viewWidth: %d, left: %d", Float.valueOf(this.OUT), Integer.valueOf(this.imageWidth), Integer.valueOf(this.gRD), Integer.valueOf(i2));
        AppMethodBeat.o(142475);
        return i2;
    }

    @Override // com.tencent.mm.ui.base.g
    public final void gKy() {
        AppMethodBeat.i(142476);
        Log.d("MicroMsg.WxImageView", "alvinluo adaptViewSize");
        this.aYH.reset();
        gLq();
        axJ();
        r(this.OUT, 0.0f, 0.0f);
        AppMethodBeat.o(142476);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void at(final float f2, final float f3) {
        AppMethodBeat.i(142477);
        gLq();
        final float scale = (this.OUT - getScale()) / 128.0f;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.ui.base.WxImageView.AnonymousClass2 */
            final /* synthetic */ float OVi = 128.0f;

            public final void run() {
                AppMethodBeat.i(205275);
                float min = Math.min(this.OVi, (float) (System.currentTimeMillis() - currentTimeMillis));
                WxImageView.this.r(scale2 + (scale * min), f2, f3);
                if (min < this.OVi) {
                    WxImageView.this.mHandler.post(this);
                }
                AppMethodBeat.o(205275);
            }
        });
        AppMethodBeat.o(142477);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            this.iCs = false;
        }
    }

    public void setOrientation(int i2) {
        AppMethodBeat.i(142478);
        this.orientation = i2;
        gLq();
        AppMethodBeat.o(142478);
    }

    private void gLq() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(142479);
        if (this.OUU != null) {
            this.OUT = this.OUU.floatValue();
            AppMethodBeat.o(142479);
            return;
        }
        int imageWidth = getImageWidth();
        int imageHeight = getImageHeight();
        this.OVc = ((float) this.gRD) / ((float) imageWidth);
        this.OVd = ((float) this.gRE) / ((float) imageHeight);
        this.aXq = ((float) imageWidth) > ((float) imageHeight) * 2.2f;
        if (((float) imageHeight) > ((float) imageWidth) * 2.2f) {
            z = true;
        } else {
            z = false;
        }
        this.aXp = z;
        if (!this.aXq || imageWidth <= this.gRD) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.aXq = z2;
        if (!this.aXp || imageHeight <= this.gRE) {
            z3 = false;
        }
        this.aXp = z3;
        float f2 = ((float) imageHeight) / ((float) imageWidth);
        float f3 = 1.8f;
        if (!(this.gRD == 0 || this.gRE == 0)) {
            f3 = ((float) this.gRE) / ((float) this.gRD);
        }
        if (f2 <= f3 || ((double) f2) > 2.2d) {
            this.OUT = this.OVc;
        } else {
            this.OUT = this.OVd;
        }
        setScaleRate(this.OUT);
        AppMethodBeat.o(142479);
    }

    @Override // com.tencent.mm.ui.base.g
    public float getScaleRate() {
        return this.OUT;
    }

    @Override // com.tencent.mm.ui.base.g
    public int getImageWidth() {
        if (this.orientation == 90 || this.orientation == 270) {
            return this.imageHeight;
        }
        return this.imageWidth;
    }

    public void setImageWidth(int i2) {
        this.imageWidth = i2;
    }

    @Override // com.tencent.mm.ui.base.g
    public int getImageHeight() {
        if (this.orientation == 90 || this.orientation == 270) {
            return this.imageWidth;
        }
        return this.imageHeight;
    }

    public void setImageHeight(int i2) {
        this.imageHeight = i2;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(142480);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            f.f(keyEvent);
            AppMethodBeat.o(142480);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(142480);
        return onKeyDown;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(142481);
        if (i2 != 4 || !f.g(keyEvent) || f.h(keyEvent) || getScale() <= 1.0f) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(142481);
            return onKeyUp;
        }
        r(1.0f, ((float) this.gRD) / 2.0f, ((float) this.gRE) / 2.0f);
        AppMethodBeat.o(142481);
        return true;
    }

    private void be(boolean z, boolean z2) {
        RectF rectF;
        float f2;
        float f3 = 0.0f;
        AppMethodBeat.i(142482);
        if (this.OVh != null || !this.OVg) {
            Matrix imageViewMatrix = getImageViewMatrix();
            if (this.OVg) {
                rectF = new RectF(0.0f, 0.0f, (float) this.OVh.getIntrinsicWidth(), (float) this.OVh.getIntrinsicHeight());
            } else {
                rectF = new RectF(0.0f, 0.0f, (float) this.imageWidth, (float) this.imageHeight);
            }
            imageViewMatrix.mapRect(rectF);
            float height = rectF.height();
            float width = rectF.width();
            if (z2) {
                if (height < ((float) this.gRE)) {
                    f2 = ((((float) this.gRE) - height) / 2.0f) - rectF.top;
                } else if (rectF.top > 0.0f) {
                    f2 = -rectF.top;
                } else {
                    if (rectF.bottom < ((float) this.gRE)) {
                        f2 = ((float) this.gRE) - rectF.bottom;
                    }
                    f2 = 0.0f;
                }
            } else if (rectF.top > 0.0f) {
                f2 = -rectF.top;
            } else {
                if (rectF.bottom < ((float) this.gRE)) {
                    f2 = ((float) this.gRE) - rectF.bottom;
                }
                f2 = 0.0f;
            }
            if (z) {
                if (width < ((float) this.gRD)) {
                    f3 = ((((float) this.gRD) - width) / 2.0f) - rectF.left;
                } else if (rectF.left > 0.0f) {
                    f3 = -rectF.left;
                } else if (rectF.right < ((float) this.gRD)) {
                    f3 = ((float) this.gRD) - rectF.right;
                }
            } else if (rectF.left > 0.0f) {
                f3 = -rectF.left;
            } else if (rectF.right < ((float) this.gRD)) {
                f3 = ((float) this.gRD) - rectF.right;
            }
            au(f3, f2);
            getImageViewMatrix().mapRect(rectF);
            AppMethodBeat.o(142482);
            return;
        }
        AppMethodBeat.o(142482);
    }

    @Override // com.tencent.mm.graphics.ui.WxBaseImageView, com.tencent.mm.ui.base.g
    public float getScale() {
        AppMethodBeat.i(142483);
        float scale = super.getScale();
        AppMethodBeat.o(142483);
        return scale;
    }

    /* access modifiers changed from: protected */
    public Matrix getImageViewMatrix() {
        AppMethodBeat.i(142484);
        this.OUO.set(this.OUN);
        this.OUO.postConcat(this.aYH);
        Matrix matrix = this.OUO;
        AppMethodBeat.o(142484);
        return matrix;
    }

    @Override // com.tencent.mm.graphics.ui.WxBaseImageView, com.tencent.mm.ui.base.g
    public void setImageViewMatrix(Matrix matrix) {
        AppMethodBeat.i(205278);
        super.setImageViewMatrix(matrix);
        AppMethodBeat.o(205278);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void gKz() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(164159);
        if (!this.EEg || !this.aXq) {
            z = true;
        } else {
            z = false;
        }
        if (this.aXp) {
            z2 = false;
        }
        be(z, z2);
        AppMethodBeat.o(164159);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void gKA() {
        AppMethodBeat.i(142485);
        if (this.OVb && 0.0f == this.OUR) {
            this.OUR = getDoubleTabScale();
        }
        AppMethodBeat.o(142485);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void r(float f2, float f3, float f4) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(142486);
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
        Log.d("MicroMsg.WxImageView", "alvinluo zoomTo mzdt=%f,mz=%f,scale=%f,oldScale=%f,deltaScale=%f", Float.valueOf(this.OUR), Float.valueOf(this.lPE), Float.valueOf(f2), Float.valueOf(scale), Float.valueOf(f5));
        if (!this.OVg) {
            this.aYH.postScale(f5, f5, f3, f4);
        }
        if (!this.EEg || !this.aXq) {
            z = true;
        } else {
            z = false;
        }
        if (this.aXp) {
            z2 = false;
        }
        be(z, z2);
        AppMethodBeat.o(142486);
    }

    @Override // com.tencent.mm.ui.base.g
    public float getDoubleTabScale() {
        float scaleRate;
        AppMethodBeat.i(142487);
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
        AppMethodBeat.o(142487);
        return scaleRate;
    }

    @Override // com.tencent.mm.graphics.ui.WxBaseImageView, com.tencent.mm.ui.base.g
    public final float y(float f2, float f3) {
        AppMethodBeat.i(205279);
        float y = super.y(f2, f3);
        AppMethodBeat.o(205279);
        return y;
    }

    public void setEnableHorLongBmpMode(boolean z) {
        this.EEg = z;
    }

    @Override // com.tencent.mm.ui.base.g
    public final void au(float f2, float f3) {
        AppMethodBeat.i(142490);
        Log.d("MicroMsg.WxImageView", "alvinluo WxImageView postTranslate dx: %f, dy: %f", Float.valueOf(f2), Float.valueOf(f3));
        this.aYH.postTranslate(f2, f3);
        AppMethodBeat.o(142490);
    }

    public final void translate(float f2, float f3) {
        AppMethodBeat.i(142491);
        float translationX = getTranslationX();
        float translationY = getTranslationY();
        setTranslationX(translationX + f2);
        setTranslationY(translationY + f3);
        Log.i("MicroMsg.WxImageView", "alvinluo translate x: %f, y: %f, x + dx: %f, y + dy: %f", Float.valueOf(translationX), Float.valueOf(translationY), Float.valueOf(translationX + f2), Float.valueOf(translationY + f3));
        AppMethodBeat.o(142491);
    }

    @Override // com.tencent.mm.ui.base.g
    public Matrix getImageMatrix() {
        AppMethodBeat.i(142492);
        this.OUO.set(this.OUN);
        this.OUO.postConcat(this.aYH);
        Matrix matrix = this.OUO;
        AppMethodBeat.o(142492);
        return matrix;
    }

    @Override // com.tencent.mm.ui.base.g
    public final PointF a(PointF pointF, int i2, int i3) {
        AppMethodBeat.i(205280);
        if (pointF == null) {
            AppMethodBeat.o(205280);
            return null;
        }
        int imageWidth = getImageWidth();
        int i4 = (int) (((1.0f * ((float) imageWidth)) * ((float) i3)) / ((float) i2));
        float[] fArr = {pointF.x * ((float) imageWidth), pointF.y * ((float) i4)};
        Log.v("MicroMsg.WxImageView", "mapPoint srcPoint: %s, width: %d, height: %d, viewWidth: %d, viewHeight: %d, targetWidth: %d, targetHeight: %d", pointF, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.gRD), Integer.valueOf(this.gRE), Integer.valueOf(imageWidth), Integer.valueOf(i4));
        if (this.hkD != null) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.hkD;
            PointF pointF2 = new PointF(subsamplingScaleImageView.Y(fArr[0]), subsamplingScaleImageView.Z(fArr[1]));
            AppMethodBeat.o(205280);
            return pointF2;
        }
        AppMethodBeat.o(205280);
        return null;
    }

    @Override // com.tencent.mm.ui.base.g
    public final PointF c(PointF pointF) {
        PointF pointF2;
        float f2;
        float f3 = 0.0f;
        AppMethodBeat.i(205281);
        int imageWidth = getImageWidth();
        int imageHeight = getImageHeight();
        float[] fArr = {pointF.x, pointF.y};
        if (this.hkD != null) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.hkD;
            float f4 = fArr[0];
            if (subsamplingScaleImageView.aXO == null) {
                f2 = 0.0f;
            } else {
                f2 = (f4 - subsamplingScaleImageView.aXO.x) / subsamplingScaleImageView.scale;
                if (Float.isNaN(f2) || Float.isInfinite(f2)) {
                    f2 = 0.0f;
                }
            }
            float f5 = fArr[1];
            if (subsamplingScaleImageView.aXO != null) {
                float f6 = (f5 - subsamplingScaleImageView.aXO.y) / subsamplingScaleImageView.scale;
                if (!Float.isNaN(f6) && !Float.isInfinite(f6)) {
                    f3 = f6;
                }
            }
            pointF2 = new PointF(f2, f3);
        } else {
            pointF2 = null;
        }
        if (pointF2 != null) {
            pointF2.x /= (float) imageWidth;
            pointF2.y /= (float) imageHeight;
            Log.i("MicroMsg.WxImageView", "alvinluo convertScreenToImageCoordinate screenCoordinate: %s, imageCoordinate: %s, imageWidth: %s, imageHeight: %s", pointF, pointF2, Integer.valueOf(imageWidth), Integer.valueOf(imageHeight));
        }
        AppMethodBeat.o(205281);
        return pointF2;
    }

    @Override // com.tencent.mm.graphics.ui.WxBaseImageView, com.tencent.mm.ui.base.g
    public PointF getImageViewMatrixScale() {
        AppMethodBeat.i(205282);
        PointF imageViewMatrixScale = super.getImageViewMatrixScale();
        AppMethodBeat.o(205282);
        return imageViewMatrixScale;
    }

    @Override // com.tencent.mm.graphics.ui.WxBaseImageView, com.tencent.mm.ui.base.g
    public PointF getImageViewMatrixTranslation() {
        AppMethodBeat.i(205283);
        PointF imageViewMatrixTranslation = super.getImageViewMatrixTranslation();
        AppMethodBeat.o(205283);
        return imageViewMatrixTranslation;
    }

    @Override // com.tencent.mm.graphics.ui.WxBaseImageView, com.tencent.mm.ui.base.g
    public final void l(float f2, float f3, float f4) {
        AppMethodBeat.i(205284);
        super.l(f2, f3, f4);
        AppMethodBeat.o(205284);
    }

    public void setCanRefresh(boolean z) {
        this.OUV = z;
    }

    @Override // com.tencent.mm.graphics.ui.WxBaseImageView, com.tencent.mm.ui.base.g
    public void setCustomScaleRate(Float f2) {
        AppMethodBeat.i(205285);
        if (f2 != null) {
            this.OUU = f2;
            super.setCustomScaleRate(f2);
            AppMethodBeat.o(205285);
            return;
        }
        gKB();
        AppMethodBeat.o(205285);
    }

    @Override // com.tencent.mm.ui.base.g
    public final void gKB() {
        AppMethodBeat.i(205286);
        this.OUU = null;
        gLq();
        AppMethodBeat.o(205286);
    }

    @Override // com.tencent.mm.ui.base.g
    public void setOnZoomScaleChangedListener(final g.a aVar) {
        AppMethodBeat.i(205287);
        if (aVar != null) {
            super.setOnZoomScaleChangedListener(new SubsamplingScaleImageView.f() {
                /* class com.tencent.mm.ui.base.WxImageView.AnonymousClass3 */

                @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.f
                public final void r(float f2, float f3) {
                    AppMethodBeat.i(205276);
                    aVar.aj(f3, f2);
                    AppMethodBeat.o(205276);
                }
            });
            AppMethodBeat.o(205287);
            return;
        }
        super.setOnZoomScaleChangedListener((SubsamplingScaleImageView.f) null);
        AppMethodBeat.o(205287);
    }

    @Override // com.tencent.mm.graphics.ui.WxBaseImageView
    public void setAllowInterceptTouchEvent(boolean z) {
        AppMethodBeat.i(205288);
        super.setAllowInterceptTouchEvent(z);
        AppMethodBeat.o(205288);
    }

    static /* synthetic */ PointF a(WxImageView wxImageView, float f2, float f3) {
        AppMethodBeat.i(205289);
        PointF c2 = wxImageView.c(new PointF(f2, f3));
        AppMethodBeat.o(205289);
        return c2;
    }
}
