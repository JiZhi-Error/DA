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
public final class i implements o {
    WeakReference<Activity> mActivityRef;
    private final f sCN = new f() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.b.a.i.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void k(ViewGroup viewGroup, int i2) {
            int i3;
            AppMethodBeat.i(220481);
            a aVar = i.this.sDg;
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
            AppMethodBeat.o(220481);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void a(ViewGroup viewGroup, int i2, int i3, int i4) {
            AppMethodBeat.i(220482);
            if (i.this.mActivityRef == null) {
                AppMethodBeat.o(220482);
                return;
            }
            Activity activity = i.this.mActivityRef.get();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                Log.printInfoStack("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, onScroll, is NULL or finishing", new Object[0]);
                AppMethodBeat.o(220482);
                return;
            }
            i.this.sDg.a(activity, viewGroup, i2, i3, i4);
            AppMethodBeat.o(220482);
        }
    };
    private final p sCP = new p() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.b.a.i.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.p
        public final void md(boolean z) {
            AppMethodBeat.i(220483);
            if (i.this.sDg != null) {
                i.this.sDg.mc(z);
            }
            AppMethodBeat.o(220483);
        }
    };
    private final a sDC = new a();
    final a sDg = new a(4, "18260", "1004");

    i() {
        AppMethodBeat.i(220484);
        AppMethodBeat.o(220484);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void startMonitor() {
        AppMethodBeat.i(220486);
        if (this.mActivityRef != null) {
            this.sDg.a(0, this.mActivityRef.get());
        }
        this.sDC.a(this.sCN, this.sCP);
        AppMethodBeat.o(220486);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void stopMonitor() {
        AppMethodBeat.i(220487);
        this.sDC.stopMonitor();
        this.sDg.a(1, (Activity) null);
        AppMethodBeat.o(220487);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void free() {
        AppMethodBeat.i(220488);
        this.sDg.a(2, (Activity) null);
        if (this.mActivityRef != null) {
            this.mActivityRef.clear();
            this.mActivityRef = null;
        }
        AppMethodBeat.o(220488);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void report() {
        AppMethodBeat.i(220489);
        this.sDg.a(3, (Activity) null);
        AppMethodBeat.o(220489);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void a(int i2, String str, Activity activity) {
        boolean z;
        AppMethodBeat.i(220485);
        if (!com.tencent.mm.plugin.expt.hellhound.a.cNo() || !com.tencent.mm.plugin.expt.hellhound.a.cNr()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.e("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor, dontNeedMonitorFinder true !!");
            AppMethodBeat.o(220485);
            return;
        }
        Log.i("HABBYGE-MALI.FinderLikeMonitor", "FinderLikeMonitor, monitor: %d, %s", Integer.valueOf(i2), str);
        switch (i2) {
            case 0:
                this.mActivityRef = new WeakReference<>(activity);
                c.cNJ().m(724, str);
                AppMethodBeat.o(220485);
                return;
            case 1:
                c.cNJ().m(725, str);
                AppMethodBeat.o(220485);
                return;
            case 2:
                c.cNJ().m(726, str);
                AppMethodBeat.o(220485);
                return;
            case 3:
                c.cNJ().m(727, str);
                break;
        }
        AppMethodBeat.o(220485);
    }
}
