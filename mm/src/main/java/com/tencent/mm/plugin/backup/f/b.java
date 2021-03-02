package com.tencent.mm.plugin.backup.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b implements l {
    @Override // com.tencent.mm.plugin.backup.f.l
    public final int a(String str, is isVar, ca caVar) {
        AppMethodBeat.i(21509);
        caVar.setContent(isVar.KHn.MTo);
        String str2 = isVar.KHl.MTo;
        String str3 = isVar.KHm.MTo;
        if (!((String) d.cgP().cgQ().azQ().get(2, (Object) null)).equals(str2)) {
            str3 = str2;
        }
        String str4 = isVar.KHn.MTo;
        Map<String, String> parseXml = XmlParser.parseXml(str4, "msg", null);
        bi fT = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fT(str4, str3);
        if (fT == null) {
            Log.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
            AppMethodBeat.o(21509);
            return -1;
        }
        EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(fT.md5);
        if (aml == null) {
            aml = new EmojiInfo();
            com.tencent.mm.plugin.emoji.h.b.b(fT, aml);
            aml.field_catalog = EmojiInfo.VkQ;
            d.cgP().cgQ().cgN().J(aml);
        }
        if (parseXml.get(".msg.emoji.$androidmd5") == null) {
            String agE = g.a.agE(fT.md5);
            if (!Util.isNullOrNil(agE)) {
                fT.md5 = agE;
                Log.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", agE);
            }
        }
        String str5 = fT.productId;
        caVar.setType(47);
        caVar.Cz(fT.md5);
        caVar.setContent(be.a(fT.jsh, 0, !aml.NA() && !aml.isGif(), fT.md5, false, ""));
        if (!aml.hYi()) {
            com.tencent.mm.plugin.backup.h.b cgQ = d.cgP().cgQ();
            if (cgQ.uin == 0) {
                com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
                AppMethodBeat.o(21509);
                throw bVar;
            }
            String str6 = cgQ.hqG + "emoji/";
            if (TextUtils.isEmpty(str5)) {
                com.tencent.mm.plugin.backup.b.g.b(isVar, 4, str6 + fT.md5 + "_thumb");
                com.tencent.mm.plugin.backup.b.g.b(isVar, 5, str6 + fT.md5);
            } else {
                o oVar = new o(str6 + str5);
                if (!oVar.exists()) {
                    oVar.mkdirs();
                }
                com.tencent.mm.plugin.backup.b.g.b(isVar, 4, str6 + str5 + FilePathGenerator.ANDROID_DIR_SEP + fT.md5 + "_cover");
                com.tencent.mm.plugin.backup.b.g.b(isVar, 5, str6 + str5 + FilePathGenerator.ANDROID_DIR_SEP + fT.md5);
            }
        }
        Log.d("MicroMsg.BackupItemEmoji", "id ".concat(String.valueOf(c.x(caVar))));
        AppMethodBeat.o(21509);
        return 0;
    }

    @Override // com.tencent.mm.plugin.backup.f.l
    public final int a(is isVar, boolean z, ca caVar, String str, LinkedList<u> linkedList, HashMap<Long, h.a> hashMap, boolean z2, long j2) {
        int length;
        AppMethodBeat.i(21508);
        if (Util.isNullOrNil(caVar.field_content)) {
            length = 0;
        } else {
            length = caVar.field_content.getBytes().length;
        }
        String trim = be.bkr(caVar.field_content).Oph.trim();
        if (!com.tencent.mm.plugin.backup.b.g.agB(trim)) {
            trim = caVar.field_content.replace("*#*", ":");
            int indexOf = trim.indexOf("<msg");
            Log.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", Integer.valueOf(indexOf));
            if (indexOf < 0) {
                trim = null;
            } else {
                String[] split = trim.substring(0, indexOf).split(":");
                int lastIndexOf = trim.substring(0, indexOf).lastIndexOf(":");
                Log.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", Integer.valueOf(split.length));
                if (split.length >= 5) {
                    trim = split[4] + trim.substring(lastIndexOf);
                }
            }
            if (!com.tencent.mm.plugin.backup.b.g.agB(trim)) {
                trim = g.a.a(caVar, isVar);
                if (caVar.field_isSend != 1 && c.Eq(caVar.field_talker)) {
                    trim = caVar.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !com.tencent.mm.plugin.backup.b.g.agB(trim)) {
            Log.d("MicroMsg.BackupItemEmoji", "emoji error:".concat(String.valueOf(trim)));
            AppMethodBeat.o(21508);
            return -1;
        }
        dqi dqi = new dqi();
        dqi.bhy(Util.nullAs(trim, ""));
        isVar.KHn = dqi;
        AppMethodBeat.o(21508);
        return length;
    }
}
