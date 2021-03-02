package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0002\f\u000f\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class f implements o {
    public static final a sDs = new a((byte) 0);
    private WeakReference<Activity> mActivityRef;
    private final a sDf = new a();
    private com.tencent.mm.plugin.expt.hellhound.a.a.a sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(10, "18260", "1010");
    private final b sDq;
    private final c sDr;

    static {
        AppMethodBeat.i(220861);
        AppMethodBeat.o(220861);
    }

    public f(Activity activity) {
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(220860);
        this.mActivityRef = new WeakReference<>(activity);
        this.sDq = new b(this);
        this.sDr = new c(this);
        AppMethodBeat.o(220860);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void startMonitor() {
        AppMethodBeat.i(220857);
        Log.d("HABBYGE-MALI.FinderFollowMonitor", "startMonitor");
        this.sDf.a(this.sDq, this.sDr);
        if (this.mActivityRef != null) {
            com.tencent.mm.plugin.expt.hellhound.a.a.a aVar = this.sDg;
            WeakReference<Activity> weakReference = this.mActivityRef;
            aVar.a(4, weakReference != null ? weakReference.get() : null);
        }
        AppMethodBeat.o(220857);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void stopMonitor() {
        AppMethodBeat.i(220858);
        Log.d("HABBYGE-MALI.FinderFollowMonitor", "stopMonitor");
        this.sDg.a(5, (Activity) null);
        this.sDf.stopMonitor();
        AppMethodBeat.o(220858);
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void report() {
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.o
    public final void free() {
        AppMethodBeat.i(220859);
        WeakReference<Activity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.mActivityRef = null;
        AppMethodBeat.o(220859);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
    public static final class b implements com.tencent.mm.plugin.expt.hellhound.a.a.f {
        final /* synthetic */ f sDt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(f fVar) {
            this.sDt = fVar;
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void k(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(220854);
            this.sDt.sDg.g(viewGroup, f.Hb(i2));
            AppMethodBeat.o(220854);
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.a.f
        public final void a(ViewGroup viewGroup, int i2, int i3, int i4) {
            String str;
            Class<?> cls;
            AppMethodBeat.i(220855);
            WeakReference weakReference = this.sDt.mActivityRef;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                StringBuilder sb = new StringBuilder("onScroll, is NULL or finishing: ");
                if (activity == null || (cls = activity.getClass()) == null) {
                    str = null;
                } else {
                    str = cls.getName();
                }
                Log.printInfoStack("HABBYGE-MALI.FinderFollowMonitor", sb.append(str).toString(), new Object[0]);
                AppMethodBeat.o(220855);
                return;
            }
            this.sDt.sDg.a(activity, viewGroup, i2, i3, i4);
            AppMethodBeat.o(220855);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFollowMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
    public static final class c implements p {
        final /* synthetic */ f sDt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(f fVar) {
            this.sDt = fVar;
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.a.p
        public final void md(boolean z) {
            AppMethodBeat.i(220856);
            Log.d("HABBYGE-MALI.FinderFollowMonitor", "scrollToPosition: %b", Boolean.valueOf(z));
            this.sDt.sDg.mc(z);
            AppMethodBeat.o(220856);
        }
    }

    public static final /* synthetic */ int Hb(int i2) {
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
