package com.tencent.mm.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.smtt.sdk.WebView;

public class AnimationLayout extends FrameLayout {
    public RectF GPe = new RectF();
    public Rect Rij = new Rect();

    public AnimationLayout(Context context) {
        super(context);
        AppMethodBeat.i(164237);
        AppMethodBeat.o(164237);
    }

    public AnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143605);
        AppMethodBeat.o(143605);
    }

    public AnimationLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143606);
        AppMethodBeat.o(143606);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(164238);
        super.onAttachedToWindow();
        if (getBackground() == null) {
            setBackgroundColor(0);
        }
        AppMethodBeat.o(164238);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(143608);
        if (this.Rij.isEmpty()) {
            canvas.getClipBounds(this.Rij);
        }
        if (this.GPe.isEmpty()) {
            super.draw(canvas);
            AppMethodBeat.o(143608);
            return;
        }
        canvas.save();
        canvas.clipRect(this.GPe);
        super.draw(canvas);
        canvas.restore();
        AppMethodBeat.o(143608);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(143609);
        super.onDetachedFromWindow();
        this.GPe.setEmpty();
        AppMethodBeat.o(143609);
    }

    public final void a(final View view, final View view2, final ViewAnimHelper.ViewInfo viewInfo, final Animator.AnimatorListener animatorListener) {
        AppMethodBeat.i(164239);
        final AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.view.AnimationLayout.AnonymousClass1 */
            final /* synthetic */ ValueAnimator.AnimatorUpdateListener Rio = null;

            public final void run() {
                final float f2;
                AnonymousClass1 r0;
                AppMethodBeat.i(164235);
                ViewAnimHelper.ViewInfo q = ViewAnimHelper.q(AnimationLayout.this, view2);
                final float width = (((float) q.QMg.width()) * 1.0f) / ((float) viewInfo.QMg.width());
                final float height = (((float) q.QMg.height()) * 1.0f) / ((float) viewInfo.QMg.height());
                final float f3 = width > height ? width : 1.0f;
                if (height > width) {
                    f2 = height;
                } else {
                    f2 = 1.0f;
                }
                AnimationLayout animationLayout = AnimationLayout.this;
                View view = view;
                ViewAnimHelper.ViewInfo viewInfo = viewInfo;
                Animator.AnimatorListener animatorListener = animatorListener;
                if (f3 > 1.0f || f2 > 1.0f) {
                    r0 = new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.tencent.mm.view.AnimationLayout.AnonymousClass1.AnonymousClass1 */
                        Matrix gT = new Matrix();

                        {
                            AppMethodBeat.i(164233);
                            AppMethodBeat.o(164233);
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(164234);
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (f3 > 1.0f) {
                                this.gT.setScale((1.0f - floatValue) + ((height * floatValue) / width), 1.0f, (float) AnimationLayout.this.Rij.centerX(), (float) AnimationLayout.this.Rij.centerY());
                            } else if (f2 > 1.0f) {
                                this.gT.setScale(1.0f, (1.0f - floatValue) + ((width * floatValue) / height), (float) AnimationLayout.this.Rij.centerX(), (float) AnimationLayout.this.Rij.centerY());
                            }
                            this.gT.mapRect(AnimationLayout.this.GPe, new RectF(AnimationLayout.this.Rij));
                            if (AnonymousClass1.this.Rio != null) {
                                AnonymousClass1.this.Rio.onAnimationUpdate(valueAnimator);
                            }
                            AnimationLayout.this.invalidate();
                            AppMethodBeat.o(164234);
                        }
                    };
                } else {
                    r0 = null;
                }
                ViewAnimHelper.c(animationLayout, view, viewInfo, animatorListener, r0);
                AppMethodBeat.o(164235);
            }
        };
        if ((getMeasuredState() & WebView.NIGHT_MODE_COLOR) > 0) {
            r0.run();
            AppMethodBeat.o(164239);
            return;
        }
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.tencent.mm.view.AnimationLayout.AnonymousClass2 */

            public final boolean onPreDraw() {
                AppMethodBeat.i(164236);
                AnimationLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                r0.run();
                AppMethodBeat.o(164236);
                return true;
            }
        });
        AppMethodBeat.o(164239);
    }

    public final void a(View view, View view2, ViewAnimHelper.ViewInfo viewInfo, Animator.AnimatorListener animatorListener, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        final float f2 = 1.0f;
        AppMethodBeat.i(143610);
        ViewAnimHelper.ViewInfo q = ViewAnimHelper.q(this, view2);
        final float width = (((float) q.QMg.width()) * 1.0f) / ((float) viewInfo.QMg.width());
        final float height = (((float) q.QMg.height()) * 1.0f) / ((float) viewInfo.QMg.height());
        final float f3 = width > height ? width : 1.0f;
        if (height > width) {
            f2 = height;
        }
        ViewAnimHelper.a(this, view, viewInfo, animatorListener, new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.view.AnimationLayout.AnonymousClass3 */
            Matrix gT = new Matrix();

            {
                AppMethodBeat.i(143603);
                AppMethodBeat.o(143603);
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(143604);
                if (f3 > 1.0f || f2 > 1.0f) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (f3 > 1.0f) {
                        this.gT.setScale((1.0f - floatValue) + ((height * floatValue) / width), 1.0f, (float) AnimationLayout.this.Rij.centerX(), (float) AnimationLayout.this.Rij.centerY());
                    } else if (f2 > 1.0f) {
                        this.gT.setScale(1.0f, (1.0f - floatValue) + ((width * floatValue) / height), (float) AnimationLayout.this.Rij.centerX(), (float) AnimationLayout.this.Rij.centerY());
                    }
                    this.gT.mapRect(AnimationLayout.this.GPe, new RectF(AnimationLayout.this.Rij));
                    AnimationLayout.this.invalidate();
                }
                if (animatorUpdateListener != null) {
                    animatorUpdateListener.onAnimationUpdate(valueAnimator);
                }
                AppMethodBeat.o(143604);
            }
        });
        AppMethodBeat.o(143610);
    }

    public final void b(final View view, final View view2, final ViewAnimHelper.ViewInfo viewInfo, final Animator.AnimatorListener animatorListener, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        AppMethodBeat.i(206163);
        final AnonymousClass4 r0 = new Runnable() {
            /* class com.tencent.mm.view.AnimationLayout.AnonymousClass4 */

            public final void run() {
                final float f2;
                AnonymousClass1 r0;
                AppMethodBeat.i(206161);
                ViewAnimHelper.ViewInfo q = ViewAnimHelper.q(AnimationLayout.this, view2);
                final float width = (((float) q.QMg.width()) * 1.0f) / ((float) viewInfo.QMg.width());
                final float height = (((float) q.QMg.height()) * 1.0f) / ((float) viewInfo.QMg.height());
                final float f3 = width > height ? width : 1.0f;
                if (height > width) {
                    f2 = height;
                } else {
                    f2 = 1.0f;
                }
                AnimationLayout animationLayout = AnimationLayout.this;
                View view = view;
                ViewAnimHelper.ViewInfo viewInfo = viewInfo;
                Animator.AnimatorListener animatorListener = animatorListener;
                if (f3 > 1.0f || f2 > 1.0f) {
                    r0 = new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.tencent.mm.view.AnimationLayout.AnonymousClass4.AnonymousClass1 */
                        Matrix gT = new Matrix();

                        {
                            AppMethodBeat.i(206159);
                            AppMethodBeat.o(206159);
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(206160);
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (f3 > 1.0f) {
                                this.gT.setScale(floatValue + ((height / width) * (1.0f - floatValue)), 1.0f, (float) AnimationLayout.this.Rij.centerX(), (float) AnimationLayout.this.Rij.centerY());
                            } else if (f2 > 1.0f) {
                                this.gT.setScale(1.0f, floatValue + ((width / height) * (1.0f - floatValue)), (float) AnimationLayout.this.Rij.centerX(), (float) AnimationLayout.this.Rij.centerY());
                            }
                            this.gT.mapRect(AnimationLayout.this.GPe, new RectF(AnimationLayout.this.Rij));
                            if (animatorUpdateListener != null) {
                                animatorUpdateListener.onAnimationUpdate(valueAnimator);
                            }
                            AnimationLayout.this.invalidate();
                            AppMethodBeat.o(206160);
                        }
                    };
                } else {
                    r0 = null;
                }
                ViewAnimHelper.c(animationLayout, view, viewInfo, animatorListener, r0);
                AppMethodBeat.o(206161);
            }
        };
        if ((getMeasuredState() & WebView.NIGHT_MODE_COLOR) > 0) {
            r0.run();
            AppMethodBeat.o(206163);
            return;
        }
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.tencent.mm.view.AnimationLayout.AnonymousClass5 */

            public final boolean onPreDraw() {
                AppMethodBeat.i(206162);
                AnimationLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                r0.run();
                AppMethodBeat.o(206162);
                return true;
            }
        });
        AppMethodBeat.o(206163);
    }
}
