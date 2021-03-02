package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import java.util.Iterator;

public final class a {
    public static int BlI = 0;
    public static int BlJ = 1;
    public static int BlK = 2;

    private static void a(String str, int i2, int i3, int i4, long j2, long j3, int i5, int i6, int i7, int i8, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(169760);
        Log.d("MicroMsg.Kv10298", "brandUsername:%s, scene:%s, brandType:%d, dataType:%d, enterTimestamp:%d, exitTimestamp:%d isAttention:%d, originalCount:%d, fansCount:%d, bindWeappCount:%d, showArticleList:%s, showFuwuList:%s decryptUserName:%s", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), str2, str3, str4);
        h.INSTANCE.a(10298, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), str2, str3, str4, Integer.valueOf(ab.getSessionId()), str5);
        AppMethodBeat.o(169760);
    }

    public static void a(String str, int i2, int i3, long j2, int i4, String str2) {
        AppMethodBeat.i(169761);
        a(str, i2, Vc(i3), 1, j2, 0, i4, 0, 0, 0, "", "", "", str2 != null ? str2 : "");
        AppMethodBeat.o(169761);
    }

    public static void a(String str, int i2, int i3, long j2, long j3, int i4, int i5, int i6, int i7, String str2, String str3, String str4) {
        AppMethodBeat.i(27588);
        a(str, i2, Vc(i3), 2, j2, j3, i4, i5, i6, i7, str2, str3, str4, "");
        AppMethodBeat.o(27588);
    }

    public static void a(String str, int i2, int i3, long j2, int i4, int i5, int i6, int i7, String str2, String str3, String str4) {
        AppMethodBeat.i(27589);
        a(str, i2, Vc(i3), 3, j2, 0, i4, i5, i6, i7, str2, str3, str4, "");
        AppMethodBeat.o(27589);
    }

    private static int Vc(int i2) {
        if (i2 == 0) {
            return BlJ;
        }
        if (i2 == 1) {
            return BlK;
        }
        return BlI;
    }

    public static String c(ov ovVar) {
        AppMethodBeat.i(27590);
        if (ovVar == null) {
            AppMethodBeat.o(27590);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<ou> it = ovVar.KVw.iterator();
        while (it.hasNext()) {
            ou next = it.next();
            if (next.KVq != null) {
                long j2 = (long) next.KVq.Brl;
                if (next.KVv == null) {
                    sb.append(j2).append(";");
                } else if (next.KVv.KSK != null) {
                    Iterator<nh> it2 = next.KVv.KSK.iterator();
                    while (it2.hasNext()) {
                        sb.append(j2).append("#").append(it2.next().KSi).append(";");
                    }
                }
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        AppMethodBeat.o(27590);
        return sb2;
    }

    public static String a(py pyVar) {
        AppMethodBeat.i(27591);
        if (pyVar == null || pyVar.KWP == null || pyVar.KWP.KWS == null) {
            AppMethodBeat.o(27591);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<qa> it = pyVar.KWP.KWS.iterator();
        while (it.hasNext()) {
            qa next = it.next();
            sb.append(next.id + "#" + next.key + ";");
            if (next.KWT != null) {
                Iterator<qa> it2 = next.KWT.iterator();
                while (it2.hasNext()) {
                    qa next2 = it2.next();
                    sb.append(next2.id + "#" + next2.key + ";");
                }
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        AppMethodBeat.o(27591);
        return sb2;
    }
}
