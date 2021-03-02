package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderLiveTagData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "getTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class al implements bo {
    public final axk uOy;

    public al(axk axk) {
        p.h(axk, "tagInfo");
        AppMethodBeat.i(248775);
        this.uOy = axk;
        AppMethodBeat.o(248775);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(248772);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(248772);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248773);
        int hashCode = al.class.hashCode();
        AppMethodBeat.o(248773);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        i iVar2;
        AppMethodBeat.i(248774);
        p.h(iVar, "obj");
        if (!(iVar instanceof al)) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        al alVar = (al) iVar2;
        if (alVar == null) {
            AppMethodBeat.o(248774);
            return -1;
        } else if (Util.isEqual(alVar.uOy.LHS, this.uOy.LHS)) {
            AppMethodBeat.o(248774);
            return 0;
        } else {
            AppMethodBeat.o(248774);
            return -1;
        }
    }
}
