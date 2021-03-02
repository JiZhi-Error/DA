package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, hxF = {SharePatchInfo.FINGER_PRINT, "", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "plugin-gamelife_release"})
public final class f {
    public static final String a(a aVar) {
        AppMethodBeat.i(241374);
        p.h(aVar, "$this$print");
        String str = "sessionId=" + aVar.field_sessionId + " unReadCount=" + aVar.field_unReadCount + " updateTime=" + aVar.field_updateTime + ' ' + "digest=" + aVar.field_digest + " lastMsgID=" + aVar.field_lastMsgID + " unReadCount=" + aVar.field_unReadCount + " systemRowid=" + aVar.systemRowid + " digestFlag=" + aVar.field_digestFlag;
        AppMethodBeat.o(241374);
        return str;
    }
}
