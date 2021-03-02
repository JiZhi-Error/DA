package com.tencent.mm.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ViewAnimHelper {
    private static void b(View view, Rect rect, Rect rect2) {
        AppMethodBeat.i(143622);
        view.getGlobalVisibleRect(rect);
        if (!rect2.isEmpty() && rect.bottom - view.getHeight() < rect2.top) {
            rect.top = rect.bottom - view.getHeight();
        }
        AppMethodBeat.o(143622);
    }

    public static ViewInfo q(View view, View view2) {
        AppMethodBeat.i(143623);
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        if (view2 != null) {
            view2.getGlobalVisibleRect(rect2);
        }
        b(view, rect, rect2);
        ViewInfo viewInfo = new ViewInfo(rect);
        AppMethodBeat.o(143623);
        return viewInfo;
    }

    public static class ViewInfo implements Parcelable {
        public static final Parcelable.Creator<ViewInfo> CREATOR = new Parcelable.Creator<ViewInfo>() {
            /* class com.tencent.mm.view.ViewAnimHelper.ViewInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ViewInfo[] newArray(int i2) {
                return new ViewInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ViewInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(143617);
                ViewInfo viewInfo = new ViewInfo(parcel);
                AppMethodBeat.o(143617);
                return viewInfo;
            }
        };
        public Rect QMg = new Rect();

        public ViewInfo(Rect rect) {
            AppMethodBeat.i(143618);
            this.QMg.set(rect);
            AppMethodBeat.o(143618);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(143619);
            parcel.writeParcelable(this.QMg, i2);
            AppMethodBeat.o(143619);
        }

        protected ViewInfo(Parcel parcel) {
            AppMethodBeat.i(143620);
            this.QMg = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            AppMethodBeat.o(143620);
        }

        static {
            AppMethodBeat.i(143621);
            AppMethodBeat.o(143621);
        }
    }

    public static void c(final View view, final View view2, ViewInfo viewInfo, final Animator.AnimatorListener animatorListener, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        AppMethodBeat.i(206184);
        ViewInfo q = q(view, null);
        final float max = Math.max((((float) viewInfo.QMg.height()) * 1.0f) / ((float) q.QMg.height()), (((float) viewInfo.QMg.width()) * 1.0f) / ((float) q.QMg.width()));
        final float centerX = (float) q.QMg.centerX();
        final float centerY = (float) q.QMg.centerY();
        final float centerX2 = (float) viewInfo.QMg.centerX();
        final float centerY2 = (float) viewInfo.QMg.centerY();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator(1.2f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.view.ViewAnimHelper.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(164324);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.setTranslationX((1.0f - floatValue) * (centerX2 - centerX));
                view.setTranslationY((1.0f - floatValue) * (centerY2 - centerY));
                view.setScaleX((max * (1.0f - floatValue)) + floatValue);
                view.setScaleY((max * (1.0f - floatValue)) + floatValue);
                view2.setAlpha(floatValue);
                if (animatorUpdateListener != null) {
                    animatorUpdateListener.onAnimationUpdate(valueAnimator);
                }
                AppMethodBeat.o(164324);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.view.ViewAnimHelper.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(164325);
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
                AppMethodBeat.o(164325);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(164326);
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
                AppMethodBeat.o(164326);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(164327);
                if (animatorListener != null) {
                    animatorListener.onAnimationCancel(animator);
                }
                AppMethodBeat.o(164327);
            }

            public final void onAnimationRepeat(Animator animator) {
                AppMethodBeat.i(164328);
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(animator);
                }
                AppMethodBeat.o(164328);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(240L);
        ofFloat.start();
        AppMethodBeat.o(206184);
    }

    public static void a(final View view, final View view2, ViewInfo viewInfo, final Animator.AnimatorListener animatorListener, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        AppMethodBeat.i(143624);
        ViewInfo q = q(view, null);
        final float max = Math.max((1.0f * ((float) viewInfo.QMg.height())) / ((float) q.QMg.height()), (1.0f * ((float) viewInfo.QMg.width())) / ((float) q.QMg.width()));
        final float scaleX = view.getScaleX();
        final float translationX = view.getTranslationX();
        final float scaleY = view.getScaleY();
        final float translationY = view.getTranslationY();
        final float alpha = view2.getAlpha();
        final float centerX = (float) q.QMg.centerX();
        final float centerY = (float) q.QMg.centerY();
        final float centerX2 = (float) viewInfo.QMg.centerX();
        final float centerY2 = (float) viewInfo.QMg.centerY();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.2f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.view.ViewAnimHelper.AnonymousClass3 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(143612);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.setTranslationX(translationX + ((centerX2 - centerX) * floatValue));
                view.setTranslationY(translationY + ((centerY2 - centerY) * floatValue));
                view.setScaleX(scaleX + (((max * scaleX) - scaleX) * floatValue));
                view.setScaleY(scaleY + (((max * scaleY) - scaleY) * floatValue));
                view2.setAlpha((1.0f - floatValue) * alpha);
                if (animatorUpdateListener != null) {
                    animatorUpdateListener.onAnimationUpdate(valueAnimator);
                }
                AppMethodBeat.o(143612);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.view.ViewAnimHelper.AnonymousClass4 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(143613);
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
                AppMethodBeat.o(143613);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(143614);
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
                AppMethodBeat.o(143614);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(143615);
                if (animatorListener != null) {
                    animatorListener.onAnimationCancel(animator);
                }
                AppMethodBeat.o(143615);
            }

            public final void onAnimationRepeat(Animator animator) {
                AppMethodBeat.i(143616);
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(animator);
                }
                AppMethodBeat.o(143616);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(240L);
        ofFloat.start();
        AppMethodBeat.o(143624);
    }
}
