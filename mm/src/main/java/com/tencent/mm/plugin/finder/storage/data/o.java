package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.coe;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003*\b\u0012\u0004\u0012\u00020\u00060\u0003\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0003¨\u0006\t"}, hxF = {"toLongVideoServer", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMedia;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Ljava/util/LinkedList;", "toMegaMediaSpec", "Lcom/tencent/mm/protocal/protobuf/MegaVideoMediaSpec;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "toServer", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "plugin-finder_release"})
public final class o {
    public static final LinkedList<cod> aC(LinkedList<cjl> linkedList) {
        AppMethodBeat.i(252027);
        p.h(linkedList, "$this$toLongVideoServer");
        LinkedList<cod> linkedList2 = new LinkedList<>();
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add(d(it.next()));
        }
        AppMethodBeat.o(252027);
        return linkedList2;
    }

    public static final cod d(cjl cjl) {
        AppMethodBeat.i(252028);
        p.h(cjl, "$this$toLongVideoServer");
        cod cod = new cod();
        cod.url = cjl.url;
        cod.mediaType = cjl.mediaType;
        cod.thumbUrl = cjl.thumbUrl;
        cod.Mur = cjl.videoDuration;
        if (cjl.MoQ == 0) {
            cod.Mus = ((long) cjl.videoDuration) * 1000;
        } else {
            cod.Mus = cjl.MoQ;
        }
        cod.width = cjl.width;
        cod.height = cjl.height;
        cod.md5sum = cjl.md5sum;
        cod.fileSize = cjl.fileSize;
        cod.bitrate = cjl.bitrate;
        cod.decodeKey = cjl.decodeKey;
        cod.coverUrl = cjl.coverUrl;
        LinkedList<coe> linkedList = cod.spec;
        linkedList.clear();
        LinkedList<ayh> linkedList2 = cjl.spec;
        p.g(linkedList2, "spec");
        linkedList.addAll(aD(linkedList2));
        AppMethodBeat.o(252028);
        return cod;
    }

    private static coe b(ayh ayh) {
        AppMethodBeat.i(252029);
        p.h(ayh, "$this$toMegaMediaSpec");
        coe coe = new coe();
        coe.dVY = ayh.dVY;
        coe.LEL = ayh.LEL;
        coe.LGa = ayh.LGa;
        coe.uUI = ayh.uUI;
        AppMethodBeat.o(252029);
        return coe;
    }

    private static LinkedList<coe> aD(LinkedList<ayh> linkedList) {
        AppMethodBeat.i(252030);
        p.h(linkedList, "$this$toMegaMediaSpec");
        LinkedList<coe> linkedList2 = new LinkedList<>();
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add(b(it.next()));
        }
        AppMethodBeat.o(252030);
        return linkedList2;
    }
}
