package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.ca;

public final class b implements a {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.a
    public final void a(h.a aVar, ca caVar, final String str, String str2, boolean z) {
        AppMethodBeat.i(22333);
        final de deVar = aVar.heO;
        final bp.b Ky = bp.Ky(deVar.KHq);
        if (Ky != null) {
            caVar.CH(Ky.iEs);
            caVar.nM(Ky.iEt);
            caVar.CC(Ky.iEr);
            Log.i("MicroMsg.BaseMsgCallbackImpl", "bizClientMsgId = %s", Ky.iEr);
            if (!(Ky.iEw == null || Ky.scene != 1 || deVar.xKb == 10000)) {
                bg.aVF();
                as Kn = c.aSN().Kn(str);
                if (Kn == null || ((int) Kn.gMZ) <= 0) {
                    ay.a.iDq.a(str, null, new ay.b.a() {
                        /* class com.tencent.mm.plugin.bbom.b.AnonymousClass1 */

                        @Override // com.tencent.mm.model.ay.b.a
                        public final void p(String str, boolean z) {
                            AppMethodBeat.i(22332);
                            bg.aVF();
                            b.a(deVar, Ky, c.aSN().Kn(str));
                            AppMethodBeat.o(22332);
                        }
                    });
                    AppMethodBeat.o(22333);
                    return;
                }
                a(deVar, Ky, Kn);
            }
        }
        AppMethodBeat.o(22333);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a
    public final void b(h.a aVar, ca caVar, String str, String str2, boolean z) {
    }

    static void a(de deVar, bp.b bVar, as asVar) {
        int i2;
        AppMethodBeat.i(22334);
        String a2 = z.a(deVar.KHl);
        bg.aVF();
        c.azQ().set(73729, (Object) 1);
        String str = asVar.field_nickname;
        bx bxVar = new bx();
        bxVar.field_content = z.a(deVar.KHn);
        bxVar.field_createtime = Util.nowSecond();
        bxVar.field_imgpath = "";
        bxVar.field_sayhicontent = deVar.xKb == 3 ? MMApplicationContext.getContext().getString(R.string.fb4) : z.a(deVar.KHn);
        bxVar.field_sayhiuser = a2;
        bxVar.field_scene = 18;
        if (deVar.oTW > 3) {
            i2 = deVar.oTW;
        } else {
            i2 = 3;
        }
        bxVar.field_status = i2;
        bxVar.field_svrid = deVar.Brn;
        bxVar.field_talker = str;
        bxVar.field_type = deVar.xKb;
        bxVar.field_isSend = 0;
        bxVar.field_sayhiencryptuser = a2;
        bxVar.field_ticket = bVar.iEw;
        d.bgO().a(bxVar);
        ls lsVar = new ls();
        lsVar.dRd.dRe = a2;
        EventCenter.instance.publish(lsVar);
        AppMethodBeat.o(22334);
    }
}
