package com.tencent.mm.plugin.story.ui.view.gallery;

import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.m.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollConsumer;", "()V", "downX", "", "downY", "lastScrollType", "", "mStoryView", "Landroid/view/View;", "getMStoryView", "()Landroid/view/View;", "setMStoryView", "(Landroid/view/View;)V", "mWrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "getMWrapperView", "()Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "setMWrapperView", "(Lcom/tencent/mm/ui/widget/listview/PullDownListView;)V", "moveUpLimit", "pointerId", "touchConsumed", "", "touchX", "touchY", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isTouchMoved", "scrollType", "getScrollDirection", "releaseVelocityTracker", "", "scaleBackOverScroll", "offset", "plugin-story_release"})
public final class c extends a {
    PullDownListView FEK;
    View FEL;
    private int FEM = at.fromDPToPix(MMApplicationContext.getContext(), 30);
    private boolean FEN;
    private int FEO;
    private float deo;
    private float dep;
    private float gZZ;
    private float haa;
    private VelocityTracker ol;
    private int zxS;

    public c() {
        AppMethodBeat.i(120331);
        AppMethodBeat.o(120331);
    }

    @Override // com.tencent.mm.ui.m.a
    public final boolean a(MotionEvent motionEvent, boolean z, int i2) {
        ViewGroup.LayoutParams layoutParams;
        PullDownListView pullDownListView;
        float f2 = 0.0f;
        AppMethodBeat.i(120330);
        p.h(motionEvent, "event");
        if (this.ol == null) {
            this.ol = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.ol;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.zxS = motionEvent.getPointerId(0);
                this.deo = motionEvent.getRawX();
                this.dep = motionEvent.getRawY();
                this.FEN = false;
                this.FEO = 0;
                break;
            case 1:
            case 3:
                VelocityTracker velocityTracker2 = this.ol;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
                VelocityTracker velocityTracker3 = this.ol;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                }
                this.ol = null;
                if (this.FEO == 1) {
                    PullDownListView pullDownListView2 = this.FEK;
                    if (pullDownListView2 != null) {
                        pullDownListView2.dispatchTouchEvent(motionEvent);
                    }
                } else if (this.FEO == 2) {
                    PullDownListView pullDownListView3 = this.FEK;
                    if (pullDownListView3 != null) {
                        pullDownListView3.hbX();
                    }
                    Object systemService = MMApplicationContext.getContext().getSystemService("vibrator");
                    if (!(systemService instanceof Vibrator)) {
                        systemService = null;
                    }
                    Vibrator vibrator = (Vibrator) systemService;
                    if (vibrator != null) {
                        vibrator.vibrate(10);
                    }
                }
                this.FEO = 0;
                break;
            case 2:
                if (z) {
                    this.FEO = i2;
                    this.gZZ = motionEvent.getRawX();
                    this.haa = motionEvent.getRawY();
                    float f3 = this.haa - this.dep;
                    VelocityTracker velocityTracker4 = this.ol;
                    if (velocityTracker4 != null) {
                        velocityTracker4.computeCurrentVelocity(1000);
                    }
                    VelocityTracker velocityTracker5 = this.ol;
                    float xVelocity = velocityTracker5 != null ? velocityTracker5.getXVelocity(this.zxS) : 0.0f;
                    VelocityTracker velocityTracker6 = this.ol;
                    if (velocityTracker6 != null) {
                        f2 = velocityTracker6.getYVelocity(this.zxS);
                    }
                    if (i2 != 1) {
                        if (i2 == 2) {
                            this.FEN = true;
                            View view = this.FEL;
                            if (view != null) {
                                layoutParams = view.getLayoutParams();
                            } else {
                                layoutParams = null;
                            }
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            if (!(this.FEK == null || marginLayoutParams == null)) {
                                marginLayoutParams.topMargin = (int) (f3 / 15.0f);
                                View view2 = this.FEL;
                                if (view2 != null) {
                                    view2.setLayoutParams(marginLayoutParams);
                                    break;
                                }
                            }
                        }
                    } else {
                        this.FEN = true;
                        if (Math.abs(f3) > ((float) this.FEM) && Math.abs(f2) > Math.abs(xVelocity) && (pullDownListView = this.FEK) != null) {
                            pullDownListView.dispatchTouchEvent(motionEvent);
                            break;
                        }
                    }
                }
                break;
        }
        boolean z2 = this.FEN;
        AppMethodBeat.o(120330);
        return z2;
    }

    @Override // com.tencent.mm.ui.m.a
    public final int fsk() {
        return 3;
    }
}
