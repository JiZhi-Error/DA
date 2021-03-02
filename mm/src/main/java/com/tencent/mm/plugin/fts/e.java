package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.List;

public final class e implements j {
    @Override // com.tencent.mm.plugin.fts.a.j
    public final Cursor i(String str, String[] strArr) {
        AppMethodBeat.i(52548);
        g.aAi();
        Cursor rawQuery = g.aAh().hqL.rawQuery(str, strArr, 2);
        AppMethodBeat.o(52548);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.fts.a.j
    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.i(52549);
        g.aAi();
        Cursor rawQuery = g.aAh().hqL.rawQuery(str, strArr);
        AppMethodBeat.o(52549);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.fts.a.j
    public final as ayj(String str) {
        AppMethodBeat.i(52550);
        as bjF = ((l) g.af(l.class)).aSN().bjF(str);
        if (bjF == null) {
            bjF = new as();
            Cursor i2 = i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE username = ? AND deleteFlag=0;", new String[]{str});
            if (i2.moveToNext()) {
                bjF.gMZ = i2.getLong(0);
                bjF.setUsername(i2.getString(1));
                bjF.BC(i2.getString(2));
                bjF.BD(i2.getString(3));
                bjF.setNickname(i2.getString(4));
                bjF.nf(i2.getInt(5));
                bjF.setType(i2.getInt(6));
                bjF.Z(i2.getBlob(7));
                bjF.BL(i2.getString(8));
                bjF.nh(0);
            }
            i2.close();
        }
        AppMethodBeat.o(52550);
        return bjF;
    }

    @Override // com.tencent.mm.plugin.fts.a.j
    public final boolean ayk(String str) {
        AppMethodBeat.i(52551);
        Cursor i2 = i(String.format("SELECT 1 FROM rconversation WHERE username = ?", new Object[0]), new String[]{str});
        try {
            return i2.moveToNext();
        } finally {
            if (i2 != null) {
                i2.close();
            }
            AppMethodBeat.o(52551);
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.j
    public final long ayl(String str) {
        AppMethodBeat.i(52552);
        Cursor i2 = i("SELECT conversationTime FROM rconversation WHERE username=?;", new String[]{str});
        long j2 = 0;
        if (i2 != null && i2.moveToFirst()) {
            j2 = i2.getLong(0);
        }
        if (i2 != null) {
            i2.close();
        }
        AppMethodBeat.o(52552);
        return j2;
    }

    @Override // com.tencent.mm.plugin.fts.a.j
    public final List<String> aym(String str) {
        AppMethodBeat.i(52553);
        ArrayList arrayList = new ArrayList();
        if (str.endsWith("\u0000")) {
            str = str.substring(0, str.length() - 1);
        }
        if (str.length() == 0) {
            AppMethodBeat.o(52553);
        } else {
            Cursor i2 = i(String.format("SELECT labelName FROM ContactLabel WHERE labelID IN (%s);", str), null);
            while (i2.moveToNext()) {
                arrayList.add(i2.getString(0));
            }
            i2.close();
            AppMethodBeat.o(52553);
        }
        return arrayList;
    }
}
