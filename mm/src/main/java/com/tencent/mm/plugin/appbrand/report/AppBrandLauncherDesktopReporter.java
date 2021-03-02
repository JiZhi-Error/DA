package com.tencent.mm.plugin.appbrand.report;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\f\u001a\u00020\nH\u0007J\b\u0010\r\u001a\u00020\nH\u0007J\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u0018\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001a\u001a\u00020\nJ\b\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReporter;", "Landroid/arch/lifecycle/LifecycleObserver;", "()V", "enterUiTimestamp", "", "historyExposureItemIndexRecorder", "", "", "mSessionId", "onCreate", "", "onDestroy", "onResume", "onStop", "recordHistoryExposure", "indexStart", "indexEnd", "reportClickCollectionHeader", "reportClickEveryoneUsingHeader", "reportClickHistoryWxaItem", "appId", "", "listIndex", "reportClickLiveHeader", "showcaseType", "reportClickNearbyHeader", "reportClickOrderHeader", "reportEnterAppBrandDesktop", "reportHistoryWxaExposure", "count", "reportLeaveAppBrandDesktop", "stayDuration", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherDesktopReporter implements LifecycleObserver {
    public static final a nGY = new a((byte) 0);
    public long mSessionId;
    private long nGW;
    public Set<Integer> nGX = new LinkedHashSet();

    static {
        AppMethodBeat.i(180650);
        AppMethodBeat.o(180650);
    }

    public AppBrandLauncherDesktopReporter() {
        AppMethodBeat.i(180649);
        AppMethodBeat.o(180649);
    }

    public final void bUr() {
        AppMethodBeat.i(180645);
        h.INSTANCE.a(19468, 2, "", "", "", "", "", Long.valueOf(this.mSessionId));
        AppMethodBeat.o(180645);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        AppMethodBeat.i(180646);
        this.mSessionId = System.currentTimeMillis();
        h.INSTANCE.a(19468, 1, "", "", "", "", "", Long.valueOf(this.mSessionId));
        AppMethodBeat.o(180646);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        AppMethodBeat.i(180647);
        long currentTimeMillis = System.currentTimeMillis() - this.nGW;
        h.INSTANCE.a(19468, 8, "", Long.valueOf(currentTimeMillis), "", "", Long.valueOf(this.mSessionId));
        int size = this.nGX.size();
        h.INSTANCE.a(19468, 7, "", "", "", "", Integer.valueOf(size), Long.valueOf(this.mSessionId));
        this.nGX.clear();
        AppMethodBeat.o(180647);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        AppMethodBeat.i(180648);
        this.nGW = System.currentTimeMillis();
        AppMethodBeat.o(180648);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReporter$Companion;", "", "()V", "ACTION_CLICK_COLLECTION_HEADER", "", "ACTION_CLICK_EVERYONE_USING_HEADER", "ACTION_CLICK_HISTORY_WXA_ITEM", "ACTION_CLICK_LIVE_HEADER", "ACTION_CLICK_NEARBY_HEADER", "ACTION_CLICK_ORDER_HEADER", "ACTION_ENTER_DESKTOP", "ACTION_REPORT_HISTORY_WXA_EXPOSURE", "ACTION_REPORT_LEAVE_APPBRAND_DESKTOP", "REPORT_ID", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
