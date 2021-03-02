package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.cng;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fJ\b\u0010\u0010\u001a\u00020\nH\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/MegaVideoOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "remove", "id", "", "list", "Ljava/util/LinkedList;", "targetDataType", "plugin-finder_release"})
public final class p {
    public static final p vGB = new p();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
    public static final class a extends q implements b<aqq, Boolean> {
        final /* synthetic */ long pny;
        final /* synthetic */ z.a vGn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(long j2, z.a aVar) {
            super(1);
            this.pny = j2;
            this.vGn = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(aqq aqq) {
            ayj ayj;
            cng cng;
            AppMethodBeat.i(252031);
            aqq aqq2 = aqq;
            kotlin.g.b.p.h(aqq2, "item");
            int i2 = aqq2.dataType;
            p pVar = p.vGB;
            boolean z = i2 == 2 && (ayj = aqq2.LCG) != null && (cng = ayj.LIA) != null && cng.id == this.pny;
            if (z) {
                this.vGn.SYB = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(252031);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(252033);
        AppMethodBeat.o(252033);
    }

    private p() {
    }

    public static boolean a(long j2, LinkedList<aqq> linkedList) {
        AppMethodBeat.i(252032);
        kotlin.g.b.p.h(linkedList, "list");
        z.a aVar = new z.a();
        aVar.SYB = false;
        d.a((LinkedList) linkedList, (b) new a(j2, aVar));
        boolean z = aVar.SYB;
        AppMethodBeat.o(252032);
        return z;
    }
}
