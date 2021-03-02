package com.tencent.mm.modelvideo;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.ugc.TXRecordCommon;

public final class a {
    public static void a(s sVar, int i2) {
        int i3;
        long j2;
        AppMethodBeat.i(126778);
        if (sVar == null) {
            Log.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
            AppMethodBeat.o(126778);
            return;
        }
        long currentTicks = Util.currentTicks();
        o.bhj();
        String Qw = t.Qw(sVar.getFileName());
        long j3 = 0;
        long j4 = 0;
        if (c.Sx(Qw)) {
            i3 = 1;
            b bVar = new b();
            j3 = bVar.Sw(Qw);
            if (bVar.jPZ != null) {
                j2 = bVar.jPZ.jPV;
            } else {
                j2 = 0;
            }
            j4 = j2;
        } else {
            Log.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
            i3 = 0;
        }
        long j5 = sVar.dTS;
        String Qn = s.Qn(sVar.bhv());
        StringBuilder sb = new StringBuilder();
        sb.append(j5).append(";").append(Qn).append(";");
        sb.append((long) sVar.iKP).append(";");
        sb.append(i3).append(";").append(j3).append(";");
        sb.append(j4).append(";").append(i2);
        String sb2 = sb.toString();
        Log.d("MicroMsg.AtomStatUtil", "report moov content : " + sb2 + " cost time: " + Util.ticksToNow(currentTicks));
        h.INSTANCE.a(11098, Integer.valueOf((int) TXRecordCommon.AUDIO_SAMPLERATE_8000), sb2);
        AppMethodBeat.o(126778);
    }

    public static void k(int i2, String str, String str2) {
        AppMethodBeat.i(126779);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
            AppMethodBeat.o(126779);
            return;
        }
        try {
            long boW = s.boW(str);
            long boW2 = s.boW(str2);
            StringBuilder sb = new StringBuilder();
            sb.append(i2).append(";").append(boW).append(";");
            sb.append(boW2).append(";").append((int) ((100 * boW2) / boW));
            String sb2 = sb.toString();
            Log.d("MicroMsg.AtomStatUtil", "report video remuxing : ".concat(String.valueOf(sb2)));
            h.INSTANCE.a(11098, Integer.valueOf((int) TXLiteAVCode.EVT_ROOM_REQUEST_IP_SUCC), sb2);
            AppMethodBeat.o(126779);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AtomStatUtil", e2, "", new Object[0]);
            Log.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + e2.toString());
            AppMethodBeat.o(126779);
        }
    }
}
