package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public final class k implements o {
    WeakReference<Activity> mActivityRef;
    private final f sCN = new f() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.b.a.k.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void k(ViewGroup viewGroup, int i2) {
            int i3;
            AppMethodBeat.i(220490);
            a aVar = k.this.sDg;
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
            AppMethodBeat.o(220490);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void a(ViewGroup viewGroup, int i2, int i3, int i4) {
            AppMethodBeat.i(220491);
            if (k.this.mActivityRef == null) {
                AppMethodBeat.o(220491);
                return;
            }
            Activity activity = k.this.mActivityRef.get();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                Log.printInfoStack("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, onScroll, is NULL or finishing", new Object[0]);
                AppMethodBeat.o(220491);
                return;
            }
            k.this.sDg.a(activity, viewGroup, i2, i3, i4);
            AppMethodBeat.o(220491);
        }
    };
    private final p sCP = new p() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.b.a.k.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.p
        public final void md(boolean z) {
            AppMethodBeat.i(220492);
            if (k.this.sDg != null) {
                k.this.sDg.mc(z);
            }
            AppMethodBeat.o(220492);
        }
    };
    private a sDC = new a();
    a sDg = new a(2, "18260", "1002");

    k() {
        AppMethodBeat.i(220493);
        AppMethodBeat.o(220493);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void startMonitor() {
        AppMethodBeat.i(220495);
        Log.d("HABBYGE-MALI.FinderProfileMonitor", "startMonitor...");
        if (this.mActivityRef != null) {
            this.sDg.a(0, this.mActivityRef.get());
        }
        this.sDC.a(this.sCN, this.sCP);
        AppMethodBeat.o(220495);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void stopMonitor() {
        AppMethodBeat.i(220496);
        Log.d("HABBYGE-MALI.FinderProfileMonitor", "stopMonitor...");
        this.sDC.stopMonitor();
        this.sDg.a(1, (Activity) null);
        AppMethodBeat.o(220496);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void free() {
        AppMethodBeat.i(220497);
        Log.d("HABBYGE-MALI.FinderProfileMonitor", "free...");
        this.sDg.a(2, (Activity) null);
        if (this.mActivityRef != null) {
            this.mActivityRef.clear();
            this.mActivityRef = null;
        }
        AppMethodBeat.o(220497);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void report() {
        AppMethodBeat.i(220498);
        Log.d("HABBYGE-MALI.FinderProfileMonitor", "report...");
        this.sDg.a(3, (Activity) null);
        AppMethodBeat.o(220498);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void a(int i2, String str, Activity activity) {
        boolean z;
        AppMethodBeat.i(220494);
        if (!com.tencent.mm.plugin.expt.hellhound.a.cNo() || !com.tencent.mm.plugin.expt.hellhound.a.cNr()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.e("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor, dontNeedMonitorFinder true !!");
            AppMethodBeat.o(220494);
            return;
        }
        Log.i("HABBYGE-MALI.FinderProfileMonitor", "FinderProfileMonitor, monitor: %d, %s", Integer.valueOf(i2), str);
        switch (i2) {
            case 0:
                this.mActivityRef = new WeakReference<>(activity);
                c.cNJ().m(708, str);
                AppMethodBeat.o(220494);
                return;
            case 1:
                c.cNJ().m(709, str);
                AppMethodBeat.o(220494);
                return;
            case 2:
                c.cNJ().m(710, str);
                AppMethodBeat.o(220494);
                return;
            case 3:
                c.cNJ().m(711, str);
                break;
        }
        AppMethodBeat.o(220494);
    }
}
