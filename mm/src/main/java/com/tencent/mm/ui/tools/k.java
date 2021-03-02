package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class k implements GestureDetector.OnGestureListener {
    private final int Pt;
    private final int Pu;
    private final float QuA;
    public a Quy;
    private final float Quz;
    public final GestureDetector aYg = new GestureDetector(this.context, this);
    private final Context context;

    public interface a {
    }

    public k(Context context2) {
        AppMethodBeat.i(143111);
        this.context = context2;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        this.Pt = viewConfiguration.getScaledMinimumFlingVelocity();
        this.Pu = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Quz = (float) BackwardSupportUtil.BitmapFactory.fromDPToPix(context2, 70.0f);
        this.QuA = (float) BackwardSupportUtil.BitmapFactory.fromDPToPix(context2, 50.0f);
        AppMethodBeat.o(143111);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(143112);
        if (this.Quy == null) {
            AppMethodBeat.o(143112);
            return true;
        }
        Log.v("MicroMsg.MMGestureDetector", "lastX:%f, curX:%f, lastY:%f, curY:%f, vX:%f, vY:%f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent2.getX()), Float.valueOf(motionEvent.getY()), Float.valueOf(motionEvent2.getY()), Float.valueOf(f2), Float.valueOf(f3));
        float abs = Math.abs(motionEvent2.getY() - motionEvent.getY());
        float abs2 = Math.abs(motionEvent2.getX() - motionEvent.getX());
        if (abs < this.QuA && f2 > 800.0f && abs2 > this.Quz) {
            AppMethodBeat.o(143112);
            return true;
        } else if (abs < this.QuA && f2 < -800.0f && abs2 < (-this.Quz)) {
            AppMethodBeat.o(143112);
            return true;
        } else if (abs2 < this.QuA && f3 > 800.0f) {
            AppMethodBeat.o(143112);
            return true;
        } else if (abs2 >= this.QuA || f3 >= -800.0f) {
            AppMethodBeat.o(143112);
            return false;
        } else {
            AppMethodBeat.o(143112);
            return true;
        }
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(205368);
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/MMGestureDetector", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/tools/MMGestureDetector", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205368);
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(205369);
        b bVar = new b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/MMGestureDetector", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/MMGestureDetector", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(205369);
    }
}
