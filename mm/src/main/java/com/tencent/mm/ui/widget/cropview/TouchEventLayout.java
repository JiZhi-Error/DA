package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\rH\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\rH\u0016J\u0012\u0010*\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010.\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J(\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0016J\u0012\u00105\u001a\u0002062\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u001dH\u0016J\u0010\u00109\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u001dH\u0016J\u0010\u0010:\u001a\u0002062\u0006\u00108\u001a\u00020\u001dH\u0016J(\u0010;\u001a\u00020\u00102\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,2\u0006\u0010<\u001a\u0002032\u0006\u0010=\u001a\u000203H\u0016J\u0010\u0010>\u001a\u0002062\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010?\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010@\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020,H\u0016J\u0010\u0010E\u001a\u0002062\u0006\u00100\u001a\u00020,H\u0016R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020#8DX\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%¨\u0006F"}, hxF = {"Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableFling", "", "()Z", "setEnableFling", "(Z)V", "isEnableOverScroll", "setEnableOverScroll", "isEnableScale", "setEnableScale", "isEnableScroll", "setEnableScroll", "isEnableTouch", "setEnableTouch", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "getScaleDetector", "()Landroid/view/ScaleGestureDetector;", "scaleDetector$delegate", "Lkotlin/Lazy;", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "canScrollHorizontally", TencentLocation.EXTRA_DIRECTION, "canScrollVertically", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", e.a.NAME, "", "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onTouch", "v", "Landroid/view/View;", "event", e.b.NAME, "libmmui_release"})
public class TouchEventLayout extends FrameLayout implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {
    protected boolean AwT = true;
    private boolean QNi = true;
    boolean QNj = true;
    boolean QNk = true;
    boolean QNl = true;
    private final f QNm = g.ah(new a(this));
    private final f wbH = g.ah(new b(this));

    private final ScaleGestureDetector getScaleDetector() {
        AppMethodBeat.i(164470);
        ScaleGestureDetector scaleGestureDetector = (ScaleGestureDetector) this.QNm.getValue();
        AppMethodBeat.o(164470);
        return scaleGestureDetector;
    }

    /* access modifiers changed from: protected */
    public final GestureDetector getTouchDetector() {
        AppMethodBeat.i(164471);
        GestureDetector gestureDetector = (GestureDetector) this.wbH.getValue();
        AppMethodBeat.o(164471);
        return gestureDetector;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchEventLayout(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(164481);
        AppMethodBeat.o(164481);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchEventLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164482);
        AppMethodBeat.o(164482);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchEventLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164483);
        AppMethodBeat.o(164483);
    }

    public void setEnableTouch(boolean z) {
        this.AwT = z;
    }

    public void setEnableScale(boolean z) {
        this.QNi = z;
    }

    public void setEnableFling(boolean z) {
        this.QNj = z;
    }

    public void setEnableOverScroll(boolean z) {
        this.QNk = z;
    }

    public void setEnableScroll(boolean z) {
        this.QNl = z;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(164475);
        p.h(scaleGestureDetector, "detector");
        AppMethodBeat.o(164475);
    }

    public void onShowPress(MotionEvent motionEvent) {
        AppMethodBeat.i(164477);
        p.h(motionEvent, "e");
        AppMethodBeat.o(164477);
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(164478);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        p.h(motionEvent, "e");
        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164478);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(204909);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(204909);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(164479);
        p.h(motionEvent, "e1");
        p.h(motionEvent2, "e2");
        AppMethodBeat.o(164479);
        return true;
    }

    public void ad(MotionEvent motionEvent) {
        AppMethodBeat.i(164480);
        p.h(motionEvent, "e1");
        AppMethodBeat.o(164480);
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(204910);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(204910);
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    public boolean canScrollVertically(int i2) {
        return true;
    }

    public boolean canScrollHorizontally(int i2) {
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(164472);
        p.h(view, "v");
        p.h(motionEvent, "event");
        if (!this.AwT) {
            AppMethodBeat.o(164472);
            return false;
        }
        if (this.QNi) {
            getScaleDetector().onTouchEvent(motionEvent);
        }
        GestureDetector touchDetector = getTouchDetector();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(touchDetector, bl.axQ(), "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(touchDetector, touchDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/widget/cropview/TouchEventLayout", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            ad(motionEvent);
        }
        AppMethodBeat.o(164472);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/ScaleGestureDetector;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<ScaleGestureDetector> {
        final /* synthetic */ TouchEventLayout QNn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(TouchEventLayout touchEventLayout) {
            super(0);
            this.QNn = touchEventLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ScaleGestureDetector invoke() {
            AppMethodBeat.i(164467);
            ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(this.QNn.getContext(), this.QNn);
            AppMethodBeat.o(164467);
            return scaleGestureDetector;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<GestureDetector> {
        final /* synthetic */ TouchEventLayout QNn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(TouchEventLayout touchEventLayout) {
            super(0);
            this.QNn = touchEventLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ GestureDetector invoke() {
            AppMethodBeat.i(164468);
            GestureDetector gestureDetector = new GestureDetector(this.QNn.getContext(), this.QNn);
            AppMethodBeat.o(164468);
            return gestureDetector;
        }
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(164473);
        p.h(scaleGestureDetector, "detector");
        boolean z = this.QNi;
        AppMethodBeat.o(164473);
        return z;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(164474);
        p.h(scaleGestureDetector, "detector");
        boolean z = this.QNi;
        AppMethodBeat.o(164474);
        return z;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(164476);
        p.h(motionEvent, "e1");
        p.h(motionEvent2, "e2");
        boolean z = this.QNj;
        AppMethodBeat.o(164476);
        return z;
    }
}
