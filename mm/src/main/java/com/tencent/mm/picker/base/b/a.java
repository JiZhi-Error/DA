package com.tencent.mm.picker.base.b;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.picker.base.c.c;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;

public final class a extends GestureDetector.SimpleOnGestureListener {
    private final WheelView jKa;

    public final boolean onContextClick(MotionEvent motionEvent) {
        AppMethodBeat.i(204553);
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/picker/base/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        boolean onContextClick = super.onContextClick(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/picker/base/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(204553);
        return onContextClick;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(204552);
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/picker/base/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        boolean onDoubleTap = super.onDoubleTap(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/picker/base/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(204552);
        return onDoubleTap;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(204551);
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/picker/base/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        super.onLongPress(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/picker/base/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(204551);
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(204550);
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/picker/base/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/picker/base/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(204550);
        return onSingleTapUp;
    }

    public a(WheelView wheelView) {
        this.jKa = wheelView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(175295);
        WheelView wheelView = this.jKa;
        wheelView.bkU();
        wheelView.jKp = wheelView.jKo.h(new c(wheelView, f3), 5);
        AppMethodBeat.o(175295);
        return true;
    }
}
