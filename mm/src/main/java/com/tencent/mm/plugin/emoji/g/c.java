package com.tencent.mm.plugin.emoji.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import java.util.Map;

public final class c implements cj.a {

    public class a {
        private String dEA;
        int rdo;
        int rdp;
        String thumburl;

        public a(int i2, int i3, String str, String str2) {
            this.rdo = i2;
            this.rdp = i3;
            this.thumburl = str;
            this.dEA = str2;
        }
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        int i2;
        int i3;
        AppMethodBeat.i(108733);
        de deVar = aVar.heO;
        if (deVar.xKb == 10002) {
            String a2 = z.a(deVar.KHn);
            if (Util.isNullOrNil(a2)) {
                Log.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
                AppMethodBeat.o(108733);
                return;
            }
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml != null && parseXml.size() > 0) {
                String str = parseXml.get(".sysmsg.$type");
                if (Util.isNullOrNil(str) || !str.equalsIgnoreCase("emotionstore")) {
                    Log.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
                } else {
                    try {
                        String str2 = parseXml.get(".sysmsg.emotionstore.productid");
                        String str3 = parseXml.get(".sysmsg.emotionstore.newcount");
                        String str4 = parseXml.get(".sysmsg.emotionstore.freecount");
                        String str5 = parseXml.get(".sysmsg.emotionstore.thumburl");
                        if (!Util.isNullOrNil(str3)) {
                            i2 = Integer.valueOf(str3).intValue();
                        } else {
                            i2 = 0;
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            i3 = Integer.valueOf(str4).intValue();
                        } else {
                            i3 = 0;
                        }
                        a aVar2 = new a(i2, i3, str5, str2);
                        if (!Util.isNullOrNil(str2)) {
                            Log.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", str2);
                            g.aAg().hqi.a(new l(str2, aVar2), 0);
                        } else {
                            a(aVar2);
                        }
                        String str6 = parseXml.get(".sysmsg.personalemotion.newcount");
                        if (!Util.isNullOrNil(str6) && Integer.valueOf(str6).intValue() > 0) {
                            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.TRUE);
                        }
                        String str7 = parseXml.get(".sysmsg.personalemoji.emojicount");
                        if (!Util.isNullOrNil(str7) && Integer.valueOf(str7).intValue() > 0) {
                            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.TRUE);
                        }
                        AppMethodBeat.o(108733);
                        return;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", Util.stackTraceToString(e2));
                        AppMethodBeat.o(108733);
                        return;
                    }
                }
            }
            AppMethodBeat.o(108733);
            return;
        }
        Log.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(deVar.xKb));
        AppMethodBeat.o(108733);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(108734);
        if (aVar == null) {
            Log.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
            AppMethodBeat.o(108734);
            return;
        }
        if (aVar.rdo > 0) {
            g.aAh().azQ().set(208899, Boolean.TRUE);
            com.tencent.mm.y.c.axV().A(262147, true);
        }
        if (aVar.rdp > 0) {
            g.aAh().azQ().set(208913, Boolean.TRUE);
            com.tencent.mm.y.c.axV().A(262149, true);
        }
        if (!Util.isNullOrNil(aVar.thumburl)) {
            Log.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", aVar.thumburl);
            g.aAh().azQ().set(229633, aVar.thumburl);
            g.aAh().azQ().set(229634, new StringBuilder().append(System.currentTimeMillis()).toString());
            AppMethodBeat.o(108734);
            return;
        }
        g.aAh().azQ().set(229633, "");
        g.aAh().azQ().set(229634, "");
        AppMethodBeat.o(108734);
    }
}
