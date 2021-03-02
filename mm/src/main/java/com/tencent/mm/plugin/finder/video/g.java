package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.protocal.protobuf.cjl;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\r\u001a\u00020\u000e2\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u000e0\u0010j\u0002`\u0013H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J2\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00182\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoThumbFetcher;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "retriever", "Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "getRetriever", "()Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "setRetriever", "(Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;)V", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "plugin-finder_release"})
public final class g implements com.tencent.mm.videocomposition.g {
    private final cjl tHM;
    d wcR = new d();

    public g(cjl cjl) {
        p.h(cjl, "media");
        AppMethodBeat.i(254068);
        this.tHM = cjl;
        d dVar = this.wcR;
        if (dVar != null) {
            dVar.setDataSource(this.tHM.url);
            AppMethodBeat.o(254068);
            return;
        }
        AppMethodBeat.o(254068);
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void setSize(int i2, int i3) {
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void b(List<Long> list, m<? super Long, ? super Bitmap, x> mVar) {
        AppMethodBeat.i(254066);
        p.h(list, "times");
        p.h(mVar, "callback");
        com.tencent.mm.ac.d.b("FinderNormalVideoThumbFetcher_requestFrames", new a(this, list, mVar));
        AppMethodBeat.o(254066);
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void cancel(long j2) {
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void destroy() {
        AppMethodBeat.i(254067);
        d dVar = this.wcR;
        if (dVar != null) {
            dVar.release();
        }
        this.wcR = null;
        AppMethodBeat.o(254067);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ m nzd;
        final /* synthetic */ g wcS;
        final /* synthetic */ List wcT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar, List list, m mVar) {
            super(0);
            this.wcS = gVar;
            this.wcT = list;
            this.nzd = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254065);
            Bitmap bitmap = null;
            for (Number number : this.wcT) {
                long longValue = number.longValue();
                d dVar = this.wcS.wcR;
                Bitmap frameAtTime = dVar != null ? dVar.getFrameAtTime(1000 * longValue, 2) : null;
                if (frameAtTime == null) {
                    frameAtTime = bitmap;
                }
                this.nzd.invoke(Long.valueOf(longValue), frameAtTime);
                bitmap = frameAtTime;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254065);
            return xVar;
        }
    }
}
