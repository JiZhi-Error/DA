package com.tencent.mm.ui.widget.picker.d;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.concurrent.TimeUnit;

public final class b extends GestureDetector.SimpleOnGestureListener {
    private final WheelView QUD;

    public final boolean onContextClick(MotionEvent motionEvent) {
        AppMethodBeat.i(198521);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        a.b("com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        boolean onContextClick = super.onContextClick(motionEvent);
        a.a(onContextClick, this, "com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(198521);
        return onContextClick;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(198520);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        a.b("com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        boolean onDoubleTap = super.onDoubleTap(motionEvent);
        a.a(onDoubleTap, this, "com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(198520);
        return onDoubleTap;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(198519);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        a.b("com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        super.onLongPress(motionEvent);
        a.a(this, "com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(198519);
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(198518);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        a.b("com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
        a.a(onSingleTapUp, this, "com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(198518);
        return onSingleTapUp;
    }

    public b(WheelView wheelView) {
        this.QUD = wheelView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(198517);
        WheelView wheelView = this.QUD;
        wheelView.bkU();
        wheelView.QTQ = wheelView.jKb.scheduleWithFixedDelay(new com.tencent.mm.ui.widget.picker.e.a(wheelView, f3), 0, 5, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(198517);
        return true;
    }
}
