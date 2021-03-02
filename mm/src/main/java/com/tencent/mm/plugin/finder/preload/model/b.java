package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, hxF = {SharePatchInfo.FINGER_PRINT, "", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "plugin-finder_release"})
public final class b {
    public static final String a(ayh ayh) {
        AppMethodBeat.i(249550);
        p.h(ayh, "$this$print");
        String str = "Spec[" + ayh.uUI + ' ' + ayh.dVY + ' ' + Util.getSizeKB((long) ayh.LEL) + ' ' + ayh.LGa + ']';
        AppMethodBeat.o(249550);
        return str;
    }
}
