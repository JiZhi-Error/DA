package com.tencent.mm.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.Map;

public final class e {

    public static class a extends czh {
        public String QYI;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r0.length() > 0) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String cT(com.tencent.mm.storage.ca r4) {
        /*
            r3 = 117353(0x1ca69, float:1.64447E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            if (r4 != 0) goto L_0x000f
            java.lang.String r0 = ""
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x000e:
            return r0
        L_0x000f:
            int r0 = r4.field_isSend
            r1 = 1
            if (r0 != r1) goto L_0x001c
            java.lang.String r0 = com.tencent.mm.model.z.aTY()
        L_0x0018:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x000e
        L_0x001c:
            java.lang.String r1 = r4.field_talker
            boolean r0 = com.tencent.mm.model.ab.Eq(r1)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = r4.field_content
            java.lang.String r0 = com.tencent.mm.model.bp.Ks(r0)
            if (r1 == 0) goto L_0x0034
            if (r0 == 0) goto L_0x0034
            int r2 = r0.length()
            if (r2 > 0) goto L_0x0018
        L_0x0034:
            r0 = r1
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.util.e.cT(com.tencent.mm.storage.ca):java.lang.String");
    }

    public static String cU(ca caVar) {
        int Kp;
        int Kp2;
        AppMethodBeat.i(225998);
        if (caVar == null) {
            AppMethodBeat.o(225998);
            return "";
        }
        String str = caVar.field_content;
        if (str == null) {
            AppMethodBeat.o(225998);
            return "";
        } else if (cV(caVar)) {
            if (!(!ab.Eq(caVar.field_talker) || caVar.field_isSend == 1 || (Kp2 = bp.Kp(str)) == -1)) {
                str = str.substring(Kp2 + 1);
            }
            AppMethodBeat.o(225998);
            return str;
        } else {
            if (!(!ab.Eq(caVar.field_talker) || caVar.field_isSend == 1 || (Kp = bp.Kp(str)) == -1)) {
                str = str.substring(Kp + 1);
            }
            int indexOf = str.indexOf(60);
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            AppMethodBeat.o(225998);
            return str;
        }
    }

    public static String b(String str, Object obj, int i2) {
        AppMethodBeat.i(225999);
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(obj == null);
        objArr[2] = Integer.valueOf(i2);
        Log.i("MicroMsg.MsgUtil", "[mergeMsgSource] rawSource:%s args is null:%s flag:%s", objArr);
        if (!Util.isNullOrNil(str) && !str.startsWith("<msgsource>")) {
            Log.w("MicroMsg.MsgUtil", "[mergeMsgSource] WTF the msgsource is right? %s", str);
            AppMethodBeat.o(225999);
            return str;
        } else if ((i2 & 1) == 0 || !(obj instanceof HashMap)) {
            AppMethodBeat.o(225999);
            return str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            if (Util.isNullOrNil(str)) {
                stringBuffer.append("<msgsource>");
            }
            for (Map.Entry entry : ((HashMap) obj).entrySet()) {
                String str2 = (String) entry.getValue();
                String str3 = (String) entry.getKey();
                if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
                    Log.w("MicroMsg.MsgUtil", "%s %s", str3, str2);
                } else {
                    stringBuffer.append("<").append(str3).append(">");
                    stringBuffer.append(str2);
                    stringBuffer.append("</").append(str3).append(">");
                }
            }
            if (Util.isNullOrNil(str)) {
                stringBuffer.append("</msgsource>");
                String stringBuffer2 = stringBuffer.toString();
                AppMethodBeat.o(225999);
                return stringBuffer2;
            }
            String replace = str.replace("<msgsource>", "<msgsource>" + stringBuffer.toString());
            AppMethodBeat.o(225999);
            return replace;
        }
    }

    public static czg boC(String str) {
        AppMethodBeat.i(226000);
        czg czg = new czg();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(226000);
            return czg;
        } else if (!str.contains("appmsg")) {
            czg Y = Y("", XmlParser.parseXml(str, "patMsg", null));
            AppMethodBeat.o(226000);
            return Y;
        } else {
            czg Y2 = Y(".msg.appmsg", XmlParser.parseXml(str, "msg", null));
            AppMethodBeat.o(226000);
            return Y2;
        }
    }

    public static czg Y(String str, Map<String, String> map) {
        AppMethodBeat.i(226001);
        czg czg = new czg();
        if (map != null) {
            String str2 = Util.nullAsNil(str) + ".patMsg";
            czg.gnh = Util.nullAsNil(map.get(str2 + ".chatUser"));
            int safeParseInt = Util.safeParseInt(map.get(str2 + ".records.recordNum"));
            for (int i2 = 0; i2 < safeParseInt; i2++) {
                czh czh = new czh();
                String str3 = str2 + ".records.record";
                String str4 = i2 > 0 ? str3 + i2 : str3;
                czh.dRL = Util.nullAsNil(map.get(str4 + ".fromUser"));
                czh.MEA = Util.nullAsNil(map.get(str4 + ".pattedUser"));
                czh.iBd = Util.nullAsNil(map.get(str4 + ".template"));
                if (Util.isNullOrNil(czh.iBd)) {
                    czh.iBd = Util.nullAsNil(map.get(str4 + ".templete"));
                }
                czh.createTime = Util.safeParseLong(map.get(str4 + ".createTime"));
                czh.MEB = Util.safeParseInt(map.get(str4 + ".readStatus"));
                czh.oNJ = Util.safeParseLong(map.get(str4 + ".svrId"));
                czh.MEC = Util.safeParseInt(map.get(str4 + ".showModifyTip"));
                czg.yVw.add(czh);
            }
        }
        AppMethodBeat.o(226001);
        return czg;
    }

    private static boolean cV(ca caVar) {
        boolean z = false;
        AppMethodBeat.i(226002);
        if (caVar == null) {
            AppMethodBeat.o(226002);
        } else {
            switch (caVar.getType()) {
                case 1:
                case 11:
                case 21:
                case 31:
                case 36:
                case 301989937:
                    z = true;
                    break;
            }
            AppMethodBeat.o(226002);
        }
        return z;
    }
}
