package com.tencent.tencentmap.mapsdk.vector.compat.utils.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;

public abstract class OverlayAnimator {

    /* renamed from: a  reason: collision with root package name */
    private Object f2855a;

    /* renamed from: b  reason: collision with root package name */
    private long f2856b;

    /* renamed from: c  reason: collision with root package name */
    private AnimatorSet f2857c = new AnimatorSet();

    /* access modifiers changed from: protected */
    public abstract ValueAnimator createSegmentAnimator(int i2);

    protected OverlayAnimator(Object obj, long j2) {
        this.f2855a = obj;
        this.f2856b = j2;
    }

    public long getDuration() {
        return this.f2856b;
    }

    public void setDuration(long j2) {
        this.f2856b = j2;
    }

    public Object getObject() {
        return this.f2855a;
    }

    public void setObject(Object obj) {
        this.f2855a = obj;
    }

    /* access modifiers changed from: protected */
    public AnimatorSet getAnimatorSet() {
        return this.f2857c;
    }

    /* access modifiers changed from: protected */
    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.f2857c = animatorSet;
    }

    public void startAnimation() {
        synchronized (this) {
            if (!this.f2857c.isRunning()) {
                this.f2857c.start();
            }
        }
    }

    public void cancelAnimation() {
        synchronized (this) {
            this.f2857c.cancel();
        }
    }

    public void endAnimation() {
        synchronized (this) {
            this.f2857c.end();
        }
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f2857c.addListener(animatorListener);
    }
}
