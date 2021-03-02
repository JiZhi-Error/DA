package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.backup.bakoldlogic.b.i;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import java.io.StringWriter;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class h implements j {
    byte[] oNG = {35, 33, 65, 77, 82, 10, 2, 35, 33};
    byte[] oNH = {35, 33, 65, 77, 82, 10, 35, 33};

    public h() {
        AppMethodBeat.i(21853);
        AppMethodBeat.o(21853);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x015b  */
    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r10, com.tencent.mm.protocal.protobuf.is r11, com.tencent.mm.storage.ca r12) {
        /*
        // Method dump skipped, instructions count: 393
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.b.h.a(java.lang.String, com.tencent.mm.protocal.protobuf.is, com.tencent.mm.storage.ca):int");
    }

    private static boolean h(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(21856);
        if (Util.isNullOrNil(bArr2)) {
            AppMethodBeat.o(21856);
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                AppMethodBeat.o(21856);
                return false;
            }
        }
        AppMethodBeat.o(21856);
        return true;
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    public final int a(is isVar, ca caVar, String str, LinkedList<u> linkedList) {
        int i2 = 0;
        AppMethodBeat.i(231603);
        String agJ = d.agJ(caVar.field_imgPath);
        if (Util.isNullOrNil(agJ)) {
            AppMethodBeat.o(231603);
        } else {
            o oVar = new o(agJ);
            if (!oVar.exists()) {
                AppMethodBeat.o(231603);
            } else {
                int length = (int) oVar.length();
                int a2 = i.a(new i.a(agJ, isVar, linkedList, 9, false, false, (u) null));
                String e2 = e(caVar, length);
                if (e2 == null) {
                    AppMethodBeat.o(231603);
                } else {
                    isVar.KHn = new dqi().bhy(e2);
                    i2 = a2 + e2.length();
                    if (length == 0) {
                        AppMethodBeat.o(231603);
                    } else {
                        AppMethodBeat.o(231603);
                    }
                }
            }
        }
        return i2;
    }

    private static String e(ca caVar, int i2) {
        String str = null;
        AppMethodBeat.i(21857);
        if (Util.isNullOrNil(caVar.field_content)) {
            AppMethodBeat.o(21857);
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
                if (d.Eq(caVar.field_talker)) {
                    str = pVar.jsh + ":\n" + str;
                }
                Log.i("MicroMsg.BakOldItemVoice", "parseContent xml:".concat(String.valueOf(str)));
                AppMethodBeat.o(21857);
            } catch (Exception e2) {
                Log.e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + e2.toString());
                AppMethodBeat.o(21857);
            }
        }
        return str;
    }
}
