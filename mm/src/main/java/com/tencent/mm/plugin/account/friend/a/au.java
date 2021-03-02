package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class au {

    public static class a {
        public r kfY;
        public bn kfZ;

        public a(r rVar) {
            this.kfY = rVar;
        }

        public a(r rVar, bn bnVar) {
            this.kfY = rVar;
            this.kfZ = bnVar;
        }
    }

    public static List<a> aH(String str, int i2) {
        String str2;
        AppMethodBeat.i(184429);
        if (i2 > 0) {
            str2 = "SELECT *,rowid FROM OldAccountFriend " + " WHERE showHead = " + i2 + " AND oldUsername = " + h.Fl(str) + " ORDER BY pinyinName";
        } else {
            str2 = "SELECT *,rowid FROM OldAccountFriend " + " WHERE oldUsername = " + h.Fl(str) + " ORDER BY showHead,pinyinName";
        }
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getOldAccountFriendStorage().rawQuery(str2, new String[0]);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                try {
                    r rVar = new r();
                    rVar.convertFrom(rawQuery);
                    bn aEm = ((l) g.af(l.class)).eix().aEm(rVar.field_encryptUsername);
                    if (aEm == null || !rVar.field_encryptUsername.equals(aEm.field_talker)) {
                        arrayList.add(new a(rVar));
                    } else {
                        arrayList.add(new a(rVar, aEm));
                    }
                } catch (Throwable th) {
                    rawQuery.close();
                    AppMethodBeat.o(184429);
                    throw th;
                }
            }
            rawQuery.close();
        }
        Log.i("MicroMsg.RecoverFriendLogic", "get recover friend, sql %s, get %d data", str2, Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(184429);
        return arrayList;
    }

    public static int Th(String str) {
        AppMethodBeat.i(184430);
        Cursor rawQuery = ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getOldAccountFriendStorage().rawQuery("SELECT COUNT(oldUsername) FROM OldAccountFriend WHERE oldUsername = " + h.Fl(str), new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToFirst()) {
                    return rawQuery.getInt(0);
                }
                rawQuery.close();
            } finally {
                rawQuery.close();
                AppMethodBeat.o(184430);
            }
        }
        AppMethodBeat.o(184430);
        return 0;
    }

    public static int Ti(String str) {
        AppMethodBeat.i(184431);
        Cursor rawQuery = ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getOldAccountFriendStorage().rawQuery("SELECT seq FROM OldAccountFriend WHERE oldUsername = " + h.Fl(str) + "ORDER BY seq DESC", new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToFirst()) {
                    return rawQuery.getInt(0);
                }
                rawQuery.close();
            } finally {
                rawQuery.close();
                AppMethodBeat.o(184431);
            }
        }
        AppMethodBeat.o(184431);
        return 0;
    }

    public static r ca(String str, String str2) {
        AppMethodBeat.i(184432);
        String str3 = "SELECT *,rowid FROM OldAccountFriend  WHERE encryptUsername = " + h.Fl(str2) + " AND oldUsername = " + h.Fl(str);
        Log.i("MicroMsg.RecoverFriendLogic", "get old acct friend, sql %s", str3);
        Cursor rawQuery = ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getOldAccountFriendStorage().rawQuery(str3, new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToFirst()) {
                    r rVar = new r();
                    rVar.convertFrom(rawQuery);
                    return rVar;
                }
                rawQuery.close();
            } finally {
                rawQuery.close();
                AppMethodBeat.o(184432);
            }
        }
        AppMethodBeat.o(184432);
        return null;
    }

    public static void aI(String str, int i2) {
        AppMethodBeat.i(184433);
        if (!Util.isNullOrNil(str)) {
            String str2 = "SELECT *,rowid FROM OldAccountFriend  WHERE encryptUsername = " + h.Fl(str);
            Log.i("MicroMsg.RecoverFriendLogic", "update old acct friend add state, sql %s", str2);
            Cursor rawQuery = ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getOldAccountFriendStorage().rawQuery(str2, new String[0]);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        r rVar = new r();
                        rVar.convertFrom(rawQuery);
                        rVar.field_addState = i2;
                        ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getOldAccountFriendStorage()).replace(rVar);
                    }
                    return;
                } finally {
                    rawQuery.close();
                    AppMethodBeat.o(184433);
                }
            }
        }
        AppMethodBeat.o(184433);
    }
}
