package com.tencent.mm.plugin.backup.f;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.f.i;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g implements l {
    byte[] oNG = {35, 33, 65, 77, 82, 10, 2, 35, 33};
    byte[] oNH = {35, 33, 65, 77, 82, 10, 35, 33};

    public g() {
        AppMethodBeat.i(21521);
        AppMethodBeat.o(21521);
    }

    @Override // com.tencent.mm.plugin.backup.f.l
    public final int a(String str, is isVar, ca caVar) {
        AppMethodBeat.i(21523);
        String str2 = isVar.KHn.MTo;
        if (c.Eq(isVar.KHl.MTo)) {
            int Kr = c.Kr(str2);
            if (Kr != -1 && Kr + 2 < str2.length()) {
                str2 = str2.substring(Kr + 2);
            }
            Log.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", str2);
        }
        Map<String, String> parseXml = XmlParser.parseXml(str2, "msg", null);
        if (parseXml != null) {
            try {
                caVar.setContent(p.b(parseXml.get(".msg.voicemsg.$fromusername"), (long) com.tencent.mm.plugin.backup.b.g.cv(parseXml.get(".msg.voicemsg.$voicelength"), 0), com.tencent.mm.plugin.backup.b.g.cv(parseXml.get(".msg.voicemsg.$isPlayed"), 1) == 1));
            } catch (Exception e2) {
                Log.e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
                Log.printErrStackTrace("MicroMsg.BackupItemVoice", e2, "", new Object[0]);
            }
        } else {
            Log.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", isVar.KHn.MTo);
            caVar.setContent(isVar.KHn.MTo);
        }
        String Rq = w.Rq(isVar.KHl.MTo);
        caVar.Cz(Rq);
        c.x(caVar);
        String agJ = c.agJ(Rq);
        String a2 = com.tencent.mm.plugin.backup.b.g.a(isVar, 9);
        if (!Util.isNullOrNil(a2)) {
            String str3 = com.tencent.mm.plugin.backup.b.g.agy(a2) + a2;
            if (s.YS(str3)) {
                byte[] aW = s.aW(str3, 0, 9);
                if (h(this.oNG, aW)) {
                    byte[] aW2 = s.aW(str3, 6, -1);
                    s.deleteFile(str3);
                    s.f(str3, aW2, aW2.length);
                } else if (h(this.oNH, aW)) {
                    byte[] aW3 = s.aW(str3, 6, -1);
                    s.deleteFile(str3);
                    s.f(str3, aW3, aW3.length);
                }
            }
        }
        if (agJ == null) {
            AppMethodBeat.o(21523);
        } else if (com.tencent.mm.plugin.backup.b.g.b(isVar, 9, agJ)) {
            AppMethodBeat.o(21523);
        } else {
            String a3 = com.tencent.mm.plugin.backup.b.g.a(isVar, 9);
            if (a3 != null) {
                String str4 = com.tencent.mm.plugin.backup.b.g.agy(a3) + a3;
                Log.d("MicroMsg.BackupItemVoice", "recover from path:%s", str4);
                s.nx(str4, agJ);
            }
            AppMethodBeat.o(21523);
        }
        return 0;
    }

    private static boolean h(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(21524);
        if (Util.isNullOrNil(bArr2)) {
            AppMethodBeat.o(21524);
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                AppMethodBeat.o(21524);
                return false;
            }
        }
        AppMethodBeat.o(21524);
        return true;
    }

    @Override // com.tencent.mm.plugin.backup.f.l
    public final int a(is isVar, boolean z, ca caVar, String str, LinkedList<u> linkedList, HashMap<Long, h.a> hashMap, boolean z2, long j2) {
        AppMethodBeat.i(21522);
        String agJ = c.agJ(caVar.field_imgPath);
        if (Util.isNullOrNil(agJ)) {
            AppMethodBeat.o(21522);
            return 0;
        }
        o oVar = new o(agJ);
        if (!oVar.exists()) {
            AppMethodBeat.o(21522);
            return 0;
        }
        int length = (int) oVar.length();
        if (z) {
            AppMethodBeat.o(21522);
            return length;
        }
        int a2 = i.a(new i.a(agJ, isVar, linkedList, 9, z2, z2, (u) null));
        String e2 = e(caVar, length);
        if (e2 == null) {
            AppMethodBeat.o(21522);
            return 0;
        }
        isVar.KHn = new dqi().bhy(e2);
        int length2 = a2 + e2.length();
        if (length == 0) {
            AppMethodBeat.o(21522);
            return length2;
        }
        AppMethodBeat.o(21522);
        return length2;
    }

    private static String e(ca caVar, int i2) {
        String str = null;
        AppMethodBeat.i(21525);
        if (Util.isNullOrNil(caVar.field_content)) {
            AppMethodBeat.o(21525);
        } else {
            p pVar = new p(caVar.field_content);
            StringWriter stringWriter = new StringWriter();
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "voicemsg");
                newSerializer.attribute(null, "length", String.valueOf(i2));
                newSerializer.attribute(null, "endflag", "1");
                newSerializer.attribute(null, "cancelflag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                newSerializer.attribute(null, "voicelength", new StringBuilder().append(pVar.time).toString());
                if (!Util.isNullOrNil(pVar.jsh)) {
                    newSerializer.attribute(null, "fromusername", pVar.jsh);
                }
                newSerializer.attribute(null, "isPlayed", pVar.jsi ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                newSerializer.endTag(null, "voicemsg");
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                str = stringWriter.getBuffer().toString();
                if (c.Eq(caVar.field_talker)) {
                    str = pVar.jsh + ":\n" + str;
                }
                Log.d("MicroMsg.BackupItemVoice", "parseContent xml:%s", str);
                AppMethodBeat.o(21525);
            } catch (Exception e2) {
                Log.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + e2.toString());
                AppMethodBeat.o(21525);
            }
        }
        return str;
    }
}
