package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, c, com.tencent.mm.kernel.c.a, com.tencent.mm.plugin.chatroom.a.c {
    private boolean isDebugMode;
    private ai qnb;
    private HashMap<String, Boolean> qnc = new HashMap<>();

    public a() {
        AppMethodBeat.i(116862);
        AppMethodBeat.o(116862);
    }

    @Override // com.tencent.mm.plugin.chatroom.a.c
    public final ap b(h hVar) {
        AppMethodBeat.i(116863);
        ai aiVar = new ai(hVar);
        AppMethodBeat.o(116863);
        return aiVar;
    }

    @Override // com.tencent.mm.plugin.chatroom.a.c
    public final boolean akx(String str) {
        boolean z;
        AppMethodBeat.i(116864);
        if (this.isDebugMode) {
            AppMethodBeat.o(116864);
            return false;
        }
        try {
            if (this.qnc.containsKey(str)) {
                boolean booleanValue = this.qnc.get(str).booleanValue();
                AppMethodBeat.o(116864);
                return booleanValue;
            }
            ah Kd = this.qnb.Kd(str);
            boolean z2 = (((long) Kd.field_chatroomStatus) & 16384) != 0;
            int i2 = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("ChatRoomAdminSwitch", -1);
            int i3 = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("ChatRoomAdminMinMemberCount", -1);
            Log.i("MicroMsg.ChatroomService", "[isEnableRoomManager] chatroomName:%s isStatusEnable:%s switchFlag:%s minCount:%d memberCount:%d", str, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(Kd.bax().size()));
            if (i2 <= 0 || (!z2 && i3 > Kd.bax().size())) {
                z = false;
            } else {
                z = true;
            }
            this.qnc.put(str, Boolean.valueOf(z));
            AppMethodBeat.o(116864);
            return z;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ChatroomService", e2, "[isEnableRoomManager]", new Object[0]);
            AppMethodBeat.o(116864);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.chatroom.a.c
    public final void setDebugMode(boolean z) {
        this.isDebugMode = z;
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(116865);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("CHATROOM_MEMBERS_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.chatroom.a.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return ai.SQL_CREATE;
            }
        });
        AppMethodBeat.o(116865);
        return hashMap;
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(116866);
        this.qnb = new ai(g.aAh().hqK);
        AppMethodBeat.o(116866);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
    }

    @Override // com.tencent.mm.plugin.chatroom.a.c
    public final /* bridge */ /* synthetic */ ap aSX() {
        return this.qnb;
    }
}
