package com.tencent.mm.plugin.finder.event.base;

import com.tencent.mm.plugin.finder.life.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "()V", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "onRelease", "plugin-finder_release"})
public abstract class d extends a {
    public abstract void a(b bVar);

    public void onRelease() {
    }

    public boolean cZD() {
        return true;
    }

    public boolean a(c cVar, b bVar) {
        p.h(cVar, "dispatcher");
        p.h(bVar, "event");
        return true;
    }
}
