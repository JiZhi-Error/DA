package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class br {
    public static int iEW = 0;
    private static ConcurrentHashMap<Long, String> iEX = new ConcurrentHashMap<>();
    private static int iEY = 1;
    private static float iEZ = 0.75f;
    private static float iFa = 0.4f;
    private static float iFb = 0.5f;

    static {
        AppMethodBeat.i(150189);
        AppMethodBeat.o(150189);
    }

    public static void I(String str, boolean z) {
        AppMethodBeat.i(150170);
        if ("bizflag".equals(str)) {
            if (z) {
                iEW |= 1;
                AppMethodBeat.o(150170);
                return;
            }
            iEW &= -2;
        }
        AppMethodBeat.o(150170);
    }

    public static String aVV() {
        AppMethodBeat.i(150171);
        StringBuilder sb = new StringBuilder();
        if (iEW != 0) {
            sb.append("<");
            sb.append("bizflag");
            sb.append(">");
            sb.append(iEW);
            sb.append("</");
            sb.append("bizflag");
            sb.append(">");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(150171);
        return sb2;
    }

    public static int A(ca caVar) {
        int i2;
        AppMethodBeat.i(150172);
        if (caVar == null) {
            AppMethodBeat.o(150172);
            return 0;
        }
        Map<String, String> parseXml = XmlParser.parseXml(caVar.fqK, "msgsource", null);
        if (parseXml != null) {
            String str = parseXml.get(".msgsource.bizflag");
            if (!Util.isNullOrNil(str)) {
                i2 = Util.getInt(str, 0);
                AppMethodBeat.o(150172);
                return i2;
            }
        }
        i2 = 0;
        AppMethodBeat.o(150172);
        return i2;
    }

    public static String ajw() {
        AppMethodBeat.i(150173);
        StringBuilder sb = new StringBuilder();
        sb.append(Util.nullAsNil(aVV()));
        if (sb.length() > 0) {
            sb.insert(0, "<msgsource>");
            sb.append("</msgsource>");
            String sb2 = sb.toString();
            AppMethodBeat.o(150173);
            return sb2;
        }
        AppMethodBeat.o(150173);
        return null;
    }

    public static boolean B(ca caVar) {
        Map<String, String> parseXml;
        AppMethodBeat.i(150174);
        if (caVar == null || Util.isNullOrNil(caVar.fqK) || (parseXml = XmlParser.parseXml(caVar.fqK, "msgsource", null)) == null || Util.safeParseInt(parseXml.get(".msgsource.sec_msg_node.sfn")) != 1) {
            AppMethodBeat.o(150174);
            return false;
        }
        AppMethodBeat.o(150174);
        return true;
    }

    public static void b(int i2, float f2, float f3, float f4) {
        iEY = i2;
        iEZ = f2;
        iFa = f3;
        iFb = f4;
    }

    public static int C(ca caVar) {
        Map<String, String> parseXml;
        AppMethodBeat.i(225951);
        if (iEY == 0) {
            AppMethodBeat.o(225951);
            return 0;
        } else if (caVar == null || Util.isNullOrNil(caVar.fqK) || (parseXml = XmlParser.parseXml(caVar.fqK, "msgsource", null)) == null) {
            AppMethodBeat.o(225951);
            return 0;
        } else {
            int i2 = Util.getInt(parseXml.get(".msgsource.sec_msg_node.media-to-emoji"), 0);
            AppMethodBeat.o(225951);
            return i2;
        }
    }

    public static boolean D(ca caVar) {
        AppMethodBeat.i(225952);
        if (C(caVar) > 0) {
            AppMethodBeat.o(225952);
            return true;
        }
        AppMethodBeat.o(225952);
        return false;
    }

    public static boolean E(ca caVar) {
        AppMethodBeat.i(225953);
        int C = C(caVar);
        if (C == 2 || C == 4) {
            AppMethodBeat.o(225953);
            return true;
        }
        AppMethodBeat.o(225953);
        return false;
    }

    public static boolean F(ca caVar) {
        AppMethodBeat.i(225954);
        int C = C(caVar);
        if (C == 3 || C == 4) {
            AppMethodBeat.o(225954);
            return true;
        }
        AppMethodBeat.o(225954);
        return false;
    }

    public static float G(ca caVar) {
        AppMethodBeat.i(225955);
        if (!D(caVar)) {
            AppMethodBeat.o(225955);
            return 1.0f;
        }
        float f2 = iEZ;
        AppMethodBeat.o(225955);
        return f2;
    }

    public static float H(ca caVar) {
        AppMethodBeat.i(225956);
        if (!D(caVar)) {
            AppMethodBeat.o(225956);
            return 1.0f;
        }
        float f2 = iFa;
        AppMethodBeat.o(225956);
        return f2;
    }

    public static float I(ca caVar) {
        AppMethodBeat.i(225957);
        if (!D(caVar)) {
            AppMethodBeat.o(225957);
            return 1.0f;
        }
        float f2 = iFb;
        AppMethodBeat.o(225957);
        return f2;
    }

    public static boolean J(ca caVar) {
        AppMethodBeat.i(150175);
        if (caVar != null) {
            int P = P(caVar);
            if (caVar.isText() && P >= 3) {
                AppMethodBeat.o(150175);
                return true;
            } else if (caVar.gAz() && P >= 2) {
                AppMethodBeat.o(150175);
                return true;
            }
        }
        AppMethodBeat.o(150175);
        return false;
    }

    public static boolean K(ca caVar) {
        AppMethodBeat.i(150176);
        if (caVar != null) {
            int P = P(caVar);
            if (caVar.isText() && P > 3) {
                AppMethodBeat.o(150176);
                return true;
            } else if (caVar.gAz() && P > 2) {
                AppMethodBeat.o(150176);
                return true;
            }
        }
        AppMethodBeat.o(150176);
        return false;
    }

    public static void L(ca caVar) {
        Map<String, String> parseXml;
        AppMethodBeat.i(150177);
        if (caVar != null && !Util.isNullOrNil(caVar.fqK) && (parseXml = XmlParser.parseXml(caVar.fqK, "msgsource", null)) != null && Util.safeParseInt(parseXml.get(".msgsource.sec_msg_node.sfn")) == 1) {
            try {
                String substring = caVar.fqK.substring(caVar.fqK.indexOf("<sec_msg_node"), caVar.fqK.indexOf("</sec_msg_node") + 12 + 2);
                Log.i("MicroMsg.MsgSourceHelper", substring);
                if (!Util.isNullOrNil(substring)) {
                    caVar.BB(caVar.fqK.replace(substring, substring.replace(substring.substring(substring.indexOf("<sfn"), substring.indexOf("</sfn") + 3 + 2), "<sfn>0<sfn/>")));
                }
                AppMethodBeat.o(150177);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MsgSourceHelper", e2, "resetShareForbidden msg exception", new Object[0]);
            }
        }
        AppMethodBeat.o(150177);
    }

    @Deprecated
    public static String M(ca caVar) {
        Map<String, String> parseXml;
        AppMethodBeat.i(150178);
        if (!(caVar == null || Util.isNullOrNil(caVar.fqK) || (parseXml = XmlParser.parseXml(caVar.fqK, "msgsource", null)) == null)) {
            String str = parseXml.get(".msgsource.sec_msg_node.show-h5");
            if (!Util.isNullOrNil(str)) {
                AppMethodBeat.o(150178);
                return str;
            }
        }
        AppMethodBeat.o(150178);
        return "";
    }

    public static String N(ca caVar) {
        Map<String, String> parseXml;
        AppMethodBeat.i(150179);
        if (!(caVar == null || Util.isNullOrNil(caVar.fqK) || (parseXml = XmlParser.parseXml(caVar.fqK, "msgsource", null)) == null)) {
            String str = parseXml.get(".msgsource.sec_msg_node.share-tip-url");
            if (!Util.isNullOrNil(str)) {
                AppMethodBeat.o(150179);
                return str;
            }
        }
        AppMethodBeat.o(150179);
        return "";
    }

    public static int O(ca caVar) {
        Map<String, String> parseXml;
        AppMethodBeat.i(150180);
        if (caVar == null || Util.isNullOrNil(caVar.fqK) || (parseXml = XmlParser.parseXml(caVar.fqK, "msgsource", null)) == null) {
            AppMethodBeat.o(150180);
            return 0;
        }
        int safeParseInt = Util.safeParseInt(parseXml.get(".msgsource.sec_msg_node.clip-len"));
        AppMethodBeat.o(150180);
        return safeParseInt;
    }

    public static void a(ca caVar, int i2) {
        Map<String, String> parseXml;
        AppMethodBeat.i(163510);
        if (!(caVar == null || Util.isNullOrNil(caVar.fqK) || (parseXml = XmlParser.parseXml(caVar.fqK, "msgsource", null)) == null)) {
            parseXml.put(".msgsource.sec_msg_node.clip-len", String.valueOf(i2));
            a(caVar, A(parseXml));
        }
        AppMethodBeat.o(163510);
    }

    public static int P(ca caVar) {
        Map<String, String> parseXml;
        AppMethodBeat.i(150182);
        if (caVar == null || Util.isNullOrNil(caVar.fqK) || (parseXml = XmlParser.parseXml(caVar.fqK, "msgsource", null)) == null) {
            AppMethodBeat.o(150182);
            return 0;
        }
        int safeParseInt = Util.safeParseInt(parseXml.get(".msgsource.sec_msg_node.fold-reduce"));
        AppMethodBeat.o(150182);
        return safeParseInt;
    }

    public static boolean Q(ca caVar) {
        Map<String, String> parseXml;
        AppMethodBeat.i(225958);
        if (caVar == null || Util.isNullOrNil(caVar.fqK) || (parseXml = XmlParser.parseXml(caVar.fqK, "msgsource", null)) == null) {
            AppMethodBeat.o(225958);
            return false;
        } else if (Util.safeParseInt(parseXml.get(".msgsource.sec_msg_node.block-range")) != 0) {
            AppMethodBeat.o(225958);
            return true;
        } else {
            AppMethodBeat.o(225958);
            return false;
        }
    }

    public static void d(long j2, String str) {
        AppMethodBeat.i(150183);
        if (j2 > 0 && !Util.isNullOrNil(str)) {
            iEX.put(Long.valueOf(j2), str);
        }
        AppMethodBeat.o(150183);
    }

    public static void E(String str, long j2) {
        AppMethodBeat.i(150184);
        if (!Util.isNullOrNil(str) && j2 > 0 && iEX.containsKey(Long.valueOf(j2))) {
            ca aJ = ((l) g.af(l.class)).eiy().aJ(str, j2);
            if (!Util.isNullOrNil(aJ.field_talker) && aJ.field_msgSvrId > 0) {
                Log.i("MicroMsg.MsgSourceHelper", "found sec msg of %s", Long.valueOf(j2));
                a(aJ, iEX.get(Long.valueOf(j2)));
                iEX.remove(Long.valueOf(j2));
            }
        }
        AppMethodBeat.o(150184);
    }

    public static String A(Map<String, String> map) {
        AppMethodBeat.i(150185);
        int safeParseInt = Util.safeParseInt(map.get(".msgsource.sec_msg_node.sfn"));
        String nullAsNil = Util.nullAsNil(map.get(".msgsource.sec_msg_node.show-h5"));
        int safeParseInt2 = Util.safeParseInt(map.get(".msgsource.sec_msg_node.clip-len"));
        String nullAsNil2 = Util.nullAsNil(map.get(".msgsource.sec_msg_node.share-tip-url"));
        int safeParseInt3 = Util.safeParseInt(map.get(".msgsource.sec_msg_node.fold-reduce"));
        int safeParseInt4 = Util.safeParseInt(map.get(".msgsource.sec_msg_node.media-to-emoji"));
        int safeParseInt5 = Util.safeParseInt(map.get(".msgsource.sec_msg_node.block-range"));
        StringBuilder sb = new StringBuilder();
        sb.append("<sec_msg_node>");
        sb.append("<sfn>").append(safeParseInt).append("</sfn>");
        sb.append("<show-h5><![CDATA[").append(nullAsNil).append("]]></show-h5>");
        sb.append("<clip-len>").append(safeParseInt2).append("</clip-len>");
        sb.append("<share-tip-url><![CDATA[").append(nullAsNil2).append("]]></share-tip-url>");
        sb.append("<fold-reduce>").append(safeParseInt3).append("</fold-reduce>");
        sb.append("<media-to-emoji>").append(safeParseInt4).append("</media-to-emoji>");
        sb.append("<block-range>").append(safeParseInt5).append("</block-range>");
        sb.append("</sec_msg_node>");
        String sb2 = sb.toString();
        AppMethodBeat.o(150185);
        return sb2;
    }

    public static void a(ca caVar, String str) {
        AppMethodBeat.i(163511);
        if (caVar != null) {
            String str2 = caVar.fqK;
            if (Util.isNullOrNil(str2) || !str2.trim().startsWith("<msgsource>")) {
                str2 = "<msgsource></msgsource>";
            }
            caVar.BB(str2.replaceAll("(?s)<sec_msg_node[^>]*>.*?</sec_msg_node>", "").replace("</msgsource>", str + "</msgsource>"));
            ((l) g.af(l.class)).eiy().b(caVar.field_msgSvrId, caVar);
        }
        AppMethodBeat.o(163511);
    }

    public static String B(Map<String, String> map) {
        AppMethodBeat.i(163513);
        int safeParseInt = Util.safeParseInt(map.get(".msgsource.alnode.cf"));
        StringBuilder sb = new StringBuilder();
        sb.append("<alnode>");
        sb.append("<cf>").append(safeParseInt).append("</cf>");
        sb.append("</alnode>");
        String sb2 = sb.toString();
        AppMethodBeat.o(163513);
        return sb2;
    }

    public static String aVW() {
        AppMethodBeat.i(150187);
        String str = (String) g.aAh().azQ().get(70, (Object) null);
        if (!Util.isNullOrNil(str)) {
            g.aAh().azQ().set(70, "");
        }
        Log.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", str);
        StringBuilder sb = new StringBuilder();
        sb.append("<msgsource>");
        sb.append(Util.nullAsNil(str));
        if (iEW != 0) {
            sb.append("<");
            sb.append("bizflag");
            sb.append(">");
            sb.append(iEW);
            sb.append("</");
            sb.append("bizflag");
            sb.append(">");
        }
        sb.append("</msgsource>");
        String sb2 = sb.toString();
        if ("<msgsource></msgsource>".equals(sb2)) {
            AppMethodBeat.o(150187);
            return "";
        }
        Log.d("MicroMsg.MsgSourceHelper", "getAndResetMsgSrcIn msgsource[%s]", sb2);
        AppMethodBeat.o(150187);
        return sb2;
    }

    public static void KA(String str) {
        AppMethodBeat.i(150188);
        Log.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", str, "");
        AppMethodBeat.o(150188);
    }

    public static String KB(String str) {
        AppMethodBeat.i(163514);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(163514);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "msgsource", null);
        if (parseXml != null) {
            String str2 = parseXml.get(".msgsource.sec_msg_node.uuid");
            AppMethodBeat.o(163514);
            return str2;
        }
        AppMethodBeat.o(163514);
        return null;
    }

    public static String KC(String str) {
        AppMethodBeat.i(163515);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(163515);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<msgsource><sec_msg_node><uuid>").append(str).append("</uuid></sec_msg_node></msgsource>");
        String sb2 = sb.toString();
        AppMethodBeat.o(163515);
        return sb2;
    }

    public static void b(ca caVar, String str) {
        AppMethodBeat.i(163512);
        String str2 = caVar.fqK;
        if (Util.isNullOrNil(str2) || !str2.trim().startsWith("<msgsource>")) {
            str2 = "<msgsource></msgsource>";
        }
        caVar.BB(str2.replaceAll("(?s)<alnode[^>]*>.*?</alnode>", "").replace("</msgsource>", str + "</msgsource>"));
        AppMethodBeat.o(163512);
    }
}
