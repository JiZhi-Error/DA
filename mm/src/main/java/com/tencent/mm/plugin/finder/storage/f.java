package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, hxF = {SharePatchInfo.FINGER_PRINT, "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
public final class f {
    public static final String b(c cVar) {
        AppMethodBeat.i(251711);
        p.h(cVar, "$this$print");
        String str = "sessionId=" + cVar.field_sessionId + " placedFlag=" + cVar.field_placedFlag + " unReadCount=" + cVar.field_unReadCount + " status=" + cVar.field_status + " updateTime=" + cVar.field_updateTime + ' ' + "digest=" + cVar.field_digest + " digestType=" + cVar.field_digestType + " lastMsgID=" + cVar.field_lastMsgID + " unReadCount=" + cVar.field_unReadCount + "content=" + cVar.field_content + " isSend=" + cVar.field_isSend + " editingMsg=" + cVar.field_editingMsg + " systemRowId=" + cVar.systemRowid + " type=" + cVar.field_type;
        AppMethodBeat.o(251711);
        return str;
    }
}
