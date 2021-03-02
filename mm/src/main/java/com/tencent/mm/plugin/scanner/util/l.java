package com.tencent.mm.plugin.scanner.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.p;

public final class l {
    public static final a CUs = new a((byte) 0);
    private long CUn;
    private long CUo;
    public b CUp;
    private Timer CUq;
    private boolean CUr;
    private View targetView;

    public interface b {
        void eRI();

        void eRJ();

        void eRK();
    }

    static {
        AppMethodBeat.i(194790);
        AppMethodBeat.o(194790);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void c(l lVar) {
        AppMethodBeat.i(194791);
        lVar.um(false);
        AppMethodBeat.o(194791);
    }

    public static final /* synthetic */ void e(l lVar) {
        AppMethodBeat.i(194792);
        lVar.eSa();
        AppMethodBeat.o(194792);
    }

    public final l eV(View view) {
        AppMethodBeat.i(194782);
        p.h(view, "view");
        this.targetView = view;
        AppMethodBeat.o(194782);
        return this;
    }

    public final l eRY() {
        this.CUn = 2000;
        return this;
    }

    public final l eRZ() {
        this.CUo = 150;
        return this;
    }

    public static /* synthetic */ void a(l lVar) {
        AppMethodBeat.i(194784);
        lVar.ul(true);
        AppMethodBeat.o(194784);
    }

    public final void ul(boolean z) {
        AppMethodBeat.i(194783);
        Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo startAnimationTask view: %s, withShowAnimation: %b", this.targetView, Boolean.valueOf(z));
        b bVar = this.CUp;
        if (bVar != null) {
            bVar.eRJ();
        }
        if (z) {
            um(true);
            AppMethodBeat.o(194783);
            return;
        }
        View view = this.targetView;
        if (view != null) {
            view.setVisibility(0);
            view.setAlpha(1.0f);
        }
        eSa();
        AppMethodBeat.o(194783);
    }

    public final void cancel() {
        AppMethodBeat.i(194785);
        eSb();
        eSc();
        AppMethodBeat.o(194785);
    }

    private final void eSa() {
        AppMethodBeat.i(194786);
        Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo startTaskTimer");
        eSb();
        this.CUq = new Timer();
        Timer timer = this.CUq;
        if (timer != null) {
            timer.schedule(new d(this), this.CUn);
        }
        this.CUr = false;
        AppMethodBeat.o(194786);
    }

    public static final class d extends TimerTask {
        final /* synthetic */ l CUt;

        d(l lVar) {
            this.CUt = lVar;
        }

        static final class a implements Runnable {
            final /* synthetic */ d CUu;

            a(d dVar) {
                this.CUu = dVar;
            }

            public final void run() {
                AppMethodBeat.i(194780);
                if (this.CUu.CUt.CUr) {
                    AppMethodBeat.o(194780);
                    return;
                }
                l.c(this.CUu.CUt);
                AppMethodBeat.o(194780);
            }
        }

        public final void run() {
            AppMethodBeat.i(194781);
            h.RTc.aV(new a(this));
            AppMethodBeat.o(194781);
        }
    }

    private final void eSb() {
        AppMethodBeat.i(194787);
        Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo cancelTaskTimer");
        this.CUr = true;
        Timer timer = this.CUq;
        if (timer != null) {
            timer.cancel();
            AppMethodBeat.o(194787);
            return;
        }
        AppMethodBeat.o(194787);
    }

    private final void um(boolean z) {
        float f2 = 1.0f;
        AppMethodBeat.i(194788);
        Log.v("MicroMsg.ScanViewAnimationTask", "alvinluo startShowAnimation show: %b", Boolean.valueOf(z));
        View view = this.targetView;
        if (view != null) {
            view.setVisibility(0);
        }
        b bVar = this.CUp;
        if (bVar != null) {
            bVar.eRI();
        }
        View view2 = this.targetView;
        float f3 = z ? 0.0f : 1.0f;
        if (!z) {
            f2 = 0.0f;
        }
        m.a(view2, f3, f2, 200, new c(this, z));
        AppMethodBeat.o(194788);
    }

    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ l CUt;
        final /* synthetic */ boolean rti;

        c(l lVar, boolean z) {
            this.CUt = lVar;
            this.rti = z;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(194779);
            super.onAnimationEnd(animator);
            Log.d("MicroMsg.ScanViewAnimationTask", "alvinluo onShowAnimationEnd show: %b", Boolean.valueOf(this.rti));
            b unused = this.CUt.CUp;
            if (this.rti) {
                l.e(this.CUt);
                AppMethodBeat.o(194779);
                return;
            }
            b bVar = this.CUt.CUp;
            if (bVar != null) {
                bVar.eRK();
                AppMethodBeat.o(194779);
                return;
            }
            AppMethodBeat.o(194779);
        }
    }

    private final void eSc() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator updateListener;
        AppMethodBeat.i(194789);
        View view = this.targetView;
        if (view == null || (animate = view.animate()) == null || (listener = animate.setListener(null)) == null || (updateListener = listener.setUpdateListener(null)) == null) {
            AppMethodBeat.o(194789);
            return;
        }
        updateListener.cancel();
        AppMethodBeat.o(194789);
    }
}
