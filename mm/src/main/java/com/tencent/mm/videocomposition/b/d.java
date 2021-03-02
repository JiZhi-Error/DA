package com.tencent.mm.videocomposition.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "", "tag", "", "(Ljava/lang/String;)V", "averageTime", "Lkotlin/Function0;", "", "getAverageTime", "()Lkotlin/jvm/functions/Function0;", "setAverageTime", "(Lkotlin/jvm/functions/Function0;)V", "getTag", "()Ljava/lang/String;", "thisStartTime", "<set-?>", "totalCount", "getTotalCount", "()J", "totalTime", "getTotalTime", "averageRenderCostLog", "end", "", "start", "video_composition_release"})
public final class d {
    public kotlin.g.a.a<Long> RhY = new a(this);
    long RhZ;
    public long dtZ;
    public long tTn;
    final String tag;

    public d(String str) {
        p.h(str, "tag");
        AppMethodBeat.i(216847);
        this.tag = str;
        AppMethodBeat.o(216847);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Long> {
        final /* synthetic */ d Ria;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar) {
            super(0);
            this.Ria = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            long j2 = 0;
            AppMethodBeat.i(216846);
            if (this.Ria.tTn > 0) {
                j2 = this.Ria.dtZ / this.Ria.tTn;
            }
            Long valueOf = Long.valueOf(j2);
            AppMethodBeat.o(216846);
            return valueOf;
        }
    }
}
