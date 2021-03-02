package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.videocomposition.c;
import com.tencent.mm.videocomposition.g;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoThumbFetcherFactory;", "", "()V", "getThumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "width", "", "height", "plugin-finder_release"})
public final class o {
    public static final o wfX = new o();

    static {
        AppMethodBeat.i(254381);
        AppMethodBeat.o(254381);
    }

    private o() {
    }

    public static g m(cjl cjl) {
        AppMethodBeat.i(254380);
        p.h(cjl, "media");
        acn acn = cjl.MfU;
        y yVar = y.vXH;
        if (y.h(cjl) || acn == null) {
            g gVar = new g(cjl);
            AppMethodBeat.o(254380);
            return gVar;
        }
        EffectManager effectManager = new EffectManager();
        ac d2 = i.d(acn, effectManager);
        c d3 = i.d(acn);
        d3.start();
        d2.O(d3);
        long playStart = d2.Gez.getPlayStart();
        c.a aVar = com.tencent.mm.videocomposition.c.RgU;
        w wVar = new w(playStart, c.a.b(d2.getComposition()), new a(d3, effectManager));
        AppMethodBeat.o(254380);
        return wVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.recordvideo.ui.editor.b.c wfY;
        final /* synthetic */ EffectManager wfZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(com.tencent.mm.plugin.recordvideo.ui.editor.b.c cVar, EffectManager effectManager) {
            super(0);
            this.wfY = cVar;
            this.wfZ = effectManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254379);
            this.wfY.destroy();
            this.wfZ.destroy();
            x xVar = x.SXb;
            AppMethodBeat.o(254379);
            return xVar;
        }
    }
}
