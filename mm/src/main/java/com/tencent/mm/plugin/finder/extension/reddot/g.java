package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, hxF = {SharePatchInfo.FINGER_PRINT, "", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowEntranceExtInfo;", "plugin-finder_release"})
public final class g {
    public static final String a(FinderTipsShowEntranceExtInfo finderTipsShowEntranceExtInfo) {
        AppMethodBeat.i(243605);
        p.h(finderTipsShowEntranceExtInfo, "$this$print");
        String str = "extInfo{tab_type=" + finderTipsShowEntranceExtInfo.tab_type + " object_id=" + finderTipsShowEntranceExtInfo.object_id + '}';
        AppMethodBeat.o(243605);
        return str;
    }
}
