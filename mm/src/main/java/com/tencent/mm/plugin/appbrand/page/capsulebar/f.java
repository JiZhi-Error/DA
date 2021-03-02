package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

public abstract class f implements i {
    /* access modifiers changed from: protected */
    public abstract void E(CharSequence charSequence);

    /* access modifiers changed from: protected */
    public abstract void P(Runnable runnable);

    /* access modifiers changed from: protected */
    public abstract Context getContext();

    /* access modifiers changed from: protected */
    public abstract void y(Drawable drawable);

    /* access modifiers changed from: protected */
    public abstract void yS(int i2);

    public static Animator cF(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f, 1.0f);
        ofFloat.setDuration(2000L);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        return ofFloat;
    }
}
