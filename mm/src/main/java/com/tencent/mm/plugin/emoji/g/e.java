package com.tencent.mm.plugin.emoji.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Map;

public final class e implements cj.a {
    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        AppMethodBeat.i(108736);
        de deVar = aVar.heO;
        if (deVar.xKb == 10002) {
            String a2 = z.a(deVar.KHn);
            if (Util.isNullOrNil(a2)) {
                Log.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
                AppMethodBeat.o(108736);
                return;
            }
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml != null && parseXml.size() > 0) {
                String str = parseXml.get(".sysmsg.$type");
                if (Util.isNullOrNil(str) || !str.equalsIgnoreCase("NewRecommendEmotion")) {
                    Log.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :".concat(String.valueOf(str)));
                } else {
                    ArrayList<EmojiGroupInfo> amT = d.amT(a2);
                    k.getEmojiStorageMgr().OpO.gEK();
                    k.getEmojiStorageMgr().OpO.bk(amT);
                    AppMethodBeat.o(108736);
                    return;
                }
            }
            AppMethodBeat.o(108736);
            return;
        }
        Log.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", Integer.valueOf(deVar.xKb));
        AppMethodBeat.o(108736);
    }
}
