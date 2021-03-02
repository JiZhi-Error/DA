package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.widget.base.a;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Locale;

final class ag<Input extends EditText & ab> {
    final String TAG;
    final Input ova;
    final float ovb;
    e.f ovc;
    MotionEvent ovd;
    boolean ove = false;
    final Runnable ovf = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.ag.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(136575);
            ag.this.ove = true;
            Log.v(ag.this.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
            ag.this.ova.postDelayed(ag.this.ovg, (long) ViewConfiguration.getLongPressTimeout());
            AppMethodBeat.o(136575);
        }
    };
    final Runnable ovg = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.ag.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(136576);
            if (!ag.this.ove) {
                AppMethodBeat.o(136576);
                return;
            }
            e.f cv = e.cv((Input) ag.this.ova);
            if (ag.this.ovc == null || Math.abs(ag.this.ovc.x - cv.x) > 1.0f || Math.abs(ag.this.ovc.y - cv.y) > 1.0f) {
                Log.v(ag.this.TAG, "check long press timeout, but view has moved.");
                AppMethodBeat.o(136576);
            } else if (ag.this.ovd == null) {
                AppMethodBeat.o(136576);
            } else {
                ag.this.ove = false;
                ag.this.ova.removeCallbacks(ag.this.ovf);
                AppMethodBeat.o(136576);
            }
        }
    };

    ag(Input input) {
        AppMethodBeat.i(136577);
        this.ova = input;
        this.TAG = "MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", input.toString());
        this.ovb = (float) ViewConfiguration.get(input.getContext()).getScaledTouchSlop();
        AppMethodBeat.o(136577);
    }

    /* access modifiers changed from: package-private */
    public final void cbX() {
        AppMethodBeat.i(136578);
        this.ove = false;
        this.ova.removeCallbacks(this.ovf);
        this.ova.removeCallbacks(this.ovg);
        this.ovc = null;
        if (this.ovd != null) {
            this.ovd.recycle();
            this.ovd = null;
        }
        AppMethodBeat.o(136578);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        AppMethodBeat.i(136579);
        float x = motionEvent.getX(motionEvent.getActionIndex());
        float y = motionEvent.getY(motionEvent.getActionIndex());
        float x2 = motionEvent2.getX(motionEvent2.getActionIndex());
        float y2 = motionEvent2.getY(motionEvent2.getActionIndex());
        Log.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", Float.valueOf(this.ovb), Float.valueOf(x), Float.valueOf(x2), Float.valueOf(y), Float.valueOf(y2), a.K(motionEvent), a.K(motionEvent2));
        if (Math.abs(y2 - y) > this.ovb || Math.abs(x2 - x) > this.ovb) {
            AppMethodBeat.o(136579);
            return false;
        }
        AppMethodBeat.o(136579);
        return true;
    }
}
