package com.tencent.mm.plugin.finder.storage;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "(Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;)V", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "getLocalPb", "()Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "localType", "", "getLocalType", "()I", "wording", "", "getWording", "()Ljava/lang/String;", "isSame", "", FacebookRequestErrorClassification.KEY_OTHER, "plugin-finder_release"})
public final class aa {
    private final f tON = g.ah(new a(this));
    public final ays vEN;

    public final long getId() {
        AppMethodBeat.i(251815);
        long longValue = ((Number) this.tON.getValue()).longValue();
        AppMethodBeat.o(251815);
        return longValue;
    }

    public aa(ays ays) {
        p.h(ays, "localPb");
        AppMethodBeat.i(251817);
        this.vEN = ays;
        AppMethodBeat.o(251817);
    }

    public final String getWording() {
        String str = this.vEN.dQx;
        return str == null ? "" : str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Long> {
        final /* synthetic */ aa vEO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(aa aaVar) {
            super(0);
            this.vEO = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(251814);
            Long valueOf = Long.valueOf((long) MD5Util.getMD5String("FinderMixLocalItem_" + this.vEO.vEN.LIS + "_" + this.vEO.getWording()).hashCode());
            AppMethodBeat.o(251814);
            return valueOf;
        }
    }

    public final boolean a(aa aaVar) {
        AppMethodBeat.i(251816);
        p.h(aaVar, FacebookRequestErrorClassification.KEY_OTHER);
        if (this.vEN.LIS != aaVar.vEN.LIS || Util.isNullOrNil(getWording()) || !p.j(getWording(), aaVar.getWording())) {
            AppMethodBeat.o(251816);
            return false;
        }
        AppMethodBeat.o(251816);
        return true;
    }
}
