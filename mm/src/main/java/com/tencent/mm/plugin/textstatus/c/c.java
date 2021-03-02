package com.tencent.mm.plugin.textstatus.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/jump/LiveSingleton;", "Lcom/tencent/mm/plugin/textstatus/jump/ITextStatusJumpSingleton;", "()V", "doJump", "", "textStatusID", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "plugin-textstatus_release"})
public final class c implements b {
    @Override // com.tencent.mm.plugin.textstatus.c.b
    public final boolean F(String str, List<? extends r> list) {
        AppMethodBeat.i(258381);
        p.h(str, "textStatusID");
        p.h(list, "jumpInfos");
        boolean z = false;
        long j2 = -1;
        for (T t : list) {
            j2++;
            String str2 = t.GaO;
            if (str2 != null) {
                switch (str2.hashCode()) {
                    case 50:
                        if (str2.equals("2")) {
                            Map<String, String> parseXml = XmlParser.parseXml(t.GaQ, "finderLive", null);
                            if (parseXml != null) {
                                axf v = com.tencent.mm.plugin.i.a.l.v("", parseXml);
                                k.vkd.a(d.Ga(v.feedId), d.Ga(v.hJs), v.username, -1, j2, s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM, s.j.COMMENT_SCENE_SLEF_STATUS.scene);
                                if (Util.isEqual(z.aUg(), v.username)) {
                                    ((aj) g.ah(aj.class)).enterFinderLiveAnchorUI(MMApplicationContext.getContext(), d.Ga(v.feedId), Long.valueOf(d.Ga(v.hJs)), v.objectNonceId, v.desc, "", "", "");
                                } else {
                                    ((aj) g.ah(aj.class)).enterFinderLiveVisitorUI(MMApplicationContext.getContext(), d.Ga(v.feedId), Long.valueOf(d.Ga(v.hJs)), v.username, v.objectNonceId, v.desc, "", "", "", 0);
                                }
                            }
                            z = true;
                            continue;
                        }
                        break;
                }
            }
            z = false;
        }
        AppMethodBeat.o(258381);
        return z;
    }
}
