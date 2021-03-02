package com.tencent.mm.plugin.finder.event.base;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "", "threadTag", "", "(Ljava/lang/String;)V", "eventObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isRelease", "", "addObserver", "", "observer", "doEvent", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onRelease", "removeObserver", "Companion", "plugin-finder_release"})
public final class c {
    public static final a tHZ = new a((byte) 0);
    private volatile boolean ife;
    private final ConcurrentHashMap<d, Object> tHX;
    private final String tHY;

    static {
        AppMethodBeat.i(165556);
        AppMethodBeat.o(165556);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public /* synthetic */ c() {
        this("EventDispatcher");
        AppMethodBeat.i(165555);
        AppMethodBeat.o(165555);
    }

    public c(String str) {
        p.h(str, "threadTag");
        AppMethodBeat.i(243449);
        this.tHY = str;
        this.tHX = new ConcurrentHashMap<>();
        AppMethodBeat.o(243449);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(243447);
        p.h(bVar, "event");
        if (this.ife) {
            AppMethodBeat.o(243447);
            return;
        }
        for (Map.Entry<d, Object> entry : this.tHX.entrySet()) {
            if (entry.getKey().a(this, bVar)) {
                d key = entry.getKey();
                if (e.contains(key.ueV, key.ueU)) {
                    if (entry.getKey().cZD()) {
                        h.RTc.b(new b(entry, this, bVar), this.tHY);
                    } else {
                        entry.getKey().a(bVar);
                    }
                }
            }
        }
        AppMethodBeat.o(243447);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/event/base/EventDispatcher$doEvent$1$1"})
    static final class b implements Runnable {
        final /* synthetic */ Map.Entry tIa;
        final /* synthetic */ c tIb;
        final /* synthetic */ b tIc;

        b(Map.Entry entry, c cVar, b bVar) {
            this.tIa = entry;
            this.tIb = cVar;
            this.tIc = bVar;
        }

        public final void run() {
            AppMethodBeat.i(165552);
            ((d) this.tIa.getKey()).a(this.tIc);
            AppMethodBeat.o(165552);
        }
    }

    public final void a(d dVar) {
        AppMethodBeat.i(165553);
        p.h(dVar, "observer");
        this.tHX.put(dVar, new Object());
        AppMethodBeat.o(165553);
    }

    public final void b(d dVar) {
        AppMethodBeat.i(165554);
        if (dVar == null || !this.tHX.containsKey(dVar)) {
            AppMethodBeat.o(165554);
            return;
        }
        this.tHX.remove(dVar);
        AppMethodBeat.o(165554);
    }

    public final void onRelease() {
        AppMethodBeat.i(243448);
        this.ife = true;
        h.RTc.bqo("EventDispatcher");
        for (Map.Entry<d, Object> entry : this.tHX.entrySet()) {
            entry.getKey().onRelease();
        }
        this.tHX.clear();
        AppMethodBeat.o(243448);
    }
}
