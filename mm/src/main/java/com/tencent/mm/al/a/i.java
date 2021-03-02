package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;

public final class i {
    public static void h(int i2, String str, String str2) {
        AppMethodBeat.i(124276);
        if (!"EnterpriseChatStatus".equals(str)) {
            AppMethodBeat.o(124276);
            return;
        }
        String[] split = str2.split(";");
        String str3 = split[0];
        String str4 = split[1];
        Util.getInt(split[2], 0);
        if (i2 == 7) {
            bo(str4, str3);
            AppMethodBeat.o(124276);
        } else if (i2 == 8) {
            bo(str4, str3);
            AppMethodBeat.o(124276);
        } else {
            if (i2 == 9) {
                bo(str4, str3);
            }
            AppMethodBeat.o(124276);
        }
    }

    private static void bo(String str, String str2) {
        AppMethodBeat.i(124277);
        long NM = e.NM(str);
        if (NM == -1) {
            Log.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", str);
            AppMethodBeat.o(124277);
            return;
        }
        int i2 = ag.bak().Al(NM).field_newUnReadCount;
        ag.bak().An(NM);
        c bs = ag.baj().bs(NM);
        az bjY = ((l) g.af(l.class)).aST().bjY(str2);
        if (bjY == null) {
            Log.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", str2);
            AppMethodBeat.o(124277);
        } else if (bs.iE(1)) {
            if (bjY.field_unReadMuteCount <= i2) {
                bjY.nz(0);
                ((l) g.af(l.class)).aST().a(bjY, str2);
                ((a) g.ah(a.class)).getNotification().cancelNotification(str2);
                AppMethodBeat.o(124277);
                return;
            }
            bjY.nz(bjY.field_unReadMuteCount - i2);
            ((l) g.af(l.class)).aST().a(bjY, str2);
            AppMethodBeat.o(124277);
        } else if (bjY.field_unReadCount <= i2) {
            ((l) g.af(l.class)).aST().bka(str2);
            ((a) g.ah(a.class)).getNotification().cancelNotification(str2);
            AppMethodBeat.o(124277);
        } else {
            bjY.ny(0);
            bjY.nt(bjY.field_unReadCount - i2);
            ((l) g.af(l.class)).aST().a(bjY, str2);
            AppMethodBeat.o(124277);
        }
    }
}
