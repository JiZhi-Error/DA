package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class l implements j {
    @Override // com.tencent.mm.plugin.sns.b.j
    public final void b(String str, m mVar) {
        AppMethodBeat.i(94906);
        p.b(str, mVar);
        AppMethodBeat.o(94906);
    }

    @Override // com.tencent.mm.plugin.sns.b.j
    public final String a(String str, PString pString) {
        AppMethodBeat.i(94907);
        String a2 = p.a(str, pString);
        AppMethodBeat.o(94907);
        return a2;
    }

    @Override // com.tencent.mm.plugin.sns.b.j
    public final String ag(ca caVar) {
        AppMethodBeat.i(94910);
        String ag = p.ag(caVar);
        AppMethodBeat.o(94910);
        return ag;
    }

    @Override // com.tencent.mm.plugin.sns.b.j
    public final void a(String str, ad.b bVar, ca caVar) {
        k.b HD;
        AppMethodBeat.i(94908);
        if (caVar.dOQ() && (HD = k.b.HD(caVar.field_content)) != null && !Util.isNullOrNil(HD.ean)) {
            bVar.l(str, HD.ean);
        }
        AppMethodBeat.o(94908);
    }

    @Override // com.tencent.mm.plugin.sns.b.j
    public final void aO(ca caVar) {
        AppMethodBeat.i(94909);
        String ag = p.ag(caVar);
        if (ag != null) {
            byte[] decode = Base64.decode(ag, 0);
            eco eco = new eco();
            try {
                eco.parseFrom(decode);
                if (eco.NcH == null) {
                    AppMethodBeat.o(94909);
                    return;
                }
                String sb = caVar.field_talker.endsWith("@chatroom") ? new StringBuilder().append(p.a.TalkChat.value).toString() : new StringBuilder().append(p.a.Chat.value).toString();
                Log.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", sb, ag, eco.NcH.NcK, eco.NcH.KxO);
                ((d) g.af(d.class)).a(13235, sb, eco.NcH.NcK, eco.NcH.KxO);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", e2, "", new Object[0]);
                AppMethodBeat.o(94909);
                return;
            }
        }
        AppMethodBeat.o(94909);
    }
}
