package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.view.c;

/* access modifiers changed from: package-private */
@TargetApi(20)
public final class h {
    VirtualDisplay STJ;
    SingleViewPresentation STK;
    final a accessibilityEventsDelegate;
    final Context context;
    final int densityDpi;
    final View.OnFocusChangeListener focusChangeListener;
    final c.a hgp;
    Surface surface;

    h(Context context2, a aVar, VirtualDisplay virtualDisplay, d dVar, Surface surface2, c.a aVar2, View.OnFocusChangeListener onFocusChangeListener, int i2, Object obj) {
        AppMethodBeat.i(9915);
        this.context = context2;
        this.accessibilityEventsDelegate = aVar;
        this.hgp = aVar2;
        this.focusChangeListener = onFocusChangeListener;
        this.surface = surface2;
        this.STJ = virtualDisplay;
        this.densityDpi = context2.getResources().getDisplayMetrics().densityDpi;
        this.STK = new SingleViewPresentation(context2, this.STJ.getDisplay(), dVar, aVar, i2, obj, onFocusChangeListener);
        this.STK.show();
        AppMethodBeat.o(9915);
    }

    public final void dispose() {
        AppMethodBeat.i(9916);
        this.STK.getView();
        this.STK.cancel();
        this.STK.detachState();
        this.STJ.release();
        this.hgp.release();
        AppMethodBeat.o(9916);
    }

    /* access modifiers changed from: package-private */
    public final void hxu() {
        AppMethodBeat.i(214886);
        if (this.STK == null || this.STK.getView() == null) {
            AppMethodBeat.o(214886);
            return;
        }
        this.STK.getView();
        AppMethodBeat.o(214886);
    }

    public final View getView() {
        AppMethodBeat.i(9917);
        if (this.STK == null) {
            AppMethodBeat.o(9917);
            return null;
        }
        View view = this.STK.getView().getView();
        AppMethodBeat.o(9917);
        return view;
    }

    @TargetApi(16)
    static class a implements ViewTreeObserver.OnDrawListener {
        Runnable STP;
        final View mView;

        static void h(View view, Runnable runnable) {
            AppMethodBeat.i(9890);
            view.getViewTreeObserver().addOnDrawListener(new a(view, runnable));
            AppMethodBeat.o(9890);
        }

        private a(View view, Runnable runnable) {
            this.mView = view;
            this.STP = runnable;
        }

        public final void onDraw() {
            AppMethodBeat.i(9891);
            if (this.STP == null) {
                AppMethodBeat.o(9891);
                return;
            }
            this.STP.run();
            this.STP = null;
            this.mView.post(new Runnable() {
                /* class io.flutter.plugin.platform.h.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(9887);
                    a.this.mView.getViewTreeObserver().removeOnDrawListener(a.this);
                    AppMethodBeat.o(9887);
                }
            });
            AppMethodBeat.o(9891);
        }
    }
}
