package com.tencent.kinda.framework.widget.base;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class MMKViewBackgroundBorderDrawable extends Drawable {
    private int backgroundColor;
    private int borderColor;
    private Path borderPath;
    private int borderPressedColor;
    private float borderRadius;
    private float borderWidth;
    private float bottomLeftBorderRadius;
    private float bottomRightBorderRadius;
    private Drawable insetDrawable;
    private Path insetDrawableClipPath;
    private boolean isPressed;
    private View mView;
    private Paint paint;
    private RectF roundBorderRectF;
    private float[] roundBorderradii;
    private float topLeftBorderRadius;
    private float topRightBorderRadius;

    public MMKViewBackgroundBorderDrawable(View view) {
        AppMethodBeat.i(19246);
        this.borderWidth = 0.0f;
        this.borderRadius = 0.0f;
        this.topLeftBorderRadius = 0.0f;
        this.topRightBorderRadius = 0.0f;
        this.bottomLeftBorderRadius = 0.0f;
        this.bottomRightBorderRadius = 0.0f;
        this.borderColor = 0;
        this.borderPressedColor = 0;
        this.isPressed = false;
        this.backgroundColor = 0;
        this.paint = new Paint();
        this.roundBorderRectF = new RectF();
        this.roundBorderradii = new float[8];
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.borderPath = new Path();
        this.insetDrawableClipPath = new Path();
        this.mView = view;
        AppMethodBeat.o(19246);
    }

    public void setInsetDrawable(Drawable drawable) {
        AppMethodBeat.i(19247);
        this.insetDrawable = drawable;
        invalidateSelf();
        AppMethodBeat.o(19247);
    }

    public int getOpacity() {
        AppMethodBeat.i(19248);
        if (this.insetDrawable != null) {
            int opacity = this.insetDrawable.getOpacity();
            AppMethodBeat.o(19248);
            return opacity;
        } else if (this.backgroundColor == 0) {
            AppMethodBeat.o(19248);
            return -2;
        } else if (Color.alpha(this.backgroundColor) > 0) {
            AppMethodBeat.o(19248);
            return -3;
        } else {
            AppMethodBeat.o(19248);
            return -1;
        }
    }

    public void setBorderWidth(float f2) {
        AppMethodBeat.i(19249);
        if (this.borderWidth != f2) {
            this.borderWidth = f2;
            invalidateSelf();
        }
        AppMethodBeat.o(19249);
    }

    public void setBorderColor(int i2) {
        AppMethodBeat.i(19250);
        if (this.borderColor != i2) {
            this.borderColor = i2;
            invalidateSelf();
        }
        AppMethodBeat.o(19250);
    }

    public void setBorderPressedColor(int i2) {
        AppMethodBeat.i(19251);
        if (this.borderPressedColor != i2) {
            this.borderPressedColor = i2;
            invalidateSelf();
        }
        AppMethodBeat.o(19251);
    }

    public void setBorderRadius(float f2) {
        AppMethodBeat.i(19252);
        if (this.borderRadius != f2) {
            this.borderRadius = f2;
            invalidateSelf();
        }
        AppMethodBeat.o(19252);
    }

    public void setTopLeftBorderRadius(float f2) {
        AppMethodBeat.i(19253);
        if (this.topLeftBorderRadius != f2) {
            this.topLeftBorderRadius = f2;
            invalidateSelf();
        }
        AppMethodBeat.o(19253);
    }

    public void setTopRightBorderRadius(float f2) {
        AppMethodBeat.i(19254);
        if (this.topRightBorderRadius != f2) {
            this.topRightBorderRadius = f2;
            invalidateSelf();
        }
        AppMethodBeat.o(19254);
    }

    public void setBottomLeftBorderRadius(float f2) {
        AppMethodBeat.i(19255);
        if (this.bottomLeftBorderRadius != f2) {
            this.bottomLeftBorderRadius = f2;
            invalidateSelf();
        }
        AppMethodBeat.o(19255);
    }

    public void setBottomRightBorderRadius(float f2) {
        AppMethodBeat.i(19256);
        if (this.bottomRightBorderRadius != f2) {
            this.bottomRightBorderRadius = f2;
            invalidateSelf();
        }
        AppMethodBeat.o(19256);
    }

    public void setBackgroundColor(int i2) {
        AppMethodBeat.i(19257);
        if (this.backgroundColor != i2) {
            this.backgroundColor = i2;
            invalidateSelf();
        }
        AppMethodBeat.o(19257);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(19258);
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width <= 0 || height <= 0) {
            AppMethodBeat.o(19258);
            return;
        }
        this.paint.reset();
        if (this.borderRadius > 0.0f || this.topLeftBorderRadius > 0.0f || this.topRightBorderRadius > 0.0f || this.bottomLeftBorderRadius > 0.0f || this.bottomRightBorderRadius > 0.0f) {
            drawClipRadiusBorder(canvas);
            if (this.insetDrawable != null) {
                this.insetDrawable.draw(canvas);
            }
        } else {
            if (this.insetDrawable == null) {
                canvas.drawARGB(Color.alpha(this.backgroundColor), Color.red(this.backgroundColor), Color.green(this.backgroundColor), Color.blue(this.backgroundColor));
            } else {
                this.insetDrawable.draw(canvas);
            }
            if (this.borderWidth > 0.0f) {
                drawClipRectBorder(canvas);
                AppMethodBeat.o(19258);
                return;
            }
        }
        AppMethodBeat.o(19258);
    }

    private void drawClipRectBorder(Canvas canvas) {
        AppMethodBeat.i(19259);
        Rect bounds = getBounds();
        int i2 = bounds.top;
        int i3 = bounds.left;
        int width = bounds.width();
        int height = bounds.height();
        this.paint.reset();
        if (this.isPressed) {
            this.paint.setColor(this.borderPressedColor);
        } else {
            this.paint.setColor(this.borderColor);
        }
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setAntiAlias(true);
        this.borderPath.reset();
        this.borderPath.moveTo((float) i3, (float) i2);
        this.borderPath.lineTo(((float) i3) + this.borderWidth, (float) i2);
        this.borderPath.lineTo(((float) i3) + this.borderWidth, (float) (i2 + height));
        this.borderPath.lineTo((float) i3, (float) (i2 + height));
        this.borderPath.lineTo((float) i3, (float) i2);
        canvas.drawPath(this.borderPath, this.paint);
        this.borderPath.reset();
        this.borderPath.moveTo(((float) i3) + this.borderWidth, (float) i2);
        this.borderPath.lineTo((float) (i3 + width), (float) i2);
        this.borderPath.lineTo((float) (i3 + width), ((float) i2) + this.borderWidth);
        this.borderPath.lineTo(((float) i3) + this.borderWidth, ((float) i2) + this.borderWidth);
        this.borderPath.lineTo(((float) i3) + this.borderWidth, (float) i2);
        canvas.drawPath(this.borderPath, this.paint);
        this.borderPath.reset();
        this.borderPath.moveTo((float) (i3 + width), (float) i2);
        this.borderPath.lineTo((float) (i3 + width), (float) (i2 + height));
        this.borderPath.lineTo(((float) (i3 + width)) - this.borderWidth, (float) (i2 + height));
        this.borderPath.lineTo(((float) (i3 + width)) - this.borderWidth, (float) i2);
        this.borderPath.lineTo((float) (i3 + width), (float) i2);
        canvas.drawPath(this.borderPath, this.paint);
        this.borderPath.reset();
        this.borderPath.moveTo(((float) i3) + this.borderWidth, ((float) (i2 + height)) - this.borderWidth);
        this.borderPath.lineTo((float) (i3 + width), ((float) (i2 + height)) - this.borderWidth);
        this.borderPath.lineTo((float) (width + i3), (float) (i2 + height));
        this.borderPath.lineTo(((float) i3) + this.borderWidth, (float) (i2 + height));
        this.borderPath.lineTo(((float) i3) + this.borderWidth, ((float) (height + i2)) - this.borderWidth);
        canvas.drawPath(this.borderPath, this.paint);
        this.paint.setAntiAlias(false);
        AppMethodBeat.o(19259);
    }

    private void drawClipRadiusBorder(Canvas canvas) {
        AppMethodBeat.i(19260);
        this.paint.reset();
        this.borderPath.reset();
        this.insetDrawableClipPath.reset();
        this.paint.setAntiAlias(true);
        this.roundBorderRectF.set(getBounds());
        this.roundBorderRectF.inset(this.borderWidth / 2.0f, this.borderWidth / 2.0f);
        Arrays.fill(this.roundBorderradii, this.borderRadius);
        if (this.topLeftBorderRadius > 0.0f) {
            this.roundBorderradii[0] = this.topLeftBorderRadius;
            this.roundBorderradii[1] = this.topLeftBorderRadius;
        }
        if (this.topRightBorderRadius > 0.0f) {
            this.roundBorderradii[2] = this.topRightBorderRadius;
            this.roundBorderradii[3] = this.topRightBorderRadius;
        }
        if (this.bottomLeftBorderRadius > 0.0f) {
            this.roundBorderradii[4] = this.bottomLeftBorderRadius;
            this.roundBorderradii[5] = this.bottomLeftBorderRadius;
        }
        if (this.bottomRightBorderRadius > 0.0f) {
            this.roundBorderradii[6] = this.bottomRightBorderRadius;
            this.roundBorderradii[7] = this.bottomRightBorderRadius;
        }
        this.borderPath.addRoundRect(this.roundBorderRectF, this.roundBorderradii, Path.Direction.CCW);
        this.roundBorderRectF.set(getBounds());
        this.roundBorderRectF.inset(this.borderWidth, this.borderWidth);
        Arrays.fill(this.roundBorderradii, this.borderRadius);
        if (this.topLeftBorderRadius > 0.0f) {
            this.roundBorderradii[0] = this.topLeftBorderRadius;
            this.roundBorderradii[1] = this.topLeftBorderRadius;
        }
        if (this.topRightBorderRadius > 0.0f) {
            this.roundBorderradii[2] = this.topRightBorderRadius;
            this.roundBorderradii[3] = this.topRightBorderRadius;
        }
        if (this.bottomLeftBorderRadius > 0.0f) {
            this.roundBorderradii[4] = this.bottomLeftBorderRadius;
            this.roundBorderradii[5] = this.bottomLeftBorderRadius;
        }
        if (this.bottomRightBorderRadius > 0.0f) {
            this.roundBorderradii[6] = this.bottomRightBorderRadius;
            this.roundBorderradii[7] = this.bottomRightBorderRadius;
        }
        this.insetDrawableClipPath.addRoundRect(this.roundBorderRectF, this.roundBorderradii, Path.Direction.CCW);
        if (this.insetDrawable == null && Color.alpha(this.backgroundColor) > 0) {
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(this.backgroundColor);
            canvas.drawPath(this.borderPath, this.paint);
        }
        if (Color.alpha(this.borderColor) > 0 && !this.isPressed) {
            this.paint.setColor(this.borderColor);
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.borderPath, this.paint);
            if (this.insetDrawable != null) {
                canvas.clipPath(this.insetDrawableClipPath);
                AppMethodBeat.o(19260);
                return;
            }
        } else if (Color.alpha(this.borderPressedColor) <= 0 || !this.isPressed) {
            canvas.clipPath(this.insetDrawableClipPath);
        } else {
            this.paint.setColor(this.borderPressedColor);
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.borderPath, this.paint);
            if (this.insetDrawable != null) {
                canvas.clipPath(this.insetDrawableClipPath);
                AppMethodBeat.o(19260);
                return;
            }
        }
        AppMethodBeat.o(19260);
    }

    public boolean isStateful() {
        AppMethodBeat.i(19261);
        if (this.insetDrawable != null) {
            boolean isStateful = this.insetDrawable.isStateful();
            AppMethodBeat.o(19261);
            return isStateful;
        }
        AppMethodBeat.o(19261);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        AppMethodBeat.i(19262);
        if (this.mView == null || this.mView.isEnabled() || !containsPressedState(iArr) || this.isPressed) {
            if (containsPressedState(iArr)) {
                this.isPressed = true;
            } else {
                this.isPressed = false;
            }
            if (this.insetDrawable != null) {
                boolean state = this.insetDrawable.setState(iArr);
                invalidateSelf();
                AppMethodBeat.o(19262);
                return state;
            }
            boolean onStateChange = super.onStateChange(iArr);
            AppMethodBeat.o(19262);
            return onStateChange;
        }
        AppMethodBeat.o(19262);
        return false;
    }

    private boolean containsPressedState(int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == 16842919) {
                return true;
            }
        }
        return false;
    }

    public void setAlpha(int i2) {
        AppMethodBeat.i(19263);
        if (this.insetDrawable != null) {
            this.insetDrawable.setAlpha(i2);
        }
        AppMethodBeat.o(19263);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(19264);
        if (this.insetDrawable != null) {
            this.insetDrawable.setColorFilter(colorFilter);
        }
        AppMethodBeat.o(19264);
    }
}
