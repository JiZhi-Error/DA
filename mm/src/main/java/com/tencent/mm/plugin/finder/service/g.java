package com.tencent.mm.plugin.finder.service;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.cy;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.an;
import com.tencent.mm.storage.ar;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderEnterPersonalMsgService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderEnterPersonalMsgService;", "()V", "checkUpdatePersonalMsg", "", "sessionId", "", "Companion", "plugin-finder_release"})
public final class g implements an {
    public static final a UUj = new a((byte) 0);

    static {
        AppMethodBeat.i(261364);
        AppMethodBeat.o(261364);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/service/FinderEnterPersonalMsgService$Companion;", "", "()V", "MMFinderPersonalMsgScene_Finder", "", "MMFinderPersonalMsgScene_WX", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.i.a.an
    public final void bxX(String str) {
        AppMethodBeat.i(261363);
        p.h(str, "sessionId");
        d.i(new b(str));
        AppMethodBeat.o(261363);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String $sessionId;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(0);
            this.$sessionId = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            AppMethodBeat.i(261362);
            String avi = ((aa) com.tencent.mm.kernel.g.af(aa.class)).avi(this.$sessionId);
            c.a aVar = c.tsp;
            boolean bxz = c.a.bxz(avi);
            new StringBuilder("[checkUpdatePersonalMsg] sessionId=").append(this.$sessionId).append(" talker=").append(avi).append(" isFinderContact=").append(bxz);
            h.hkS();
            c.a aVar2 = c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(avi);
            if (asG != null) {
                e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                if (System.currentTimeMillis() - asG.field_personalMsgUpdateTime >= ((long) aAh.azQ().getInt(ar.a.USERINFO_FINDER_ENTER_PERSONAL_MSG_REFRESH_INTERVAL_INT_SYNC, LocalCache.TIME_HOUR)) * 1000) {
                    if (bxz) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    p.g(avi, "talker");
                    new cy(i2, avi, this.$sessionId, (byte) 0).aYI();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(261362);
            return xVar;
        }
    }
}
