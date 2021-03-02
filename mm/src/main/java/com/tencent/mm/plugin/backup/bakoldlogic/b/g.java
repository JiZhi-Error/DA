package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.b.i;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g implements j {
    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    public final int a(is isVar, ca caVar, String str, LinkedList<u> linkedList) {
        boolean z;
        int i2;
        int i3;
        AppMethodBeat.i(231602);
        b.chw().chx().bhj();
        String Qw = t.Qw(caVar.field_imgPath);
        s agI = d.agI(caVar.field_imgPath);
        if (agI == null || agI.status == 199) {
            z = true;
        } else {
            z = false;
        }
        o oVar = new o(Qw);
        if (!z || !oVar.exists()) {
            i2 = 0;
        } else {
            i2 = (int) oVar.length();
        }
        int i4 = 0;
        b.chw().chx().bhj();
        String Qx = t.Qx(caVar.field_imgPath);
        o oVar2 = new o(Qx);
        if (oVar2.exists()) {
            i4 = (int) oVar2.length();
        }
        int i5 = 0;
        if (i4 != 0) {
            if (caVar.getType() == 62) {
                i5 = i.a(new i.a(Qx, isVar, linkedList, 13, false, "_thumb", false)) + 0;
            } else {
                i5 = i.a(new i.a(Qx, isVar, linkedList, 11, false, "_thumb", false)) + 0;
            }
        }
        if (!z || i2 == 0) {
            i3 = i5;
        } else if (caVar.getType() == 62) {
            i3 = i.a(new i.a(Qw, isVar, linkedList, 12, false, false, (u) null)) + i5;
        } else {
            i3 = i.a(new i.a(Qw, isVar, linkedList, 10, false, false, (u) null)) + i5;
        }
        String a2 = a(isVar, caVar);
        if (a2 == null) {
            AppMethodBeat.o(231602);
            return i3;
        }
        isVar.KHn = new dqi().bhy(a2);
        int length = i3 + a2.length();
        AppMethodBeat.o(231602);
        return length;
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    public final int a(String str, is isVar, ca caVar) {
        String a2;
        int i2;
        AppMethodBeat.i(21851);
        s sVar = new s();
        sVar.dWq = isVar.KHl.MTo;
        sVar.createTime = caVar.field_createTime;
        sVar.dTS = isVar.Brn;
        String str2 = isVar.KHn.MTo;
        Log.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:".concat(String.valueOf(str2)));
        Map<String, String> parseXml = XmlParser.parseXml(str2, "msg", null);
        if (parseXml != null) {
            try {
                sVar.iKP = a.cv(parseXml.get(".msg.videomsg.$length"), 0);
                sVar.iFw = a.cv(parseXml.get(".msg.videomsg.$playlength"), 0);
                sVar.jsh = parseXml.get(".msg.videomsg.$fromusername");
                int cv = a.cv(parseXml.get(".msg.videomsg.$type"), 0);
                Log.d("MicroMsg.BakOldItemVideo", "video msg exportType :".concat(String.valueOf(cv)));
                if (cv == 44) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                sVar.jsr = i2;
            } catch (Exception e2) {
                Log.e("MicroMsg.BakOldItemVideo", "parsing voice msg xml failed");
                Log.printErrStackTrace("MicroMsg.BakOldItemVideo", e2, "", new Object[0]);
            }
        } else {
            Log.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", isVar.KHn.MTo);
            caVar.setContent(isVar.KHn.MTo);
        }
        if (a.d(isVar, 10) || a.d(isVar, 12)) {
            sVar.status = 199;
        } else {
            sVar.status = 111;
        }
        String Qv = t.Qv(sVar.getUser());
        caVar.Cz(Qv);
        sVar.fileName = Qv;
        if (caVar.getType() != 62) {
            caVar.setType(43);
        }
        caVar.setContent(q.b(sVar.bhs(), sVar.jsn, false));
        sVar.jso = (int) d.x(caVar);
        sVar.jsm = Util.nowSecond();
        sVar.jsp = 0;
        Log.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + sVar.getFileName() + "] size:" + sVar.iKP + " svrid:" + sVar.dTS + " timelen:" + sVar.iFw + " user:" + sVar.getUser() + " human:" + sVar.bhs());
        b.chw().chx().bhj().b(sVar);
        b.chw().chx().bhj();
        String Qx = t.Qx(Qv);
        if (caVar.getType() == 62) {
            a.b(isVar, 13, Qx);
            a2 = a.a(isVar, 12);
        } else {
            a.b(isVar, 11, Qx);
            a2 = a.a(isVar, 10);
        }
        if (a2 != null) {
            String agM = a.agM(a2);
            b.chw().chx().bhj();
            com.tencent.mm.vfs.s.nw(agM, t.Qw(Qv));
        }
        AppMethodBeat.o(21851);
        return 0;
    }

    private static String a(is isVar, ca caVar) {
        int i2;
        String str;
        AppMethodBeat.i(21852);
        s agI = d.agI(caVar.field_imgPath);
        if (agI == null) {
            AppMethodBeat.o(21852);
            return null;
        }
        if (caVar.getType() == 62) {
            i2 = 62;
        } else {
            i2 = 43;
        }
        isVar.oUv = i2;
        if (Util.isNullOrNil(caVar.field_content)) {
            AppMethodBeat.o(21852);
            return null;
        }
        if (d.Eq(caVar.field_talker)) {
            str = agI.bhs();
        } else {
            str = isVar.KHl.MTo;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "videomsg");
            Map<String, String> parseXml = XmlParser.parseXml(agI.bhv(), "msg", null);
            if (parseXml != null) {
                newSerializer.attribute(null, "aeskey", parseXml.get(".msg.videomsg.$aeskey"));
                newSerializer.attribute(null, "cdnthumbaeskey", parseXml.get(".msg.videomsg.$cdnthumbaeskey"));
                newSerializer.attribute(null, "cdnvideourl", parseXml.get(".msg.videomsg.$cdnvideourl"));
                newSerializer.attribute(null, "cdnthumburl", parseXml.get(".msg.videomsg.$cdnthumburl"));
                newSerializer.attribute(null, "cdnthumblength", parseXml.get(".msg.videomsg.$cdnthumblength"));
            }
            newSerializer.attribute(null, "playlength", new StringBuilder().append(agI.iFw).toString());
            newSerializer.attribute(null, "length", new StringBuilder().append(agI.iKP).toString());
            newSerializer.attribute(null, "type", String.valueOf(i2));
            if (!Util.isNullOrNil(str)) {
                newSerializer.attribute(null, "fromusername", str);
            }
            newSerializer.attribute(null, "md5", agI.ebj);
            newSerializer.endTag(null, "videomsg");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            Log.d("MicroMsg.BakOldItemVideo", "parseContent xml:".concat(String.valueOf(stringBuffer)));
            AppMethodBeat.o(21852);
            return stringBuffer;
        } catch (Exception e2) {
            Log.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + e2.toString());
            AppMethodBeat.o(21852);
            return null;
        }
    }
}
