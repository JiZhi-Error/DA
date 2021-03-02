package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i;
import com.tencent.smtt.sdk.WebView;

public class CircularImageView extends ImageView {
    private static final String TAG = CircularImageView.class.getSimpleName();
    private boolean EiT;
    private boolean EiU;
    private int EiV;
    private int EiW;
    private BitmapShader EiX;
    private Bitmap EiY;
    private Paint EiZ;
    private Paint Eja;
    private ColorFilter Ejb;
    private boolean isSelected;
    private boolean lY;
    private float ly;
    private float lz;
    private Paint paint;
    private int rc;
    private int shadowColor;
    private float shadowRadius;

    static {
        AppMethodBeat.i(97178);
        AppMethodBeat.o(97178);
    }

    public CircularImageView(Context context) {
        this(context, null, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(97162);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.EiZ = new Paint();
        this.EiZ.setAntiAlias(true);
        this.EiZ.setStyle(Paint.Style.STROKE);
        this.Eja = new Paint();
        this.Eja.setAntiAlias(true);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.a.CircularImageView, i2, 0);
        this.EiT = obtainStyledAttributes.getBoolean(0, false);
        this.EiU = obtainStyledAttributes.getBoolean(3, false);
        this.lY = obtainStyledAttributes.getBoolean(7, false);
        if (this.EiT) {
            setBorderWidth(obtainStyledAttributes.getDimensionPixelOffset(2, (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f)));
            setBorderColor(obtainStyledAttributes.getColor(1, -1));
        }
        if (this.EiU) {
            setSelectorColor(obtainStyledAttributes.getColor(4, 0));
            setSelectorStrokeWidth(obtainStyledAttributes.getDimensionPixelOffset(6, (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f)));
            setSelectorStrokeColor(obtainStyledAttributes.getColor(5, -16776961));
        }
        if (this.lY) {
            this.shadowRadius = obtainStyledAttributes.getFloat(11, 4.0f);
            this.ly = obtainStyledAttributes.getFloat(9, 0.0f);
            this.lz = obtainStyledAttributes.getFloat(10, 2.0f);
            this.shadowColor = obtainStyledAttributes.getColor(8, WebView.NIGHT_MODE_COLOR);
            setShadowEnabled(true);
        }
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(97162);
    }

    public void setBorderWidth(int i2) {
        AppMethodBeat.i(97163);
        this.rc = i2;
        if (this.EiZ != null) {
            this.EiZ.setStrokeWidth((float) i2);
        }
        requestLayout();
        invalidate();
        AppMethodBeat.o(97163);
    }

    public void setBorderColor(int i2) {
        AppMethodBeat.i(97164);
        if (this.EiZ != null) {
            this.EiZ.setColor(i2);
        }
        invalidate();
        AppMethodBeat.o(97164);
    }

    public void setSelectorColor(int i2) {
        AppMethodBeat.i(97165);
        this.Ejb = new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
        invalidate();
        AppMethodBeat.o(97165);
    }

    public void setSelectorStrokeWidth(int i2) {
        AppMethodBeat.i(97166);
        this.EiW = i2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(97166);
    }

    public void setSelectorStrokeColor(int i2) {
        AppMethodBeat.i(97167);
        if (this.Eja != null) {
            this.Eja.setColor(i2);
        }
        invalidate();
        AppMethodBeat.o(97167);
    }

    public void setShadowEnabled(boolean z) {
        AppMethodBeat.i(97168);
        this.lY = z;
        float f2 = this.lY ? this.shadowRadius : 0.0f;
        this.EiZ.setShadowLayer(f2, this.ly, this.lz, this.shadowColor);
        this.Eja.setShadowLayer(f2, this.ly, this.lz, this.shadowColor);
        AppMethodBeat.o(97168);
    }

