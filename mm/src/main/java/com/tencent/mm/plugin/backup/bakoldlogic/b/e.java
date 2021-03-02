package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.g;
import com.tencent.mm.av.i;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.StringWriter;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e implements j {
    private static String a(g gVar, ca caVar) {
        AppMethodBeat.i(21846);
        StringWriter stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (d.Eq(caVar.field_talker)) {
                stringWriter.write(bp.Ks(caVar.field_content) + ":\n");
            }
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "img");
            Map<String, String> parseXml = XmlParser.parseXml(gVar.iXy, "msg", null);
            if (parseXml != null) {
                newSerializer.attribute(null, "aeskey", parseXml.get(".msg.img.$aeskey"));
                newSerializer.attribute(null, "encryver", parseXml.get(".msg.img.$encryver"));
                newSerializer.attribute(null, "cdnthumbaeskey", parseXml.get(".msg.img.$cdnthumbaeskey"));
                newSerializer.attribute(null, "cdnthumburl", parseXml.get(".msg.img.$cdnthumburl"));
                newSerializer.attribute(null, "cdnthumblength", new StringBuilder().append(Util.getLong(parseXml.get(".msg.img.$cdnthumblength"), 10240)).toString());
                newSerializer.attribute(null, "cdnthumbheight", new StringBuilder().append(Util.getInt(parseXml.get(".msg.img.$cdnthumbheight"), 0)).toString());
                newSerializer.attribute(null, "cdnthumbwidth", new StringBuilder().append(Util.getInt(parseXml.get(".msg.img.$cdnthumbwidth"), 0)).toString());
                newSerializer.attribute(null, "cdnmidheight", new StringBuilder().append(Util.getInt(parseXml.get(".msg.img.$cdnmidheight"), 0)).toString());
                newSerializer.attribute(null, "cdnmidwidth", new StringBuilder().append(Util.getInt(parseXml.get(".msg.img.$cdnmidwidth"), 0)).toString());
                newSerializer.attribute(null, "cdnhdheight", new StringBuilder().append(Util.getInt(parseXml.get(".msg.img.$cdnhdheight"), 0)).toString());
                newSerializer.attribute(null, "cdnhdwidth", new StringBuilder().append(Util.getInt(parseXml.get(".msg.img.$cdnhdwidth"), 0)).toString());
                newSerializer.attribute(null, "cdnmidimgurl", parseXml.get(".msg.img.$cdnmidimgurl"));
                long j2 = Util.getLong(parseXml.get(".msg.img.$length"), 0);
                StringBuilder sb = new StringBuilder();
                if (j2 == 0) {
                    j2 = s.boW(b.chw().chx().cgM().o(gVar.iXm, "", ""));
                }
                newSerializer.attribute(null, "length", sb.append(j2).toString());
                if (caVar.field_isSend != 1 || gVar.iXp == 1) {
                    newSerializer.attribute(null, "cdnbigimgurl", parseXml.get(".msg.img.$cdnbigimgurl"));
                    newSerializer.attribute(null, "hdlength", new StringBuilder().append(Util.getLong(parseXml.get(".msg.img.$hdlength"), 0)).toString());
                }
                newSerializer.attribute(null, "md5", parseXml.get(".msg.img.$md5"));
            }
            newSerializer.endTag(null, "img");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            Log.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", stringBuffer);
            AppMethodBeat.o(21846);
            return stringBuffer;
        } catch (Exception e2) {
            Log.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + e2.toString());
            AppMethodBeat.o(21846);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    public final int a(String str, is isVar, ca caVar) {
        int iLen;
        String linkedList;
        String linkedList2;
        g G;
        boolean z;
        String str2;
        AppMethodBeat.i(21847);
        if (isVar == null || isVar.KHn == null) {
            Log.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
            AppMethodBeat.o(21847);
            return 0;
        }
        String str3 = new String(Util.nullAs(isVar.KHn.MTo, ""));
        Log.d("MicroMsg.BakOldItemImg", "recover msg" + isVar.Brn + " " + str3);
        Object[] objArr = new Object[4];
        if (isVar.KMS == null) {
            iLen = 0;
        } else {
            iLen = isVar.KMS.getILen();
        }
        objArr[0] = Integer.valueOf(iLen);
        objArr[1] = Integer.valueOf(isVar.KMU);
        if (isVar.KMR == null) {
            linkedList = "";
        } else {
            linkedList = isVar.KMR.toString();
        }
        objArr[2] = linkedList;
        if (isVar.KMQ == null) {
            linkedList2 = "";
        } else {
            linkedList2 = isVar.KMQ.toString();
        }
        objArr[3] = linkedList2;
        Log.d("MicroMsg.BakOldItemImg", "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s", objArr);
        g gVar = null;
        caVar.setContent(str3);
        i cgM = b.chw().chx().cgM();
        if (caVar.field_isSend == 1) {
            if (caVar.field_msgId != 0) {
                gVar = cgM.H(caVar.field_talker, caVar.field_msgId);
            }
            if (gVar == null || gVar.localId == 0) {
                G = cgM.G(caVar.field_talker, caVar.field_msgSvrId);
            } else {
                G = gVar;
            }
        } else {
            G = cgM.G(caVar.field_talker, caVar.field_msgSvrId);
        }
        Map<String, String> parseXml = XmlParser.parseXml(str3, "msg", null);
        if (parseXml == null || Util.getLong(parseXml.get(".msg.img.$hdlength"), 0) <= 0) {
            z = false;
        } else {
            z = true;
        }
        String nullAs = Util.nullAs(a.a(isVar, 3), "");
        if (isVar.KMU == 3 && isVar.KMS != null) {
            byte[] bufferToBytes = isVar.KMS.getBufferToBytes();
            s.e(a.cgW() + "backupMeida/" + a.agK(nullAs) + nullAs, bufferToBytes, bufferToBytes.length);
        }
        String nullAs2 = Util.nullAs(a.a(isVar, 2), "");
        if (isVar.KMU == 2 && isVar.KMS != null) {
            byte[] bufferToBytes2 = isVar.KMS.getBufferToBytes();
            s.e(a.cgW() + "backupMeida/" + a.agK(nullAs2) + nullAs2, bufferToBytes2, bufferToBytes2.length);
        }
        Log.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", nullAs, nullAs2);
        if (Util.isNullOrNil(nullAs2)) {
            Log.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
            str2 = nullAs;
        } else {
            str2 = nullAs2;
        }
        byte[] b2 = a.b(isVar, 1);
        if (b2 == null) {
            Log.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            String agM = a.agM(str2);
            String messageDigest = com.tencent.mm.b.g.getMessageDigest((Util.nowMilliSecond() + " ").getBytes());
            String str4 = a.cgW() + "backupMeida/" + a.agK(messageDigest);
            String str5 = str4 + messageDigest;
            o oVar = new o(str4);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            int isLongPicture = LongBitmapHandler.isLongPicture(str5);
            if (isLongPicture > 0) {
                if (!LongBitmapHandler.createLongPictureThumbNail(agM, Bitmap.CompressFormat.JPEG, 90, str5, isLongPicture)) {
                    Log.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
                    AppMethodBeat.o(21847);
                    return -1;
                }
            } else if (!BitmapUtil.createThumbNail(agM, 120, 120, Bitmap.CompressFormat.JPEG, 90, str5)) {
                Log.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
                AppMethodBeat.o(21847);
                return -1;
            } else {
                Log.d("MicroMsg.BakOldItemImg", "insert: thumbName = ".concat(String.valueOf(messageDigest)));
            }
            b2 = s.aW(str5, 0, -1);
        } else {
            Log.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", Integer.valueOf(b2.length));
        }
        if (b2 == null) {
            Log.e("MicroMsg.BakOldItemImg", "img buf is null");
            AppMethodBeat.o(21847);
            return -1;
        }
        String o = cgM.o(nullAs, "", "");
        String o2 = cgM.o(str2, "", "");
        long j2 = 0;
        if (G.localId == 0) {
            if (z) {
                j2 = cgM.a(caVar.field_talker, b2, isVar.Brn, true, nullAs, a.c(isVar, 3), str3, new PString(), new PInt(), new PInt());
                if (!a.b(isVar, 3, o)) {
                    Log.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", o);
                }
            }
            int c2 = a.c(isVar, 2);
            if (c2 <= 0) {
                c2 = a.c(isVar, 3);
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            long a2 = cgM.a(caVar.field_talker, b2, isVar.Brn, false, str2, c2, str3, pString, pInt, pInt2);
            if (!a.b(isVar, 2, o2)) {
                Log.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", o);
            }
            if (a2 > 0) {
                caVar.Cz(pString.value);
                caVar.nG(pInt.value);
                caVar.nH(pInt2.value);
                if (j2 > 0) {
                    g c3 = b.chw().chx().cgM().c(Long.valueOf(a2));
                    c3.tg((int) j2);
                    b.chw().chx().cgM().a(Long.valueOf(a2), c3);
                }
            } else {
                AppMethodBeat.o(21847);
                return -1;
            }
        } else {
            String str6 = G.iXo;
            if (str6 == null || !str6.startsWith("THUMBNAIL_DIRPATH://")) {
                caVar.Cz("THUMBNAIL://" + G.localId);
            } else {
                caVar.Cz(str6);
            }
        }
        d.x(caVar);
        AppMethodBeat.o(21847);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x025b  */
    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.protocal.protobuf.is r12, com.tencent.mm.storage.ca r13, java.lang.String r14, java.util.LinkedList<com.tencent.mm.plugin.backup.i.u> r15) {
        /*
        // Method dump skipped, instructions count: 725
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.b.e.a(com.tencent.mm.protocal.protobuf.is, com.tencent.mm.storage.ca, java.lang.String, java.util.LinkedList):int");
    }
}
