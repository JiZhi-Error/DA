package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.protocal.protobuf.azm;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderMixFeedLogic;", "", "()V", "finderFeedToMixFeed", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObjectToMixFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "lbsToMixFeed", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "localToMixFeed", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "pack", "mixItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "plugin-finder_release"})
public final class w {
    public static final w tOM = new w();

    static {
        AppMethodBeat.i(243994);
        AppMethodBeat.o(243994);
    }

    private w() {
    }

    public static c a(azm azm) {
        int i2;
        AppMethodBeat.i(243992);
        p.h(azm, "lbsSection");
        ayr ayr = new ayr();
        z.a aVar = z.vEM;
        ayr.dataType = z.dxS();
        ayr.vEa = azm;
        z zVar = new z(ayr);
        int i3 = zVar.vEI.dataType;
        z.a aVar2 = z.vEM;
        if (i3 == z.dxS()) {
            azm azm2 = zVar.vEI.vEa;
            if (azm2 == null) {
                azm2 = new azm();
            }
            o oVar = new o(azm2);
            zVar.vEF = oVar;
            zVar.vEG = null;
            zVar.uNH = null;
            zVar.qcr = oVar.dxE().FVr + 1000;
            long longValue = ((Number) oVar.tON.getValue()).longValue();
            o oVar2 = zVar.vEF;
            if (oVar2 != null) {
                i2 = oVar2.hashCode();
            } else {
                i2 = 0;
            }
            zVar.vEH = ((long) i2) + longValue;
        } else {
            z.a aVar3 = z.vEM;
            if (i3 == z.dxT()) {
                zVar.vEF = null;
                FinderItem.a aVar4 = FinderItem.Companion;
                FinderObject finderObject = zVar.vEI.tuO;
                if (finderObject == null) {
                    finderObject = new FinderObject();
                }
                FinderItem a2 = FinderItem.a.a(finderObject, 0);
                zVar.vEG = a2;
                zVar.uNH = null;
                zVar.qcr = a2.getMediaType();
                zVar.vEH = a2.getId();
            } else {
                z.a aVar5 = z.vEM;
                if (i3 == z.dxU()) {
                    zVar.vEF = null;
                    zVar.vEG = null;
                    ays ays = zVar.vEI.LIR;
                    if (ays == null) {
                        ays = new ays();
                    }
                    aa aaVar = new aa(ays);
                    zVar.uNH = aaVar;
                    zVar.qcr = aaVar.vEN.LIS;
                    zVar.vEH = aaVar.getId();
                } else {
                    zVar.vEF = null;
                    zVar.vEG = null;
                    zVar.uNH = null;
                    zVar.qcr = 10000;
                    zVar.vEH = -1;
                }
            }
        }
        c cVar = new c(zVar);
        AppMethodBeat.o(243992);
        return cVar;
    }

    public static c m(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(243993);
        p.h(baseFinderFeed, "feed");
        ayr ayr = new ayr();
        z.a aVar = z.vEM;
        ayr.dataType = z.dxT();
        ayr.tuO = baseFinderFeed.feedObject.getFeedObject();
        z zVar = new z(ayr);
        zVar.vEF = null;
        FinderItem finderItem = baseFinderFeed.feedObject;
        zVar.vEG = finderItem;
        zVar.uNH = null;
        zVar.qcr = finderItem.getMediaType();
        zVar.vEH = finderItem.getId();
        c cVar = new c(zVar);
        cVar.uNI = baseFinderFeed;
        AppMethodBeat.o(243993);
        return cVar;
    }
}
