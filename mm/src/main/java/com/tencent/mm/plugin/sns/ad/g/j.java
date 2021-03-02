package com.tencent.mm.plugin.sns.ad.g;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class j {
    public static void a(String str, m mVar) {
        AppMethodBeat.i(94985);
        SnsInfo aQl = aj.faO().aQl(str);
        if (aQl != null) {
            TimeLineObject timeLine = aQl.getTimeLine();
            if (timeLine != null) {
                p.a(timeLine.statExtStr, mVar);
                AppMethodBeat.o(94985);
                return;
            }
            Log.v("SnsAdExtUtil", "timeLineObject null, snsId %s", str);
            AppMethodBeat.o(94985);
            return;
        }
        Log.v("SnsAdExtUtil", "snsInfo null, snsId %s", str);
        AppMethodBeat.o(94985);
    }

    public static String a(long j2, Object... objArr) {
        AppMethodBeat.i(94986);
        aj.faI();
        StringBuilder sb = new StringBuilder(m.u(objArr));
        a(j2, sb);
        String sb2 = sb.toString();
        AppMethodBeat.o(94986);
        return sb2;
    }

    public static void a(long j2, StringBuilder sb) {
        AppMethodBeat.i(94987);
        AdSnsInfo JE = aj.faR().JE(j2);
        if (JE != null) {
            TimeLineObject timeLine = JE.getTimeLine();
            if (timeLine != null) {
                p.a(timeLine.statExtStr, sb);
                AppMethodBeat.o(94987);
                return;
            }
            Log.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", Long.valueOf(j2));
            sb.append(",,");
            AppMethodBeat.o(94987);
            return;
        }
        Log.v("SnsAdExtUtil", "l snsInfo null, snsId %d", Long.valueOf(j2));
        sb.append(",,");
        AppMethodBeat.o(94987);
    }

    public static String b(TimeLineObject timeLineObject) {
        AppMethodBeat.i(94988);
        if (timeLineObject != null) {
            String aNL = aNL(timeLineObject.statExtStr);
            AppMethodBeat.o(94988);
            return aNL;
        }
        Log.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
        AppMethodBeat.o(94988);
        return null;
    }

    private static String aNL(String str) {
        AppMethodBeat.i(94989);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(94989);
            return "";
        }
        byte[] decode = Base64.decode(str, 0);
        eco eco = new eco();
        try {
            eco.parseFrom(decode);
            String a2 = p.a(eco.NcH);
            AppMethodBeat.o(94989);
            return a2;
        } catch (IOException e2) {
            Log.e("SnsAdExtUtil", "", e2);
            AppMethodBeat.o(94989);
            return "";
        }
    }
}
