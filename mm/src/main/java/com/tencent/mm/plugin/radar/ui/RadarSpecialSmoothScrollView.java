package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001eB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0006\u0010\u001d\u001a\u00020\u0016R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isLayoutChanged", "", "()Z", "isOverScroll", "mLastMotionY", "", "mRect", "Landroid/graphics/Rect;", "mRootChildView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "mScrollInterpolator", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator;", "mTranslateAnimation", "Landroid/view/animation/TranslateAnimation;", "onFinishInflate", "", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "scaleOverScroll", "", "offset", "startAnimation", "WorkspaceOvershootInterpolator", "plugin-radar_release"})
public class RadarSpecialSmoothScrollView extends ScrollView {
    private RadarSpecialTableLayout BAb;
    private TranslateAnimation BAc;
    private final a BAd = new a();
    private float mLastMotionY;
    private final Rect mRect = new Rect();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarSpecialSmoothScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(138657);
        AppMethodBeat.o(138657);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator;", "Landroid/view/animation/Interpolator;", "()V", "mTension", "", "getInterpolation", "t", "Companion", "plugin-radar_release"})
    static final class a implements Interpolator {
        private static final float BAf = BAf;
        public static final C1622a BAg = new C1622a((byte) 0);
        private final float BAe = BAf;

        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (((f3 * (this.BAe + 1.0f)) + this.BAe) * f3 * f3) + 1.0f;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator$Companion;", "", "()V", "DEFAULT_TENSION", "", "plugin-radar_release"})
        /* renamed from: com.tencent.mm.plugin.radar.ui.RadarSpecialSmoothScrollView$a$a  reason: collision with other inner class name */
        public static final class C1622a {
            private C1622a() {
            }

            public /* synthetic */ C1622a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(138654);
            AppMethodBeat.o(138654);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(138655);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (!(childAt instanceof RadarSpecialTableLayout)) {
                childAt = null;
            }
            this.BAb = (RadarSpecialTableLayout) childAt;
        }
        AppMethodBeat.o(138655);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.i(138656);
        p.h(motionEvent, "ev");
        if (this.BAb == null) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(138656);
            return onTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastMotionY = motionEvent.getY();
                break;
            case 1:
                this.mLastMotionY = 0.0f;
                if (this.mRect.isEmpty()) {
                    z = false;
                }
                if (z) {
                    RadarSpecialTableLayout radarSpecialTableLayout = this.BAb;
                    if (radarSpecialTableLayout == null) {
                        p.hyc();
                    }
                    this.BAc = new TranslateAnimation(0.0f, 0.0f, (float) (radarSpecialTableLayout.getTop() - this.mRect.top), 0.0f);
                    TranslateAnimation translateAnimation = this.BAc;
                    if (translateAnimation == null) {
                        p.hyc();
                    }
                    translateAnimation.setInterpolator(this.BAd);
                    TranslateAnimation translateAnimation2 = this.BAc;
                    if (translateAnimation2 == null) {
                        p.hyc();
                    }
                    RadarSpecialTableLayout radarSpecialTableLayout2 = this.BAb;
                    if (radarSpecialTableLayout2 == null) {
                        p.hyc();
                    }
                    translateAnimation2.setDuration((long) Math.abs(radarSpecialTableLayout2.getTop() - this.mRect.top));
                    RadarSpecialTableLayout radarSpecialTableLayout3 = this.BAb;
                    if (radarSpecialTableLayout3 == null) {
                        p.hyc();
                    }
                    radarSpecialTableLayout3.startAnimation(this.BAc);
                    RadarSpecialTableLayout radarSpecialTableLayout4 = this.BAb;
                    if (radarSpecialTableLayout4 == null) {
                        p.hyc();
                    }
                    radarSpecialTableLayout4.I(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
                    this.mRect.setEmpty();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY();
                if (this.mLastMotionY == 0.0f) {
                    this.mLastMotionY = y;
                }
                RadarSpecialTableLayout radarSpecialTableLayout5 = this.BAb;
                if (radarSpecialTableLayout5 == null) {
                    p.hyc();
                }
                int measuredHeight = radarSpecialTableLayout5.getMeasuredHeight() - getHeight();
                int scrollY = getScrollY();
                if (!(scrollY == 0 || scrollY == measuredHeight)) {
                    z = false;
                }
                if (z) {
                    int i2 = (int) (this.mLastMotionY - y);
                    scrollBy(0, i2);
                    if (this.mRect.isEmpty()) {
                        Rect rect = this.mRect;
                        RadarSpecialTableLayout radarSpecialTableLayout6 = this.BAb;
                        if (radarSpecialTableLayout6 == null) {
                            p.hyc();
                        }
                        int left = radarSpecialTableLayout6.getLeft();
                        RadarSpecialTableLayout radarSpecialTableLayout7 = this.BAb;
                        if (radarSpecialTableLayout7 == null) {
                            p.hyc();
                        }
                        int top = radarSpecialTableLayout7.getTop();
                        RadarSpecialTableLayout radarSpecialTableLayout8 = this.BAb;
                        if (radarSpecialTableLayout8 == null) {
                            p.hyc();
                        }
                        int right = radarSpecialTableLayout8.getRight();
                        RadarSpecialTableLayout radarSpecialTableLayout9 = this.BAb;
                        if (radarSpecialTableLayout9 == null) {
                            p.hyc();
                        }
                        rect.set(left, top, right, radarSpecialTableLayout9.getBottom());
                    }
                    RadarSpecialTableLayout radarSpecialTableLayout10 = this.BAb;
                    if (radarSpecialTableLayout10 == null) {
                        p.hyc();
                    }
                    RadarSpecialTableLayout radarSpecialTableLayout11 = this.BAb;
                    if (radarSpecialTableLayout11 == null) {
                        p.hyc();
                    }
                    int left2 = radarSpecialTableLayout11.getLeft();
                    RadarSpecialTableLayout radarSpecialTableLayout12 = this.BAb;
                    if (radarSpecialTableLayout12 == null) {
                        p.hyc();
                    }
                    int top2 = radarSpecialTableLayout12.getTop() - (i2 / 2);
                    RadarSpecialTableLayout radarSpecialTableLayout13 = this.BAb;
                    if (radarSpecialTableLayout13 == null) {
                        p.hyc();
                    }
                    int right2 = radarSpecialTableLayout13.getRight();
                    RadarSpecialTableLayout radarSpecialTableLayout14 = this.BAb;
                    if (radarSpecialTableLayout14 == null) {
                        p.hyc();
                    }
                    radarSpecialTableLayout10.I(left2, top2, right2, radarSpecialTableLayout14.getBottom() - (i2 / 2));
                } else {
                    scrollBy(0, ((int) (this.mLastMotionY - y)) / 2);
                }
                this.mLastMotionY = y;
                break;
        }
        boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(138656);
        return onTouchEvent2;
    }
}
