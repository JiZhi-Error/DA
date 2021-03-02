package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class e {
    private static final f<Integer, e> gAU = new c(100);
    public int FJX;
    public int FJY;
    public String FJZ;
    public int FKa;
    public int FKb;
    public int FKc;
    public int FKd;
    public String dCK;
    public int iwI;
    public String iwJ;

    static {
        AppMethodBeat.i(28961);
        AppMethodBeat.o(28961);
    }

    public static e aSK(String str) {
        AppMethodBeat.i(28960);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(28960);
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        int hashCode = str.hashCode();
        e eVar = gAU.get(Integer.valueOf(hashCode));
        if (eVar != null) {
            AppMethodBeat.o(28960);
            return eVar;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
        if (parseXml == null) {
            Log.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
            AppMethodBeat.o(28960);
            return null;
        }
        try {
            e eVar2 = new e();
            eVar2.iwI = Util.getInt(parseXml.get(".msg.appmsg.appattach.totallen"), 0);
            eVar2.dCK = parseXml.get(".msg.appmsg.appattach.attachid");
            eVar2.iwJ = parseXml.get(".msg.appmsg.appattach.fileext");
            eVar2.FJX = Util.getInt(parseXml.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
            eVar2.FJY = Util.getInt(parseXml.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
            eVar2.FJZ = parseXml.get(".msg.appmsg.voicecmd.reminder.$remindattachid");
            eVar2.FKa = Util.getInt(parseXml.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
            eVar2.FKb = Util.getInt(parseXml.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
            eVar2.FKc = Util.getInt(parseXml.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
            eVar2.FKd = Util.getInt(parseXml.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
            gAU.x(Integer.valueOf(hashCode), eVar2);
            AppMethodBeat.o(28960);
            return eVar2;
        } catch (Exception e2) {
            Log.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
            Log.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", e2, "", new Object[0]);
            AppMethodBeat.o(28960);
            return null;
        }
    }
}
