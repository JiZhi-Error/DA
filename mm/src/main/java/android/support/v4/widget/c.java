package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v4.view.u;
import android.view.animation.Animation;
import android.widget.ImageView;

/* access modifiers changed from: package-private */
public final class c extends ImageView {
    Animation.AnimationListener SD;
    int SE;

    c(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f2);
        int i3 = (int) (0.0f * f2);
        this.SE = (int) (3.5f * f2);
        if (fN()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            u.l(this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new a(this.SE));
            setLayerType(1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.SE, (float) i3, (float) i2, 503316480);
            int i4 = this.SE;
            setPadding(i4, i4, i4, i4);
        }
        shapeDrawable.getPaint().setColor(-328966);
        u.a(this, shapeDrawable);
    }

    private static boolean fN() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!fN()) {
            setMeasuredDimension(getMeasuredWidth() + (this.SE * 2), getMeasuredHeight() + (this.SE * 2));
        }
    }

    public final void onAnimationStart() {
        super.onAnimationStart();
        if (this.SD != null) {
            this.SD.onAnimationStart(getAnimation());
        }
    }

    public final void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.SD != null) {
            this.SD.onAnimationEnd(getAnimation());
        }
    }

    public final void setBackgroundColor(int i2) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }

    class a extends OvalShape {
        private RadialGradient SF;
        private Paint SG = new Paint();

        a(int i2) {
            c.this.SE = i2;
            aU((int) rect().width());
        }

        /* access modifiers changed from: protected */
        public final void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            aU((int) f2);
        }

        public final void draw(Canvas canvas, Paint paint) {
            int width = c.this.getWidth();
            int height = c.this.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (width / 2), this.SG);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((width / 2) - c.this.SE), paint);
        }

        private void aU(int i2) {
            this.SF = new RadialGradient((float) (i2 / 2), (float) (i2 / 2), (float) c.this.SE, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.SG.setShader(this.SF);
        }
    }
}
