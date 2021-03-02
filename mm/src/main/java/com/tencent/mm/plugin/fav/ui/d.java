package com.tencent.mm.plugin.fav.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;

public final class d {
    MMActivity activity;
    View gvQ = this.activity.findViewById(R.id.h8y);
    ImageView jUG = ((ImageView) this.activity.findViewById(R.id.dcj));
    MMGestureGallery jUy;
    float scaleX;
    float scaleY;
    a tdH;
    int tdI;
    int tdJ;
    private ValueAnimator tdK;
    int thumbHeight;
    int thumbWidth;
    float translationX;
    float translationY;

    public interface a {
        MultiTouchImageView cVG();

        String cVH();
    }

    public d(MMGestureGallery mMGestureGallery, MMActivity mMActivity, a aVar) {
        AppMethodBeat.i(106668);
        this.jUy = mMGestureGallery;
        this.activity = mMActivity;
        this.tdH = aVar;
        this.jUy.setGalleryScaleListener(new MMGestureGallery.b() {
            /* class com.tencent.mm.plugin.fav.ui.d.AnonymousClass1 */

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.b
            public final void S(float f2, float f3) {
                float f4;
                float f5 = 1.0f;
                AppMethodBeat.i(106664);
                if (d.this.jUy == null || d.this.tdH == null) {
                    AppMethodBeat.o(106664);
                    return;
                }
                if (d.this.jUy.getHeight() != 0) {
                    f4 = 1.0f - (f3 / ((float) d.this.jUy.getHeight()));
                } else {
                    f4 = 1.0f;
                }
                if (f4 <= 1.0f) {
                    f5 = f4;
                }
                Log.d("MicroMsg.FavDragLogic", "onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f5));
                MultiTouchImageView cVG = d.this.tdH.cVG();
                if (cVG != null) {
                    cVG.setPivotX((float) (d.this.jUy.getWidth() / 2));
                    cVG.setPivotY((float) (d.this.jUy.getHeight() / 2));
                    cVG.setScaleX(f5);
                    cVG.setScaleY(f5);
                    cVG.setTranslationX(f2);
                    cVG.setTranslationY(f3);
                    d.this.gvQ.setAlpha(f5);
                    AppMethodBeat.o(106664);
                    return;
                }
                Log.d("MicroMsg.FavDragLogic", "runDragAnimation contentView is null !!");
                AppMethodBeat.o(106664);
            }

            @Override // com.tencent.mm.ui.tools.MMGestureGallery.b
            public final void T(float f2, float f3) {
            }
        });
        this.tdK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.tdK.setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2f));
        this.tdK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.fav.ui.d.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(106665);
                if (d.this.jUy == null) {
                    AppMethodBeat.o(106665);
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.jUy.getLayoutParams();
                layoutParams.leftMargin = (int) (((float) d.this.tdI) * floatValue);
                layoutParams.topMargin = (int) (((float) d.this.tdJ) * floatValue);
                layoutParams.rightMargin = (int) (((((float) d.this.gvQ.getWidth()) * floatValue) - (((float) d.this.thumbWidth) * floatValue)) - ((float) layoutParams.leftMargin));
                layoutParams.bottomMargin = (int) (((((float) d.this.gvQ.getHeight()) * floatValue) - (((float) d.this.thumbHeight) * floatValue)) - ((float) layoutParams.topMargin));
                d.this.jUy.setLayoutParams(layoutParams);
                Log.d("MicroMsg.FavDragLogic", "onAnimationUpdate leftMargin:%s, topMargin:%s, rightMargin:%s, bottomMargin:%s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin), Integer.valueOf(layoutParams.bottomMargin));
                if (!(d.this.tdH == null || d.this.tdH.cVG() == null)) {
                    MultiTouchImageView cVG = d.this.tdH.cVG();
                    cVG.setTranslationX(d.this.translationX * (1.0f - floatValue));
                    cVG.setTranslationY(d.this.translationY * (1.0f - floatValue));
                    cVG.setScaleX(((1.0f - floatValue) * d.this.scaleX) + floatValue);
                    cVG.setScaleY(((1.0f - floatValue) * d.this.scaleY) + floatValue);
                    d.this.jUG.setAlpha(1.0f - floatValue);
                    Log.d("MicroMsg.FavDragLogic", "onAnimationUpdate value:%s TranslationX:%s, TranslationY:%s, ScaleX:%s, ScaleY:%s", Float.valueOf(floatValue), Float.valueOf(d.this.translationX * (1.0f - floatValue)), Float.valueOf(d.this.translationY * (1.0f - floatValue)), Float.valueOf(((1.0f - floatValue) * d.this.scaleX) + floatValue), Float.valueOf(floatValue + ((1.0f - floatValue) * d.this.scaleY)));
                }
                AppMethodBeat.o(106665);
            }
        });
        this.tdK.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.fav.ui.d.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(106666);
                super.onAnimationStart(animator);
                if (d.this.tdH == null) {
                    AppMethodBeat.o(106666);
                    return;
                }
                MultiTouchImageView cVG = d.this.tdH.cVG();
                if (cVG != null) {
                    if (cVG.getScale() > 1.0f) {
                        cVG.gKy();
                    }
                    d.this.translationX = cVG.getTranslationX();
                    d.this.translationY = cVG.getTranslationY();
                    d.this.scaleX = cVG.getScaleX();
                    d.this.scaleY = cVG.getScaleY();
                    Log.d("MicroMsg.FavDragLogic", "onAnimationStart() scale:%s translationX:%s translationY:%s scaleX:%s scaleY:%s", Float.valueOf(cVG.getScale()), Float.valueOf(d.this.translationX), Float.valueOf(d.this.translationY), Float.valueOf(d.this.scaleX), Float.valueOf(d.this.scaleY));
                }
                AppMethodBeat.o(106666);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(106667);
                super.onAnimationEnd(animator);
                if (d.this.activity == null) {
                    AppMethodBeat.o(106667);
                    return;
                }
                d.this.activity.finish();
                d.this.activity.overridePendingTransition(R.anim.s, R.anim.s);
                AppMethodBeat.o(106667);
            }
        });
        AppMethodBeat.o(106668);
    }

    public final void mD(boolean z) {
        AppMethodBeat.i(106669);
        if (this.jUy == null) {
            Log.i("MicroMsg.FavDragLogic", "goBack() gallery == null");
            AppMethodBeat.o(106669);
            return;
        }
        this.thumbWidth = 0;
        this.thumbHeight = 0;
        this.tdI = this.jUy.getWidth() / 2;
        this.tdJ = this.jUy.getHeight() / 2;
        if (!z && this.tdH != null) {
            ha haVar = new ha();
            haVar.dLj.dLl = this.tdH.cVH();
            EventCenter.instance.publish(haVar);
            this.thumbWidth = haVar.dLk.dEs;
            this.thumbHeight = haVar.dLk.dEt;
            this.tdI = haVar.dLk.dEq;
            this.tdJ = haVar.dLk.dEr;
        }
        if (this.tdI == 0 && this.tdJ == 0) {
            this.tdI = this.jUy.getWidth() / 2;
            this.tdJ = this.jUy.getHeight() / 2;
        }
        Log.i("MicroMsg.FavDragLogic", "thumbLeft %d, thumbTop %d, thumbWidth %d, thumbHeight %d", Integer.valueOf(this.tdI), Integer.valueOf(this.tdJ), Integer.valueOf(this.thumbWidth), Integer.valueOf(this.thumbHeight));
        this.tdK.start();
        AppMethodBeat.o(106669);
    }

    public final void onDestroy() {
        this.jUy = null;
        this.activity = null;
        this.tdH = null;
    }
}
