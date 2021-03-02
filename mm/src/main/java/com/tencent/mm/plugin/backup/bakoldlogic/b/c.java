package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.backup.bakoldlogic.b.a;
import com.tencent.mm.plugin.backup.bakoldlogic.b.i;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class c implements j {
    private static boolean agB(String str) {
        AppMethodBeat.i(21840);
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (XmlParser.parseXml(str, "msg", null) != null) {
            AppMethodBeat.o(21840);
            return true;
        }
        AppMethodBeat.o(21840);
        return false;
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    public final int a(String str, is isVar, ca caVar) {
        boolean z = true;
        AppMethodBeat.i(21842);
        caVar.setContent(isVar.KHn.MTo);
        String str2 = isVar.KHl.MTo;
        String str3 = isVar.KHm.MTo;
        if (!((String) b.chw().chx().azQ().get(2, (Object) null)).equals(str2)) {
            str3 = str2;
        }
        String str4 = isVar.KHn.MTo;
        Map<String, String> parseXml = XmlParser.parseXml(str4, "msg", null);
        bi fT = ((d) g.ah(d.class)).getEmojiMgr().fT(str4, str3);
        if (fT == null) {
            Log.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
            AppMethodBeat.o(21842);
            return -1;
        }
        EmojiInfo aml = ((d) g.ah(d.class)).getEmojiMgr().aml(fT.md5);
        if (aml == null) {
            Log.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
            AppMethodBeat.o(21842);
            return -1;
        }
        if (parseXml.get(".msg.emoji.$androidmd5") == null) {
            String agE = a.agE(fT.md5);
            if (!Util.isNullOrNil(agE)) {
                fT.md5 = agE;
                Log.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", agE);
            }
        }
        String str5 = parseXml.get(".msg.emoji.$productid");
        if (!TextUtils.isEmpty(str5)) {
            fT.productId = str5;
        }
        caVar.setType(47);
        caVar.Cz(fT.md5);
        String str6 = fT.jsh;
        if (aml.NA() || aml.isGif()) {
            z = false;
        }
        caVar.setContent(be.a(str6, 0, z, fT.md5, false, ""));
        if (!aml.hYi()) {
            String aTd = b.chw().chx().aTd();
            if (TextUtils.isEmpty(str5)) {
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(isVar, 4, aTd + fT.md5 + "_thumb");
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(isVar, 5, aTd + fT.md5);
            } else {
                o oVar = new o(aTd + str5);
                if (!oVar.exists()) {
                    oVar.mkdirs();
                }
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(isVar, 4, aTd + str5 + FilePathGenerator.ANDROID_DIR_SEP + fT.md5 + "_cover");
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(isVar, 5, aTd + str5 + FilePathGenerator.ANDROID_DIR_SEP + fT.md5);
            }
            EmojiInfo emojiInfo = new EmojiInfo(aTd);
            emojiInfo.field_md5 = fT.md5;
            emojiInfo.field_svrid = fT.id;
            emojiInfo.field_catalog = EmojiInfo.VkQ;
            emojiInfo.field_type = fT.OpC;
            emojiInfo.field_size = fT.OpD;
            emojiInfo.field_state = EmojiInfo.Vlc;
            if (!TextUtils.isEmpty(str5)) {
                emojiInfo.field_groupId = str5;
            }
            if (!Util.isNullOrNil(fT.OpL)) {
                emojiInfo.field_activityid = fT.OpL;
            }
            b.chw().chx().cgN().replace(emojiInfo);
        }
        Log.d("MicroMsg.BakOldItemEmoji", "id ".concat(String.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.d.d.x(caVar))));
        AppMethodBeat.o(21842);
        return 0;
    }

    static class a {
        public static String oJw = "<msg>";
        public static String oJx = "</msg>";

        public static String agE(String str) {
            AppMethodBeat.i(21838);
            a.C0836a agN = a.agN(str);
            if (agN == null) {
                AppMethodBeat.o(21838);
                return null;
            }
            String str2 = agN.oNX;
            AppMethodBeat.o(21838);
            return str2;
        }

        public static String a(ca caVar, is isVar) {
            AppMethodBeat.i(21839);
            EmojiInfo blk = b.chw().chx().cgN().blk(caVar.field_imgPath);
            if (blk == null) {
                AppMethodBeat.o(21839);
                return null;
            }
            a.C0836a agO = a.agO(blk.getMd5());
            if (agO == null) {
                agO = new a.C0836a(blk.getMd5(), blk.getMd5(), blk.getMd5(), blk.getMd5());
            }
            StringWriter stringWriter = new StringWriter();
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument(MimeTypeUtil.ContentType.DEFAULT_CHARSET, Boolean.TRUE);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "emoji");
                newSerializer.attribute(null, "fromusername", isVar.KHl.MTo);
                newSerializer.attribute(null, "tousername", isVar.KHm.MTo);
                newSerializer.attribute(null, "type", new StringBuilder().append(blk.field_type).toString());
                newSerializer.attribute(null, "idbuffer", blk.hYp());
                newSerializer.attribute(null, "md5", agO.oNY);
                newSerializer.attribute(null, "len", "1024");
                newSerializer.attribute(null, "androidmd5", agO.oNX);
                newSerializer.attribute(null, "androidlen", "1024");
                newSerializer.attribute(null, "productid", blk.field_groupId);
                newSerializer.endTag(null, "emoji");
                if (blk.NA()) {
                    newSerializer.startTag(null, "gameext");
                    Map<String, String> parseXml = XmlParser.parseXml(blk.getContent(), "gameext", null);
                    String nullAs = Util.nullAs(parseXml.get(".gameext.$type"), "");
                    String nullAs2 = Util.nullAs(parseXml.get(".gameext.$content"), "");
                    if (nullAs.equals("") || nullAs2.equals("")) {
                        stringWriter.close();
                        AppMethodBeat.o(21839);
                        return "";
                    }
                    newSerializer.attribute(null, "type", String.valueOf(nullAs));
                    newSerializer.attribute(null, "content", String.valueOf(nullAs2));
                    newSerializer.endTag(null, "gameext");
                }
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                String stringBuffer = stringWriter.getBuffer().toString();
                try {
                    String substring = stringBuffer.substring(stringBuffer.indexOf(oJw), stringBuffer.indexOf(oJx) + oJx.length());
                    Log.d("MicroMsg.EmojiConvert", "xml ".concat(String.valueOf(substring)));
                    AppMethodBeat.o(21839);
                    return substring;
                } catch (Exception e2) {
                    AppMethodBeat.o(21839);
                    return "";
                }
            } catch (XmlPullParserException e3) {
                Log.printErrStackTrace("MicroMsg.EmojiConvert", e3, "", new Object[0]);
                AppMethodBeat.o(21839);
                return "";
            } catch (IllegalArgumentException e4) {
                Log.printErrStackTrace("MicroMsg.EmojiConvert", e4, "", new Object[0]);
                AppMethodBeat.o(21839);
                return "";
            } catch (IllegalStateException e5) {
                Log.printErrStackTrace("MicroMsg.EmojiConvert", e5, "", new Object[0]);
                AppMethodBeat.o(21839);
                return "";
            } catch (IOException e6) {
                Log.printErrStackTrace("MicroMsg.EmojiConvert", e6, "", new Object[0]);
                AppMethodBeat.o(21839);
                return "";
            }
        }
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.b.j
    public final int a(is isVar, ca caVar, String str, LinkedList<u> linkedList) {
        int length;
        int i2;
        boolean z;
        AppMethodBeat.i(231599);
        if (Util.isNullOrNil(caVar.field_content)) {
            length = 0;
        } else {
            length = caVar.field_content.getBytes().length;
        }
        String trim = be.bkr(caVar.field_content).Oph.trim();
        if (!agB(trim)) {
            trim = caVar.field_content;
            if (!agB(trim)) {
                trim = a.a(caVar, isVar);
                if (caVar.field_isSend != 1 && com.tencent.mm.plugin.backup.bakoldlogic.d.d.Eq(caVar.field_talker)) {
                    trim = caVar.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !agB(trim)) {
            Log.d("MicroMsg.BakOldItemEmoji", "emoji error".concat(String.valueOf(trim)));
            AppMethodBeat.o(231599);
            return -1;
        }
        dqi dqi = new dqi();
        dqi.bhy(Util.nullAs(trim, ""));
        isVar.KHn = dqi;
        EmojiInfo blk = b.chw().chx().cgN().blk(caVar.field_imgPath);
        if (blk == null || !blk.hYm()) {
            if (blk != null) {
                if (TextUtils.isEmpty(blk.field_groupId)) {
                    String str2 = b.chw().chx().aTd() + blk.getMd5() + "_thumb";
                    if (s.boW(str2) < 0) {
                        Log.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                        AppMethodBeat.o(231599);
                        return -1;
                    }
                    i2 = i.a(new i.a(str2, isVar, linkedList, 4, false, "_thumb", false)) + length;
                } else {
                    String str3 = b.chw().chx().aTd() + blk.field_groupId + FilePathGenerator.ANDROID_DIR_SEP + blk.getMd5() + "_cover";
                    if (s.boW(str3) < 0) {
                        Log.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                        AppMethodBeat.o(231599);
                        return -1;
                    }
                    i2 = i.a(new i.a(str3, isVar, linkedList, 4, false, "_thumb", false)) + length;
                }
                if (!TextUtils.isEmpty(blk.field_groupId) || !blk.hYi()) {
                    if (blk.field_catalog == EmojiInfo.VkS || blk.field_catalog == EmojiInfo.VkV || blk.field_catalog == EmojiInfo.VkU) {
                        z = true;
                    } else {
                        String hYx = blk.hYx();
                        if (Util.isNullOrNil(hYx)) {
                            z = false;
                        } else {
                            z = new o(hYx).exists();
                        }
                    }
                    if (z) {
                        i2 += i.a(new i.a(b.chw().chx().aTd() + blk.field_groupId + FilePathGenerator.ANDROID_DIR_SEP + blk.getMd5(), isVar, linkedList, false, false, b.chw().chx().cgN().blk(be.bkr(z.a(isVar.KHn)).md5)));
                    }
                } else {
                    i2 += i.a(new i.a(b.chw().chx().aTd() + blk.getMd5(), isVar, linkedList, false, false, b.chw().chx().cgN().blk(be.bkr(z.a(isVar.KHn)).md5)));
                }
            } else {
                i2 = length;
            }
            AppMethodBeat.o(231599);
            return i2;
        }
        AppMethodBeat.o(231599);
        return length;
    }
}
