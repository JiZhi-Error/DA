package com.tencent.mm.plugin.expt.hellhound.a.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public final class e {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile e sJt;
    public WeakReference<Activity> mActivityRef;
    private int mScrollState = 0;
    public final f sCN = new f() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.g.e.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void k(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(169374);
            e.a(e.this, viewGroup, e.Hs(i2));
            AppMethodBeat.o(169374);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void a(ViewGroup viewGroup, int i2, int i3, int i4) {
            AppMethodBeat.i(169375);
            if (e.this.mActivityRef == null) {
                AppMethodBeat.o(169375);
                return;
            }
            Activity activity = (Activity) e.this.mActivityRef.get();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                Log.printInfoStack("HABBYGE-MALI.SnsMonitor", "SnsMonitor onScroll is NULL or finishing", new Object[0]);
                AppMethodBeat.o(169375);
                return;
            }
            e.a(e.this, activity, viewGroup, i2, i3);
            AppMethodBeat.o(169375);
        }
    };
    public a sDg = new a(0, "16242", "1000");
    public c sJs = new c();
    public final b sJu = new b() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.g.e.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.expt.hellhound.a.g.b
        public final void smoothScrollToPosition(int i2) {
            AppMethodBeat.i(184395);
            Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, smoothScrollToPosition: %d", Integer.valueOf(i2));
            if (e.this.sDg != null) {
                e.this.sDg.sBr = i2;
            }
            AppMethodBeat.o(184395);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.g.b
        public final void Hr(int i2) {
            AppMethodBeat.i(184396);
            Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, smoothScrollToPositionFromTop: %d", Integer.valueOf(i2));
            if (e.this.sDg != null) {
                e.this.sDg.sBr = i2;
            }
            AppMethodBeat.o(184396);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.g.b
        public final void cQS() {
            AppMethodBeat.i(184397);
            Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, scrollToTop...");
            if (e.this.sDg != null) {
                e.this.sDg.sBr = 0;
            }
            AppMethodBeat.o(184397);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.g.b
        public final void cQT() {
            AppMethodBeat.i(184398);
            if (e.this.sDg != null) {
                e.this.sDg.mc(false);
            }
            AppMethodBeat.o(184398);
        }
    };
    private Field sJv;
    private int sJw = 0;
    private int sJx = 0;

    public static e cQV() {
        AppMethodBeat.i(169376);
        if (sJt == null) {
            synchronized (e.class) {
                try {
                    if (sJt == null) {
                        sJt = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(169376);
                    throw th;
                }
            }
        }
        e eVar = sJt;
        AppMethodBeat.o(169376);
        return eVar;
    }

    @SuppressLint({"NewApi"})
    private e() {
        AppMethodBeat.i(169377);
        try {
            this.sJv = AbsListView.class.getDeclaredField("mMotionY");
            this.sJv.setAccessible(true);
            AppMethodBeat.o(169377);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.SnsMonitor", e2, "SnsMonitor, crash: %s", e2.getMessage());
            AppMethodBeat.o(169377);
        }
    }

    private void p(ViewGroup viewGroup) {
        AppMethodBeat.i(169379);
        try {
            this.sJx = ((Integer) this.sJv.get(viewGroup)).intValue() - this.sJw;
            AppMethodBeat.o(169379);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.SnsMonitor", e2, "SnsMonitor, beginFlingState, crash: %s", e2.getMessage());
            AppMethodBeat.o(169379);
        }
    }

    private static boolean cQW() {
        AppMethodBeat.i(169380);
        if (!com.tencent.mm.plugin.expt.hellhound.a.cNo() || !com.tencent.mm.plugin.expt.hellhound.a.cNs()) {
            AppMethodBeat.o(169380);
            return true;
        }
        AppMethodBeat.o(169380);
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(int i2, String str, Activity activity) {
        AppMethodBeat.i(169378);
        if (!"com.tencent.mm.plugin.sns.ui.SnsTimeLineUI".equals(str)) {
            AppMethodBeat.o(169378);
        } else if (cQW()) {
            Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, monitor, dontNeedMonitorTimeline true !!");
            AppMethodBeat.o(169378);
        } else {
            Log.i("HABBYGE-MALI.SnsMonitor", "SnsMonitor, monitor: %d, %s", Integer.valueOf(i2), str);
            switch (i2) {
                case 0:
                    this.mActivityRef = new WeakReference<>(activity);
                    c.cNJ().GP(700);
                    AppMethodBeat.o(169378);
                    return;
                case 1:
                    c.cNJ().GP(701);
                    AppMethodBeat.o(169378);
                    return;
                case 2:
                    c.cNJ().GP(702);
                    AppMethodBeat.o(169378);
                    return;
                case 3:
                    c.cNJ().GP(703);
                    break;
            }
            AppMethodBeat.o(169378);
        }
    }

    static /* synthetic */ int Hs(int i2) {
        switch (i2) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return -1;
        }
    }

    static /* synthetic */ void a(e eVar, ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(169381);
        eVar.mScrollState = i2;
        if (i2 == 1) {
            try {
                eVar.sJw = ((Integer) eVar.sJv.get(viewGroup)).intValue();
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.SnsMonitor", e2, "beginScrollState", new Object[0]);
            }
        } else if (i2 == 2) {
            eVar.p(viewGroup);
        } else if (i2 == 0) {
            eVar.sJx = 0;
        }
        eVar.sDg.g(viewGroup, i2);
        AppMethodBeat.o(169381);
    }

    static /* synthetic */ void a(e eVar, Activity activity, ViewGroup viewGroup, int i2, int i3) {
        AppMethodBeat.i(169382);
        if (eVar.mScrollState == 1) {
            eVar.p(viewGroup);
        }
        eVar.sDg.a(activity, viewGroup, i2, i3, eVar.sJx);
        AppMethodBeat.o(169382);
    }
}
