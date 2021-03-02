package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\t\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\b\u001a\u0014\u0010\n\u001a\u00020\f*\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u0007¨\u0006\u000e"}, hxF = {"createFinderLiveList", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "finderStreamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "tabType", "", SharePatchInfo.FINGER_PRINT, "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "streamCardTitle", "plugin-finder_release"})
public final class e {
    public static final bo a(bcu bcu, int i2) {
        AppMethodBeat.i(242632);
        p.h(bcu, "$this$toRVFeed");
        c.a aVar = c.vGN;
        LinkedList<FinderObject> linkedList = bcu.object;
        p.g(linkedList, "`object`");
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            T t2 = t;
            y yVar = y.vXH;
            p.g(t2, LocaleUtil.ITALIAN);
            if (y.r((FinderObject) t2)) {
                arrayList.add(t);
            }
        }
        y yVar2 = y.vXH;
        List<FinderItem> s = c.a.s(arrayList, y.LL(i2));
        ArrayList arrayList2 = new ArrayList(j.a(s, 10));
        for (FinderItem finderItem : s) {
            c.a aVar2 = c.vGN;
            arrayList2.add(c.a.s(finderItem));
        }
        LinkedList linkedList2 = new LinkedList(arrayList2);
        if (bcu.tQR == 1) {
            x xVar = new x(bcu);
            Log.i("Finder.HandleLayoutInfoInterceptor", "[updateLiveList] tabType:" + i2 + ", live list:" + xVar);
            x xVar2 = xVar;
            AppMethodBeat.o(242632);
            return xVar2;
        }
        k kVar = k.vfA;
        long j2 = bcu.id;
        y yVar3 = y.vXH;
        k.e(j2, y.LB(i2), bcu.sessionBuffer);
        ag agVar = new ag(bcu, bcu.tQR, linkedList2);
        AppMethodBeat.o(242632);
        return agVar;
    }

    public static final String a(bcu bcu) {
        AppMethodBeat.i(242633);
        p.h(bcu, "$this$print");
        String str = d.zs(bcu.id) + '_' + bcu.uOx + '_' + bcu.tQR + '_' + bcu.object.size() + '_' + bcu.LLO + '_' + bcu.IFO + '_' + bcu.LLT;
        AppMethodBeat.o(242633);
        return str;
    }
}
