package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizFastRejectTool;", "", "()V", "KEY_MSG_ID", "", "KEY_MSG_RANK", "SCENE_BIZ_REJECT_PROFILE_SET", "", "TAG", "TYPE_BIZ_REJECT_TYPE_REJECT", "reportBizReject", "", "brandUserName", "actionTime", "", "scene", "sceneNote", "actionType", "plugin-brandservice_release"})
public final class a {
    public static final a pqG = new a();

    static {
        AppMethodBeat.i(6535);
        AppMethodBeat.o(6535);
    }

    private a() {
    }

    public static void r(String str, long j2, long j3) {
        AppMethodBeat.i(195151);
        p.h(str, "brandUserName");
        h.INSTANCE.a(17748, str, Long.valueOf(j2), 0, Long.valueOf(j3), 0);
        AppMethodBeat.o(195151);
    }
}
