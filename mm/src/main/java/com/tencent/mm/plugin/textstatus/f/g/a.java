package com.tencent.mm.plugin.textstatus.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class a implements com.tencent.mm.view.recyclerview.a {
    public final com.tencent.mm.plugin.textstatus.f.f.a FYx;

    public a(com.tencent.mm.plugin.textstatus.f.f.a aVar) {
        p.h(aVar, "info");
        AppMethodBeat.i(216298);
        this.FYx = aVar;
        AppMethodBeat.o(216298);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(216297);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(216297);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 0;
    }
}
