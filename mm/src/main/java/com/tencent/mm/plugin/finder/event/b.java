package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/FinderPlayProgressObserver;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
public final class b extends d {
    private final String TAG = "FinderPlayProgressObserver";

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(243425);
        p.h(bVar, "ev");
        if (bVar instanceof c.a) {
            Log.i(this.TAG, "offset = " + ((c.a) bVar).offset + ",total = " + ((c.a) bVar).jcu);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.duz().value().intValue() == 1 && ((c.a) bVar).offset >= ((c.a) bVar).jcu - 1) {
                y yVar = y.vXH;
                y.a(((c.a) bVar).feedId, true, 2);
            }
        }
        AppMethodBeat.o(243425);
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(243426);
        p.h(cVar, "dispatcher");
        p.h(bVar, "event");
        if (!(bVar instanceof c.a) || ((c.a) bVar).type != 3) {
            AppMethodBeat.o(243426);
            return false;
        }
        AppMethodBeat.o(243426);
        return true;
    }
}
