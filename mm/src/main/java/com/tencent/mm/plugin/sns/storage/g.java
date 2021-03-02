package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Collections;

public final class g {
    public static boolean JG(long j2) {
        AppMethodBeat.i(97447);
        SnsInfo JJ = aj.faO().JJ(j2);
        if (JJ == null) {
            AppMethodBeat.o(97447);
            return false;
        }
        String[] split = ((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, "")).split("&");
        boolean z = split.length > 0 && Util.getBoolean(split[0], false);
        boolean z2 = split.length >= 2 && Util.getBoolean(split[1], false);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 2; i2 < split.length; i2++) {
            long j3 = Util.getLong(split[i2], 0);
            if (j3 != 0) {
                arrayList.add(Long.valueOf(j3));
            }
        }
        if (JJ.getTimeLine().ContentObj.LoU == 15) {
            if (!z) {
                z = true;
            } else {
                AppMethodBeat.o(97447);
                return false;
            }
        } else if (JJ.getTimeLine().ContentObj.LoU != 1) {
            AppMethodBeat.o(97447);
            return false;
        } else if (!z2) {
            z2 = true;
        } else {
            AppMethodBeat.o(97447);
            return false;
        }
        if (!arrayList.contains(Long.valueOf(j2))) {
            arrayList.add(Long.valueOf(j2));
        }
        StringBuilder append = new StringBuilder().append(z).append("&").append(z2);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            append.append("&").append(arrayList.get(i3));
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, append.toString());
        k(Long.valueOf(j2));
        AppMethodBeat.o(97447);
        return true;
    }

    public static void JH(long j2) {
        boolean z = true;
        AppMethodBeat.i(97448);
        String[] split = ((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, "")).split("&");
        boolean z2 = split.length > 0 && Util.getBoolean(split[0], false);
        if (split.length < 2 || !Util.getBoolean(split[1], false)) {
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 2; i2 < split.length; i2++) {
            long j3 = Util.getLong(split[i2], 0);
            if (j3 != 0) {
                arrayList.add(Long.valueOf(j3));
            }
        }
        arrayList.remove(Long.valueOf(j2));
        Collections.reverse(arrayList);
        k(arrayList.size() > 0 ? (Long) arrayList.get(0) : null);
        StringBuilder append = new StringBuilder().append(z2).append("&").append(z);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            append.append("&").append(arrayList.get(i3));
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SNS_MEDIA_COLLAPSE_STRING, append.toString());
        AppMethodBeat.o(97448);
    }

    public static void k(Long l) {
        AppMethodBeat.i(97449);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_SNS_MEDIA_COLLAPSE_SNS_ID_LONG, l);
        AppMethodBeat.o(97449);
    }
}
