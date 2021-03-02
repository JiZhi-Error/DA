package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderActivityInfoData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;)V", "getEventInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
public final class l implements a {
    public final aqk tqo;

    public l(aqk aqk) {
        p.h(aqk, "eventInfo");
        AppMethodBeat.i(248718);
        this.tqo = aqk;
        AppMethodBeat.o(248718);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return 0;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248717);
        int hashCode = l.class.getName().hashCode();
        AppMethodBeat.o(248717);
        return hashCode;
    }
}
