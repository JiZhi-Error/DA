package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.b;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.Map;

public final class d {
    public static String cPV() {
        AppMethodBeat.i(169348);
        b.cPO();
        Pair<String, String> cPS = b.cPS();
        if (cPS == null) {
            AppMethodBeat.o(169348);
            return null;
        }
        String str = (String) cPS.first;
        String str2 = (String) cPS.second;
        StringBuilder sb = new StringBuilder();
        sb.append(aqm(str)).append("#");
        Map<Long, Long> aqj = b.aqj(str);
        if (aqj != null && !aqj.isEmpty()) {
            for (Map.Entry<Long, Long> entry : aqj.entrySet()) {
                sb.append(entry.getKey()).append("_").append(entry.getValue()).append("|");
            }
        }
        a aVar = a.sHW;
        List<bgb> aqb = a.aqb(str);
        if (aqb != null) {
            Log.i("HABBYGE-MALI.SessionPageCollector", "realGetSessionPageId, matchingPathList: %d", Integer.valueOf(aqb.size()));
            for (bgb bgb : aqb) {
                if (bgb.LPK.size() > 0) {
                    sb.append(bgb.LPN).append("_").append(bgb.LPK.get(0).startTime).append("|");
                }
            }
        }
        String sb2 = sb.toString();
        if (sb2.endsWith("|")) {
            sb2 = sb2.substring(0, sb2.length() - 1);
        }
        String str3 = sb2 + "$" + aql(str2);
        AppMethodBeat.o(169348);
        return str3;
    }

    private static String aql(String str) {
        AppMethodBeat.i(185584);
        if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqA(str)) {
            String str2 = aqm(str) + "#";
            AppMethodBeat.o(185584);
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aqm(str)).append("#");
        Map<Long, Long> aqk = b.aqk(str);
        if (aqk != null && !aqk.isEmpty()) {
            for (Map.Entry<Long, Long> entry : aqk.entrySet()) {
                sb.append(entry.getKey()).append("_").append(entry.getValue()).append("|");
            }
        }
        a aVar = a.sHW;
        List<bgb> aqc = a.aqc(str);
        Log.i("HABBYGE-MALI.SessionPageCollector", "getLastSessionPagePath, matchedPathList: %d", Integer.valueOf(aqc.size()));
        for (bgb bgb : aqc) {
            if (bgb.LPK.size() > 0) {
                sb.append(bgb.LPN).append("_").append(bgb.LPK.get(0).startTime).append("|");
            }
        }
        String sb2 = sb.toString();
        if (sb2.endsWith("|")) {
            sb2 = sb2.substring(0, sb2.length() - 1);
        }
        AppMethodBeat.o(185584);
        return sb2;
    }

    private static String aqm(String str) {
        AppMethodBeat.i(185585);
        if (str == null) {
            AppMethodBeat.o(185585);
            return null;
        }
        int lastIndexOf = str.lastIndexOf("_");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length() - 1) {
            String aqy = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqy(str);
            AppMethodBeat.o(185585);
            return aqy;
        }
        String substring = str.substring(0, lastIndexOf);
        String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqy(substring) + "_" + str.substring(lastIndexOf + 1);
        AppMethodBeat.o(185585);
        return str2;
    }
}
