package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class b {
    public static amt t(String str, Map<String, String> map) {
        AppMethodBeat.i(103495);
        if (!map.containsKey(str)) {
            Log.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", str);
            AppMethodBeat.o(103495);
            return null;
        }
        amt amt = new amt();
        amt.iwc = Util.getInt(map.get(str + ".itemshowtype"), -1);
        amt.iwf = Util.getInt(map.get(str + ".ispaysubscribe"), -1);
        amt.iwe = Util.getInt(map.get(str + ".nativepage"), 0);
        amt.videoWidth = Util.getInt(map.get(str + ".width"), 0);
        amt.videoHeight = Util.getInt(map.get(str + ".height"), 0);
        amt.iwd = Util.getInt(map.get(str + ".pubtime"), 0);
        amt.duration = Util.getInt(map.get(str + ".duration"), 0);
        amt.iwg = Util.getInt(map.get(str + ".funcflag"), 0);
        amt.vid = map.get(str + ".vid");
        amt.dHc = map.get(str + ".srcusername");
        amt.iAg = map.get(str + ".srcdisplayname");
        amt.iAo = map.get(str + ".cover");
        AppMethodBeat.o(103495);
        return amt;
    }

    public static String a(amt amt) {
        AppMethodBeat.i(103496);
        StringBuffer stringBuffer = new StringBuffer();
        if (amt == null) {
            AppMethodBeat.o(103496);
            return "";
        }
        stringBuffer.append("<appmsgshareitem>");
        stringBuffer.append("<vid>").append(Util.escapeStringForXml(amt.vid)).append("</vid>");
        stringBuffer.append("<srcusername>").append(Util.escapeStringForXml(amt.dHc)).append("</srcusername>");
        stringBuffer.append("<srcdisplayname>").append(Util.escapeStringForXml(amt.iAg)).append("</srcdisplayname>");
        stringBuffer.append("<cover>").append(Util.escapeStringForXml(amt.iAo)).append("</cover>");
        stringBuffer.append("<itemshowtype>").append(amt.iwc).append("</itemshowtype>");
        stringBuffer.append("<ispaysubscribe>").append(amt.iwf).append("</ispaysubscribe>");
        stringBuffer.append("<nativepage>").append(amt.iwe).append("</nativepage>");
        stringBuffer.append("<width>").append(amt.videoWidth).append("</width>");
        stringBuffer.append("<height>").append(amt.videoHeight).append("</height>");
        stringBuffer.append("<pubtime>").append(amt.iwd).append("</pubtime>");
        stringBuffer.append("<duration>").append(amt.duration).append("</duration>");
        stringBuffer.append("<funcflag>").append(amt.iwg).append("</funcflag>");
        stringBuffer.append("</appmsgshareitem>");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(103496);
        return stringBuffer2;
    }

    public static amt u(String str, Map<String, String> map) {
        AppMethodBeat.i(103497);
        if (!map.containsKey(str)) {
            Log.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", str);
            AppMethodBeat.o(103497);
            return null;
        }
        amt amt = new amt();
        amt.vid = map.get(str + ".vid");
        amt.videoUrl = map.get(str + ".videourl");
        amt.KOe = map.get(str + ".mpurl");
        amt.dHc = map.get(str + ".bizusrname");
        amt.iAg = map.get(str + ".biznickname");
        amt.iAo = map.get(str + ".thumburl");
        amt.videoWidth = (int) Util.getFloat(map.get(str + ".thumbwidth"), 0.0f);
        amt.videoHeight = (int) Util.getFloat(map.get(str + ".thumbheight"), 0.0f);
        amt.duration = (int) Util.getFloat(map.get(str + ".duration"), 0.0f);
        AppMethodBeat.o(103497);
        return amt;
    }

    public static String b(amt amt) {
        AppMethodBeat.i(103498);
        StringBuffer stringBuffer = new StringBuffer();
        if (amt == null) {
            AppMethodBeat.o(103498);
            return "";
        }
        stringBuffer.append("<favbrandmpvideo>");
        stringBuffer.append("<vid>").append(Util.escapeStringForXml(amt.vid)).append("</vid>");
        stringBuffer.append("<videourl>").append(Util.escapeStringForXml(amt.videoUrl)).append("</videourl>");
        stringBuffer.append("<mpurl>").append(Util.escapeStringForXml(amt.KOe)).append("</mpurl>");
        stringBuffer.append("<bizusrname>").append(Util.escapeStringForXml(amt.dHc)).append("</bizusrname>");
        stringBuffer.append("<biznickname>").append(Util.escapeStringForXml(amt.iAg)).append("</biznickname>");
        stringBuffer.append("<thumburl>").append(Util.escapeStringForXml(amt.iAo)).append("</thumburl>");
        stringBuffer.append("<thumbwidth>").append(amt.videoWidth).append("</thumbwidth>");
        stringBuffer.append("<thumbheight>").append(amt.videoHeight).append("</thumbheight>");
        stringBuffer.append("<duration>").append(amt.duration).append("</duration>");
        stringBuffer.append("</favbrandmpvideo>");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(103498);
        return stringBuffer2;
    }
}
