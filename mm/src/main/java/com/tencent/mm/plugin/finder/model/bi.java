package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.view.recyclerview.g;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderSearchData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "searchHint", "", "(I)V", "getSearchHint", "()I", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class bi extends g.b {
    public final int uOP = R.string.che;

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return 100;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248847);
        int hashCode = bi.class.getName().hashCode();
        AppMethodBeat.o(248847);
        return hashCode;
    }
}
