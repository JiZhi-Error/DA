package com.tencent.mm.plugin.card.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class a implements b {
    @Override // com.tencent.mm.plugin.card.c.b
    public final boolean cuq() {
        AppMethodBeat.i(112904);
        boolean cxF = l.cxF();
        AppMethodBeat.o(112904);
        return cxF;
    }

    @Override // com.tencent.mm.plugin.card.c.b
    public final boolean cur() {
        AppMethodBeat.i(112905);
        boolean cxH = l.cxH();
        AppMethodBeat.o(112905);
        return cxH;
    }

    @Override // com.tencent.mm.plugin.card.c.b
    public final String cus() {
        AppMethodBeat.i(112906);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) null);
        AppMethodBeat.o(112906);
        return str;
    }

    @Override // com.tencent.mm.plugin.card.c.b
    public final int cut() {
        int i2 = 0;
        AppMethodBeat.i(112907);
        c ctQ = am.ctQ();
        StringBuilder sb = new StringBuilder();
        sb.append(" where (status=0 OR status=5) and (block_mask").append("= '1' OR block_mask= '0' )");
        Cursor rawQuery = ctQ.db.rawQuery("select count(*) from UserCardInfo" + sb.toString(), null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        Log.i("MicroMsg.CardMgrImpl", "getGiftCardCount:".concat(String.valueOf(i2)));
        AppMethodBeat.o(112907);
        return i2;
    }

    @Override // com.tencent.mm.plugin.card.c.b
    public final boolean Eg(int i2) {
        AppMethodBeat.i(112908);
        boolean Eg = l.Eg(i2);
        AppMethodBeat.o(112908);
        return Eg;
    }
}
