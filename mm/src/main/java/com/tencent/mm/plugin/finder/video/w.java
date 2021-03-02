package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ(\u0010\u000f\u001a\u00020\u00072\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00070\u0011j\u0002`\u0013H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J2\u0010\u0016\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00070\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/ThumbFetcherWrapper;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "start", "", "thumbFetcher", "destroyCallback", "Lkotlin/Function0;", "", "(JLcom/tencent/mm/videocomposition/ITrackThumbFetcher;Lkotlin/jvm/functions/Function0;)V", "getDestroyCallback", "()Lkotlin/jvm/functions/Function0;", "getStart", "()J", "getThumbFetcher", "()Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "cancel", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "plugin-finder_release"})
public final class w implements g {
    final long start;
    private final g vNj;
    private final kotlin.g.a.a<x> wgu;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
    static final class a extends q implements m<Long, Bitmap, x> {
        final /* synthetic */ m nzd;
        final /* synthetic */ w wgv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(w wVar, m mVar) {
            super(2);
            this.wgv = wVar;
            this.nzd = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
            AppMethodBeat.i(254411);
            long longValue = l.longValue();
            this.nzd.invoke(Long.valueOf(longValue - this.wgv.start), bitmap);
            x xVar = x.SXb;
            AppMethodBeat.o(254411);
            return xVar;
        }
    }

    public w(long j2, g gVar, kotlin.g.a.a<x> aVar) {
        p.h(gVar, "thumbFetcher");
        p.h(aVar, "destroyCallback");
        AppMethodBeat.i(254416);
        this.start = j2;
        this.vNj = gVar;
        this.wgu = aVar;
        AppMethodBeat.o(254416);
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void setSize(int i2, int i3) {
        AppMethodBeat.i(254412);
        this.vNj.setSize(i2, i3);
        AppMethodBeat.o(254412);
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void b(List<Long> list, m<? super Long, ? super Bitmap, x> mVar) {
        AppMethodBeat.i(254413);
        p.h(list, "times");
        p.h(mVar, "callback");
        g gVar = this.vNj;
        List<Long> list2 = list;
        ArrayList arrayList = new ArrayList(j.a(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().longValue() + this.start));
        }
        gVar.b(arrayList, new a(this, mVar));
        AppMethodBeat.o(254413);
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void cancel(long j2) {
        AppMethodBeat.i(254414);
        this.vNj.cancel(this.start + j2);
        AppMethodBeat.o(254414);
    }

    @Override // com.tencent.mm.videocomposition.g
    public final void destroy() {
        AppMethodBeat.i(254415);
        this.vNj.destroy();
        this.wgu.invoke();
        AppMethodBeat.o(254415);
    }
}
