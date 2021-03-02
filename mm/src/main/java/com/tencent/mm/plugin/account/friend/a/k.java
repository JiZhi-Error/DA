package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.TimeLogger;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import java.util.List;

public final class k extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS friend_ext ( username text  PRIMARY KEY , sex int  , personalcard int  , province text  , city text  , signature text  , reserved1 text  , reserved2 text  , reserved3 text  , reserved4 text  , reserved5 int  , reserved6 int  , reserved7 int  , reserved8 int  ) "};
    public h iFy;

    public k(h hVar) {
        this.iFy = hVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007c, code lost:
        if (((int) r9.iFy.insert("friend_ext", com.tencent.mm.g.c.ch.COL_USERNAME, r10.convertTo())) == -1) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x005c, code lost:
        if (r2 > 0) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.plugin.account.friend.a.j r10) {
        /*
        // Method dump skipped, instructions count: 130
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.friend.a.k.a(com.tencent.mm.plugin.account.friend.a.j):boolean");
    }

    public final boolean av(List<j> list) {
        boolean z;
        AppMethodBeat.i(131020);
        if (list.size() <= 0) {
            AppMethodBeat.o(131020);
            return false;
        }
        TimeLogger timeLogger = new TimeLogger("MicroMsg.FriendExtStorage", "batchSetFriendExt transaction");
        timeLogger.addSplit("transation begin");
        long beginTransaction = this.iFy.beginTransaction(Thread.currentThread().getId());
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                j jVar = list.get(i2);
                if (jVar != null) {
                    a(jVar);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.FriendExtStorage", e2.getMessage());
                z = false;
            }
        }
        z = true;
        this.iFy.endTransaction(beginTransaction);
        timeLogger.addSplit("transation end");
        timeLogger.dumpToLog();
        doNotify();
        AppMethodBeat.o(131020);
        return z;
    }
}
