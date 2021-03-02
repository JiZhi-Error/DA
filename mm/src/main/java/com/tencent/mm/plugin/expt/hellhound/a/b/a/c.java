package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tavkit.component.TAVExporter;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public final class c implements o {
    WeakReference<Activity> mActivityRef;
    private final f sCN = new f() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.b.a.c.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void k(ViewGroup viewGroup, int i2) {
            int i3;
            AppMethodBeat.i(220472);
            a aVar = c.this.sDg;
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
            AppMethodBeat.o(220472);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void a(ViewGroup viewGroup, int i2, int i3, int i4) {
            AppMethodBeat.i(220473);
            if (c.this.mActivityRef == null) {
                AppMethodBeat.o(220473);
                return;
            }
            Activity activity = c.this.mActivityRef.get();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                Log.printInfoStack("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, onScroll, is NULL or finishing", new Object[0]);
                AppMethodBeat.o(220473);
                return;
            }
            c.this.sDg.a(activity, viewGroup, i2, i3, i4);
            AppMethodBeat.o(220473);
        }
    };
    private final p sCP = new p() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.b.a.c.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.p
        public final void md(boolean z) {
            AppMethodBeat.i(220474);
            if (c.this.sDg != null) {
                c.this.sDg.mc(z);
            }
            AppMethodBeat.o(220474);
        }
    };
    private a sDf = new a();
    a sDg = new a(6, "18260", "1006");

    c() {
        AppMethodBeat.i(220475);
        AppMethodBeat.o(220475);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void startMonitor() {
        AppMethodBeat.i(220477);
        if (this.mActivityRef != null) {
            this.sDg.a(0, this.mActivityRef.get());
        }
        this.sDf.a(this.sCN, this.sCP);
        AppMethodBeat.o(220477);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void stopMonitor() {
        AppMethodBeat.i(220478);
        this.sDf.stopMonitor();
        this.sDg.a(1, (Activity) null);
        AppMethodBeat.o(220478);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void free() {
        AppMethodBeat.i(220479);
        this.sDg.a(2, (Activity) null);
        if (this.mActivityRef != null) {
            this.mActivityRef.clear();
            this.mActivityRef = null;
        }
        AppMethodBeat.o(220479);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void report() {
        AppMethodBeat.i(220480);
        this.sDg.a(3, (Activity) null);
        AppMethodBeat.o(220480);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void a(int i2, String str, Activity activity) {
        boolean z;
        AppMethodBeat.i(220476);
        if (!com.tencent.mm.plugin.expt.hellhound.a.cNo() || !com.tencent.mm.plugin.expt.hellhound.a.cNr()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.e("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor, dontNeedMonitorFinder true !!");
            AppMethodBeat.o(220476);
            return;
        }
        Log.i("HABBYGE-MALI.FinderDetailMonitor", "FinderDetailMonitor, monitor: %d, %s", Integer.valueOf(i2), str);
        switch (i2) {
            case 0:
                this.mActivityRef = new WeakReference<>(activity);
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(TAVExporter.VIDEO_EXPORT_WIDTH, str);
                AppMethodBeat.o(220476);
                return;
            case 1:
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(721, str);
                AppMethodBeat.o(220476);
                return;
            case 2:
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(722, str);
                AppMethodBeat.o(220476);
                return;
            case 3:
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(723, str);
                break;
        }
        AppMethodBeat.o(220476);
    }
}
