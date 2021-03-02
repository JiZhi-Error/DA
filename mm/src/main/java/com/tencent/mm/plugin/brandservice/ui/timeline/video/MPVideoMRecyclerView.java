package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J.\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/MRecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "animationContainerContainer", "Landroid/view/View;", "canScroll", "", "downY", "", "hasDown", "maxVideoHeight", "", "minVideoHeight", "moveY", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoViewContainer", "Landroid/widget/FrameLayout;", "deltaY", "inScrollRange", "curHeight", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setParam", "", "animationView", "maxHeight", "minHeight", "setVideoHeight", "videoHeight", "plugin-brandservice_release"})
public final class MPVideoMRecyclerView extends MRecyclerView {
    private final String TAG = "MicroMsg.MPVideoMRecyclerView";
    private int bEm;
    private boolean canScroll = true;
    private float dep;
    private float liE;
    private int pJf;
    private FrameLayout pJg;
    private View pJh;
    private boolean pJi;

    public MPVideoMRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(7266);
        FrameLayout frameLayout = this.pJg;
        if (frameLayout == null) {
            p.btv("videoViewContainer");
        }
        int height = frameLayout.getHeight();
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.dep = motionEvent.getRawY();
            this.pJi = true;
        } else if (valueOf != null && valueOf.intValue() == 2) {
            if (!this.pJi) {
                this.dep = motionEvent.getRawY();
                this.pJi = true;
            }
            this.liE = motionEvent.getRawY();
            float f2 = (this.liE - this.dep) * 1.2f;
            int i2 = (int) (((float) height) + f2);
            if (f2 == 0.0f) {
                z = false;
            } else {
                if (f2 > 0.0f) {
                    FrameLayout frameLayout2 = this.pJg;
                    if (frameLayout2 == null) {
                        p.btv("videoViewContainer");
                    }
                    if (frameLayout2.getHeight() >= this.bEm) {
                        z = false;
                    }
                }
                if (f2 < 0.0f) {
                    FrameLayout frameLayout3 = this.pJg;
                    if (frameLayout3 == null) {
                        p.btv("videoViewContainer");
                    }
                    if (frameLayout3.getHeight() <= this.pJf) {
                        z = false;
                    }
                }
                if (f2 <= 0.0f || !canScrollVertically(-1)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            this.canScroll = z;
            if (this.canScroll) {
                int i3 = this.pJf;
                int i4 = this.bEm;
                if (i3 > i2 || i4 < i2) {
                    z2 = false;
                }
                if (z2) {
                    setVideoHeight(i2);
                } else if (i2 <= this.pJf) {
                    setVideoHeight(this.pJf);
                } else if (i2 >= this.bEm) {
                    setVideoHeight(this.bEm);
                }
            }
            this.dep = this.liE;
        } else if (valueOf != null && valueOf.intValue() == 1) {
            this.pJi = false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(7266);
        return onTouchEvent;
    }

    private final void setVideoHeight(int i2) {
        AppMethodBeat.i(7267);
        FrameLayout frameLayout = this.pJg;
        if (frameLayout == null) {
            p.btv("videoViewContainer");
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            AppMethodBeat.o(7267);
            throw tVar;
        }
        layoutParams.height = i2;
        FrameLayout frameLayout2 = this.pJg;
        if (frameLayout2 == null) {
            p.btv("videoViewContainer");
        }
        frameLayout2.setLayoutParams(layoutParams);
        View view = this.pJh;
        if (view == null) {
            p.btv("animationContainerContainer");
        }
        if (view.getVisibility() == 0) {
            View view2 = this.pJh;
            if (view2 == null) {
                p.btv("animationContainerContainer");
            }
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            if (layoutParams2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                AppMethodBeat.o(7267);
                throw tVar2;
            }
            layoutParams2.height = i2;
            View view3 = this.pJh;
            if (view3 == null) {
                p.btv("animationContainerContainer");
            }
            view3.setLayoutParams(layoutParams2);
        }
        AppMethodBeat.o(7267);
    }
}
