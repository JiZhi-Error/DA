package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.o.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.List;

public final class h {
    public static final Cursor jG(List<String> list) {
        AppMethodBeat.i(102837);
        List<String> jH = jH(list);
        if (jH.size() == 0) {
            g.aAi();
            Cursor gCo = ((l) g.af(l.class)).aSN().gCo();
            AppMethodBeat.o(102837);
            return gCo;
        }
        g.aAi();
        Cursor iL = ((l) g.af(l.class)).aSN().iL(jH);
        AppMethodBeat.o(102837);
        return iL;
    }

    private static final List<String> jH(List<String> list) {
        AppMethodBeat.i(102838);
        ArrayList arrayList = new ArrayList();
        Cursor b2 = ((l) g.af(l.class)).aST().b(ab.iCF, list, a.gNj, true, null);
        if (b2.moveToFirst()) {
            int i2 = 0;
            do {
                az azVar = new az();
                azVar.convertFrom(b2);
                if (aRc(azVar.field_username)) {
                    arrayList.add(azVar.field_username);
                    i2++;
                    if (i2 >= 4) {
                        break;
                    }
                }
            } while (b2.moveToNext());
        }
        b2.close();
        AppMethodBeat.o(102838);
        return arrayList;
    }

    private static final boolean aRc(String str) {
        AppMethodBeat.i(102839);
        for (String str2 : ab.iCO) {
            if (str.equals(str2)) {
                AppMethodBeat.o(102839);
                return false;
            }
        }
        if (ab.Eq(str)) {
            AppMethodBeat.o(102839);
            return false;
        } else if (ab.IT(str)) {
            AppMethodBeat.o(102839);
            return false;
        } else {
            AppMethodBeat.o(102839);
            return true;
        }
    }
}
