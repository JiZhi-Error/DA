package com.tencent.mm.chatroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class c implements u {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.u
    public final void amb() {
        AppMethodBeat.i(185964);
        aa.amf();
        AppMethodBeat.o(185964);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.u
    public final void Dv(String str) {
        AppMethodBeat.i(194010);
        if (aa.ame() && ab.Ix(str)) {
            e Dz = aa.Dz(str);
            if (Dz == null) {
                Log.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is null", str);
                AppMethodBeat.o(194010);
                return;
            } else if (Dz.field_queryState == 0) {
                Log.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is COL_STATE_NEED_QUERY", str);
                AppMethodBeat.o(194010);
                return;
            } else {
                Dz.a(new GroupToolItem("roomaa@app.origin", "", cl.aWy()));
                Log.i("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA room:%s result:%s", str, Boolean.valueOf(((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(Dz, new String[0])));
            }
        }
        AppMethodBeat.o(194010);
    }
}
