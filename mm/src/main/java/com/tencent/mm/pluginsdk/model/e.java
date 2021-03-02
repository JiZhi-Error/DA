package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;

public final class e implements h {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        AppMethodBeat.i(30937);
        de deVar = aVar.heO;
        if (deVar == null || deVar.xKb != 47) {
            Log.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
            AppMethodBeat.o(30937);
        } else {
            String a2 = z.a(deVar.KHl);
            String a3 = z.a(deVar.KHm);
            bg.aVF();
            if (!((String) c.azQ().get(2, (Object) null)).equals(a2)) {
                a3 = a2;
            }
            ((d) g.ah(d.class)).getEmojiMgr().a(a3, z.a(deVar.KHn), deVar.Brn, deVar.KHq, aVar);
            bp.b Ky = bp.Ky(deVar.KHq);
            if (Ky != null) {
                Log.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", Ky.iEr);
                if (Ky.iEw != null && Ky.scene == 1) {
                    String a4 = z.a(deVar.KHl);
                    bg.aVF();
                    c.azQ().set(73729, (Object) 1);
                    bx bxVar = new bx();
                    bxVar.field_content = MMApplicationContext.getContext().getString(R.string.fb3);
                    bxVar.field_createtime = Util.nowSecond();
                    bxVar.field_imgpath = "";
                    bxVar.field_sayhicontent = bxVar.field_content;
                    bxVar.field_sayhiuser = a4;
                    bxVar.field_scene = 18;
                    bxVar.field_status = deVar.oTW > 3 ? deVar.oTW : 3;
                    bxVar.field_svrid = deVar.Brn;
                    bxVar.field_talker = a4;
                    bxVar.field_type = deVar.xKb;
                    bxVar.field_isSend = 0;
                    bxVar.field_sayhiencryptuser = a4;
                    bxVar.field_ticket = Ky.iEw;
                    com.tencent.mm.bj.d.bgO().a(bxVar);
                    ls lsVar = new ls();
                    lsVar.dRd.dRe = a4;
                    EventCenter.instance.publish(lsVar);
                }
            }
            AppMethodBeat.o(30937);
        }
        return null;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}
