package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/PanelLifeCycle;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "lifeCycles", "Ljava/util/LinkedList;", "clear", "", "keep", "iLifeCycle", "plugin-emojisdk_release"})
public final class af implements b<a> {
    private final String TAG = "MicroMsg.PanelLifeCycle";
    private final LinkedList<a> gZd = new LinkedList<>();

    public af() {
        AppMethodBeat.i(199925);
        AppMethodBeat.o(199925);
    }

    @Override // com.tencent.mm.vending.e.b
    public final void keep(a aVar) {
        AppMethodBeat.i(199923);
        p.h(aVar, "iLifeCycle");
        Log.i(this.TAG, "keep: ".concat(String.valueOf(aVar)));
        if (!this.gZd.contains(aVar)) {
            this.gZd.add(aVar);
        }
        AppMethodBeat.o(199923);
    }

    public final void clear() {
        AppMethodBeat.i(199924);
        Log.i(this.TAG, "clear: ");
        Iterator<T> it = this.gZd.iterator();
        while (it.hasNext()) {
            it.next().dead();
        }
        this.gZd.clear();
        AppMethodBeat.o(199924);
    }
}
