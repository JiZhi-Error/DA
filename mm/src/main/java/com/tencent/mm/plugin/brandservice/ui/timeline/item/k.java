package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005¨\u0006\u0006"}, hxF = {"isExpire", "", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "toBizRecArticleCardLite", "Lcom/tencent/mm/protocal/protobuf/BizRecArticleCardLite;", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "plugin-brandservice_release"})
public final class k {
    public static final pl l(z zVar) {
        AppMethodBeat.i(195295);
        p.h(zVar, "$this$toBizRecArticleCardLite");
        pl plVar = new pl();
        plVar.KWz = zVar.field_msgId;
        plVar.KUh = zVar.NQn.style;
        plVar.KUi = zVar.NQn.event;
        plVar.KWA = zVar.NQn.dSJ;
        LinkedList<oq> linkedList = plVar.KUf;
        LinkedList<pj> linkedList2 = zVar.gAD().Nga.KUf;
        p.g(linkedList2, "info.tlRecCardWrapper.extraInfo.BizInfo");
        LinkedList<pj> linkedList3 = linkedList2;
        ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
        for (T t : linkedList3) {
            oq oqVar = new oq();
            oqVar.KSV = t.UserName;
            LinkedList<String> linkedList4 = oqVar.KUB;
            LinkedList<pi> linkedList5 = t.KWy;
            p.g(linkedList5, "info.AppMsg");
            LinkedList<pi> linkedList6 = linkedList5;
            ArrayList arrayList2 = new ArrayList(j.a(linkedList6, 10));
            Iterator<T> it = linkedList6.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().KSj);
            }
            linkedList4.addAll(arrayList2);
            arrayList.add(oqVar);
        }
        linkedList.addAll(arrayList);
        AppMethodBeat.o(195295);
        return plVar;
    }
}
