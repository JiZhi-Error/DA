package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class s {
    public static int aTQ() {
        int i2;
        AppMethodBeat.i(20317);
        if (!g.aAc()) {
            Log.w("MicroMsg.BottleConversationLogic", "get Bottle Total Conversation Unread, but has not set uin");
            AppMethodBeat.o(20317);
            return 0;
        }
        Cursor gCA = ((l) g.af(l.class)).aST().gCA();
        if (gCA == null || gCA.getCount() <= 0) {
            i2 = 0;
        } else {
            gCA.moveToFirst();
            i2 = gCA.getInt(0);
        }
        if (gCA != null) {
            gCA.close();
        }
        AppMethodBeat.o(20317);
        return i2;
    }
}
