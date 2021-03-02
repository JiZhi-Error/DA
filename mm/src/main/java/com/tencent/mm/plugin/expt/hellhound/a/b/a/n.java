package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.pay.g;
import com.tencent.mm.plugin.expt.hellhound.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public final class n implements o {
    WeakReference<Activity> mActivityRef;
    private final f sCN = new f() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.b.a.n.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void k(ViewGroup viewGroup, int i2) {
            int i3;
            AppMethodBeat.i(220517);
            a aVar = n.this.sDg;
            switch (i2) {
                case 0:
                    i3 = 0;
                    break;
                case 1:
                    i3 = 1;
                    break;
                case 2:
                    i3 = 2;
                    break;
                default:
                    i3 = -1;
                    break;
            }
            aVar.g(viewGroup, i3);
            AppMethodBeat.o(220517);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void a(ViewGroup viewGroup, int i2, int i3, int i4) {
            AppMethodBeat.i(220518);
            if (n.this.mActivityRef == null) {
                AppMethodBeat.o(220518);
                return;
            }
            Activity activity = n.this.mActivityRef.get();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                Log.printInfoStack("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, onScroll, is NULL or finishing", new Object[0]);
                AppMethodBeat.o(220518);
                return;
            }
            n.this.sDg.a(activity, viewGroup, i2, i3, i4);
            AppMethodBeat.o(220518);
        }
    };
    private final p sCP = new p() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.b.a.n.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.p
        public final void md(boolean z) {
            AppMethodBeat.i(220519);
            if (n.this.sDg != null) {
                n.this.sDg.mc(z);
            }
            AppMethodBeat.o(220519);
        }
    };
    private a sDC = new a();
    a sDg = new a(3, "18260", "1003");

    n() {
        AppMethodBeat.i(220520);
        AppMethodBeat.o(220520);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void startMonitor() {
        AppMethodBeat.i(220522);
        if (this.mActivityRef != null) {
            this.sDg.a(0, this.mActivityRef.get());
        }
        this.sDC.a(this.sCN, this.sCP);
        AppMethodBeat.o(220522);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void stopMonitor() {
        AppMethodBeat.i(220523);
        this.sDC.stopMonitor();
        this.sDg.a(1, (Activity) null);
        AppMethodBeat.o(220523);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void free() {
        AppMethodBeat.i(220524);
        this.sDg.a(2, (Activity) null);
        if (this.mActivityRef != null) {
            this.mActivityRef.clear();
            this.mActivityRef = null;
        }
        AppMethodBeat.o(220524);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void report() {
        AppMethodBeat.i(220525);
        this.sDg.a(3, (Activity) null);
        AppMethodBeat.o(220525);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void a(int i2, String str, Activity activity) {
        boolean z;
        AppMethodBeat.i(220521);
        if (!com.tencent.mm.plugin.expt.hellhound.a.cNo() || !com.tencent.mm.plugin.expt.hellhound.a.cNr()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.e("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor, dontNeedMonitorFinder true !!");
            AppMethodBeat.o(220521);
            return;
        }
        Log.i("HABBYGE-MALI.FinderTopicMonitor", "FinderTopicMonitor, monitor: %d, %s", Integer.valueOf(i2), str);
        switch (i2) {
            case 0:
                this.mActivityRef = new WeakReference<>(activity);
                c.cNJ().m(712, str);
                AppMethodBeat.o(220521);
                return;
            case 1:
                c.cNJ().m(713, str);
                AppMethodBeat.o(220521);
                return;
            case 2:
                c.cNJ().m(g.CTRL_INDEX, str);
                AppMethodBeat.o(220521);
                return;
            case 3:
                c.cNJ().m(715, str);
                break;
        }
        AppMethodBeat.o(220521);
    }
}