    public void onDraw(Canvas canvas) {
        int i2 = 0;
        AppMethodBeat.i(97169);
        if (this.EiY == null) {
            AppMethodBeat.o(97169);
        } else if (this.EiY.getHeight() == 0 || this.EiY.getWidth() == 0) {
            AppMethodBeat.o(97169);
        } else {
            int i3 = this.EiV;
            this.EiV = getWidth() < getHeight() ? getWidth() : getHeight();
            if (i3 != this.EiV) {
                fem();
            }
            this.paint.setShader(this.EiX);
            int i4 = this.EiV / 2;
            if (this.EiU && this.isSelected) {
                i2 = this.EiW;
                i4 = (this.EiV - (i2 * 2)) / 2;
                this.paint.setColorFilter(this.Ejb);
                canvas.drawCircle((float) (i4 + i2), (float) (i4 + i2), ((float) (((this.EiV - (i2 * 2)) / 2) + i2)) - 4.0f, this.Eja);
            } else if (this.EiT) {
                int i5 = this.rc;
                int i6 = (this.EiV - (i5 * 2)) / 2;
                this.paint.setColorFilter(null);
                canvas.drawArc(new RectF((float) ((i5 / 2) + 0), (float) ((i5 / 2) + 0), (float) (this.EiV - (i5 / 2)), (float) (this.EiV - (i5 / 2))), 360.0f, 360.0f, false, this.EiZ);
                i4 = i6;
                i2 = i5;
            } else {
                this.paint.setColorFilter(null);
            }
            canvas.drawCircle((float) (i4 + i2), (float) (i4 + i2), (float) ((this.EiV - (i2 * 2)) / 2), this.paint);
            AppMethodBeat.o(97169);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(97170);
        if (!isClickable()) {
            this.isSelected = false;
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(97170);
            return onTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.isSelected = true;
                break;
            case 1:
            case 3:
            case 4:
            case 8:
                this.isSelected = false;
                break;
        }
        invalidate();
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(97170);
        return dispatchTouchEvent;
    }

    public void setImageURI(Uri uri) {
        AppMethodBeat.i(97171);
        super.setImageURI(uri);
        this.EiY = drawableToBitmap(getDrawable());
        if (this.EiV > 0) {
            fem();
        }
        AppMethodBeat.o(97171);
    }

    public void setImageResource(int i2) {
        AppMethodBeat.i(97172);
        super.setImageResource(i2);
        this.EiY = drawableToBitmap(getDrawable());
        if (this.EiV > 0) {
            fem();
        }
        AppMethodBeat.o(97172);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(97173);
        super.setImageDrawable(drawable);
        this.EiY = drawableToBitmap(getDrawable());
        if (this.EiV > 0) {
            fem();
        }
        AppMethodBeat.o(97173);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(97174);
        super.setImageBitmap(bitmap);
        this.EiY = bitmap;
        if (this.EiV > 0) {
            fem();
        }
        AppMethodBeat.o(97174);
    }

    private static Bitmap drawableToBitmap(Drawable drawable) {
        AppMethodBeat.i(97176);
        if (drawable == null) {
            AppMethodBeat.o(97176);
            return null;
        } else if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            AppMethodBeat.o(97176);
            return bitmap;
        } else {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                AppMethodBeat.o(97176);
                return null;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                AppMethodBeat.o(97176);
                return createBitmap;
            } catch (OutOfMemoryError e2) {
                AppMethodBeat.o(97176);
                return null;
            }
        }
    }

    public void setIconModeEnabled(boolean z) {
    }

    private void fem() {
        AppMethodBeat.i(97177);
        if (this.EiY == null) {
            AppMethodBeat.o(97177);
            return;
        }
        Bitmap bitmap = this.EiY;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.EiX = new BitmapShader(bitmap, tileMode, tileMode);
        if (!(this.EiV == this.EiY.getWidth() && this.EiV == this.EiY.getHeight())) {
            Matrix matrix = new Matrix();
            float width = ((float) this.EiV) / ((float) this.EiY.getWidth());
            matrix.setScale(width, width);
            this.EiX.setLocalMatrix(matrix);
        }
        AppMethodBeat.o(97177);
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(97175);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            size = this.EiV;
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (!(mode2 == 1073741824 || mode2 == Integer.MIN_VALUE)) {
            size2 = this.EiV;
        }
        setMeasuredDimension(size, size2 + 2);
        AppMethodBeat.o(97175);
    }
}
