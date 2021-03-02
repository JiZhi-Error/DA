package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.s;
import java.util.Map;

public final class h {
    public static g a(g gVar) {
        AppMethodBeat.i(150554);
        if (gVar == null) {
            AppMethodBeat.o(150554);
            return null;
        } else if (gVar.bcv()) {
            g tl = q.bcR().tl(gVar.iXx);
            if (tl == null) {
                AppMethodBeat.o(150554);
                return gVar;
            }
            AppMethodBeat.o(150554);
            return tl;
        } else {
            AppMethodBeat.o(150554);
            return gVar;
        }
    }

    public static boolean b(g gVar) {
        AppMethodBeat.i(150555);
        if (gVar == null) {
            AppMethodBeat.o(150555);
            return false;
        }
        int i2 = gVar.offset;
        int i3 = gVar.iKP;
        long j2 = gVar.dTS;
        if (gVar.bcv()) {
            g tl = q.bcR().tl(gVar.iXx);
            i2 = tl.offset;
            i3 = tl.iKP;
            j2 = tl.dTS;
        }
        if (i3 == 0) {
            AppMethodBeat.o(150555);
            return true;
        } else if ((i2 != i3 || i3 == 0) && j2 == 0) {
            AppMethodBeat.o(150555);
            return false;
        } else {
            AppMethodBeat.o(150555);
            return true;
        }
    }

    public static String c(g gVar) {
        AppMethodBeat.i(150556);
        if (gVar == null) {
            AppMethodBeat.o(150556);
            return "";
        } else if (gVar.bcv()) {
            g tl = q.bcR().tl(gVar.iXx);
            if (tl == null) {
                AppMethodBeat.o(150556);
                return "";
            }
            String str = tl.iXm;
            AppMethodBeat.o(150556);
            return str;
        } else {
            String str2 = gVar.iXm;
            AppMethodBeat.o(150556);
            return str2;
        }
    }

    public static String c(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(150557);
        String str5 = null;
        if (!Util.isNullOrNil(str)) {
            str5 = String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", str, Util.nullAsNil(str2), Util.nullAsNil(str3), Util.nullAsNil(str4));
        }
        AppMethodBeat.o(150557);
        return str5;
    }

    public static final a Ov(String str) {
        AppMethodBeat.i(150558);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150558);
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
        if (parseXml == null) {
            Log.e("MicroMsg.ImgInfoLogic", "parseImg failed");
            AppMethodBeat.o(150558);
            return null;
        }
        a aVar = new a();
        aVar.appId = parseXml.get(".msg.appinfo.appid");
        aVar.mediaTagName = parseXml.get(".msg.appinfo.mediatagname");
        aVar.messageExt = parseXml.get(".msg.appinfo.messageext");
        aVar.messageAction = parseXml.get(".msg.appinfo.messageaction");
        AppMethodBeat.o(150558);
        return aVar;
    }

    public static String Ow(String str) {
        AppMethodBeat.i(150559);
        if (!s.YS(str)) {
            AppMethodBeat.o(150559);
            return null;
        }
        String messageDigest = g.getMessageDigest((str + "-" + s.boW(str)).getBytes());
        AppMethodBeat.o(150559);
        return messageDigest;
    }
}
