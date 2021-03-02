package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import com.tencent.mm.aj.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.s;

public abstract class d extends s<as> implements e.a {

    public interface a {
        void ve(int i2);
    }

    public d(Context context, as asVar) {
        super(context, asVar);
    }

    public void a(a aVar) {
    }

    public void SM(String str) {
    }

    public static void Tk(String str) {
        com.tencent.mm.storage.as asVar;
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
            return;
        }
        as Tg = ((at) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).Tg(str);
        if (Tg != null) {
            Tg.kfO = 2;
            ((at) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(Tg.kfN, Tg);
        }
        com.tencent.mm.storage.as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null) {
            Log.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
            return;
        }
        if (Util.isNullOrNil(Kn.field_username)) {
            Kn.setUsername(str);
        }
        if (((int) Kn.gMZ) == 0) {
            ((l) g.af(l.class)).aSN().aq(Kn);
            if (!Util.isNullOrNil(Kn.field_username)) {
                asVar = ((l) g.af(l.class)).aSN().Kn(Kn.field_username);
            } else {
                return;
            }
        } else {
            asVar = Kn;
        }
        if (((int) asVar.gMZ) <= 0) {
            Log.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
            return;
        }
        ab.B(asVar);
        cf.aWl().f(26, new Object[0]);
    }
}
