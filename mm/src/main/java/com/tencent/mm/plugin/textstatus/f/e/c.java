package com.tencent.mm.plugin.textstatus.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.j.b;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/square/DoWhatItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "name", "", "iconItem", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;)V", "getIconItem", "()Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "getName", "()Ljava/lang/String;", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class c implements a {
    public final b.C1825b VdG;
    public final String name;

    public c(String str, b.C1825b bVar) {
        p.h(bVar, "iconItem");
        AppMethodBeat.i(258409);
        this.name = str;
        this.VdG = bVar;
        AppMethodBeat.o(258409);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(216242);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(216242);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 0;
    }
}
