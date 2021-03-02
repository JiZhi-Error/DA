package com.tencent.mm.chatroom.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.b.a.hp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class b implements t {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.t
    public final void ad(String str, String str2) {
        boolean z;
        AppMethodBeat.i(182076);
        c ai = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(str, str2);
        if (ai != null) {
            boolean c2 = y.c(ai);
            for (Long l : ai.gts) {
                ca aJ = ((l) g.af(l.class)).eiy().aJ(str, l.longValue());
                aJ.CK("");
                ((l) g.af(l.class)).eiy().a(aJ.field_msgId, aJ);
            }
            nt ntVar = new nt();
            ntVar.dTT.op = 1;
            ntVar.dTT.dTU = str2;
            ntVar.dTT.dOe = str;
            EventCenter.instance.asyncPublish(ntVar, Looper.getMainLooper());
            z = c2;
        } else {
            z = false;
        }
        Object[] objArr = new Object[2];
        objArr[0] = ai == null ? BuildConfig.COMMAND : ai.field_todoid;
        objArr[1] = Boolean.valueOf(z);
        Log.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomInfoTodo delete(%s) result:%s", objArr);
        AppMethodBeat.o(182076);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.t
    public final void r(String str, long j2) {
        boolean z;
        AppMethodBeat.i(194009);
        ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
        if (Hb.field_msgId != j2) {
            c DB = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupTodoStorage().DB(str);
            if (DB != null) {
                z = y.c(DB);
                nt ntVar = new nt();
                ntVar.dTT.op = 1;
                ntVar.dTT.dTU = DB.field_todoid;
                ntVar.dTT.dOe = str;
                EventCenter.instance.asyncPublish(ntVar, Looper.getMainLooper());
            } else {
                z = false;
            }
            Object[] objArr = new Object[3];
            objArr[0] = DB == null ? BuildConfig.COMMAND : DB.field_todoid;
            objArr[1] = str;
            objArr[2] = Boolean.valueOf(z);
            Log.i("MicroMsg.roomTodo.RoomTodoService", "deleteChatroomAtAllTodo delete(%s) roomname:%s result:%s", objArr);
        } else if (!Util.isNullOrNil(Hb.fRe)) {
            ((t) g.af(t.class)).ad(str, Hb.fRe);
            AppMethodBeat.o(194009);
            return;
        }
        AppMethodBeat.o(194009);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.t
    public final boolean ama() {
        AppMethodBeat.i(182077);
        boolean ama = y.ama();
        AppMethodBeat.o(182077);
        return ama;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.t
    public final void b(String str, String str2, String str3, int i2, int i3, int i4) {
        int i5 = 2;
        AppMethodBeat.i(184780);
        Log.d("MicroMsg.roomTodo.RoomTodoService", "shareDialogOperateReport %s %s %s %s %s %s", str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (!y.ama()) {
            AppMethodBeat.o(184780);
        } else if (!ab.Ix(str)) {
            AppMethodBeat.o(184780);
        } else if (!ab.JN(str)) {
            AppMethodBeat.o(184780);
        } else {
            if (!ab.JO(str)) {
                i5 = 1;
            }
            hp hpVar = new hp();
            hpVar.eFc = hpVar.x("roomid", str, true);
            hpVar.enM = (long) i5;
            hpVar.enR = hpVar.x("appid", str2, true);
            hpVar.enS = hpVar.x("appname", str3, true);
            hpVar.eMg = (long) i2;
            hpVar.eMf = (long) i3;
            hpVar.eMc = (long) i4;
            hpVar.bfK();
            AppMethodBeat.o(184780);
        }
    }
}
