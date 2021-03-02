package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, hxF = {SharePatchInfo.FINGER_PRINT, "", "Lcom/tencent/mm/protocal/protobuf/FinderCheckExpireInfo;", "plugin-finder_release"})
public final class cj {
    public static final String a(apb apb) {
        AppMethodBeat.i(242514);
        p.h(apb, "$this$print");
        String str = "check_expire_interval_sec=" + apb.LBc + ", check_expire_max_count=" + apb.LBd + ", check_expire_valid=" + apb.LBb;
        AppMethodBeat.o(242514);
        return str;
    }
}
