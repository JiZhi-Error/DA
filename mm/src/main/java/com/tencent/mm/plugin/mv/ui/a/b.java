package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "mv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "(Lcom/tencent/mm/plugin/mv/model/MusicMv;)V", "getMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "setMv", "getItemId", "", "getItemType", "", "hasMv", "", "plugin-mv_release"})
public final class b implements a {
    public e ArY;

    public b(e eVar) {
        p.h(eVar, "mv");
        AppMethodBeat.i(257002);
        this.ArY = eVar;
        AppMethodBeat.o(257002);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(257001);
        Long l = this.ArY.ApB;
        if (l == null) {
            l = this.ArY.ApE;
        }
        if (l != null) {
            long longValue = l.longValue();
            AppMethodBeat.o(257001);
            return longValue;
        }
        AppMethodBeat.o(257001);
        return 0;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 0;
    }
}
