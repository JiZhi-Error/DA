package com.tencent.mm.plugin.mv.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/thumb/TPTrackThumbInfo;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "(Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;)V", "getMediaInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "cropToPlayRange", "", "start", "", "end", "isEmpty", "", "Companion", "plugin-mv_release"})
public final class c extends com.tencent.mm.plugin.vlog.ui.thumb.a {
    public static final a AsB = new a((byte) 0);
    final com.tencent.mm.plugin.thumbplayer.d.a AsA;

    static {
        AppMethodBeat.i(257068);
        AppMethodBeat.o(257068);
    }

    public c(com.tencent.mm.plugin.thumbplayer.d.a aVar) {
        p.h(aVar, "mediaInfo");
        AppMethodBeat.i(257067);
        this.AsA = aVar;
        this.GOD = 0;
        this.GOE = this.AsA.pLQ;
        this.GOF = ((float) fEu()) / 1000.0f;
        AppMethodBeat.o(257067);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/thumb/TPTrackThumbInfo$Companion;", "", "()V", "countPerTime", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
