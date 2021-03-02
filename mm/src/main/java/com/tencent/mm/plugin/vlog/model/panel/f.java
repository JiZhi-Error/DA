package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.a.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "()V", "getReportCount", "", "plugin-vlog_release"})
public final class f extends a {
    public f() {
        super(b.fCe());
        AppMethodBeat.i(190795);
        Log.i(b.TAG, "create: pag group");
        Iterator it = j.r((Collection<?>) b.GAT).iterator();
        while (it.hasNext()) {
            int nextInt = ((ab) it).nextInt();
            this.gXW.add(new e(String.valueOf(nextInt), "pag/text/" + ((String) b.GAT.get(nextInt)), "pag/text/" + ((String) b.GAS.get(nextInt))));
        }
        AppMethodBeat.o(190795);
    }

    @Override // com.tencent.mm.emoji.b.b.w
    public final int avo() {
        return 0;
    }
}
