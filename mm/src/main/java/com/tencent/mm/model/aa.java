package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class aa {
    private static Set<String> iCC = new HashSet();

    public static String Iq(String str) {
        AppMethodBeat.i(90675);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null) {
            AppMethodBeat.o(90675);
            return str;
        } else if (!Util.isNullOrNil(Kn.field_nickname)) {
            String str2 = Kn.field_nickname;
            AppMethodBeat.o(90675);
            return str2;
        } else if (ab.IR(str)) {
            AppMethodBeat.o(90675);
            return " ";
        } else {
            AppMethodBeat.o(90675);
            return str;
        }
    }

    public static String getDisplayName(String str, String str2) {
        AppMethodBeat.i(90676);
        if (Util.isNullOrNil(str2)) {
            String displayName = getDisplayName(str);
            AppMethodBeat.o(90676);
            return displayName;
        }
        String Is = Is(str);
        if (!Util.isNullOrNil(Is)) {
            AppMethodBeat.o(90676);
            return Is;
        }
        String ah = v.ah(str, str2);
        if (Util.isNullOrNil(ah)) {
            String displayName2 = getDisplayName(str);
            AppMethodBeat.o(90676);
            return displayName2;
        }
        AppMethodBeat.o(90676);
        return ah;
    }

    public static String Ir(String str) {
        AppMethodBeat.i(90677);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(90677);
            return "";
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        Log.d("MicroMsg.ContactCommDisplay", "username: %s", str);
        if (Kn == null) {
            AppMethodBeat.o(90677);
            return str;
        }
        if (ab.Eq(str) && Util.isNullOrNil(Kn.field_nickname)) {
            String displayName = ((c) g.af(c.class)).aSX().getDisplayName(str);
            if (!Util.isNullOrNil(displayName)) {
                AppMethodBeat.o(90677);
                return displayName;
            }
        }
        if (Kn.arI() != null && Kn.arI().length() > 0) {
            String arI = Kn.arI();
            AppMethodBeat.o(90677);
            return arI;
        } else if (ab.IR(str)) {
            AppMethodBeat.o(90677);
            return " ";
        } else {
            AppMethodBeat.o(90677);
            return str;
        }
    }

    public static String getDisplayName(String str) {
        AppMethodBeat.i(90678);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(90678);
            return "";
        }
        String b2 = b(((l) g.af(l.class)).aSN().Kn(str), str);
        AppMethodBeat.o(90678);
        return b2;
    }

    public static String b(as asVar, String str) {
        AppMethodBeat.i(186094);
        String a2 = a(asVar, str, ab.Eq(str));
        AppMethodBeat.o(186094);
        return a2;
    }

    public static String a(as asVar, String str, boolean z) {
        AppMethodBeat.i(90680);
        if (asVar == null) {
            AppMethodBeat.o(90680);
            return str;
        } else if (z && Util.isNullOrNil(asVar.field_nickname) && Util.isNullOrNil(asVar.field_conRemark)) {
            String displayName = ((c) g.af(c.class)).aSX().getDisplayName(str);
            AppMethodBeat.o(90680);
            return displayName;
        } else if (asVar.arJ() != null && asVar.arJ().length() > 0) {
            String arJ = asVar.arJ();
            AppMethodBeat.o(90680);
            return arJ;
        } else if (Util.isNullOrNil(asVar.field_nickname) && ab.JB(str)) {
            String Ew = com.tencent.mm.contact.c.Ew(str);
            AppMethodBeat.o(90680);
            return Ew;
        } else if (ab.IR(str)) {
            AppMethodBeat.o(90680);
            return " ";
        } else {
            AppMethodBeat.o(90680);
            return str;
        }
    }

    public static String Is(String str) {
        AppMethodBeat.i(90682);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null) {
            AppMethodBeat.o(90682);
            return "";
        } else if (!Util.isNullOrNil(Kn.field_conRemark)) {
            String str2 = Kn.field_conRemark;
            AppMethodBeat.o(90682);
            return str2;
        } else {
            AppMethodBeat.o(90682);
            return "";
        }
    }

    static {
        AppMethodBeat.i(90684);
        AppMethodBeat.o(90684);
    }

    public static void f(Set<String> set) {
        iCC = set;
    }

    public static String It(String str) {
        AppMethodBeat.i(90683);
        if (iCC.contains(str)) {
            AppMethodBeat.o(90683);
            return "";
        }
        AppMethodBeat.o(90683);
        return str;
    }

    public static String b(as asVar) {
        AppMethodBeat.i(90681);
        String displayName = getDisplayName(asVar.field_username);
        if (!ab.Eq(asVar.field_username)) {
            AppMethodBeat.o(90681);
            return displayName;
        } else if (displayName == null || displayName.equals(asVar.field_username)) {
            List<String> Kh = ((c) g.af(c.class)).aSX().Kh(asVar.field_username);
            if (Kh == null || Kh.size() <= 0) {
                String string = MMApplicationContext.getResources().getString(R.string.e6);
                AppMethodBeat.o(90681);
                return string;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : Kh) {
                arrayList.add(getDisplayName(str));
            }
            String str2 = "(" + Util.listToString(arrayList, ", ") + ")";
            AppMethodBeat.o(90681);
            return str2;
        } else {
            AppMethodBeat.o(90681);
            return displayName;
        }
    }
}
