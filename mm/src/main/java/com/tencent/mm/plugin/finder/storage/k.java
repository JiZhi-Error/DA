package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqv;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderFeedAttachInfoItem;", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;)V", "continueFlag", "getContinueFlag", "()Ljava/lang/Object;", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderFeedAttachListInfo;", "setInfo", "innerList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "objectList", "", "getObjectList", "()Ljava/util/List;", "showLeft", "", "getShowLeft", "()Z", "setShowLeft", "(Z)V", "wording", "", "getWording", "()Ljava/lang/String;", "plugin-finder_release"})
public final class k {
    public boolean vDG = true;
    private final List<BaseFinderFeed> vDH = new ArrayList();
    public aqv vDI;

    public k(aqv aqv) {
        AppMethodBeat.i(251726);
        this.vDI = aqv;
        AppMethodBeat.o(251726);
    }

    public final String getWording() {
        String str;
        AppMethodBeat.i(251724);
        aqv aqv = this.vDI;
        if (aqv == null || (str = aqv.dQx) == null) {
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            str = aAh.azQ().a(ar.a.USERINFO_FINDER_FAV_SIMILAR_WORDING_STRING_SYNC, "");
            if (str == null) {
                str = "";
            }
        }
        p.g(str, "info?.wording ?: (MMKern…G_STRING_SYNC, \"\") ?: \"\")");
        AppMethodBeat.o(251724);
        return str;
    }

    public final List<BaseFinderFeed> dxB() {
        ArrayList arrayList;
        ArrayList arrayList2;
        v vVar;
        AppMethodBeat.i(251725);
        aqv aqv = this.vDI;
        if (aqv != null && Util.isNullOrNil(this.vDH) && !Util.isNullOrNil(aqv.tbD)) {
            LinkedList<FinderObject> linkedList = aqv.tbD;
            if (linkedList != null) {
                ArrayList arrayList3 = new ArrayList();
                for (T t : linkedList) {
                    T t2 = t;
                    if ((t2 != null ? t2.objectDesc : null) != null) {
                        arrayList3.add(t);
                    }
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                ArrayList<FinderObject> arrayList4 = arrayList;
                ArrayList arrayList5 = new ArrayList(j.a(arrayList4, 10));
                for (FinderObject finderObject : arrayList4) {
                    FinderItem.a aVar = FinderItem.Companion;
                    p.g(finderObject, "feed");
                    FinderItem a2 = FinderItem.a.a(finderObject, 1);
                    c.a aVar2 = c.vGN;
                    arrayList5.add(c.a.s(a2));
                }
                arrayList2 = arrayList5;
            } else {
                arrayList2 = null;
            }
            List<BaseFinderFeed> list = this.vDH;
            if (arrayList2 != null) {
                vVar = arrayList2;
            } else {
                vVar = v.SXr;
            }
            list.addAll(vVar);
        }
        List<BaseFinderFeed> list2 = this.vDH;
        AppMethodBeat.o(251725);
        return list2;
    }
}
