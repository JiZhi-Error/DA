package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class a {
    private static int iQQ = 0;
    private static int iQR = 0;

    public static String a(C0256a aVar) {
        AppMethodBeat.i(20473);
        if (aVar == null) {
            AppMethodBeat.o(20473);
            return "";
        }
        String str = "" + Util.nullAsNil(aVar.iRa) + "\n-------------------\n" + Util.nullAsNil(aVar.iQY) + "\n-------------------\n" + Util.nullAsNil(aVar.iQV);
        AppMethodBeat.o(20473);
        return str;
    }

    public static String b(C0256a aVar) {
        AppMethodBeat.i(20474);
        StringBuilder sb = new StringBuilder("");
        if (!z.Im(aVar.dRL)) {
            sb.append(aVar.iQS);
            sb.append(": ");
        }
        sb.append(Util.isNullOrNil(aVar.iRa) ? Util.isNullOrNil(aVar.iQY) ? aVar.iQV : aVar.iQY : aVar.iRa);
        String sb2 = sb.toString();
        AppMethodBeat.o(20474);
        return sb2;
    }

    /* renamed from: com.tencent.mm.am.a$a  reason: collision with other inner class name */
    public static class C0256a {
        private static final f<Integer, C0256a> gAU = new c(100);
        public String dRL;
        public String iQS;
        public String iQT;
        public String iQU;
        public String iQV;
        public String iQW;
        public String iQX;
        public String iQY;
        public String iQZ;
        public String iRa;
        public String toUser;

        static {
            AppMethodBeat.i(20472);
            AppMethodBeat.o(20472);
        }

        public static final C0256a NS(String str) {
            AppMethodBeat.i(20471);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.BrandQALogic", "empty xml to parse");
                AppMethodBeat.o(20471);
                return null;
            }
            int indexOf = str.indexOf("<qamsg");
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            int hashCode = str.hashCode();
            C0256a aVar = gAU.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                AppMethodBeat.o(20471);
                return aVar;
            }
            Map<String, String> parseXml = XmlParser.parseXml(str, "qamsg", null);
            if (parseXml == null) {
                Log.e("MicroMsg.BrandQALogic", "parse msg failed");
                AppMethodBeat.o(20471);
                return null;
            }
            try {
                C0256a aVar2 = new C0256a();
                aVar2.dRL = parseXml.get(".qamsg.$fromUser");
                aVar2.iQS = parseXml.get(".qamsg.$fromNickname");
                aVar2.toUser = parseXml.get(".qamsg.$title");
                aVar2.iQT = parseXml.get(".qamsg.question.$id");
                aVar2.iQU = parseXml.get(".qamsg.question.$fromUser");
                aVar2.iQV = parseXml.get(".qamsg.question.content");
                aVar2.iQW = parseXml.get(".qamsg.answer.$id");
                aVar2.iQX = parseXml.get(".qamsg.answer.$fromUser");
                aVar2.iQY = parseXml.get(".qamsg.answer.content");
                aVar2.iQW = parseXml.get(".qamsg.answer1.$id");
                aVar2.iQZ = parseXml.get(".qamsg.answer1.$fromUser");
                aVar2.iRa = parseXml.get(".qamsg.answer1.content");
                gAU.x(Integer.valueOf(hashCode), aVar2);
                AppMethodBeat.o(20471);
                return aVar2;
            } catch (Exception e2) {
                Log.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
                Log.printErrStackTrace("MicroMsg.BrandQALogic", e2, "", new Object[0]);
                AppMethodBeat.o(20471);
                return null;
            }
        }
    }
}
