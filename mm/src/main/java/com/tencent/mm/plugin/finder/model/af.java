package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "(Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;)V", "getContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getItemId", "", "getItemType", "", "plugin-finder_release"})
public final class af implements a {
    public final g contact;

    public af(g gVar) {
        p.h(gVar, "contact");
        AppMethodBeat.i(248754);
        this.contact = gVar;
        AppMethodBeat.o(248754);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return 0;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248753);
        int hashCode = af.class.getName().hashCode();
        AppMethodBeat.o(248753);
        return hashCode;
    }
}
