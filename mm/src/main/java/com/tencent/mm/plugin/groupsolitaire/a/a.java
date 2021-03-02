package com.tencent.mm.plugin.groupsolitaire.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a implements j {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.j
    public final void a(String str, String str2, String str3, String str4, long j2, long j3) {
        AppMethodBeat.i(194419);
        Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s", str, str2, Long.valueOf(j2));
        if (BuildInfo.DEBUG) {
            String.format("processGroupSolitatireMessage() fromUserName:%s toUserName:%s title:%s xml:%s", str, str2, str3, str4);
        }
        try {
            com.tencent.mm.plugin.groupsolitaire.c.a au = b.au(str, str3, str4);
            b.a(str, str2, au, j2, true);
            b.a(au, b.a(au, ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(str, au.field_key, true), str2, 3), j2, false, str2, true, j3);
            b.a(j2, str2, au);
            AppMethodBeat.o(194419);
        } catch (Exception e2) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage1() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(194419);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.j
    public final void b(String str, String str2, String str3, String str4, long j2, long j3) {
        AppMethodBeat.i(194420);
        Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessageByGetMsg() fromUserName:%s toUserName:%s msgId:%s", str, str2, Long.valueOf(j2));
        if (BuildInfo.DEBUG) {
            String.format("processGroupSolitatireMessageByGetMsg() fromUserName:%s toUserName:%s title:%s xml:%s", str, str2, str3, str4);
        }
        try {
            com.tencent.mm.plugin.groupsolitaire.c.a au = b.au(str, str3, str4);
            b.a(str, str2, au, j2, true);
            com.tencent.mm.plugin.groupsolitaire.c.a r = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(str, au.field_key, true);
            if (r == null || r.field_lastActiveTime <= j3) {
                b.a(au, b.a(au, r, str2, 3), j2, false, str2, true, true, j3);
                b.a(j2, str2, au);
                AppMethodBeat.o(194420);
                return;
            }
            Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "from getRoom % < %s", Long.valueOf(j3), Long.valueOf(r.field_lastActiveTime));
            AppMethodBeat.o(194420);
        } catch (Exception e2) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessageByGetMsg() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(194420);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.j
    public final void a(String str, String str2, String str3, long j2) {
        AppMethodBeat.i(110313);
        a(str, str2, str3, j2, (long) cl.aWB());
        AppMethodBeat.o(110313);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.j
    public final void a(String str, String str2, String str3, long j2, long j3) {
        AppMethodBeat.i(194421);
        Log.i("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s ", str, str2, Long.valueOf(j2));
        try {
            str3 = ((com.tencent.mm.plugin.emoji.b.a) g.af(com.tencent.mm.plugin.emoji.b.a.class)).alW(str3);
        } catch (Exception e2) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage() emojiSoftBank2Unicode %s %s", e2.getClass().getSimpleName(), e2.getMessage());
        }
        if (BuildInfo.DEBUG) {
            String.format("processGroupSolitatireMessage() fromUserName:%s toUserName:%s msgId:%s content:%s", str, str2, Long.valueOf(j2), str3);
        }
        try {
            Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> ia = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ia(str3, str);
            if (((Integer) ia.first).intValue() > 0 && ia.second != null) {
                com.tencent.mm.plugin.groupsolitaire.c.a aVar = (com.tencent.mm.plugin.groupsolitaire.c.a) ia.second;
                b.a(str, str2, aVar, j2, false);
                b.a(aVar, b.a(aVar, ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(str, aVar.field_key, true), str2, 1), j2, true, str2, false, j3);
                b.a(j2, str2, aVar);
            }
            AppMethodBeat.o(194421);
        } catch (Exception e3) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitaireService", "processGroupSolitatireMessage2() Exception:%s %s", e3.getClass().getSimpleName(), e3.getMessage());
            AppMethodBeat.o(194421);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.j
    public final boolean aBf(String str) {
        AppMethodBeat.i(110314);
        if (!ab.Ix(str) || (!PluginGroupSolitaire.isSupportGroupSolitaireAnalyze() && !PluginGroupSolitaire.isSupportGroupSolitaireShow())) {
            AppMethodBeat.o(110314);
            return false;
        }
        AppMethodBeat.o(110314);
        return true;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.j
    public final boolean aBg(String str) {
        AppMethodBeat.i(110315);
        if (!ab.Ix(str) || !PluginGroupSolitaire.isSupportGroupSolitaireShow()) {
            AppMethodBeat.o(110315);
            return false;
        }
        AppMethodBeat.o(110315);
        return true;
    }
}
