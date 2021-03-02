package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class AutoPlayViewPager extends ViewPager {
    private static final String TAG = "AutoPlayViewPager";
    private ValueAnimator animator;
    private boolean autoCarousel;
    protected int mLastOffset;
    private ViewPagerControlView pagerControlView;
    protected int scrollTime;
    protected int scrollTimeInterval;

    public AutoPlayViewPager(Context context) {
        this(context, null);
    }

    public AutoPlayViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastOffset = 0;
        this.scrollTime = 1000;
        this.scrollTimeInterval = 4000;
        this.autoCarousel = false;
    }

    public void setScrollTime(int i2) {
        this.scrollTime = i2;
    }

    public void setScrollTimeInterval(int i2) {
        this.scrollTimeInterval = i2;
    }

    public void scrollToNextPage() {
        AppMethodBeat.i(204012);
        if (isFakeDragging()) {
            AppMethodBeat.o(204012);
            return;
        }
        beginFakeDrag();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, getWidth());
        ofInt.setDuration((long) this.scrollTime);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.widget.ad.AutoPlayViewPager.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(204008);
                if (AutoPlayViewPager.this.isFakeDragging()) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    AutoPlayViewPager.this.fakeDragBy((float) (AutoPlayViewPager.this.mLastOffset - intValue));
                    AutoPlayViewPager.this.mLastOffset = intValue;
                }
                AppMethodBeat.o(204008);
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.widget.ad.AutoPlayViewPager.AnonymousClass2 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(204009);
                super.onAnimationEnd(animator);
                if (AutoPlayViewPager.this.isFakeDragging()) {
                    AutoPlayViewPager.this.endFakeDrag();
                    AutoPlayViewPager.this.mLastOffset = 0;
                    AutoPlayViewPager.this.startAutoPlay();
                }
                AppMethodBeat.o(204009);
            }
        });
        ofInt.start();
        AppMethodBeat.o(204012);
    }

    public void bindViewPagerControlView(ViewPagerControlView viewPagerControlView, boolean z) {
        this.pagerControlView = viewPagerControlView;
        this.autoCarousel = z;
    }

    public void startAutoPlay() {
        AppMethodBeat.i(204013);
        if (this.autoCarousel) {
            if (this.animator == null) {
                this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.animator.setDuration((long) this.scrollTimeInterval);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.plugin.sns.ui.widget.ad.AutoPlayViewPager.AnonymousClass3 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(204010);
                        AutoPlayViewPager.this.pagerControlView.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        AutoPlayViewPager.this.pagerControlView.invalidate();
                        AppMethodBeat.o(204010);
                    }
                });
                this.animator.addListener(new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.plugin.sns.ui.widget.ad.AutoPlayViewPager.AnonymousClass4 */

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(204011);
                        super.onAnimationEnd(animator);
                        AutoPlayViewPager.this.scrollToNextPage();
                        AppMethodBeat.o(204011);
                    }
                });
            }
            this.animator.start();
            AppMethodBeat.o(204013);
            return;
        }
        this.pagerControlView.progress = 1.0f;
        this.pagerControlView.invalidate();
        AppMethodBeat.o(204013);
    }

    public void pauseAutoPlay() {
        AppMethodBeat.i(204014);
        if (this.autoCarousel) {
            if (this.animator != null) {
                this.animator.pause();
                AppMethodBeat.o(204014);
                return;
            }
            Log.e(TAG, "animator is null when pauseAutoPlay");
        }
        AppMethodBeat.o(204014);
    }

    @Override // android.support.v4.view.ViewPager
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(204015);
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 2:
                pauseAutoPlay();
                break;
            case 1:
            case 3:
                startAutoPlay();
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(204015);
        return onTouchEvent;
    }
}
