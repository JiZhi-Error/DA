package com.tencent.mm.plugin.mv.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.e.b;
import com.tencent.mm.plugin.vlog.ui.thumb.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/thumb/TPThumbFetcherFactory;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "()V", "createFromTrackInfo", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "extra", "", "plugin-mv_release"})
public final class a implements g {
    @Override // com.tencent.mm.plugin.vlog.ui.thumb.g
    public final com.tencent.mm.videocomposition.g a(com.tencent.mm.plugin.vlog.ui.thumb.a aVar, Object obj) {
        AppMethodBeat.i(257042);
        p.h(aVar, "trackInfo");
        if (!(aVar instanceof c)) {
            IllegalStateException illegalStateException = new IllegalStateException("trackInfo is not TPTrackThumbInfo".toString());
            AppMethodBeat.o(257042);
            throw illegalStateException;
        } else if (!(obj instanceof b.C1836b)) {
            IllegalStateException illegalStateException2 = new IllegalStateException("not set resourceLoader".toString());
            AppMethodBeat.o(257042);
            throw illegalStateException2;
        } else {
            b bVar = new b((c) aVar, (b.C1836b) obj);
            AppMethodBeat.o(257042);
            return bVar;
        }
    }
}
