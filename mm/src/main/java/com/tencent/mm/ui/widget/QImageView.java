package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

@RemoteViews.RemoteView
public class QImageView extends View {
    private static final a[] QED = {a.MATRIX, a.FIT_XY, a.FIT_START, a.FIT_CENTER, a.FIT_END, a.CENTER, a.CENTER_CROP, a.CENTER_INSIDE};
    private static final Matrix.ScaleToFit[] QEE = {Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
    private boolean QEA;
    private PaintFlagsDrawFilter QEB;
    private PaintFlagsDrawFilter QEC;
    private int QEn;
    private a QEo;
    private boolean QEp;
    private boolean QEq;
    private int QEr;
    private boolean QEs;
    private int[] QEt;
    private boolean QEu;
    private int QEv;
    private int QEw;
    private Matrix QEx;
    private final RectF QEy;
    private final RectF QEz;
    private boolean aqf;
    private int mAlpha;
    private Context mContext;
    private Drawable mDrawable;
    private int mLevel;
    private Matrix mMatrix;
    private int mMaxHeight;
    private int mMaxWidth;
    private Uri mUri;
    private ColorFilter xo;

    public QImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(156564);
        this.mContext = context;
        gZb();
        AppMethodBeat.o(156564);
    }

    public QImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(156565);
        this.QEn = 0;
        this.QEp = false;
        this.QEq = false;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mAlpha = 255;
        this.QEr = 256;
        this.QEs = false;
        this.mDrawable = null;
        this.QEt = null;
        this.QEu = false;
        this.mLevel = 0;
        this.QEx = null;
        this.QEy = new RectF();
        this.QEz = new RectF();
        this.aqf = false;
        this.mContext = context;
        gZb();
        this.aqf = false;
        setAdjustViewBounds(false);
        setMaxWidth(Integer.MAX_VALUE);
        setMaxHeight(Integer.MAX_VALUE);
        this.QEA = false;
        AppMethodBeat.o(156565);
    }

    private void gZb() {
        AppMethodBeat.i(156566);
        this.mMatrix = new Matrix();
        this.QEo = a.FIT_CENTER;
        this.QEB = new PaintFlagsDrawFilter(0, 3);
        this.QEC = new PaintFlagsDrawFilter(0, 0);
        AppMethodBeat.o(156566);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        AppMethodBeat.i(156567);
        if (this.mDrawable == drawable || super.verifyDrawable(drawable)) {
            AppMethodBeat.o(156567);
            return true;
        }
        AppMethodBeat.o(156567);
        return false;
    }

    public void invalidateDrawable(Drawable drawable) {
        AppMethodBeat.i(156568);
        if (drawable == this.mDrawable) {
            invalidate();
            AppMethodBeat.o(156568);
            return;
        }
        super.invalidateDrawable(drawable);
        AppMethodBeat.o(156568);
    }

    /* access modifiers changed from: protected */
    public boolean onSetAlpha(int i2) {
        AppMethodBeat.i(156569);
        if (getBackground() == null) {
            int i3 = (i2 >> 7) + i2;
            if (this.QEr != i3) {
                this.QEr = i3;
                this.QEs = true;
                gZf();
            }
            AppMethodBeat.o(156569);
            return true;
        }
        AppMethodBeat.o(156569);
        return false;
    }

    public void setAdjustViewBounds(boolean z) {
        AppMethodBeat.i(156570);
        this.QEq = z;
        if (z) {
            setScaleType(a.FIT_CENTER);
        }
        AppMethodBeat.o(156570);
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxHeight(int i2) {
        this.mMaxHeight = i2;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public void setImageResource(int i2) {
        AppMethodBeat.i(156571);
        if (!(this.mUri == null && this.QEn == i2)) {
            G(null);
            this.QEn = i2;
            this.mUri = null;
            gZc();
            invalidate();
        }
        AppMethodBeat.o(156571);
    }

    @TargetApi(11)
    public void setLayerType(int i2, Paint paint) {
        AppMethodBeat.i(156572);
        if (!(getDrawable() instanceof PictureDrawable) || i2 == 1) {
            super.setLayerType(i2, paint);
            AppMethodBeat.o(156572);
            return;
        }
        AppMethodBeat.o(156572);
    }

    public void setImageURI(Uri uri) {
        AppMethodBeat.i(156573);
        if (this.QEn != 0 || (this.mUri != uri && (uri == null || this.mUri == null || !uri.equals(this.mUri)))) {
            G(null);
            this.QEn = 0;
            this.mUri = uri;
            gZc();
            invalidate();
        }
        AppMethodBeat.o(156573);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(156574);
        if (this.mDrawable != drawable) {
            this.QEn = 0;
            this.mUri = null;
            G(drawable);
            invalidate();
        }
        AppMethodBeat.o(156574);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        AppMethodBeat.i(156575);
        super.setBackgroundDrawable(drawable);
        AppMethodBeat.o(156575);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(156576);
        setImageDrawable(new BitmapDrawable(this.mContext.getResources(), bitmap));
        AppMethodBeat.o(156576);
    }

    private void gZc() {
        Drawable drawable = null;
        AppMethodBeat.i(156577);
        if (this.mDrawable != null) {
            AppMethodBeat.o(156577);
            return;
        }
        Resources resources = getResources();
        if (resources == null) {
            AppMethodBeat.o(156577);
            return;
        }
        if (this.QEn != 0) {
            try {
                drawable = resources.getDrawable(this.QEn);
            } catch (Exception e2) {
                Log.w("ImageView", "Unable to find resource: " + this.QEn, e2);
                this.mUri = null;
            }
        } else if (this.mUri == null) {
            AppMethodBeat.o(156577);
            return;
        }
        G(drawable);
        AppMethodBeat.o(156577);
    }

    public void setSelected(boolean z) {
        AppMethodBeat.i(156578);
        super.setSelected(z);
        gZd();
        AppMethodBeat.o(156578);
    }

    public void setImageLevel(int i2) {
        AppMethodBeat.i(156579);
        this.mLevel = i2;
        if (this.mDrawable != null) {
            this.mDrawable.setLevel(i2);
            gZd();
        }
        AppMethodBeat.o(156579);
    }

    public enum a {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);
        
        final int QEN;

        public static a valueOf(String str) {
            AppMethodBeat.i(156562);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(156562);
            return aVar;
        }

        static {
            AppMethodBeat.i(156563);
            AppMethodBeat.o(156563);
        }

        private a(int i2) {
            this.QEN = i2;
        }
    }

    public void setScaleType(a aVar) {
        AppMethodBeat.i(156580);
        if (aVar == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(156580);
            throw nullPointerException;
        }
        if (this.QEo != aVar) {
            this.QEo = aVar;
            setWillNotCacheDrawing(this.QEo == a.CENTER);
            requestLayout();
            invalidate();
        }
        AppMethodBeat.o(156580);
    }

    public a getScaleType() {
        return this.QEo;
    }

    public Matrix getImageMatrix() {
        return this.mMatrix;
    }

    public void setImageMatrix(Matrix matrix) {
        AppMethodBeat.i(156581);
        if (matrix != null && matrix.isIdentity()) {
            matrix = null;
        }
        if ((matrix == null && !this.mMatrix.isIdentity()) || (matrix != null && !this.mMatrix.equals(matrix))) {
            this.mMatrix.set(matrix);
            gZe();
            invalidate();
        }
        AppMethodBeat.o(156581);
    }

    public int[] onCreateDrawableState(int i2) {
        AppMethodBeat.i(156582);
        if (this.QEt == null) {
            int[] onCreateDrawableState = super.onCreateDrawableState(i2);
            AppMethodBeat.o(156582);
            return onCreateDrawableState;
        } else if (!this.QEu) {
            int[] iArr = this.QEt;
            AppMethodBeat.o(156582);
            return iArr;
        } else {
            int[] mergeDrawableStates = mergeDrawableStates(super.onCreateDrawableState(this.QEt.length + i2), this.QEt);
            AppMethodBeat.o(156582);
            return mergeDrawableStates;
        }
    }

    private void G(Drawable drawable) {
        AppMethodBeat.i(156583);
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
            unscheduleDrawable(this.mDrawable);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            drawable.setLevel(this.mLevel);
            this.QEv = drawable.getIntrinsicWidth();
            this.QEw = drawable.getIntrinsicHeight();
            gZf();
            gZe();
        }
        AppMethodBeat.o(156583);
    }

    private void gZd() {
        AppMethodBeat.i(156584);
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth < 0) {
                intrinsicWidth = this.QEv;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight < 0) {
                intrinsicHeight = this.QEw;
            }
            if (!(intrinsicWidth == this.QEv && intrinsicHeight == this.QEw)) {
                this.QEv = intrinsicWidth;
                this.QEw = intrinsicHeight;
                requestLayout();
            }
        }
        AppMethodBeat.o(156584);
    }

    private static Matrix.ScaleToFit a(a aVar) {
        return QEE[aVar.QEN - 1];
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(156585);
        gZc();
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        if (this.mDrawable == null) {
            this.QEv = -1;
            this.QEw = -1;
            i4 = 0;
            i5 = 0;
        } else {
            i4 = this.QEv;
            int i9 = this.QEw;
            if (i4 <= 0) {
                i4 = 1;
            }
            if (i9 <= 0) {
                i9 = 1;
            }
            if (this.QEq) {
                int mode = View.MeasureSpec.getMode(i2);
                int mode2 = View.MeasureSpec.getMode(i3);
                z = mode != 1073741824;
                z2 = mode2 != 1073741824;
                f2 = ((float) i4) / ((float) i9);
                i5 = i9;
            } else {
                i5 = i9;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (z || z2) {
            int aU = aU(i4 + paddingLeft + paddingRight, this.mMaxWidth, i2);
            int aU2 = aU(i5 + paddingTop + paddingBottom, this.mMaxHeight, i3);
            if (f2 == 0.0f || ((double) Math.abs((((float) ((aU - paddingLeft) - paddingRight)) / ((float) ((aU2 - paddingTop) - paddingBottom))) - f2)) <= 1.0E-7d) {
                i7 = aU2;
                i6 = aU;
            } else {
                boolean z3 = false;
                if (!z || (i8 = ((int) (((float) ((aU2 - paddingTop) - paddingBottom)) * f2)) + paddingLeft + paddingRight) > aU) {
                    i8 = aU;
                } else {
                    z3 = true;
                }
                if (z3 || !z2 || (i7 = ((int) (((float) ((i8 - paddingLeft) - paddingRight)) / f2)) + paddingTop + paddingBottom) > aU2) {
                    i7 = aU2;
                    i6 = i8;
                } else {
                    i6 = i8;
                }
            }
        } else {
            int max = Math.max(paddingLeft + paddingRight + i4, getSuggestedMinimumWidth());
            int max2 = Math.max(paddingTop + paddingBottom + i5, getSuggestedMinimumHeight());
            i6 = resolveSize(max, i2);
            i7 = resolveSize(max2, i3);
        }
        setMeasuredDimension(i6, i7);
        AppMethodBeat.o(156585);
    }

    private static int aU(int i2, int i3, int i4) {
        AppMethodBeat.i(156586);
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        switch (mode) {
            case Integer.MIN_VALUE:
                i2 = Math.min(Math.min(i2, size), i3);
                break;
            case 0:
                i2 = Math.min(i2, i3);
                break;
            case 1073741824:
                i2 = size;
                break;
        }
        AppMethodBeat.o(156586);
        return i2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(156587);
        this.QEp = true;
        gZe();
        AppMethodBeat.o(156587);
    }

    private void gZe() {
        float min;
        float f2;
        float f3;
        float f4;
        AppMethodBeat.i(156588);
        if (this.mDrawable == null || !this.QEp) {
            AppMethodBeat.o(156588);
            return;
        }
        int i2 = this.QEv;
        int i3 = this.QEw;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        boolean z = (i2 < 0 || width == i2) && (i3 < 0 || height == i3);
        if (i2 <= 0 || i3 <= 0 || a.FIT_XY == this.QEo) {
            this.mDrawable.setBounds(0, 0, width, height);
            this.QEx = null;
            AppMethodBeat.o(156588);
            return;
        }
        this.mDrawable.setBounds(0, 0, i2, i3);
        if (a.MATRIX == this.QEo) {
            if (this.mMatrix.isIdentity()) {
                this.QEx = null;
                AppMethodBeat.o(156588);
                return;
            }
            this.QEx = this.mMatrix;
            AppMethodBeat.o(156588);
        } else if (z) {
            this.QEx = null;
            AppMethodBeat.o(156588);
        } else if (a.CENTER == this.QEo) {
            this.QEx = this.mMatrix;
            this.QEx.setTranslate((float) ((int) ((((float) (width - i2)) * 0.5f) + 0.5f)), (float) ((int) ((((float) (height - i3)) * 0.5f) + 0.5f)));
            AppMethodBeat.o(156588);
        } else if (a.CENTER_CROP == this.QEo) {
            this.QEx = this.mMatrix;
            if (i2 * height > width * i3) {
                f2 = ((float) height) / ((float) i3);
                f4 = (((float) width) - (((float) i2) * f2)) * 0.5f;
                f3 = 0.0f;
            } else {
                f2 = ((float) width) / ((float) i2);
                f3 = (((float) height) - (((float) i3) * f2)) * 0.5f;
                f4 = 0.0f;
            }
            this.QEx.setScale(f2, f2);
            this.QEx.postTranslate((float) ((int) (f4 + 0.5f)), (float) ((int) (f3 + 0.5f)));
            AppMethodBeat.o(156588);
        } else if (a.CENTER_INSIDE == this.QEo) {
            this.QEx = this.mMatrix;
            if (i2 > width || i3 > height) {
                min = Math.min(((float) width) / ((float) i2), ((float) height) / ((float) i3));
            } else {
                min = 1.0f;
            }
            this.QEx.setScale(min, min);
            this.QEx.postTranslate((float) ((int) (((((float) width) - (((float) i2) * min)) * 0.5f) + 0.5f)), (float) ((int) (((((float) height) - (((float) i3) * min)) * 0.5f) + 0.5f)));
            AppMethodBeat.o(156588);
        } else {
            this.QEy.set(0.0f, 0.0f, (float) i2, (float) i3);
            this.QEz.set(0.0f, 0.0f, (float) width, (float) height);
            this.QEx = this.mMatrix;
            this.QEx.setRectToRect(this.QEy, this.QEz, a(this.QEo));
            AppMethodBeat.o(156588);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        AppMethodBeat.i(156589);
        super.drawableStateChanged();
        Drawable drawable = this.mDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
        AppMethodBeat.o(156589);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(156590);
        canvas.setDrawFilter(this.QEB);
        super.onDraw(canvas);
        if (this.mDrawable == null) {
            AppMethodBeat.o(156590);
        } else if (this.QEv == 0 || this.QEw == 0) {
            AppMethodBeat.o(156590);
        } else {
            if (this.QEx == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
                this.mDrawable.draw(canvas);
            } else {
                int saveCount = canvas.getSaveCount();
                canvas.save();
                if (this.QEA) {
                    int scrollX = getScrollX();
                    int scrollY = getScrollY();
                    canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
                }
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
                if (this.QEx != null) {
                    canvas.concat(this.QEx);
                }
                this.mDrawable.draw(canvas);
                canvas.restoreToCount(saveCount);
            }
            if (Build.VERSION.SDK_INT > 28) {
                canvas.setDrawFilter(this.QEC);
            }
            AppMethodBeat.o(156590);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(156591);
        if (this.aqf) {
            int measuredHeight = getMeasuredHeight();
            AppMethodBeat.o(156591);
            return measuredHeight;
        }
        AppMethodBeat.o(156591);
        return -1;
    }

    public final void setColorFilter(int i2) {
        AppMethodBeat.i(156592);
        setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_ATOP));
        AppMethodBeat.o(156592);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(156593);
        if (this.xo != colorFilter) {
            this.xo = colorFilter;
            this.QEs = true;
            gZf();
            invalidate();
        }
        AppMethodBeat.o(156593);
    }

    public void setAlpha(int i2) {
        AppMethodBeat.i(156594);
        int i3 = i2 & 255;
        if (this.mAlpha != i3) {
            this.mAlpha = i3;
            this.QEs = true;
            gZf();
            invalidate();
        }
        AppMethodBeat.o(156594);
    }

    private void gZf() {
        AppMethodBeat.i(156595);
        if (this.mDrawable != null && this.QEs) {
            this.mDrawable = this.mDrawable.mutate();
            this.mDrawable.setColorFilter(this.xo);
            this.mDrawable.setAlpha((this.mAlpha * this.QEr) >> 8);
        }
        AppMethodBeat.o(156595);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(156596);
        super.onDetachedFromWindow();
        AppMethodBeat.o(156596);
    }
}
