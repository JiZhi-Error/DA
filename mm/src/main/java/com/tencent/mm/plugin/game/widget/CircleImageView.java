package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.a;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g;
import com.tencent.smtt.sdk.WebView;

public class CircleImageView extends ImageView {
    private static final Bitmap.Config itA = Bitmap.Config.ARGB_8888;
    private static final ImageView.ScaleType xZH = ImageView.ScaleType.CENTER_CROP;
    private BitmapShader Kv;
    private final Matrix Kw;
    private float lSR;
    private int lST;
    private final Paint lSU;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private final RectF xZI;
    private final RectF xZJ;
    private final Paint xZK;
    private int xZL;
    private float xZM;
    private boolean xZN;
    private boolean xZO;
    private boolean xZP;
    private ColorFilter xo;

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(42593);
        this.xZI = new RectF();
        this.xZJ = new RectF();
        this.Kw = new Matrix();
        this.xZK = new Paint();
        this.lSU = new Paint();
        this.lST = WebView.NIGHT_MODE_COLOR;
        this.xZL = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.CircleImageView, i2, 0);
        this.xZL = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.lST = obtainStyledAttributes.getColor(0, WebView.NIGHT_MODE_COLOR);
        this.xZP = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
        super.setScaleType(xZH);
        this.xZN = true;
        if (this.xZO) {
            setup();
            this.xZO = false;
        }
        AppMethodBeat.o(42593);
    }

    public ImageView.ScaleType getScaleType() {
        return xZH;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        AppMethodBeat.i(42594);
        if (scaleType != xZH) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
            AppMethodBeat.o(42594);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(42594);
    }

    public void setAdjustViewBounds(boolean z) {
        AppMethodBeat.i(42595);
        if (z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("adjustViewBounds not supported.");
            AppMethodBeat.o(42595);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(42595);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(42596);
        if (getDrawable() == null) {
            AppMethodBeat.o(42596);
            return;
        }
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.xZM, this.xZK);
        if (this.xZL != 0) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.lSR, this.lSU);
        }
        AppMethodBeat.o(42596);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(42597);
        super.onSizeChanged(i2, i3, i4, i5);
        setup();
        AppMethodBeat.o(42597);
    }

    public int getBorderColor() {
        return this.lST;
    }

    public void setBorderColor(int i2) {
        AppMethodBeat.i(42598);
        if (i2 == this.lST) {
            AppMethodBeat.o(42598);
            return;
        }
        this.lST = i2;
        this.lSU.setColor(this.lST);
        invalidate();
        AppMethodBeat.o(42598);
    }

    public void setBorderColorResource(@a int i2) {
        AppMethodBeat.i(42599);
        setBorderColor(getContext().getResources().getColor(i2));
        AppMethodBeat.o(42599);
    }

    public int getBorderWidth() {
        return this.xZL;
    }

    public void setBorderWidth(int i2) {
        AppMethodBeat.i(42600);
        if (i2 == this.xZL) {
            AppMethodBeat.o(42600);
            return;
        }
        this.xZL = i2;
        setup();
        AppMethodBeat.o(42600);
    }

    public void setBorderOverlay(boolean z) {
        AppMethodBeat.i(42601);
        if (z == this.xZP) {
            AppMethodBeat.o(42601);
            return;
        }
        this.xZP = z;
        setup();
        AppMethodBeat.o(42601);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(42602);
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
        AppMethodBeat.o(42602);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(42603);
        super.setImageDrawable(drawable);
        this.mBitmap = z(drawable);
        setup();
        AppMethodBeat.o(42603);
    }

    public void setImageResource(int i2) {
        AppMethodBeat.i(42604);
        super.setImageResource(i2);
        this.mBitmap = z(getDrawable());
        setup();
        AppMethodBeat.o(42604);
    }

    public void setImageURI(Uri uri) {
        AppMethodBeat.i(42605);
        super.setImageURI(uri);
        this.mBitmap = z(getDrawable());
        setup();
        AppMethodBeat.o(42605);
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(42606);
        if (colorFilter == this.xo) {
            AppMethodBeat.o(42606);
            return;
        }
        this.xo = colorFilter;
        this.xZK.setColorFilter(this.xo);
        invalidate();
        AppMethodBeat.o(42606);
    }

    private static Bitmap z(Drawable drawable) {
        Bitmap createBitmap;
        AppMethodBeat.i(42607);
        if (drawable == null) {
            AppMethodBeat.o(42607);
            return null;
        } else if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            AppMethodBeat.o(42607);
            return bitmap;
        } else {
            try {
                if (drawable instanceof ColorDrawable) {
                    createBitmap = Bitmap.createBitmap(2, 2, itA);
                } else {
                    createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), itA);
                }
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                AppMethodBeat.o(42607);
                return createBitmap;
            } catch (OutOfMemoryError e2) {
                AppMethodBeat.o(42607);
                return null;
            }
        }
    }

    private void setup() {
        AppMethodBeat.i(42608);
        if (!this.xZN) {
            this.xZO = true;
            AppMethodBeat.o(42608);
        } else if (this.mBitmap == null) {
            AppMethodBeat.o(42608);
        } else {
            Bitmap bitmap = this.mBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.Kv = new BitmapShader(bitmap, tileMode, tileMode);
            this.xZK.setAntiAlias(true);
            this.xZK.setShader(this.Kv);
            this.lSU.setStyle(Paint.Style.STROKE);
            this.lSU.setAntiAlias(true);
            this.lSU.setColor(this.lST);
            this.lSU.setStrokeWidth((float) this.xZL);
            this.mBitmapHeight = this.mBitmap.getHeight();
            this.mBitmapWidth = this.mBitmap.getWidth();
            this.xZJ.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.lSR = Math.min((this.xZJ.height() - ((float) this.xZL)) / 2.0f, (this.xZJ.width() - ((float) this.xZL)) / 2.0f);
            this.xZI.set(this.xZJ);
            if (!this.xZP) {
                this.xZI.inset((float) this.xZL, (float) this.xZL);
            }
            this.xZM = Math.min(this.xZI.height() / 2.0f, this.xZI.width() / 2.0f);
            dWV();
            invalidate();
            AppMethodBeat.o(42608);
        }
    }

    private void dWV() {
        float width;
        float height;
        float f2;
        AppMethodBeat.i(42609);
        this.Kw.set(null);
        if (((float) this.mBitmapWidth) * this.xZI.height() > this.xZI.width() * ((float) this.mBitmapHeight)) {
            width = this.xZI.height() / ((float) this.mBitmapHeight);
            f2 = (this.xZI.width() - (((float) this.mBitmapWidth) * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.xZI.width() / ((float) this.mBitmapWidth);
            height = (this.xZI.height() - (((float) this.mBitmapHeight) * width)) * 0.5f;
            f2 = 0.0f;
        }
        this.Kw.setScale(width, width);
        this.Kw.postTranslate(((float) ((int) (f2 + 0.5f))) + this.xZI.left, ((float) ((int) (height + 0.5f))) + this.xZI.top);
        this.Kv.setLocalMatrix(this.Kw);
        AppMethodBeat.o(42609);
    }
}
