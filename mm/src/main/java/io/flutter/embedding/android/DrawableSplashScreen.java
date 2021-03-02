package io.flutter.embedding.android;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DrawableSplashScreen implements j {
    private final ImageView.ScaleType SMv;
    private final long SMw;
    private DrawableSplashScreenView SMx;
    private final Drawable drawable;

    public DrawableSplashScreen(Drawable drawable2) {
        this(drawable2, ImageView.ScaleType.FIT_XY);
    }

    private DrawableSplashScreen(Drawable drawable2, ImageView.ScaleType scaleType) {
        this.drawable = drawable2;
        this.SMv = scaleType;
        this.SMw = 500;
    }

    @Override // io.flutter.embedding.android.j
    public final View lM(Context context) {
        AppMethodBeat.i(10067);
        this.SMx = new DrawableSplashScreenView(context);
        this.SMx.a(this.drawable, this.SMv);
        DrawableSplashScreenView drawableSplashScreenView = this.SMx;
        AppMethodBeat.o(10067);
        return drawableSplashScreenView;
    }

    @Override // io.flutter.embedding.android.j
    public final void bc(final Runnable runnable) {
        AppMethodBeat.i(10068);
        if (this.SMx == null) {
            runnable.run();
            AppMethodBeat.o(10068);
            return;
        }
        this.SMx.animate().alpha(0.0f).setDuration(this.SMw).setListener(new Animator.AnimatorListener() {
            /* class io.flutter.embedding.android.DrawableSplashScreen.AnonymousClass1 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(10026);
                runnable.run();
                AppMethodBeat.o(10026);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(10027);
                runnable.run();
                AppMethodBeat.o(10027);
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        AppMethodBeat.o(10068);
    }

    public static class DrawableSplashScreenView extends ImageView {
        public DrawableSplashScreenView(Context context) {
            this(context, null, 0);
        }

        public DrawableSplashScreenView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public DrawableSplashScreenView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
        }

        public void setSplashDrawable(Drawable drawable) {
            AppMethodBeat.i(10069);
            a(drawable, ImageView.ScaleType.FIT_XY);
            AppMethodBeat.o(10069);
        }

        public final void a(Drawable drawable, ImageView.ScaleType scaleType) {
            AppMethodBeat.i(10070);
            setScaleType(scaleType);
            setImageDrawable(drawable);
            AppMethodBeat.o(10070);
        }
    }
}
