package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setContact", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class p implements i, a {
    public FinderContact contact;

    public p(FinderContact finderContact) {
        kotlin.g.b.p.h(finderContact, "contact");
        AppMethodBeat.i(248725);
        this.contact = finderContact;
        AppMethodBeat.o(248725);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(248722);
        String str = this.contact.username;
        long hashCode = (long) (str != null ? str.hashCode() : 0);
        AppMethodBeat.o(248722);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248723);
        int hashCode = p.class.getName().hashCode();
        AppMethodBeat.o(248723);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(248724);
        kotlin.g.b.p.h(iVar, "obj");
        AppMethodBeat.o(248724);
        return 0;
    }
}
