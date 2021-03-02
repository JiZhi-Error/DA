package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\"H\u0016J\u0012\u0010%\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010&\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010\"H\u0016J,\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010\"2\b\u0010)\u001a\u0004\u0018\u00010\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0016J\u0012\u0010-\u001a\u00020.2\b\u0010$\u001a\u0004\u0018\u00010\"H\u0016J,\u0010/\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010\"2\b\u0010)\u001a\u0004\u0018\u00010\"2\u0006\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020+H\u0016J\u0012\u00102\u001a\u00020.2\b\u0010$\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u00103\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u00104\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010\"H\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderLongVideoMediaBanner;", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDoubleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "getOnDoubleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "setOnDoubleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;)V", "onSingleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "getOnSingleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "setOnSingleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;)V", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onDoubleTap", "e", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", e.a.NAME, "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "plugin-finder_release"})
public final class FinderLongVideoMediaBanner extends FinderMediaBanner implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    private HardTouchableLayout.g Rjg;
    private HardTouchableLayout.b Rjh;
    private final f wbH = g.ah(new a(this));

    private final GestureDetector getTouchDetector() {
        AppMethodBeat.i(261541);
        GestureDetector gestureDetector = (GestureDetector) this.wbH.getValue();
        AppMethodBeat.o(261541);
        return gestureDetector;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLongVideoMediaBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(261547);
        AppMethodBeat.o(261547);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLongVideoMediaBanner(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(261548);
        AppMethodBeat.o(261548);
    }

    public final HardTouchableLayout.g getOnSingleClickListener() {
        return this.Rjg;
    }

    public final void setOnSingleClickListener(HardTouchableLayout.g gVar) {
        this.Rjg = gVar;
    }

    public final HardTouchableLayout.b getOnDoubleClickListener() {
        return this.Rjh;
    }

    public final void setOnDoubleClickListener(HardTouchableLayout.b bVar) {
        this.Rjh = bVar;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(261542);
        super.dispatchTouchEvent(motionEvent);
        GestureDetector touchDetector = getTouchDetector();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(touchDetector, bl.axQ(), "com/tencent/mm/plugin/finder/view/FinderLongVideoMediaBanner", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(touchDetector, touchDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/finder/view/FinderLongVideoMediaBanner", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(261542);
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(261543);
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderLongVideoMediaBanner", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/view/FinderLongVideoMediaBanner", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(261543);
        return true;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(261544);
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderLongVideoMediaBanner", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderLongVideoMediaBanner", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(261544);
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(261545);
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderLongVideoMediaBanner", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        p.h(motionEvent, "e");
        HardTouchableLayout.b bVar2 = this.Rjh;
        if (bVar2 != null) {
            bVar2.a(this, motionEvent);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/view/FinderLongVideoMediaBanner", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(261545);
        return true;
    }

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AppMethodBeat.i(261546);
        HardTouchableLayout.g gVar = this.Rjg;
        if (gVar != null) {
            gVar.b(this, motionEvent);
        }
        AppMethodBeat.o(261546);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<GestureDetector> {
        final /* synthetic */ FinderLongVideoMediaBanner UVx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderLongVideoMediaBanner finderLongVideoMediaBanner) {
            super(0);
            this.UVx = finderLongVideoMediaBanner;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ GestureDetector invoke() {
            AppMethodBeat.i(261540);
            GestureDetector gestureDetector = new GestureDetector(this.UVx.getContext(), this.UVx);
            AppMethodBeat.o(261540);
            return gestureDetector;
        }
    }
}
