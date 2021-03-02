package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-finder_release"})
public final class j implements p {
    public static final a tyW = new a((byte) 0);

    static {
        AppMethodBeat.i(242762);
        AppMethodBeat.o(242762);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        long j2;
        long j3;
        String str2;
        long j4 = 0;
        AppMethodBeat.i(242761);
        kotlin.g.b.p.h(map, "values");
        kotlin.g.b.p.h(aVar, "addMsgInfo");
        if ((aVar.iMa instanceof cp) && aVar.what == 1) {
            de deVar = aVar.heO;
            Object obj = aVar.iMa;
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddBypMsg");
                AppMethodBeat.o(242761);
                throw tVar;
            }
            String str3 = ((cp) obj).KGL;
            String.valueOf(str);
            com.tencent.e.f.h.hkS();
            if (Util.isNullOrNil(z.a(deVar != null ? deVar.KHn : null))) {
                com.tencent.e.f.h.ez("msg content is null");
                AppMethodBeat.o(242761);
                return null;
            }
            String a2 = z.a(deVar != null ? deVar.KHl : null);
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            i eiy = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy();
            if (deVar != null) {
                j2 = deVar.Brn;
            } else {
                j2 = 0;
            }
            ca aJ = eiy.aJ(a2, j2);
            kotlin.g.b.p.g(aJ, "msgInfo");
            if (deVar != null) {
                j3 = deVar.Brn;
            } else {
                j3 = 0;
            }
            aJ.yF(j3);
            if (deVar != null) {
                j4 = (long) deVar.CreateTime;
            }
            aJ.setCreateTime(bp.C(a2, j4));
            aJ.setType(10000);
            aJ.setContent(map.get(".sysmsg.SysMsgContent"));
            aJ.nv(0);
            aJ.Cy(str3);
            if (deVar != null) {
                str2 = deVar.KHq;
            } else {
                str2 = null;
            }
            aJ.BB(str2);
            aJ.gDN();
            bp.x(aJ);
        }
        AppMethodBeat.o(242761);
        return null;
    }
}
