package com.tencent.mm.plugin.finder.live.view;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder_release"})
public final class FinderLiveVisitorPluginLayout$miniWindow$1 implements RequestFloatWindowPermissionDialog.a {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderLiveVisitorPluginLayout$miniWindow$1(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
    public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
        int i2 = 1;
        AppMethodBeat.i(247598);
        p.h(requestFloatWindowPermissionDialog, "dialog");
        requestFloatWindowPermissionDialog.finish();
        m.vli.a(true, s.r.LIVE_FLOAT_ACTION_UNKNOWN);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_FINDER_LIVE_FORCE_TASK", true);
        if (!this.this$0.isSwipeBack()) {
            i2 = 3;
        }
        bundle.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", i2);
        bundle.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 13);
        this.this$0.statusChange(b.c.hLQ, bundle);
        this.this$0.setMiniWinPermission(false);
        AppMethodBeat.o(247598);
    }

    @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
    public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
        AppMethodBeat.i(247599);
        p.h(requestFloatWindowPermissionDialog, "dialog");
        this.this$0.setMiniWinPermission(false);
        requestFloatWindowPermissionDialog.finish();
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_LIVE_MINI_WINDOW_AUTO", true);
        this.this$0.statusChange(b.c.hLT, bundle);
        AppMethodBeat.o(247599);
    }

    @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
    public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
        AppMethodBeat.i(247600);
        p.h(requestFloatWindowPermissionDialog, "dialog");
        this.this$0.setMiniWinPermission(false);
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_LIVE_MINI_WINDOW_AUTO", true);
        this.this$0.statusChange(b.c.hLU, bundle);
        AppMethodBeat.o(247600);
    }
}
