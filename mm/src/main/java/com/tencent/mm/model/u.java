package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class u {
    public static List<Boolean> am(List<String> list) {
        boolean z;
        boolean z2;
        ca aES;
        AppMethodBeat.i(101736);
        if (list == null) {
            AppMethodBeat.o(101736);
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (!ab.Eq(str)) {
                z2 = false;
            } else {
                boolean z3 = false;
                long j2 = 0;
                az bjY = ((l) g.af(l.class)).aST().bjY(str);
                if (bjY != null) {
                    if (bjY.field_lastSeq != 0 && ((l) g.af(l.class)).eiy().aK(str, bjY.field_lastSeq).field_msgId == 0) {
                        j2 = bjY.field_lastSeq;
                        z3 = true;
                    }
                    if (bjY.field_firstUnDeliverSeq != 0) {
                        bjY.yD(0);
                        bjY.yC(0);
                        ((l) g.af(l.class)).aST().a(bjY, str);
                        Log.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
                    }
                }
                long j3 = j2;
                if (z3 || (aES = ((l) g.af(l.class)).eiy().aES(str)) == null || aES.field_msgId == 0) {
                    z = z3;
                } else {
                    z = true;
                }
                if (j3 == 0) {
                    j3 = ((l) g.af(l.class)).eiy().aER(str);
                }
                if (j3 != 0) {
                    ((l) g.af(l.class)).aTq().aG(str, j3);
                }
                Log.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", str, Boolean.valueOf(z), Long.valueOf(j3));
                z2 = z;
            }
            arrayList.add(Boolean.valueOf(z2));
        }
        AppMethodBeat.o(101736);
        return arrayList;
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3) {
        AppMethodBeat.i(101737);
        a(str, list, str2, z, str3, 2);
        AppMethodBeat.o(101737);
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3, int i2) {
        AppMethodBeat.i(101738);
        ca caVar = new ca();
        caVar.Cy(str);
        caVar.setType(10000);
        caVar.setCreateTime(System.currentTimeMillis());
        caVar.setStatus(4);
        caVar.nv(i2);
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            String aTY = z.aTY();
            String string = MMApplicationContext.getContext().getString(R.string.awt);
            for (String str4 : list) {
                if (!str4.equals(aTY)) {
                    as Kn = ((l) g.af(l.class)).aSN().Kn(str4);
                    if (Kn == null || ((int) Kn.gMZ) == 0) {
                        if (z) {
                            stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + str4 + "</a>" + string);
                        } else {
                            stringBuffer.append(str4 + string);
                        }
                    } else if (z) {
                        stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + o(Kn) + "</a>" + string);
                    } else {
                        stringBuffer.append(o(Kn) + string);
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(string));
            }
        }
        caVar.setContent(str2.replace("%s", stringBuffer));
        ((l) g.af(l.class)).eiy().aC(caVar);
        AppMethodBeat.o(101738);
    }

    private static String o(as asVar) {
        AppMethodBeat.i(101739);
        if (a.N(asVar)) {
            String O = a.O(asVar);
            if (O != null) {
                String str = asVar.arJ() + O;
                AppMethodBeat.o(101739);
                return str;
            }
            String arJ = asVar.arJ();
            AppMethodBeat.o(101739);
            return arJ;
        }
        String arJ2 = asVar.arJ();
        AppMethodBeat.o(101739);
        return arJ2;
    }

    public static boolean HQ(String str) {
        boolean z;
        AppMethodBeat.i(184632);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(184632);
            return false;
        }
        ArrayList<String> stringsToList = Util.stringsToList(str.split(","));
        if (stringsToList == null) {
            AppMethodBeat.o(184632);
            return false;
        }
        Iterator<String> it = stringsToList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!ab.Iu(it.next())) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        AppMethodBeat.o(184632);
        return z;
    }

    public static boolean HR(String str) {
        AppMethodBeat.i(101740);
        if (ab.Iu(str) || as.bjp(str)) {
            AppMethodBeat.o(101740);
            return true;
        }
        AppMethodBeat.o(101740);
        return false;
    }
}
