package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public enum b {
    INSTANCE;

    public static b valueOf(String str) {
        AppMethodBeat.i(89756);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(89756);
        return bVar;
    }

    static {
        AppMethodBeat.i(89764);
        AppMethodBeat.o(89764);
    }

    public static boolean jc(String str, String str2) {
        AppMethodBeat.i(89757);
        as asVar = new as();
        asVar.setNickname(str2);
        asVar.setUsername(str);
        bv aSN = ((l) g.af(l.class)).aSN();
        Log.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + asVar.field_username);
        if (!aSN.bjN(asVar.field_username)) {
            aSN.ap(asVar);
        }
        g.aAh().azQ().set(143873, str);
        g.aAh().azQ().set(143874, Long.valueOf(Util.nowSecond()));
        AppMethodBeat.o(89757);
        return true;
    }

    public static void eV(String str, int i2) {
        AppMethodBeat.i(89758);
        g.azz().a(new d(str, (int) Util.secondsToNow(Util.nullAsNil((Long) g.aAh().azQ().get(143874, (Object) 0L))), i2), 0);
        AppMethodBeat.o(89758);
    }

    public static void Ts(int i2) {
        AppMethodBeat.i(89759);
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(143873, ""));
        if (!nullAsNil.equals("")) {
            if (Util.secondsToNow(Util.nullAsNil((Long) g.aAh().azQ().get(143874, (Object) 0L))) < 7200) {
                eV(nullAsNil, i2);
                AppMethodBeat.o(89759);
                return;
            }
            aIt(nullAsNil);
        }
        AppMethodBeat.o(89759);
    }

    public static boolean ewO() {
        AppMethodBeat.i(89760);
        if (Util.nullAsNil((Integer) g.aAh().azQ().get(143875, (Object) 0)) == 1) {
            AppMethodBeat.o(89760);
            return true;
        }
        AppMethodBeat.o(89760);
        return false;
    }

    public static void ewP() {
        AppMethodBeat.i(89761);
        g.aAh().azQ().set(143875, (Object) 1);
        AppMethodBeat.o(89761);
    }

    public static void ewQ() {
        AppMethodBeat.i(89762);
        g.aAh().azQ().set(143875, (Object) 0);
        AppMethodBeat.o(89762);
    }

    public static void aIt(String str) {
        AppMethodBeat.i(89763);
        bv aSN = ((l) g.af(l.class)).aSN();
        if (aSN.bjN(str)) {
            aSN.aNa(str);
        }
        bp.a(str, new bp.a() {
            /* class com.tencent.mm.plugin.nearby.a.b.AnonymousClass1 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                return false;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
            }
        });
        g.aAh().azQ().set(143873, "");
        g.aAh().azQ().set(143874, (Object) 0L);
        ewQ();
        AppMethodBeat.o(89763);
    }
}
