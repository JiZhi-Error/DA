package com.tencent.mm.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    public static String d(as asVar) {
        if (asVar == null || asVar.fvc == 0) {
            return ",";
        }
        return "，";
    }

    public static String[] e(as asVar) {
        AppMethodBeat.i(116824);
        if (asVar == null) {
            AppMethodBeat.o(116824);
            return null;
        } else if (asVar.fuX != null) {
            String[] split = asVar.fuX.split(d(asVar));
            AppMethodBeat.o(116824);
            return split;
        } else {
            AppMethodBeat.o(116824);
            return null;
        }
    }

    public static String[] a(as asVar, String str) {
        AppMethodBeat.i(116825);
        if (str != null) {
            String[] split = str.split(d(asVar));
            AppMethodBeat.o(116825);
            return split;
        }
        AppMethodBeat.o(116825);
        return null;
    }

    public static String[] al(String str, String str2) {
        AppMethodBeat.i(116826);
        if (str != null) {
            String[] split = str.split(str2);
            AppMethodBeat.o(116826);
            return split;
        }
        AppMethodBeat.o(116826);
        return null;
    }

    public static String j(ArrayList<String> arrayList) {
        AppMethodBeat.i(116827);
        if (arrayList == null) {
            AppMethodBeat.o(116827);
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next()).append("，");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(116827);
        return stringBuffer2;
    }

    public static void a(as asVar, String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(116828);
        if (asVar == null) {
            asVar = ((l) g.af(l.class)).aSN().Kn(str);
        }
        if (asVar != null && ((int) asVar.gMZ) > 0 && c.oR(asVar.field_type)) {
            asVar.Ci(j(arrayList));
            g(asVar);
            ((l) g.af(l.class)).aSN().ao(asVar);
        }
        AppMethodBeat.o(116828);
    }

    public static int f(as asVar) {
        AppMethodBeat.i(116829);
        String[] e2 = e(asVar);
        if (e2 == null) {
            AppMethodBeat.o(116829);
            return 0;
        } else if (e2.length >= 5) {
            AppMethodBeat.o(116829);
            return 5;
        } else {
            int length = e2.length;
            AppMethodBeat.o(116829);
            return length;
        }
    }

    public static void g(as asVar) {
        AppMethodBeat.i(116830);
        if (asVar != null) {
            asVar.ajF();
        }
        AppMethodBeat.o(116830);
    }
}
