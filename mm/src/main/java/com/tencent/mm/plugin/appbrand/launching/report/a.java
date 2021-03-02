package com.tencent.mm.plugin.appbrand.launching.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.am;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/report/LaunchGetWxaAttrsIDKeyConstants;", "", "()V", "ID", "", "KEY_APP_VERSION_LESS_THAN_SYNC_VERSION", "KEY_SYNC_GET_BY_ATTRS_NOT_FOUND", "KEY_SYNC_GET_BY_CMD_UPDATE_VERSION", "KEY_SYNC_GET_BY_INVALID_FIELDS", "KEY_SYNC_GET_BY_MISSING_PKG", "KEY_SYNC_GET_BY_NO_USE_RECENT", "KEY_SYNC_GET_BY_PATH_NOT_FOUND", "KEY_SYNC_GET_BY_VERSION_NOT_FOUND", "KEY_SYNC_GET_TOTAL", "KEY_USERNAME_INVALID", "reportSyncGet", "", "reason", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchStepCostReporter$GetAttrsReason;", "plugin-appbrand-integration_release"})
public final class a {
    public static final a mZt = new a();

    static {
        AppMethodBeat.i(228764);
        AppMethodBeat.o(228764);
    }

    private a() {
    }

    public static final void a(am.a aVar) {
        int i2;
        AppMethodBeat.i(228763);
        p.h(aVar, "reason");
        h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.a.CTRL_INDEX, 10);
        switch (b.$EnumSwitchMapping$0[aVar.ordinal()]) {
            case 1:
                AppMethodBeat.o(228763);
                return;
            case 2:
                i2 = 11;
                break;
            case 3:
                i2 = 12;
                break;
            case 4:
                i2 = 13;
                break;
            case 5:
                i2 = 14;
                break;
            case 6:
                i2 = 15;
                break;
            case 7:
                i2 = 16;
                break;
            case 8:
                i2 = 17;
                break;
            default:
                m mVar = new m();
                AppMethodBeat.o(228763);
                throw mVar;
        }
        h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.a.CTRL_INDEX, i2);
        AppMethodBeat.o(228763);
    }
}
