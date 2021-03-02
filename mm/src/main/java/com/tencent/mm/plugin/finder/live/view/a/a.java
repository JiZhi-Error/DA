package com.tencent.mm.plugin.finder.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.fhd;
import com.tencent.mm.protocal.protobuf.fhe;
import com.tencent.mm.protocal.protobuf.fhq;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0005J\f\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\u0005J\n\u0010\b\u001a\u00020\t*\u00020\nJ\f\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u000bJ\n\u0010\b\u001a\u00020\f*\u00020\rJ\f\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/convert/DataUtil;", "", "()V", "promoteTitle", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "promoting", "", "toLocal", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowAdItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowItem;", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowProductItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "Lcom/tencent/mm/protocal/protobuf/PromotingInfo;", "plugin-finder_release"})
public final class a {
    public static final a UPD = new a();

    static {
        AppMethodBeat.i(261030);
        AppMethodBeat.o(261030);
    }

    private a() {
    }

    public static b a(fhd fhd) {
        AppMethodBeat.i(261026);
        p.h(fhd, "$this$toLocal");
        b bVar = new b(fhd);
        AppMethodBeat.o(261026);
        return bVar;
    }

    public static c b(axg axg) {
        AppMethodBeat.i(261027);
        p.h(axg, "$this$toLocal");
        c cVar = new c(axg);
        AppMethodBeat.o(261027);
        return cVar;
    }

    public static bo a(fhe fhe) {
        b bVar;
        c cVar;
        AppMethodBeat.i(261028);
        p.h(fhe, "$this$toLocal");
        b bVar2 = fhe.ybi;
        if (bVar2 == null) {
            AppMethodBeat.o(261028);
            return null;
        }
        p.g(bVar2, "this.ext_info ?: return null");
        switch (fhe.pWk) {
            case 0:
                axg axg = new axg();
                try {
                    axg.parseFrom(bVar2.toByteArray());
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                    axg = null;
                }
                axg axg2 = axg;
                if (axg2 != null) {
                    cVar = b(axg2);
                } else {
                    cVar = null;
                }
                c cVar2 = cVar;
                AppMethodBeat.o(261028);
                return cVar2;
            case 1:
                fhd fhd = new fhd();
                try {
                    fhd.parseFrom(bVar2.toByteArray());
                } catch (Exception e3) {
                    Log.printDebugStack("safeParser", "", e3);
                    fhd = null;
                }
                fhd fhd2 = fhd;
                if (fhd2 != null) {
                    bVar = a(fhd2);
                } else {
                    bVar = null;
                }
                b bVar3 = bVar;
                AppMethodBeat.o(261028);
                return bVar3;
            default:
                AppMethodBeat.o(261028);
                return null;
        }
    }

    public static bo a(fhq fhq) {
        b bVar;
        c cVar;
        AppMethodBeat.i(261029);
        p.h(fhq, "$this$toLocal");
        b bVar2 = fhq.ybi;
        if (bVar2 == null) {
            AppMethodBeat.o(261029);
            return null;
        }
        p.g(bVar2, "this.ext_info ?: return null");
        switch (fhq.Vjn) {
            case 0:
                axg axg = new axg();
                try {
                    axg.parseFrom(bVar2.toByteArray());
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                    axg = null;
                }
                axg axg2 = axg;
                if (axg2 != null) {
                    cVar = b(axg2);
                } else {
                    cVar = null;
                }
                c cVar2 = cVar;
                AppMethodBeat.o(261029);
                return cVar2;
            case 1:
                fhd fhd = new fhd();
                try {
                    fhd.parseFrom(bVar2.toByteArray());
                } catch (Exception e3) {
                    Log.printDebugStack("safeParser", "", e3);
                    fhd = null;
                }
                fhd fhd2 = fhd;
                if (fhd2 != null) {
                    bVar = a(fhd2);
                } else {
                    bVar = null;
                }
                b bVar3 = bVar;
                AppMethodBeat.o(261029);
                return bVar3;
            default:
                AppMethodBeat.o(261029);
                return null;
        }
    }

    public static String hTP() {
        return "";
    }
}
