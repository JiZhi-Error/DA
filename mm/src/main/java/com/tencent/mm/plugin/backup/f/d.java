package com.tencent.mm.plugin.backup.f;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.io.StringWriter;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class d implements l {
    private static String a(g gVar, ca caVar) {
        AppMethodBeat.i(21514);
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (c.Eq(caVar.field_talker)) {
                stringWriter.write(bp.Ks(caVar.field_content) + ":\n");
            }
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "img");
            Map<String, String> parseXml = XmlParser.parseXml(gVar.iXy, "msg", null);
            if (parseXml != null) {
                if (parseXml.get(".msg.img.$aeskey") == null) {
                    newSerializer.attribute(null, "aeskey", "");
                }
                if (parseXml.get(".msg.img.$encryver") == null) {
                    newSerializer.attribute(null, "encryver", "");
                }
                if (parseXml.get(".msg.img.$cdnthumbaeskey") == null) {
                    newSerializer.attribute(null, "cdnthumbaeskey", "");
                }
                if (parseXml.get(".msg.img.$cdnthumburl") == null) {
                    newSerializer.attribute(null, "cdnthumburl", "");
                }
                if (parseXml.get(".msg.img.$cdnthumblength") == null) {
                    newSerializer.attribute(null, "cdnthumblength", "10240");
                }
                if (parseXml.get(".msg.img.$cdnthumbheight") == null) {
                    newSerializer.attribute(null, "cdnthumbheight", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (parseXml.get(".msg.img.$cdnthumbwidth") == null) {
                    newSerializer.attribute(null, "cdnthumbwidth", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (parseXml.get(".msg.img.$cdnmidheight") == null) {
                    newSerializer.attribute(null, "cdnmidheight", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (parseXml.get(".msg.img.$cdnmidwidth") == null) {
                    newSerializer.attribute(null, "cdnmidwidth", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (parseXml.get(".msg.img.$cdnhdheight") == null) {
                    newSerializer.attribute(null, "cdnhdheight", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (parseXml.get(".msg.img.$cdnhdwidth") == null) {
                    newSerializer.attribute(null, "cdnhdwidth", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                if (parseXml.get(".msg.img.$cdnmidimgurl") == null) {
                    newSerializer.attribute(null, "cdnmidimgurl", "");
                }
                if (Util.getLong(parseXml.get(".msg.img.$length"), 0) == 0) {
                    newSerializer.attribute(null, "length", new StringBuilder().append(s.boW(com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgM().o(gVar.iXm, "", ""))).toString());
                }
                if (caVar.field_isSend != 1 || gVar.iXp == 1) {
                    newSerializer.attribute(null, "cdnbigimgurl", parseXml.get(".msg.img.$cdnbigimgurl"));
                    newSerializer.attribute(null, "hdlength", new StringBuilder().append(Util.getLong(parseXml.get(".msg.img.$hdlength"), 0)).toString());
                }
                parseXml.remove(".msg.img.$cdnbigimgurl");
                parseXml.remove(".msg.img.$hdlength");
                if (parseXml.get(".msg.img.$md5") == null) {
                    newSerializer.attribute(null, "md5", "");
                }
                for (String str : parseXml.keySet()) {
                    if (str.startsWith(".msg.img.$")) {
                        newSerializer.attribute(null, str.substring(10), parseXml.get(str));
                    }
                }
            }
            newSerializer.endTag(null, "img");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            Log.d("MicroMsg.BackupItemImg", "parseContent xml:%s", stringBuffer);
            AppMethodBeat.o(21514);
            return stringBuffer;
        } catch (Exception e2) {
            Log.e("MicroMsg.BackupItemImg", "packetImg xml error: " + e2.toString());
            AppMethodBeat.o(21514);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x040b  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x040e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x03d8  */
    @Override // com.tencent.mm.plugin.backup.f.l
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.String r23, com.tencent.mm.protocal.protobuf.is r24, com.tencent.mm.storage.ca r25) {
        /*
        // Method dump skipped, instructions count: 1049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.f.d.a(java.lang.String, com.tencent.mm.protocal.protobuf.is, com.tencent.mm.storage.ca):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02a2  */
    @Override // com.tencent.mm.plugin.backup.f.l
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.protocal.protobuf.is r12, boolean r13, com.tencent.mm.storage.ca r14, java.lang.String r15, java.util.LinkedList<com.tencent.mm.plugin.backup.i.u> r16, java.util.HashMap<java.lang.Long, com.tencent.mm.plugin.backup.f.h.a> r17, boolean r18, long r19) {
        /*
        // Method dump skipped, instructions count: 700
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.f.d.a(com.tencent.mm.protocal.protobuf.is, boolean, com.tencent.mm.storage.ca, java.lang.String, java.util.LinkedList, java.util.HashMap, boolean, long):int");
    }
}
