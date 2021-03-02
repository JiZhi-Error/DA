package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0002\u000b\u000e\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class h implements o {
    public static final a sDA = new a((byte) 0);
    private WeakReference<Activity> mActivityRef;
    private final a sDf = new a();
    private com.tencent.mm.plugin.expt.hellhound.a.a.a sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(13, "18260", "1013");
    private final b sDy = new b(this);
    private final c sDz = new c(this);

    static {
        AppMethodBeat.i(220879);
        AppMethodBeat.o(220879);
    }

    public h() {
        AppMethodBeat.i(220878);
        AppMethodBeat.o(220878);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(int i2, String str, Activity activity) {
        AppMethodBeat.i(220873);
        p.h(str, "aName");
        Log.i("HABBYGE-MALI.FinderLbsMonitor", "monitor: %d, %s", Integer.valueOf(i2), str);
        switch (i2) {
            case 0:
                if (activity != null) {
                    this.mActivityRef = new WeakReference<>(activity);
                }
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(744, str);
                AppMethodBeat.o(220873);
                return;
            case 1:
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(745, str);
                AppMethodBeat.o(220873);
                return;
            case 2:
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(746, str);
                AppMethodBeat.o(220873);
                return;
            case 3:
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(av.CTRL_INDEX, str);
                break;
        }
        AppMethodBeat.o(220873);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void startMonitor() {
        AppMethodBeat.i(220874);
        if (this.mActivityRef != null) {
            com.tencent.mm.plugin.expt.hellhound.a.a.a aVar = this.sDg;
            WeakReference<Activity> weakReference = this.mActivityRef;
            aVar.a(0, weakReference != null ? weakReference.get() : null);
        }
        this.sDf.a(this.sDy, this.sDz);
        AppMethodBeat.o(220874);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void stopMonitor() {
        AppMethodBeat.i(220875);
        this.sDf.stopMonitor();
        this.sDg.a(1, (Activity) null);
        AppMethodBeat.o(220875);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void free() {
        AppMethodBeat.i(220876);
        this.sDg.a(2, (Activity) null);
        WeakReference<Activity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.mActivityRef = null;
        AppMethodBeat.o(220876);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void report() {
        AppMethodBeat.i(220877);
        this.sDg.a(3, (Activity) null);
        AppMethodBeat.o(220877);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
    public static final class b implements f {
        final /* synthetic */ h sDB;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(h hVar) {
            this.sDB = hVar;
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void k(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(220870);
            this.sDB.sDg.g(viewGroup, h.Hd(i2));
            AppMethodBeat.o(220870);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void a(ViewGroup viewGroup, int i2, int i3, int i4) {
            AppMethodBeat.i(220871);
            WeakReference weakReference = this.sDB.mActivityRef;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                Log.printInfoStack("HABBYGE-MALI.FinderLbsMonitor", "onScroll, is NULL or finishing", new Object[0]);
                AppMethodBeat.o(220871);
                return;
            }
            this.sDB.sDg.a(activity, viewGroup, i2, i3, i4);
            AppMethodBeat.o(220871);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
    public static final class c implements p {
        final /* synthetic */ h sDB;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(h hVar) {
            this.sDB = hVar;
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.p
        public final void md(boolean z) {
            AppMethodBeat.i(220872);
            this.sDB.sDg.mc(z);
            AppMethodBeat.o(220872);
        }
    }

    public static final /* synthetic */ int Hd(int i2) {
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
}
