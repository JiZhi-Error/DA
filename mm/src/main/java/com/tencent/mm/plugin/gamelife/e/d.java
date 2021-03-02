package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.plugin.gamelife.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0015\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeConversationService;", "()V", "addOnStorageChange", "", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "clearUnreadCount", "sessionId", "", "deleteConversationBySessionId", "", "getEditing", "getGameLifeConversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "getLatestUnReadConversationInfo", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationInfo;", "getTotalUnreadCount", "", "getUnreadCount", "removeOnStorageChange", "setEditing", "content", "Companion", "plugin-gamelife_release"})
public final class d implements c {
    public static final a yca = new a((byte) 0);

    static {
        AppMethodBeat.i(241362);
        AppMethodBeat.o(241362);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationService$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.gamelife.a.c
    public final void ave(String str) {
        AppMethodBeat.i(241352);
        b.a aVar = b.xZZ;
        if (!b.a.aAQ(str)) {
            AppMethodBeat.o(241352);
            return;
        }
        e conversationStorage = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage();
        if (str == null) {
            p.hyc();
        }
        conversationStorage.avs(str);
        AppMethodBeat.o(241352);
    }

    @Override // com.tencent.mm.plugin.gamelife.a.c
    public final int dWZ() {
        AppMethodBeat.i(241353);
        int dWZ = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage().dWZ();
        AppMethodBeat.o(241353);
        return dWZ;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.c
    public final int avf(String str) {
        AppMethodBeat.i(241354);
        b.a aVar = b.xZZ;
        if (!b.a.aAQ(str)) {
            AppMethodBeat.o(241354);
            return 0;
        }
        e conversationStorage = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage();
        if (str == null) {
            p.hyc();
        }
        int avf = conversationStorage.avf(str);
        AppMethodBeat.o(241354);
        return avf;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.c
    public final String avh(String str) {
        AppMethodBeat.i(241355);
        b.a aVar = b.xZZ;
        if (!b.a.aAQ(str)) {
            AppMethodBeat.o(241355);
            return "";
        }
        e conversationStorage = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage();
        if (str == null) {
            p.hyc();
        }
        String str2 = conversationStorage.aBa(str).field_editingMsg;
        if (str2 == null) {
            str2 = "";
        }
        AppMethodBeat.o(241355);
        return str2;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.c
    public final boolean gT(String str, String str2) {
        AppMethodBeat.i(241356);
        e conversationStorage = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage();
        if (str == null) {
            p.hyc();
        }
        a aBa = conversationStorage.aBa(str);
        if (str2 == null) {
            str2 = "";
        }
        aBa.field_editingMsg = str2;
        boolean updateNotify = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage().updateNotify(aBa, false, new String[0]);
        AppMethodBeat.o(241356);
        return updateNotify;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.c
    public final void l(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(241357);
        p.h(iOnStorageChange, "storageChange");
        ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage().remove(iOnStorageChange);
        AppMethodBeat.o(241357);
    }

    @Override // com.tencent.mm.plugin.gamelife.a.c
    public final void m(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(241358);
        p.h(iOnStorageChange, "storageChange");
        ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage().add(iOnStorageChange);
        AppMethodBeat.o(241358);
    }

    @Override // com.tencent.mm.plugin.gamelife.a.c
    public final boolean aAT(String str) {
        AppMethodBeat.i(241359);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(241359);
            return false;
        }
        e conversationStorage = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage();
        a aBa = conversationStorage.aBa(str);
        boolean deleteNotify = conversationStorage.deleteNotify(aBa.systemRowid, false);
        conversationStorage.doNotify(MStorageEventData.EventType.SINGLE, 3, aBa);
        AppMethodBeat.o(241359);
        return deleteNotify;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.c
    public final e dXb() {
        AppMethodBeat.i(241360);
        e conversationStorage = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage();
        AppMethodBeat.o(241360);
        return conversationStorage;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.c
    public final b dXa() {
        String str;
        boolean z;
        AppMethodBeat.i(241361);
        a dXk = ((PluginGameLife) g.ah(PluginGameLife.class)).getConversationStorage().dXk();
        long j2 = dXk != null ? dXk.field_lastMsgID : 0;
        if (dXk != null) {
            String str2 = dXk.field_talker;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str = "@gamelifehistory";
            } else {
                str = dXk.field_talker;
            }
        } else {
            str = null;
        }
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_GAME_LIFE_LAST_SAVED_MSG_TYPE_INT, 0);
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        b bVar = new b(str, j2, aAh2.azQ().a(ar.a.USERINFO_GAME_LIFE_LAST_SAVED_EXTERN_INFO_STRING, ""), i2);
        Log.i("GameLife.ConversationService", "getLatestConversationInfo: ".concat(String.valueOf(bVar)));
        AppMethodBeat.o(241361);
        return bVar;
    }
}
